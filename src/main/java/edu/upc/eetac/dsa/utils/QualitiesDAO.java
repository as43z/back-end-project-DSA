package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Qualities;

import java.util.List;

public interface QualitiesDAO {

    Qualities addQualities(Qualities qualities);
    Qualities getQualities(String qualitiesID);
    void updateQualities(String ID, int healthVal, int calcVal, int stamVal, int logicVal, int memVal);
    void deleteQualities(String gameID);
    List<Qualities> getQualitiesList();
}
