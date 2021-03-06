import java.util.ArrayList;

public interface IVector {
    double abs();
    Double[] getComponents();
    Double[] getAngles();
    double cdot(Double[] args);
}
