import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddToArr {
    public Double[] addDoubleToArr(Double[] arr, double x){
        List<Double> arrlist = new ArrayList<Double>(Arrays.asList(arr));
        arrlist.add(x);
        Double[] r = new Double[arrlist.size()];
        arrlist.toArray(r);
        return r;
    }
}
