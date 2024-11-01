package U1_ProgramacionLineal;

public class NumeroOptTest {

    public static void main(String[] args) {
        //int arreglo []={1, -3, -6, 9, 0, 1, -2};
        int arreglo[] = {1, 2, 3, 4};
        NumeroOpt no = new NumeroOpt(arreglo);
        System.out.println(no.operacion());
    }
}
