package test;

import org.junit.jupiter.api.Test;

import com.runner.daily.demo.DailyActivity;

class DailyActivityTest {

	@Test
	void testDailyActivityRunner() {
		DailyActivity d1 = new DailyActivity();
		d1.dailyActivityRunner();
	}

	@Test
	void testUploadCsv() {
		DailyActivity d1 = new DailyActivity();
		d1.uploadCsv();
	}

	@Test
	void testAverageRun() {
		DailyActivity d1 = new DailyActivity();
		d1.averageRun();
	}

}
