package gmail.kazzimir.bortnik.sting.authorizationserver.service.impl;

import gmail.kazzimir.bortnik.sting.authorizationserver.repository.impl.AccountRepository;
import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Account;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.UserService;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.Converter;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.ExceptionFactory;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception.CustomException;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception.CustomRuntimeException;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.AccountDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.messageexception.MessageException.ERROR_ACCOUNT_DOES_NOT_EXIST;
import static gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.messageexception.MessageException.createMessage;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final AccountRepository accountRepository;
    private final ExceptionFactory<CustomRuntimeException, CustomException> exceptionFactory;
    private final Converter<AccountDTO, Account> accountConverter;

    @Autowired
    public UserServiceImpl(AccountRepository accountRepository,
                           ExceptionFactory<CustomRuntimeException,
                                   CustomException> exceptionFactory,
                           Converter<AccountDTO, Account> accountConverter) {
        this.accountRepository = accountRepository;
        this.exceptionFactory = exceptionFactory;
        this.accountConverter = accountConverter;
    }

    @Override
    @Transactional
    public AccountDTO getAccountByEmail(String email) {
        logger.info("Receiving an Account by email := {}", email);
        Optional<Account> accountOptional = accountRepository.findByEmail(email);
        Account account = accountOptional.orElseThrow(() ->
                exceptionFactory.createRuntimeException(
                        createMessage(ERROR_ACCOUNT_DOES_NOT_EXIST, email), UserServiceImpl.class, HttpStatus.NOT_FOUND
                )
        );
        return accountConverter.toDTO(account);
    }
}
