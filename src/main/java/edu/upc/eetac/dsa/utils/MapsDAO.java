package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Maps;

import java.util.List;

public interface MapsDAO {
    Maps addMaps(Maps maps);
    Maps getMaps(String mapsID);
    void updateMaps(String ID, String name, String vectMap);
    void deleteMaps(String mapsID);
    List<Maps> getMapsList();
}
