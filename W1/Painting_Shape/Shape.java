public abstract class Shape {
    protected String shapeName;
    public abstract double area();
    
    public Shape(String shapeName){
        this.shapeName=shapeName;
    }
    @Override
    public String toString(){
        return "\nShape Name: "+shapeName;
    }
}
