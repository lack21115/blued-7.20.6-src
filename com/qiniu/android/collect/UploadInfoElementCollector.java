package com.qiniu.android.collect;

import com.qiniu.android.collect.UploadInfoElement;
import com.qiniu.android.common.Constants;
import com.qiniu.android.http.UserAgent;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.ContextGetter;
import com.qiniu.android.utils.StringUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/collect/UploadInfoElementCollector.class */
public class UploadInfoElementCollector {
    public static LogHandler getUplogHandler(final Object obj) {
        return new LogHandler() { // from class: com.qiniu.android.collect.UploadInfoElementCollector.1
            @Override // com.qiniu.android.collect.LogHandler
            public Object getUploadInfo() {
                return Object.this;
            }

            @Override // com.qiniu.android.collect.LogHandler
            public void send(String str, Object obj2) {
                try {
                    if (obj2 instanceof String) {
                        Class<?> cls = Object.this.getClass();
                        cls.getMethod("set" + StringUtils.upperCase(str), Class.forName("java.lang.String")).invoke(Object.this, obj2);
                    } else if (obj2 instanceof Integer) {
                        Class<?> cls2 = Object.this.getClass();
                        cls2.getMethod("set" + StringUtils.upperCase(str), Integer.TYPE).invoke(Object.this, obj2);
                    } else if (obj2 instanceof Long) {
                        Class<?> cls3 = Object.this.getClass();
                        cls3.getMethod("set" + StringUtils.upperCase(str), Long.TYPE).invoke(Object.this, obj2);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    public static void setReqCommonElements(UploadInfoElement.ReqInfo reqInfo) {
        reqInfo.setOs_version(UserAgent.osVersion());
        reqInfo.setSdk_version(Constants.VERSION);
        reqInfo.setUp_time(System.currentTimeMillis() / 1000);
        reqInfo.setNetwork_type(AndroidNetwork.networkType(ContextGetter.applicationContext()));
        reqInfo.setSignal_strength(AndroidNetwork.getMobileDbm());
    }
}
