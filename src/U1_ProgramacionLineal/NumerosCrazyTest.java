package U1_ProgramacionLineal;

public class NumerosCrazyTest {

    public static void main(String[] args) {
//        double []columna1={1,2,0,1,-3};
//        double []columna2 ={1,0,-6,8,-4};
//        double[] columna1 = {-1,1};
//        double[] columna2 = {1,1};
        
        double []columna1={1,-1, -2 -3};
        double []columna2 ={1,0,-6,8,-4};

        NumeroCrazy nu = new NumeroCrazy(columna1, columna2);
        System.out.println("Indice: " + nu.resolver());
        nu.print();
    }
}
