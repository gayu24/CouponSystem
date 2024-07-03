package org.coupon;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Coupon implements Delayed {
	private String code; 
	private long expirationTime; 
	
	public Coupon(String code, long delay) {
		this.code = code;
		this.expirationTime = System.currentTimeMillis() + delay;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = expirationTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed other) {
		if (this.expirationTime < ((Coupon) other).expirationTime) {
			return -1;
		}
		if (this.expirationTime > ((Coupon) other).expirationTime) {
			return 1;
		}
		return 0;
	}

	public String getCode() {
		return code;
	}

	public long getExpirationTime() {
		return expirationTime;
	}
}


