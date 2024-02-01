package alisher.mc.service;

import alisher.mc.model.Genre;
import alisher.mc.model.Rate;
import alisher.mc.repository.GenreRepository;
import alisher.mc.repository.RateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j

public class RateService {
    private RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public List<Rate> getAllRates(){
        return rateRepository.getAllRates();
    }

    public Rate addRate(Rate rate){
        if(rateRepository.findById(rate.getRate_id()) == null){
            return rateRepository.save(rate);
        }
        else{
            throw new IllegalStateException("Rate with id(" + rate.getRate_id() + ") already exist");
        }
    }

    public Rate findRateById(int id){
        return rateRepository.findById(id);
    }

    public void deleteRateById(int id){
        rateRepository.deleteRateById(id);
    }


    public Rate updateRate(int rate_id, Rate rate){
        if(rateRepository.findById(rate_id) != null){
            rate.setRate_id(rate_id);
            return rateRepository.save(rate);
        }
        else{
            throw new NoSuchElementException("Rate with id(" + rate_id + ") not found");
        }
    }
}