package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.patient.BloodType;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Gender;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.Nationality;
import com.tukuntech.platform.tukun.domain.services.patient.BedService;
import com.tukuntech.platform.tukun.domain.services.patient.BloodTypeService;
import com.tukuntech.platform.tukun.domain.services.patient.GenderService;
import com.tukuntech.platform.tukun.domain.services.patient.NatonalityService;
import com.tukuntech.platform.tukun.domain.util.appSetings;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/util", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = appSetings.URL_CROSS_ORIGIN)
@Tag(name = "Util", description = "Available Util Endpoints")
public class UtilController {

    @Autowired
    private BloodTypeService bloodTypeService;

    @Autowired
    private NatonalityService natonalityService;

    @Autowired
    private GenderService genderService;

    @GetMapping("/listBlood")
    @ResponseBody
    public List<BloodType> listBlood(){
        return bloodTypeService.getBloodType();
    }

    @GetMapping("/listNationality")
    @ResponseBody
    public List<Nationality> listNationality(){
        return natonalityService.getNationalities();
    }

    @GetMapping("/listGender")
    @ResponseBody
    public List<Gender> listGender(){
        return genderService.getGenders();
    }

}
