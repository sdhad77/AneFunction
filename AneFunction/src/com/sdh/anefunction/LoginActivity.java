//////////////////////////////////////////////////////////////////////////////////////
//
//  Copyright 2012 Freshplanet (http://freshplanet.com | opensource@freshplanet.com)
//  
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//  
//    http://www.apache.org/licenses/LICENSE-2.0
//  
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//  
//////////////////////////////////////////////////////////////////////////////////////

package com.sdh.anefunction;

import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Window;

public class LoginActivity extends Activity
{	
	private Session.StatusCallback statusCallback = new SessionStatusCallback();
	private String functionName = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent(); // 값을 받아온다.
		functionName = intent.getStringExtra("param");   
		AneFunctionExtension.log(functionName);
		
        Settings.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        
        Session session = Session.getActiveSession();
        if (session == null) {
            if (savedInstanceState != null) {
                session = Session.restoreSession(this, null, statusCallback, savedInstanceState);
            }
            if (session == null) {
                session = new Session(this);
            }
            Session.setActiveSession(session);
            if (session.getState().equals(SessionState.CREATED_TOKEN_LOADED)) {
                session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
            }
        }
        
        login();
	}

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Session.saveSession(Session.getActiveSession(), outState);
    }
    
    private void login()
    {
    	Session session = Session.getActiveSession();
        if (!session.isOpened() && !session.isClosed())
        {
            session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
        }
        else
        {
            Session.openActiveSession(this, true, statusCallback);
        }
    }

    private void logout()
    {
    	Session session = Session.getActiveSession();
    	session.closeAndClearTokenInformation();
    	finish();
    }
    
    private void statusUpdate()
    {
    	Session session = Session.getActiveSession();
    	if(session.isOpened())
    	{
            Request request = Request.newStatusUpdateRequest(session, getIntent().getStringExtra("param2"), null);
            Request.executeBatchAsync(request);
            finish();
    	}
    	else
		{
    		AneFunctionExtension.log("statusUpdate 실패");
		}
    }
    
    private void myProfile()
    {
    	Session session = Session.getActiveSession();
    	if(session.isOpened())
    	{
            Request request = Request.newMeRequest(session, null);
            Request.executeBatchAsync(request);
            finish();
    	}
    }
    
    private class SessionStatusCallback implements Session.StatusCallback
    {
        @Override
        public void call(Session session, SessionState state, Exception exception)
        {
        	if(functionName.equals("logout")) logout();
        	else if(functionName.equals("statusUpdate")) statusUpdate();
        	else if(functionName.equals("myProfile")) myProfile();
        	else if(functionName.equals("login") && Session.getActiveSession().isOpened() == true) finish();
        }
    }
}