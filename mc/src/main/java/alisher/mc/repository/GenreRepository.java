package alisher.mc.repository;

import alisher.mc.model.Genre;
import alisher.mc.model.Mangaka;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query("SELECT g FROM Genre g WHERE LOWER(g.genre_name) = LOWER(:genre_name)")
    Genre findByName(@Param("genre_name") String name);
    @Transactional
    void deleteById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO genre VALUES (?,?,?,?)", nativeQuery = true)
    void insertGenre(int genre_id, String genre_name);

    @Query(value = "SELECT * FROM Genre g", nativeQuery = true)
    List<Genre> getAllGenres();

    @Query(value = "SELECT g FROM Genre g WHERE g.genre_id = :genre_id")
    Genre  findById(@Param("genre_id") int id);

}
