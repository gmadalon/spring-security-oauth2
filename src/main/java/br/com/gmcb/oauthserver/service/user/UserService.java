package br.com.gmcb.oauthserver.service.user;

import br.com.gmcb.oauthserver.domainobject.User;

public interface UserService
{
    User findByEmail(String email);
    void addUser(String email, String password);
}
