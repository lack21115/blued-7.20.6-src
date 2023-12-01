package com.vivo.push.util;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/NotifyUtil.class */
public class NotifyUtil {
    private static BaseNotifyDataAdapter sNotifyData;
    private static String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
    private static BaseNotifyLayoutAdapter sNotifyLayout;
    private static String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";

    public static BaseNotifyDataAdapter getNotifyDataAdapter(Context context) {
        initAdapter(context);
        return sNotifyData;
    }

    public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context context) {
        initAdapter(context);
        return sNotifyLayout;
    }

    private static Object getObjectByReflect(String str, Object obj) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (Exception e) {
            cls = null;
        }
        Object obj2 = null;
        if (cls != null) {
            try {
                obj2 = cls.newInstance();
            } catch (Exception e2) {
                obj2 = null;
            }
        }
        return obj2 == null ? obj : obj2;
    }

    private static void initAdapter(Context context) {
        synchronized (NotifyUtil.class) {
            try {
                if (sNotifyData == null) {
                    BaseNotifyDataAdapter baseNotifyDataAdapter = (BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new h());
                    sNotifyData = baseNotifyDataAdapter;
                    baseNotifyDataAdapter.init(context);
                }
                if (sNotifyLayout == null) {
                    BaseNotifyLayoutAdapter baseNotifyLayoutAdapter = (BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new i());
                    sNotifyLayout = baseNotifyLayoutAdapter;
                    baseNotifyLayoutAdapter.init(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
