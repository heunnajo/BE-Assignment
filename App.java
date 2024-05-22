import com.sun.net.httpserver.Headers;
//서버 생성
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
public class App {
    int port = 5678;
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    server.createContext("/",new MyHandler()); //1번 문제("경로 설정",실행할 로직 지정)
    server.createContext("/sum",new MyHandler2());//2번 문제("경로 설정",실행할 로직 지정)
    server.setExecutor(null);
    server.start();
    System.out.prntln("Server started on port " + port);
}
