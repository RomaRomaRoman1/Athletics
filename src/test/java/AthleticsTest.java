import org.example.CsvReader;
import org.example.ResultProcessor;
import org.example.Sportsmans;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AthleticsTest {
    private CsvReader csvReader;
    private ResultProcessor resultProcessor = new ResultProcessor(csvReader);
    List<Sportsmans> sportsmansList1 = new ArrayList<>();
    List<Sportsmans> sportsmansList2 = new ArrayList<>();
    @Before
            public void testBefore() {
        csvReader = new CsvReader();
        csvReader.read();

    }
    @Test
    public void testIsEmpty () {
        csvReader.read();
        assertFalse(csvReader.getSportsmansList().isEmpty());
        for (Sportsmans s: csvReader.getSportsmansList()) {
            String gender = s.getGender();
            String distance = s.getDistance();
            assertTrue(gender.equals("Male") || gender.equals("Female"));
            assertTrue(distance.equals("5") || distance.equals("10"));
        }

    }
    @Test
    public void testSorting() {
        int j=0;
        for (int i=10; i>=0; i--) {
            sportsmansList1.add(new Sportsmans());
            sportsmansList1.get(j).setResult(i);
            j++;
        }
        for (int i=0; i<=10; i++) {
            sportsmansList2.add(new Sportsmans());
            sportsmansList2.get(i).setResult(i);
        }
    CsvReader csvReader1 = new CsvReader();
    csvReader1.setSportsmansList(sportsmansList1);
    ResultProcessor resultProcessor1 = new ResultProcessor(csvReader1);
    resultProcessor1.sortResult();
    List<Sportsmans> compareList = resultProcessor1.getCsvReader().getSportsmansList();
    String[] array1 = new String[sportsmansList2.size()];
    String[] array2 = new String[compareList.size()];

      for (int i=0; i<sportsmansList2.size(); i++) {
          array1[i] = sportsmansList2.get(i).toString();
      }
        for (int i=0; i<compareList.size(); i++) {
            array2[i] = compareList.get(i).toString();
        }
        assertEquals(array1, array2);
    }
    @Test
    public void testFilter() {
        for (int i=0; i<=10; i++) {
            sportsmansList2.add(new Sportsmans());
            if (i<5) {sportsmansList2.get(i).setDistance("5");
                sportsmansList2.get(i).setGender("Male");
            }
            else {
                sportsmansList2.get(i).setDistance("10");
                sportsmansList2.get(i).setGender("Female");
            }
        }
        csvReader.setSportsmansList(sportsmansList2);
        resultProcessor.setCsvReader(csvReader);
        resultProcessor.filterResult(10, "Male", "5");
        int j = 0;
        for (Sportsmans s: resultProcessor.getCsvReader().getSportsmansList()) {
            if (s.getGender().equals("Male") &&
                    s.getDistance().equals("5")) {
                j++;
                j++;
            }
            else {
                j++;
            }
        }
        assertTrue(j%2==0);

    }

}
