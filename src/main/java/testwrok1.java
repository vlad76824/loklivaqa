import org.jetbrains.annotations.Contract;

public class testwrok1 {

    public static void main(String[] args) {
        int[] arrayTemp1 = {10, 0, 2, -1, 4};  // 1
        int[] arrayTemp2 = {15, 0, 3, -2, 3, -3, -1}; //1
        int[] arrayTemp3 = {-10, -5, 0, 10, 15, 10, 16};  //2
        int[] arrayTemp4 = {-20 , -10 , -18};
        int[] arrayTemp5 = {5 , 10 , -35};  //1
        System.out.println("quantity --> " + solution(arrayTemp1));
        System.out.println("====================================");
        System.out.println("quantity --> " + solution(arrayTemp2));
        System.out.println("====================================");
        System.out.println("quantity --> " + solution(arrayTemp3));
        System.out.println("====================================");
        System.out.println("quantity --> " + solution(arrayTemp4));
        System.out.println("====================================");
        System.out.println("quantity --> " + solution(arrayTemp5));


        int[] clienti = {1, 2,3,4,5,6,7};
        int[] Posilca ={3, 2, 7, 5, 4, 1, 6};

         //System.out.println("максимально число посылок на полке = "+solution_zadanie2(clienti,Posilca ));

        int[] clientArray1 = {3, 2, 4, 5, 1}; //2
        int[] clientArray2 = {1,2,3,4,5};     //0
        int[] clientArray3 = {3, 2, 7, 5, 4, 1, 6}; //4



    }

    public static int solution(int[] temperatures) {
        if(temperatures == null){
            System.out.println("array is null");
            return -1;
        }
        int minN = 2, maxN=10; //100
        if(temperatures.length<2*minN-1 || temperatures.length>2*maxN-1){
            System.out.println("temp length false");
            return -1;
        }
        if((temperatures.length%2 == 0)){
            System.out.println("array even");
            return -1;
        }
        for (int i = 0; i < temperatures.length; i++) {
            if(temperatures[i] <-25 || temperatures[i] > 40){
                System.out.println("40 < temp < -25");
                return -1;
            }
        }

        int counter = 0;
        for (int i = 1; i < temperatures.length; i += 2) {
            int nightTemp = temperatures[i];
            System.out.println(nightTemp);            //  -20  -10  -18       -18 - -10 == -18+10
            if (nightTemp >= temperatures[i - 1] && (Math.abs(temperatures[i + 1] - nightTemp)) <= 5) {
                counter++;
                System.out.println("nightTemp: " + nightTemp);
            } else if (Math.abs((temperatures[i - 1] - nightTemp)) <= 5
                    && (Math.abs(temperatures[i + 1] - nightTemp)) <= 5) {
                counter++;
                System.out.println("nightTemp: " + nightTemp);
            }
        }
        return counter;
    }


    public static int solution_zadanie2(int[] clienti, int[] Posilca ){
        int Rezult_global=0;
        for (int i = 0; clienti[i]<clienti.length; i++) {
            for (int j = 0; Posilca[j]<Posilca.length; j++) {
                int nomer_posilc= clienti[i];//номер клиента равен номеру посылки
                int  Rezult_min=0;
                System.out.println("Posilca[j] = "+Posilca[j]);
                Rezult_min++;// после каждого прохода добавляем в переменную 1 для подсчета количество на полке
                if (Posilca[j]== nomer_posilc ){//сравниваем когда посылка равна получатель
                    if  (  Rezult_global <Rezult_min){
                        Rezult_global = Rezult_min ;// при переборе этого клиенты мы сравниваем что при нем количество товаров на полке равно максимальному значению или нет если до то присваиваем если нет то идём дальше
                        System.out.println("Rezult_min = "+Rezult_min);
                    }

                    int indexToRemove =  j;
                    // Создаем новый массив с длиной на 1 меньше
                    int[] newArray = new int[Posilca.length - 1];

                    // Копируем элементы, пропуская удаляемый индекс
                    for (int b = 0, n = 0; b < Posilca.length; b++) {
                        if (b != indexToRemove) {
                            newArray[n++] = Posilca[b];
                        }

                    }

                    // Заменяем старый массив на новый
                    Posilca = newArray;
                    //убираем этот элемент из массива так как клиент забрал посылку
                    //завершаем цикл и идём дальше к следующему клиенту

                }


            }
            //break ;

        }

        // Ответ : выводи на экран переменную Rezult_global тут мы получаем максимально число посылок на полке

        return Rezult_global;
    }

}