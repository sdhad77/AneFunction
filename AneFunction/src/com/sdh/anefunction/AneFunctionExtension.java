package com.sdh.anefunction;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
  
public class AneFunctionExtension implements FREExtension
{
    @Override
    public FREContext createContext(String arg0)
    {
        return new AneFunctionContext();
    }
 
    @Override
    public void dispose()
    {
    }
 
    @Override
    public void initialize()
    {
    }
}
