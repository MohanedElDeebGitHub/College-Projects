public class App {
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();

        MainMenu m = new MainMenu(cart);
        m.MainMenuInitialize();
    }
}
