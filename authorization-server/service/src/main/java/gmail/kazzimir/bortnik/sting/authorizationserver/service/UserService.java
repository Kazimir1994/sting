package gmail.kazzimir.bortnik.sting.authorizationserver.service;

import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.AccountDTO;

public interface UserService {
    AccountDTO getAccountByEmail(String email);
}
