/*
Реализовать консольное приложение, которое:
Принимает от пользователя строку вида
text~num
Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Task01_01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        LinkedList<String> myList = new LinkedList<>();
        boolean run = true;

        while(run){
            try {
                System.out.printf("Введите строку в виде 'слово -> пробел -> номер': ");
                String str = myScanner.nextLine();
                String[] split = str.split(" ");
                String text = split[0];
                String numberString = split[1];
                int number = Integer.parseInt(numberString) - 1; 
                if (myList.size() < number + 1){
                    for (int index = myList.size(); index < number + 1; index++) {
                        myList.add(index, null); 

                    }
                }

                if(str.toLowerCase().equals("print " + numberString)) {
                    System.out.println(myList.toString());
                    System.out.println(myList.get(number) + " " + (number + 1));
                    myList.remove(number);
                
                    run = false;
                }
                else {
                    myList.set(number, text);
                }
            
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Введите строку заново!");
            }
        }

        myScanner.close();
        System.out.println(myList.toString());
    }   
}