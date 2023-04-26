import java.io.*;
import java.util.*;

public class CSVReaderTest {
    public static ArrayList<String> read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            //String[] tempArr;
            ArrayList<String> mtc = new ArrayList();
            while ((line = br.readLine()) != null) {
                mtc.add(line);
            }
            return mtc;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}



