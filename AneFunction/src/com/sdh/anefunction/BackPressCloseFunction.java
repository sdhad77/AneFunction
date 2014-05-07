package com.sdh.anefunction;

import android.app.Activity;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * Back 버튼을 한번 누르면 toast, 두번 누르면 종료되게 하는 클래스</br>
 * http://javacan.tistory.com/235
 * @author 신동환
 */
public class BackPressCloseFunction implements FREFunction
{
	private long backKeyPressedTime = 0;

	public boolean onBackPressed(Activity activity) 
	{
		if(System.currentTimeMillis() - backKeyPressedTime > 2000)
		{
			backKeyPressedTime = System.currentTimeMillis();
			Toast.makeText(activity, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
			return false;
		}
		else if(System.currentTimeMillis() - backKeyPressedTime <= 2000) return true;
		
		return false;
	}
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) 
	{
		try
		{
			FREObject obj = FREObject.newObject("Object", null);
			obj.setProperty("BackKeyPressEnd", FREObject.newObject(onBackPressed(arg0.getActivity())));
			
			return obj;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
