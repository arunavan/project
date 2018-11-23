package com.cognizant.internal.workout.service.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.internal.workout.service.bo.CategoryBO;
import com.cognizant.internal.workout.service.dao.CategoryDao;
import com.cognizant.internal.workout.service.exception.BusinessException;
import com.cognizant.internal.workout.service.mapper.WorkoutMapper;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoTest {
	
	@Mock
	private WorkoutMapper itsWorkoutMapper;

	@InjectMocks
	private CategoryDao itsCategoryDao;

	/**
	 * Test Category List
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testGetCategory() throws BusinessException {
		// Execution Block
		final List<CategoryBO> theResult = itsCategoryDao.getCategory();
		// Validation Block
		assertNotNull(theResult);
	}

	/**
	 * Test Add Category method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testAddCategory() throws BusinessException {
		// Execution Block
		itsCategoryDao.addCategory(new CategoryBO());
	}

	/**
	 * Test Delete Category method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testDeleteCategory() throws BusinessException {
		// Initialization Block
		final String theCategoryId = "101";
		// Execution Block
		itsCategoryDao.deleteCategory(theCategoryId);
	}

	/**
	 * Test Update Category method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testUpdateCategory() throws BusinessException {
		// Execution Block
		itsCategoryDao.updatetCategory(new CategoryBO());
	}
}
