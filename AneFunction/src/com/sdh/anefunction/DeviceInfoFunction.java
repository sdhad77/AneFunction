package com.sdh.anefunction;

import android.app.Activity;
import android.os.Build;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DeviceInfoFunction extends Activity implements FREFunction{
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {
		
		try
		{
			FREObject obj = FREObject.newObject("Object", null);
			obj.setProperty("BOARD",           FREObject.newObject(Build.BOARD));
			obj.setProperty("BRAND",           FREObject.newObject(Build.BRAND));
			obj.setProperty("CPU_ABI",         FREObject.newObject(Build.CPU_ABI));
			obj.setProperty("DEVICE",          FREObject.newObject(Build.DEVICE));
			obj.setProperty("DISPLAY",         FREObject.newObject(Build.DISPLAY));
			obj.setProperty("FINGERPRINT",     FREObject.newObject(Build.FINGERPRINT));
			obj.setProperty("HOST",            FREObject.newObject(Build.HOST));
			obj.setProperty("ID",              FREObject.newObject(Build.ID));
			obj.setProperty("MANUFACTURER",    FREObject.newObject(Build.MANUFACTURER));
			obj.setProperty("MODEL",           FREObject.newObject(Build.MODEL));
			obj.setProperty("PRODUCT",         FREObject.newObject(Build.PRODUCT));
			obj.setProperty("TAGS",            FREObject.newObject(Build.TAGS));
			obj.setProperty("TYPE",            FREObject.newObject(Build.TYPE));
			obj.setProperty("USER",            FREObject.newObject(Build.USER));
			obj.setProperty("VERSION.RELEASE", FREObject.newObject(Build.VERSION.RELEASE));
			
			return obj;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
