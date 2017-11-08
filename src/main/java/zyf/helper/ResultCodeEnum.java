package zyf.helper;
/**
* @Author 庄元丰
* @CreateTime 2017年11月8日下午6:35:59
* 返回消息和返回码
*/
public enum ResultCodeEnum {
	/**
	 * 成功
	 */
	SUCCESS("0000", "成功"),
	
	/**
	 * 失败
	 */
	FAILURE("9999", "失败"),
	
	/**
	 * 系统相关
	 */
	UNKNOWN_ERROR("0001", "未知错误")
	
	;
	/**
	 * 结果码
	 */
	private String code;
	
	/**
	 * 错误消息
	 */
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	ResultCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
