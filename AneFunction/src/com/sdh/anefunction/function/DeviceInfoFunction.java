package com.sdh.anefunction.function;

import android.app.Activity;
import android.os.Build;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * device 정보들을 문자열 하나로 만들어서 반환하는 클래스입니다
 * @author 신동환
 */
public class DeviceInfoFunction extends Activity implements FREFunction
{
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) 
	{
		String str =  "BOARD = "             + Build.BOARD        +
                      "\nBRAND = "           + Build.BRAND        +
                      "\nCPU_ABI = "         + Build.CPU_ABI      +
                      "\nDEVICE = "          + Build.DEVICE       +
                      "\nDISPLAY = "         + Build.DISPLAY      +
                      "\nFINGERPRINT = "     + Build.FINGERPRINT  +
                      "\nHOST = "            + Build.HOST         +
                      "\nID = "              + Build.ID           +
                      "\nMANUFACTURER = "    + Build.MANUFACTURER +
                      "\nMODEL = "           + Build.MODEL        +
                      "\nPRODUCT = "         + Build.PRODUCT      +
                      "\nTAGS = "            + Build.TAGS         +
                      "\nTYPE = "            + Build.TYPE         +
                      "\nUSER = "            + Build.USER         +
                      "\nVERSION.RELEASE = " + Build.VERSION.RELEASE;
		try
		{
			FREObject obj = FREObject.newObject("Object", null);
			obj.setProperty("Info", FREObject.newObject(str));

			return obj;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
