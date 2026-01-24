package main.com.userapp.controller;

import lombok.AllArgsConstructor;
import main.com.userapp.dao.Database;
import main.com.userapp.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    private final Database database;

    @RequestMapping("/")
    public String ShowFormPage(Model model) {
        model.addAttribute("userData", new UserData());
        return "formPage";
    }

    @RequestMapping("/submitPage")
    public String ShowSubmitPage(@ModelAttribute("userData") UserData userData, Model model) {
        boolean success = database.submitUser(userData);
        if (success) {
            model.addAttribute("message", "Data Submitted Successfully!");
            model.addAttribute("submittedUser", userData);
        } else {
            model.addAttribute("message", "Failed to submit data. Please try again.");
        }
        return "submitPage";
    }
}
