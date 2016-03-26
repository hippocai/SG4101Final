package com.ft9.common;

public class RedeemConfig {

	private static int dollar2RedeemValue=10;
	private static int redeem2DollarValue=20;
	
	public static int redeem2Dollar(int redeem){
		return redeem/redeem2DollarValue;
	}
	
	public static int intdoolar2Redeem(int dollar){
		return dollar/dollar2RedeemValue;
	}
}
