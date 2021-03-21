package utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: TestNG_DEMO
 * @description:
 * @author: poooooi
 * @create: 2021-03-21 22:41
 **/

public class ExcelUtil {
    public Workbook workbook;
    public Sheet sheet;
    public Cell cell;
    private int rows;
    private int columns;
    public String fileName;
    public String caseName;
    public ArrayList<String> arrKey = new ArrayList<String>();
    private String sourceFile;

    /**
     * @param fileName excel文件名
     * @param caseName sheet名
     */
    public ExcelUtil(String fileName, String caseName) {
        super();
        this.fileName = fileName;
        this.caseName = caseName;
    }

    /**
     * 获得excel表中的数据
     */
    public Object[][] getExcelData() throws BiffException, IOException {

        workbook = Workbook.getWorkbook(new File(getPath()));
        sheet = workbook.getSheet(caseName);
        rows = sheet.getRows();
        columns = sheet.getColumns();
        // 为了返回值是Object[][],定义一个多行单列的二维数组
        HashMap[][] arrMap = new HashMap[rows - 1][1];
        // 对数组中所有元素hashMap进行初始化
        if (rows > 1) {
            for (int i = 0; i < rows - 1; i++) {
                arrMap[i][0] = new HashMap<>();
            }
        } else {
            System.out.println("excel中没有数据");
        }

        // 获得首行的列名，作为hashMap的key值
        for (int c = 0; c < columns; c++) {
            String cellValue = sheet.getCell(c, 0).getContents();
            arrKey.add(cellValue);
        }
        // 遍历所有的单元格的值添加到hashMap中
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                String cellValue = sheet.getCell(c, r).getContents();
                arrMap[r - 1][0].put(arrKey.get(c), cellValue);
            }
        }
        return arrMap;
    }

    /**
     * 获得excel文件的路径
     *
     * @return
     * @throws IOException
     */
    public String getPath() throws IOException {
        File directory = new File(".");
        sourceFile = directory.getCanonicalPath() + "\\src\\main\\java\\data\\"
                + fileName + ".xls";
        return sourceFile;
    }
}
