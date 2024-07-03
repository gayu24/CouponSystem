package org.coupon;

import java.util.concurrent.DelayQueue;

public class CouponStore {
	private DelayQueue<Coupon> delayQueue;

	public  CouponStore() {
		
		delayQueue = new DelayQueue<>();
	}

	public void addCoupon(Coupon coupon) {
		delayQueue.offer(coupon);
		System.out.println("coupon: " + coupon.getCode() + " and expiration time: " + coupon.getExpirationTime());
	}

	public void startProcessing() {
		Thread processor = new Thread(() -> {
			try {
				while (true) {
					Coupon coupon = delayQueue.take();
					System.out.println("expired coupon: " + coupon.getCode());
				}
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println("Expired coupon thread interrupted");
			}
		});
		processor.setDaemon(true);
		processor.start();
	}
}



