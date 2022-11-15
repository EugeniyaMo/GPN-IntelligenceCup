package ru.task.gpnintelligencecup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.task.gpnintelligencecup.service.UserService;

@SpringBootTest
class GpnIntelligenceCupApplicationTests {

	@Autowired
	UserService userService;
	@Test
	void contextLoads() {
	}

}
