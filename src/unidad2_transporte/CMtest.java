
package unidad2_transporte;

public class CMtest extends TrasnporteSfbCM{
    public static void main(String[] args) {
        int[] Suministros = {5, 10, 15};
        int[] Demanda = {12, 8, 6, 6};
        int[][] Costos = {{2, 3, 5, 6}, {2, 1, 3, 5}, {3, 8, 4, 6}};
        TrasnporteSfbCM CM = new TrasnporteSfbCM(3, 4) {};
        CM.setS(Suministros);
        CM.setD(Demanda);
        CM.setC(Costos);
        CM.calcularCM(Costos, Suministros, Demanda);
        CM.printEstado();
    }

    public CMtest(int nSuministro, int nDemanda) {
        super(nSuministro, nDemanda);
    }
}
