package com.automotive.vehicle.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.automotive.vehicle.model.Status;
import com.automotive.vehicle.model.Vehicle;
import com.automotive.vehicle.repo.VehicleRepository;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

	@Mock
	private VehicleRepository vehicleRepositoryMock;

	@InjectMocks
	VehicleService vehicleService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("YS2R4X20005399401", "FORD", "F150", "ABC123", "ABC123",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		assertThat("size is equal to 1", vehicleService.findAll().size(), is(1));

	}

	@Test
	public void testFindByIdWithEmptyValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("YS2R4X20005399401", "FORD", "F150", "ABC123", "ABC123",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		assertNull(vehicleService.findById("VLUR4X20009093588"));
//		assertThat("size is equal to 0", vehicleService.findById("123"), is(null));
	}

	@Test
	public void testFindByIdWithExitingValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("123", "FORD", "F150", "ABC123", "ABC123",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

//		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);
		when(vehicleService.findById("123")).thenReturn(vehicleListMock.get(0));
		assertThat("size is equal to 1", vehicleService.findById("123"), is(1));

	}

//	@Test(expected = IllegalArgumentException.class)
//	public void testFindByNameWithEmptyValue() {
//		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
//			{
//				add(new Vehicle("VLUR4X20009093588", "FORD", "F150", "ABC123", "ABC123",
//						Status.CONNECTED.getStatusCode()));
//			}
//		};
//
//		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);
//
//		vehicleService.findByName("VLUR4X20009093588XCZ");
//	}

	@Test
	public void testFindByNameWithExitingValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("VLUR4X20009093588", "FORD", "F150", "ABC123", "ABC123",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		assertThat("size is equal to 1", vehicleService.findByName("FORD"), is(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindByPlateNumberWithEmptyValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("VLUR4X20009093588", "FORD", "F150", "ABC123", "ABC123",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		vehicleService.findByPlateNumber("");
	}

	@Test
	public void testFindByPlateNumberWithExistingValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("VLUR4X20009093588", "FORD", "F150", "ABC123", "ABC123",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		assertThat("size is equal to 1", vehicleService.findByPlateNumber("ABC123"), is(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindByRegistrationNumberWithEmptyValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("VLUR4X20009093588", "FORD", "F150", "ABC123", "ABC123",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		vehicleService.findByRegistrationNumber("");

		// assertThatIllegalArgumentException();
	}

	@Test
	public void testFindByRegistrationNumberWithExistingValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("VLUR4X20009048066", "Raptor", "F150", "GHI789", "GHI789",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		assertThat("size is equal to 1", vehicleService.findByRegistrationNumber("GHI789"), is(1));

	}

	@Test
	public void testPingWithExitingValue() {

		List<Vehicle> vehicleListMock = new ArrayList<Vehicle>() {
			{
				add(new Vehicle("VLUR4X20009048066", "Raptor", "F150", "GHI789", "GHI789",
						Status.CONNECTED.getStatusCode(),LocalDateTime.now()));
			}
		};

		when(vehicleRepositoryMock.findAll()).thenReturn(vehicleListMock);

		Optional<Vehicle> vehicle = vehicleService.pulse("VLUR4X20009048066");

		Assert.assertEquals(true, vehicle.isPresent());

	}

}
