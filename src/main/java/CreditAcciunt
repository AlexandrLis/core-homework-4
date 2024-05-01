import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Account account = new Account();
        CreditAcciunt creditAcciunt = new CreditAcciunt();
        DebitAccount debitAccount = new DebitAccount();
        int startSumma = startBalance(account);
        while (startSumma <= 0){
            startBalance(account);
            startSumma = startBalance(account);
        }

//        do{
//            startBalance(account);
//        }
//        while (!startBalance(account));

        start(account, creditAcciunt, debitAccount);


    }


    public static int startBalance(Account account){
        try{
            int balance = balance(account);
            return balance;
        }catch (IllegalArgumentException e){
            System.out.println("Баланс не может быть отрицательным");
        }catch (Exception e){
            e.getStackTrace();
        }
        return 0;
    }


    public static void start(Account account, CreditAcciunt creditAcciunt, DebitAccount debitAccount){
        System.out.println("Выберите действие: ");
        System.out.println("1 - пополнить счет");
        System.out.println("2 - снять деньги со счета");
        System.out.println("3 - перевести деньги между счетами");
        System.out.println("4 - баланс Account");
        System.out.println("5 - баланс CreditAccount");
        System.out.println("6 - баланс DebitAccount");
        System.out.println("7 - выход");
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
                start(account, creditAcciunt, debitAccount);
            break;

            case "2":
                try{
                    takeMoney(account);
                }catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    e.getStackTrace();
                }
                start(account, creditAcciunt, debitAccount);
            break;

            case "3":
                try{
                    sendMoney(account, creditAcciunt, debitAccount);
                }catch (Exception e){
                    System.out.println("Не удалось перевести деньги");
                }
                start(account, creditAcciunt, debitAccount);
                break;
            case "4":
                System.out.println("Баланс счета Account:");
                System.out.println(account.getBalance());
                start(account, creditAcciunt, debitAccount);
            break;
            case "5":
                System.out.println("Баланс счета CreditAccount:");
                System.out.println(creditAcciunt.getCreditAcciunt());
                start(account, creditAcciunt, debitAccount);
            break;
            case "6":
                System.out.println("Баланс счета DebitAccount:");
                System.out.println(debitAccount.getDebitAccount());
                start(account, creditAcciunt, debitAccount);
            break;
            case "7":
                System.out.println("До свидания!");
            break;
            default:
                System.out.println("Введите корректное значение от 1 до 3");
                start(account, creditAcciunt, debitAccount);
            break;
        }
    }



    public static int balance(Account account) throws IllegalArgumentException{
        System.out.println("Укажите начальный баланс счета: ");
        Scanner scanner = new Scanner(System.in);
        int balance = scanner.nextInt();
        if(balance < 0){
            throw new IllegalArgumentException();
        }
        else {
            account.setBalance(balance);
            return account.getBalance();
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



    public static void sendMoney(Account account, CreditAcciunt creditAcciunt, DebitAccount debitAccount){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите сумму: ");
        int sum = scanner.nextInt();
        System.out.println("Выберите счет списания и счет зачисления: ");
        System.out.println("1 - с Account на CreditAccount");
        System.out.println("2 - с Account на DebitAccount");
        System.out.println("3 - с CreditAccount на Account");
        System.out.println("4 - с CreditAccount на DebitAccount");
        System.out.println("5 - с DebitAccount на Account");
        System.out.println("6 - с DebitAccount на CreditAccount");
        System.out.println("7 - назад");
        int result = scanner.nextInt();
        switch (result){
            case 1:
                try {
                    Transaction.AccountToCreditAccount(account, creditAcciunt, sum);
                    System.out.println("Вы перевели деньги с Account на CreditAccount");
                    System.out.println("Баланс Account: " + account.getBalance());
                    System.out.println("Баланс CreditAccount: " + creditAcciunt.getCreditAcciunt());
                }
                catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }
            break;
            case 2:
                try {
                    Transaction.AccountToDebitAccount(account, debitAccount, sum);
                    System.out.println("Вы перевели деньги с Account на DebitAccount");
                    System.out.println("Баланс Account: " + account.getBalance());
                    System.out.println("Баланс DebitAccount: " + debitAccount.getDebitAccount());
                }
                catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }
            break;
            case 3:
                try {
                    Transaction.CreditAccountToAccount(account, creditAcciunt, sum);
                    System.out.println("Вы перевели деньги с CreditAccount на Account");
                    System.out.println("Баланс Account: " + account.getBalance());
                    System.out.println("Баланс CreditAccount: " + creditAcciunt.getCreditAcciunt());
                }
                catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }
            break;
            case 4:
                try {
                    Transaction.CreditAccountToDebitAccount(creditAcciunt, debitAccount, sum);
                    System.out.println("Вы перевели деньги с CreditAccount на DebitAccount");
                    System.out.println("Баланс CreditAccount: " + creditAcciunt.getCreditAcciunt());
                    System.out.println("Баланс DebitAccount: " + debitAccount.getDebitAccount());
                }
                catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }
            break;
            case 5:
                try {
                    Transaction.DebitAccountToAccount(account, debitAccount, sum);
                    System.out.println("Вы перевели деньги с DebitAccount на Account");
                    System.out.println("Баланс Account: " + account.getBalance());
                    System.out.println("Баланс DebitAccount: " + debitAccount.getDebitAccount());
                }
                catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }
            break;
            case 6:
                try {
                    Transaction.DebitAccountToCreditAcciunt(debitAccount, creditAcciunt, sum);
                    System.out.println("Вы перевели деньги с DebitAccount на CreditAccount");
                    System.out.println("Баланс DebitAccount: " + debitAccount.getDebitAccount());
                    System.out.println("Баланс CreditAccount: " + creditAcciunt.getCreditAcciunt());
                }
                catch (InsufficientFundsException e){
                    System.out.println(e.getMessage());
                }
            break;
            case 7:

            break;
            default:
                System.out.println("Некорректный выбор порядкового номера действия");
                sendMoney(account, creditAcciunt, debitAccount);
            break;
        }
    }
}
