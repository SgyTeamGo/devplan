package dao;

import model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by meruzhan.gasparyan on 29-Nov-16.
 */

@Repository
public interface UserDao extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query(countQuery = "select u from users u where first_name =:firstName")
    User findByFirstName(@Param("firstName") String firstName);

    @Query(countQuery = "select u from  users u where username =:userName")
    User findByUserName(@Param("userName") String userName);


}
