//////////////////////////////////////////////////////////////////////////////////////
//
//  Copyright 2012 Freshplanet (http://freshplanet.com | opensource@freshplanet.com)
//  
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//  
//    http://www.apache.org/licenses/LICENSE-2.0
//  
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//  
//////////////////////////////////////////////////////////////////////////////////////

package com.sdh.anefunction.function.facebook;

import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sdh.anefunction.AneFunctionExtension;

public class LogInFunction implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] args)
	{
		String appID = "";
		
		try
		{
			appID = args[0].getAsString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(AneFunctionExtension.context.login(appID)) Toast.makeText(context.getActivity(), "페이스북 초기화에 성공하였습니다.", Toast.LENGTH_SHORT).show();
		else Toast.makeText(context.getActivity(), "페이스북 초기화에 실패하였습니다.", Toast.LENGTH_SHORT).show();
		
		return null;
	}
}