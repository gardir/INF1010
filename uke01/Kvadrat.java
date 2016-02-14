class Kvadrat{
	private double sidelengde;

	public Kvadrat(double sl){
		sidelengde = sl;
	}

	public double area(){
		return sidelengde*sidelengde;
	}

	public double circumference(){
		return 4*sidelengde;
	}
}
