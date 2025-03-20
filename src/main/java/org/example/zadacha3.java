package org.example;

public class zadacha3 {
    public static void main(String[] args) {
        int[] priceArray1 = {4, 1, 2, 3};  //6   +4-1+3
        int[] priceArray2 = {1, 2, 3, 3, 2, 1, 5 }; //7  +3 -1 +5
        System.out.println("--> " + solution(priceArray1));

        System.out.println("--> "  );
        System.out.println("--> " + solution(priceArray2));


    }

    public static int solution(int[] pricesArray) {
        int result = 0;
       // int number = 0;
        int maxPrice, minPrice;
        boolean pocepca = true;
        for (int number = 0; number < pricesArray.length-1;   ) {
            if (pocepca ==true)
            {
            for (int i = number; i < pricesArray.length-1; i++) {
                if (pricesArray[i] > pricesArray[i + 1]) {
                    maxPrice = pricesArray[i];
                    result  +=  maxPrice;

                    pocepca=false;
                    number = i;
                    number++;
                    break;
                }
                number++;

            }

            }
            else
            {
            for (int i = number; i < pricesArray.length-1; i++) {
                if (pricesArray[i] < pricesArray[i + 1]) {
                    minPrice = pricesArray[i];
                    result -=  minPrice;

                    pocepca = true;
                    number = i;
                    break;
                }
                number++;

            }


            }

        }

        return result;
    }
}
