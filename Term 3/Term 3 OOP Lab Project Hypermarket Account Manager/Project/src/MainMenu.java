import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MainMenu {
    private ShoppingCart cart;
    public MainMenu(ShoppingCart cart){
        this.cart = cart;
    }

    public void MainMenuInitialize(){
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 4));

        frame.add(new JLabel("Please, select a product:"));
        frame.add(new JLabel("Pizza, $40"));
        frame.add(new JLabel("Cheeseburger, $20"));
        frame.add(new JLabel("Coffee, $5"));
        frame.add(new JLabel("Soda, $4"));
        frame.add(new JLabel("Water, $2"));


        JTextField itemNameField = new JTextField("Enter item name");
        itemNameField.setPreferredSize(new Dimension(200, 40));
        itemNameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemNameField.setText("");
            }
        });

        JTextField itemQuantityField = new JTextField("Enter quantity");
        itemQuantityField.setPreferredSize(new Dimension(200, 40));
        itemQuantityField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemQuantityField.setText("");
            }
        });

        JTextField itemPriceField = new JTextField("Enter item price");
        itemPriceField.setPreferredSize(new Dimension(200, 40));
        itemPriceField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemPriceField.setText("");
            }
        });

        JButton submitButton = new JButton("OK");
        submitButton.addActionListener(e -> {
            String itemName = itemNameField.getText();
            int itemQuantity = Integer.parseInt(itemQuantityField.getText());
            Double itemPrice = Double.parseDouble(itemPriceField.getText());

            
            Item item = new Item(itemName, itemQuantity, itemPrice);
            cart.addItem(item);

            CheckOutMessage();
            frame.dispose();
        });


        frame.add(itemNameField);
        frame.add(itemQuantityField);
        frame.add(itemPriceField);
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);
        
    }

    private void CheckOutMessage(){
        int response = JOptionPane.showConfirmDialog(null, "Proceed to checkout?", "Checkout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response != JOptionPane.YES_OPTION) {
            MainMenuInitialize();
        }else {
            CheckoutInitiate();
        }
    }

    public void CheckoutInitiate(){
        Object[] options = {"PayPal", "CreditCard"};
        int choice = JOptionPane.showOptionDialog(null, "Choose a payment method", "Payment", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String chosenOption;
        if (choice == 0) {
            PayPalMenu();
        } else if (choice == 1) {
            CreditCardMenu();
        } else {
            chosenOption = "No option chosen";
        }
    }

    // PAYPAL
    private void PayPalMenu(){
        JFrame frame = new JFrame("PayPal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 4));

        JTextField emailField = new JTextField("Enter your E-Mail");
        emailField.setPreferredSize(new Dimension(200, 40));
        emailField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                emailField.setText("");
            }
        });

        JTextField passwordField = new JTextField("Enter Password");
        passwordField.setPreferredSize(new Dimension(200, 40));
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                passwordField.setText("");
            }
        });

        JTextField balanceField = new JTextField("Enter Balance");
        balanceField.setPreferredSize(new Dimension(200, 40));
        balanceField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                balanceField.setText("");
            }
        });

        JButton submitButton = new JButton("OK");
        submitButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            int balance = Integer.parseInt(balanceField.getText());
            
            PayPal paypal = new PayPal(email, password, balance);
            CheckoutFinish(paypal);
            frame.dispose();
        });


        frame.add(emailField);
        frame.add(passwordField);
        frame.add(balanceField);
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);
    }


    // CREDIT CARD
    private void CreditCardMenu(){
        JFrame frame = new JFrame("CreditCard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 4));

        JTextField nameField = new JTextField("Enter your Name");
        nameField.setPreferredSize(new Dimension(200, 40));
        nameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameField.setText("");
            }
        });

        JTextField cardNumberField = new JTextField("Enter your Card Number");
        cardNumberField.setPreferredSize(new Dimension(200, 40));
        cardNumberField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardNumberField.setText("");
            }
        });

        JTextField cvvField = new JTextField("Enter your CVV");
        cvvField.setPreferredSize(new Dimension(200, 40));
        cvvField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cvvField.setText("");
            }
        });

        JTextField expiryDateMonth = new JTextField("Enter your Card's Expiry Date (month)");
        expiryDateMonth.setPreferredSize(new Dimension(200, 40));
        expiryDateMonth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                expiryDateMonth.setText("");
            }
        });

        JTextField expiryDateDay = new JTextField("Enter your Card's Expiry Date (day)");
        expiryDateDay.setPreferredSize(new Dimension(200, 40));
        expiryDateDay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                expiryDateDay.setText("");
            }
        });

        JTextField expiryDateYear = new JTextField("Enter your Card's Expiry Date (year)");
        expiryDateYear.setPreferredSize(new Dimension(200, 40));
        expiryDateYear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                expiryDateYear.setText("");
            }
        });

        JTextField balanceField = new JTextField("Enter Balance");
        balanceField.setPreferredSize(new Dimension(200, 40));
        balanceField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                balanceField.setText("");
            }
        });

        JButton submitButton = new JButton("OK");
        submitButton.addActionListener(e -> {
            String holderName = nameField.getText();
            String cardNumber = cardNumberField.getText();
            int cvv = Integer.parseInt(cvvField.getText());

            int day = Integer.parseInt(expiryDateDay.getText());
            int month = Integer.parseInt(expiryDateMonth.getText());
            int year = Integer.parseInt(expiryDateYear.getText());
            LocalDate localDate = LocalDate.of(year, month, day);
            Date expiryDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());


            int balance = Integer.parseInt(balanceField.getText());
            
            CreditCard creditCard = new CreditCard(holderName, cardNumber, cvv, expiryDate, balance);
            CheckoutFinish(creditCard);
            frame.dispose();
        });


        frame.add(nameField);
        frame.add(cardNumberField);
        frame.add(cvvField);
        
        frame.add(expiryDateDay);
        frame.add(expiryDateMonth);
        frame.add(expiryDateYear);


        frame.add(balanceField);
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);

    }


    //
    private String CheckoutFinish(PaymentMethod paymentMethod){
        return cart.checkout(paymentMethod);
    }
}
