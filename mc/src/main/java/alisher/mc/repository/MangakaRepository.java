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

public interface MangakaRepository extends JpaRepository<Mangaka, Long> {
    Mangaka findByNameContainingIgnoreCase(String name);

    @Query("SELECT m FROM Mangaka m WHERE LOWER(m.name) = LOWER(:name)")
    Mangaka findByName(@Param("name") String name);
    @Transactional
    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO mangaka VALUES (?,?,?,?)", nativeQuery = true)
    void insertManga(int mangaka_id, String name, String lname, int age);

    @Query(value = "SELECT * FROM Mangaka m", nativeQuery = true)
    List<Mangaka> getAllMangakas();

    @Query(value = "SELECT m FROM Mangaka m WHERE m.mangaka_id = :id")
    Mangaka  findById(@Param("mangaka_id") int id);

}

