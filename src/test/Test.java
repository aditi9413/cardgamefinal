package test;
import java.io.IOException;

import application.Application;

public class Test {

	public static void main(String[] args) throws IOException 
	{
		Application service = Application.getInstance();;
		service.start();
    }
}
