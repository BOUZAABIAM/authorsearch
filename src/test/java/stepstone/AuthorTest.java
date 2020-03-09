package stepstone;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;

public class AuthorTest {

    @Test
    public void runTheCommand() {
        Authenticator.setDefault(new RHAuthenticator());
        try {
            URIBuilder b = new URIBuilder("https://reststop.randomhouse.com/resources/authors");
            b.addParameter("firstName", "DAN");
            b.addParameter("lastName", "BROWN");
            URL url = b.build().toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String test;
            while((test = reader.readLine()) != null) {

                JSONObject objTest = XML.toJSONObject(test);
                JSONObject authorsTest = (JSONObject) objTest.get("authors");
                JSONArray authorsArrayTest = (JSONArray) authorsTest.get("author");
                assertEquals(authorsArrayTest.length(),3);
                List<Integer> authorIDs = new ArrayList<Integer>();
                List<Integer> authorTitels = new ArrayList<Integer>();
                for (int i = 0; i < authorsArrayTest.length(); i++) {
                    JSONObject authorTest = authorsArrayTest.getJSONObject(i);
                    authorIDs.add(Integer.parseInt(""+authorTest.get("authorid")));
                    assertEquals(""+authorTest.get("authorlastfirst"),"BROWN, DAN");
                    try {
                        JSONObject titlesTest = authorTest.getJSONObject("titles");
                        JSONArray titlesArrayTest = (JSONArray) titlesTest.get("isbn");
                        authorTitels.add(titlesArrayTest.length());
                    }catch (JSONException ex){
                        authorTitels.add(0);
                    }
                }
                assertEquals(authorIDs, Arrays.asList(3446, 224942, 2182290));
                assertEquals(authorTitels,Arrays.asList(65, 0, 3));


            }
            reader.close();
        }catch (URISyntaxException e){
            System.err.println(e.getMessage());
        }catch (Exception ex){
            System.err.println("Please try again! Connection Error!");
        }


    }
}