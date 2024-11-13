
package unidad2_transporte;

public class ProblemasTransporteENO {

    private int nSuministro;
    private int nDemanda;
    private int[] S;
    private int[] D;
    private int[][] C;
    private int[][] estado;

    public ProblemasTransporteENO(int nSuministro, int nDemanda) {
        this.nSuministro = nSuministro;
        this.nDemanda = nDemanda;
        this.estado = new int[nSuministro][nDemanda];
    }

    public void setS(int[] S) {
        this.S = S;
    }

    public void setD(int[] D) {
        this.D = D;
    }

    public void setC(int[][] C) {
        this.C = C;
    }

    public void resolverNO() {
        int i = 0;
        int j = 0;
        while (i < nSuministro && j < nDemanda ) {
            if (S[i] < D[j]) {
                estado[i][j] = S[i];
                D[j] -= S[i];
                S[i] -= S[i];
                i++;
            } else {
                estado[i][j] = D[j];
                S[i] -= D[i];
                D[j] -= D[j];
                j++;
            }
        }
    }

//    public void printEstado() {
//        System.out.println("** Estado **");
//        for (int i = 0; i < estado.length; i++) {
//            for (int j = 0; j < estado[0].length; j++) {
//                System.out.printf("%3d ", estado [i][j]);
//            }
//            System.out.println();
//        }  
//    }
    public StringBuilder Resultado() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[0].length; j++) {
             str.append(estado[i][j]).append(" ");
            }
             str.append("\n");

        }
        return str;
    }
    
}

