package com.witapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Junit {

	@Test
	void totalRunner() throws Exception {
        Runner r5= new Runner();
		r5.totalRunner();
		assertSame(1,2);
				
	}

	private void assertSame(int i, int j) {
		// TODO Auto-generated method stub
		
	}

}
