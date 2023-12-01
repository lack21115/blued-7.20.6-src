package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.a;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ui/SafeBundle.class */
public class SafeBundle {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f22902a;

    public SafeBundle() {
        this(new Bundle());
    }

    public SafeBundle(Bundle bundle) {
        this.f22902a = bundle == null ? new Bundle() : bundle;
    }

    public boolean containsKey(String str) {
        try {
            return this.f22902a.containsKey(str);
        } catch (Exception e) {
            a.a("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f22902a.get(str);
        } catch (Exception e) {
            a.a("SafeBundle", "get exception: " + e.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f22902a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        try {
            return this.f22902a.getInt(str, i);
        } catch (Exception e) {
            a.a("SafeBundle", "getInt exception: " + e.getMessage(), true);
            return i;
        }
    }

    public String getString(String str) {
        try {
            return this.f22902a.getString(str);
        } catch (Exception e) {
            a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return "";
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f22902a.getString(str, str2);
        } catch (Exception e) {
            a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return str2;
        }
    }

    public boolean isEmpty() {
        try {
            return this.f22902a.isEmpty();
        } catch (Exception e) {
            a.a("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f22902a.size();
        } catch (Exception e) {
            a.a("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f22902a.toString();
    }
}
