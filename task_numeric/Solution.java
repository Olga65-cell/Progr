package task_numeric;

import task_numeric.IllegalInputException;

import java.util.*;

public class Solution {

    private static String [] numerals ={"M", "CM", "D", "CD", "C","XC", "L", "XL", "X", "IX","V", "IV", "I"};
    private static int [] numeralValues ={1000, 900, 500, 400, 100,90, 50, 40, 10, 9, 5, 4, 1};
    private static Character [] digits = {'M', 'C', 'D', 'L', 'X', 'I', 'V'};
    private static String [] helpDig = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static HashMap<String, Integer> digit;

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

    static int romanToInt(String s) {
        int num=0,last=0,now = -1;
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case 'i':
                case 'I': now=1;break;
                case 'v':
                case 'V': now=5;break;
                case 'x':
                case 'X': now=10;break;
                case 'l':
                case 'L': now=50;break;
                case 'c':
                case 'C': now=100;break;
                case 'd':
                case 'D': now=500;break;
                case 'm':
                case 'M': now=1000;break;
                default:break;
            }

            if(last!=0 && last<now)
                num -= 2*last;
            num += now;
            last = now;
        }
        return num;
    }

    static boolean isDecimal(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    static boolean isRoman(String str){
        return digit.containsKey(str);
    }

    private static int getAns(String[] data, int val1, int ans, int val2) throws IllegalInputException {
        String op = data[1];
        switch (op){
            case "+":
                ans = val1 + val2;
                break;
            case "-":
                ans = val1 - val2;
                break;
            case "*":
                ans = val1 * val2;
                break;
            case "/":
                ans = val1 / val2;
                break;
            default: throw new IllegalInputException();
        }
        return ans;
    }

    public static void main(String[] args) throws IllegalInputException {
        digit = new HashMap<>();
        int cnt = 0;
        for (String str : helpDig){
            cnt++;
            digit.put(str, cnt);
        }
        Scanner in = new Scanner(System.in);
        String [] data = in.nextLine().split(" ");
        if(data.length != 3){
            throw new IllegalInputException();
        }
        else if(isRoman(data[0]) && isRoman(data[2])){
            if(romanToInt(data[0]) >= 0 && romanToInt(data[0]) <= 9 &&
                    romanToInt(data[2]) >= 0
                    && romanToInt(data[2]) <= 9
            ){
                Roman val1 = new Roman(data[0]);
                Roman val2 = new Roman(data[2]);
                String op = data[1];
                switch (op){
                    case "+":
                        val1.add(val2);
                        break;
                    case "-":
                        val1.sub(val2);
                        break;
                    case "*":
                        val1.mul(val2);
                        break;
                    case "/":
                        val1.div(val2);;
                        break;
                    default: throw new IllegalInputException();
                }
                System.out.println(val1);
            }
        }else if(isDecimal(data[0]) && isDecimal(data[2])){
            Decimal val1 = new Decimal(data[0]);
            Decimal val2 = new Decimal(data[2]);
            String op = data[1];
            switch (op){
                case "+":
                    val1.add(val2);
                    break;
                case "-":
                    val1.sub(val2);
                    break;
                case "*":
                    val1.mul(val2);
                    break;
                case "/":
                    val1.div(val2);;
                    break;
                default: throw new IllegalInputException();
            }
            System.out.println(val1);
        }
        else throw new IllegalInputException();
    }

}
