package alisher.mc.repository;

import alisher.mc.model.Genre;
import alisher.mc.model.Mangaka;
import alisher.mc.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
    Rate findByNameContainingIgnoreCase(String name);

    @Transactional
    void deleteRateById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO rate VALUES (?,?,?,?,?,?,?)", nativeQuery = true)
    void insertRate(int rate_id, int detail, int story, int quality_of_drawing, int manga_id, int user_id, String comment);

    @Query(value = "SELECT * FROM Rate r", nativeQuery = true)
    List<Rate> getAllRates();

    @Query(value = "SELECT r FROM Rate r WHERE r.rate_id = :rate_id")
    Rate findById(@Param("rate_id") int id);

}