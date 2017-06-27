package eu.programisci.gry.ob;

import eu.programisci.gry.enums.EGatunek;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gra")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_gra_id")
public class GraOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "data_utworzenia")
    private Date dataUtworzenia;

    @Column(name = "tytul")
    private String tytul;

    @ElementCollection(targetClass = EGatunek.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "gatunek")
    @CollectionTable(name = "gry_gatunki", joinColumns = @JoinColumn(name = "gra_id"))
    private Set<EGatunek> gatunkiGry = new HashSet<>();

    @Column(name = "developer")
    private String developer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "gry_wydania")
    private Set<WydanieOB> wydania;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Set<EGatunek> getGatunkiGry() {
        return gatunkiGry;
    }

    public void setGatunkiGry(Set<EGatunek> gatunkiGry) {
        this.gatunkiGry = gatunkiGry;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Set<WydanieOB> getWydania() {
        return wydania;
    }

    public void setWydania(Set<WydanieOB> wydania) {
        this.wydania = wydania;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }
}
