package expensereport;

import java.util.ArrayList;
import java.util.List;

import static expensereport.Expense.Type.BREAKFAST;
import static expensereport.Expense.Type.DINNER;

public class ExpenseReport {

    private List<Expense> expenses = new ArrayList<Expense>();

    public void printReport(ReportPrinter printer) {

        int total = 0;
        int mealExpenses = 0;

        printer.print("Expenses " + getDate() + "\n");

        for (Expense expense : expenses) {

            if (expense.getType() == BREAKFAST || expense.getType() == DINNER)
                mealExpenses += expense.getAmount();

            String name = "TILT";
            switch (expense.getType()) {
                case DINNER:
                    name = "Dinner";
                    break;
                case BREAKFAST:
                    name = "Breakfast";
                    break;
                case CAR_RENTAL:
                    name = "Car Rental";
                    break;
            }

            printer.print(String.format("%s\t%s\t$%.02f\n",
                    ((expense.getType() == DINNER && expense.getAmount() > 5000)
                            || (expense.getType() == BREAKFAST && expense.getAmount() > 1000)) ? "X" : " ",
                    name, expense.getAmount() / 100.0));

            total += expense.getAmount();
        }

        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0));
        printer.print(String.format("\nTotal $%.02f", total / 100.0));
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    private String getDate() {
        return "9/12/2002";
    }

}
