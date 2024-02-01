package alisher.mc.service;
import alisher.mc.model.Manga;
import alisher.mc.repository.MangaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j

public class MangaService {
    private MangaRepository mangaRepository;

    @Autowired
    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    public List<Manga> getAllMangas(){
        return mangaRepository.getAllMangas();
    }

    public Manga addManga(Manga manga){
        if(mangaRepository.findById(manga.getManga_id()) == null){
            return mangaRepository.save(manga);
        }
        else{
            throw new IllegalStateException("Manga with id(" + manga.getManga_id() + ") already exist");
        }
    }

    public Manga findMangaById(int id){
        return mangaRepository.findById(id);
    }

    public void deleteMangaById(Integer id){
        mangaRepository.deleteMangaById(id);
    }

    public Manga findMangaByName(String manga_name){
        return mangaRepository.findByName(manga_name);
    }

    public Manga updateManga(int manga_id, Manga manga){
        if(mangaRepository.findById(manga_id) != null){
            manga.setManga_id(manga_id);
            return mangaRepository.save(manga);
        }
        else{
            throw new NoSuchElementException("Manga with id(" + manga_id + ") not found");
        }
    }
}
