import java.util.*;
import java.lang.StringBuilder;
/*
создать HashMap у которого ключ - логин, значение - пароль.
На старте заполнить тремя элементами.
создать 3 ошибки(1. Для проверки арифметического оператора,
2. Для проверки логина 3. Для проверки аутентификации)
первая проверка на аутентификацию,
в сканере вводим логин - проверяем, вводим пароль - проверяем
если ошибка, то выбрасывем exception
проверяем арифметический оператор(+ - * /)
 */
public class Main {

    static List<String> operatorList = new ArrayList<>();
    static Map<String, String> user = new HashMap<>(3);
    static void checkOperator(String operator) {
        if (!operatorList.contains(operator)) {
            throw new InvalidExeption("введенный операнд не верный");
        }
    }
    static void checkPassword(String userlogin,String password) {
        if ((!password.equals(user.get(userlogin))))  {
            throw new InvalidExeption("введенный вами  пароль или логин не верный");
        }
    }
    static int checkNumbers(int num){
        if (num>10){
            throw new InvalidExeption("введите число меньше 10");
        }return num;
    }
    static String builder(int first, String operation, int second) {
        StringBuilder builder = new StringBuilder();
        builder.append(first);
        builder.append(operation);
        builder.append(second);
        return builder.toString();
    }
    static String builder1(int sum) {
        StringBuilder builder = new StringBuilder();
        builder.append(sum);
        return builder.toString();
    }
    public static void main(String[] args)  {
        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("*");
        operatorList.add("/");

        user.put("MTuulu", "Kyrgyzstan+996");
        user.put("AdylTuulu", "KG03222");
        user.put("EdilTuulu", "Bishkek+996");


        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>(100);
        try {
            System.out.println("введите логин: ");
            String userLogin = scanner.next();
            String password = scanner.next();
            checkPassword(userLogin,password);
        }
        catch (InvalidExeption e){
            e.printStackTrace();
        }
        int first;
        String operation;
        int second;
        int sum;
        for (int i = 0; i < 2; i++) {
            try {
                System.out.println("введите первое число: ");
                first = scanner.nextInt();
                checkNumbers(first);
                System.out.println("введите операцию: ");
                operation = scanner.next();
                checkOperator(operation);
                System.out.println("введите второе число: ");
                second = scanner.nextInt();
                checkNumbers(second);
                if (map.containsKey(builder(first, operation, second))) {
                    System.out.println(map.get(builder(first, operation, second)));
                    System.out.println(map);
                }
                switch (operation) {
                    case "+":
                        sum = first + second;
                        map.put(builder(first, operation, second), String.valueOf(sum));
                        break;
                    case "-":
                        sum = first - second;
                        map.put(builder(first, operation, second), String.valueOf(sum));
                        break;
                    case "*":
                        sum = first * second;
                        map.put(builder(first, operation, second), String.valueOf(sum));
                        break;

                    case "/":
                        sum = first / second;
                        map.put(builder(first, operation, second), String.valueOf(sum));
                        break;
                }
            } catch (InvalidExeption e) {
                e.printStackTrace();
            }
        }
    }
}