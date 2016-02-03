class Square implements Shape, Comparable<Square>{
    private double sidelength;

    public Square(double sl){
        sidelength = sl;
    }
    
    public double area(){
        return sidelength*sidelength;
    }
    
    public double perimeter(){
        return 4*sidelength;
    }

    /*
      a.compareTo(b) > 0: a storre enn b
      a.compareTo(b) == 0: a er like stor som b
      a.compareTo(b) < 0: a er mindre enn b
     */
    public int compareTo(Square s){
        double compare = area() - s.area();
        if(compare > 0){
            return 1;
        }else if(compare < 0){
            return -1;
        }else{
            return 0;
        }
    }
}