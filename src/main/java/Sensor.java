import java.util.Observable;
public class Sensor extends Observable{

    private String nome;

    public Sensor(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void notificarProblema(String mensagem) {
        setChanged();
        notifyObservers(mensagem);
    }

    public String toString() {
        return this.nome;
    }
}
