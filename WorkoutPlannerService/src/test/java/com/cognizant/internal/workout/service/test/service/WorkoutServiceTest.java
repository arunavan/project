package com.cognizant.internal.workout.service.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.WorkoutManager;
import com.cognizant.internal.workout.service.rest.WorkoutService;

@RunWith(MockitoJUnitRunner.class)
public class WorkoutServiceTest {
	private static final String ERRORMSG = "Error";
	private static final String WORKOUT_ID = "101";
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkoutServiceTest.class);

	@Mock
	private WorkoutManager itsWorkoutManager;

	@InjectMocks
	private WorkoutService itsWorkoutService;

	/**
	 * Test Workout List
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */

	@Test
	public final void testGetAllWorkouts() throws BusinessException {
		// Initialization Block
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		final List<WorkoutBO> theWorkoutList = new ArrayList<>();
		theWorkoutList.add(theWorkoutBO);
		// Mocking Block
		Mockito.when(itsWorkoutManager.getWorkout()).thenReturn(theWorkoutList);
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.getAllWorkouts();
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test addWorkout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testAddWorkout() throws BusinessException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.addWorkout(new WorkoutBO());
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test addWorkout for exception cases
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testAddWorkoutForCatch() throws BusinessException {
		// Initialization Block
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsWorkoutManager).addWorkout(theWorkoutBO);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.addWorkout(theWorkoutBO);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testAddWorkoutForCatch method of WorkoutServiceTest class", ex);
		}
	}

	/**
	 * Test updatetWorkout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testUpdateWorkout() throws BusinessException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.updateWorkout(new WorkoutBO());
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test updatetWorkout method for exception cases
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testUpdateWorkoutForCatch() throws BusinessException {
		// Initialization Block
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsWorkoutManager).updateWorkout(theWorkoutBO);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.updateWorkout(theWorkoutBO);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testUpdateWorkoutForCatch method of WorkoutServiceTest class", ex);
		}
	}

	/**
	 * Test deleteWorkout method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testDeleteWorkout() throws BusinessException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.deleteWorkout(WORKOUT_ID);
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test deleteWorkout method for exception cases
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testDeleteWorkoutForCatch() throws BusinessException {
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsWorkoutManager).deleteWorkout(WORKOUT_ID);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.deleteWorkout(WORKOUT_ID);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testDeleteWorkoutForCatch method of WorkoutServiceTest class", ex);
		}
	}

	/**
	 * Test deleteWorworkoutDetails method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */

	@Test
	public final void testDeleteWorworkoutDetailskout() throws BusinessException {
		// Initialization Block
		final String theType = "cardio";
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		final List<WorkoutBO> theWorkoutList = new ArrayList<>();
		theWorkoutList.add(theWorkoutBO);
		// Mocking Block
		Mockito.when(itsWorkoutManager.workoutDetails(theType)).thenReturn(theWorkoutList);
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsWorkoutService.deleteWorworkoutDetails(theType);
		// Validation Block
		assertNotNull(theResult);
	}

}
