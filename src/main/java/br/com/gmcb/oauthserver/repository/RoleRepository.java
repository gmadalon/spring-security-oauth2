package br.com.gmcb.oauthserver.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gmcb.oauthserver.domainobject.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, UUID> {

}
