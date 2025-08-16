package superclasse;

public class Corvo extends Animal {

    public Corvo(String nome) {
        super(nome);
    }
    
    @Override
    public void fazerBarulho() {
        System.out.println("Quó, quó, quóóóóó");
    }
}

