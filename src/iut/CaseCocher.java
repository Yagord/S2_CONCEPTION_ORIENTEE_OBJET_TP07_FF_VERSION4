package iut;

/**
 * la case à cocher est un composant à deux états, l'utilisateur change l'état en cliquant dessus. 
 */
public class CaseCocher extends Label {
	/**
	 * état de la coche
	 */
	private boolean etat=false;	
                
        public CaseCocher(Composant parent, int x, int y, int w, int h)
        {
            super(parent,x,y,w,h);        
        }
        
        @Override
        protected void clic()
        {
            etat = !etat; // le clic change l'état !
            super.clic();
        }
        
        @Override
	public void dessiner(Ecran e) {
             super.dessiner(e);
             e.traceRectangle(getX()-20, getY(), 20, getHauteur(), 0xFFFFFF);
             if(etat)
             {
                 e.traceLigne(getX()-20, getY(), getX(), getY()+getHauteur(), 0);
                 e.traceLigne(getX(), getY(), getX()-20, getY()+getHauteur(), 0);
             }
	}

        @Override
	protected String nomType() {
		return "casecocher";
	}

	/**
	 * @return true si le composant peut recevoir des enfants
	 */
        @Override
	protected boolean peutAvoirComposants() {
		return false;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public boolean isEtat() {
		return this.etat;
	}
}