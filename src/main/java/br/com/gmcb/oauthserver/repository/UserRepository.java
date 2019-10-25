package br.com.gmcb.oauthserver.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gmcb.oauthserver.domainobject.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
	
	Optional<User> findByEmail(String email);

}
