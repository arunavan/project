package com.cognizant.internal.workout.service.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.internal.workout.service.bo.CategoryBO;
import com.cognizant.internal.workout.service.dao.CategoryDao;
import com.cognizant.internal.workout.service.exception.BusinessException;

@Service
public class CategoryManager {
	
	@Autowired
	private CategoryDao itsCategoryDao;
		
	public List<CategoryBO> getCategory() throws BusinessException {
        return itsCategoryDao.getCategory();
    }
	
	/**
	 * Inserts Category details in the Workout
	 * 
	 * @param inCategoryBean passed from Service
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void addCategory(CategoryBO inCategoryBean) throws BusinessException {
		itsCategoryDao.addCategory(inCategoryBean);
	}
	
	/**
	 * Update of Workout based on CategoryId
	 * 
	 * @param inCategoryBean passed from Service
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void updatetCategory(CategoryBO inCategoryBean) throws BusinessException{
		itsCategoryDao.updatetCategory(inCategoryBean);
	}
	
	/**
	 * Delete status updated to 'Y' based on CategoryID
	 * 
	 * @param inCategoryId passed from service
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	public void deleteCategory(String inCategoryId) throws BusinessException{
		itsCategoryDao.deleteCategory(inCategoryId);
	}
}
