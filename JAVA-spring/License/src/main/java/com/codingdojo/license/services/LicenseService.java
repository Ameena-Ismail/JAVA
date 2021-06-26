package com.codingdojo.license.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.License;
import com.codingdojo.license.repositories.LicenseRepository;

@Service
public class LicenseService {
	// adding the license repository as a dependency
	private final LicenseRepository licenseRepository;

	private static String newNumber = "000000";

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	// create a license
	public License createLicense(License license) {

		newNumber = String.format("%06d", Integer.parseInt(newNumber) + 1);
		license.setNumber(newNumber);
		return licenseRepository.save(license);
	}

	// find License by id
	public License findLicense(Long id) {
		Optional<License> findLic = licenseRepository.findById(id);
		if (findLic.isPresent()) {
			return findLic.get();
		} else {
			return null;
		}
	}
}
