package unidad2_transporte;
import java.util.Arrays;

public abstract class TransporteSFBVogel {

    private int nSuministro;  
    private int nDemanda;      
    private int[] S;           
    private int[] D;          
    private int[][] C;         
    private int[][] estado;    

    public TransporteSFBVogel(int nSuministro, int nDemanda) {
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

    public void calcularVogel() {
        int[] sumRestante = Arrays.copyOf(S, nSuministro);
        int[] demandaRestante = Arrays.copyOf(D, nDemanda); 

        while (!demandaSatisfecha(demandaRestante) && !sumSatisfecha(sumRestante)) {
            int[] penalizacionesFila = new int[nSuministro];
            int[] penalizacionesColumna = new int[nDemanda];

            for (int i = 0; i < nSuministro; i++) {
                if (sumRestante[i] > 0) {
                    int[] costosFiltrados = new int[nDemanda];
                    int contador = 0;
                    for (int j = 0; j < nDemanda; j++) {
                        if (demandaRestante[j] > 0) {
                            costosFiltrados[contador++] = C[i][j];
                        }
                    }
                    costosFiltrados = Arrays.copyOf(costosFiltrados, contador);
                    Arrays.sort(costosFiltrados);
                    penalizacionesFila[i] = (costosFiltrados.length > 1) ? 
                            (costosFiltrados[1] - costosFiltrados[0]) : Integer.MAX_VALUE;
                } else {
                    penalizacionesFila[i] = -1; 
                }
            }
            for (int j = 0; j < nDemanda; j++) {
                if (demandaRestante[j] > 0) {
                    int[] costosFiltrados = new int[nSuministro];
                    int contador = 0;
                    for (int i = 0; i < nSuministro; i++) {
                        if (sumRestante[i] > 0) {
                            costosFiltrados[contador++] = C[i][j];
                        }
                    }
                    costosFiltrados = Arrays.copyOf(costosFiltrados, contador);
                    Arrays.sort(costosFiltrados);
                    penalizacionesColumna[j] = (costosFiltrados.length > 1) ? 
                            (costosFiltrados[1] - costosFiltrados[0]) : Integer.MAX_VALUE;
                } else {
                    penalizacionesColumna[j] = -1; 
                }
            }

            int filaMaxima = -1, columnaMaxima = -1;
            int maxPenalizacion = -1;

            for (int i = 0; i < nSuministro; i++) {
                if (penalizacionesFila[i] > maxPenalizacion) {
                    maxPenalizacion = penalizacionesFila[i];
                    filaMaxima = i;
                }
            }
            for (int j = 0; j < nDemanda; j++) {
                if (penalizacionesColumna[j] > maxPenalizacion) {
                    maxPenalizacion = penalizacionesColumna[j];
                    columnaMaxima = j;
                }
            }

            if (filaMaxima != -1 && columnaMaxima != -1) {
                int cantidadAsignada = Math.min(sumRestante[filaMaxima], demandaRestante[columnaMaxima]);
                estado[filaMaxima][columnaMaxima] = cantidadAsignada; 
                sumRestante[filaMaxima] -= cantidadAsignada; 
                demandaRestante[columnaMaxima] -= cantidadAsignada; 
                if (demandaRestante[columnaMaxima] == 0) {
                    for (int i = 0; i < nSuministro; i++) {
                        C[i][columnaMaxima] = Integer.MAX_VALUE; 
                    }
                }
                if (sumRestante[filaMaxima] == 0) {
                    for (int j = 0; j < nDemanda; j++) {
                        C[filaMaxima][j] = Integer.MAX_VALUE; 
                    }
                }
            } else {
                break;
            }
        }
    }

    public boolean demandaSatisfecha(int[] demandaRestante) {
        for (int d : demandaRestante) {
            if (d > 0) return false; 
        }
        return true; 
    }

    public boolean sumSatisfecha(int[] ofertaRestante) {
        for (int o : ofertaRestante) {
            if (o > 0) return false;
        }
        return true;     }

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
