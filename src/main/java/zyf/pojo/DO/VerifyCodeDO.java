package zyf.pojo.DO;

import java.util.Date;

import zyf.pojo.BaseDO;

/**
* @Author 庄元丰
* @CreateTime 2017年11月21日上午11:58:45
*/
public class VerifyCodeDO extends BaseDO{
	
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -9095576807945968057L;

	/**
	 * 手机号码
	 */
	private String phone;
	
	/**
	 * 验证码
	 */
	private String code;
	
	/**
	 * 发送时间
	 */
	private Date sendTime;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "VerifyCode [phone=" + phone + ", code=" + code + ", sendTime=" + sendTime + "]";
	}
	
}
