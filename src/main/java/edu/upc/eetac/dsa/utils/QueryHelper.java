package edu.upc.eetac.dsa.utils;

public class QueryHelper {
    public static String queryInsert(Object entity){
        String[] fields = ObjectHelper.getFields(entity);
        String query = "INSERT INTO " +
                entity.getClass().getSimpleName() + " (";

        query += fields[0];
        for(int i = 1; i < fields.length; i++){
            query += ", " + fields[i]; //(ID, uname(1), pswrd(2), email(3)
        }

        query += ") VALUES (?";
        for(int i = 1; i < fields.length; i++){
            query += ", ?"; //(?, ?(1), ?(2), ?(3)
        }

        query += ");";
        return query;
    }
}
