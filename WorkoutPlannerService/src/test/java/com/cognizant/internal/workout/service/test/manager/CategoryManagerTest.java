package com.cognizant.internal.workout.service.test.manager;

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
import com.cognizant.internal.workout.service.manager.CategoryManager;

@RunWith(MockitoJUnitRunner.class)
public class CategoryManagerTest {

	@Mock
	private CategoryDao itsCategoryDao;

	@InjectMocks
	private CategoryManager itsCategoryManager;

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
		final List<CategoryBO> theResult = itsCategoryManager.getCategory();
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
		itsCategoryManager.addCategory(new CategoryBO());
	}

	/**
	 * Test Update Category method
	 * 
	 * @throws BusinessException
	 *             it may throw exception if there is any kind of error occurs in
	 *             operating the data
	 */
	@Test
	public final void testUpdatetCategory() throws BusinessException {
		// Execution Block
		itsCategoryManager.updatetCategory(new CategoryBO());
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
		//Initialization Block
		final String theCategoryId = "101";
		// Execution Block
		itsCategoryManager.deleteCategory(theCategoryId);
	}
}
