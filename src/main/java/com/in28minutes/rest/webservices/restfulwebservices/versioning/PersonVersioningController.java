package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	//////////////////////////////////////////////////////////////
	// No.1 - v1, v2
	// URI versioning
	// Twitter
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	//////////////////////////////////////////////////////////////
	// No.2 - params
	// Request parameter versioning
	// Amazon
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	//////////////////////////////////////////////////////////////
	// No.3 - header
	// Custome Header versioning
	// Microsoft
	@GetMapping(value = "/person/header", headers = "X_API_VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/header", headers = "X_API_VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	//////////////////////////////////////////////////////////////
	// No.4 - produces
	// Mime type versioning - "Content negociation" - "accept header"
	// Also called "Media type versioning"
	// GitHub
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	//@formatter:off
	/**
	 * Factors
	 * -- URI Pollution
	 * 		-- URI versioning & Request Parameter versioning pollute the URI
	 * -- Misuse of HTTP headers
	 * 		-- Mimi Type versioning & Headers versioning are misusing HTTP headers
	 * -- Caching
	 * 		-- Caching is difficulte for Mime Type Versioning & Headers versioning
	 * 		-- Caching is esay for URI versioning & Parameter versioning because the version is part of the URI
	 * -- Can we execute a request on the browser ? (Should care for the consumers of our API)
	 * 		-- Difficult to execute the requests for Mimi Type Versioning & Headers versioning, to be able to do it
	 * 			-- You have to install some plugins
	 * 			-- & having some technical knowledges to be able to configure an HTTP header
	 * --  
	 */
	//@formatter:on
	// Factors
	// - URI pollution
	//
	// - Misuse of HTTP headers
}
