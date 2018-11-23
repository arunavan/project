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
import com.cognizant.internal.workout.service.bo.CategoryBO;
import com.cognizant.internal.workout.service.bo.ResponseWrapperBO;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.manager.CategoryManager;
import com.cognizant.internal.workout.service.mapper.WorkoutMapper;
import com.cognizant.internal.workout.service.rest.CategoryService;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	private static final String ERRORMSG = "Error";
	private static final String CATEGORY_ID = "101";
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceTest.class);

	@Mock
	private WorkoutMapper itsWorkoutMapper;

	@Mock
	private CategoryManager itsCategoryManager;

	@InjectMocks
	private CategoryService itsCategoryService;
	
	/**
	 * Test Category List
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@Test
	public final void testGetCategory() throws BusinessException {
		// Initialization Block
		final CategoryBO theCategoryBO = new CategoryBO();
		theCategoryBO.setCategoryId(CATEGORY_ID);
		final List<CategoryBO> theCategoryList = new ArrayList<>();
		theCategoryList.add(theCategoryBO);
		// Mocking Block
		Mockito.when(itsCategoryManager.getCategory()).thenReturn(theCategoryList);
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsCategoryService.getCategory();
		// Validation Block
		assertNotNull(theResult);
	}
	/**
	 * Test addCategory method
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@Test
	public final void testAddCategory() throws BusinessException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsCategoryService.addCategory(new CategoryBO());
		// Validation Block
		assertNotNull(theResult);
	}
	/**
	 * Test addCategory for exception cases
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@Test
	public final void testAddCategoryForCatch() throws BusinessException {
		// Initialization Block
		final CategoryBO theCategoryBO = new CategoryBO();
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsCategoryManager).addCategory(theCategoryBO);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsCategoryService.addCategory(theCategoryBO);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testAddCategoryForCatch method of CategoryServiceTest class", ex);
		}
	}
	/**
	 * Test deletetCategory method
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@Test
	public final void testDeletetCategory() throws BusinessException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsCategoryService.deletetCategory(CATEGORY_ID);
		// Validation Block
		assertNotNull(theResult);
	}
	/**
	 * Test deletetCategory method for exception cases
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@Test
	public final void testDeletetCategoryForCatch() throws BusinessException {
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsCategoryManager).deleteCategory(CATEGORY_ID);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsCategoryService.deletetCategory(CATEGORY_ID);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testDeletetCategoryForCatch method of CategoryServiceTest class", ex);
		}
	}
	/**
	 * Test updatetCategory method
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@Test
	public final void testUpdatetCategory() throws BusinessException {
		// Execution Block
		final ResponseWrapperBO<BaseBO> theResult = itsCategoryService.updatetCategory(new CategoryBO());
		// Validation Block
		assertNotNull(theResult);
	}
	/**
	 *Test updatetCategory method for exception cases
	 * @throws BusinessException it may throw exception if there is any kind of error occurs in operating the data
	 */
	@Test
	public final void testUpdatetCategoryForCatch() throws BusinessException {
		// Initialization Block
		final CategoryBO theCategoryBO = new CategoryBO();
		// Mocking Block
		Mockito.doThrow(new BusinessException(ERRORMSG)).when(itsCategoryManager).updatetCategory(theCategoryBO);
		// Execution Block
		try {
			final ResponseWrapperBO<BaseBO> theResult = itsCategoryService.updatetCategory(theCategoryBO);
			// Validation Block
			assertNotNull(theResult);
		} catch (BusinessException ex) {
			LOGGER.error("Exception Handled for testUpdatetCategoryForCatch method of CategoryServiceTest class", ex);
		}
	}

}
