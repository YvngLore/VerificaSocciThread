public class Semaforo {
    private int valore;

    public Semaforo(){
        valore = 2; // cambia soltanto la molteciplità del box, possono entrare 2 vetture alla volta
    }

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

    public synchronized void V(){
        valore++;
        notify();
    }
}
