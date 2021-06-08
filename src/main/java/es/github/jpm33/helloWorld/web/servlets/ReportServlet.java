package es.github.jpm33.helloWorld.web.servlets;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/ReportServlet")
public class ReportServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(ReportServlet.class.getSimpleName());
    private static Document document = new Document();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Expires", "0");
        resp.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        resp.setHeader("Pragma", "public");
        resp.setContentType("application/pdf");

//        crearDocumento();
        OutputStream os = resp.getOutputStream();
        crearDocumento().writeTo(os);
        os.flush();
        os.close();
    }

    private static ByteArrayOutputStream crearDocumento() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter pdfw = null;
            pdfw = PdfWriter.getInstance(document, baos);
            document.open();
            addMetaData();

            Paragraph preface = new Paragraph();
            preface.add(new Paragraph("Title of the document"));
            document.add(preface);

//            for (Deudor D : carta1){
//                //Imagen cabecera
//                Image imgHead = Image.getInstance(imgCabecera);
//                //imgHead.setAbsolutePosition(35, 770);
//                imgHead.scaleAbsolute(125, 40);
//                Documento.add(imgHead);
//                Carta1(D);
//                //Imagen Firma
//                Image imgSign = Image.getInstance(imgFirma);
//                //imgHead.setAbsolutePosition(35, 770);
//                imgSign.scaleAbsolute(110, 105);
//                Documento.add(imgSign);
//                Documento.newPage();
//            }
            document.close();
        }
        catch(DocumentException e) {
            logger.severe(e.getMessage());
            System.out.println(e.getMessage());
        }

        return baos;
    }

    private static void addMetaData() {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }
}
