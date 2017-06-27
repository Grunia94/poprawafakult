package eu.programisci.gry.dto;

import eu.programisci.gry.enums.EGatunek;

public class CritDTO {
    private EGatunek gatunek;
    private Integer rokWydania;

    public CritDTO() {}

    public CritDTO(EGatunek gatunek, Integer rokWydania) {
        this.gatunek = gatunek;
        this.rokWydania = rokWydania;
    }

    public EGatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(EGatunek gatunek) {
        this.gatunek = gatunek;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }
}
