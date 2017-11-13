package zyf.util;
/**
* @Author 庄元丰
* @CreateTime 2017年11月13日下午1:59:44
* 导入excel和导出excel
*/

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import zyf.exception.ExcelException;

public class ExcelUtil {
	
	/**
	 * 将一个javaBeanList导出为Excel
	 */
	public static <T> void expExcel(List<T> list, String filePath) throws Exception {
		
		//没有数据可以导出
		if (CommonUtil.isEmpty(list)) {
			throw new ExcelException("没有用于产生Excel的数据");
		}
		
		int pos = filePath.indexOf(".");
		if (pos < 0) {
			throw new ExcelException("非法的路径名");
		}
		String ext = filePath.substring(pos + 1);
		if (!"xls".equals(ext) && !"xlsx".equals(ext)) {
			throw new ExcelException("非法后缀名");
		}
		
		HSSFWorkbook workbook = null;
		FileOutputStream fos = null;	
		try {
			fos = new FileOutputStream(filePath);
		
			workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
		
			HSSFRow row = sheet.createRow(0);
		
			//通过反射设置excel的表头
			Field[] fields = list.get(0).getClass().getDeclaredFields();
			HSSFCell cell = null;
			for (int i = 0; i < fields.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(fields[i].getName());
			}
			
			//遍历记录，生成excel数据
			for (int i = 0; i < list.size(); i++) {
				T t = list.get(i);
				row = sheet.createRow(i+1);
				
				for (int j = 0; j < fields.length; j++) {
					String fieldName = fields[j].getName();
					Object fieldValue = null;
					try {
						fieldValue = ReflectionUtil.doGetMethod(t, fieldName);
					} catch (Exception e) {
					}
					if (fieldValue == null) {
						fieldValue = "";
					}
					cell = row.createCell(j);
					cell.setCellValue(fieldValue.toString());
				}
			}
			
			workbook.write(fos);
		} catch (Exception e) {
			throw e;
		} finally { //关闭资源
			if (workbook != null) {
				workbook.close();
			}
			if (fos != null) {
				fos.close();				
			}
		}
	}	
}
