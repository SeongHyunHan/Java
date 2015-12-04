package finalproject_seonghyunhan;

import java.io.*;
import java.util.*;

public class Receipt {
    public void Receipt(){
        CustomerInformationController ci = new CustomerInformationController();
        SideDishnDrinkOrderController sd = new SideDishnDrinkOrderController();
        PizzaOrderController p = new PizzaOrderController();
        FXMLDocumentController login = new FXMLDocumentController();
        Order order = new Order();
        double taxes, totalPrice;
        
        Calendar orderTime = Calendar.getInstance();

        try{
            File folder = new File("Receipt");
            if(!folder.exists()){
                folder.mkdir();
            }
            File file = new File(folder, "ORDER"+ ci.orderN[0] + ci.orderN[1] 
                    + ci.orderN[2] + ".txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("       Pizza Sing Sang Song");
            bw.newLine();
            bw.newLine();
            bw.write(" Address: 1430 Trafalgar Road");
            bw.newLine();
            bw.write("          Oakville, Ontario L6H 2L1");
            bw.newLine();
            bw.write(" Phone Number: 905-845-9430");
            bw.newLine();
            bw.write(" Employee Name: " + login.eName);
            bw.newLine();
            bw.write(" Employee ID: " + login.eID);
            bw.newLine();
            bw.write("-----------------------------------------");
            bw.newLine();
            if(ci.orderOption){
                bw.write(" Order Option: Pick Up");
            }else{
                bw.write(" Order Option: Delivery");
            }
            bw.newLine();
            bw.write(" Customer Name: " + ci.customerName);
            bw.newLine();
            bw.write(" Customer Phone Number: " + ci.customerPhone);
            bw.newLine();
            if(ci.customerAChecked){
                bw.write(" Customer Address: " + ci.customerAddress);
                bw.newLine();
            }
            if(ci.customerEChecked){
                bw.write(" Custmer Email: " + ci.customerEmail);
                bw.newLine();
            }
            bw.write(" Order Time: " + orderTime.get(Calendar.YEAR) +"." +
                    (orderTime.get(Calendar.MONTH)+1) + "." + orderTime.get(Calendar.DAY_OF_MONTH) +
                    " " + orderTime.get(Calendar.HOUR_OF_DAY) + ":" +
                    orderTime.get(Calendar.MINUTE) +":" + orderTime.get(Calendar.SECOND));
            orderTime.add(Calendar.MINUTE, 30);
            bw.newLine();
            bw.write(" Complete Time: " + orderTime.get(Calendar.YEAR) +"." +
                    (orderTime.get(Calendar.MONTH)+1) + "." + orderTime.get(Calendar.DAY_OF_MONTH) +
                    " " + orderTime.get(Calendar.HOUR_OF_DAY) + ":" +
                    orderTime.get(Calendar.MINUTE) +":" + orderTime.get(Calendar.SECOND));
            bw.newLine();
            bw.write("=======================================");
            bw.newLine();
            bw.write(" Product             Qty        Price");
            bw.newLine();
            bw.write("=======================================");
            bw.newLine();
            if(p.countPizzaAdd != 0){
                for(int i=0; i < order.pizza.size(); i++){
                    bw.write("Pizza " + (i+1));
                    bw.newLine();
                    String onePizza = order.pizza.get(i);
                    String[] strValues = onePizza.split(",");
                    ArrayList<String> onePizzas = new ArrayList(Arrays.asList(strValues));
                    for(int j=0; j < onePizzas.size(); j++){
                        bw.write(" " + onePizzas.get(j));   
                        bw.newLine();
                    }
                    bw.write("                             ----------");
                    bw.newLine();
                    bw.write( "Pizza Price                    $ " 
                            + String.format("%.2f", order.onePPrice.get(i)));
                    bw.newLine();
                }
            }
            if(sd.sideDish == true){
                bw.write("Side Dish");
                bw.newLine();
                for(int i =0; i < order.sideDish.size(); i++){
                    bw.write(" " + order.sideDish.get(i) + "        " +
                            order.sideDishQuantityC.get(i) + "        $ " +
                            String.format("%.2f", order.sideDishEachPrice.get(i)));
                    bw.newLine();
                }
            }
            if(sd.beverage == true){
                bw.write("Beverage");
                bw.newLine();
                for(int i=0; i< order.beverage.size(); i++){
                    bw.write(" " + order.beverage.get(i) + "      " +
                            order.beverageQuantityC.get(i)+ "        $ " +
                            String.format("%.2f", order.beverageEachPrice.get(i)));
                    bw.newLine();
                }
            }
            bw.write("=======================================");
            bw.newLine();
            bw.write(" SubTotal                      $ " + 
                    String.format("%.2f", order.orderPrice));
            bw.newLine();
            taxes = order.orderPrice * 0.13;
            totalPrice = order.orderPrice + taxes;
            bw.write(" HST                           $  " + 
                    String.format("%.2f",taxes));
            bw.newLine();
            bw.write(" Total                         $ " +
                    String.format("%.2f", totalPrice));
            bw.close();
        }catch(IOException e){
        }
    }
    
   
}
