package main.com.agecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showFormPage() {
        return "formPage";
    }

    @RequestMapping("/agePage")
    public String showAgePage(HttpServletRequest request, Model model) {
        int year = Integer.parseInt(request.getParameter("year"));
        int day = Integer.parseInt(request.getParameter("day"));
        int month = Integer.parseInt(request.getParameter("month"));

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);

        model.addAttribute("year", age.getYears());
        model.addAttribute("month", age.getMonths());
        model.addAttribute("day", age.getDays());

        return "agePage";
    }
}
