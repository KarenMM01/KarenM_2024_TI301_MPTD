package U1_ProgramacionLineal;

public class GaussRTest {

    public static void main(String[] args) {
        double[][] pl = {{1.0, -60.0, -30.0, -20.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                         {0.0, 8.0, 6.0, 1.0, 1.0, 0.0, 0.0, 0.0, 48.0},
                         {0.0, 4.0, 2.0, 1.5, 0.0, 1.0, 0.0, 0.0, 20.0},
                         {0.0, 2.0, 2.5, 0.5, 0.0, 0.0, 1.0, 0.0, 8.0},
                         {0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 5.0}};
        GaussR gr = new GaussR(pl, 3, 1);
        //gr.resolver();
        gr.print();
    }
}
