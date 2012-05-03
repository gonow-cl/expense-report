package expensereport;

public class Expense {

    public enum Type {

        DINNER {
            @Override
            public String toString() {
                return "Dinner";
            }
        },

        BREAKFAST {
            @Override
            public String toString() {
                return "Breakfast";
            }
        },

        CAR_RENTAL {
            @Override
            public String toString() {
                return "Car Rental";
            }
        }
    }

    private Type type;

    private int amount;

    public Expense(Type type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

}
