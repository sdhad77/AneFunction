package com.sdh.anefunction;

import android.app.Activity;
import android.os.Build;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class DeviceInfoFunction extends Activity implements FREFunction{
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {
		CharSequence message = "";
            
		try
		{
			message = arg1[0].getAsString();
			
			FREObject obj = FREObject.newObject("Object", null);
			
			if     (message == "BOARD")           obj.setProperty("BOARD",           FREObject.newObject(Build.BOARD));
			else if(message == "BRAND")           obj.setProperty("BRAND",           FREObject.newObject(Build.BRAND));
			else if(message == "CPU_ABI")         obj.setProperty("CPU_ABI",         FREObject.newObject(Build.CPU_ABI));
			else if(message == "DEVICE")          obj.setProperty("DEVICE",          FREObject.newObject(Build.DEVICE));
			else if(message == "DISPLAY")         obj.setProperty("DISPLAY",         FREObject.newObject(Build.DISPLAY));
			else if(message == "FINGERPRINT")     obj.setProperty("FINGERPRINT",     FREObject.newObject(Build.FINGERPRINT));
			else if(message == "HOST")            obj.setProperty("HOST",            FREObject.newObject(Build.HOST));
			else if(message == "ID")              obj.setProperty("ID",              FREObject.newObject(Build.ID));
			else if(message == "MANUFACTURER")    obj.setProperty("MANUFACTURER",    FREObject.newObject(Build.MANUFACTURER));
			else if(message == "MODEL")           obj.setProperty("MODEL",           FREObject.newObject(Build.MODEL));
			else if(message == "PRODUCT")         obj.setProperty("PRODUCT",         FREObject.newObject(Build.PRODUCT));
			else if(message == "TAGS")            obj.setProperty("TAGS",            FREObject.newObject(Build.TAGS));
			else if(message == "TYPE")            obj.setProperty("TYPE",            FREObject.newObject(Build.TYPE));
			else if(message == "USER")            obj.setProperty("USER",            FREObject.newObject(Build.USER));
			else if(message == "VERSION.RELEASE") obj.setProperty("VERSION.RELEASE", FREObject.newObject(Build.VERSION.RELEASE));

			return obj;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
