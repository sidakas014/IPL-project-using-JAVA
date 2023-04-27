import java.io.*;
import java.util.*;

public class CSVReaderTest {
    public static ArrayList<String> read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            ArrayList<String> tmp_whole_arr = new ArrayList();
            while ((line = br.readLine()) != null) {
                tmp_whole_arr.add(line);
            }
            return tmp_whole_arr;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}



