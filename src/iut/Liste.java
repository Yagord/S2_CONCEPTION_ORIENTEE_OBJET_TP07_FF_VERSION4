package iut;

/**
 * une liste possède un certain nombre de chaînes et sélectionne par clic une d'entre elles.
 */
public class Liste extends Composant {
    //<editor-fold defaultstate="collapsed" desc="Opérations fournies">
    
	/**
	 * tableau des chaînes contenues dans la liste
	 */
	private java.util.ArrayList<String> chaines = new java.util.ArrayList<>();
	/**
	 * indice de la chaîne sélectionnée (-1 si aucune)
	 */
	private int selection=-1;	
                     
        
        public Liste(Composant parent, int x, int y, int w, int h)
        {
            super(parent,x,y,w,h);
        }
    
        @Override
	protected String nomType() {
		return "liste";
	}
        	public void setSelection(int selection) {
		this.selection = selection;
	}

	public int getSelection() {
		return this.selection;
	}

	/**
	 * @return true si le composant peut recevoir des enfants
	 */
        @Override
	protected boolean peutAvoirComposants() {
		return false;
	}
    //</editor-fold>
        
    //<editor-fold defaultstate="expanded" desc="Travail à faire">
        /**
         * @author Chassagne
         * @param e 
         */
        @Override
	public void dessiner(Ecran e) {
            // indication : tracer une rectangle blanc à bord noir (la liste), calculer la hauteur de chaque chaine, parcourir les chaines et les tracer dans la liste
            e.traceRectangle(this.getX(), this.getY(), this.getLargeur(), this.getHauteur(), 16777215);
            e.traceLigne(this.getX(), this.getY(), this.getX() + this.getLargeur(), this.getY(), 000000000);
            e.traceLigne(this.getX() + this.getLargeur(), this.getY(), this.getX() + this.getLargeur(), this.getY() + this.getHauteur(), 000000000);
            e.traceLigne(this.getX(), this.getY() + this.getHauteur(), this.getX() + this.getLargeur(), this.getY() + this.getHauteur(), 000000000);
            e.traceLigne(this.getX(), this.getY(), this.getX(), this.getY() + this.getHauteur(), 000000000);
            super.dessiner(e);
            
            Police police = new Police("Arial",this.getHauteur()/3,0);
            
            for (int i = 0; i < this.chaines.size(); i++) {
                e.traceTexte(this.getX(), this.getY() + i*this.getHauteur()/this.chaines.size(), this.chaines.get(i), police);
            }
	}
        

	/**
         * @author Chassagne
	 * ajoute une chaine dans la liste
     * @param s
	 */
	public void ajoute(String s) {
		// indication : juste ajouter dans la liste
            this.chaines.add(s);
	}

	/**
         * @author Chassagne
	 * retire une chaîne de la liste
     * @param s
	 */
	public void retire(String s) {
		// indication : juste retirer
            this.chaines.remove(s);
	}

        /**
         * @author Chassagne
         * @param i l'indice de la chaine souhaitée
         * @return 
         */
        public String getItem(int i)
        {
            return this.getItem(i); // indication : simplement renvoyer la bonne chaine
        }

        /**
         * @author Chassagne
         * @param x
         * @param y 
         */        
        @Override
        public void clic(int x, int y) // sélectionne un item de liste
        {            
            // indication : sélectionner la chaine correspondant à la hauteur cliquée
           // int i = 
           int i = (this.getHauteur() - this.getY())/this.getHauteur()/this.chaines.size();
        }
    //</editor-fold>
}