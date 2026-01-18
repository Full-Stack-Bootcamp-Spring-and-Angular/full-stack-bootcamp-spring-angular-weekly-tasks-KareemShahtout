package main.com.agecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showFormPage() {
        return "formPage";
    }

    @RequestMapping("/agePage")
    public String showAgePage(@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("day") String day, Model model) {

        LocalDate birthDate = LocalDate.of(Integer.parseInt(year),
                                           Integer.parseInt(month),
                                           Integer.parseInt(day));

        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);

        model.addAttribute("year", age.getYears());
        model.addAttribute("month", age.getMonths());
        model.addAttribute("day", age.getDays());

        return "agePage";
    }
}
