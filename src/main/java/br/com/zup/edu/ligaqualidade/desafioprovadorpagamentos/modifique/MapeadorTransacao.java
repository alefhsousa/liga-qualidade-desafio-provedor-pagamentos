package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class MapeadorTransacao {

    private String separador;

    public MapeadorTransacao(String separador) {
        this.separador = separador;
    }

    public Transacao paraTransacao(String transacaoInfo) {
        String[] valores = transacaoInfo.split(separador);

        return new Transacao(new BigDecimal(valores[0]), TipoDePagamento.valueOf(valores[1].toUpperCase()),
                valores[2],valores[3],
                LocalDate.parse(valores[4], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                valores[5], Integer.parseInt(valores[6]));
    }

    public List<Transacao> paraTransacao(List<String> informacoesTransacoes) {
        return informacoesTransacoes
                .stream()
                .map(this::paraTransacao)
                .collect(Collectors.toList());
    }

}
