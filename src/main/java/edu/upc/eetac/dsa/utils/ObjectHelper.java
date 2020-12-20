package edu.upc.eetac.dsa.utils;

import java.lang.reflect.Field;

public class ObjectHelper {
    public static String[] getFields(Object entity) {
        Class c = entity.getClass();
        Field[] fields = c.getDeclaredFields();

        String[] sFields = new String[fields.length];

        int i=0;
        for (Field f: fields){
            sFields[i]=f.getName();
            i++;
        }

        return sFields;
    }
}
