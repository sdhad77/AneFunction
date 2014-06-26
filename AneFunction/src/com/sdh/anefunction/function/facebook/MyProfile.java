package com.sdh.anefunction.function.facebook;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;
import com.sdh.anefunction.AneFunctionExtension;

public class MyProfile
{
	public FREObject call(FREContext context, FREObject[] args)
	{
		AneFunctionExtension.context.myProfile();
		
		return null;
	}
}
