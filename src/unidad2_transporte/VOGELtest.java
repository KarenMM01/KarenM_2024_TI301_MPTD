package unidad2_transporte;

public class VOGELtest extends TransporteSFBVogel {

    public static void main(String[] args) {
        int[] Suministros = {10, 15};
        int[] Demanda = {15, 5, 5};
        int[][] Costos = {{6, 7, 8}, {15, 80, 78}};
        TransporteSFBVogel VO = new TransporteSFBVogel(2, 3) {};
        VO.setC(Costos);
        VO.setD(Demanda);
        VO.setS(Suministros);
        VO.calcularVogel();
        VO.printEstado();
    }

    public VOGELtest(int nSuministro, int nDemanda) {
        super(nSuministro, nDemanda);
    }
}
