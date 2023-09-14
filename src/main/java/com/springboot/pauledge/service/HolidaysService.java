package com.springboot.pauledge.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pauledge.dao.HolidaysRepo;
import com.springboot.pauledge.entity.Holidays;


@Service
public class HolidaysService {
	
	@Autowired
	HolidaysRepo holidaysRepo;
	
	public List<Holidays> getHolidays()
	{
		return holidaysRepo.findAll();
	}
	
	public List<Map<String,Object>> getAllHolidays()
	{
		//List<Object[]> holidaysData = holidaysRepo.findAllHolidays();
		List<Map<String, Object>> result = new ArrayList<>();
		
		for (Object[] holiday : holidaysRepo.findAllHolidays()) {
            Map<String, Object> holidayMap = new LinkedHashMap<>();
            holidayMap.put("festival", holiday[0]);
            holidayMap.put("date", holiday[1]);
            holidayMap.put("day", holiday[2]);
            result.add(holidayMap);
        }

        return result;
	}
}
