package stepstone;

import stepstone.factoryPattern.AbstractFactoryPattern;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class Author implements AbstractFactoryPattern{
    private String FIRST_NAME;
    private String LAST_NAME;

    public Author(String FIRST_NAME, String LAST_NAME){

        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
    }



    public void runTheCommand() throws IOException {
        Authenticator.setDefault(new RHAuthenticator());
        URIBuilder b;
        try {
            b = new URIBuilder("https://reststop.randomhouse.com/resources/authors");
            b.addParameter("firstName", FIRST_NAME);
            b.addParameter("lastName", LAST_NAME);
            URL url = b.build().toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String str;
            while((str = reader.readLine()) != null) {

                JSONObject obj = XML.toJSONObject(str);
                JSONObject authors = (JSONObject)obj.get("authors");
                try {
                    JSONArray authorsArray = (JSONArray)authors.get("author");
                    for(int i=0;i<authorsArray.length();i++ ){
                        JSONObject author =  authorsArray.getJSONObject(i);
                        System.out.print(author.get("authorid")+"; ");
                        System.out.print(author.get("authorlastfirst")+"; ");
                        try {
                            JSONObject titles = author.getJSONObject("titles");
                            JSONArray titlesArray = (JSONArray)titles.get("isbn");
                            System.out.println(titlesArray.length());
                        }catch (JSONException ex){
                            System.out.println(0);
                        }
                    }
                }catch (JSONException e){
                    System.err.println("Author Not Found ! Check the firstName/lastName.");
                }

            }
            reader.close();

        }catch (URISyntaxException e){
            System.err.println(e.getMessage());
        }catch (Exception ex){
            System.err.println("Please try again! Connection Error!");
        }

    }
}
