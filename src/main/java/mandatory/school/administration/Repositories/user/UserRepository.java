package mandatory.school.administration.Repositories.user;

import mandatory.school.administration.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findUserByUsername(String username);
}

