public class Bolo {
    
    public static void main(String[] args) throws InterruptedException {   
        SplashScreen splashScreen = new SplashScreen();
        BoloGUI boloGUI = new BoloGUI();
        
        splashScreen.setVisible(true);
        Thread.sleep(1500);
        splashScreen.setVisible(false);
        boloGUI.setVisible(true);
        
    }
}
