package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProcessadorDebito implements ProcessadorRecebivel{


    @Override
    public Recebivel processa(Transacao transacao, Double taxaDeProcessamento, Integer diasParaRecebimento) {

        return new Recebivel(StatusRecebivel.PAGO,
                transacao.getValor(),
                transacao.getValor().subtract(transacao.getValor().multiply(new BigDecimal(taxaDeProcessamento.toString()))),
                LocalDate.now().plusDays(diasParaRecebimento));
    }
}
