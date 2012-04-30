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

    printer.print(reportOutPut);

  }

  public void addExpense(Expense expense) {
    expenses.add(expense);
  }

  private String getDate() {
    return "9/12/2002";
  }

  private void appendExpense(String expenseType, int expenseAmount) {
    mealExpenses = (expenseType == "Dinner" || expenseType == "Breakfast") ? mealExpenses+expenseAmount : mealExpenses;
    reportOutPut += ((expenseType == "Dinner" && expenseAmount > 5000) || (expenseType == "Breakfast" && expenseAmount > 1000)) ? "X" : " ";
    reportOutPut += "\t"+expenseType+"\t$"+expenseAmount/100.0+"\n";
    totalExpenses += expenseAmount;
  }

}
