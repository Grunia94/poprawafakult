package eu.programisci.gry.service;

import eu.programisci.gry.dto.CritDTO;
import eu.programisci.gry.dto.GraDTO;
import eu.programisci.gry.enums.EGatunek;

import java.util.List;

public interface IGraService {
    GraDTO findOne(Long id);

    List<GraDTO> findAll();

    void deleteOne(Long id);

    GraDTO save(GraDTO in);

    List<GraDTO> saveBatch(List<GraDTO> inList);

    List<GraDTO> znajdzStarszeNiz(Integer rokWydania);

    List<GraDTO> znajdzWgGatunku(EGatunek gatunek);

    List<String> znajdzTytulyZawierajace(String partial);

    List<GraDTO> znajdzWgGatunkuIRokuWydania(CritDTO crit);
}
