package edu.upc.eetac.dsa.utils;

import edu.upc.eetac.dsa.models.Achievements;

import java.util.List;

public interface AchievementsDAO {
    Achievements addAchievements(Achievements achievements);
    Achievements getAchievements(String achievementsID);
    void updateAchievements(String ID, int calcAch, int electronicsAch, int commsAch, int oescAch, int dsaAch, int aeroAch, int tfgAch);
    void deleteAchievements(String achievementsID);
    List<Achievements> getAchievementsList();
}
