package com.miodrag.finbooks.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.miodrag.finbooks.entities.Dnevnik;

public interface DnevnikRepository extends JpaRepository<Dnevnik, Integer> {
	
	@Query(nativeQuery = true, value ="SELECT * FROM dnevnik WHERE br_naloga =?1")
	List<Dnevnik> findDnevniksbyBrNaloga(int brn);

}
