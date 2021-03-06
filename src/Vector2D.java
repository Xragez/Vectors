
public class Vector2D implements IVector {
    private double x;
    private double y;

    Vector2D(Double[] args){
        x = args[0];
        y = args[1];
    }
    @Override
    public double abs() {
        return Math.sqrt(x*x + y*y);
    }

    @Override
    public Double[] getComponents() {
        return new Double[]{x, y};
    }

    @Override
    public Double[] getAngles() {
        double r = Math.sqrt(x*x + y*y);
        double phi = Math.atan(y/x);
        return new Double[]{r, phi};
    }

    @Override
    public double cdot(Double[] args) {
        return x*args[0] + y*args[1];
    }
}
