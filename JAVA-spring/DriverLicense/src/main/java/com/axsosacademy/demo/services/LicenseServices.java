package com.axsosacademy.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsosacademy.demo.models.License;
import com.axsosacademy.demo.repositories.LicenseRepository;



@Service
public class LicenseServices {
	
	private final LicenseRepository licenseRepository;

	private static String newNumber = "000000";

	public LicenseServices(LicenseRepository licenseRepository) {
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
		}}}
