package com.cognizant.internal.workout.service.test.manager;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.dao.WorkoutDao;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.WorkoutManager;

@RunWith(MockitoJUnitRunner.class)
public class WorkoutManagerTest {

	@Mock
	private WorkoutDao itsWorkoutDao;

	@InjectMocks
	private WorkoutManager itsWorkoutManager;

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
		final List<WorkoutBO> theResult = itsWorkoutManager.getWorkout();
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
		itsWorkoutManager.addWorkout(new WorkoutBO());
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
		itsWorkoutManager.deleteWorkout(theWorkoutId);
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
		itsWorkoutManager.updateWorkout(new WorkoutBO());
	}

	/**
	 * Test Add Date Time method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testAddDateTime() throws BusinessException {
		// Execution Block
		itsWorkoutManager.addDateTime(new WorkoutBO());
	}

	/**
	 * Test End Date Time method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 * @throws ParseException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testEndDateTime() throws BusinessException, ParseException {
		// Execution Block
		itsWorkoutManager.endDateTime(new WorkoutBO());
	}

	/**
	 * Test Get All Track
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 * @throws ParseException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetAllTrack() throws BusinessException {
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutManager.getAllTrack();
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test Get WorkoutDetails
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 * @throws ParseException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testWorkoutDetails() throws BusinessException {
		// Initialization Block
		String theType = "cardio";
		// Execution Block
		final List<WorkoutBO> theResult = itsWorkoutManager.workoutDetails(theType);
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test End Date Time method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 * @throws ParseException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testSearchExistingWorkout() throws BusinessException {
		// Execution Block
		itsWorkoutManager.searchExistingWorkout();
	}

}
