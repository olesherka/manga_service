package alisher.mc.repository;

import alisher.mc.model.Genre;
import alisher.mc.model.Mangaka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByNameContainingIgnoreCase(String name);

    @Query("SELECT g FROM Genre g WHERE LOWER(g.genre_name) = LOWER(:name)")
    Genre findByName(@Param("genre_name") String name);
    @Transactional
    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO genre VALUES (?,?,?,?)", nativeQuery = true)
    void insertGenre(int genre_id, String genre_name);

    @Query(value = "SELECT * FROM Genre g", nativeQuery = true)
    List<Genre> getAllGenres();

    @Query(value = "SELECT g FROM Genre g WHERE g.genre_id = :id")
    Genre  findById(@Param("genre_id") int id);

}
