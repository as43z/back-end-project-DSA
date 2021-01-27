package edu.upc.eetac.dsa.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.upc.eetac.dsa.ManagerImpl;
import org.apache.log4j.Logger;

public class ObjectHelper {
    private static final Logger log = Logger.getLogger(ObjectHelper.class);

    public static String[] getFields(Object entity) {
        Class c = entity.getClass();
        Field[] fields = c.getDeclaredFields();
        log.info("Searching fields for class entity " + c.getClass().getSimpleName());
        String[] sFields = new String[fields.length];

        int i=0;
        for (Field f: fields){
            sFields[i]=f.getName();
            i++;
            log.info("Log field " + f.getName());
        }

        return sFields;
    }

    public static Object setter(Object o, String prop, Object value) throws NoSuchMethodException {
        Class<?> c = o.getClass();

        log.info("for class " + c.getSimpleName());
        try {
            //BUILD THE METHOD
            prop = prop.substring(0,1).toUpperCase() + prop.substring(1);

            String gMeth = "set" + prop; //Method
            log.info("use of method " + gMeth);
            //USE THE METHOD
            Method set = null;
            Class type = value.getClass();
            if(type == Integer.class){
                set = c.getMethod(gMeth, Integer.TYPE);
                set.invoke(o, value);
            } else {
              set = c.getMethod(gMeth, type);
              set.invoke(o, value);
            }

            log.info("method executed for object " + o.getClass() + " with value " + value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            log.info("bad illegal access");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            log.info("bad illegal access");
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

            log.info("using method " + sMeth);
            //USE THE METHOD
            Method get = null;
            get = c.getMethod(sMeth);
            val = get.invoke(o);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }

        return val;
    }
}