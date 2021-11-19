package com.example.logisticModule.services;

import org.springframework.http.ResponseEntity;

import com.example.logisticModule.DTOmodals.ShipmentInfo;

public interface ShipmentTrackServicesInterface {
	public ResponseEntity showTrackandStatus(String code, String tracknumber) throws Exception;
	public ResponseEntity createTrackingServ(ShipmentInfo si) throws Exception;
}
