package com.example.logisticModule.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.logisticModule.DTOmodals.ShipmentInfo;
import com.example.logisticModule.DTOmodals.Tracking;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

@Service
public class ShipmentTrackServices  implements ShipmentTrackServicesInterface{

	Logger logger = LoggerFactory.getLogger(ShipmentTrackServices.class);

	public ResponseEntity showTrackandStatus(String code, String tracknumber) throws Exception {

		ShipmentTrackServices shipmentTrackServices = new ShipmentTrackServices();
		ResponseEntity tst = shipmentTrackServices.fetchTrackingDetails(code, tracknumber);

		return tst;

	}

	public ResponseEntity createTrackingServ(ShipmentInfo si) throws Exception {

		ShipmentTrackServices shipmentTrackServices = new ShipmentTrackServices();
		ResponseEntity re = shipmentTrackServices.createTrackingServThirdParty(si);
		return re;
	}

//Calling third Party API

	private ResponseEntity fetchTrackingDetails(String code, String tracknumber) throws IOException {
		Tracking trackingshipmentDetails = new Tracking();
		ResponseEntity re = null;
		int responseCode = 0;
		String responseMessage = null;
		try {
			URL obj = new URL("https://api.aftership.com/v4/trackings/" + code + "/" + tracknumber);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("aftership-api-key", "430a82b8-e5b5-48b7-8f10-dcda5b921245");
			responseCode = con.getResponseCode();
			responseMessage = con.getResponseMessage();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer responsesb = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				responsesb.append(inputLine);
			}
			in.close();

			JSONObject jsonObj = new JSONObject(responsesb.toString());
			jsonObj = (JSONObject) jsonObj.get("data");
			jsonObj = (JSONObject) jsonObj.get("tracking");
			logger.info("Succesfully Fetched the details for Tracking Number: " + jsonObj.getString("tracking_number"));

			trackingshipmentDetails.setId(jsonObj.getString("id"));
			trackingshipmentDetails.setTracking_number(jsonObj.getString("tracking_number"));
			trackingshipmentDetails.setCourier_code(jsonObj.getString("slug"));
			trackingshipmentDetails.setCurrent_status(jsonObj.getString("tag"));
			trackingshipmentDetails.setDestination_country(jsonObj.getString("destination_country_iso3"));
			trackingshipmentDetails.setOrigin_country(jsonObj.getString("origin_country_iso3"));
			trackingshipmentDetails.setOrder_id(jsonObj.getString("order_id"));
			trackingshipmentDetails.setCourier_tracking_link(jsonObj.getString("courier_tracking_link"));
			trackingshipmentDetails.setPickup_location(jsonObj.getString("pickup_location"));
			trackingshipmentDetails.setLast_updated_at(jsonObj.getString("last_updated_at"));
			trackingshipmentDetails.setCreated_at(jsonObj.getString("created_at"));
			re = ResponseEntity.ok().body(trackingshipmentDetails);
		} catch (IOException ex) {

			ex.printStackTrace();
			re = ResponseEntity.status(responseCode).body(responseMessage);
		}

		return re;
	}

	private ResponseEntity createTrackingServThirdParty(ShipmentInfo si) throws IOException {
		ResponseEntity re = null;

		String str = "{\"tracking\":{\"slug\":\"" + si.getSlug() + "\",\"tracking_number\":\"" + si.getTracking_number()
				+ "\"," + "\"title\":\"" + si.getTitle()
				+ "\",\"smses\":[\"+18555072509\",\"+18555072501\"],\"emails\":[\"email@yourdomain.com\",\"another_email@yourdomain.com\"],\"order_id\":\"ID 1234\",\"order_id_path\":\"http://www.aftership.com/order_id=1234\",\"custom_fields\":{\"product_name\":\"iPhone Case\",\"product_price\":\"USD19.99\"},\"language\":\"en\",\"order_promised_delivery_date\":\"2019-05-20\",\"delivery_type\":\"pickup_at_store\","
				+ "\"pickup_location\":\"" + si.getPickup_location() + "\"," + "\"origin_country_iso3\":\""
				+ si.getOrigin_country() + "\"," + "\"destination_country_iso3\":\"" + si.getDestination_country()
				+ "\"," + "\"pickup_note\":\"" + si.getPickup_note() + "\"" + "}}";

		OkHttpClient client = new OkHttpClient();
//		MediaType mediaType = MediaType.parse("application/json");
		JSONObject jsonObj = new JSONObject(str);
		RequestBody body = RequestBody.create(MediaType.parse("text/json"), jsonObj.toString());
		Request request = new Request.Builder().url("https://api.aftership.com/v4/trackings").post(body)
				.addHeader("Accept", "application/json").addHeader("Content-Type", "application/json")
				.addHeader("aftership-api-key", "430a82b8-e5b5-48b7-8f10-dcda5b921245").build();
		try {
			Response response = client.newCall(request).execute();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		logger.info("Succesfully Created the Tracking for Tracking Number: " + si.getTracking_number());

		return re;
	}

}
