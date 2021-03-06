public class Vector3DAdapter implements IVector {
    private IVector vector;

    public Vector3DAdapter(IVector vector, double z){
        Double[] vect = vector.getComponents();
        AddToArr add = new AddToArr();
        this.vector = new Vector3DAdaptee(add.addDoubleToArr(vect, z));
    }

    @Override
    public double abs() {
        return vector.abs();
    }

    @Override
    public Double[] getComponents() {
        return vector.getComponents();
    }

    @Override
    public Double[] getAngles() {
        return vector.getAngles();
    }

    @Override
    public double cdot(Double[] args) {
        return vector.cdot(args);
    }

}
