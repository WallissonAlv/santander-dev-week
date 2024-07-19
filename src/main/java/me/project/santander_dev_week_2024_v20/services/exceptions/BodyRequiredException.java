package me.project.santander_dev_week_2024_v20.services.exceptions;

public class BodyRequiredException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BodyRequiredException(Object id){
		super("Content cannot be null!");
	}
}
