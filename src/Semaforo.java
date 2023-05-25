/**
 * Classe Semaforo
 */
public class Semaforo {
    /**
     * Attributi classe Semaforo
     * int valore - valore del semaforo (se 0 è rosso, se 1 è verde)
     */
    private int valore;

    /**
     * Costruttore classe Semaforo
     * Non prende niente in ingresso e setta il valore pari a 1
     */
    public Semaforo(){
        valore = 1;
    }

    /**
     * finchè il valore è uguale a 0, mette il Thread corrente nello stato wait()
     * se il valore è pari a 1, viene decrementato di 1
     */
    public synchronized void P(){
        while(valore == 0){
            try {
                System.out.println("------------" + Thread.currentThread().getName() + " in attesa al BOX-----------");
                wait();
            } catch (Exception e) {
                System.out.println("ERRORE GENERICO");
            }
        }
        valore--;
    }

    /**
     * Metodo che aumenta il valore di 1.
     * Avverte il primo Thread nello stato di wait() che il semaforo è attivo
     */
    public synchronized void V(){
        valore++;
        notify();
    }
}
