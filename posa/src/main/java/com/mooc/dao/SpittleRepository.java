package com.mooc.dao;

import java.util.List;

import com.mooc.model.Spittle;

public interface SpittleRepository {

	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long max,long spittle_id);
}
