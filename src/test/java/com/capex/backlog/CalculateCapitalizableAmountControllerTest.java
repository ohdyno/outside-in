package com.capex.backlog;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateCapitalizableAmountControllerTest {

    @Test
    public void calculate_usesTheFormParamsAndAppliesTheCalculation() {
        CalculateCapitalizableAmountController subject = new CalculateCapitalizableAmountController();

        int spend = 50000;
        int percentage = 84;
        Model pageData = new ExtendedModelMap();
        subject.calculate(spend, percentage, pageData);

        Integer capitalizableAmount = (Integer) pageData.asMap().get("capitalizable_amount");
        assertThat(capitalizableAmount).isEqualTo(42000);
    }

    @Test
    public void calculate_whenSuccessful_rendersTheResultsPage() {
        CalculateCapitalizableAmountController subject = new CalculateCapitalizableAmountController();

        String renderedPage = subject.calculate(0, 0, new ExtendedModelMap());

        assertThat(renderedPage).isEqualTo("result");
    }

}