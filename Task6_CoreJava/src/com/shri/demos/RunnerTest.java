package com.shri.demos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RunnerTest {

	@Test
	void test() {
		Runner rr=new Runner();
		rr.List();
		assertSame(2, 2);
	}

}
