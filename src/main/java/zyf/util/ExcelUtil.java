package zyf.util;
/**
* @Author 庄元丰
* @CreateTime 2017年11月13日下午1:59:44
* 导入excel和导出excel
*/

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {
	
	/**
	 * 将一个javaBeanList导出到out流中
	 * 传入一个VO和VO的属性字符串对应的excel表头名Map
	 */
	public static <T> void expExcel(List<T> list, Map<String, String> map, OutputStream out) throws Exception {

		//没有数据可以导出
		if (CommonUtil.isEmpty(list)) {
			return ;
		}
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		HSSFRow row = sheet.createRow(0);
		
		//通过反射设置excel的表头
		Field[] fields = list.get(0).getClass().getDeclaredFields();
		HSSFCell cell = null;
		for (int i = 0; i < fields.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(map.get(fields[i].getName()));
		}
			
		//遍历记录，生成excel数据
		for (int i = 0; i < list.size(); i++) {
			T t = list.get(i);
			row = sheet.createRow(i+1);
				
			for (int j = 0; j < fields.length; j++) {
				String fieldName = fields[j].getName();
				Object fieldValue = null;
				
				fieldValue = ReflectionUtil.doGetMethod(t, fieldName);
		
				if (fieldValue == null) {
					fieldValue = "";
				}
				cell = row.createCell(j);
				cell.setCellValue(fieldValue.toString());
			}
		}
			
		workbook.write(out);
		
		if (workbook != null) {
			workbook.close();
		}
		if (out != null) {
			out.flush();
			out.close();
		}
	}	
	
}
