package iut;

/**
 * zone de saisie de texte. L'utilisateur doit cliquer dans la boite pour qu'elle ait le focus
 */
public class BoiteTexte extends Label {
    //<editor-fold defaultstate="collapsed" desc="Opérations fournies">
	/**
	 * indique si la boite possède ou non le focus clavier
	 */
	private boolean hasFocus=false;

        public BoiteTexte(Composant parent, int x, int y, int w, int h)
        {
            super(parent,x,y,w,h);
            
        }
           public boolean isHasFocus() {
        return hasFocus;
    }


        @Override
	protected String nomType() {
		return "boitetexte";
	}
        //</editor-fold>
        
        //<editor-fold defaultstate="expanded" desc="Travail à faire">
        
        /**
         * @author
         */
        @Override
        protected void clic()
        {
            // indication : récuperer l'ensemble des composants de même type et les priver de focus. Prendre le focus.
            Composant[] listeComposant = super.getComposants(this.nomType());
            for (int i = 0; i < listeComposant.length; i++) {
                //listeComposant[i].get
            }
        }
        
        /**
         * @author Chasssagne
         * @param e 
         */
         @Override
	public void dessiner(Ecran e) {
            // indication : tracer une rectangle blanc avec bord noir pour la zone de saisie, tracer l'ancêtre (pour le texte) et tracer le signalement du focus
            e.traceRectangle(this.getX(), this.getY(), this.getLargeur(), this.getHauteur(), 16777215);
            e.traceLigne(this.getX(), this.getY(), this.getX() + this.getLargeur(), this.getY(), 000000000);
            e.traceLigne(this.getX() + this.getLargeur(), this.getY(), this.getX() + this.getLargeur(), this.getY() + this.getHauteur(), 000000000);
            e.traceLigne(this.getX(), this.getY() + this.getHauteur(), this.getX() + this.getLargeur(), this.getY() + this.getHauteur(), 000000000);
            e.traceLigne(this.getX(), this.getY(), this.getX(), this.getY() + this.getHauteur(), 000000000);
            super.dessiner(e);
	}
        
        //</editor-fold>
}

