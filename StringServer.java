import java.io.IOException;
import java.net.URI;


class Handler implements URLHandler {
    
    String response = "";

    public Handler(String string) {
    }

    public String handleRequest(URI url) {

        if (url.getPath().equals("/")) {
            return response;
        } 
        else if (url.getPath().contains("add")) {

            String[] parameters;
            parameters = url.getQuery().split("=");

            if (parameters[0].equals("s")) {
                response = response.concat(parameters[1]);
                response = response.concat("\n");
                return response;
            }
            return "Wrong url input!";
    }
    return "404 not found!";
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
}