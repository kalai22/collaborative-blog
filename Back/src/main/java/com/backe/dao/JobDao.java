package com.backe.dao;

import java.util.List;

import com.backe.model.Job;

public interface JobDao {

	void saveJobDetails(Job job);

	List<Job> getAllJobDetails();

	Job getJobById(int id);

}
