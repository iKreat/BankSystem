package com.pure.bank;

import java.util.Calendar;
import java.util.Date;

public class Record<A extends Asset> {
	public final Date date = currentDate();
	public final long assetID;
	
	public Record(A asset) {
		assetID = asset.getID();
	}
	
	public static final Date currentDate() {
		return Calendar.getInstance().getTime();
	}
}