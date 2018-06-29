package iut;

/**
 * un bouton radio est une sorte de case à cocher qui "décoche" les autres boutons radio du même parent (groupe ou fenêtre). 
 */
public class BoutonRadio extends CaseCocher {

    //<editor-fold defaultstate="collapsed" desc="Opérations fournies">
    public BoutonRadio(Composant parent, int x, int y, int w, int h)
    {
        super(parent,x,y,w,h);
    }
    
        @Override
	protected String nomType() {
		return "boutons radio";
	}
        
    //</editor-fold>
        
    //<editor-fold defaultstate="expanded" desc="Travail à faire">
        
        /**
         * @author Chassagne
         * @param e 
         */
    @Override
	public void dessiner(Ecran e) {
            // indication : tracer le texte du bouton, puis un cercle blanc à coté contenant au besoin (état) un cercle noir
            e.traceTexte(this.getX(), this.getY(), this.getTexte(), this.getPolice());
            e.traceCercle(this.getX() - 20, this.getY() + this.getHauteur() - 20, 8, 16777215);
            if (this.isEtat()) {
                e.traceCercle(this.getX() - 20, this.getY() + this.getHauteur() - 20, 5, 000000000);
            }
	}

        /**
         * @author
         */
    @Override
        protected void clic()
        {
            // indication : cherche les BR du même parent et les décoche, coche celle-ci
            Composant[] listeComposant = this.getComposants("groupe");
            for (int i = 0; i < listeComposant.length; i++) {
                if ((listeComposant[i].getParent()).equals(this.getParent())) {
                    //listeComposant[i].getParent().setEtat(false);
                }
            }
            this.setEtat(true);

            
        }
       //</editor-fold>
}