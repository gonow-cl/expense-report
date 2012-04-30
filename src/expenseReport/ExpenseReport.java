package expenseReport;

import java.util.ArrayList;
import java.util.List;

import static expenseReport.Expense.Type.*;


public class ExpenseReport {

  private List<Expense> expenses = new ArrayList<Expense>();
  private int mealExpenses = 0;
  private int totalExpenses = 0;
  private String reportOutPut = "";

    public void printReport(ReportPrinter printer) {

    reportOutPut += "Expenses " + getDate() + "\n";

    for (Expense expense : expenses) {

        switch (expense.type) {

            case DINNER:
            appendExpense("Dinner",expense.amount);
            break;

            case BREAKFAST:
            appendExpense("Breakfast",expense.amount);
            break;

            case CAR_RENTAL:
            appendExpense("Car Rental",expense.amount);
            break;

            default:
            appendExpense("TILT",0);
            break;

        }

    }

    reportOutPut += "\nMeal expenses $" + mealExpenses/100.0;
    reportOutPut += "\nTotal $" + totalExpenses/100.0;

        /*
        printer.print(String.format("%s\t%s\t$%.02f\n",
        (  (expense.type == DINNER && expense.amount > 5000)
        || (expense.type == BREAKFAST && expense.amount > 1000)) ? "X" : " ",
        name, expense.amount / 100.0));



    printer.print(String.format("\nMeal expenses $%.02f",mealExpenses / 100.0 ));
    printer.print(String.format("\nTotal $%.02f", total / 100.0));  */

     printer.print(reportOutPut);

  }

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }

  private String getDate() {
    return "9/12/2002";
  }

  private boolean isMeal(String expense) {
    return (expense == "Dinner" || expense == "Breakfast") ? true : false;
  }

  private void appendExpense(String expense, int amount) {

    if (isMeal(expense)) mealExpenses += amount;
    reportOutPut += ((expense == "Dinner" && amount > 5000) || (expense == "Breakfast" && amount > 1000)) ? "X" : " ";
    reportOutPut += "\t"+expense+"\t$"+amount/100.0+"\n";
    totalExpenses += amount;

  }

}
