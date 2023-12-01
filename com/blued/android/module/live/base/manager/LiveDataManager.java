package com.blued.android.module.live.base.manager;

import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.live.base.model.BasePayRemaining;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/manager/LiveDataManager.class */
public class LiveDataManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile LiveDataManager f11416a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private String f11417c;
    private long d;
    private BasePayRemaining e;
    private final Map<String, List<CommonGiftPackageModel>> f = new HashMap();
    private boolean g = false;
    private int h = 0;
    private int i;
    private boolean j;
    private boolean k;

    private LiveDataManager() {
    }

    public static LiveDataManager a() {
        if (f11416a == null) {
            synchronized (LiveDataManager.class) {
                try {
                    if (f11416a == null) {
                        f11416a = new LiveDataManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11416a;
    }

    private void b(long j) {
        this.d = j;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        this.b = j;
        this.f11417c = String.valueOf(j);
    }

    public void a(BasePayRemaining basePayRemaining) {
        this.e = basePayRemaining;
        if (basePayRemaining != null) {
            b(basePayRemaining.beans);
        }
    }

    public void a(String str) {
        if (this.f.containsKey(str)) {
            this.f.remove(str);
        }
    }

    public void a(String str, List<CommonGiftPackageModel> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (b(str) != null) {
            this.f.get(str).clear();
        }
        this.f.get(str).addAll(list);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public List<CommonGiftPackageModel> b(String str) {
        if (!this.f.containsKey(str) || this.f.get(str) == null) {
            this.f.put(str, new ArrayList());
        }
        return this.f.get(str);
    }

    public void b() {
        this.b = 0L;
        this.f11417c = "";
        this.g = false;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public String c() {
        return this.f11417c;
    }

    public void c(boolean z) {
        this.k = z;
    }

    public long d() {
        return this.d;
    }

    public BasePayRemaining e() {
        return this.e;
    }

    public boolean f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public boolean h() {
        return this.i == 1;
    }

    public boolean i() {
        return this.j;
    }

    public boolean j() {
        return this.k;
    }
}
