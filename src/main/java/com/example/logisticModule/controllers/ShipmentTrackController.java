package com.example.logisticModule.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.logisticModule.DTOmodals.ShipmentInfo;
import com.example.logisticModule.DTOmodals.TrackStatuses;
import com.example.logisticModule.services.ShipmentTrackServices;
import com.example.logisticModule.services.ShipmentTrackServicesInterface;

@RestController
public class ShipmentTrackController {

	@Autowired
	ShipmentTrackServices shipmentTrackServices;
	

	Logger logger = LoggerFactory.getLogger(ShipmentTrackController.class);
	private final String CREATE_SHIPMENT_ISSUE = "Facing issue while creating a Track. Please connect with the Customer Support For the details";
	private final String TRACKING_DETAILS_FETCH_ISSUE = "Please connect with the Customer Support For the details";
	private final String MANDATORY_SLUG_TRACKINGNUMBER = "Code and TrackID are Mandatory";
	private final String CREATE_SHIPMENT = "Creating Tracking for Tracking Number: ";
	/*
	 * @RequestMapping(path ="/shipmentStatus/{code}/{TrackId}" , method=
	 * RequestMethod.GET) public ResponseEntity getShipmentStatus(@PathVariable
	 * String code , @PathVariable String TrackId) throws Exception { ResponseEntity
	 * re = null; String message = check(code, TrackId);
	 * System.out.println(message);
	 * 
	 * if( !code.isEmpty() && !TrackId.isEmpty() ) {
	 * 
	 * 
	 * 
	 * shipmentTrackServices.showTrackandStatus(code, TrackId); re =
	 * ResponseEntity.ok().body("All Good");
	 * 
	 * }else {
	 * 
	 * re = ResponseEntity.ok().body("Code and TrackID are Mandatory"); } return re;
	 * }
	 */

	@RequestMapping(path = "/shipmentStatus", method = RequestMethod.GET)
	public ResponseEntity getShipmentStatusnew(@RequestBody TrackStatuses ts) throws Exception {
		ResponseEntity re = null;
		try {

			String TrackId = ts.getTrackId();
			String code = ts.getSlug();
			logger.info(TrackId + " and " + code);
			
			if (!code.isEmpty() && !TrackId.isEmpty()) {
				re = shipmentTrackServices.showTrackandStatus(code, TrackId);
			} else {
				logger.error(MANDATORY_SLUG_TRACKINGNUMBER);
				re = ResponseEntity.ok().body(MANDATORY_SLUG_TRACKINGNUMBER);
			}

		} catch (Exception ex) {
			logger.error(TRACKING_DETAILS_FETCH_ISSUE);
			re = ResponseEntity.ok().body(TRACKING_DETAILS_FETCH_ISSUE);
			ex.printStackTrace();
		}

		return re;
	}

	@RequestMapping(path = "/createShipment", method = RequestMethod.POST)
	public ResponseEntity createNewShipment(@RequestBody ShipmentInfo si) throws Exception {

		ResponseEntity re = null;
		try {
			logger.info(CREATE_SHIPMENT + si.getTracking_number());
			if (!si.getSlug().isEmpty() && !si.getTracking_number().isEmpty()) {
				re = shipmentTrackServices.createTrackingServ(si);
			} else {
				logger.error(MANDATORY_SLUG_TRACKINGNUMBER);
				re = ResponseEntity.ok().body(MANDATORY_SLUG_TRACKINGNUMBER);
			}

		} catch (Exception ex) {
			logger.error(CREATE_SHIPMENT_ISSUE);
			re = ResponseEntity.ok().body(CREATE_SHIPMENT_ISSUE);
			ex.printStackTrace();
		}

		return re;
	}


}
