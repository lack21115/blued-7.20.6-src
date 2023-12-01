package com.tencent.tmsbeacon.qimei;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.tmsbeacon.a.a.d;
import com.tencent.tmsbeacon.a.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/QimeiSDK.class */
public class QimeiSDK implements d {
    public static final String TAG = "[Qimei]";
    private static volatile QimeiSDK instance;
    private String appKey;
    private Context mContext;
    private final List<IAsyncQimeiListener> qimeiListeners = Collections.synchronizedList(new ArrayList(3));
    private String beaconId = "";
    private String omgID = "";
    private String oaID = "";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/QimeiSDK$a.class */
    public class a implements Runnable {
        public final /* synthetic */ IAsyncQimeiListener b;

        public a(IAsyncQimeiListener iAsyncQimeiListener) {
            this.b = iAsyncQimeiListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (QimeiSDK.this.qimeiListeners) {
                Qimei qimei = QimeiSDK.this.getQimei();
                if (qimei == null || qimei.isEmpty()) {
                    QimeiSDK.this.qimeiListeners.add(this.b);
                } else {
                    this.b.onQimeiDispatch(qimei);
                }
            }
        }
    }

    private QimeiSDK() {
    }

    public static QimeiSDK getInstance() {
        if (instance == null) {
            synchronized (QimeiSDK.class) {
                try {
                    if (instance == null) {
                        instance = new QimeiSDK();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private boolean isInit() {
        synchronized (this) {
            if (this.mContext != null) {
                return true;
            }
            com.tencent.tmsbeacon.base.util.c.d("[qimei] QimeiSdk not init", new Object[0]);
            return false;
        }
    }

    private boolean isUpdateQimei() {
        Qimei qimei = getQimei();
        boolean z = true;
        if (qimei == null || qimei.isEmpty()) {
            return true;
        }
        if (e.c() || e.a()) {
            com.tencent.tmsbeacon.base.util.c.d("[qimei] isQIMEIReqZeroPeak or Qimei disable", new Object[0]);
            return false;
        }
        if (!e.b()) {
            if (b.h()) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public String getAppKey() {
        String str;
        synchronized (this) {
            str = this.appKey;
        }
        return str;
    }

    @Deprecated
    public String getBeaconIdInfo() {
        String str;
        synchronized (this) {
            if (TextUtils.isEmpty(this.beaconId)) {
                this.beaconId = com.tencent.tmsbeacon.b.a.a(Build.VERSION.SDK_INT);
            }
            str = this.beaconId;
        }
        return str;
    }

    public Context getContext() {
        Context context;
        synchronized (this) {
            context = this.mContext;
        }
        return context;
    }

    @Deprecated
    public String getOAID() {
        return "";
    }

    public String getOmgID() {
        return this.omgID;
    }

    public Qimei getQimei() {
        if (com.tencent.tmsbeacon.a.c.c.d().c() == null) {
            return null;
        }
        return com.tencent.tmsbeacon.qimei.a.a().b();
    }

    public void getQimei(IAsyncQimeiListener iAsyncQimeiListener) {
        synchronized (this) {
            com.tencent.tmsbeacon.a.b.a.a().a(new a(iAsyncQimeiListener));
        }
    }

    @Deprecated
    public String getQimeiInternal() {
        synchronized (this) {
            if (isInit()) {
                Qimei b = com.tencent.tmsbeacon.qimei.a.a().b();
                if (TextUtils.isEmpty(b.getQimeiOld())) {
                    return "";
                }
                return b.getQimeiOld();
            }
            return "";
        }
    }

    public QimeiSDK init(Context context) {
        synchronized (this) {
            if (!isInit()) {
                com.tencent.tmsbeacon.base.util.c.a(TAG, "QimeiSDK init!", new Object[0]);
                this.mContext = context;
                com.tencent.tmsbeacon.a.a.b.a().a(1, this);
                boolean isUpdateQimei = isUpdateQimei();
                com.tencent.tmsbeacon.base.util.c.a(TAG, "isUpdate Qimei: %s", Boolean.valueOf(isUpdateQimei));
                if (isUpdateQimei) {
                    com.tencent.tmsbeacon.a.b.a.a().a(new c(context));
                }
            }
        }
        return this;
    }

    public void logQimeiCallbackError(Throwable th) {
        com.tencent.tmsbeacon.base.util.c.b("[qimei] onQimeiDispatch error!", th.getMessage());
        com.tencent.tmsbeacon.base.util.c.a(th);
        com.tencent.tmsbeacon.a.b.d.b().a("514", "QimeiDispatch error", th);
    }

    @Override // com.tencent.tmsbeacon.a.a.d
    public void onEvent(com.tencent.tmsbeacon.a.a.c cVar) {
        if (cVar.f39460a == 1) {
            synchronized (this.qimeiListeners) {
                Qimei b = com.tencent.tmsbeacon.qimei.a.a().b();
                if (b == null || !b.isEmpty()) {
                    for (IAsyncQimeiListener iAsyncQimeiListener : this.qimeiListeners) {
                        iAsyncQimeiListener.onQimeiDispatch(b);
                    }
                    this.qimeiListeners.clear();
                }
            }
        }
    }

    public QimeiSDK setAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.appKey = str;
        }
        return this;
    }

    public QimeiSDK setLogAble(boolean z) {
        synchronized (this) {
            com.tencent.tmsbeacon.base.util.c.a(z);
            com.tencent.tmsbeacon.base.util.c.b(z);
        }
        return this;
    }

    @Deprecated
    public void setOAID(String str) {
    }

    public QimeiSDK setOmgId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.omgID = str;
        }
        return this;
    }
}
