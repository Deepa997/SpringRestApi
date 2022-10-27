package com.thbs.StudentData.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentRepoTest {

	@Test
	void test() {
		StudentRepo.findById(10);
	}

}
