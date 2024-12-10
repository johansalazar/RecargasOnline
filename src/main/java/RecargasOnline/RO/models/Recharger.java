package RecargasOnline.RO.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Recharger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal valor;
    private LocalDateTime fecha;


    @JoinColumn(name = "operador_id")
    private int operadorId;


    @JoinColumn(name = "vendedor_id")
    private Long vendedorId;

    public Recharger() {
    }

    public Recharger(int id, BigDecimal valor, LocalDateTime fecha, int operadorId, Long vendedorId) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.operadorId = operadorId;
        this.vendedorId = vendedorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(int operadorId) {
        this.operadorId = operadorId;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }

    @Override
    public String toString() {
        return "Recharger{" +
                "id=" + id +
                ", valor=" + valor +
                ", fecha=" + fecha +
                ", operadorId=" + operadorId +
                ", vendedorId=" + vendedorId +
                '}';
    }
}
