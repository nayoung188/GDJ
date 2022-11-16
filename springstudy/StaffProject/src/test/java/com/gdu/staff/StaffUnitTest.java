package com.gdu.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})


public class StaffUnitTest {

	@Autowired
	private StaffMapper staffMapper;
	
	@Test
	public void 사원삽입테스트() {
		StaffDTO staff = new StaffDTO("99999", "김기획", "기획부", 5000);
		assertEquals(1, staffMapper.insertStaff(staff));
	}
	
	@Test
	public void 사원조회테스트() {
		assertNotNull(staffMapper.findStaffList("99999"));
	}
	
}
