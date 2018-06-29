package iut;

import java.util.ArrayList;

/**
 * Composant générique
 */
public abstract class Composant {
    
    //<editor-fold defaultstate="collapsed" desc="opérations fournies">
    
	/**
	 * abssisse de départ
	 */
	private int x;
	/**
	 * ordonnée de départ
	 */
	private int y;
	/**
	 * largeur totale du composant
	 */
	private int largeur;
	/**
	 * hauteur totale du composant
	 */
	private int hauteur;
	/**
	 * un composant peut contenir un certain nombre d'autres composants
	 */
	private ArrayList<Composant> composants = new ArrayList<>();
	/**
	 * un composant peut contenir un certain nombre d'autres composants
	 */
	private Composant parent;
        
        private Action onClick=null;
        
        /**
         * Un composant peut être visible, ou non
         */
        private boolean visible=true;

        /**
         * Construit un composant
         * @param parent le composant parent
         * @param x l'abs de départ
         * @param y l'ord de départ
         * @param width la largeur du composant
         * @param height la hauteur du composant
         */
	public Composant(Composant parent, int x, int y, int width, int height) {
		this.parent = parent;
                if(parent!=null)
                {
                    parent.ajouteComposant(this);
                }
                this.x = x;
                this.y = y;
                this.largeur = width;
                this.hauteur = height;
	}
        
        public boolean isVisible(){return visible;}
        public void setVisible(boolean v){visible=v;}
        public void show(){visible=true;} /**< montre le composant */
        public void hide(){visible=false;} /**< cache le composant */

	/**
	 * @return nom du type exact
	 */
	protected abstract String nomType();

	/**
	 * @return true si le composant peut recevoir des enfants
	 */
	protected abstract boolean peutAvoirComposants();

        /**
         * Change l'action associée à l'évènement onClick
         * @param a l'action a exécuter lors du clic
         */
        public void setOnClick(Action a){
            onClick = a;
        }
	/**
	 * ajoute un composant enfant au compmosant
     * @param c
	 */
	protected void ajouteComposant(Composant c) {
		composants.add(c);
	}

        protected Composant getParent(){return parent;}
        
         /**
         * 
         * @return les composants enfants
         */
        protected Composant[] getComposants()
        {            
            return composants.toArray(new Composant[0]);
        }
        public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getHauteur() {
		return this.hauteur;
	}
        
        /**
	 * dessiner le composant
	 * @param e l'écran sur lequel dessiner
	 */
	public void dessiner(Ecran e) {
                for(Composant child : composants) // dessine tous les enfants du composants
                {
                    if(child.isVisible()) // seulement s'ils sont visible
                        child.dessiner(e);
                }
	}
        
        //</editor-fold>
        
    //<editor-fold defaultstate="expanded" desc="Travail à faire">
        
	/**
         * @author Chassagne
	 * cherche parmi les enfants celui qui contient le point précisé
     * @param x
     * @param y
	 * @return le composant contenant le point x,y, ou null si aucun
	 */
	protected Composant chercheComposant(int x, int y) {
            Composant c = null;
            // indication : parcourt les composants enfants et regarde si les coordonnées x,y sont contenues dedans
            boolean fini = false;
            int i = 0;
            c = this.composants.get(i);
            while(!fini) {
                if (i >= this.composants.size()-1) {
                    c = null;
                    fini = true;
                }
                else {
                    if ((c.nomType().equals("casecocher"))) {
                        if ((x<c.getX()) && (x>c.getX()-20) && (y>c.getY()) && (y<c.getY()+20)) {
                            System.out.println(x);
                            System.out.println(y);
                            System.out.println(c.getX());
                            System.out.println(c.getLargeur());
                            fini = true;
                        }
                        else {
                        i++;
                        c = this.composants.get(i);
                        }
                    }
                    else {
                        if ((x>c.getX()) && (x<c.getX()+c.getLargeur()) && (y>c.getY()) && (y<c.getY()+c.getHauteur())) {
                            System.out.println(x);
                            System.out.println(y);
                            System.out.println(c.getX());
                            System.out.println(c.getLargeur());
                            fini = true;
                        }
                        else {
                        i++;
                        c = this.composants.get(i);
                        }
                    }

                }
            }
            return c;
	}
       
        
        /**
         * @author Chassagne
         * @param type le nom du type désiré
         * @return les composants enfants du type choisi
         */
        protected Composant[] getComposants(String type)
        {            
            ArrayList<Composant> liste = new ArrayList<>();
         // indication : ajouter à la liste les composants dont le nom de type est identique à celui passé en paramètre
            for (int i = 0; i < this.composants.size(); i++) {
                if ((this.composants.get(i).nomType()).equals(type)) {
                    liste.add(this);
                }
            } 
            return liste.toArray(new Composant[0]);
        }
	

	/**
         * @author Chassagne
	 * effectue un clic de souris 
	 */
	protected void clic() {
		// indication : si une action est liée, on appelle sa méthode exécuter
            if (this.onClick != null) {
                this.onClick.executer();
            }
	}                
        
        /**
         * @author Chassagne
	 * Clic de souris, à redistribuer aux différents composants
     * @param x
     * @param y
	 */
	public void clic(int x, int y) {
            // indication : si le composant peut avoir des enfants, on cherche un composant contenant x,y : s'il existe on appelle sa fontion clic(x,y). Si le composant ne peut pas avoir d'enfants, on appelle clic()
            if (this.peutAvoirComposants()) {
                Composant composantEnfant = this.chercheComposant(x, y);
                if (composantEnfant != null) {
                    composantEnfant.clic(x, y);
                }
            }
            else {
                this.clic();
            }
	}
     //</editor-fold>
}