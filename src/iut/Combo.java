package iut;

/**
 * ue boite combo est une zone de saisie de texte associée avec une liste déroulante. La liste est placée juste sous la boite de texte. 
 */
public class Combo extends BoiteTexte {
    //<editor-fold defaultstate="collapsed" desc="Opérations fournies">
	/**
	 * indique si la liste est enroulée (invisible) ou non
	 */
	private boolean enroulée;	
	private Liste liste;

        public Combo(Composant parent, int x, int y, int w, int h)
        {
            super(parent,x,y,w,h);
            enroulée = true;
            liste = new Liste(parent,x,y+h,w,h+60);
            liste.hide();
        }
        
        @Override
	protected String nomType() {
		return "combo";
	}
    //</editor-fold>
        
    //<editor-fold defaultstate="expanded" desc="Travail à faire">
        /**
         * @author Chassagne
         * @param e 
         */
        @Override
	public void dessiner(Ecran e) {
            // indication : change l'état de la liste, si un item de la liste est sélectionné, fixe le texte de la zone. Fait dessiner l'ancêtre, et dessiner un petit rectangle avec une fleche à coté
            this.enroulée = false;
            super.dessiner(e);
	}

        /**
         * @author
         */
        @Override
        protected void clic()
        {
            // indication : change l'état de la liste et passe le clic à l'ancêtre
            
        }


	/**
         * @author Chassagne
	 * ajoute une chaine dans la liste
     * @param s
	 */
	public void ajoute(String s) {
		// indication : ajoute une chaine dans la liste contenue
            this.liste.ajoute(s);
	}

	/**
         * @author Chassagne
	 * retire une chaîne de la liste
     * @param s
	 */
	public void retire(String s) {
		// indication : retire une chaine de la liste contenue
            this.liste.retire(s);
	}
        
        /**
         * @author Chassagne
         * @param i l'indice fourni
         * @return la chaine contenue
         */
        public String getItem(int i)
        {
            return this.liste.getItem(i); // indication : fournir la chaine fournie par la liste
        }
     //</editor-fold>
}