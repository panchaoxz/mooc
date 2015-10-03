package com.mooc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mooc.model.Spittle;
@Service("SpittleRepo")
public class SpittleRepoImpl implements SpittleRepository {

	private final int MAX_COUNT = 50;

	public List<Spittle> findSpittles(long max, int count) {
			return createSpittleList(count);
	}
	
	private List<Spittle> createSpittleList(int arg) {
		List<Spittle> Spittles = new ArrayList<Spittle>();
		for (int ii = 0; ii < arg; ii++) {
			Spittles.add(new Spittle(ii,"Spittle " + ii, new Date()));
		}
		return Spittles;
	}


	public Spittle findOne(long max,long spittle_id) {
		
		for(Spittle spittle :createSpittleList(MAX_COUNT)){
			if(spittle.getId() == spittle_id){
				return spittle;
			}
		}
		return null;
	}
}
