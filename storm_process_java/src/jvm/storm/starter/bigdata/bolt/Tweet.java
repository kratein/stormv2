package storm.starter.bigdata.bolt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Tweet {

    private long id;
    private long id_author;
    private String created_at_utc;
    private long rt_id_tweet;
    private int rt_count;
    private String source;
    private String text;
    private String lang;
    private int id_location;

    public Tweet() {
        this.id = 0;
        this.id_author = 0;
        this.created_at_utc = "";
        this.rt_id_tweet = 0;
        this.rt_count = 0;
        this.source = "";
        this.text = "";
        this.lang = "";
        this.id_location = 0;
    }

    public Tweet(long id, long id_author, String created_at_utc, long rt_id_tweet, int rt_count,
                 String source, String text, String lang, int id_location) {
        this.id = id;
        this.id_author = id_author;
        this.created_at_utc = created_at_utc;
        this.rt_id_tweet = rt_id_tweet;
        this.rt_count = rt_count;
        this.source = source;
        this.text = text;
        this.lang = lang;
        this.id_location = id_location;
    }

    public boolean save() {
        Model m = Model.getInstance();

        String query = "INSERT INTO tweet (id, id_author, created_at_utc, rt_id_tweet, rt_count, source, text, lang, id_location)" +
                " VALUES ('"+this.id+"', " +"'"+this.id_author+"' ,'"+this.created_at_utc+"', '"+this.rt_id_tweet+
                "','"+this.rt_count+"', '"+this.source+"', '"+this.text+"', '"+this.lang+"', '"+this.id_location+"')";

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
        return "id = " + this.id + "\ncreated_at_utc = " + this.created_at_utc + "\nrt_id_tweet = " + this.rt_id_tweet + "\nrt_count = " + this.rt_count;
    }
}
