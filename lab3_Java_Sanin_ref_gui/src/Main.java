import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Введите длину массива: ");
        //Пока значение не будет корректным, то есть типа int, будет отрабатывать цикл (обработка исключений)
        while (!input.hasNextInt()) {
            System.out.println("Пожалуйста, введите корректное значение:");
            input.next();
        }
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size

        int[] array = new int[size]; // Создаём массив int размером в size
        System.out.println("Введите элементы массива:");
        //Пройдёмся по всему массиву, заполняя его
        for (int i = 0; i < size; i++) {
            //Пока значение не будет корректным, то есть типа int, будет отрабатывать цикл (обработка исключений)
            while (!input.hasNextInt()) {
                System.out.println("Пожалуйста, введите корректное значение:");
                input.next();
            }
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }

        System.out.println(Arrays.toString(array) + " --- inserted array elements");

        sortByCount(array);
        System.out.println(Arrays.toString(array) + " --- sorted array elements");
    }

    public static void sortByCount(int[] array) {

        //Найдём максимальное число в массиве
        int k = array[0]; //Максимальное число в массиве
        for (int i = 1; i < array.length; i++) {
            if (array[i] > k) {
                k = array[i];
            }
        }

        //Создадим новый массив длины k, по умолчанию наполненный нулями
        int[] tempArray = new int[k + 1];

        //Запишем в него количество вхождений каждого элемента поиндексно
        for (int value : array) {
            ++tempArray[value];
        }

        //Вставим элементы в исходный массив
        int b = 0;
        for (int i = 0; i < k + 1; ++i){
            for (int j = 0; j < tempArray[i]; ++j) {
                array[b++] = i;
            }
        }
    }
}

