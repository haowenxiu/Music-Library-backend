package com.hwx.pojo.msg;

import java.util.HashMap;
import java.util.Map;

/*
 * 专门用来返回json数据的类
 * 
 */
public class Msg {

	// 响应状态码 100--表示成功 200--表示失败
	private int code;
	// 响应信息 成功或是失败
	private String msg;
	// 用户要返回给浏览器的数据 存放数据
	private Map<String, Object> extend = new HashMap<String, Object>();

	// 代表请求成功
	public static Msg success() {

		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("处理成功");
		return result;
	}

	// 代表请求失败
	public static Msg fail() {

		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("处理失败");
		return result;
	}

	// 添加数据 链式方式返回的核心就是返回(this)当前对象
	public Msg add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}

	public Msg() {
		super();
	}

	public Msg(int code, String msg, Map<String, Object> extend) {
		super();
		this.code = code;
		this.msg = msg;
		this.extend = extend;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	@Override
	public String toString() {
		return "Msg [code=" + code + ", msg=" + msg + ", extend=" + extend + "]";
	}

}
