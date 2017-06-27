package eu.programisci.gry.service;

import eu.programisci.gry.converters.GraConverter;
import eu.programisci.gry.converters.WydanieConverter;
import eu.programisci.gry.dto.CritDTO;
import eu.programisci.gry.dto.GraDTO;
import eu.programisci.gry.enums.EGatunek;
import eu.programisci.gry.ob.GraOB;
import eu.programisci.gry.repository.IGraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class GraServiceImpl implements IGraService {

    @Autowired
    private IGraRepository repository;

    @Autowired
    private GraConverter graConverter;

    @Autowired
    private WydanieConverter wydanieConverter;

    @Override
    public GraDTO findOne(Long id) {
        GraOB ob = repository.findOne(id);
        return graConverter.obToDto(ob);
    }

    @Override
    public List<GraDTO> findAll() {
        List<GraOB> obList = repository.findAll();
        return graConverter.obListToDtoList(obList);
    }

    @Override
    public void deleteOne(Long id) {
        repository.delete(id);
    }

    @Override
    public GraDTO save(GraDTO in) {
        if(in.getId() == null)
            return graConverter.obToDto(create(in));
        else
            return graConverter.obToDto(update(in));
    }

    @Override
    public List<GraDTO> saveBatch(List<GraDTO> inList) {
        List<GraDTO> outList = new ArrayList<>();
        for (GraDTO in : inList) {
            outList.add(save(in));
        }
        return outList;
    }

    private GraOB create(GraDTO in) {
        GraOB ob = graConverter.dtoToOb(in);
        ob.setDataUtworzenia(new Date());
        ob = repository.save(ob);
        return ob;
    }

    private GraOB update(GraDTO in) {
        GraOB ob = repository.findOne(in.getId());
        ob.setTytul(in.getTytul());
        ob.setDeveloper(in.getDeveloper());
        ob.setGatunkiGry(new HashSet<>(in.getGatunki()));
        ob.setWydania(wydanieConverter.dtoListToObList(in.getWydania()));
        ob = repository.save(ob);
        return ob;
    }

    @Override
    public List<GraDTO> znajdzStarszeNiz(Integer rokWydania) {
        List<GraOB> ob = repository.znajdzStarszeNiz(rokWydania);
        return graConverter.obListToDtoList(ob);
    }

    @Override
    public List<GraDTO> znajdzWgGatunku(EGatunek gatunek) {
        List<GraOB> ob = repository.znajdzWgGatunku(gatunek);
        return graConverter.obListToDtoList(ob);
    }

    @Override
    public List<String> znajdzTytulyZawierajace(String partial) {
        return repository.znajdzTytulyZawierajace(partial);
    }

    @Override
    public List<GraDTO> znajdzWgGatunkuIRokuWydania(CritDTO crit) {
        List<GraOB> ob = repository.znajdzWgGatunkuIRokuWydania(crit);
        return graConverter.obListToDtoList(ob);
    }
}
