package gmail.kazzimir.bortnik.sting.authorizationserver.service.impl;

import gmail.kazzimir.bortnik.exceptionfactory.impl.ExceptionGeneratorUtils;
import gmail.kazzimir.bortnik.sting.authorizationserver.repository.impl.AccountRepository;
import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Account;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.UserService;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.Converter;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static gmail.kazzimir.bortnik.exceptionfactory.modelexception.utils.MessageExceptionUtils.createMessage;
import static gmail.kazzimir.bortnik.sting.authorizationserver.service.messageexception.MessageException.ERROR_ACCOUNT_DOES_NOT_EXIST;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final AccountRepository accountRepository;
    private final Converter<AccountDTO, Account> accountConverter;

    @Autowired
    public UserServiceImpl(AccountRepository accountRepository,
                           Converter<AccountDTO, Account> accountConverter) {
        this.accountRepository = accountRepository;
        this.accountConverter = accountConverter;
    }

    @Override
    @Transactional
    public AccountDTO getAccountByEmail(String email) {
        logger.info("Receiving an Account by email := {}", email);
        Optional<Account> accountOptional = accountRepository.findByEmail(email);
        Account account = accountOptional.orElseThrow(() ->
                ExceptionGeneratorUtils.createRuntimeException(
                        createMessage(ERROR_ACCOUNT_DOES_NOT_EXIST, email), HttpStatus.NOT_FOUND
                )
        );
        return accountConverter.toDTO(account);
    }
}
