package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/GlobalEnvStruct.class */
public class GlobalEnvStruct {

    /* renamed from: a  reason: collision with root package name */
    private String f21745a;
    private String b;
    private String h;
    private ILogEncryptAction m;
    public Context mAppContext;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21746c = true;
    private boolean d = true;
    private boolean e = false;
    private Boolean f = null;
    private boolean g = false;
    private boolean i = false;
    public long configRefreshDelayMills = 5000;
    private long j = 10000;
    private long k = 10000;
    private Map<String, String> l = new HashMap(5);
    private ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> n = new ConcurrentHashMap<>();
    private List<IEfsReporterObserver> o = new ArrayList(5);

    public void addConfigObserver(IEfsReporterObserver iEfsReporterObserver) {
        if (this.o.contains(iEfsReporterObserver)) {
            return;
        }
        this.o.add(iEfsReporterObserver);
    }

    public void addPublicParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap(this.l);
        hashMap.putAll(map);
        this.l = hashMap;
    }

    public String getAppid() {
        return this.f21745a;
    }

    public List<ValueCallback<Pair<Message, Message>>> getCallback(int i) {
        return (!this.n.containsKey(Integer.valueOf(i)) || this.n.get(Integer.valueOf(i)) == null) ? Collections.emptyList() : this.n.get(Integer.valueOf(i));
    }

    public List<IEfsReporterObserver> getEfsReporterObservers() {
        return this.o;
    }

    public ILogEncryptAction getLogEncryptAction() {
        return this.m;
    }

    public long getLogSendDelayMills() {
        return this.j;
    }

    public long getLogSendIntervalMills() {
        return this.k;
    }

    public Map<String, String> getPublicParamMap() {
        Map<String, String> map = this.l;
        Map<String, String> map2 = map;
        if (map == null) {
            map2 = Collections.emptyMap();
        }
        return map2;
    }

    public String getSecret() {
        return this.b;
    }

    public String getUid() {
        return this.h;
    }

    public boolean isDebug() {
        return this.e;
    }

    public boolean isEnableSendLog() {
        return this.d;
    }

    public boolean isEnableWaStat() {
        return this.f21746c;
    }

    public boolean isIntl() {
        return this.i;
    }

    public boolean isPrintLogDetail() {
        return this.g;
    }

    public void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        List<ValueCallback<Pair<Message, Message>>> list = this.n.get(Integer.valueOf(i));
        LinkedList linkedList = list;
        if (list == null) {
            linkedList = new LinkedList();
            this.n.putIfAbsent(Integer.valueOf(i), linkedList);
        }
        linkedList.add(valueCallback);
    }

    public void setAppid(String str) {
        this.f21745a = str;
    }

    public void setDebug(boolean z) {
        this.e = z;
    }

    public void setEnableSendLog(boolean z) {
        this.d = z;
    }

    public void setEnableWaStat(boolean z) {
        this.f21746c = z;
    }

    public void setIsIntl(boolean z) {
        this.i = z;
    }

    public void setLogEncryptAction(ILogEncryptAction iLogEncryptAction) {
        this.m = iLogEncryptAction;
    }

    public void setPrintLogDetail(boolean z) {
        this.g = z;
    }

    public void setSecret(String str) {
        this.b = str;
    }

    public void setUid(String str) {
        this.h = str;
    }
}
