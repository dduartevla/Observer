import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonitorTest {

    @Test
    void deveNotificarUmMonitor() {
        Sensor sensor = new Sensor("Umidade01");
        Monitor monitor = new Monitor("Monitor01");
        sensor.addObserver(monitor);
        sensor.notificarProblema("Umidade Baixa");
        assertEquals("Monitor01" + "\n Sensor: " + "Umidade01" + "\n Mensagem: " + "Umidade Baixa"
                , monitor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMonitores() {
        Sensor sensor = new Sensor("Umidade01");
        Monitor monitor1 = new Monitor("Monitor01");
        Monitor monitor2 = new Monitor("Monitor02");
        sensor.addObserver(monitor1);
        sensor.addObserver(monitor2);
        sensor.notificarProblema("Umidade Alta");
        assertEquals("Monitor01" + "\n Sensor: " + "Umidade01" + "\n Mensagem: " + "Umidade Alta"
                , monitor1.getUltimaNotificacao());
        assertEquals("Monitor02" + "\n Sensor: " + "Umidade01" + "\n Mensagem: " + "Umidade Alta"
                , monitor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarMonitor() {
        Sensor sensor = new Sensor("Temperatura01");
        Monitor monitor = new Monitor("Monitor01");
        sensor.notificarProblema("Muito Quente");
        assertEquals(null, monitor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMonitorUmidade01() {
        Sensor sensor1 = new Sensor("Umidade01");
        Sensor sensor2 = new Sensor("Umidade02");
        Monitor monitor1 = new Monitor("Monitor01");
        Monitor monitor2 = new Monitor("Monitor02");
        sensor1.addObserver(monitor1);
        sensor2.addObserver(monitor2);
        sensor1.notificarProblema("Umidade Baixa");
        assertEquals("Monitor01" + "\n Sensor: " + "Umidade01" + "\n Mensagem: " + "Umidade Baixa"
                , monitor1.getUltimaNotificacao());
        assertEquals(null, monitor2.getUltimaNotificacao());
    }


}