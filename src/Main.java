import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void printMenu(){
        System.out.println("1. Wartość bezwzględną wektroa\n");
        System.out.println("2. Współrzędne biegunowe\n");
        System.out.println("3. Iloczyn skalarny\n");
        System.out.println("4. Składowe wektora\n");
        System.out.println("5. Koniec");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String vectVals = "";
        System.out.println("Wprowadź współrzędne wektora (2d lub 3d) oddzielone przecinkami:\n");
        vectVals = reader.readLine();
        String[] vectComp = vectVals.split(",", 3);
        boolean isVect3D = false;
        double x = Double.parseDouble(vectComp[0]);
        double y = Double.parseDouble(vectComp[1]);
        IVector vector = new Vector2D(new Double[]{x, y});
        Double z = null;
        if(vectComp.length == 3){
            z = Double.parseDouble(vectComp[2]);
            isVect3D = true;
            vector = new Vector3DDecorator(vector, z);
            //vector = new Vector3DAdapter(vector, z);
        }
        int choice = 0;
        boolean run = true;
        while (run){
            clearScreen();
            printMenu();
            choice = Integer.parseInt(reader.readLine());
            switch(choice){
                case 1:
                    System.out.println("Wartość bezwzględna wynosi: " + vector.abs());
                    break;
                case 2:

                    Double[] angles = vector.getAngles();
                    System.out.println("Współrzędne biegunowe:");
                    System.out.println("r = " + angles[0] );
                    System.out.println("phi = " + angles[1] );
                    if (isVect3D){
                        System.out.println("theta = " + angles[2]);
                    }
                    break;
                case 3:
                    System.out.println("Wprowadź współrzędne drugiego wektora:");
                    String[] vect2str = reader.readLine().split(",", 3);
                    Double[] vect2 = {};
                    AddToArr add = new AddToArr();
                    for(int i = 0; i < vect2str.length; i++){
                        vect2 = add.addDoubleToArr(vect2, Double.parseDouble(vect2str[i]));
                    }
                    System.out.println("Iloczyn skalarny wynosi: " + vector.cdot(vect2));
                    break;
                case 4:
                    System.out.println("Składowe wektora:");
                    Double[] comp = vector.getComponents();
                    for(int i = 0; i < comp.length; i++){
                        System.out.print(comp[i] + " ");
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    run = false;
            }
        }
    }
}
