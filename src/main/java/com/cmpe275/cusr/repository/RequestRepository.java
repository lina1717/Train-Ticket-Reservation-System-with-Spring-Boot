package com.cmpe275.cusr.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


import com.cmpe275.cusr.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
	
	
	@Query("SELECT COUNT(REQUEST_ID) from Request r WHERE r.date = ?1")
	int getTotalCount(String date);
	
	@Query("SELECT COUNT(REQUEST_ID) from Request r WHERE r.numberOfConnections = ?1")
	int getCountOnConnectionType(String numberOfConnections);
	
	List<Request> findByNumberOfConnectionsAndDate(String numberOfConnections, String date);
	
}