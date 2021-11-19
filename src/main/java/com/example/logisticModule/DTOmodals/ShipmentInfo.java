package com.example.logisticModule.DTOmodals;

import java.util.Date;

public class ShipmentInfo {

	private String slug;
	private String tracking_number;
	private String title;
	private String[] smses;
	private String[] emails;
	private String order_id;
	private String order_id_path;
	private CustomFields custom_fields;
	private String language;
	private Date order_promised_delivery_date;
	private String delivery_type;
	private String pickup_location;
	private String pickup_note;
	
	private String origin_country ;
	 private String destination_country ;
	
	
	
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getSmses() {
		return smses;
	}
	public void setSmses(String[] smses) {
		this.smses = smses;
	}
	public String[] getEmails() {
		return emails;
	}
	public void setEmails(String[] emails) {
		this.emails = emails;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_id_path() {
		return order_id_path;
	}
	public void setOrder_id_path(String order_id_path) {
		this.order_id_path = order_id_path;
	}

	public CustomFields getCustom_fields() {
		return custom_fields;
	}
	public void setCustom_fields(CustomFields custom_fields) {
		this.custom_fields = custom_fields;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getOrder_promised_delivery_date() {
		return order_promised_delivery_date;
	}
	public void setOrder_promised_delivery_date(Date order_promised_delivery_date) {
		this.order_promised_delivery_date = order_promised_delivery_date;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}
	public String getPickup_location() {
		return pickup_location;
	}
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}
	public String getPickup_note() {
		return pickup_note;
	}
	public void setPickup_note(String pickup_note) {
		this.pickup_note = pickup_note;
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
	 
	
	
}
