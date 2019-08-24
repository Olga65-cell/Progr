package task_numeric;

public class Decimal {

    int value;

    public Decimal(String value) {
        if(isNum(value)) {
            this.value = Integer.parseInt(value);
        }
        else try {
            throw new IllegalInputException();
        } catch (IllegalInputException e) {
            e.printStackTrace();
        }
    }

    private boolean isNum(String value) {
        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i) < '0' || value.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    void add(Decimal decimal){
        value += decimal.value;
    }

    void sub(Decimal decimal){
        value -= decimal.value;
    }

    void mul(Decimal decimal){
        value *= decimal.value;
    }

    void div(Decimal decimal){
        value /= decimal.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
