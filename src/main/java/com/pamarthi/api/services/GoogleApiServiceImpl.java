package com.pamarthi.api.services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.pamarthi.api.exceptions.NotFoundException;

@Service
public class GoogleApiServiceImpl implements GoogleApiService {

	public static final String PLACE_URL = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=%s&key=%s";
	public static final String PLACE_BY_ID_URL = "https://maps.googleapis.com/maps/api/place/details/json?place_id=%s&key=%s";
	public static final String KEY = "AIzaSyA7ehIlzll-6Kci9hVhY6GsYXOF3J3HVeI";

	@Override
	public String searchPlace(String test) throws NotFoundException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet request = new HttpGet(String.format(PLACE_URL, test, KEY));
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String result = EntityUtils.toString(entity);
					return result;
				}

			} finally {
				response.close();
			}
		} catch (Exception e) {
			throw new NotFoundException();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				throw new NotFoundException();
			}
		}

		throw new NotFoundException();
	}

	@Override
	public String getPlaceById(String id) throws NotFoundException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet request = new HttpGet(String.format(PLACE_BY_ID_URL, id, KEY));
			CloseableHttpResponse response = httpClient.execute(request);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String result = EntityUtils.toString(entity);
					return result;
				}

			} finally {
				response.close();
			}
		} catch (Exception e) {
			throw new NotFoundException();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				throw new NotFoundException();
			}
		}

		throw new NotFoundException();
	}

}
