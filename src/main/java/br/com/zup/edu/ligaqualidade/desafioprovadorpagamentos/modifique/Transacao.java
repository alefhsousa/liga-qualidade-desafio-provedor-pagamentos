package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    private BigDecimal valor;
    private TipoDePagamento metodoPagamento;
    private String numeroDeCartao;
    private String nomeDoCartao;
    private LocalDate validade;
    private String cvv;
    private Integer id;

    public Transacao(BigDecimal valor, TipoDePagamento metodoPagamento, String numeroDeCartao, String nomeDoCartao, LocalDate validade, String cvv, Integer id) {
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.numeroDeCartao = numeroDeCartao;
        this.validade = validade;
        this.nomeDoCartao = nomeDoCartao;
        this.cvv = cvv;
        this.id = id;
    }

    public Recebivel paraRecebivel() {
        return this.metodoPagamento.processaRecebivel(this);
    }
    public BigDecimal getValor() {
        return valor;
    }

    public TipoDePagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public String getNumeroDeCartao() {
        return numeroDeCartao;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public String getCvv() {
        return cvv;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeDoCartao() {
        return nomeDoCartao;
    }
}
