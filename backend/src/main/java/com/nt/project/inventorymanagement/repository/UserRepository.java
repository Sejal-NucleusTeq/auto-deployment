package com.nt.project.inventorymanagement.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nt.project.inventorymanagement.domain.User;

/**
 * @author Sejal Jain.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * @param email : email.
     * @return user.
     */
    Optional<User> findByEmail(String email);
    /**
     * @param id :id.
     * @return user.
     */
    Optional<User> findById(int id);
    /**
     * @param email : email.
     * @param password :password.
     * @return user.
     */
    Optional<User> findByEmailAndPassword(String email, String password);

    /**
     * @param employeeId : employeeId.
     * @return user.
     */
    Optional<User> findByEmployeeId(String employeeId);

    /**
     * @param phoneNo : phoneNo.
     * @return user.
     */
    Optional<User> findByPhoneNo(String phoneNo);
    /**
     * @param isDeleted : delete.
     * @return user.
     */
    List<User> findByIsDeleted(boolean isDeleted);
}
