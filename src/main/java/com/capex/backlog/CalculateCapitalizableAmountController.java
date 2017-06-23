package com.capex.backlog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculateCapitalizableAmountController {

    private final CapitalizationAlgorithm algorithm;

    public CalculateCapitalizableAmountController(CapitalizationAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @RequestMapping("/result")
    public String calculate(int spend, int percentage, Model pageData) {
        int calculation = this.algorithm.calculate(spend, percentage);
        pageData.addAttribute("capitalizable_amount", calculation);

        return "result";
    }

}
