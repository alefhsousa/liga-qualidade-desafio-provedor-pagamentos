package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

public interface ProcessadorRecebivel {

    Recebivel processa(Transacao transacao, Double taxaDeProcessamento, Integer diasParaRecebimento);
}
