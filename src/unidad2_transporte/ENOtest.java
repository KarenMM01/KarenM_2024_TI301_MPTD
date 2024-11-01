
package unidad2_transporte;

public class ENOtest extends ProblemasTransporteENO{
    public static void main(String[] args) {
        int[] Suministros = {15, 15};
        int[] Demanda = {10, 10, 10};
        int[][] Costos = {{4, 2, 4}, {12, 8, 4}};
        ProblemasTransporteENO NO = new ProblemasTransporteENO(2, 3) {};
        NO.setS(Suministros);
        NO.setD(Demanda);
        NO.setC(Costos);
        NO.resolverNO();
        NO.printEstado();
    }

    public ENOtest(int nSuministro, int nDemanda) {
        super(nSuministro, nDemanda);
    }
}
