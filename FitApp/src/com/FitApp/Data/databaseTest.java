package com.FitApp.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

class databaseTest  {

	//Insert Runner
	@Test
	void CASE1()
	{	
		Database db= new Database();
		
			db.DisplayRunner();
			assertEquals(0,10);
					
		}
	


}
