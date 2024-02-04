import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ShoppingCart {
    private ArrayList<Item> orderItems;

    public ShoppingCart(){
        this.orderItems = new ArrayList<>();
    }

    public void addItem(Item item){
        if(orderItems.size() < 10){
            orderItems.add(item);
        }else{
            JOptionPane.showMessageDialog(null, "Cart is full, proceeding to checkout.");
        }
    }

    public void removeItem(Item item){
        if(!orderItems.isEmpty() && orderItems.contains(item)){
            orderItems.remove(item);
        }
    }

    public double getTotalAmount(){
        double total = 0;

        for(Item i : orderItems){
            total += (i.getPrice() * i.getQuantity());
        }

        return total;
    }

    public String checkout(PaymentMethod paymentMethod){
        return paymentMethod.pay( (int) getTotalAmount());
    }
}
