package com.sdh.anefunction.function;

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
	//최근에 Back 키가 눌렸던 시간을 저장.
	//이 시간과 현재 시간을 비교 하여 프로그램을 종료시킬 것인지 판단
	private long backKeyPressedTime = 0;

	/**
	 * Back 버튼이 눌린 시간을 비교하여 2초이내에 두번 눌린 경우 true 반환해서 프로그램 종료시킴
	 * @param activity 현재 화면
	 * @return 종료시켜야 되면 true 아니면 false
	 */
	public boolean onBackPressed(Activity activity) 
	{
		//2초 이내에 두번 눌리지 않았습니다
		if(System.currentTimeMillis() - backKeyPressedTime > 2000)
		{
			//현재 시간 저장, 토스트 출력을 합니다.
			backKeyPressedTime = System.currentTimeMillis();
			Toast.makeText(activity, "뒤로 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
			return false;
		}
		//2초 이내에 두번 눌렸습니다
		else if(System.currentTimeMillis() - backKeyPressedTime <= 2000) return true;
		
		return false;
	}
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) 
	{
		try
		{
			FREObject obj = FREObject.newObject("Object", null);
			
			//Back 버튼이 연타 됐는지에대한 결과를 저장합니다
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
