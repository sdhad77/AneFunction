package com.sdh.anefunction;
 
import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.sdh.anefunction.function.BackPressCloseFunction;
import com.sdh.anefunction.function.DeviceInfoFunction;
import com.sdh.anefunction.function.MediaStoreImageLoadFunction;
import com.sdh.anefunction.function.ToastFunction;
import com.sdh.anefunction.function.VibrationFunction;
 
public class AneFunctionContext extends FREContext
{
	public AneFunctionContext()
	{
	}
	
    @Override
    public void dispose()
    {
    }
 
    @Override
    public Map<String, FREFunction> getFunctions()
    {
        Map<String, FREFunction> map = new HashMap<String, FREFunction>();
        map.put("toast", new ToastFunction());
        map.put("vibration", new VibrationFunction());
        map.put("deviceinfo", new DeviceInfoFunction());
        map.put("backpress", new BackPressCloseFunction());
        map.put("mediastoreimageload", new MediaStoreImageLoadFunction());
        return map;
    }
}