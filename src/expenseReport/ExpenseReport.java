package expenseReport;

import java.util.ArrayList;
import java.util.List;

import static expenseReport.Expense.Type.BREAKFAST;
import static expenseReport.Expense.Type.DINNER;


public class ExpenseReport {
    private List<Expense> expenses = new ArrayList<Expense>();
    private final String date = "9/12/2002";
    private String name;
    private int mealExpenses = 0;

    public void printReport(ReportPrinter printer) {
        int total = 0;

        printer.print("Expenses " + date + "\n");

        for (Expense expense : expenses) {

            validateIfMeal(expense);

            setNameExpense(expense);

            printer.print(String.format("%s\t%s\t$%.02f\n",
                    (validateValueMeal(expense)),
                    name, expense.amount / 100.0));
            total += expense.amount;
        }

        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0));
        printer.print(String.format("\nTotal $%.02f", total / 100.0));
    }

    private String validateValueMeal(Expense expense) {
        if (expense.type == DINNER && expense.amount > 5000
                || expense.type == BREAKFAST && expense.amount > 1000) {
            return ("X");
        } else {
            return (" ");
        }
    }

    private void validateIfMeal(Expense expense) {
        if (expense.type == BREAKFAST || expense.type == DINNER)
            mealExpenses += expense.amount;
    }

    private void setNameExpense(Expense expense) {
        name = "TILT";
        switch (expense.type) {
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
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

}
