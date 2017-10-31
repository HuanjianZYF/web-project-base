package zyf.query;
/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午3:09:06
*/
public class BaseQuery {
	
	/**
	 * 不知道为什么就是要一个id
	 */
	private Integer id;
	
	/**
	 * 分页时候的偏移量
	 */
	private Integer offset;
	
	/**
	 * 分页时候的记录数
	 */
	private Integer limit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
