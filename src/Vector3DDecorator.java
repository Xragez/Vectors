public class Vector3DDecorator extends VectorDecorator {
    private double z;
    public Vector3DDecorator(IVector vector, double z){
        super(vector);
        this.z = z;
    }
    @Override
    public double abs() {
        double val = super.abs();
        return Math.sqrt(val*val+z*z);
    }

    @Override
    public Double[] getComponents() {
        AddToArr add = new AddToArr();
        return add.addDoubleToArr(super.getComponents(), z);
    }

    @Override
    public Double[] getAngles() {
        Double[] angles = super.getAngles();
        Double[] comp = super.getComponents();
        double r = Math.sqrt(comp[0]*comp[0] + comp[1]*comp[1] + z*z);
        double phi = angles[1];
        double theta = Math.acos(z/r);
        return new Double[]{r, phi, theta};
    }

    @Override
    public double cdot(Double[] args) {
        double ret = super.cdot(args);
        return ret + z*args[2];
    }
}
