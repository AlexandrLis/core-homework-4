import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Account account = new Account(1000);


        do{
            startBalance(account);
        }
        while (!startBalance(account));

        start(account);


    }


    public static boolean startBalance(Account account){
        try{
            balance(account);
        }catch (IllegalArgumentException e){
            System.out.println("Баланс не может быть отрицательным");
            return false;
        }catch (Exception e){
            e.getStackTrace();
            return false;
        }
        return true;
    }


    public static void start(Account account){
        System.out.println("Выберите действие: ");
        System.out.println("1 - пополнить счет");
        System.out.println("2 - снять деньги со счета");
        System.out.println("3 - выход");
        Scanner scanner = new Scanner(System.in);
        String choise = scanner.nextLine();
        switch (choise){
            case "1":
                try{
                    depositMoney(account);
                }catch (IllegalArgumentException e){
                    System.out.println("Невозможно внести отрицательную сумму на счет");
                }catch (Exception e){
                    e.getStackTrace();
                }
                start(account);
            break;

            case "2":
                try{
                    takeMoney(account);
                }catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    e.getStackTrace();
                }
                start(account);
            break;

            case "3":
                System.out.println("До свидания!");
            break;
            default:
                System.out.println("Введите корректное значение от 1 до 3");
                start(account);
            break;
        }
    }



    public static void balance(Account account) throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите начальный баланс счета: ");
        int balance = scanner.nextInt();
        if(balance < 0){
            throw new IllegalArgumentException();
        }
        else {
            account.setBalance(balance);
        }
    }


    public static void depositMoney(Account account) throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите, какую сумму вы хотите внести на счет: ");
        int summa = scanner.nextInt();
        if(summa < 0){
            throw new IllegalArgumentException();
        }
        else{
            account.setBalance(account.getBalance() + summa);
            System.out.printf("Вы внесли %s рублей, баланс вашего счета: " + account.getBalance() + "\n", summa);
        }
    }

    public static void takeMoney(Account account) throws InsufficientFundsException{
        int[] array = new int[1];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите, какую сумму вы хотите снять со счета: ");
        int summa = scanner.nextInt();
        array[0] = summa;
        if(summa > account.getBalance() || summa < 0){
            throw new InsufficientFundsException();
        }
        else{
            account.setBalance(account.getBalance() - summa);
            System.out.printf("Вы сняли со счета %s рублей, баланс вашего счета: " + account.getBalance() + "\n", summa);
        }
    }
}
