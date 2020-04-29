package vtb.supertask02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLHandler {
    private Connection connection;
    private PreparedStatement preparedStatementOperations;
    private PreparedStatement getPreparedStatementOperationsById;

        public void connect(){
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:clients.db");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                preparedStatementOperations = connection.prepareStatement("SELECT operations.amount FROM operations INNER JOIN clients_bank_accounts ON operations.'to' = clients_bank_accounts.bank_account WHERE clients_bank_accounts.client = ? AND operations.date = ?");
                getPreparedStatementOperationsById = connection.prepareStatement("SELECT operations.date,\n" +
                        "        operations.'to',\n" +
                        "        operations.'from',\n" +
                        "        operations.amount FROM operations\n" +
                        "        INNER JOIN \n" +
                        "        clients_bank_accounts ON\n" +
                        "        operations.'from' = clients_bank_accounts.bank_account WHERE clients_bank_accounts.client = ?");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public List<Double> getOperationsByDate(int idClient, String date){
            List<Double> res = new ArrayList<>();
            try {
                preparedStatementOperations.setInt(1,idClient);
                preparedStatementOperations.setString(2,date);
                ResultSet rs = preparedStatementOperations.executeQuery();
                while(rs.next()){
                    res.add((double)rs.getInt(1));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return res;
        }

    public List<String> getOperationsById(int idClient){
            List<String> res = new ArrayList<>();
        try {
            getPreparedStatementOperationsById.setInt(1,idClient);
            ResultSet rs = getPreparedStatementOperationsById.executeQuery();
            while(rs.next()){
                res.add(String.format("%s %-10s %-10s %-10s", rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

        public void disconect(){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
}
