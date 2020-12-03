package com.springutil.test.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * pdf格式导出
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年12月03日
 */
public class PdfExport {

    public static void main(String[] args) throws Exception {
        Document document = new Document();
        FileOutputStream writer = new FileOutputStream("E:\\Mixed\\Downloads\\" + System.currentTimeMillis() + ".pdf");
        PdfWriter.getInstance(document, writer);

        document.open();
        //创建有两列的table
        PdfPTable table = new PdfPTable(4);

        PdfPCell cell;
        cell = new PdfPCell(new Phrase("nikin.."));
        setCellCenter(cell);
        table.addCell(cell);

        PdfPCell iCell;
        PdfPTable inspectResultTable = new PdfPTable(2);
        float[] iwidth = {16f, 64f};
        inspectResultTable.setWidths(iwidth);

        //插入指标值  告警 规则 阈值
        PdfPCell jCell;
        PdfPTable entityTable = new PdfPTable(2);
        float[] jwidth = {16f, 16f};
        entityTable.setWidths(jwidth);
        for (int i = 0; i <= 3; i++) {

            //插入指标值
            jCell = new PdfPCell(new Phrase("zhibiao"));
            setCellCenter(jCell);
            entityTable.addCell(jCell);
            //告警
            jCell = new PdfPCell(new Paragraph("gao"));
            setCellCenter(jCell);
            entityTable.addCell(jCell);
        }
        iCell = new PdfPCell(entityTable);
        iCell.setColspan(2);

        inspectResultTable.addCell(iCell);

        cell = new PdfPCell(inspectResultTable);
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("oh no no no.."));
        setCellCenter(cell);
        table.addCell(cell);

        document.add(table);
        document.close();
    }

    private static void setCellCenter(PdfPCell cell) {
        cell.setMinimumHeight(40);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    }
}
