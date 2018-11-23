package com.cognizant.internal.workout.service.rest;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.bo.WorkoutWrapper;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.WorkoutManager;

@RestController
@RequestMapping("/services/track")
public class TrackService extends BaseService{
	
	
	@Autowired
	private WorkoutManager itsWorkoutManager;
	
	/**
	 * Gets the list of Tracked start, end Date and time
	 * 
	 * @return List of WorkoutsBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseWrapperBO<BaseBO> getAllTrack() throws BusinessException {
		final WorkoutWrapper theWorkoutWrapper= new WorkoutWrapper();
		theWorkoutWrapper.setWorkoutBos(itsWorkoutManager.getAllTrack().stream().distinct()
				.collect(Collectors.toList()));
		return getSuccessStatus(theWorkoutWrapper);
	}
}
