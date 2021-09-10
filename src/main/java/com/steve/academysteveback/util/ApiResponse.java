package com.steve.academysteveback.util;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponse {

	private Header header = new Header();
	private Object data = new Object();
	private Object lockObject = new Object();

	public ApiResponse() {
		header.setResultCode(200);
		header.setResultMessage("SUCCESS");
	}

	public ApiResponse(Integer resultCode, String resultMessage) {
		header.setResultCode(resultCode);
		header.setResultMessage(resultMessage);
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public void setData(Object data) {
		synchronized(lockObject) {
			this.data = data;
		}
	}

	public Header getHeader() {
		return header;
	}

	public Object getData() {
		return data;
	}

	public void setResultCode(Integer resultCode) {
		header.resultCode = resultCode;
	}

	public void setResultMessage(String resultMessage) {
		header.resultMessage = resultMessage;
	}

	public void put(Object data) {
		synchronized(lockObject) {
			this.data = data;
		}
	}

	public void put(String key, Object value) {
		synchronized(lockObject) {
			if(data == null || !(data instanceof Map)) {
				data = new LinkedHashMap<String, Object>();
			}
			Map<String, Object> map = (Map<String, Object>)data;
			map.put(key, value);
		}
	}

	@Data
	public class Header {
		private Integer resultCode;
		private String resultMessage;
	}
}
