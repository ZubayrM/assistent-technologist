package project.Service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.Repositories.UserRepo;
import project.dto.respons.UserProfilDto;
import project.dto.respons.UserRegDto;
import project.dto.respons.list.AllNumberListDto;
import project.dto.respons.list.NumberToUsersListDto;
import project.dto.respons.list.UserDto;
import project.model.Enums.Position;
import project.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authentication;

    public Boolean saveUser(User u){
        userRepo.save(u);
        return true;

    }


    public AllNumberListDto getUserList() {
        List<User> all = userRepo.findAll();
        AllNumberListDto allNumberListDto = new AllNumberListDto();
        Set<String> numberList = new HashSet<>();
        for (User u: all){
            numberList.add(u.getNumber());
        }
        for (String number: numberList){
            NumberToUsersListDto numberToUsersListDto = new NumberToUsersListDto();
            numberToUsersListDto.setNumber(number);
            for (User u: all){
                if (number!= null) {
                    if (u.getNumber().equals(number)) {
                        if (u.getPosition().equals(Position.CHIEF_OF_TB))
                            numberToUsersListDto.setChief(new UserDto(u.getId(), u.getUsername()));
                        else numberToUsersListDto.getList().add(new UserDto(u.getId(), u.getUsername()));
                    }
                }
            }
            allNumberListDto.getAllList().add(numberToUsersListDto);
        }

        return allNumberListDto;
    }

    public User getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return (User) principal;
    }

    public UserProfilDto getUserById(Long id) {
        Optional<User> byId = userRepo.findById(id);
        UserProfilDto dto = null;
        if (byId.isPresent()){
            User u = byId.get();
             dto = UserProfilDto.builder()
                    .name(u.getUsername())
                    .shop(u.getShop())
                    .number(u.getNumber())
                    .position(u.getPosition()).build();
        }
        return dto;
    }

    @SneakyThrows
    public void logout(HttpServletRequest request) {
        request.logout();
        request.getSession(false);
    }

    public void registration(UserRegDto dto) {

    }
}
