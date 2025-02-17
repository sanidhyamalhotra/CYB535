package com.classwork.java_code;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaCodeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void mainMethodTest() {
        // This test can ensure the main method runs as expected by invoking it.
        JavaCodeApplication.main(new String[]{});
    }
}
