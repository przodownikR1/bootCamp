package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.java.scalatech.entity.Role;
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>{

}
