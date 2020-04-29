package vtb.supertask02;

public class Main {
    public static void main(String[] args) {
        SQLHandler sqlHandler = new SQLHandler();
        Bank bank = new Bank(sqlHandler);
        bank.getSumOperationsByDate(1, "2020-01-01");
        bank.getOperations(1);
    }
}
