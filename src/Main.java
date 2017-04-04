import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        main5(args);
    }

    public static void main1(String[] args) throws IOException {
        // will not compile
            FileWriter fw = new FileWriter("output.txt");
            fw.write("Now is the time " + (LocalDateTime.now()));
            fw.flush();
            fw.close();
    }
    public static void main2(String[] args) {
        // will not compile
        try {
            FileWriter fw = new FileWriter("output.txt");
            fw.write("Now is the time " + (LocalDateTime.now()));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main3(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("");
            fw.write("Now is the time " + (LocalDateTime.now()));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("In catch " + e.getMessage());
            return;
        } finally {
            System.out.println("finally running");
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // write to log
                }
            }
        }
    }
    public static void main4(String[] args) {
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write("howdy!");
            fw.flush();
        } catch (IOException e) {
            System.out.println("In catch " + e.getMessage());
        }
    }
    public static void main5(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("File name required");
        }
        try (FileWriter fw = new FileWriter( args[0] )) {
            fw.write("Now is the time " + (LocalDateTime.now()));
            fw.flush();
        } catch (IOException e) {
            System.out.println("In catch " + e.getMessage());
        }
    }

}


