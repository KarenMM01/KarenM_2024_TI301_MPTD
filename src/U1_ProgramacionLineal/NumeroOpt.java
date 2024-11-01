
package U1_ProgramacionLineal;

public class NumeroOpt {
    private int []arreglo;

    public NumeroOpt(int[] arreglo) {
        this.arreglo = arreglo;
    }
    
    public int  operacion (){
        int indice = 0;
        double valor = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] < 0) {
                valor = arreglo[i];
                indice = i;
                break;
            }
            if(arreglo[i] > 0) return -1 ;
        }   
        return indice;    
    }
}
