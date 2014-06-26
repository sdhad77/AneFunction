package com.sdh.anefunction;
 
import java.util.HashMap;
import java.util.Map;

import android.content.Intent;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.sdh.anefunction.function.BackPressCloseFunction;
import com.sdh.anefunction.function.ToastFunction;
import com.sdh.anefunction.function.VibrationFunction;
import com.sdh.anefunction.function.facebook.LogInFunction;
import com.sdh.anefunction.function.facebook.LogOutFunction;
import com.sdh.anefunction.function.facebook.StatusUpdateFunction;
 
public class AneFunctionContext extends FREContext
{
	public AneFunctionContext()
	{
	}
	
    @Override
    public void dispose()
    {
    	AneFunctionExtension.context = null;
    }
 
    @Override
    public Map<String, FREFunction> getFunctions()
    {
        Map<String, FREFunction> map = new HashMap<String, FREFunction>();
        map.put("toast", new ToastFunction());
        map.put("vibration", new VibrationFunction());
        map.put("backpress", new BackPressCloseFunction());
        map.put("login", new LogInFunction());
        map.put("logout", new LogOutFunction());
        map.put("statusupdate", new StatusUpdateFunction());
        return map;
    }
    
    private String _appID;
	
	public Boolean login(String appID)
	{
		_appID = appID;
		
		if(_appID == null) return false;
		
		Intent i = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
		i.putExtra("param", "login");
		getActivity().startActivity(i);
		
		return true;
	}
	
	public void logout()
	{
		Intent i = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
		i.putExtra("param", "logout");
		getActivity().startActivity(i);
	}
	
	public void statusUpdate(String str)
	{
		Intent i = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
		i.putExtra("param", "statusUpdate");
		i.putExtra("param2", str);
		getActivity().startActivity(i);
	}
	
	public void myProfile()
	{
		Intent i = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
		i.putExtra("param", "myProfile");
		getActivity().startActivity(i);
	}
}