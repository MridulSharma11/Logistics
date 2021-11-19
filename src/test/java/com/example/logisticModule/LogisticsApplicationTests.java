package com.example.logisticModule;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.logisticModule.DTOmodals.TrackStatuses;
import com.example.logisticModule.services.ShipmentTrackServices;

@SpringBootTest
class LogisticsApplicationTests {

	@Test
	void contextLoads() {
	} 

	
	@Autowired
	ShipmentTrackServices shipmentTrackServices;
	
	@Test
	public void testCreate() {
		
		TrackStatuses ts = new TrackStatuses();
		ts.setSlug("FedEx");
		ts.setTrackId("32435667");
		ResponseEntity re = null;
		 
			 try {
				//re = shipmentTrackServices.showTrackandStatus(ts.getSlug(), ts.getTrackId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		
	}
	
	
}
