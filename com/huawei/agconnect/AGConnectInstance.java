package com.huawei.agconnect;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.core.a.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/AGConnectInstance.class */
public abstract class AGConnectInstance {
    public static AGConnectInstance buildInstance(AGConnectOptions aGConnectOptions) {
        return b.a(aGConnectOptions);
    }

    public static AGConnectInstance getInstance() {
        return b.a();
    }

    public static AGConnectInstance getInstance(String str) {
        return b.a(str);
    }

    public static void initialize(Context context) {
        synchronized (AGConnectInstance.class) {
            try {
                Log.i("AGConnectInstance", "AGConnectInstance#initialize");
                b.a(context);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void initialize(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (AGConnectInstance.class) {
            try {
                Log.i("AGConnectInstance", "AGConnectInstance#initialize with options");
                b.a(context, aGConnectOptionsBuilder);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Context getContext();

    public abstract String getIdentifier();

    public abstract AGConnectOptions getOptions();

    public abstract <T> T getService(Class<? super T> cls);
}
