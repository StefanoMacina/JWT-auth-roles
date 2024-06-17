package com.example.angularLogin.repositories;

import com.example.angularLogin.models.ERole;
import com.example.angularLogin.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

    Optional<Role> findByName(ERole name);
}
