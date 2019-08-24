package task_numeric;

import java.util.HashMap;

public class Roman {
    int value;
    private static String [] helpDig = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static HashMap<String, Integer> digit;
    static {
        digit = new HashMap<>();
        int cnt = 0;
        for (String str : helpDig){
            cnt++;
            digit.put(str, cnt);
        }
    }
    public Roman(String value) {
        if(isRoman(value)) {
            this.value = digit.get(value);
        }
        else try {
            throw new IllegalInputException();
        } catch (IllegalInputException e) {
            e.printStackTrace();
        }
    }

    private boolean isRoman(String value) {
        return digit.containsKey(value);
    }

    void add(Roman decimal){
        value += decimal.value;
    }

    void sub(Roman decimal){
        value -= decimal.value;
    }

    void mul(Roman decimal){
        value *= decimal.value;
    }

    void div(Roman decimal){
        value /= decimal.value;
    }

    private static String [] numerals ={"M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX","V", "IV", "I"};
    private static int [] numeralValues ={1000, 900, 500, 400, 100,90, 50, 40, 10, 9, 5, 4, 1};

    static String intToRoman(int num){
        StringBuilder roman = new StringBuilder();
        for(int i = 0; i < 13; i++){
            while(num >= numeralValues[i]){
                roman.append(numerals[i]);
                num -= numeralValues[i];
            }
        }
        return roman.toString();
    }

    @Override
    public String toString() {
        return intToRoman(value);
    }
}
