package com.mounika.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.mounika.model.ParseResponse;

public class ParsingServiceTest {
	
	ParsingService service = new ParsingService();
	
	
	@Test
	public void testService() {
		ParseResponse response = service.parseCsvString("\"Patient Name\",\"SSN\",\"Age\",\"Phone Number\",\"Status\"\r\n" + 
				"\"Prescott, Zeke\",\"542-51-6641\",21,\"801-555-2134\",\"Opratory=2,PCP=1\"\r\n" + 
				"\"Goldstein, Bucky\",\"635-45-1254\",42,\"435-555-1541\",\"Opratory=1,PCP=1\"\r\n" + 
				"\"Vox, Bono\",\"414-45-1475\",51,\"801-555-2100\",\"Opratory=3,PCP=2\"\r\n" + 
				"");
		assertEquals("[Patient Name] [SSN] [Age] [Phone Number] [Status]\r\n" + 
				"[Prescott, Zeke] [542-51-6641] [21] [801-555-2134] [Opratory=2,PCP=1]\r\n" + 
				"[Goldstein, Bucky] [635-45-1254] [42] [435-555-1541] [Opratory=1,PCP=1]\r\n" + 
				"[Vox, Bono] [414-45-1475] [51] [801-555-2100] [Opratory=3,PCP=2]\r\n" + 
				"", response.getReponseString());
		
	}
	

}
