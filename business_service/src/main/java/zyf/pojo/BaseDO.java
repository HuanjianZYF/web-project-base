package zyf.pojo;

import java.io.Serializable;
import java.util.Date;

/**
* @Author 庄元丰
* @CreateTime 2017年10月20日上午11:42:27
*/
public class BaseDO implements Serializable{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = -705213204125656669L;

	/**
	 * 主键id
	 */
	protected Long id;
		
	/**
	 * 创建时间
	 */
	protected Date createTime;
		
	/**
	 * 修改时间
	 */
	protected Date updateTime;
		
	/**
	 * 是否逻辑删除,0表示未逻辑删除,1表示已逻辑删除
	 */
	protected Integer isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "BaseDO [id=" + id + ", createTime=" + createTime + ", updateTime=" + updateTime + ", isDeleted="
				+ isDeleted + "]";
	}

}
