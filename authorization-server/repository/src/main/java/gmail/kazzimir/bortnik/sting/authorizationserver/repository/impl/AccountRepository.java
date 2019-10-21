package gmail.kazzimir.bortnik.sting.authorizationserver.repository.impl;


import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}