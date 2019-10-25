package br.com.gmcb.oauthserver.service.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.gmcb.oauthserver.domainobject.Role;
import br.com.gmcb.oauthserver.domainobject.User;
import br.com.gmcb.oauthserver.repository.RoleRepository;
import br.com.gmcb.oauthserver.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository ){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

    @Override
    public User findByEmail(String email)
    {
    	return userRepository.findByEmail(email).get();
    }

	@Override
	public void addUser(String email, String password) {
		User user = new User(email, password);
		
		Set<Role> roles = new HashSet<Role>();
		roleRepository.findAll().forEach(roles::add);
		user.setRoles(roles);
		
		userRepository.save(user);
	}

}
