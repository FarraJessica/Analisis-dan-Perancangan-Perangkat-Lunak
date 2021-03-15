public class Cylinder extends Shape{
    private double height;
    private double radius;
    
    public Cylinder(double r, double h){
        super("Cylinder");
        height = h;
        radius = r;
    }


    @Override
    public double area() {
        return Math.PI*radius*radius*height;
    }
    
    @Override
    public String toString(){
        return super.toString() + " of radius " + radius +" and height "+ height;
    }
}
