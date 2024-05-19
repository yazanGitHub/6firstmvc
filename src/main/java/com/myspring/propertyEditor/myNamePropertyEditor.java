package com.myspring.propertyEditor;

import java.beans.PropertyEditorSupport;


// this is our property editor that will be used by data binding
public class myNamePropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String myConvertedString = text.toUpperCase();
		setValue(myConvertedString);

	}
}
