package org.coupon;

public class Main {
	public static void main(String[] args) {

		CouponStore coupon = new CouponStore();
		coupon.addCoupon(new Coupon("100% Cashback", 2000));
		coupon.addCoupon(new Coupon("Flat Rs 200 off", 4000));
		coupon.addCoupon(new Coupon("Free Lenskart", 8000));

		coupon.startProcessing();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


