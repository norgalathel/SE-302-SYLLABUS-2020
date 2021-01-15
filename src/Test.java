import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public class Test {
    public static void main(String[] args) {
        XWPFDocument document = new XWPFDocument();

        try{
            FileOutputStream output = new FileOutputStream("Table Experiment.docx");
            document.write(output);
            output.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}