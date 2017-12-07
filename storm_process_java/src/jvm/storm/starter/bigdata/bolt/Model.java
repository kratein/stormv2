package storm.starter.bigdata.bolt;

import java.sql.*;
import java.util.*;

public class Model {

    private static Model instance = null;

    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://188.166.21.164/bigdata";
    private final String CRED = "root";

    private Connection con;
    private Statement stmt;

    private Model() {
        try {
            Class.forName(this.DRIVER_NAME);
            connectDB();
        } catch(ClassNotFoundException e) {
            System.err.println("DB driver not loaded into JVM !");
            e.printStackTrace();
        }
    }

    public static Model getInstance()
    {
        if(instance == null)
            instance = new Model();

        return instance;
    }

    public boolean connectDB() {
        try {
            this.con = DriverManager.getConnection(this.DB_URL, this.CRED, this.CRED);
        } catch(SQLException err) {
            System.err.println("SQL error !!");
            err.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean openStatement() {
        if (this.con == null)
            this.connectDB();
        try {
            this.stmt = this.con.createStatement();
        } catch(SQLException err) {
            System.err.println("SQL error !!");
            err.printStackTrace();
            return false;
        }
        return true;
    }

    public Statement getStatement() { return this.stmt; }

    public ArrayList<Integer> testSelect() {
        ArrayList<Integer> res = new ArrayList<Integer>();
        String query = "SELECT tweet_author_id FROM raw LIMIT 1";
        try {
            if (this.stmt == null)
                this.openStatement();

            ResultSet rs = this.stmt.executeQuery(query);
            rs.first();
            int count = rs.getMetaData().getColumnCount();
            if (count != 1)
                System.err.println("The query was executed but did not return any result !!!");

            while(rs.next())
                res.add(rs.getInt(0));
            this.stmt.close();
        } catch(SQLException err) {
            System.err.println("SQL error !!");
            err.printStackTrace();
        }
        return res;
    }
}
