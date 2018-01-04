package zyf.exception;
/**
* @Author 庄元丰
* @CreateTime 2017年11月13日下午4:05:03
*/
public class ExcelException extends RuntimeException{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 7365837709724622249L;

	public ExcelException() {
		
	}
	
	public ExcelException(String msg) {
		super(msg);
	}
}
