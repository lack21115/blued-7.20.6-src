package com.efs.sdk.pa;

import android.content.Context;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.pa.config.ConfigManager;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import java.util.HashMap;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/pa/PAFactory.class */
public class PAFactory {
    private static final long DEFAULT_TIME_OUT_TIME = 2000;
    private static final long INVALID_TIME_OUT_TIME = 0;
    private static final long MAX_TIME_OUT_TIME = 4000;
    private static final String TAG = "pafactory";
    static final ThreadLocal<PA> sThreadLocal = new ThreadLocal<>();
    private ConfigManager mConfigManager;
    private Context mContext;
    private HashMap<String, String> mExtend;
    private EfsReporter mReporter;
    private IEfsReporter mReporterFactory;
    private String mSerial;
    private String mSver;
    private long mTimeOutTime;
    private PATraceListener mTraceListener;

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/pa/PAFactory$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private PackageLevel f21846a;
        private IEfsReporter b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21847c;
        private Context d;
        private String e;
        private HashMap<String, String> f;
        private String g;
        private long h = 2000;
        private PATraceListener i;

        public Builder(Context context, IEfsReporter iEfsReporter) {
            if (context == null) {
                throw new RuntimeException("context Should Not null");
            }
            if (iEfsReporter == null) {
                throw new RuntimeException("reporter Should Not Empty");
            }
            this.b = iEfsReporter;
            this.d = context;
        }

        public PAFactory build() {
            PackageLevel packageLevel = this.f21846a;
            if (packageLevel != null) {
                return new PAFactory(this.d, packageLevel, this.b, this.f21847c, this.e, this.f, this.g, this.h, this.i);
            }
            throw new RuntimeException(String.format("%s Should Not Null", ""));
        }

        public Builder extendLogInfo(HashMap<String, String> hashMap) {
            this.f = hashMap;
            return this;
        }

        public Builder isNewInstall(boolean z) {
            this.f21847c = z;
            return this;
        }

        public Builder packageLevel(PackageLevel packageLevel) {
            this.f21846a = packageLevel;
            return this;
        }

        public Builder serial(String str) {
            this.e = str;
            return this;
        }

        public Builder sver(String str) {
            this.g = str;
            return this;
        }

        public Builder timeoutTime(long j) {
            if (j <= 0) {
                Log.w(PAFactory.TAG, "Timeout time is invalid, and the default value 2s will be used");
                this.h = 2000L;
                return this;
            } else if (j <= PAFactory.MAX_TIME_OUT_TIME) {
                this.h = j;
                return this;
            } else {
                Log.w(PAFactory.TAG, "Timeout time over 4s is not recommended, and the default value 2s will be used");
                this.h = 2000L;
                return this;
            }
        }

        public Builder traceListener(PATraceListener pATraceListener) {
            this.i = pATraceListener;
            return this;
        }
    }

    private PAFactory(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z, String str, HashMap<String, String> hashMap, String str2, long j, PATraceListener pATraceListener) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = hashMap;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mTimeOutTime = j;
        this.mConfigManager = new ConfigManager(context, packageLevel, iEfsReporter, z);
    }

    public ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public HashMap<String, String> getExtend() {
        return this.mExtend;
    }

    public PA getPaInstance() {
        com.efs.sdk.pa.a.c cVar;
        synchronized (this) {
            PA pa = sThreadLocal.get();
            cVar = pa;
            if (pa == null) {
                cVar = new com.efs.sdk.pa.a.c(this.mConfigManager.enableTracer());
                cVar.registerPAANRListener(this.mContext, new a(this), this.mTimeOutTime);
                sThreadLocal.set(cVar);
            }
        }
        return cVar;
    }

    public EfsReporter getReporter() {
        if (this.mReporter == null) {
            IEfsReporter iEfsReporter = this.mReporterFactory;
            this.mReporter = iEfsReporter != null ? iEfsReporter.getReporter() : null;
        }
        return this.mReporter;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getSver() {
        return this.mSver;
    }

    public PATraceListener getTraceListener() {
        return this.mTraceListener;
    }
}
