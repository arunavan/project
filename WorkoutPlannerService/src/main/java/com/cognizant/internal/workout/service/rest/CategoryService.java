package com.cognizant.internal.workout.service.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.internal.workout.service.bo.BaseBO;
import com.cognizant.internal.workout.service.bo.CategoryBO;
import com.cognizant.internal.workout.service.bo.CategorysBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.constant.BusinessConstants;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.CategoryManager;
@RestController
@RequestMapping("/services/category")
public class CategoryService extends BaseService {
	
	private static final Logger LOGGER             = LoggerFactory.getLogger(CategoryService.class);	
	@Autowired
	private CategoryManager itsCategoryManager;
	
	/**
	 * Get Category List
	 * 
	 * @return List of CategoryBo
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseWrapperBO<BaseBO> getCategory() throws BusinessException {
		final CategorysBO theCategoryBos= new CategorysBO();
		theCategoryBos.setCategoryBos(itsCategoryManager.getCategory().stream().distinct()
				.collect(Collectors.toList()));
		return getSuccessStatus(theCategoryBos);
	}

	/**
	 * Add Category
	 * 
	 * @param inCategoryBO input CategoryBO Object
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapperBO<BaseBO> addCategory(@RequestBody final CategoryBO inCategoryBO) throws BusinessException {
		try{
			itsCategoryManager.addCategory(inCategoryBO);
			return getSuccessMessage(BusinessConstants.PROP_INFO_INSERT_CATEGORY);			
		}catch(BusinessException businessException){
			LOGGER.error("Error in addCategory", businessException);
			return getFailureMessage(BusinessConstants.PROP_INFO_INSERT_CATEGORY_FAILURE);
		}
	}

	/**
	 *  Update of Workout based on CategoryId
	 * 
	 * @param inCategoryBO input CategoryBO Object
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseWrapperBO<BaseBO> updatetCategory(@RequestBody final CategoryBO inCategoryBO) throws BusinessException{
		try{
			itsCategoryManager.updatetCategory(inCategoryBO);
			return getSuccessMessage(BusinessConstants.PROP_INFO_UPDATE_CATEGORY);
		}catch(BusinessException inBusinessException){
			LOGGER.error("Error in updatetCategory", inBusinessException);
			return getFailureMessage(BusinessConstants.PROP_INFO_UPDATE_CATEGORY_FAILURE);
		
		}
	}

	/**
	 * Delete Category
	 * 
	 * @param inCategoryId input CatgoryId
	 * @return ResponseWrapperBO
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@RequestMapping(value = "categoryId/{inCategoryId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseWrapperBO<BaseBO> deletetCategory(@PathVariable final String inCategoryId) throws BusinessException {
		try{
			itsCategoryManager.deleteCategory(inCategoryId);
			return getSuccessMessage(BusinessConstants.PROP_INFO_DELETE_CATEGORY);
		}catch(BusinessException businessException){
			LOGGER.error("Error in deletetCategory", businessException);
			return getFailureMessage(BusinessConstants.PROP_INFO_DELETE_CATEGORY_FAILURE);
		}
	}
}
