class Sirkel{
	private double radius;

	public Sirkel(double r){
		radius = r;
	}

	public double areal(){
		return Math.PI*radius*radius;
	}

	public double omkrets(){
		return 2*Math.PI*radius;
	}
}
