public class InsufficientFundsException extends Exception{

    public InsufficientFundsException() {
        super();
    }


    @Override
    public String getMessage() {
        return "На вашем балансе недостаточно средств или вы ввели отрицательное значение";
    }
}
