class Square{
	private double sidelength;

	public Square(double sl){
		sidelength = sl;
	}

	public double area(){
		return sidelength*sidelength;
	}

	public double circumference(){
		return 4*sidelength;
	}
}
