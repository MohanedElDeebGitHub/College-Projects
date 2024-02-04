import java.util.Date;

import javax.swing.JOptionPane;

public class CreditCard extends AbstractBalance implements PaymentMethod{
    private String holderName;
    private String cardNumber;
    private int cvv;
    private Date expiryDate;
    private int balance;

    public CreditCard(String holderName, String cardNumber, int cvv, Date expiryDate, int balance) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.balance = balance;
    }


    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    
    
    @Override
    public boolean isValid() {
        Date currentDate = new Date();
        return expiryDate.after(currentDate);
    }

    @Override
    public String pay(int amount) {
        if(isValid()){
            balance -= amount;

            String message = "Total left in your card is: " + balance + "\nCheckout Return Value is: " + amount;
            JOptionPane.showMessageDialog(null, message);

            return ("Payment successful. Total: " + balance);
        }

        JOptionPane.showMessageDialog(null, "Card already expired.");
        return "Payment unsucessful";
    }
}
