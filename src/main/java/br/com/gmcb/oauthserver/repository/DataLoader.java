package br.com.gmcb.oauthserver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.gmcb.oauthserver.domainobject.Role;
import br.com.gmcb.oauthserver.service.user.UserService;

@Component
public class DataLoader implements ApplicationRunner {

    private UserService userService;
    
    private RoleRepository roleRepository;

    @Autowired
    public DataLoader(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    public void run(ApplicationArguments args) {
    	roleRepository.save(Role.builder().name("ADMIN").build());
    	roleRepository.save(Role.builder().name("CUSTOMER").build());
    	
    	userService.addUser("admin@admin.com", "changeyourpassword");
    	
    
    }
}