package alisher.mc.service;

import alisher.mc.model.Genre;
import alisher.mc.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j

public class GenreService {
    private GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres(){
        return genreRepository.getAllGenres();
    }

    public Genre addGenre(Genre genre){
        if(genreRepository.findById(genre.getGenre_id()) == null){
            return genreRepository.save(genre);
        }
        else{
            throw new IllegalStateException("Genre with id(" + genre.getGenre_id() + ") already exist");
        }
    }

    public Genre findGenreById(int id){
        return genreRepository.findById(id);
    }

    public void deleteGenreById(int id){
        genreRepository.deleteGenreById(id);
    }

    public Genre findGenreByName(String name){
        return genreRepository.findByName(name);
    }

    public Genre updateGenre(int genre_id, Genre genre){
        if(genreRepository.findById(genre_id) != null){
            genre.setGenre_id(genre_id);
            return genreRepository.save(genre);
        }
        else{
            throw new NoSuchElementException("Genre with id(" + genre_id + ") not found");
        }
    }
}