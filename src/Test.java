import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.math.BigInteger;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;


public class Test {
    public static void main(String[] args) {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph para1 = doc.createParagraph();
        XWPFRun run = para1.createRun();
        run.setText("İZMİR EKONOMİ ÜNİVERSİTESİ DERS ÖNERİ FORMU");
        para1.setAlignment(ParagraphAlignment.CENTER);

        XWPFTable genelBilgiler = doc.createTable();
        XWPFTableRow row0 = genelBilgiler.getRow(0);
        XWPFTableCell cell0 = row0.getCell(0);
        cell0.setText("1. GENEL BİLGİLER");

        CTTblWidth width = genelBilgiler.getCTTbl().addNewTblPr().addNewTblW();
        width.setType(STTblWidth.DXA);
        width.setW(BigInteger.valueOf(9072));
        //Neden direkt setWidth kullanmadın diye sorarsanız
        // settWidht'in sanırım bir sınırı var ve o sınırdan sonrasını kabul etmiyor detaylı konuşabiliriz.

        try{
            FileOutputStream output = new FileOutputStream("Table Experiment.docx");
            doc.write(output);
            output.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}