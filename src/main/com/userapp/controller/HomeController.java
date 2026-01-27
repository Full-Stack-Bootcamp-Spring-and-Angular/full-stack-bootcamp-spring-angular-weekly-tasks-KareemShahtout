package main.com.userapp.controller;

import lombok.AllArgsConstructor;
import main.com.userapp.dao.Database;
import main.com.userapp.model.UserModel;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class HomeController {

    private final Database database;

    @RequestMapping("/")
    public String showFormPage(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "userForm";
    }

    @RequestMapping("/submitUserData")
    public String submitUserData(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }

        if (database.insertUser(userModel)) {
            String message = "Data Submitted Successfully!";
            model.addAttribute("userModel", userModel);
            model.addAttribute("message", message);
            return "submitPage";
        }
        return "userForm";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);

    }
}
