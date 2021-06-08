package com.delnortedevs.roompractice.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface TvShowDao {

    @Query("Select * from TvShow")
    List<TvShow> AllShows();

    @Query("Select * from TvShow where name like :name")
    List<TvShow>  SearchByName(String name);

    @Query("Select * from TvShow where name like :name")
    Single <List<TvShow>>  SearchByNameNMT(String name);

    @Insert
    Long insertTvShow(TvShow tvShow);

    @Insert
    Single<Long> insertTvShowNMT(TvShow tvShow);

    @Update
    int updateTvShow(TvShow tvShow);

    @Delete
    int deleteTvShow(TvShow tvShow);

}
