/**
 * CLASSE MONOPOSTO
 */
public class Monoposto extends Thread{
    /** ATTRIBUTI CLASSE MONOPOSTO*/
    /**
     * int numeroIdentificativo - numero identificativo della vettura
     */
    private int numeroIdentificativo;

    /**
     * String scuderia -> nome della scuderia della vettura
     */
    private String scuderia;

    /**
     * Box box - oggetto box 
     */
    private Box box;
    /**
     * Semaforo semaforo - oggetto semaforo
     */
    private Semaforo semaforo;

    /**
     * int numeroGiri - numero di giri che deve completare la vettura
     */
    private int numeroGiri;

    /**
     * Costruttore classe Monoposto
     * @param ni - Numero identificativo
     * @param scud - nome scuderia
     * @param np - nome pilota
     * @param b - box
     * @param s - semaforo
     */
    public Monoposto(int ni, String scud, String np, Box b, Semaforo s){
        numeroIdentificativo = ni;
        scuderia = scud;
        setName(np);
        box = b;
        semaforo = s;
        numeroGiri = 0;
    }

    /**
     * Metodo che fa eseguire alla vettura un giro di corsa. 
     * Se i numeri di giri sono pari a 3, 6 o 9 la vettura entra nel box per effetturare un pit-stop.
     */
    @Override
    public void run(){
        System.out.println("--------------------" + Thread.currentThread().getName() + " inizia la gara ---------------------\n");
        
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep((long)(Math.random() * 4000) + 1);
            } catch (Exception e) {
                System.out.println("ERRORE GENERICO");
            }

            System.out.println("->GIRO-" + (i+1) + "--->" + Thread.currentThread().getName() + " ha completato un giro...\n");
            numeroGiri++;

            
            if(numeroGiri == 3 || numeroGiri == 6 || numeroGiri == 9){
                semaforo.P();
                box.cambioGomme(Thread.currentThread().getName());
                System.out.println("----->CAMBIO DI GOMME EFFETTUATO --- " + Thread.currentThread().getName() + " Torna in gara!");
                semaforo.V();
            }
        }
    }
}
