package mandatory.school.administration.Repositories;

import mandatory.school.administration.Model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsertypeRepository extends JpaRepository<UserType, String>
{
}
