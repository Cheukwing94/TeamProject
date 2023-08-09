/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package backend;

import backend.authentication.UserManager;
import backend.database.DatabaseConnector;
import backend.servlets.Router;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Auto generated app class.
 */
public class App {

    /**
     * Runs the application
     *
     * @param args the command line args
     */
    public static void main(String[] args) {
        Dotenv dotenv = null;

        try {
            // Nasty hack to get dotenv to behave
            final String folder = System.getProperty("user.dir");
            dotenv = Dotenv.configure()
                    .directory(folder)
                    .ignoreIfMalformed()
                    .ignoreIfMissing()
                    .load();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            System.out.println(".env file is missing, see ../README.md");
            System.exit(1);
        }

        final String db_url = dotenv.get("DB_URL"),
                username = dotenv.get("DB_USERNAME"),
                password = dotenv.get("DB_PASSWORD"),
                server_url = dotenv.get("SERVER_BIND"),
                secret = dotenv.get("JWT_SECRET"),
                portTmp = dotenv.get("SERVER_PORT");

        // Check for missing args
        if (db_url == null) {
            System.out.println("DB_URL is not defined, see ../README.md");
            System.exit(1);
        }
        if (username == null) {
            System.out.println("DB_USERNAME is not defined, see ../README.md");
            System.exit(1);
        }
        if (password == null) {
            System.out.println("DB_PASSWORD is not defined, see ../README.md");
            System.exit(1);
        }
        if (server_url == null) {
            System.out.println("SERVER_BIND is not defined, see ../README.md");
            System.exit(1);
        }
        if (secret == null) {
            System.out.println("JWT_SECRET is not defined, see ../README.md");
            System.exit(1);
        }
        if (portTmp == null) {
            System.out.println("SERVER_PORT is not defined, see ../README.md");
            System.exit(1);
        }

        final int server_port = Integer.parseInt(portTmp);
        final DatabaseConnector conn = new DatabaseConnector(db_url, username, password);
        final UserManager userManager = new UserManager(conn, secret);

        try {
            Router.initRouter(server_url, server_port, conn, userManager);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}
