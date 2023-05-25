/**
 * Classe Box
 */
public class Box {
    /**
     * La classe Box ha solo un Costruttore vuoto
     */
    public Box(){}

    /**
     * Il metodo simula il cambio di gomme della vettura con un tempo di attesa che va da 1 a 5 secondi
     * @param nome - prende in ingresso il nome del pilota
     */
    public void cambioGomme(String nome){
        System.out.println("----->PIT-STOP: " + nome + " entra nel BOX per effetturare un CAMBIO DI GOMME....");
        
        try{
            Thread.sleep((long)(Math.random() * 5000) + 1);
        }catch(Exception ex){
            System.out.println("ERRORE GENERICO");
        }
    }
}
