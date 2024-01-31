package alisher.mc.controller;

import alisher.mc.model.Manga;
import alisher.mc.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "mangalibrary/")

public class MangaController {
    private MangaService mangaService;

    @Autowired
    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }

    @GetMapping("listOfMangas/")
    public List<Manga> getMangas(){
        return mangaService.getAllMangas();
    }

    @GetMapping("searchManga/{id}")
    public Manga getMangaById(@PathVariable int id){
        return mangaService.findMangaById(id);
    }

    @PostMapping("addNewManga/")
    public ResponseEntity<Manga> addStudent(@RequestBody Manga manga){
        Manga newManga = mangaService.addManga(manga);
        return ResponseEntity.ok(newManga);
    }
    @PutMapping("updateManga/{id}")
    public ResponseEntity<Manga> updateStudent(@PathVariable int id, @RequestBody Manga manga){
        Manga updatedManga = mangaService.updateManga(id, manga);
        return ResponseEntity.ok(updatedManga);
    }

    @DeleteMapping("removeManga/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        mangaService.deleteMangaById(id);
        return ResponseEntity.ok().body("manga with id " + id + " deleted.");
    }
}

