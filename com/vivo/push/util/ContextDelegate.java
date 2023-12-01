package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/ContextDelegate.class */
public class ContextDelegate {
    private static final String TAG = "ContextDelegate";
    private static Context mContext;
    private static Method mCreateCredentialProtectedStorageContext;
    private static Method mCreateDeviceProtectedStorageContext;
    private static boolean mDelegateEnable = false;
    private static Boolean mIsFbeProject;

    /* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/ContextDelegate$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static ContextDelegate f27437a = new ContextDelegate();
    }

    private static Context createCredentialProtectedStorageContext(Context context) {
        try {
            if (mCreateCredentialProtectedStorageContext == null) {
                mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
            }
            return (Context) mCreateCredentialProtectedStorageContext.invoke(context, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return context;
        }
    }

    private static Context createDeviceProtectedStorageContext(Context context) {
        try {
            if (mCreateDeviceProtectedStorageContext == null) {
                mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
            }
            return (Context) mCreateDeviceProtectedStorageContext.invoke(context, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return context;
        }
    }

    public static Context getContext(Context context) {
        Context context2 = context;
        if (isFBEProject()) {
            if (context == null) {
                return context;
            }
            Context context3 = mContext;
            if (context3 != null) {
                return context3;
            }
            setContext(context);
            context2 = mContext;
        }
        return context2;
    }

    public static ContextDelegate getInstance() {
        return a.f27437a;
    }

    public static boolean isFBEProject() {
        if (mIsFbeProject == null) {
            try {
                mIsFbeProject = Boolean.valueOf(ContentResolver.SCHEME_FILE.equals(j.a("ro.crypto.type", "unknow")));
                p.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
            } catch (Exception e) {
                p.a(TAG, "mIsFbeProject = " + e.getMessage());
            }
        }
        Boolean bool = mIsFbeProject;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static void setAppContext() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    private static void setContext(Context context) {
        mContext = !mDelegateEnable ? createCredentialProtectedStorageContext(context) : createDeviceProtectedStorageContext(context);
    }

    public static void setEnable(boolean z) {
        mDelegateEnable = z;
        setAppContext();
    }
}
