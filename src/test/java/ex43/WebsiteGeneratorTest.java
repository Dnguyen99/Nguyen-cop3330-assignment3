package ex43;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {

    @Test
    void shouldCreateWebsite() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();
        websiteGenerator.path = "src/main/java/ex43/";
        websiteGenerator.siteName = "websitetest.com";
        websiteGenerator.author = "Dylan Nguyen";

        String expected = "src/main/java/ex43/websitetest.com";
        String actual = websiteGenerator.createWebsite();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateJSFolder() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();
        websiteGenerator.path = "src/main/java/ex43/";
        websiteGenerator.siteName = "websitetest.com";
        websiteGenerator.author = "Dylan Nguyen";

        String expected = "src/main/java/ex43/websitetest.com/js/";
        String actual = websiteGenerator.createJSFolder();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateCSSFolder() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();
        websiteGenerator.path = "src/main/java/ex43/";
        websiteGenerator.siteName = "websitetest.com";
        websiteGenerator.author = "Dylan Nguyen";

        String expected = "src/main/java/ex43/websitetest.com/css/";
        String actual = websiteGenerator.createCSSFolder();

        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateHTML() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();
        websiteGenerator.path = "src/main/java/ex43/";
        websiteGenerator.siteName = "websitetest.com";
        websiteGenerator.author = "Dylan Nguyen";

        String expected = "src/main/java/ex43/websitetest.com/index.html";
        String actual = websiteGenerator.createHTML();

        assertEquals(expected, actual);
    }
}