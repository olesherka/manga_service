package alisher.mc.repository;

import alisher.mc.model.Genre;
import alisher.mc.model.Mangaka;
import alisher.mc.model.Read_list;
import alisher.mc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface ReadListRepository extends JpaRepository<Read_list, Long> {
    Read_list findByNameContainingIgnoreCase(String name);

    @Transactional
    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO read_list VALUES (?,?,?)", nativeQuery = true)
    void insertReadList(int read_list_id, int manga_id, int user_id);

    @Query(value = "SELECT * FROM Read_list rl", nativeQuery = true)
    List<Read_list> getAllReadLists();

    @Query(value = "SELECT rl FROM Read_list rl WHERE rl.read_list_id = :id")
    Read_list  findById(@Param("read_list_id") int id);

}