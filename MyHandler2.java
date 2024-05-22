import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
static class MyHandler2 implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException{
        String filePath = "/home/programmers/project/user.json";

        ObjectMapper objectMapper = new ObjectMapper();

        int sum = 0;
        
        //filePath 경로에 있는 json 코드와 User[] 배열을 매칭시킨다!
        User[] users = objectMapper.readValue(new File(filePath),User[].class);

        for(User user:users){
            System.out.println(user.getPost_count());
            sum += user.getPost_count();
        }
        //JSON 형태의 응답 내용
        //String response = "{\sum\": \""+sum+"\"}";
        String response = """
            {
                "sum" : "%d"
            }        

                """.formatted(sum);
        t.getResponseHeaders().add("Content-Type","application/json");//응답 헤더 설정
        t.sendResponseHeaders(200,response.getBytes().length);//응답 코드와 길이 설정
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}