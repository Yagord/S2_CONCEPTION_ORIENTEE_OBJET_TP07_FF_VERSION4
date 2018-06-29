package iut;

/**
 * Bouton cliquable.
 */
public class Bouton extends Label {        
    
    //<editor-fold defaultstate="collapsed" desc="Opérations fournies">
    public Bouton(Composant parent, int x, int y, int w, int h)
    {
        super(parent, x,y,w,h);        
    }
        


    @Override
	protected String nomType() {
		return "bouton";
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
     * @author Chasssagne
     * @param e 
     */
    @Override
    public void dessiner(Ecran e) {
        // indication : tracer un rectangle gris à bord noir, et tracer l'ancetre (pour le texte)
	e.traceRectangle(this.getX(), this.getY(), this.getLargeur(), this.getHauteur(), 6316128);
        e.traceLigne(this.getX(), this.getY(), this.getX() + this.getLargeur(), this.getY(), 000000000);
        e.traceLigne(this.getX() + this.getLargeur(), this.getY(), this.getX() + this.getLargeur(), this.getY() + this.getHauteur(), 000000000);
        e.traceLigne(this.getX(), this.getY() + this.getHauteur(), this.getX() + this.getLargeur(), this.getY() + this.getHauteur(), 000000000);
        e.traceLigne(this.getX(), this.getY(), this.getX(), this.getY() + this.getHauteur(), 000000000);
        super.dessiner(e);
    }
    //</editor-fold>
}