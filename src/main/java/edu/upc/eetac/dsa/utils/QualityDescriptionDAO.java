package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.QualityDescription;

import java.util.List;

public interface QualityDescriptionDAO {
    QualityDescription addQualityDescription(QualityDescription qualityDescription);
    QualityDescription getQualityDescription(String qualityDescriptionID);
    void updateQualityDescription(String ID, String name, String description);
    void deleteQualityDescription(String qualityDescriptionID);
    List<QualityDescription> getQualityDescriptions();
}
