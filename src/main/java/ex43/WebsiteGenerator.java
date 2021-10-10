package ex43;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WebsiteGenerator {
    // Creating attributes of website to be set from user
    String siteName;
    String author;
    String path;

    // Defining createWebsite() function to create the website
    public String createWebsite() {
        // Set directory and create file with that path
        String directory = path + siteName;
        File newFolder = new File(directory);
        // Creating folder and returning directory for test
        newFolder.mkdirs();
        return directory;
    }

    // Defining createJSFolder() function to create JS folder
    public String createJSFolder() {
        String directory = path + siteName + "/js/";
        File newFolder = new File(directory);
        newFolder.mkdirs();
        return directory;
    }

    // Defining createCSSFolder() function to create CSS folder
    public String createCSSFolder() {
        String directory = path + siteName + "/css/";
        File newFolder = new File(directory);
        newFolder.mkdirs();
        return directory;
    }

    // Defining createHTML() function to create the HTML file
    public String createHTML() {
        String directory = path + siteName + "/index.html";
        // Create what is going to go inside file
        String htmlContent = "<title>" + siteName + "<title>\n<meta>" + author + "<meta>";
        // The file
        File file = new File(directory);
        try {
            // Writing on the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(htmlContent);
            writer.close();
            return directory;
        } catch (Exception e) {
            return "Failure";
        }
    }
}
