package com.automotive.vehicle.status.error;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.automotive.vehicle.status.AutomotiveVehiclesStatusApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={AutomotiveVehiclesStatusApplication.class})
public class ErrorHandlerTest {


	@Test
	public void testErrorHandler() {

		ErrorHandler errorHandler= new ErrorHandler();
		errorHandler.processValidationError(new IllegalArgumentException());
		Assert.assertEquals("done","done");
	}


}
