package alisher.mc.repository;

import alisher.mc.model.Genre;
import alisher.mc.model.Mangaka;
import alisher.mc.model.Personal_information;
import alisher.mc.service.PersonalInformationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PersonalInformationRepository extends JpaRepository<Personal_information, Integer> {
    Personal_information findByNameContainingIgnoreCase(String name);

    @Query("SELECT pi FROM Personal_information pi WHERE LOWER(pi.name) = LOWER(:user_name)")
    Personal_information findByName(@Param("user_name") String name);
    @Transactional
    void deletePersonal_informationById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO personal_information VALUES (?,?,?,?,?)", nativeQuery = true)
    void insertPersonalInformation(int personal_inf_id, String user_name, String user_lname, int user_age, int user_id);

    @Query(value = "SELECT * FROM personal_information pi", nativeQuery = true)
    List<Personal_information> getAllPersonal_Informations();

    @Query(value = "SELECT pi FROM Personal_information pi WHERE pi.personal_inf_id = :personal_inf_id")
    Personal_information findById(@Param("personal_inf_id") int id);
}