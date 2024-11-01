package unidad2_transporte;

public abstract class TrasnporteSfbCM {

    private int nSuministro;
    private int nDemanda;
    private int[] S;
    private int[] D;
    private int[][] C;
    private int[][] estado;

    public TrasnporteSfbCM(int nSuministro, int nDemanda) {
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

    public void calcularCM(int[][] costos, int[] suministro, int[] demanda) {
        while (!demandaS(D) && !suministroS(S)) {
            int[] posMinimo = posicionMinima(costos, S, D);
            int i = posMinimo[0];
            int j = posMinimo[1];

            int cantidadAsignada = Math.min(S[i], D[j]);
            estado[i][j] = cantidadAsignada;
            S[i] -= cantidadAsignada;
            D[j] -= cantidadAsignada;
        }
    }

    public int[] posicionMinima(int[][] costos, int[] suministrosRestante, int[] demandaRestante) {
        int filas = costos.length;
        int columnas = costos[0].length;
        int minimoCosto = Integer.MAX_VALUE;
        int[] posicion = new int[2];

        for (int i = 0; i < filas; i++) {
            if (suministrosRestante[i] == 0) {
                continue;
            }
            for (int j = 0; j < columnas; j++) {
                if (demandaRestante[j] == 0) {
                    continue;
                }
                if (costos[i][j] < minimoCosto) {
                    minimoCosto = costos[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }

    public boolean demandaS(int[] demanda) {
        for (int d : demanda) {
            if (d > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean suministroS(int[] suministros) {
        for (int o : suministros) {
            if (o > 0) {
                return false;
            }
        }
        return true;
    }

    public void printEstado() {
        System.out.println("**** Estado ****");
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[0].length; j++) {
                System.out.printf("%3d ", estado[i][j]);
            }
            System.out.println();
        }
    }
}
