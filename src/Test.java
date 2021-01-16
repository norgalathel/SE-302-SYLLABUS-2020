import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.math.BigInteger;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import java.util.Scanner;

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
        // settWidht'in sanırım bir sınırı var ve o sınırdan sonrasını kabul etmiyor detaylı konuşabiliriz.2172 1150
        XWPFParagraph space1 = doc.createParagraph();
        space1.isPageBreak();
        XWPFTable dersinAdi = doc.createTable();
        XWPFTableRow rowd0 = dersinAdi.getRow(0);
        XWPFTableCell celld0 = rowd0.getCell(0);
        XWPFTableCell celld1 = rowd0.addNewTableCell();
        celld0.setText("Dersin Adı");
        celld0.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
        celld1.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(7072));
        XWPFParagraph space2 = doc.createParagraph();
        space2.isPageBreak();

        XWPFTable dersKodlari = doc.createTable();
        XWPFTableRow rowdk0 = dersKodlari.getRow(0);
        XWPFTableCell celldk0 = rowdk0.getCell(0);

        XWPFTableCell celldk1 = rowdk0.addNewTableCell();
        XWPFTableCell celldk2 = rowdk0.addNewTableCell();
        XWPFTableCell celldk3 = rowdk0.addNewTableCell();
        XWPFTableCell celldk4 = rowdk0.addNewTableCell();
        XWPFTableCell celldk5 = rowdk0.addNewTableCell();
        XWPFTableCell celldk6 = rowdk0.addNewTableCell();
        /*celldk1.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1150));
        celldk2.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1150));
        celldk3.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1150));
        celldk4.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1150));
        celldk5.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1150));
        celldk6.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1150));*/
        CTTblWidth widthDersKodlari = dersKodlari.getCTTbl().addNewTblPr().addNewTblW();
        widthDersKodlari.setType(STTblWidth.DXA);
        widthDersKodlari.setW(BigInteger.valueOf(9072));

        celldk0.setText("Kodu");
        celldk1.setText("Güz");
        celldk2.setText("Bahar");
        celldk3.setText("Teori(Saat/Hafta)");
        celldk4.setText("Uygulama/Lab(Saat/Hafta)");
        celldk5.setText("Yerel Kredi");
        celldk6.setText("AKTS");

        XWPFParagraph space3 = doc.createParagraph();
        space3.isPageBreak();

        XWPFTable onkosullar = doc.createTable();
        XWPFTableRow rowon0 = onkosullar.getRow(0);
        XWPFTableCell cellon0 = rowon0.getCell(0);
        XWPFTableCell cellon1 = rowon0.addNewTableCell();
        cellon0.setText("Ön-koşul(lar)");
        cellon0.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
        cellon1.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(7072));
        XWPFTableRow rowon1 = onkosullar.createRow();
        XWPFTableRow rowon2 = onkosullar.createRow();
        XWPFTableRow rowon3 = onkosullar.createRow();

        // deneme amaçlı input çalışıyor
        Scanner languageInput = new Scanner(System.in);
        System.out.println("enter language");
        String textLanguage = languageInput.next();
        rowon1.getCell(1).setText(textLanguage);

        rowon1.getCell(0).setText("Dersin Dili");
        rowon2.getCell(0).setText("Dersin Türü");
        rowon3.getCell(0).setText("Dersin Düzeyi");

        XWPFParagraph space4 = doc.createParagraph();
        space4.isPageBreak();

        try{
            FileOutputStream output = new FileOutputStream("Table Experiment.docx");
            doc.write(output);
            output.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}