package com.akhi.math.mathassignment.ruleengine;

import org.springframework.stereotype.Component;

/**
 * RuleEngine class. Abstracts the rules that need to be run on the data
 * All rules are currently housed inside the class, however, there's a possiblity of moving the actual rules in drools
 */
@Component
public class RuleEngine {

    /**
     * Runs the Fizz rule on passed data attribute
     *
     * @param number the number on which rule should be rul
     * @param ruleType the rule type that needs to be run - TYPE_1 or TYPE_2
     * @return boolean value on whether the rule was satisfied
     */
    public boolean isFizz(int number, RuleType ruleType) {
        return number%3 == 0 || (ruleType == RuleType.TYPE_2 && (""+ number).contains("3"));
    }
    /**
     * Runs the Buzz rule on passed data attribute
     *
     * @param number the number on which rule should be rul
     * @param ruleType the rule type that needs to be run - TYPE_1 or TYPE_2
     * @return boolean value on whether the rule was satisfied
     */
    public boolean isBuzz(int number, RuleType ruleType) {
        return number%5 == 0 || (ruleType == RuleType.TYPE_2 && (""+ number).contains("5"));
    }
}
