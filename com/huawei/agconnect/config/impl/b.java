package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.core.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/impl/b.class */
public class b implements AGConnectOptions {

    /* renamed from: a  reason: collision with root package name */
    private final String f22330a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22331c;
    private final AGCRoutePolicy d;
    private final d e;
    private final e f;
    private final Map<String, String> g;
    private final List<Service> h;
    private final Map<String, String> i = new HashMap();

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a2, code lost:
        if (r9 == com.huawei.agconnect.AGCRoutePolicy.UNKNOWN) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(android.content.Context r7, java.lang.String r8, com.huawei.agconnect.AGCRoutePolicy r9, java.io.InputStream r10, java.util.Map<java.lang.String, java.lang.String> r11, java.util.List<com.huawei.agconnect.core.Service> r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.b.<init>(android.content.Context, java.lang.String, com.huawei.agconnect.AGCRoutePolicy, java.io.InputStream, java.util.Map, java.util.List, java.lang.String):void");
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str)) {
            if (this.i.containsKey(str)) {
                return this.i.get(str);
            }
            JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
            if (jsonProcessor == null) {
                return null;
            }
            String processOption = jsonProcessor.processOption(this);
            this.i.put(str, processOption);
            return processOption;
        }
        return null;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f22331c + "', routePolicy=" + this.d + ", reader=" + this.e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.g).toString().hashCode() + '}').hashCode());
    }

    public List<Service> a() {
        return this.h;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.f22330a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str, int i) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i)));
        } catch (NumberFormatException e) {
            return i;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f22331c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.d;
        AGCRoutePolicy aGCRoutePolicy2 = aGCRoutePolicy;
        if (aGCRoutePolicy == null) {
            aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        }
        return aGCRoutePolicy2;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String fixPath = Utils.fixPath(str);
        String str3 = this.g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String a2 = a(fixPath);
        if (a2 != null) {
            return a2;
        }
        String a3 = this.e.a(fixPath, str2);
        String str4 = a3;
        if (e.a(a3)) {
            str4 = this.f.a(a3, str2);
        }
        return str4;
    }
}
