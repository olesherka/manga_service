package alisher.mc.repository;

import alisher.mc.model.Genre;
import alisher.mc.model.Mangaka;
import alisher.mc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNameContainingIgnoreCase(String name);

    @Query("SELECT u FROM User u WHERE LOWER(u.user_nickname) = LOWER(:user_nickname)")
    User findByName(@Param("user_nickname") String name);
    @Transactional
    void deleteUserById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO service_user VALUES (?,?,?,?)", nativeQuery = true)
    void insertGenre(int user_id, String user_nickname, int level, int total_read);

    @Query(value = "SELECT * FROM User u", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "SELECT u FROM User u WHERE u.user_id = :user_id")
    User  findById(@Param("user_id") int id);

}