package com.cognizant.internal.workout.service.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cognizant.internal.workout.service.bo.CategoryBO;
import com.cognizant.internal.workout.service.constant.BusinessConstants;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.mapper.WorkoutMapper;

@Repository
public class CategoryDao {
	
	@Autowired
	private WorkoutMapper itsWorkoutMapper;
	
	/**
	 * Gets the list of CategoryId, CategoryName from Workout where Delete Status is 'N'
	 * 
	 * @return List of Category
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public List<CategoryBO> getCategory() throws BusinessException {
		try {
			return itsWorkoutMapper.getWorkOuts();
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}
	
	/**
	 * Inserts Category details in the Workout
	 * 
	 * @param inCategoryBean CategoryBean object from Service
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void addCategory(CategoryBO inCategoryBean) throws BusinessException {
		try {
			itsWorkoutMapper.addWorkOuts(inCategoryBean);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}
	
	/**
	 * Delete status updated to 'Y' based on CategoryID
	 * 
	 * @param inCategoryId input CategoryId passed from Manager
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void deleteCategory(String inCategoryId) throws BusinessException {
		try {
			itsWorkoutMapper.deleteWorkOuts(inCategoryId);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}
	
	/**
	 * Update of Workout based on CategoryId
	 * 
	 * @param inCategoryBean CategoryBean object from Service
	 * @throws BusinessException it may throw Business exception if there is any kind of error occurs in operating the data
	 */
	public void updatetCategory(CategoryBO inCategoryBean) throws BusinessException {
		try {
			itsWorkoutMapper.updatetCategory(inCategoryBean);
		} catch (final DataAccessException ex) {
			throw new BusinessException(BusinessConstants.PROP_DATA_ACCESS_ERROR);
		}
	}
}
