package com.cognizant.internal.workout.service.test.service;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

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
import com.cognizant.internal.workout.service.rest.EndService;

@RunWith(MockitoJUnitRunner.class)
public class EndServiceTest {

	private static final String ERRORMSG = "Error";
	private static final Logger LOGGER = LoggerFactory.getLogger(EndServiceTest.class);

	@Mock
	private WorkoutManager itsWorkoutManager;

	@InjectMocks
	private EndService itsEndService;

	/**
	 * Test EndDateTime method
	 * 
	 * @throws ParseException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testeEndDateTime() throws BusinessException, ParseException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsEndService.endDateTime(new WorkoutBO());
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test EndDateTime method for exception cases
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 * @throws ParseException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testeEndDateTimeForCatch() throws BusinessException, ParseException {
		// Initialization Block
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsWorkoutManager).endDateTime(theWorkoutBO);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsEndService.endDateTime(theWorkoutBO);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testeEndDateTimeForCatch method of EndServiceTest class", ex);
		}
	}
}
