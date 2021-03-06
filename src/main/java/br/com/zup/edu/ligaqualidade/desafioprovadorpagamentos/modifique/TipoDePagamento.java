package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

public enum TipoDePagamento {
    CREDITO(new ProcessadorCredito(), 0.05, 30),
    DEBITO(new ProcessadorDebito(), 0.03, 0);

    private ProcessadorRecebivel processadorRecebivel;
    private Double taxaDeProcessamento;
    private Integer diasParaRecebimento;

    TipoDePagamento(ProcessadorRecebivel processadorRecebivel, Double taxaDeProcessamento, Integer diasParaRecebimento) {
        this.processadorRecebivel = processadorRecebivel;
        this.taxaDeProcessamento = taxaDeProcessamento;
        this.diasParaRecebimento = diasParaRecebimento;
    }

    public Recebivel processaRecebivel(Transacao transacao) {
        return this.processadorRecebivel.processa(transacao, this.taxaDeProcessamento, this.diasParaRecebimento);
    }

    public String nome() {
        return this.name();
    }
}
