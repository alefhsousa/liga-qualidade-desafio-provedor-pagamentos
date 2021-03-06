package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Recebivel {

    private final StatusRecebivel status;
    private final BigDecimal valorOriginal;
    private final BigDecimal valorAReceber;
    private final LocalDate dataRecebimento;

    public Recebivel(StatusRecebivel status, BigDecimal valorOriginal, BigDecimal valorAReceber, LocalDate dataRecebimento) {
        this.status = status;
        this.valorOriginal = valorOriginal;
        this.valorAReceber = valorAReceber;
        this.dataRecebimento = dataRecebimento;
    }

    public String[] paraArrayString() {
        return new String[]{
                this.status.name().toLowerCase(Locale.ROOT),
                this.valorOriginal.toString(),
                this.valorAReceber.toString(),
                this.dataRecebimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        };
    }
}

    enum StatusRecebivel {
        PAGO,
        AGUARDANDO_PAGAMENTO
    }
