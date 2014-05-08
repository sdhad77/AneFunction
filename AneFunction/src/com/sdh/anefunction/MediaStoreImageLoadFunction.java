package com.sdh.anefunction;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class MediaStoreImageLoadFunction implements FREFunction
{
	private Context _mContext;
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1)
	{
		_mContext = arg0.getActivity();

		ArrayList<String> thumbsDataList = new ArrayList<String>();
		
		int dataCnt = getThumbInfo(thumbsDataList);

		try
		{
			FREObject obj = FREObject.newObject("Object", null);
			
			for(int i = 0; i < dataCnt; i++) obj.setProperty("img" + i, FREObject.newObject(thumbsDataList.get(i).toString()));
			
			return obj;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        
		return null;
	}
    
	/**
	 * 저장소에 저장되어있는 이미지들의 경로를 읽고 저장하는 함수
	 * @param thumbsDatas 이미지들의 경로를 저장할 ArrayList
	 * @return 경로를 알아내서 저장한 이미지들의 갯수
	 */
	private int getThumbInfo(ArrayList<String> thumbsDatas)
	{
		int dataCnt = 0;
		String[] proj = {MediaStore.Images.Media.DATA};
		Cursor imageCursor = _mContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, proj, null, null, null);

		if (imageCursor != null && imageCursor.moveToFirst())
		{
			String thumbsData;
			int thumbsDataCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
			
			do
			{
				thumbsData = imageCursor.getString(thumbsDataCol);
				if (thumbsData != null)
				{
					thumbsDatas.add(thumbsData);
					dataCnt++;
				}
			}
			while (imageCursor.moveToNext());
		}
		imageCursor.close();
		
		return dataCnt;
	}
}
