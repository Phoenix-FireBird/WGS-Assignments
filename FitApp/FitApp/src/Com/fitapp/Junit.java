package Com.fitapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junit {

	@Test
	void totalRunner() throws Exception {
        Demo d4= new Demo();
		d4.totalRunner();
		assertSame(2,2);
				
	}

}
