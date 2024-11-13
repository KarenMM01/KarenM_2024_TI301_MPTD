package controladores;

import ejemplo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import unidad2_transporte.ProblemasTransporteENO;

public class control {

    @FXML
    private TextField Demandatxtx;

    @FXML
    private TextField Suministrostxt;

    @FXML
    private Button botonAgre;

    @FXML
    private TextField cantDtxt;

    @FXML
    private TextField cantStxt;

    @FXML
    private TextField costostxt;

    @FXML
    private TextArea mostrar;

    @FXML
    private Button sigbtn;

    @FXML
    void agregar(ActionEvent event) {
        int filaDemanda = Integer.parseInt(cantDtxt.getText());
        int columnasSuministros = Integer.parseInt(cantStxt.getText());
        String DemandaString[] = Demandatxtx.getText().split(",");
        int [] Demanda = new int [DemandaString.length];
        
        for (int i = 0; i < DemandaString.length; i++) {
            Demanda[i] = Integer.parseInt(DemandaString[i].trim());
        }
        
        String SuministrosString[] = Suministrostxt.getText().split(",");
        int [] Suministros = new int [SuministrosString.length];
        
        for (int i = 0; i < SuministrosString.length; i++) {
            Suministros[i] = Integer.parseInt(SuministrosString[i].trim());
        }
        
        String costosString [] = new String[filaDemanda * columnasSuministros];
        int [][] costos = new int[filaDemanda][columnasSuministros];
        costosString = costostxt.getText().split(",");
        
        int lugar = 0;
        for (int i = 0; i < costos.length; i++) {
            for (int j = 0; j < costos[i].length; j++) {
                costos[i][j] = Integer.parseInt(costosString[lugar]);
                lugar++;
            }
        }
        
        ProblemasTransporteENO eqn = new ProblemasTransporteENO(columnasSuministros, filaDemanda);
        eqn.setC(costos);
        eqn.setD(Demanda);
        eqn.setS(Suministros);
        eqn.resolverNO();
        
        mostrar.setText(eqn.Resultado().toString());
    }

    @FXML
    void siguiente(ActionEvent event) {
        try {
            Main.showView("v1.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
