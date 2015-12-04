/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject_seonghyunhan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class SideDishnDrinkOrderController implements Initializable {
    
    public int sand, bread, pastas, ceasar, poutines, wing;
    public int colaCan, colaBottle, sodaCan, sodaBottle, rootCan, rootBottle,
            fanCan, fanBottle, teaCan, teaBottle, dietCan, dietBottle;
    public static boolean beverage, sideDish;
    
    @FXML
    private Button customerinfo, pizzaOrder, submitOrder, addSide, addBeverage,
            resetSide, resetDrink;
    
    @FXML
    private ComboBox<Integer> wings,garlicBread,sandwiches, pasta, salad, poutine, 
            cokeCan, spriteCan, rootBeerCan, fantaCan, icedTeaCan, dietcokeCan,
            cokeBottle,spriteBottle, rootBeerBottle, fantaBottle, icedTeaBottle,
            dietcokeBottle;
    @FXML
    private Label alertOrder;
    
    
    ObservableList<Integer> list =FXCollections.observableArrayList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    );
    
    @FXML
    private void addSide(ActionEvent event){
       storeSide();
       clearValue();
    }
    @FXML
    private void resetSide(ActionEvent event){
       clearValue();
    }  
    @FXML
    private void addBeverage(ActionEvent event){
        storeBeverage();
        clearValues();
    }
    @FXML
    private void resetBeverage(ActionEvent event){
        clearValues();
    }
    @FXML
    private void pizzaButtonAction(ActionEvent event) throws IOException{
        Parent pizzaOrder_parent=FXMLLoader.load(getClass().getResource("PizzaOrder.fxml"));
        Scene pizzaOrder_scene = new Scene(pizzaOrder_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(pizzaOrder_scene);
        app_stage.show();
    }
    @FXML
    private void orderButtonAction(ActionEvent event){
        Order order = new Order();
        if(checkOrder()){
            order.setSideDish();
            order.setBeverage();
            order.printReceipt(true);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wings.setItems(list);
        garlicBread.setItems(list);
        sandwiches.setItems(list);
        pasta.setItems(list);
        salad.setItems(list);
        poutine.setItems(list);
        cokeCan.setItems(list);
        spriteCan.setItems(list);
        rootBeerCan.setItems(list);
        fantaCan.setItems(list);
        icedTeaCan.setItems(list);
        dietcokeCan.setItems(list);
        cokeBottle.setItems(list);
        spriteBottle.setItems(list);
        rootBeerBottle.setItems(list);
        fantaBottle.setItems(list);
        icedTeaBottle.setItems(list);
        dietcokeBottle.setItems(list);
    }    

    private void storeSide() {
        Order order = new Order();
        if(!wings.getSelectionModel().isEmpty()){
            wing += wings.getValue(); 
            sideDish = true;
        }else{
            wing += 0;
        }
        if(!garlicBread.getSelectionModel().isEmpty()){
            bread += garlicBread.getValue(); 
            sideDish = true;
        }else {
            bread += 0;
        }
        if(!sandwiches.getSelectionModel().isEmpty()){
            sand += sandwiches.getValue();
            sideDish = true;
        }else{
            sand += 0;
        }
        if(!pasta.getSelectionModel().isEmpty()){
            pastas += pasta.getValue();     
            sideDish = true;
        }else{
            pastas += 0;
        }
        if(!salad.getSelectionModel().isEmpty()){
            ceasar += salad.getValue();
            sideDish = true;
        }else{
            ceasar += 0;
        }
        if(!poutine.getSelectionModel().isEmpty()){
            poutines += poutine.getValue();
            sideDish = true;
        }else{
            poutines += 0;
        }
        order.sideDishQuantity.set(0, wing);
        order.sideDishQuantity.set(1, bread);
        order.sideDishQuantity.set(2, sand);
        order.sideDishQuantity.set(3, pastas);
        order.sideDishQuantity.set(4, ceasar);
        order.sideDishQuantity.set(5, poutines);
    }

    private void clearValue() {
        wings.getSelectionModel().clearSelection();
        garlicBread.getSelectionModel().clearSelection();
        sandwiches.getSelectionModel().clearSelection();
        pasta.getSelectionModel().clearSelection();
        salad.getSelectionModel().clearSelection();
        poutine.getSelectionModel().clearSelection();
    }

    private void storeBeverage() {
        Order order = new Order();
        if(!cokeCan.getSelectionModel().isEmpty()){
            colaCan += cokeCan.getValue();
            beverage = true;
        }else{
            colaCan += 0;
        }
        if(!cokeBottle.getSelectionModel().isEmpty()){
            colaBottle += cokeBottle.getValue();
            beverage = true;
        }else{
            colaBottle += 0;
        }
        if(!spriteCan.getSelectionModel().isEmpty()){
            sodaCan += spriteCan.getValue();
            beverage = true;
        }else{
            sodaCan += 0;
        }
        if(!spriteBottle.getSelectionModel().isEmpty()){
            sodaBottle += spriteBottle.getValue();
            beverage = true;
        }else{
            sodaBottle += 0;
        }
        if(!rootBeerCan.getSelectionModel().isEmpty()){
            rootCan += rootBeerCan.getValue();
            beverage = true;
        }else{
            rootCan += 0;
        }
        if(!rootBeerBottle.getSelectionModel().isEmpty()){
            rootBottle += rootBeerBottle.getValue();
            beverage = true;
        }else{
            rootBottle += 0;
        }
        if(!fantaCan.getSelectionModel().isEmpty()){
            fanCan += fantaCan.getValue();
            beverage = true;
        }else{
            fanCan += 0;
        }
        if(!fantaBottle.getSelectionModel().isEmpty()){
            fanBottle += fantaBottle.getValue();
            beverage = true;
        }else{
            fanBottle += 0;
        }
        if(!icedTeaCan.getSelectionModel().isEmpty()){
            teaCan += icedTeaCan.getValue();
            beverage = true;
        }else{
            teaCan += 0;
        }
        if(!icedTeaBottle.getSelectionModel().isEmpty()){
            teaBottle += icedTeaBottle.getValue();
            beverage = true;
        }else{
            teaBottle += 0;
        }
        if(!dietcokeCan.getSelectionModel().isEmpty()){
            dietCan += dietcokeCan.getValue();
            beverage = true;
        }else{
            dietCan += 0;
        }
        if(!dietcokeBottle.getSelectionModel().isEmpty()){
            dietBottle += dietcokeBottle.getValue();
            beverage = true;
        }else{
            dietBottle += 0;
        }
        order.beverageQuantity.set(0, colaCan);
        order.beverageQuantity.set(1, colaBottle);
        order.beverageQuantity.set(2, sodaCan);
        order.beverageQuantity.set(3, sodaBottle);
        order.beverageQuantity.set(4, rootCan);
        order.beverageQuantity.set(5, rootBottle);
        order.beverageQuantity.set(6, fanCan);
        order.beverageQuantity.set(7, fanBottle);
        order.beverageQuantity.set(8, teaCan);
        order.beverageQuantity.set(9, teaBottle);
        order.beverageQuantity.set(10, dietCan);
        order.beverageQuantity.set(11, dietBottle);
    }

    private void clearValues() {
        cokeCan.getSelectionModel().clearSelection();
        cokeBottle.getSelectionModel().clearSelection();
        spriteCan.getSelectionModel().clearSelection();
        spriteBottle.getSelectionModel().clearSelection();
        rootBeerCan.getSelectionModel().clearSelection();
        rootBeerBottle.getSelectionModel().clearSelection();
        fantaCan.getSelectionModel().clearSelection();
        fantaBottle.getSelectionModel().clearSelection();
        icedTeaCan.getSelectionModel().clearSelection();
        icedTeaBottle.getSelectionModel().clearSelection();
        dietcokeCan.getSelectionModel().clearSelection();
        dietcokeBottle.getSelectionModel().clearSelection();
    }
    
    private boolean checkOrder() {
        boolean checked = false;
        PizzaOrderController p = new PizzaOrderController();
        if(p.countPizzaAdd != 0 || beverage == true || sideDish == true){
            alertOrder.setVisible(false);
            checked = true;
        }else{
            alertOrder.setVisible(true);
        }
        return checked;
    }
}
