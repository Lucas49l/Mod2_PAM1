
package superclasse;

public class SuperClasse {
    
    public static void main(String[] args) {
        
        Cachorro cachorro = new Cachorro("Rex", "Caramelo");
        Galinha  galinha = new Galinha("Jorina");
        Corvo    corvo   = new Corvo("Alfredo");
        
        cachorro.fazerBarulho();
        galinha.fazerBarulho();
        corvo.fazerBarulho();
        
    }
    
}
