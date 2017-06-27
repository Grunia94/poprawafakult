package eu.programisci.gry.api;

import eu.programisci.gry.dto.CritDTO;
import eu.programisci.gry.dto.GraDTO;
import eu.programisci.gry.enums.EGatunek;
import eu.programisci.gry.service.IGraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/gry")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class GraRestController {

    @Autowired
    private IGraService service;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GraDTO findOne(@RequestParam("id") Long aId) {
        return service.findOne(aId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteOne(@RequestParam("id") Long aId) {
        service.deleteOne(aId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GraDTO save(@RequestBody GraDTO aGraDto) {
        return service.save(aGraDto);
    }

    @RequestMapping(value = "/saveBatch", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> saveBatch(@RequestBody List<GraDTO> aGraList) {
        return service.saveBatch(aGraList);
    }

    @RequestMapping(value = "/znajdzStarszeNiz", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> znajdzStarszeNiz(@RequestParam("rokWydania") Integer aRokWydania) {
        return service.znajdzStarszeNiz(aRokWydania);
    }

    @RequestMapping(value = "/znajdzWgGatunku", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> znajdzWgGatunku(@RequestParam("gatunek") EGatunek aGatunek) {
        return service.znajdzWgGatunku(aGatunek);
    }

    @RequestMapping(value = "/znajdzTytulyZawierajace", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> znajdzTytulyZawierajace(@RequestParam("partial") String aPartial) {
        return service.znajdzTytulyZawierajace(aPartial);
    }

    @RequestMapping(value = "/znajdzWgGatunkuIRokuWydania", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GraDTO> znajdzWgGatunkuIRokuWydania(@RequestBody CritDTO aCrit) {
        return service.znajdzWgGatunkuIRokuWydania(aCrit);
    }
}
