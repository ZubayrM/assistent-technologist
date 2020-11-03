package project.controllers.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import project.Service.UserService;
import project.dto.respons.UserRegDto;
import project.model.Enums.Position;
import project.model.User;

import java.util.Objects;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public ModelAndView regist(String name, String password, String code, String number, String position, String shop){
        User u = new User();
        u.setNumber(number);
        u.setUsername(name);
        u.setPassword(password);
        u.setPosition(Position.valueOf(position.toUpperCase()));
        u.setCode(code);
        u.setShop(shop);
        userService.saveUser(u);

        return new ModelAndView("redirect:/");
    }





}
