import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.regex.Matcher;

public class PayPal extends AbstractBalance implements PaymentMethod{
    private String email;
    private String password;
    private int balance;
    
    public PayPal(String email, String password, int balance) {
        this.email = email;
        this.password = password;

        this.balance = balance; 
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public int getBalance() {
        return balance;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public boolean isValid() {

        //email
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
    
        //password
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);
    
        return (emailMatcher.matches() && passwordMatcher.matches());
    }


    @Override
    public String pay(int amount) {
        if(isValid()){
            balance -= amount;
            
            String message = "Total left in your card is: " + balance + "\nCheckout Return Value is: " + amount;
            JOptionPane.showMessageDialog(null, message);

            return ("Payment successful. Total: " + balance);
        }

        JOptionPane.showMessageDialog(null, "Wrong Credentials.");
        return "Payment unsucessful";
    }
    
}
