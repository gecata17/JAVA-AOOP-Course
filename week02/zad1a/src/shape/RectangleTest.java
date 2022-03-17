package shape;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10,8);
        System.out.printf("Width: %.2f\n",rectangle.getWidth() );
        rectangle.setHeight(7);
        System.out.printf("Height: %.2f\n",rectangle.getHeight() );
        System.out.printf("Color: %s\n",rectangle.getColor() );
        System.out.printf("Area: %.2f\n",rectangle.getArea());
        System.out.printf("Perimeter: %.2f\n",rectangle.getPerimeter());
    }
}
