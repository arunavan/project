package com.cognizant.internal.workout.service.test;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cognizant.internal.workout.service.test.dao.CategoryDaoTest;
import com.cognizant.internal.workout.service.test.dao.WorkoutDaoTest;
import com.cognizant.internal.workout.service.test.manager.CategoryManagerTest;
import com.cognizant.internal.workout.service.test.manager.WorkoutManagerTest;
import com.cognizant.internal.workout.service.test.service.CategoryServiceTest;
import com.cognizant.internal.workout.service.test.service.EndServiceTest;
import com.cognizant.internal.workout.service.test.service.StartServiceTest;
import com.cognizant.internal.workout.service.test.service.TrackServiceTest;
import com.cognizant.internal.workout.service.test.service.WorkoutServiceTest;
@SuiteClasses({CategoryServiceTest.class,EndServiceTest.class,StartServiceTest.class,TrackServiceTest.class, WorkoutServiceTest.class, CategoryManagerTest.class,WorkoutManagerTest.class, CategoryDaoTest.class,WorkoutDaoTest.class})
@RunWith(Suite.class)
public class AllTests {
}
