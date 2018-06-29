package iut;

/**
 * le groupe est un composant pouvant contenir d'autres comspoants
 */
public class Groupe extends Composant {
	/**
	 * titre du groupe
	 */
	private String texte="group";
        
        public Groupe(Composant parent,int x, int y, int w, int h)
        {
            super(parent,x,y,w,h);
        }

        @Override
	protected boolean peutAvoirComposants() {
		return true;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return this.texte;
	}

        @Override
        public void clic(int x, int y)
        {
            super.clic(x, y);
        }
	/**
	 * @return nom du type exact
	 */
        @Override
	protected String nomType() {
		return "groupe";
	}
        
        @Override
        public void dessiner(Ecran e)
        {                        
            e.traceTexte(getX()+10, getY(), texte, new Police("Arial",8,0));
            int x = getX(), y = getY();
            e.traceLigne(x,y,x+getLargeur(),y,0);
            e.traceLigne(x+getLargeur(), y, x+getLargeur(), y+getHauteur(), 0);
            e.traceLigne(x+getLargeur(), y+getHauteur(), x, y+getHauteur(), 0);
            e.traceLigne(x, y+getHauteur(), x, y, y);
            super.dessiner(e);
        }
}