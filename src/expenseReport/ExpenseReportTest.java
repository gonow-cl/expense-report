package expenseReport;

import expense.Expense;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static expense.Expense.Type.BREAKFAST;
import static expense.Expense.Type.CAR_RENTAL;
import static expense.Expense.Type.DINNER;
import static org.junit.Assert.assertEquals;

public class ExpenseReportTest {
  private ExpenseReport reporter;
  private MockReportPrinter printer = new MockReportPrinter();
  private Locale defaultLocale;

  @Before
  public void setUp() {
    printer = new MockReportPrinter();
    reporter = new ExpenseReport();
    defaultLocale = Locale.getDefault();
    Locale.setDefault(new Locale("en", "US"));
  }

  @After
  public void tearDown() {
    Locale.setDefault(defaultLocale);
  }

  @Test
  public void printEmpty() {
    reporter.print(printer);

    assertEquals(
        "Expenses 9/12/2002\n" +
            "\n" +
            "Meal expenses $0.00\n" +
            "Total $0.00",
        printer.getText());
  }

  @Test
  public void fullReport() throws Exception {
    reporter.addExpense(new Expense(BREAKFAST, 1000));
    reporter.addExpense(new Expense(BREAKFAST, 1001));
    reporter.addExpense(new Expense(DINNER, 5000));
    reporter.addExpense(new Expense(DINNER, 5001));
    reporter.addExpense(new Expense(CAR_RENTAL, 30000));
    reporter.print(printer);

    assertEquals(
        "Expenses 9/12/2002\n" +
            " \tBreakfast\t$10.00\n" +
            "X\tBreakfast\t$10.01\n" +
            " \tDinner\t$50.00\n" +
            "X\tDinner\t$50.01\n" +
            " \tCar Rental\t$300.00\n" +
            "\n" +
            "Meal expenses $120.02\n" +
            "Total $420.02",
        printer.getText());
  }
}
