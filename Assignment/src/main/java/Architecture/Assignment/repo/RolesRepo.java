package Architecture.Assignment.repo;


import Architecture.Assignment.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String authority);
}
