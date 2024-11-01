
package U1_ProgramacionLineal;

public class GaussR {
    private double pl [][];
    private int r;
    private int c;

    public GaussR(double[][] pl, int r, int c) {
        this.pl = pl;
        this.r = r;
        this.c = c;
    }
    
    public void resolver(){
        
    }
    
    public void print(){
        for(int i = 0; i< pl.length; i++){
            for (int j = 0; j < pl[0].length; j++) {
                System.out.printf("%+06.3f  ", pl[i][j]);
            }
            System.out.println();
        }
    }
}
