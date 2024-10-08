package entities;

public abstract class Shape {
    private Color color;
    public Shape() {}
    public Shape(Color color) {
        this.color = color;
    }
    public abstract Double area();
}
