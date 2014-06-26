package com.sdh.anefunction;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
  
public class AneFunctionExtension implements FREExtension
{
	public static String TAG = "AirFacebook";
	private static Boolean PRINT_LOG = true;
	
	public static AneFunctionContext context;
	
    @Override
    public FREContext createContext(String arg0)
    {
        return context = new AneFunctionContext();
    }
 
    @Override
    public void dispose()
    {
    	context = null;
    }
 
    @Override
    public void initialize()
    {
    }
    
	public static void log(String message)
	{
		if (PRINT_LOG) Log.d(TAG, message);
		if (context != null && message != null) context.dispatchStatusEventAsync("LOGGING", message);
	}
	
	public static int getResourceId(String name)
	{
		return context != null ? context.getResourceId(name) : 0;
	}
}
