package com.uir.smartAgri.Repositories;
import com.uir.smartAgri.Entities.SensorCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorCategoryRepository extends JpaRepository<SensorCategory,Integer> {
}
