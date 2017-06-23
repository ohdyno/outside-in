package com.capex.backlog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculateCapitalizableAmountControllerTest {
    @Mock
    CapitalizationAlgorithm algorithm;

    @InjectMocks
    CalculateCapitalizableAmountController subject;

    @Test
    public void calculate_usesTheFormParamsAndAppliesTheCalculation() {
        when(algorithm.calculate(50000, 84)).thenReturn(42000);

        int spend = 50000;
        int percentage = 84;
        Model pageData = new ExtendedModelMap();

        subject.calculate(spend, percentage, pageData);

        Integer capitalizableAmount = (Integer) pageData.asMap().get("capitalizable_amount");
        assertThat(capitalizableAmount).isEqualTo(42000);
    }

    @Test
    public void calculate_whenSuccessful_rendersTheResultsPage() {
        String renderedPage = subject.calculate(0, 0, new ExtendedModelMap());

        assertThat(renderedPage).isEqualTo("result");
    }

}