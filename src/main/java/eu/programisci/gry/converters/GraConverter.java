package eu.programisci.gry.converters;

import eu.programisci.gry.dto.GraDTO;
import eu.programisci.gry.enums.EGatunek;
import eu.programisci.gry.ob.GraOB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GraConverter {

    @Autowired
    private WydanieConverter converter;

    public GraDTO obToDto(GraOB in) {
        GraDTO out = new GraDTO();
        out.setId(in.getId());
        out.setTytul(in.getTytul());
        out.setDeveloper(in.getDeveloper());
        List<EGatunek> gatunki = new ArrayList<>(in.getGatunkiGry());
        out.setGatunki(gatunki);
        out.setWydania(converter.obSetToDtoSet(in.getWydania()));
        return out;
    }

    public GraOB dtoToOb(GraDTO in) {
        GraOB out = new GraOB();
        out.setTytul(in.getTytul());
        out.setDeveloper(in.getDeveloper());
        Set<EGatunek> gatunki = new HashSet<>(in.getGatunki());
        out.setGatunkiGry(gatunki);
        out.setWydania(converter.dtoListToObList(in.getWydania()));
        return out;
    }

    public List<GraDTO> obListToDtoList(List<GraOB> inList) {
        List<GraDTO> outList = new ArrayList<>();
        for(GraOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }

    public List<GraOB> dtoListToObList(List<GraDTO> inList) {
        List<GraOB> outList = new ArrayList<>();
        for(GraDTO in : inList) {
            outList.add(dtoToOb(in));
        }
        return outList;
    }
}
