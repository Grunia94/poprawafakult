package eu.programisci.gry.repository;

import eu.programisci.gry.dto.CritDTO;
import eu.programisci.gry.enums.EGatunek;
import eu.programisci.gry.ob.GraOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGraRepository extends JpaRepository<GraOB, Long> {

    @Query("SELECT DISTINCT g FROM GraOB g LEFT JOIN g.wydania w WHERE w.rokWydania < :rokWydania")
    List<GraOB> znajdzStarszeNiz(@Param("rokWydania") Integer aRokWydania);

    @Query("SELECT g FROM GraOB g WHERE :gatunek MEMBER OF g.gatunkiGry")
    List<GraOB> znajdzWgGatunku(@Param("gatunek") EGatunek aGatunek);

    @Query("SELECT g.tytul FROM GraOB g WHERE upper(g.tytul) LIKE upper(concat('%',:partial,'%'))")
    List<String> znajdzTytulyZawierajace(@Param("partial") String aPartial);

    @Query("SELECT g FROM GraOB g LEFT JOIN g.wydania w WHERE :#{#crit.gatunek} MEMBER OF g.gatunkiGry AND w.rokWydania = :#{#crit.rokWydania}")
    List<GraOB> znajdzWgGatunkuIRokuWydania(@Param("crit") CritDTO aCritDTO);


}

