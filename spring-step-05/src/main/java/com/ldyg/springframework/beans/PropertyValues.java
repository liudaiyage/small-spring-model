package com.ldyg.springframework.beans;

import com.ldyg.springframework.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    private final List<PropertyValue> propertyValues = new ArrayList<>();

//    public PropertyValue[] getPropertyValues() {
//        return this.propertyValues.toArray(new PropertyValue[0]);
//    }
    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValues) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
