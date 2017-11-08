package zyf.util;

import zyf.helper.Result;
import zyf.helper.ResultCodeEnum;

/**
* @Author 庄元丰
* @CreateTime 2017年11月8日下午6:33:25
* 返回结果工厂类
*/
public class ResultUtil {
	
	/**
	 * 构建没有data的成功结果
	 */
	public static <T> Result<T> buildSuccessResult() {
		return new Result<T>(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), null);
	}
	
	/**
	 * 构建有data的成功结果
	 */
	public static <T> Result<T> buildSuccessResult(T t) {
		return new Result<T>(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), t);
	}
	
	/**
	 * 构建成功结果对象，使用ResultCodeEnum
	 */
	public static <T> Result<T> buildSuccessResult(ResultCodeEnum result) {
		return new Result<T>(true, result.getCode(), result.getMsg(), null);
	}
	
	/**
	 * 构建成功结果对象，使用ResultCodeEnum，且带data
	 */
	public static <T> Result<T> buildSuccessResult(ResultCodeEnum result, T t) {
		return new Result<T>(true, result.getCode(), result.getMsg(), t);
	}
	
	/**
	 * 构建失败结果，使用ResultCodeEnum
	 */
	public static <T> Result<T> buildFailResult(ResultCodeEnum result) {
		return new Result<T>(false, result.getCode(), result.getMsg(), null);
	}
	
	/**
	 * 构建失败结果,使用ResultCodeEnum，且带data
	 */
	public static <T> Result<T> buildFailResult(ResultCodeEnum result, T t) {
		return new Result<T>(false, result.getCode(), result.getMsg(), t);
	}
}
