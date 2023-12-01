package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/local/model/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f22729a;
    private final Map<String, d> b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private List<b> f22730c = new ArrayList(16);

    public d a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
            return null;
        }
        return this.b.get(str);
    }

    public List<b> a() {
        return this.f22730c;
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        this.b.put(str, dVar);
    }

    public void a(List<b> list) {
        this.f22730c = list;
    }

    public String b() {
        return this.f22729a;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.f22729a = str;
    }
}
