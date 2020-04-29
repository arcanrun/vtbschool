package vtb.supertask02;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    SQLHandler sqlHandler;

    Bank(SQLHandler sqlHandler) {
        this.sqlHandler = sqlHandler;
        this.sqlHandler.connect();
    }

    public void getSumOperationsByDate(int idClient, String date) {
        List<Double> res = new ArrayList<>();
        res = sqlHandler.getOperationsByDate(idClient, date);
        if (res.size() == 0) {
            System.out.println("Values not found");
        } else {
            double sum = 0;
            for (Double d : res) {
                sum += d;
            }
            System.out.println("Client: " + idClient + " has sum on date " + date + "--> " + sum);
        }
    }

    public void getOperations(int idClient) {
        List<String> response = sqlHandler.getOperationsById(idClient);
        if (response.size() == 0) {
            System.out.println("Values not found");
        } else {
            System.out.printf("%s %10s %8s %12s", "Date", "From", "To", "Amount");
            System.out.println();
            for (String s : response) {
                System.out.println(s);
            }
        }


    }
}
