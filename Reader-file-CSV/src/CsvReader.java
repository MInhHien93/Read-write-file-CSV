
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private static final String COMMA = ",";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("D:\\Java\\Module2\\CSV\\Writer-file-CSV\\contries.csv"));

            // How to read file in java line by line?
            while ((line = br.readLine()) != null) {
                printContry(parseCsvLine(line));
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static void printContry(List<String> country) {
        System.out.println(
                "Country [id = "
                        + country.get(0)
                        + ", code = " + country.get(1)
                        + " , name = " + country.get(2)
                        + "]");
    }
}
