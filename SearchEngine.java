import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {    

    @Override
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Shawn, " + "CSE, " + "15L");
    }
    else if (url.getPath().equals("/increment")) {
      
        return String.format("Number incremented!");
    } else {
        System.out.println("Path: " + url.getPath());
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
        }
        return "404 Not Found!";
    }
}

class SearchEngine {
        
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






