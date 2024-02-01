package alisher.mc.service;

import alisher.mc.model.Genre;
import alisher.mc.model.Personal_information;
import alisher.mc.repository.GenreRepository;
import alisher.mc.repository.PersonalInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j

public class PersonalInformationService {
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    public PersonalInformationService(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    public List<Personal_information> getAllPersonalInformations(){
        return personalInformationRepository.getAllPersonal_Informations();
    }

    public Personal_information addPersonalInformationService(Personal_information personalInformation){
        if(personalInformationRepository.findById(personalInformation.getPersonal_inf_id()) == null){
            return personalInformationRepository.save(personalInformation);
        }
        else{
            throw new IllegalStateException("Personal information with id(" + personalInformation.getPersonal_inf_id() + ") already exist");
        }
    }

    public Personal_information findById(int id){
        return personalInformationRepository.findById(id);
    }

    public void deletePersonalInformationById(int id){
        personalInformationRepository.deletePersonal_informationById(id);
    }

    public Personal_information findPersonalInformationByName(String name){
        return personalInformationRepository.findByName(name);
    }

    public Personal_information updateGenre(int personal_inf_id, Personal_information personalInformation){
        if(personalInformationRepository.findById(personal_inf_id) != null){
            personalInformation.setPersonal_inf_id(personal_inf_id);
            return personalInformationRepository.save(personalInformation);
        }
        else{
            throw new NoSuchElementException("Personal information with id(" + personal_inf_id + ") not found");
        }
    }
}