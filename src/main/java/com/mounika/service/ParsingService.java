package com.mounika.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mounika.model.ParseResponse;

@Service
@Component
public class ParsingService {

	public ParseResponse parseCsvString(String inputString) {
		ParseResponse response = new ParseResponse();
		StringBuilder outPutString = new StringBuilder();
		char currentChar;
		char nextChar;
		boolean isStringClosed = true;
		boolean isNumberClosed = true;
		for(int i=0; i< inputString.length(); i++) {
			currentChar = inputString.charAt(i);
			nextChar = (i < inputString.length()-1) ? inputString.charAt(i+1) : currentChar;
			if(currentChar == ',' && nextChar == '\"' 
					&& isNumberClosed) {
				continue;
			}
			if(currentChar == '\"') {
				if (isStringClosed) {
					outPutString.append("[");
					isStringClosed = false;
				} else {
					if(nextChar != '\r') {
						outPutString.append("] ");
					} else {
						outPutString.append("]");
					}
					isStringClosed = true;
				} 
			} else if (currentChar == ',') {
				if (isNumberClosed && isStringClosed) {
					outPutString.append("[");
					isNumberClosed = false;
				} else if (!isNumberClosed && isStringClosed) {
					if(nextChar != '\r') {
						outPutString.append("] ");
					} else {
						outPutString.append("]");
					}
					isNumberClosed = true;
				} else {
					outPutString.append(currentChar);
				}
			}
			else {
				outPutString.append(currentChar);
			}
			
		}
		System.out.println(outPutString);
		response.setReponseString(outPutString.toString());
		return response;
	}


}
