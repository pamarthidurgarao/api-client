package com.pamarthi.api.services;

import com.pamarthi.api.exceptions.NotFoundException;

public interface GoogleApiService {

	String searchPlace(String test) throws NotFoundException;

	String getPlaceById(String id) throws NotFoundException;

}
