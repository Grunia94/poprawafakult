package eu.programisci.gry.dto;

import eu.programisci.gry.enums.EGatunek;

import java.util.List;
import java.util.Set;

public class GraDTO {
    private Long id;
    private String tytul;
    private List<EGatunek> gatunki;
    private String developer;
    private Set<WydanieDTO> wydania;

    public GraDTO() {}
    public GraDTO(Long id,
                  String tytul,
                  List<EGatunek> gatunki,
                  String developer,
                  Set<WydanieDTO> wydania) {
        this.id = id;
        this.tytul = tytul;
        this.gatunki = gatunki;
        this.developer = developer;
        this.wydania = wydania;
    }

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

    public List<EGatunek> getGatunki() {
        return gatunki;
    }

    public void setGatunki(List<EGatunek> gatunki) {
        this.gatunki = gatunki;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Set<WydanieDTO> getWydania() {
        return wydania;
    }

    public void setWydania(Set<WydanieDTO> wydania) {
        this.wydania = wydania;
    }
}
