package com.sdh.anefunction.function;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.sdh.anefunction.AneFunctionContext;

public class VibrationFunction extends Activity implements FREFunction{
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {

		int vibTime = 1000;
		AneFunctionContext vibExtContext = (AneFunctionContext) arg0;
		
		Activity a = vibExtContext.getActivity();

		vibExtContext.androidVibrator = (Vibrator) a.getSystemService(Context.VIBRATOR_SERVICE);
		
		Toast.makeText(arg0.getActivity(), "진동이다!!", Toast.LENGTH_LONG).show();
		
		try {
			vibTime = arg1[0].getAsInt();
			vibExtContext.androidVibrator.vibrate(vibTime);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
