package abhishek;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FitAppTest {
	
	@Test
	void TestUploadCsv() {
		
		UploadCsv uc=new UploadCsv();
		
		assertEquals(0,uc.getId());
		assertEquals(0,uc.getDistance());
		assertEquals(0,uc.getCid());
		
	}
}
