package me.project.santander_dev_week_2024_v20.services.exceptions;

public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DatabaseException(String msg){
		super(msg);
	}
}
