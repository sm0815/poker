public class Server {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/poker/";
    /*
     * public static HttpServer startServer() {
     * // create a resource config that scans for JAX-RS resources and providers
     * // in com.example.rest package
     * final ResourceConfig rc = new ResourceConfig().packages("com.example.rest");
     * 
     * // create and start a new instance of grizzly http server
     * // exposing the Jersey application at BASE_URI
     * return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
     * }
     * 
     * public static void main(String[] args) throws IOException {
     * final HttpServer server = startServer();
     * System.out.println(String.format(
     * "Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
     * BASE_URI));
     * System.in.read();
     * server.stop();
     * }
     * 
     */
}