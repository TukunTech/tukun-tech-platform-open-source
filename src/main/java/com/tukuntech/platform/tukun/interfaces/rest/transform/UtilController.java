package com.tukuntech.platform.tukun.interfaces.rest.transform;


import com.tukuntech.platform.tukun.domain.model.aggregates.criticalAlerts.TypeAlert;
import com.tukuntech.platform.tukun.domain.model.aggregates.medic.Specialization;
import com.tukuntech.platform.tukun.domain.model.aggregates.patient.*;
import com.tukuntech.platform.tukun.domain.services.elder.AllergyService;
import com.tukuntech.platform.tukun.domain.services.elder.MedicalInsuranceService;
import com.tukuntech.platform.tukun.domain.model.aggregates.pendingMedicine.Status;
import com.tukuntech.platform.tukun.domain.services.criticalAlerts.TypeAlertService;
import com.tukuntech.platform.tukun.domain.services.medic.SpecializationService;
import com.tukuntech.platform.tukun.domain.services.patient.BloodTypeService;
import com.tukuntech.platform.tukun.domain.services.patient.GenderService;
import com.tukuntech.platform.tukun.domain.services.patient.NatonalityService;
import com.tukuntech.platform.tukun.domain.services.pendingMedicine.StatusService;
import com.tukuntech.platform.tukun.domain.util.appSetings;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/util", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "https://tukuntech.netlify.app")
@Tag(name = "Util", description = "Available Util Endpoints")
public class UtilController {

    @Autowired
    private BloodTypeService bloodTypeService;

    @Autowired
    private NatonalityService natonalityService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private TypeAlertService typeAlertService;
    @Autowired
    private AllergyService allergyService;
    @Autowired
    private MedicalInsuranceService medicalInsuranceService;


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

    @GetMapping("/listSpecialization")
    @ResponseBody
    public List<Specialization> listSpecialization(){
        return specializationService.getSpecialization();
    }

    @GetMapping("/listStatus")
    @ResponseBody
    public List<Status> listStatus(){return statusService.getStatus();}

    @GetMapping("/listTypeAlert")
    @ResponseBody
    public List<TypeAlert> listTypeAlert(){return typeAlertService.GetAllTypeAlerts();}

    @GetMapping("/listAllergy")
    @ResponseBody
    public List<Allergy> listAllergy(){return allergyService.getAllergy();}
    @GetMapping("/listMedicalInsurance")
    @ResponseBody
    public List<MedicalInsurance> listMedicalInsurance(){return medicalInsuranceService.getMedicalInsurance();}

}
