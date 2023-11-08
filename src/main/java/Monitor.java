import java.util.Observer;
import java.util.Observable;

public class Monitor implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Monitor(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void observar(Sensor sensor) {
        sensor.addObserver(this);
    }

    public void update(Observable sensor, Object mensagem) {
        this.ultimaNotificacao = this.nome + "\n Sensor: " + sensor.toString() + "\n Mensagem: " + mensagem;
    }
}
