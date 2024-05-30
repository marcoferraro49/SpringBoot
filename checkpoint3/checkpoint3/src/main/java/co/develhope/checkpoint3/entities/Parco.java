package co.develhope.checkpoint3.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parco")
public class Parco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "citta")
    private String citta;

    @OneToMany(mappedBy = "parco")
    @JsonManagedReference
    private List<Attrazione> attrazioni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Attrazione> getAttrazioni() {
        return attrazioni;
    }

    public void setAttrazioni(List<Attrazione> attrazioni) {
        this.attrazioni = attrazioni;
    }
}
