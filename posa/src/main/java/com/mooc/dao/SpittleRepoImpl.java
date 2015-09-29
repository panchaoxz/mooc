package com.mooc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mooc.model.Spittle;
@Service("SpittleRepo")
public class SpittleRepoImpl implements SpittleRepository {

	public List<Spittle> findSpittles(long max, int count) {
			return createSpittleList(count);
	}

	
	private List<Spittle> createSpittleList(int arg) {
		List<Spittle> Spittles = new ArrayList<Spittle>();
		for (int ii = 0; ii < arg; ii++) {
			Spittles.add(new Spittle("Spittle " + ii, new Date()));
		}
		return Spittles;
	}
}
