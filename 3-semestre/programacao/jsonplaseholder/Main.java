import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * Main
 */
public class Main {
    final static String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws Exception {
        System.out.println(get("/comments?postId=10"));

        System.out.println(get("/posts/10/comments"));

        String body = "{\"name\":\"Novo comentario\",\"email\":\"luisfelipesdn12@gmail.com\",\"body\":\"Meu novo comentario!\"}";
        System.out.println(post("/posts/10/comments", body));

        String putBody = "{\"title\":\"Meu novo título\"}";
        System.out.println(put("/posts/15", putBody));

        System.out.println(delete("/comments/71"));
    }

    public static String get(String route) throws Exception {
        System.out.println("\n\nroute: " + route);
        URI uri = URI.create(BASE_URL + route);
        URL url = uri.toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        return content.toString();
    }

    public static String post(String route, String body) throws Exception {
        return update(route, body, "POST");
    }

    public static String put(String route, String body) throws Exception {
        return update(route, body, "PUT");
    }

    public static String update(String route, String body, String method) throws Exception {
        System.out.println("\n\nroute: " + route);
        System.out.println("body: " + body);
        System.out.println("method: " + method);
        URI uri = URI.create(BASE_URL + route);
        URL url = uri.toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        con.getOutputStream().write(body.getBytes());

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        con.disconnect();

        return content.toString();
    }

    
    public static String delete(String route) throws Exception {
        return update(route, "", "DELETE");
    }
}
