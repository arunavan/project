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

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.bo.WorkoutBO;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.WorkoutManager;
import com.cognizant.internal.workout.service.rest.TrackService;

@RunWith(MockitoJUnitRunner.class)
public class TrackServiceTest {

	@Mock
	private WorkoutManager itsWorkoutManager;

	@InjectMocks
	private TrackService itsTrackService;

	/**
	 * Test Track List
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */

	@Test
	public final void testGetAllTrack() throws BusinessException {
		// Initialization Block
		final WorkoutBO theWorkoutBO = new WorkoutBO();
		final List<WorkoutBO> theWorkoutList = new ArrayList<>();
		theWorkoutList.add(theWorkoutBO);
		// Mocking Block
		Mockito.when(itsWorkoutManager.getAllTrack()).thenReturn(theWorkoutList);
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsTrackService.getAllTrack();
		// Validation Block
		assertNotNull(theResult);
	}
}
