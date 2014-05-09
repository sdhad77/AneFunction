package com.sdh.anefunction.function;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 진동 기능을 사용하는 클래스입니다.
 * @author 신동환
 */
public class VibrationFunction extends Activity implements FREFunction
{
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1)
	{
		Vibrator androidVibrator = (Vibrator) arg0.getActivity().getSystemService(Context.VIBRATOR_SERVICE);

		try 
		{
			androidVibrator.vibrate(arg1[0].getAsInt());
			Toast.makeText(arg0.getActivity(), "진동", Toast.LENGTH_SHORT).show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
