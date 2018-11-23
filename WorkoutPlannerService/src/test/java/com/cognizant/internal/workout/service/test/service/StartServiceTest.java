package com.cognizant.internal.workout.service.test.service;

import static org.junit.Assert.assertNotNull;

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
import com.cognizant.internal.workout.service.rest.StartService;

@RunWith(MockitoJUnitRunner.class)
public class StartServiceTest {
	
	private static final String ERRORMSG = "Error";
	private static final Logger LOGGER = LoggerFactory.getLogger(StartServiceTest.class);

	@Mock
	private WorkoutManager itsWorkoutManager;

	@InjectMocks
	private StartService itsStartService;

	/**
	 * Test StartDateTime method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testStartDateTime() throws BusinessException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsStartService.startDateTime(new WorkoutBO());
		// Validation Block
		assertNotNull(theResult);
	}
	
	/**
	 * Test StartDateTime method for exception cases
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testStartDateTimeForCatch() throws BusinessException {
		// Initialization Block
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsWorkoutManager).searchExistingWorkout();
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsStartService.startDateTime(theWorkoutBO);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testStartDateTimeForCatch method of StartServiceTest class", ex);
		}
	}
	
	/**
	 * Test StartDateTime method for exception cases
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testStartDateTimeForAddDateTimeCatch() throws BusinessException {
		// Initialization Block
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsWorkoutManager).addDateTime(theWorkoutBO);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsStartService.startDateTime(theWorkoutBO);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testStartDateTimeForAddDateTimeCatch method of StartServiceTest class", ex);
		}
	}
}
