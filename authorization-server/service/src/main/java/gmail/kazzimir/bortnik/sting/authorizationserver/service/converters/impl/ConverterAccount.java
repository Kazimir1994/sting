package gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.impl;

import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Account;
import gmail.kazzimir.bortnik.sting.authorizationserver.repository.model.Role;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.converters.Converter;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.AccountDTO;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.model.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterAccount implements Converter<AccountDTO, Account> {
    private final Converter<RoleDTO, Role> roleConverter;

    @Autowired
    public ConverterAccount(Converter<RoleDTO, Role> roleConverter) {
        this.roleConverter = roleConverter;
    }

    @Override
    public AccountDTO toDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setUsername(account.getEmail());
        accountDTO.setName(account.getUserName());
        accountDTO.setSurname(account.getUserSurname());
        List<RoleDTO> roleDTOS = roleConverter.listToDTO(account.getRoles());
        accountDTO.setRoles(roleDTOS);
        return accountDTO;
    }

    @Override
    public Account fromDTO(AccountDTO accountDTO) {
        throw new UnsupportedOperationException();
    }
}
