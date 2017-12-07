package storm.starter.bigdata.bolt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Author {
    private long id;
    private String name;
    private String screen_name;
    private String lang;
    private String created_at_utc;
    private String description;
    private String url;
    private int following_count;
    private int statuses_count;
    private int likes_count;
    private String location;

    public Author(){}

    public Author(long id, String name, String screen_name, String lang, String created_at_utc, String description,
                  String url, int following_count, int statuses_count, int likes_count, String location){
        this.id = id;
        this.name = name;
        this.screen_name = screen_name;
        this.lang = lang;
        this.created_at_utc = created_at_utc;
        this.description = description;
        this.url = url;
        this.following_count = following_count;
        this.statuses_count = statuses_count;
        this.likes_count = likes_count;
        this.location = location;
    }

    public boolean save() {
        Model m = Model.getInstance();

        String query = "INSERT INTO author (id, name, screen_name, lang, created_at_utc, description, url, statuses_count, " +
                "following_count, likes_count, location) VALUES ("+this.id+", " +"'"+this.name+"' ,'"
                +this.screen_name+"', '"+this.lang+"', '"+this.created_at_utc+"', '"+this.description+"', '"+
                this.url+"', "+this.statuses_count+","+this.following_count+", "+this.likes_count+", '"+this.location+"')";

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
        return this.name;
    }
}
