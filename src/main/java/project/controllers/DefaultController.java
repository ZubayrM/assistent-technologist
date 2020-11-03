package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import project.Service.UserService;
import project.dto.respons.UserProfilDto;
import project.dto.respons.UserRegDto;
import project.dto.respons.list.AllNumberListDto;
import project.model.Enums.Position;
import project.model.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String init (Model model){
        User user = userService.getUser();
        user.setPosition(Position.CHIEF_OF_TB);
        userService.saveUser(user);

        if (user!= null) {
            model.addAttribute("name", user.getUsername());
            model.addAttribute("id", user.getId());
        }
        AllNumberListDto userList = userService.getUserList();
        model.addAttribute("user_list", userList);

        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login/error")
    public String login(Model model){
        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/regist")
    public String registration(UserRegDto dto){
        return "regist";
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id, Model model){
        User auth = userService.getUser();
        boolean my;
        my = !auth.getId().equals(id);
        model.addAttribute("my", my);
        UserProfilDto u = userService.getUserById(id);
        model.addAttribute("user", u);
        return "user";
    }

    @GetMapping("/logout")
    public void exit(HttpServletRequest request){
        userService.logout(request);
    }



}
