public class Vector3DAdaptee implements IVector {
    private double x;
    private double y;
    private double z;

    Vector3DAdaptee(Double[] args){
        x = args[0];
        y = args[1];
        z = args[2];
    }

    @Override
    public double abs() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    @Override
    public Double[] getComponents() {
        return new Double[]{x, y, z};
    }

    @Override
    public Double[] getAngles() {
        double r = Math.sqrt(x*x + y*y + z*z);
        double phi = Math.atan(y/x);
        double theta = Math.acos(z/r);
        return new Double[]{r, phi, theta};
    }

    @Override
    public double cdot(Double[] args) {
        return x*args[0] + y*args[1] + z*args[2];
    }
}
