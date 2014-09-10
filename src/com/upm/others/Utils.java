package com.upm.others;

import java.io.InputStream;
import java.io.OutputStream;

import com.google.android.gcm.GCMRegistrar;
import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.App42Log;
import com.upm.app42.App42GCMService;

public class Utils {
    public static void CopyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
              int count=is.read(bytes, 0, buffer_size);
              if(count==-1)
                  break;
              os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
    
    public static void registerWithApp42(String projectNo) {
		App42Log.debug(" ..... Registeration Check ....");
		App42GCMService.setSenderId(projectNo);
			final String deviceRegId = GCMRegistrar.getRegistrationId(App42API.appContext);
			if (deviceRegId.equals("")) {
				// Automatically registers application on startup.
				GCMRegistrar.register(App42API.appContext, projectNo);
				
			} else  {
					App42Log.debug(" Registering on Server ....");
					
						App42API.buildPushNotificationService().storeDeviceToken(App42API.getLoggedInUser(), deviceRegId, new App42CallBack() {
							
							@Override
							public void onSuccess(Object paramObject) {
								// TODO Auto-generated method stub
								App42Log.debug(" ..... Registeration Success ....");
								GCMRegistrar.setRegisteredOnServer(App42API.appContext, true);
							}
							
							@Override
							public void onException(Exception paramException) {
								App42Log.debug(" ..... Registeration Failed ....");
								App42Log.debug("storeDeviceToken :  Exception : on start up " +paramException);
								
							}
						});
					

				}
			}

}