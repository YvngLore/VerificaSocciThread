public class Monoposto extends Thread{
    private int numeroIdentificativo;
    private String scuderia;
    private Box box;
    private Semaforo semaforo;
    private int numeroGiri;

    public Monoposto(int ni, String scud, String np, Box b, Semaforo s){
        numeroIdentificativo = ni;
        scuderia = scud;
        setName(np);
        box = b;
        semaforo = s;
        numeroGiri = 0;
    }

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
