import static java.net.HttpURLConnection.HTTP_OK;
import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SomaHandler implements HttpHandler {

    public static final String PATH = "/soma";

    @Override
    public void handle(HttpExchange conn) throws IOException {
        String[] partes = conn.getRequestURI().getPath().split("/");
        String p1 = partes[2];
        String p2 = partes[3];
        byte[] result = calculateResponse(parametro1, parametro2);
        try {
            conn.sendResponseHeaders(HTTP_OK, result.length);
            Headers headers = conn.getResponseHeaders();
            headers.add("Content-Type", "text/html; charset=UTF-8");
            try (OutputStream out = conn.getResponseBody()) {
                out.write(result);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    byte[] calculateResponse(String p1, String p2) {
        double numero1 = Double.parseDouble(p1);
        double numero2 = Double.parseDouble(p2);
        double soma = numero1 + numero2;
        return Double.toString(soma).getBytes();
    }
}