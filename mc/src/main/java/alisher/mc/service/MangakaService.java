package alisher.mc.service;
import alisher.mc.model.Mangaka;
import alisher.mc.repository.MangakaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j

public class MangakaService {
    private MangakaRepository mangakaRepository;

    @Autowired
    public MangakaService(MangakaRepository mangakaRepository) {
        this.mangakaRepository = mangakaRepository;
    }

    public List<Mangaka> getAllMangakas(){
        return mangakaRepository.getAllMangakas();
    }

    public Mangaka addMangaka(Mangaka mangaka){
        if(mangakaRepository.findById(mangaka.getMangaka_id()) == null){
            return mangakaRepository.save(mangaka);
        }
        else{
            throw new IllegalStateException("Mangaka with id(" + mangaka.getMangaka_id() + ") already exist");
        }
    }

    public Mangaka findMangakaById(int id){
        return mangakaRepository.findById(id);
    }

    public void deleteMangakaById(int id){
        mangakaRepository.deleteMangakaById(id);
    }

    public Mangaka findMangakaByName(String name){
        return mangakaRepository.findByName(name);
    }

    public Mangaka updateMangaka(int mangaka_id, Mangaka mangaka){
        if(mangakaRepository.findById(mangaka_id) != null){
            mangaka.setMangaka_id(mangaka_id);
            return mangakaRepository.save(mangaka);
        }
        else{
            throw new NoSuchElementException("Mangaka with id(" + mangaka_id + ") not found");
        }
    }
}