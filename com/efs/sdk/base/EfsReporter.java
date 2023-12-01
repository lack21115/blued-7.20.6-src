package com.efs.sdk.base;

import android.app.Application;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.b.e;
import com.efs.sdk.base.core.c.d;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.a.c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.a;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-5382004-dex2jar.jar:com/efs/sdk/base/EfsReporter.class */
public class EfsReporter {
    private static ControllerCenter sControllerCenter;

    /* loaded from: source-5382004-dex2jar.jar:com/efs/sdk/base/EfsReporter$Builder.class */
    public static class Builder {
        private static Map<String, EfsReporter> sInstanceMap = new ConcurrentHashMap();
        private static boolean sUseAppContext = true;
        private final String TAG;
        private GlobalEnvStruct mGlobalEnvStruct;

        /* loaded from: source-5382004-dex2jar.jar:com/efs/sdk/base/EfsReporter$Builder$IPublicParams.class */
        public interface IPublicParams {
            Map<String, String> getRecordHeaders();
        }

        public Builder(Application application, String str, String str2) {
            this(application.getApplicationContext(), str, str2);
        }

        public Builder(Context context, String str, String str2) {
            this.TAG = "efs.reporter.builder";
            Context checkContext = checkContext(context);
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("EfsReporter init, appid is empty");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new RuntimeException("EfsReporter init, secret is empty");
            }
            GlobalEnvStruct globalEnvStruct = new GlobalEnvStruct();
            this.mGlobalEnvStruct = globalEnvStruct;
            globalEnvStruct.mAppContext = checkContext;
            this.mGlobalEnvStruct.setAppid(str);
            this.mGlobalEnvStruct.setSecret(str2);
        }

        private static Context checkContext(Context context) {
            if (context == null) {
                Log.e("context can not be null!");
                throw null;
            } else if (!sUseAppContext || (context instanceof Application)) {
                return context;
            } else {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null || !(applicationContext instanceof Application)) {
                    Log.e("Can not get Application context from given context!");
                    throw new IllegalArgumentException("Can not get Application context from given context!");
                }
                return applicationContext;
            }
        }

        private void checkParam(String str) {
            GlobalEnvStruct globalEnvStruct = sInstanceMap.get(str).getGlobalEnvStruct();
            if (!globalEnvStruct.mAppContext.equals(getGlobalEnvStruct().mAppContext)) {
                throw new RuntimeException("efs-core: duplicate init, but application context is different");
            } else if (!TextUtils.isEmpty(globalEnvStruct.getSecret()) && !globalEnvStruct.getSecret().equals(getGlobalEnvStruct().getSecret())) {
                throw new RuntimeException("efs-core: duplicate init, but secret is different");
            } else if (globalEnvStruct.isIntl() != getGlobalEnvStruct().isIntl()) {
                throw new RuntimeException("efs-core: duplicate init, but intl setting is different");
            } else {
                if (!TextUtils.isEmpty(getGlobalEnvStruct().getUid()) && !getGlobalEnvStruct().getUid().equals(globalEnvStruct.getUid())) {
                    Log.w("efs.reporter.builder", "efs-core: duplicate init, but  uid is different");
                }
                if (getGlobalEnvStruct().getPublicParamMap() == null || getGlobalEnvStruct().getPublicParamMap().size() <= 0) {
                    return;
                }
                globalEnvStruct.addPublicParams(getGlobalEnvStruct().getPublicParamMap());
            }
        }

        public Builder addEfsReporterObserver(IEfsReporterObserver iEfsReporterObserver) {
            this.mGlobalEnvStruct.addConfigObserver(iEfsReporterObserver);
            return this;
        }

        public EfsReporter build() {
            String appid = getGlobalEnvStruct().getAppid();
            if (!sInstanceMap.containsKey(appid)) {
                synchronized (EfsReporter.class) {
                    try {
                        if (!sInstanceMap.containsKey(appid)) {
                            EfsReporter efsReporter = new EfsReporter(this);
                            sInstanceMap.put(appid, efsReporter);
                            return efsReporter;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            Log.w("efs.reporter.builder", "efs-core: duplicate init");
            checkParam(appid);
            return sInstanceMap.get(appid);
        }

        public Builder configRefreshAction(IConfigRefreshAction iConfigRefreshAction) {
            c.a().b = iConfigRefreshAction;
            return this;
        }

        public Builder configRefreshDelayMills(long j) {
            this.mGlobalEnvStruct.configRefreshDelayMills = j;
            return this;
        }

        public Builder debug(boolean z) {
            this.mGlobalEnvStruct.setDebug(z);
            return this;
        }

        public Builder efsDirRootName(String str) {
            a.a(str);
            return this;
        }

        public Builder enableSendLog(boolean z) {
            this.mGlobalEnvStruct.setEnableSendLog(z);
            return this;
        }

        public Builder enableWaStat(boolean z) {
            this.mGlobalEnvStruct.setEnableWaStat(z);
            return this;
        }

        public GlobalEnvStruct getGlobalEnvStruct() {
            return this.mGlobalEnvStruct;
        }

        public Builder intl(boolean z) {
            this.mGlobalEnvStruct.setIsIntl(z);
            return this;
        }

        public Builder logEncryptAction(ILogEncryptAction iLogEncryptAction) {
            this.mGlobalEnvStruct.setLogEncryptAction(iLogEncryptAction);
            return this;
        }

        public Builder maxConcurrentUploadCnt(int i) {
            d.a().f21737a = i;
            return this;
        }

        public Builder printLogDetail(boolean z) {
            this.mGlobalEnvStruct.setPrintLogDetail(z);
            return this;
        }

        public Builder publicParams(IPublicParams iPublicParams) {
            if (iPublicParams.getRecordHeaders() != null && iPublicParams.getRecordHeaders().size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(iPublicParams.getRecordHeaders());
            }
            return this;
        }

        public Builder publicParams(Map<String, String> map) {
            if (map.size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(map);
            }
            return this;
        }

        public Builder uid(String str) {
            this.mGlobalEnvStruct.setUid(str);
            return this;
        }
    }

    private EfsReporter(Builder builder) {
        sControllerCenter = new ControllerCenter(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GlobalEnvStruct getGlobalEnvStruct() {
        return ControllerCenter.getGlobalEnvStruct();
    }

    public void addPublicParams(Map<String, String> map) {
        if (map.size() > 0) {
            getGlobalEnvStruct().addPublicParams(map);
        }
    }

    public void flushRecordLogImmediately(String str) {
        e a2 = a.b.a().f21726c.a((byte) 1);
        if (a2 != null) {
            a2.a(str);
        }
    }

    public Map<String, String> getAllConfig() {
        return c.a().c();
    }

    public Map<String, Object> getAllSdkConfig() {
        return new HashMap(c.a().d.f);
    }

    public void getAllSdkConfig(String[] strArr, IConfigCallback iConfigCallback) {
        c a2 = c.a();
        a2.e.put(iConfigCallback, strArr);
        if (a2.d.f.isEmpty()) {
            return;
        }
        a2.d();
    }

    public void refreshConfig(String str) {
        c.a().a(str);
    }

    public void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        getGlobalEnvStruct().registerCallback(i, valueCallback);
    }

    public void send(ILogProtocol iLogProtocol) {
        sControllerCenter.send(iLogProtocol);
    }

    public HttpResponse sendSyncImediatelly(String str, int i, String str2, File file) {
        return sendSyncImediatelly(str, i, str2, true, file);
    }

    public HttpResponse sendSyncImediatelly(String str, int i, String str2, boolean z, File file) {
        return sControllerCenter.sendSyncImmediately(str, i, str2, z, file);
    }

    public void setEnableRefreshConfigFromRemote(boolean z) {
        c.a().f21752c = z;
    }
}
