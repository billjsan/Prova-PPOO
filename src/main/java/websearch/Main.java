package websearch;

import java.io.File;

/**
 * Launch the web-search example
 */
public class Main {
    public static void main(String[] args) {
        // Source file (in the project's root folder)
        File inputTextFile = new File("Queries.txt");

        // Build object graph
        WebSearchModel model = new WebSearchModel(inputTextFile);
        new Snooper(model);

        // Execute
        model.pretendToSearch();
    }
}
