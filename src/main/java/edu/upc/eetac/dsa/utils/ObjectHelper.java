package edu.upc.eetac.dsa.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static Object setter(Object o, String prop, Object value) throws NoSuchMethodException {
        Class<?> c = o.getClass();

        try {
            //BUILD THE METHOD
            char[] propChar = prop.toCharArray();
            propChar[0] = Character.toUpperCase(prop.charAt(0));
            prop = String.valueOf(propChar);

            String gMeth = "set" + prop; //Method

            //USE THE METHOD
            Method set = null;
            Class type = value.getClass();
            set = c.getMethod(gMeth, type);
            set.invoke(o, value);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return o;
    }

    public static Object getter(Object o, String prop) throws NoSuchMethodException {
        Object val = null;
        Class c = o.getClass();

        try {
            //BUILD THE METHOD
            char[] propChar = prop.toCharArray();
            propChar[0] = Character.toUpperCase(prop.charAt(0));
            prop = String.valueOf(propChar);

            String sMeth = "get" + prop; //Method

            //USE THE METHOD
            Method get = null;
            get = c.getMethod(sMeth);
            val = get.invoke(o);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return val;
    }
}