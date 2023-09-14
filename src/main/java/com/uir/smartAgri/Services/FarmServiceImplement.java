package com.uir.smartAgri.Services;

import com.uir.smartAgri.Entities.Farm;
import com.uir.smartAgri.Entities.User;
import com.uir.smartAgri.Repositories.FarmRepository;
import com.uir.smartAgri.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FarmServiceImplement implements FarmService {
    private  FarmRepository farmRepository;
    private  UserRepository UserRepository;
    public List<Farm> findAll() {
        return farmRepository.findAll();
    }

    public Farm findById(Long id) {
        return farmRepository.findById(id).orElse(null);
    }

    public void save(Farm farm) {
        farmRepository.save(farm);
    }

    public void update(Farm farm) {
        farmRepository.save(farm);
    }

    public void delete(Long id) {
        farmRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersNotExistInFarm(Long idFarm) {
        Farm farm=farmRepository.findById(idFarm).orElse(null);
        List<User> alluser = UserRepository.findAll();
        List<User> allusernotexistinfarm = new ArrayList<>();
        for(User user:alluser){
            if(!farm.getUsers().contains(user)){
                allusernotexistinfarm.add(user);
            }
        }
    return allusernotexistinfarm;
    }

    @Override
    public Farm updateFarm(Long id, Farm farm) {
            return farmRepository.findById(id).map(farm1 -> {
                farm1.setAddress(farm.getAddress());
                farm1.setName(farm.getName());
                farm1.setArea(farm.getArea());
                farm1.setLatitude(farm.getLatitude());
                farm1.setLongitude(farm.getLongitude());
                farm1.setDescription(farm.getDescription());
                return farmRepository.save(farm1);
            }).orElseThrow(()->new RuntimeException("Farm not found"));
    }

    @Override
    public Farm getFarmById(Long farmid) {
        return farmRepository.findById(farmid).orElse(null);
    }

    @Override
    public Farm findFarmByFarmName(String name) {
        return farmRepository.findByName(name);
    }

    @Override
    public Boolean addUserToFarm(String username, String FarmName) {
        Farm f = findFarmByFarmName(FarmName);
        User u = UserRepository.findByUsername(username);
        if(u.getFarms()!=null){
            if(!u.getFarms().contains(f)){
                u.getFarms().add(f);
                f.getUsers().add(u);
            }
            return true;

        }
        return false;
    }
    @Override
    public Boolean deleteUserFromFarm(String username, String FarmName) {
        Farm farm = findFarmByFarmName(FarmName);
        User user = UserRepository.findByUsername(username);
        if (user != null && farm != null) {
            if (user.getFarms() != null && user.getFarms().contains(farm)) {
                user.getFarms().remove(farm);
                farm.getUsers().remove(user);
                return true;
            }
        }
            return false;
    }
}
