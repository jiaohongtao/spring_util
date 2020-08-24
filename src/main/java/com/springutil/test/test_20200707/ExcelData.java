package com.springutil.test.test_20200707;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * 读取Excel数据
 * href：https://blog.csdn.net/galen2016/article/details/84840793
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年07月17日
 */
public class ExcelData {
    private XSSFSheet sheet;

    /**
     * 构造函数，初始化excel数据
     *
     * @param filePath  excel路径
     * @param sheetName sheet表名
     */
    ExcelData(String filePath, String sheetName) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            //获取sheet
            sheet = sheets.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据行和列的索引获取单元格的数据
     *
     * @param row
     * @param column
     */
    public String getExcelDateByIndex(int rowCount, int columnCount) {
        XSSFRow row = sheet.getRow(rowCount);
        return row.getCell(columnCount).toString();
    }

    /**
     * 根据某一列值为“******”的这一行，来获取该行第x列的值
     *
     * @param caseName
     * @param currentColumn 当前单元格列的索引
     * @param targetColumn  目标单元格列的索引
     */
    public String getCellByCaseName(String caseName, int currentColumn, int targetColumn) {
        String operateSteps = "";
        //获取行数
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            String cell = row.getCell(currentColumn).toString();
            if (cell.equals(caseName)) {
                operateSteps = row.getCell(targetColumn).toString();
                break;
            }
        }
        return operateSteps;
    }

    //打印excel数据
    public void readExcelData() {
        //获取行数
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            //获取列数
            XSSFRow row = sheet.getRow(i);
            int columns = row.getPhysicalNumberOfCells();
            for (int j = 0; j < columns; j++) {
                String cell = row.getCell(j).toString();
                System.out.print(cell + " \t");
            }
            System.out.println();
        }
    }

    //测试方法
    public static void main(String[] args) {
        String filePath = "src/main/resources/files/FirstTests.xlsx";
        // String filePath = "E:\\Projects\\IdeaProjects\\spring_util\\src\\main\\resources\\files\\FirstTests.xlsx";
        ExcelData sheet1 = new ExcelData(filePath, "Sheet1");
        /*//获取第二行第4列
        String cell2 = sheet1.getExcelDateByIndex(1, 3);
        //根据第3列值为“customer23”的这一行，来获取该行第2列的值
        String cell3 = sheet1.getCellByCaseName("cusumer23", 2, 1);
        System.out.println(cell2);
        System.out.println(cell3);*/

        sheet1.readExcelData();
    }
}

