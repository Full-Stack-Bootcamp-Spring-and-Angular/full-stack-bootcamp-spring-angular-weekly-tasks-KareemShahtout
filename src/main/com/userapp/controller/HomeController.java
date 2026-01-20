package main.com.userapp.controller;

import main.com.userapp.dao.Database;
import main.com.userapp.models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private Database database;
    private UserData userData;

    @Autowired
    public HomeController(Database database, UserData userData) {
        this.database = database;
        this.userData = userData;
    }

    @RequestMapping("/")
    public String showFormPage(Model model) {

        model.addAttribute("user_data", userData);
        return "userFormPage";
    }

    @RequestMapping("/submitUserData")
    public String ShowSubmitPage() {
        return "submitPage";
    }

}
