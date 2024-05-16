package com.myspring.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.myspring.api.Phone;


// this will format the phone class string to match the field that inside phone object 'phone.countrycode, phone.usernumber' 
// and to using it we have to added to the config file 
public class PhoneFormatter implements Formatter<Phone>{

	@Override
	public String print(Phone object, Locale locale) {
		
		return object.getCountryCode() + "-" + object.getUserNumber();
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		Phone     phone    = new Phone();
		String [] phoneStr = text.split("-");
		//check the number is correct 
		//else set the country code to +49
		if (text.indexOf('-') == -1 || phoneStr[0].length() < 1)
		{
			// that mean there are no - in the phone text 
			// so we will add the country code by our self
			phone.setCountryCode("+49");
			phone.setUserNumber(phoneStr[0]);
		}
		else {
			phone.setCountryCode(phoneStr[0]);
			phone.setUserNumber(phoneStr[1]);
		} 
	
		return phone;
	}

}
