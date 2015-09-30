package com.pure.bank;

public class Asset {
	private static long newID = 0;
	private final long assetID;
	public final long getID() {
		return assetID;
	}
	
	protected Asset() {
		synchronized(this) {
			assetID = newID++;
		}
	}
}