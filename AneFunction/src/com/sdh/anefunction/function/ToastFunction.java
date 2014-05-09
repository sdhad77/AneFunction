package com.sdh.anefunction.function;
 
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
 
/**
 * 토스트를 출력하는 간단한 클래스입니다.
 * @author 신동환
 */
public class ToastFunction implements FREFunction
{
    @Override
    public FREObject call(FREContext arg0, FREObject[] arg1)
    {
        CharSequence message = "";
        
        try
        {
        	//출력할 메시지를 받아옵니다
            message = arg1[0].getAsString();
        }
        catch (Exception e)
		{
			e.printStackTrace();
		}
        
        //토스트 출력
        Toast.makeText(arg0.getActivity(), message, Toast.LENGTH_SHORT).show();
        
        return null;
    }
}