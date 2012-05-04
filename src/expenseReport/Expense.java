package expenseReport;

public class Expense {

    public enum Type {DINNER, BREAKFAST, CAR_RENTAL;};

    private Type type;
    private int amount;

  public Expense(Type type, int amount) {
      this.setType(type);
      this.setAmount(amount);

  }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}


