package model.entities.services;

import model.entities.AluguelDeCarro;
import model.entities.Fatura;

import java.time.Duration;

public class ServicoDeAluguel {

    private double precoPorHora;
    private double precoPorDia;

    private ServicoDeImpostoBrasil ServicoDeImposto;

    public ServicoDeAluguel(double precoPorHora, double precoPorDia, ServicoDeImpostoBrasil servicoDeImposto) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        ServicoDeImposto = servicoDeImposto;
    }

    public static void processFatura(AluguelDeCarro ac) {
    }

    public void processamentoDaFatura(AluguelDeCarro AluguelDeCarro){

        double minutos = Duration.between(AluguelDeCarro.getComeco(), AluguelDeCarro.getFim()).toMinutes();
        double horas = minutos / 60.0;

        double pagamentoBasico;
        if (horas <= 12.0){
            pagamentoBasico = precoPorHora * Math.ceil(horas);
        }
        else {
            pagamentoBasico = precoPorDia * Math.ceil(horas / 24.0);
        }

        double imposto = ServicoDeImposto.imposto(pagamentoBasico);

        AluguelDeCarro.setFatura(new Fatura(pagamentoBasico, imposto));
    }
}