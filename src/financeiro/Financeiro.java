package financeiro;

public class Financeiro {
    private static boolean capital;

    // Construtor do Financeiro
    private Financeiro() {
        setCapital(true);
    }    

    // Setter do atributo Capital
    private static void setCapital(boolean value) {
        capital = value;
    }
    
    // Condece capital
    public static boolean concedeCapital() {
        return true;
    }    
}
