package com.jasmine.utilities;

import com.jasmine.drivers.BaseDriver;

public class CommonMethod extends BaseDriver {
	
	public void timeout() throws InterruptedException {
		
		Thread.sleep(3000);
	}
	
	public void timeout(int time) throws InterruptedException {
		
		Thread.sleep(time);
	}


}
