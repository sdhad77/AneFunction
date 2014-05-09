package com.sdh.anefunction;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 갤러리 기능을 위해 저장소에서 이미지들의 경로를 찾아 저장,반환하는 클래스입니다.</br>
 * http://mainia.tistory.com/497
 * @author 신동환
 */
public class MediaStoreImageLoadFunction implements FREFunction
{
	private Context _mContext;
	
	//받아온 이미지 경로 앞에 붙여줄 문자열입니다.
	final private String FILE_PATH = "file://";
	
	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1)
	{
		_mContext = arg0.getActivity();

		//이미지 경로가 저장될 ArrayList입니다.
		ArrayList<String> thumbsDataList = new ArrayList<String>();
		
		//이미지 경로를 받아오고(thumbsDataList), 받아온 이미지 갯수를 dataCnt에 저장합니다.
		int dataCnt = getThumbInfo(thumbsDataList);

		try
		{
			FREObject obj = FREObject.newObject("Object", null);
			
			//다음의 형태로 이미지 경로들을 Object에 저장합니다.
			//key : "img + 숫자", value : 경로
			for(int i = 0; i < dataCnt; i++) obj.setProperty("img" + i, FREObject.newObject(thumbsDataList.get(i).toString()));
			
			//이미지 경로 갯수를 저장합니다.
			obj.setProperty("imgcnt", FREObject.newObject(dataCnt));
			
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
		//이미지 갯수입니다.
		int dataCnt = 0;
		
		//이미지 경로만 받아옵니다.
		String[] proj = {MediaStore.Images.Media.DATA};
		
		//이미지 커서입니다.
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
					//읽어온 이미지 경로에 파일경로를 붙여서 저장합니다.
					thumbsDatas.add(FILE_PATH + thumbsData);
					dataCnt++;
				}
			}//아직 읽을 이미지가 남아있으면 계속 읽어옵니다.
			while (imageCursor.moveToNext());
		}
		imageCursor.close();
		
		//이미지 갯수를 반환합니다.
		return dataCnt;
	}
}
