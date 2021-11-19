package com.example.logisticModule.DTOmodals;

import java.time.LocalDateTime;
import java.util.Date;

public class Tracking {

	 
	 private String id;
	 private String tracking_number;
	 private String courier_code;
	 private String order_id;
	/* private String origin_country_iso3;
	 private String destination_country_iso3;*/
	 private String origin_country ;
	 private String destination_country ;
	 private String current_status;
	 private String created_at;
//	 private String updated_at;
	 private String last_updated_at;
	 private String pickup_location;
	 private String courier_tracking_link;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public String getCourier_code() {
		return courier_code;
	}
	public void setCourier_code(String courier_code) {
		this.courier_code = courier_code;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrigin_country() {
		return origin_country;
	}
	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}
	public String getDestination_country() {
		return destination_country;
	}
	public void setDestination_country(String destination_country) {
		this.destination_country = destination_country;
	}
	public String getCurrent_status() {
		return current_status;
	}
	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}
	 
	  
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getLast_updated_at() {
		return last_updated_at;
	}
	public void setLast_updated_at(String last_updated_at) {
		this.last_updated_at = last_updated_at;
	}

	public String getPickup_location() {
		return pickup_location;
	}
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}
	public String getCourier_tracking_link() {
		return courier_tracking_link;
	}
	public void setCourier_tracking_link(String courier_tracking_link) {
		this.courier_tracking_link = courier_tracking_link;
	}
	 
//	 private String courier_destination_country_iso3;
//	 private String tracking_destination_country;
	 
//	 private String tracking_postal_code;
//	 private String tracking_state;
	 

	 
	 
}
