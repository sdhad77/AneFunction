package com.sdh.anefunction.function.facebook;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sdh.anefunction.AneFunctionExtension;

public class StatusUpdateFunction implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] args)
	{
		String str = "";
		
		try
		{
			str = args[0].getAsString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		AneFunctionExtension.context.statusUpdate(str);
		
		return null;
	}
}