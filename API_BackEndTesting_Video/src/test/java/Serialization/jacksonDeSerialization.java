package Serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jacksonDeSerialization {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		project PObj = om.readValue(new File("./Project.json"), project.class);
		System.out.println(PObj.getProjectName());
		System.out.println(PObj.getCreatedBy());
		System.out.println(PObj.getStatus());
		System.out.println(PObj.getTeamSize());
	}

}
