package com.example.networktest;

public class QuerSum {
    private String input;
    private int sum;


    public QuerSum(String input) {
    this.input = input;
    this.sum = getDigit(0);
    }

    public void calculateQuerSum(){
        for (int i = 1;i<input.length();i++){
           int digit = getDigit(i);

           if (i % 2 == 0) {
               System.out.println("sum = "+sum+"-"+digit);
                sum -= digit;

           } else {
               System.out.println("sum = "+sum+"+"+digit);
                sum += digit;
           }
        }
    }

    public int getDigit(int index){
        char c = input.charAt(index);
        int digit = Character.getNumericValue(c);
        return digit;
    }

    public int getSum() {
        return sum;
    }
}
