package com.eden.common.exception;

public class YunBizException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	//记录已不存在
	public YunBizException(){
		super();
	}
	public YunBizException(String msg){
		super(msg);
	}
	public YunBizException(String message, Throwable cause){
		super(message, cause);
	}
	public YunBizException(Throwable cause){
		super(cause);
	}
}
