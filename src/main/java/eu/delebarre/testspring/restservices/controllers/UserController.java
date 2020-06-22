package eu.delebarre.testspring.restservices.controllers;

import eu.delebarre.testspring.restservices.model.User;
import eu.delebarre.testspring.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("/")
//    public String index(Model model){
//        model.addAttribute("users",userService.findAll());
//        return "users/users";
//    }

    @RequestMapping({"/users", "/"})
    public String getAllUsers(Model model) {

        model.addAttribute("users", userService.findAll());
        return "users/users";
    }

    @RequestMapping("/users/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable UUID id) {
        Optional<User> userToDelete = Optional.ofNullable(this.getUserById(id));
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/user/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/user/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") UUID id) {
        ModelAndView mav = new ModelAndView("users/editUser");
        User user = userService.getUserById(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value = "/user/create")
    public String showCreateForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "users/createUser";
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) { //@RequestBody String userName) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        userService.addUser(newUser);//new User(user.getFirstName(), user.getLastName()));
        return "redirect:/";
    }

}
