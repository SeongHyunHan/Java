package finalproject_seonghyunhan;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {
    public static ArrayList<String> pizza = new ArrayList();
    public static ArrayList<String> sideDish = new ArrayList();
    public static ArrayList<Integer> sideDishQuantity = new ArrayList
        (Arrays.asList(0,0,0,0,0,0));
    public static ArrayList<Integer> sideDishQuantityC = new ArrayList();
    public static ArrayList<Double> sideDishEachPrice = new ArrayList();
    public static ArrayList<String> beverage = new ArrayList();
    public static ArrayList<Integer> beverageQuantity = new ArrayList
        (Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
    public static ArrayList<Integer> beverageQuantityC = new ArrayList();
    public static ArrayList<Double> beverageEachPrice = new ArrayList();
    public static ArrayList<Double> onePPrice = new ArrayList();
    public static double orderPrice = 0;
    public static double onePizzaPrice;
    
    
    public void Order(){
    }
    
    public void setPizza(int size,int crust, ArrayList<Integer> toppings){
        
        String wholePizza = "";
        if(size == 0){
            wholePizza = "Small                          $ 5.00";
            orderPrice += 5.00;
            onePizzaPrice = 5.00;
        }else if(size == 1){
            wholePizza = "Medium                         $ 6.00";
            orderPrice += 6.00;
            onePizzaPrice = 6.00;
        }else if(size == 2){
            wholePizza = "Large                          $ 8.00";
            orderPrice += 8.00;
            onePizzaPrice = 8.00;
        }else{
            wholePizza = "X-Large                       $ 10.00";
            orderPrice += 10.00;
            onePizzaPrice = 10.00;
        }
        wholePizza += ",";
        if(crust == 0){
            wholePizza += "Plain                          $ 3.50";
            orderPrice += 3.50;
            onePizzaPrice += 3.50;
        }else if(crust == 1){
            wholePizza += "Whole-Wheat                    $ 4.00";
            orderPrice += 4.00;
            onePizzaPrice += 4.00;
        }else{
            wholePizza += "Stuffed Crust                  $ 5.00";
            orderPrice += 5.00;
            onePizzaPrice += 5.00;
        }
        if(toppings.get(0) != 0){
            wholePizza += ",";
            if(toppings.get(0) == 1){
                wholePizza += "Pepperoni Extra Left           $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(0) == 2){
                wholePizza += "Pepperoni Extra Right          $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(0) == 3){
                wholePizza += "Pepperoni Extra Whole          $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(0) == 4){
                wholePizza += "Pepperoni Left                 $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(0) == 5){
                wholePizza += "Pepperoni Right                $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else{
                wholePizza += "Pepperoni Whole                $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }
        }
        if(toppings.get(1) != 0){
            wholePizza += ",";
            if(toppings.get(1) == 1){
                wholePizza += "Sausage Extra Left             $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(1) == 2){
                wholePizza += "Sausage Extra Right            $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(1) == 3){
                wholePizza += "Sausage Extra Whole            $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(1) == 4){
                wholePizza += "Sausage Left                   $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(1) == 5){
                wholePizza += "Sausage Right                  $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else{
                wholePizza += "Sausage Whole                  $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }
        }
        if(toppings.get(2) != 0){
            wholePizza += ",";
            if(toppings.get(2) == 1){
                wholePizza += "Garlic Extra Left              $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(2) == 2){
                wholePizza += "Garlic Extra Right             $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(2) == 3){
                wholePizza += "Garlic Extra Whole             $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(2) == 4){
                wholePizza += "Garlic Left                    $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else if(toppings.get(2) == 5){
                wholePizza += "Garlic Right                   $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else{
                wholePizza += "Garlic Whole                   $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }
        }
        if(toppings.get(3) != 0){
            wholePizza += ",";
            if(toppings.get(3) == 1){
                wholePizza += "Pineapple Extra Left           $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(3) == 2){
                wholePizza += "Pineapple Extra Right          $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(3) == 3){
                wholePizza += "Pineapple Extra Whole          $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(3) == 4){
                wholePizza += "Pineapple Left                 $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else if(toppings.get(3) == 5){
                wholePizza += "Pineapple Right                $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else{
                wholePizza += "Pineapple Whole                $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }
        }
        if(toppings.get(4) != 0){
            wholePizza += ",";
            if(toppings.get(4) == 1){
                wholePizza += "Ham Extra Left                 $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(4) == 2){
                wholePizza += "Ham Extra Right                $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(4) == 3){
                wholePizza += "Ham Extra Whole                $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(4) == 4){
                wholePizza += "Ham Left                       $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(4) == 5){
                wholePizza += "Ham Right                      $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else{
                wholePizza += "Ham Whole                      $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }
        }
        if(toppings.get(5) != 0){
            wholePizza += ",";
            if(toppings.get(5) == 1){
                wholePizza += "Olive Extra Left               $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(5) == 2){
                wholePizza += "Olive Extra Right              $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(5) == 3){
                wholePizza += "Olive Extra Whole              $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(5) == 4){
                wholePizza += "Olive Left                     $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else if(toppings.get(5) == 5){
                wholePizza += "Olive Right                    $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else{
                wholePizza += "Olive Whole                    $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }
        }
        if(toppings.get(6) != 0){
            wholePizza += ",";
            if(toppings.get(6) == 1){
                wholePizza += "Mushroom Extra Left            $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(6) == 2){
                wholePizza += "Mushroom Extra Right           $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(6) == 3){
                wholePizza += "Mushroom Extra Whole           $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(6) == 4){
                wholePizza += "Mushroom Left                  $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else if(toppings.get(6) == 5){
                wholePizza += "Mushroom Right                 $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else{
                wholePizza += "Mushroom Whole                 $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }
        }
        if(toppings.get(7) != 0){
            wholePizza += ",";
            if(toppings.get(7) == 1){
                wholePizza += "Bacon Extra Left               $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(7) == 2){
                wholePizza += "Bacon Extra Right              $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(7) == 3){
                wholePizza += "Bacon Extra Whole              $ 2.00";
                orderPrice += 2.00;
                onePizzaPrice += 2.00;
            }else if(toppings.get(7) == 4){
                wholePizza += "Bacon Left                     $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(7) == 5){
                wholePizza += "Bacon Right                    $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else{
                wholePizza += "Bacon Whole                    $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }
        }
        if(toppings.get(8) != 0){
            wholePizza += ",";
            if(toppings.get(8) == 1){
                wholePizza += "Cheddar Cheese Extra Left      $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(8) == 2){
                wholePizza += "Cheddar Cheese Extra Right     $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(8) == 3){
                wholePizza += "Cheddar Cheese Extra Whole     $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(8) == 4){
                wholePizza += "Cheddar Cheese Left            $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else if(toppings.get(8) == 5){
                wholePizza += "Cheddar Cheese Right           $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else{
                wholePizza += "Cheddar Cheese Whole           $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }
        }
        if(toppings.get(9) != 0){
            wholePizza += ",";
            if(toppings.get(9) == 1){
                wholePizza += "Tomato Extra Left              $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(9) == 2){
                wholePizza += "Tomato Extra Right             $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(9) == 3){
                wholePizza += "Tomato Extra Whole             $ 1.50";
                orderPrice += 1.50;
                onePizzaPrice += 1.50;
            }else if(toppings.get(9) == 4){
                wholePizza += "Tomato Left                    $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else if(toppings.get(9) == 5){
                wholePizza += "Tomato Right                   $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }else{
                wholePizza += "Tomato Whole                   $ 1.00";
                orderPrice += 1.00;
                onePizzaPrice += 1.00;
            }
        }
        pizza.add(wholePizza);
        onePPrice.add(onePizzaPrice);
        
    }
    
    public void setSideDish(){
        if(sideDishQuantity.get(0) != 0){
            sideDish.add("Wings");
            orderPrice += 8.00 * sideDishQuantity.get(0);
            sideDishEachPrice.add(8.00 * sideDishQuantity.get(0));
        }
        if(sideDishQuantity.get(1) != 0){
            sideDish.add("Garlic Bread");
            orderPrice += 4.50 * sideDishQuantity.get(1);
            sideDishEachPrice.add(4.50 * sideDishQuantity.get(1));
        }
        if(sideDishQuantity.get(2) != 0){
            sideDish.add("Sandwiches");
            orderPrice += 7.50 * sideDishQuantity.get(2);
            sideDishEachPrice.add(7.50 * sideDishQuantity.get(2));
        }
        if(sideDishQuantity.get(3) != 0){
            sideDish.add("Pasta");
            orderPrice += 7.00 * sideDishQuantity.get(3);
            sideDishEachPrice.add(7.00 * sideDishQuantity.get(3));
        }
        if(sideDishQuantity.get(4) != 0){
            sideDish.add("Ceasar Salad");
            orderPrice += 5.00 * sideDishQuantity.get(4);
            sideDishEachPrice.add(5.00 * sideDishQuantity.get(4));
        }
        if(sideDishQuantity.get(5) != 0){
            sideDish.add("Poutines");
            orderPrice += 3.50 * sideDishQuantity.get(5);
            sideDishEachPrice.add(3.50 * sideDishQuantity.get(5));
        }
        for(int i=0; i< sideDishQuantity.size(); i++){
            if(sideDishQuantity.get(i) != 0){
                sideDishQuantityC.add(sideDishQuantity.get(i));
            }
        }
    }
    
    public void setBeverage(){
        if(beverageQuantity.get(0) != 0){
            beverage.add("Coca-Cola(Can)");
            orderPrice += 1.00 * beverageQuantity.get(0);
            beverageEachPrice.add(1.00 * beverageQuantity.get(0));
        }
        if(beverageQuantity.get(1) != 0){
            beverage.add("Coca-Cola(Bottle)");
            orderPrice += 2.50 * beverageQuantity.get(1);
            beverageEachPrice.add(2.50 * beverageQuantity.get(1));
        }
        if(beverageQuantity.get(2) != 0){
            beverage.add("Sprite(Can)");
            orderPrice += 1.00 * beverageQuantity.get(2);
            beverageEachPrice.add(1.00 * beverageQuantity.get(2));
        }
        if(beverageQuantity.get(3) != 0){
            beverage.add("Sprite(Bottle)");
            orderPrice += 2.50 * beverageQuantity.get(3);
            beverageEachPrice.add(2.50 * beverageQuantity.get(3));
        }
        if(beverageQuantity.get(4) != 0){
            beverage.add("Root Beer(Can)");
            orderPrice += 1.00 * beverageQuantity.get(4);
            beverageEachPrice.add(1.00 * beverageQuantity.get(4));
        }
        if(beverageQuantity.get(5) != 0){
            beverage.add("Root Beer(Bottle)");
            orderPrice += 2.50 * beverageQuantity.get(5);
            beverageEachPrice.add(2.50 * beverageQuantity.get(5));
        }
        if(beverageQuantity.get(6) != 0){
            beverage.add("Fanta(Can)");
            orderPrice += 1.00 * beverageQuantity.get(6);
            beverageEachPrice.add(1.00 * beverageQuantity.get(6));
        }
        if(beverageQuantity.get(7) != 0){
            beverage.add("Fanta(Bottle)");
            orderPrice += 2.50 * beverageQuantity.get(7);
            beverageEachPrice.add(2.50 * beverageQuantity.get(7));
        }
        if(beverageQuantity.get(8) != 0){
            beverage.add("Iced Tea(Can)");
            orderPrice += 1.00 * beverageQuantity.get(8);
            beverageEachPrice.add(1.00 * beverageQuantity.get(8));
        }
        if(beverageQuantity.get(9) != 0){
            beverage.add("Iced Tea(Bottle)");
            orderPrice += 2.50 * beverageQuantity.get(9);
            beverageEachPrice.add(2.50 * beverageQuantity.get(9));
        }
        if(beverageQuantity.get(10) != 0){
            beverage.add("Diet Coke(Can)");
            orderPrice += 1.00 * beverageQuantity.get(10);
            beverageEachPrice.add(1.00 * beverageQuantity.get(10));
        }
        if(beverageQuantity.get(11) != 0){
            beverage.add("Diet Coke(Bottle)");
            orderPrice += 2.50 * beverageQuantity.get(11);
            beverageEachPrice.add(2.50 * beverageQuantity.get(11));
        }
        for(int i=0; i< beverageQuantity.size(); i++){
            if(beverageQuantity.get(i) != 0){
                beverageQuantityC.add(beverageQuantity.get(i));
            }
        }
    }
    
    public void printReceipt(boolean print){
        Receipt receipt = new Receipt();
        receipt.Receipt();
    }
}
