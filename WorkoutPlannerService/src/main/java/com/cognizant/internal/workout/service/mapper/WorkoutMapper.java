package com.cognizant.internal.workout.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.cognizant.internal.workout.service.bo.CategoryBO;
import com.cognizant.internal.workout.service.bo.WorkoutBO;

/**
 * Workout Mapper
 * @author 731283
 *
 */
public interface WorkoutMapper {
    public List<WorkoutBO> getWorkout() throws DataAccessException;
    public List<CategoryBO> getWorkOuts() throws DataAccessException;
	public void addWorkOuts(@Param("category") CategoryBO inCategoryBean) throws DataAccessException;
	public void deleteWorkOuts(@Param("inCategoryId") String inCategoryId) throws DataAccessException;
	public void addWorkOut(@Param("WorkOutBean") final WorkoutBO inWorkoutsBean) throws DataAccessException;
	public void addWorkOutDate(@Param("WorkOutBean") final WorkoutBO inWorkoutsBean) throws DataAccessException;
	public void updatetCategory(@Param("categoryBean") CategoryBO inCategoryBean) throws DataAccessException;
	public void updateWorkout(@Param("WorkOutBean") final WorkoutBO inWorkoutsBean) throws DataAccessException;
	public void updateWorkoutDate(@Param("WorkOutBean") final WorkoutBO inWorkoutsBean) throws DataAccessException;
	public void deleteWorkout(@Param("inworkoutId") final String inworkoutId) throws DataAccessException;
	public void addDateTime(@Param("WorkOutBean") final WorkoutBO inWorkoutsBean) throws DataAccessException;
	public void endDateTime(@Param("WorkOutBean") final WorkoutBO inWorkoutsBean) throws DataAccessException;
	public List<WorkoutBO> getAllTrack() throws DataAccessException;
	public List<WorkoutBO> searchExistingWorkout() throws DataAccessException;
	public List<WorkoutBO> getWorkoutForYear() throws DataAccessException;
	public List<WorkoutBO> getWorkoutForWeek()throws DataAccessException;
	public List<WorkoutBO> getWorkoutForMonth() throws DataAccessException;
	
}
