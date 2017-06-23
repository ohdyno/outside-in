package com.capex.backlog;

import org.springframework.stereotype.Component;

@Component
public class CapitalizationAlgorithm {
    public int calculate(int spend, int capitalizablePercentage) {
        return spend * capitalizablePercentage / 100;
    }
}
