package storm.starter.bigdata.bolt;

import java.sql.*;
import java.util.*;

public class TweetLocation {
    private int id;
    private String country;
    private String city;
    private String countryCode;

    public TweetLocation(){}

    public TweetLocation(String country, String city, String countryCode) {
        this.id = 0;
        this.country = country;
        this.city = city;
        this.countryCode = countryCode;
    }

    public TweetLocation(int id, String country, String city, String countryCode) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.countryCode = countryCode;
    }

    public String getCountry() { return this.country; }

    public boolean save() {
        Model m = Model.getInstance();

        String query = "INSERT INTO tweet_location (country, city, country_code) VALUES ('"+this.country+"', " +
                "'"+this.city+"' ,'"+this.countryCode+"')";

        try {
            m.openStatement();
            Statement stmt = m.getStatement();
            stmt.executeUpdate(query);
        } catch (SQLException err) {
            err.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.country;
    }
}

