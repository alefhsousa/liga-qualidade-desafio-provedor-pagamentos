package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.MapeadorTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class TestMapeadorTransacao {


    @Test
    public void testDeveRetornarUmaTransacao() {
        BigDecimal valor = new BigDecimal("22.50");
        String credito = new String("CREDITO");

        String numeroCartao = "764387534";
        String nomeDoCartao = "Nome do cartao";
        String dataTransacao = LocalDate.now().plusYears(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String cvv = "457";
        int idTransacao = new Random().nextInt();
        String param = String.format("%s,%s,%s,%s,%s,%s,%s",
                valor,
                credito,
                numeroCartao,
                nomeDoCartao,
                dataTransacao,
                cvv,
                idTransacao
        );
        List<Transacao> transacaos = new MapeadorTransacao(",").paraTransacao(List.of(param));

        Assertions.assertTrue(transacaos.stream().allMatch(dado -> dado.getValor().equals(valor) &&
                               dado.getMetodoPagamento().name().equals(credito) &&
                               dado.getNumeroDeCartao().equals(numeroCartao) &&
                               dado.getNomeDoCartao().equals(nomeDoCartao) &&
                               dado.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyy")).equals(dataTransacao) &&
                               dado.getCvv().equals(cvv) &&
                               dado.getId().equals(idTransacao)));
    }


}
