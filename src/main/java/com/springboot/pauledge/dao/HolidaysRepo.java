package com.springboot.pauledge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.pauledge.entity.Holidays;

@Repository
public interface HolidaysRepo extends JpaRepository<Holidays, String> {
	
	@Query(nativeQuery = true,
			value = "SELECT h.festival, h.date, h.day FROM holidays h")
	List<Object[]> findAllHolidays();
	
}
