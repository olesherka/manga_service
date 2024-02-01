package alisher.mc.repository;
import alisher.mc.model.Genre;
import alisher.mc.model.Manga;
import alisher.mc.model.Mangaka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface MangaRepository extends JpaRepository<Manga, Integer> {

    @Query("SELECT m FROM Manga m WHERE LOWER(m.manga_name) = LOWER(:manga_name)")
    Manga findByName(@Param("manga_name") String manga_name);
    @Transactional
    void deleteById(Integer manga_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO manga VALUES (?,?,?,?,?,?)", nativeQuery = true)
    void insertManga(int manga_id, String manga_name, Genre genre_id, Mangaka mangaka_id, int rate, LocalDateTime year_of_issue);

    @Query(value = "SELECT * FROM manga m", nativeQuery = true)
    List<Manga> getAllMangas();

    @Query(value = "SELECT m FROM Manga m WHERE m.manga_id = :manga_id")
    Manga  findById(@Param("manga_id") int id);

}
