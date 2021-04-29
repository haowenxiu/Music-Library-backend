package com.hwx.pojo.msg;

import java.util.HashMap;
import java.util.Map;

public class Msg {

//	响应状态码
	private int code;
//	响应信息成功或是失败
	private String msg;
//	存放数据
	private Map<String, Object> extend = new HashMap<String, Object>();

	// 成功
	public static Msg success() {

		Msg m = new Msg();
		m.setCode(200);
		m.setMsg("处理成功");
		return m;
	}

	// 失败
	public static Msg fail() {

		Msg m = new Msg();
		m.setCode(400);
		m.setMsg("处理失败");
		return m;
	}

	// 添加数据
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
