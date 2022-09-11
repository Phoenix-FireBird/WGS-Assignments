package test;

import org.junit.jupiter.api.Test;

import com.runner.daily.demo.Runner;


class RunnerTest {

	@Test
	void testRegisterNewRunner() {
		
		Runner r1 = new Runner();
		r1.registerNewRunner();
		
	}

	@Test
	void testAllRunnersList() {
		Runner r1 = new Runner();
		r1.allRunnersList();
	}

	@Test
	void testTotalRunnerPerCity() {
		Runner r1 = new Runner();
		r1.totalRunnerPerCity();
	}

}
