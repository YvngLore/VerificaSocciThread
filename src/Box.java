public class Box {
    public Box(){}

    public void cambioGomme(String nome){
        System.out.println("----->PIT-STOP: " + nome + " entra nel BOX per effetturare un CAMBIO DI GOMME....");
        
        try{
            Thread.sleep((long)(Math.random() * 5000) + 1);
        }catch(Exception ex){
            System.out.println("ERRORE GENERICO");
        }
    }
}
