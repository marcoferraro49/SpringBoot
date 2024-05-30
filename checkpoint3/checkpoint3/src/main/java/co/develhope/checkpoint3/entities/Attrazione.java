package co.develhope.checkpoint3.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "attrazione")
public class Attrazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "durata")
    private Integer durata;

    @Column(name = "altezza_min")
    private Integer altezzaMin;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "attrazioni_id")
    private Parco parco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getAltezzaMin() {
        return altezzaMin;
    }

    public void setAltezzaMin(Integer altezzaMin) {
        this.altezzaMin = altezzaMin;
    }
}
