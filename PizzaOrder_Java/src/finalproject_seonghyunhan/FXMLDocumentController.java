/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject_seonghyunhan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.regex.*;

/**
 *
 * @author Seong Hyun
 */
public class FXMLDocumentController implements Initializable {
    public static String eName, eID;
    @FXML
    private TextField employeename, employeeid;
    
    @FXML
    private Button login;
    
    @FXML
    private Label noMatch;
    
    @FXML
    private void buttonAction(ActionEvent event) throws IOException{
        Parent customerinfo_parent=FXMLLoader.load(getClass().getResource("CustomerInformation.fxml"));
        Scene customerinfo_scene = new Scene(customerinfo_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(validation()){
            eName = employeename.getText();
            eID = employeeid.getText();
            
            app_stage.setScene(customerinfo_scene);
            app_stage.show();
        }else{
            noMatch.setVisible(true);
            employeename.clear();
            employeeid.clear();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private boolean validation() throws IOException{
        boolean validate = false;
        File file = new File("login.dat");
        FileReader fr = new FileReader(file.getAbsoluteFile());
        BufferedReader br = new BufferedReader(fr);
        String check ="";
        Pattern pattern = Pattern.compile("Employee Name:(.*) Employee ID:(\\d*)");
        while((check = br.readLine()) != null){
            Matcher match = pattern.matcher(check);
            if(match.matches()){
                if(employeename.getText().equals(match.group(1)) && 
                        employeeid.getText().equals(match.group(2))){
                    return true;
                }
            }
      
    }
      return validate;
}
}

