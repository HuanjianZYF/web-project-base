package zyf.helper;

import java.io.Serializable;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日下午6:43:48
* 返回结果类型
*/
public class Result<T> implements Serializable{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -739336625726725142L;
	
	/**
	 * 返回结果码
	 */
	private String errorCode;
	
	/**
	 * 返回消息
	 */
	private String errorMsg;
	
	/**
	 * 结果数据
	 */
	private T data;
	
	/**
	 * 是否成功
	 */
	private Boolean success;

	/**
	 * 返回的时间戳
	 */
	private Long timestamp = System.currentTimeMillis();

	public Result() {
		
	}
	
	public Result(Boolean success, String errorCode, String errorMsg, T data) {
		this.success = success;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Result [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", data=" + data + ", success=" + success
				+ ", timestamp=" + timestamp + "]";
	}

}
