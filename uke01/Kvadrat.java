class Kvadrat{
	private double sidelengde;

	public Kvadrat(double sl){
		sidelengde = sl;
	}

	public double areal(){
		return sidelengde*sidelengde;
	}

	public double omkrets(){
		return 4*sidelengde;
	}
}
