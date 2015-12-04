
package finalproject_seonghyunhan;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.util.*;


public class CustomerInformationController implements Initializable {

    public static String customerName;
    public static String customerAddress;
    public static String customerPhone;
    public static String customerEmail;
    public static boolean customerAChecked, customerEChecked, orderOption;
    public static int[] orderN = new int[3];
    public static String orderNumber;
    
    @FXML
    private RadioButton pickUp, delivery;
    
    @FXML
    private TextField fName, lName, phone, address, email;
    
    @FXML
    private Button reset, startorder;
    
    @FXML
    private Label alertOption,required1,required2,required3,required4;
    boolean customerAChekced;
    
    @FXML
    private void orderButtonAction(ActionEvent event) throws IOException{
        Parent pizzaOrder_parent=FXMLLoader.load(getClass().getResource("PizzaOrder.fxml"));
        Scene pizzaOrder_scene = new Scene(pizzaOrder_parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(pickUp.isSelected() || delivery.isSelected()){
            if(validation()){
                storeCustomerInfo();
                createOrderNumber();
                orderOption = pickUp.isSelected();
                stage.setScene(pizzaOrder_scene);
                stage.show();
            }else{
                clearField();
            }
        }else{
            alertOption.setVisible(true);
        }
    }
    @FXML
    private void deliveryAction(ActionEvent event){
        fName.setDisable(false);
        lName.setDisable(false);
        phone.setDisable(false);
        address.setDisable(false);
        email.setDisable(false);
        alertOption.setVisible(false);
        required4.setVisible(true);
    }
    
    @FXML
    private void pickUpAction(ActionEvent event){
        fName.setDisable(false);
        lName.setDisable(false);
        phone.setDisable(false);
        address.setDisable(false);
        email.setDisable(false);
        alertOption.setVisible(false);
        required4.setVisible(false);
    }
    
    @FXML
    private void resetButtonAction(ActionEvent event){
        fName.clear();
        lName.clear();
        phone.clear();
        address.clear();
        email.clear();
        pickUp.setSelected(false);
        delivery.setSelected(false);
        address.setDisable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup option = new ToggleGroup();
        pickUp.setToggleGroup(option);
        delivery.setToggleGroup(option);
        
    }    
    
    private boolean validation(){
        boolean validation = false;
        String value = "";
        int check = 0;
        if(value.equals(fName.getText())){
            fName.setStyle("-fx-border-color:red;");
        }else{
            check++;
            fName.setStyle("-fx-border-color:none;");
        }
        if(value.equals(lName.getText())){
            lName.setStyle("-fx-border-color:red;");
        }else{
            check++;
            lName.setStyle("-fx-border-color:none;");
        }
        if(value.equals(phone.getText())){
            phone.setStyle("-fx-border-color:red;");
        }else{
            check++;
            phone.setStyle("-fx-border-color:none;");
        }
        
        if(delivery.isSelected()){
            validation = false;
            if(value.equals(address.getText())){
               address.setStyle("-fx-border-color:red;");
            }else{
                check ++;    
                address.setStyle("-fx-border-color:none;");
            }
        }else{
            if(check == 3){
            validation = true;
            }
        }
        if(check == 4){
            validation = true;
        }
        return validation;

    }
    
    private void clearField(){
        fName.clear();
        lName.clear();
        phone.clear();
        address.clear();
        email.clear();
    }

    private void storeCustomerInfo() {
        customerName = fName.getText() + " " + lName.getText();
        customerPhone = phone.getText();
        if(!"".equals(address.getText())){
            customerAddress = address.getText();
            customerAChecked = true;
        }
        if(!"".equals(email.getText())){
            customerEmail = email.getText();
            customerEChecked = true;
        }
    }
    
    private void createOrderNumber(){
        Random random = new Random();
        for(int i = 0; i < orderN.length; i++){
            orderN[i] = random.nextInt(10);
        }
    }
}
