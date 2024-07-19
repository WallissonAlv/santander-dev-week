package me.project.santander_dev_week_2024_v20.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id){
		super("Resource not found! id: "+id);
	}
}
