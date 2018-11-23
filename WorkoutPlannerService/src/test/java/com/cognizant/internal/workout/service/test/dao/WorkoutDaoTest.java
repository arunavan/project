package com.cognizant.internal.workout.service.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.dao.WorkoutDao;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.mapper.WorkoutMapper;

@RunWith(MockitoJUnitRunner.class)
public class WorkoutDaoTest {
	@Mock
	private WorkoutMapper itsWorkoutMapper;

	@InjectMocks
	private WorkoutDao itsWorkoutDao;

	/**
	 * Test Workout List
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetWorkout() throws BusinessException {
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutDao.getWorkout();
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test Add Workout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testAddWorkout() throws BusinessException {
		// Execution Block
		itsWorkoutDao.addWorkout(new WorkoutBO());
	}

	/**
	 * Test Update Workout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testUpdateWorkout() throws BusinessException {
		// Execution Block
		itsWorkoutDao.updateWorkout(new WorkoutBO());
	}

	/**
	 * Test Update Workout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testUpdateWorkoutDate() throws BusinessException {
		// Execution Block
		itsWorkoutDao.updateWorkoutDate(new WorkoutBO());
	}

	/**
	 * Test Delete Workout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testDeleteWorkout() throws BusinessException {
		// Initialization Block
		final String theWorkoutId = "101";
		// Execution Block
		itsWorkoutDao.deleteWorkout(theWorkoutId);
	}

	/**
	 * Test AddDateTime method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testAddDateTime() throws BusinessException {
		// Execution Block
		itsWorkoutDao.addDateTime(new WorkoutBO());
	}

	/**
	 * Test EndDateTime method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testEndDateTime() throws BusinessException {
		// Execution Block
		itsWorkoutDao.endDateTime(new WorkoutBO());
	}

	/**
	 * Test GetAllTrack method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetAllTrack() throws BusinessException {
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutDao.getAllTrack();
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test SearchExistingWorkout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testSearchExistingWorkout() throws BusinessException {
		// Execution Block
		itsWorkoutDao.searchExistingWorkout();
	}

	/**
	 * Test GetWorkoutDetails for Yearwise method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetWorkoutDetailsYearwise() throws BusinessException {
		// Initialization Block
		final String theType = "yearWise";
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutDao.getWorkoutDetails(theType);
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test GetWorkoutDetails for MonthWise method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetWorkoutDetailsMonthWise() throws BusinessException {
		// Initialization Block
		final String theType = "monthWise";
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutDao.getWorkoutDetails(theType);
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test GetWorkoutDetails for WeekWise method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetWorkoutDetailsWeekWise() throws BusinessException {
		// Initialization Block
		final String theType = "weekWise";
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutDao.getWorkoutDetails(theType);
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test GetWorkoutDetails for Null method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetWorkoutDetailsForNull() throws BusinessException {
		// Initialization Block
		final String theType = "test";
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutDao.getWorkoutDetails(theType);
		// Validation Block
		assertNull(theResult);
	}
}
