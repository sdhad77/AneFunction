package com.sdh.anefunction;
 
import java.util.HashMap;
import java.util.Map;
 






import android.os.Vibrator;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.sdh.anefunction.function.BackPressCloseFunction;
import com.sdh.anefunction.function.DeviceInfoFunction;
import com.sdh.anefunction.function.MediaStoreImageLoadFunction;
import com.sdh.anefunction.function.ToastFunction;
import com.sdh.anefunction.function.VibrationFunction;
 
public class AneFunctionContext extends FREContext {
 
	public Vibrator androidVibrator = null;

	public AneFunctionContext()
	{
	}
	
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    	androidVibrator = null;
    }
 
    @Override
    public Map<String, FREFunction> getFunctions() {
        // TODO Auto-generated method stub
        Map<String, FREFunction> map = new HashMap<String, FREFunction>();
        map.put("toast", new ToastFunction());
        map.put("vibration", new VibrationFunction());
        map.put("deviceinfo", new DeviceInfoFunction());
        map.put("backpress", new BackPressCloseFunction());
        map.put("mediastoreimageload", new MediaStoreImageLoadFunction());
        return map;
    }
 
}