package eu.programisci.gry.converters;

import eu.programisci.gry.dto.WydanieDTO;
import eu.programisci.gry.ob.WydanieOB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WydanieConverter {
    public WydanieDTO obToDto(WydanieOB in) {
        WydanieDTO out = new WydanieDTO();
        out.setId(in.getId());
        out.setPlatforma(in.getPlatforma());
        out.setWydawca(in.getWydawca());
        out.setRokWydania(in.getRokWydania());
        return out;
    }

    public WydanieOB dtoToOb(WydanieDTO in) {
        WydanieOB out = new WydanieOB();
        out.setId(in.getId());
        out.setRokWydania(in.getRokWydania());
        out.setWydawca(in.getWydawca());
        out.setPlatforma(in.getPlatforma());
        return out;
    }

    public Set<WydanieDTO> obSetToDtoSet(Set<WydanieOB> inList) {
        Set<WydanieDTO> outList = new HashSet<>();
        for(WydanieOB in : inList) {
            outList.add(obToDto(in));
        }
        return outList;
    }

    public Set<WydanieOB> dtoListToObList(Set<WydanieDTO> inList) {
        Set<WydanieOB> outList = new HashSet<>();
        for(WydanieDTO in : inList) {
            outList.add(dtoToOb(in));
        }
        return outList;
    }
}

