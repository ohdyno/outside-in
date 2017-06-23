package com.capex.backlog;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CapitalizationAlgorithmTest {

    @Test
    public void calculate_byMultiplyingTheSpendWithThePercentage_youGetTheCapitalizablePortionOfTheSpend() {
        CapitalizationAlgorithm subject = new CapitalizationAlgorithm();

        int spend = 200;
        int percentage = 84;
        int capitalizablePortionOfTheSpend = subject.calculate(spend, percentage);

        assertThat(capitalizablePortionOfTheSpend).isEqualTo(168);
    }

    @Test
    public void calculate_byMultiplyingTheSpendWithThePercentage_youGetTheCapitalizablePortionOfTheSpend_roundTwo() {
        CapitalizationAlgorithm subject = new CapitalizationAlgorithm();

        int spend = 100;
        int percentage = 76;
        int capitalizablePortionOfTheSpend = subject.calculate(spend, percentage);

        assertThat(capitalizablePortionOfTheSpend).isEqualTo(76);
    }

}