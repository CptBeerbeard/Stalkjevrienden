package zbookpc.stalkjevrienden;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import javax.net.ssl.HttpsURLConnection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.DataOutputStream;

/**
 * Created by zbookpc on 31-5-17.
 */

public class HttpURLConnectionExample {


    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

//        System.out.println("\nTesting 2 - Send Http POST request");
//        http.sendPost();

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://localhost:9018/friends";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
//    Connection connection = null;
//        try {
//
//        String url = "http://localhost:9018/friends";
//        URL obj = new URL(url);
//        HttpURLConnection connect = (HttpURLConnection) obj.openConnection();
//        connect.setRequestMethod("GET");
//        connect.setRequestProperty("User-Agent", USER_AGENT);
//
//        // create a database connection
//        Log.d(TAG, "YOLO2");
//        connection = DriverManager.getConnection("jdbc:sqlite:/home/zbookpc/Documents/PT4-database/users.db");
//        Statement statement = connection.createStatement();
//        statement.setQueryTimeout(30);  // set timeout to 30 sec.
//        Log.d(TAG, "YOLO2");
//
//        ResultSet rs = statement.executeQuery("select * from users");
//        while(rs.next()) {
//            // read the result set
//            textView.setText("test");
//            System.out.println("id = " + rs.getInt("id"));
//            System.out.println("pic = " + rs.getInt("picture"));
//        }
//    }
//        catch(SQLException e) {
//        // if the error message is "out of memory",
//        // it probably means no database file is found
//        System.err.println(e.getMessage());
//    } catch (MalformedURLException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//        catch(SQLException e) {
//            // connection close failed.
//            System.err.println(e);
//        }
//    }
//}
