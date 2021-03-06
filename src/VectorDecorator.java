public class VectorDecorator implements IVector {
    private IVector wrappee;

    VectorDecorator(IVector vector){
        this.wrappee = vector;
    }

    @Override
    public double abs() {
        return wrappee.abs();
    }

    @Override
    public Double[] getComponents() {
        return wrappee.getComponents();
    }

    @Override
    public Double[] getAngles() {
        return wrappee.getAngles();
    }

    @Override
    public double cdot(Double[] args) {
        return wrappee.cdot(args);
    }
}
