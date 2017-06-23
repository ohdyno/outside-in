package com.capex.backlog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    @RequestMapping("/calculator")
    public String render() {
        return "calculator";
    }

    @RequestMapping("/result")
    public String calculate(int spend, int percentage, Model pageData) {
        pageData.addAttribute("capitalizable_amount", spend*percentage/100);

        return "result";
    }

}
