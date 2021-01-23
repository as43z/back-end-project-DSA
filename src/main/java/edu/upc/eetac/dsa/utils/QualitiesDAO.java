package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Qualities;

import java.util.List;

public interface QualitiesDAO {

    Qualities addQualities(Qualities qualities);
    Qualities getQualities(String qualitiesID);
    Qualities updateQualities(Qualities qualities);
    void deleteQualities(String gameID);
    List<Qualities> getQualitiesList();
}
