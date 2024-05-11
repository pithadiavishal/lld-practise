package lld.splitwise.expense;


import lld.splitwise.expense.split.EqualExpenseSplit;
import lld.splitwise.expense.split.ExpenseSplit;
import lld.splitwise.expense.split.PercentageExpenseSplit;
import lld.splitwise.expense.split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
