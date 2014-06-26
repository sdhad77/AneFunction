package com.sdh.anefunction.function.facebook;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sdh.anefunction.AneFunctionExtension;

public class LogOutFunction implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] args)
	{
		AneFunctionExtension.context.logout();
		
		return null;
	}
}