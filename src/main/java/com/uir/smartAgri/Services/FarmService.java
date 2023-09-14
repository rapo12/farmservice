package com.uir.smartAgri.Services;

import com.uir.smartAgri.Entities.Farm;
import com.uir.smartAgri.Entities.User;

import java.util.List;

public interface FarmService {
    Farm updateFarm(Long id, Farm farm);
    Farm getFarmById(Long farmid);

    Farm findFarmByFarmName(String name);
    Boolean addUserToFarm(String username,String FarmName);
    Boolean deleteUserFromFarm(String username,String FarmName);
    List<Farm> findAll();
    Farm findById(Long id);
    void save(Farm farm);
    void update(Farm farm);
    void delete(Long id);
    List<User> getUsersNotExistInFarm(Long idFarm);
}
