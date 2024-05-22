import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException{
        String response = """
            {
                "message" : "server check"
            }        

            """;
        t.getResponseHeaders().add("Content-Type","application/json");
        t.sendResponseHeaders(200,response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}