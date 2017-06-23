package com.capex.backlog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorRenderingController {

    @RequestMapping("/calculator")
    public String render() {
        return "calculator";
    }

}
