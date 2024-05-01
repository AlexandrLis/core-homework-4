public class Transaction {

    public int summa;

    public static void AccountToCreditAccount(Account account, CreditAcciunt creditAcciunt, int summa)throws InsufficientFundsException{
        if(account.getBalance() < summa || summa < 0){
            throw new InsufficientFundsException();
        }
        account.setBalance(account.getBalance() - summa);
        creditAcciunt.setCreditAcciunt(creditAcciunt.getCreditAcciunt() + summa);
    }

    public static void AccountToDebitAccount(Account account, DebitAccount debitAccount, int summa)throws InsufficientFundsException{
        if(account.getBalance() < summa || summa < 0){
            throw new InsufficientFundsException();
        }
        account.setBalance(account.getBalance() - summa);
        debitAccount.setDebitAccount(debitAccount.getDebitAccount() + summa);
    }

    public static void CreditAccountToAccount(Account account, CreditAcciunt creditAcciunt, int summa)throws InsufficientFundsException{
        if(creditAcciunt.getCreditAcciunt() < summa || summa < 0){
            throw new InsufficientFundsException();
        }
        account.setBalance(account.getBalance() + summa);
        creditAcciunt.setCreditAcciunt(creditAcciunt.getCreditAcciunt() - summa);
    }

    public static void CreditAccountToDebitAccount(CreditAcciunt creditAcciunt, DebitAccount debitAccount, int summa)throws InsufficientFundsException{
        if(creditAcciunt.getCreditAcciunt() < summa || summa < 0){
            throw new InsufficientFundsException();
        }
        debitAccount.setDebitAccount(debitAccount.getDebitAccount() + summa);
        creditAcciunt.setCreditAcciunt(creditAcciunt.getCreditAcciunt() - summa);
    }

    public static void DebitAccountToAccount(Account account, DebitAccount debitAccount, int summa)throws InsufficientFundsException{
        if(debitAccount.getDebitAccount() < summa || summa < 0){
            throw new InsufficientFundsException();
        }
        account.setBalance(account.getBalance() + summa);
        debitAccount.setDebitAccount(debitAccount.getDebitAccount() - summa);
    }

    public static void DebitAccountToCreditAcciunt(DebitAccount debitAccount, CreditAcciunt creditAcciunt, int summa)throws InsufficientFundsException{
        if(debitAccount.getDebitAccount() < summa || summa < 0){
            throw new InsufficientFundsException();
        }
        debitAccount.setDebitAccount(debitAccount.getDebitAccount() - summa);
        creditAcciunt.setCreditAcciunt(creditAcciunt.getCreditAcciunt() + summa);
    }


}
