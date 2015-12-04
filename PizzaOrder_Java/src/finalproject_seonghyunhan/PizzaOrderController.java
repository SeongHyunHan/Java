package finalproject_seonghyunhan;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class PizzaOrderController implements Initializable {
    public static int countPizzaAdd =0;
    public int size;
    public int crust;
    public ArrayList<Integer> toppings = new ArrayList();
    
    @FXML
    private Button customerInfo, sideDishnDrink, orderSubmit, addOrder;
    
    @FXML
    private RadioButton small, medium, large, xlarge, plain, wheat, stuffedcrust,
            pepWhole, pepLeft, pepRight, sausageLeft, sausageRight, sausageWhole,
            garLeft, garRight, garWhole, pineLeft, pineRight, pineWhole, hamLeft,
            hamRight, hamWhole, oliveLeft, oliveRight, oliveWhole, mushLeft,
            mushRight, mushWhole, baconLeft, baconRight, baconWhole, cheddarLeft,
            cheddarRight, cheddarWhole, tomatoLeft, tomatoRight, tomatoWhole;
    
    @FXML
    private CheckBox pepperoni, pepperoniEx, garlic, garlicEx, pineapple, 
            pineappleEx, ham, hamEx, olive, oliveEx, mushroom, mushroomEx, 
            bacon, baconEx, cheddar, cheddarEx, tomato, tomatoEx, sausage, sausageEx;
    
    @FXML
    private Label alertOrder, alertSize, alertCrust;
    
    @FXML
    private void sdButtonAction(ActionEvent event) throws IOException{
        Parent sidendrink_parent=FXMLLoader.load(getClass().getResource("SideDishnDrinkOrder.fxml"));
        Scene sidendrink_scene = new Scene(sidendrink_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(sidendrink_scene);
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
    
    @FXML
    private void addOrderButtonAction(ActionEvent event){
        Order order = new Order();
        alertOrder.setVisible(false);
        if(validateOrder()){
            countPizzaAdd++;
            storeSize();
            storeCrust();
            storeTopping();
            order.setPizza(size, crust, toppings);
            toppings.clear();
            clearField();
        }
    }
    
    @FXML
    private void pepperoniSelected(ActionEvent event){
        pepperoniSelect();
    }
    @FXML
    private void sausageSelected(ActionEvent event){
        sausageSelect();
    }
    @FXML
    private void garlicSelected(ActionEvent event){
        garlicSelect();
    }
    @FXML
    private void pinappleSelected(ActionEvent event){
        pineappleSelect();
    }
    @FXML
    private void hamSelected(ActionEvent event){
        hamSelect();
    }
    @FXML
    private void oliveSelected(ActionEvent event){
        oliveSelect();
    }
    @FXML
    private void mushroomSelected(ActionEvent event){
        mushroomSelect();
    }
    @FXML
    private void baconSelected(ActionEvent event){
        baconSelect();
    }
    @FXML
    private void cheddarSelected(ActionEvent event){
        cheddarSelect();
    }
    @FXML
    private void tomatoSelected(ActionEvent event){
        tomatoSelect();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ToggleGroup size = new ToggleGroup();
        small.setToggleGroup(size);
        medium.setToggleGroup(size);
        large.setToggleGroup(size);
        xlarge.setToggleGroup(size);
        
        ToggleGroup crust = new ToggleGroup();
        plain.setToggleGroup(crust);
        wheat.setToggleGroup(crust);
        stuffedcrust.setToggleGroup(crust);
        
        ToggleGroup pepPosition = new ToggleGroup();
        pepLeft.setToggleGroup(pepPosition);
        pepRight.setToggleGroup(pepPosition);
        pepWhole.setToggleGroup(pepPosition);
        
        ToggleGroup sausagePosition = new ToggleGroup();
        sausageLeft.setToggleGroup(sausagePosition);
        sausageRight.setToggleGroup(sausagePosition);
        sausageWhole.setToggleGroup(sausagePosition);
        
        ToggleGroup garlicPosition = new ToggleGroup();
        garLeft.setToggleGroup(garlicPosition);
        garRight.setToggleGroup(garlicPosition);
        garWhole.setToggleGroup(garlicPosition);
        
        ToggleGroup pinePosition = new ToggleGroup();
        pineLeft.setToggleGroup(pinePosition);
        pineRight.setToggleGroup(pinePosition);
        pineWhole.setToggleGroup(pinePosition);
        
        ToggleGroup hamPosition = new ToggleGroup();
        hamLeft.setToggleGroup(hamPosition);
        hamRight.setToggleGroup(hamPosition);
        hamWhole.setToggleGroup(hamPosition);
        
        ToggleGroup olivePosition = new ToggleGroup();
        oliveLeft.setToggleGroup(olivePosition);
        oliveRight.setToggleGroup(olivePosition);
        oliveWhole.setToggleGroup(olivePosition);
        
        ToggleGroup mushroomPosition = new ToggleGroup();
        mushLeft.setToggleGroup(mushroomPosition);
        mushRight.setToggleGroup(mushroomPosition);
        mushWhole.setToggleGroup(mushroomPosition);
        
        ToggleGroup baconPosition = new ToggleGroup();
        baconLeft.setToggleGroup(baconPosition);
        baconRight.setToggleGroup(baconPosition);
        baconWhole.setToggleGroup(baconPosition);
        
        ToggleGroup cheddarPosition = new ToggleGroup();
        cheddarLeft.setToggleGroup(cheddarPosition);
        cheddarRight.setToggleGroup(cheddarPosition);
        cheddarWhole.setToggleGroup(cheddarPosition);
        
        ToggleGroup tomatoPosition = new ToggleGroup();
        tomatoLeft.setToggleGroup(tomatoPosition);
        tomatoRight.setToggleGroup(tomatoPosition);
        tomatoWhole.setToggleGroup(tomatoPosition);
    }    
    
    private boolean validateOrder() {
        boolean validate = false;
        if(!small.isSelected() && !medium.isSelected() && !large.isSelected()
                && !xlarge.isSelected()){
            alertSize.setVisible(true);
        }else{
            alertSize.setVisible(false);
            validate = true;
        }
        if(!plain.isSelected() && !wheat.isSelected() && !stuffedcrust.isSelected()){
            alertCrust.setVisible(true);
            validate = false;
        }else{
            alertCrust.setVisible(false);
            validate = true;
        }
        return validate;
    }

    private boolean checkOrder() {
        SideDishnDrinkOrderController sd = new SideDishnDrinkOrderController();
        boolean checked = false;
        if(countPizzaAdd != 0 || sd.beverage == true || sd.sideDish == true){
            alertOrder.setVisible(false);
            checked = true;
        }else{
            alertOrder.setVisible(true);
        }
        return checked;
    }

    private void storeSize() {
        if(small.isSelected()){
            size = 0;
        }else if(medium.isSelected()){
            size = 1;
        }else if(large.isSelected()){
            size = 2;
        }else{
            size = 3;
        }
    }

    private void storeCrust() {
        if(plain.isSelected()){
            crust = 0;
        }else if(wheat.isSelected()){
            crust = 1;
        }else{
            crust = 2;
        }
    }

    private void storeTopping() {
        if(pepperoni.isSelected()){
            if(pepperoniEx.isSelected()){
                if(pepLeft.isSelected()){
                    toppings.add(1);
                }else if(pepRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(pepLeft.isSelected()){
                    toppings.add(4);
                }else if(pepRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(sausage.isSelected()){
            if(sausageEx.isSelected()){
                if(sausageLeft.isSelected()){
                    toppings.add(1);
                }else if(sausageRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(sausageLeft.isSelected()){
                    toppings.add(4);
                }else if(sausageRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(garlic.isSelected()){
            if(garlicEx.isSelected()){
                if(garLeft.isSelected()){
                    toppings.add(1);
                }else if(garRight.isSelected()){
                   toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(garLeft.isSelected()){
                    toppings.add(4);
                }else if(garRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(pineapple.isSelected()){
            if(pineappleEx.isSelected()){
                if(pineLeft.isSelected()){
                   toppings.add(1);
                }else if(pineRight.isSelected()){
                   toppings.add(2);
                }else{
                   toppings.add(3);
                }
            }else{
                if(pineLeft.isSelected()){
                   toppings.add(4);
                }else if(pineRight.isSelected()){
                   toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(ham.isSelected()){
            if(hamEx.isSelected()){
                if(hamLeft.isSelected()){
                    toppings.add(1);
                }else if(hamRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(hamLeft.isSelected()){
                    toppings.add(4);
                }else if(hamRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(olive.isSelected()){
            if(oliveEx.isSelected()){
                if(oliveLeft.isSelected()){
                    toppings.add(1);
                }else if(oliveRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(oliveLeft.isSelected()){
                    toppings.add(4);
                }else if(oliveRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(mushroom.isSelected()){
            if(mushroomEx.isSelected()){
                if(mushLeft.isSelected()){
                    toppings.add(1);
                }else if(mushRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(mushLeft.isSelected()){
                    toppings.add(4);
                }else if(mushRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(bacon.isSelected()){
            if(baconEx.isSelected()){
                if(baconLeft.isSelected()){
                    toppings.add(1);
                }else if(baconRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(baconLeft.isSelected()){
                    toppings.add(4);
                }else if(baconRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(cheddar.isSelected()){
            if(cheddarEx.isSelected()){
                if(cheddarLeft.isSelected()){
                    toppings.add(1);
                }else if(cheddarRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(cheddarLeft.isSelected()){
                    toppings.add(4);
                }else if(cheddarRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
        if(tomato.isSelected()){
            if(tomatoEx.isSelected()){
               if(tomatoLeft.isSelected()){
                    toppings.add(1);
                }else if(tomatoRight.isSelected()){
                    toppings.add(2);
                }else{
                    toppings.add(3);
                }
            }else{
                if(tomatoLeft.isSelected()){
                    toppings.add(4);
                }else if(tomatoRight.isSelected()){
                    toppings.add(5);
                }else{
                    toppings.add(6);
                }
            }
        }else{
            toppings.add(0);
        }
    }

    private void clearField() {
        small.setSelected(false);
        medium.setSelected(false);
        large.setSelected(false);
        xlarge.setSelected(false);
        plain.setSelected(false);
        wheat.setSelected(false);
        stuffedcrust.setSelected(false);
        pepperoni.setSelected(false);
        sausage.setSelected(false);
        garlic.setSelected(false);
        pineapple.setSelected(false);
        ham.setSelected(false);
        olive.setSelected(false);
        mushroom.setSelected(false);
        bacon.setSelected(false);
        cheddar.setSelected(false);
        tomato.setSelected(false);
        pepperoniSelect();
        sausageSelect();
        garlicSelect();
        pineappleSelect();
        hamSelect();
        oliveSelect();
        mushroomSelect();
        baconSelect();
        cheddarSelect();
        tomatoSelect();   
    }

    private void pepperoniSelect() {
        if(pepperoni.isSelected()){
            pepperoniEx.setDisable(false);
            pepLeft.setDisable(false);
            pepWhole.setDisable(false);
            pepWhole.setSelected(true);
            pepRight.setDisable(false);
        }else{
            pepperoniEx.setDisable(true);
            pepperoniEx.setSelected(false);
            pepLeft.setDisable(true);
            pepLeft.setSelected(false);
            pepWhole.setDisable(true);
            pepWhole.setSelected(false);
            pepRight.setDisable(true);
            pepRight.setSelected(false);
        }
    }

    private void sausageSelect() {
        if(sausage.isSelected()){
            sausageEx.setDisable(false);
            sausageLeft.setDisable(false);
            sausageWhole.setDisable(false);
            sausageWhole.setSelected(true);
            sausageRight.setDisable(false);
        }else{
            sausageEx.setDisable(true);
            sausageEx.setSelected(false);
            sausageLeft.setDisable(true);
            sausageLeft.setSelected(false);
            sausageWhole.setDisable(true);
            sausageWhole.setSelected(false);
            sausageRight.setDisable(true);
            sausageRight.setSelected(false);
        }
    }

    private void garlicSelect() {
        if(garlic.isSelected()){
            garlicEx.setDisable(false);
            garLeft.setDisable(false);
            garWhole.setDisable(false);
            garWhole.setSelected(true);
            garRight.setDisable(false);
        }else{
            garlicEx.setDisable(true);
            garlicEx.setSelected(false);
            garLeft.setDisable(true);
            garLeft.setSelected(false);
            garWhole.setDisable(true);
            garWhole.setSelected(false);
            garRight.setDisable(true);
            garRight.setSelected(false);
        }
    }

    private void pineappleSelect() {
        if(pineapple.isSelected()){
            pineappleEx.setDisable(false);
            pineLeft.setDisable(false);
            pineWhole.setDisable(false);
            pineWhole.setSelected(true);
            pineRight.setDisable(false);
        }else{
            pineappleEx.setDisable(true);
            pineappleEx.setSelected(false);
            pineLeft.setDisable(true);
            pineLeft.setSelected(false);
            pineWhole.setDisable(true);
            pineWhole.setSelected(false);
            pineRight.setDisable(true);
            pineRight.setSelected(false);
        }
    }

    private void hamSelect() {
        if(ham.isSelected()){
            hamEx.setDisable(false);
            hamLeft.setDisable(false);
            hamWhole.setDisable(false);
            hamWhole.setSelected(true);
            hamRight.setDisable(false);
        }else{
            hamEx.setDisable(true);
            hamEx.setSelected(false);
            hamLeft.setDisable(true);
            hamLeft.setSelected(false);
            hamWhole.setDisable(true);
            hamWhole.setSelected(false);
            hamRight.setDisable(true);
            hamRight.setSelected(false);
        }
    }

    private void oliveSelect() {
        if(olive.isSelected()){
            oliveEx.setDisable(false);
            oliveLeft.setDisable(false);
            oliveWhole.setDisable(false);
            oliveWhole.setSelected(true);
            oliveRight.setDisable(false);
        }else{
            oliveEx.setDisable(true);
            oliveEx.setSelected(false);
            oliveLeft.setDisable(true);
            oliveLeft.setSelected(false);
            oliveWhole.setDisable(true);
            oliveWhole.setSelected(false);
            oliveRight.setDisable(true);
            oliveRight.setSelected(false);
        }
    }

    private void mushroomSelect() {
        if(mushroom.isSelected()){
            mushroomEx.setDisable(false);
            mushLeft.setDisable(false);
            mushWhole.setDisable(false);
            mushWhole.setSelected(true);
            mushRight.setDisable(false);
        }else{
            mushroomEx.setDisable(true);
            mushroomEx.setSelected(false);
            mushLeft.setDisable(true);
            mushLeft.setSelected(false);
            mushWhole.setDisable(true);
            mushWhole.setSelected(false);
            mushRight.setDisable(true);
            mushRight.setSelected(false);
        }
    }

    private void baconSelect() {
        if(bacon.isSelected()){
            baconEx.setDisable(false);
            baconLeft.setDisable(false);
            baconWhole.setDisable(false);
            baconWhole.setSelected(true);
            baconRight.setDisable(false);
        }else{
            baconEx.setDisable(true);
            baconEx.setSelected(false);
            baconLeft.setDisable(true);
            baconLeft.setSelected(false);
            baconWhole.setDisable(true);
            baconWhole.setSelected(false);
            baconRight.setDisable(true);
            baconRight.setSelected(false);
        }
    }

    private void cheddarSelect() {
        if(cheddar.isSelected()){
            cheddarEx.setDisable(false);
            cheddarLeft.setDisable(false);
            cheddarWhole.setDisable(false);
            cheddarWhole.setSelected(true);
            cheddarRight.setDisable(false);
        }else{
            cheddarEx.setDisable(true);
            cheddarEx.setSelected(false);
            cheddarLeft.setDisable(true);
            cheddarLeft.setSelected(false);
            cheddarWhole.setDisable(true);
            cheddarWhole.setSelected(false);
            cheddarRight.setDisable(true);
            cheddarRight.setSelected(false);
        }
    }

    private void tomatoSelect() {
        if(tomato.isSelected()){
            tomatoEx.setDisable(false);
            tomatoLeft.setDisable(false);
            tomatoWhole.setDisable(false);
            tomatoWhole.setSelected(true);
            tomatoRight.setDisable(false);
        }else{
            tomatoEx.setDisable(true);
            tomatoEx.setSelected(false);
            tomatoLeft.setDisable(true);
            tomatoLeft.setSelected(false);
            tomatoWhole.setDisable(true);
            tomatoWhole.setSelected(false);
            tomatoRight.setDisable(true);
            tomatoRight.setSelected(false);
        }
    }
}
