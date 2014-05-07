package com.sdh.anefunction;

import android.app.Activity;
import android.widget.Toast;
import android.os.Build;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DeviceInfoFunction extends Activity implements FREFunction{
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {
		
		String str =  "BOARD = " + Build.BOARD +
					"\nBRAND = " + Build.BRAND +
					"\nCPU_ABI = " + Build.CPU_ABI +
					"\nDEVICE = " + Build.DEVICE +
					"\nDISPLAY = " + Build.DISPLAY +
					"\nFINGERPRINT = " + Build.FINGERPRINT +
					"\nHOST = " + Build.HOST +
					"\nID = " + Build.ID +
					"\nMANUFACTURER = " + Build.MANUFACTURER +
					"\nMODEL = " + Build.MODEL +
					"\nPRODUCT = " + Build.PRODUCT +
					"\nTAGS = " + Build.TAGS +
					"\nTYPE = " + Build.TYPE +
					"\nUSER = " + Build.USER +
					"\nVERSION.RELEASE = " + Build.VERSION.RELEASE;

		Toast.makeText(arg0.getActivity(), str, Toast.LENGTH_LONG).show();

		return null;
	}

}
