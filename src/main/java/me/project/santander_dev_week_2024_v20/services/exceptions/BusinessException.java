package me.project.santander_dev_week_2024_v20.services.exceptions;

public class BusinessException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BusinessException(String msg) {
		super(msg);
	}
}
