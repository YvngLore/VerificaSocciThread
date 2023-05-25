public class App {
    public static void main(String[] args) throws Exception {
        Box box = new Box();
        Semaforo semaforo = new Semaforo();

        Monoposto bottas = new Monoposto(1, "Mercedeas", "Bottas", box, semaforo);
        Monoposto verstappen = new Monoposto(2, "Redbull", "Verstappen", box, semaforo);
        Monoposto leclerc = new Monoposto(3, "Ferrari", "Leclerc", box, semaforo);

        bottas.start();
        verstappen.start();
        leclerc.start();

        bottas.join();
        verstappen.join();
        leclerc.join();
        
        System.out.println("------------GARA FINITA!!!!-------------");
    }
}