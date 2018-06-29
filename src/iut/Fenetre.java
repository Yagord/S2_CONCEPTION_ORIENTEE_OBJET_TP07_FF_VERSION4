package iut;

/**
 * Fene^tre graphique, peut contenir des composants. liée à un écran, elle déclenche le dessin et les clics souris.
 */
public class Fenetre extends Composant {
	/**
	 * titre de la fenêtre
	 */
	private String titre="noname";
        private Police police; /**< police par défaut */
        
	/**
	 * couleur RVB du fond
	 */
	private int arrièrePlan=0xB8B8B8;
	

        public Fenetre(Ecran e)
        {
            super(null,0,0,e.getLargeur(),e.getHauteur());            
            e.setRoot(this);
            police = new Police("Arial",8,0);
        }
        
        @Override
	public void dessiner(Ecran e) {
            e.traceRectangle(getX(),getY(), getLargeur(), getHauteur(), 0x000000);
            e.traceRectangle(getX()+1,getY()+1, getLargeur()-2, getHauteur()-2, arrièrePlan);
            e.traceRectangle(getX()+1,30, getLargeur()-2, 40, 0x0080F0);
            e.traceTexte(getX()+5,  31, titre, police);
            
            super.dessiner(e);
	}

        @Override
	protected String nomType() {
		return "fenêtre";
	}

        @Override
	protected boolean peutAvoirComposants() {
		return true;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setArrièrePlan(int arrièrePlan) {
		this.arrièrePlan = arrièrePlan;
	}

	public int getArrièrePlan() {
		return this.arrièrePlan;
	}
}