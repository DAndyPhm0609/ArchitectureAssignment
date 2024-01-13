package Architecture.Assignment.repo;


import Architecture.Assignment.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByAuthority(String authority);
}
