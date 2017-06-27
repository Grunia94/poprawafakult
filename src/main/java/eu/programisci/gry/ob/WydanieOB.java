package eu.programisci.gry.ob;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wydanie")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_wydanie_id")
public class WydanieOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "data_utworzenia")
    private Date dataUtworzenia;

    @Column(name = "wydawca")
    private String wydawca;

    @Column(name = "platforma")
    private String platforma;

    @Column(name = "rokWydania")
    private Integer rokWydania;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWydawca() {
        return wydawca;
    }

    public void setWydawca(String wydawca) {
        this.wydawca = wydawca;
    }

    public String getPlatforma() {
        return platforma;
    }

    public void setPlatforma(String platforma) {
        this.platforma = platforma;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }
}
