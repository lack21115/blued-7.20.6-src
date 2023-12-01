package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/auth/WeiboParameters.class */
public class WeiboParameters {
    private ArrayList<String> mKeys = new ArrayList<>();
    private ArrayList<String> mValues = new ArrayList<>();

    private int getLocation(String str) {
        if (this.mKeys.contains(str)) {
            return this.mKeys.indexOf(str);
        }
        return -1;
    }

    public void add(String str, int i) {
        this.mKeys.add(str);
        this.mValues.add(String.valueOf(i));
    }

    public void add(String str, long j) {
        this.mKeys.add(str);
        this.mValues.add(String.valueOf(j));
    }

    public void add(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mKeys.add(str);
        this.mValues.add(str2);
    }

    public void addAll(WeiboParameters weiboParameters) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= weiboParameters.size()) {
                return;
            }
            add(weiboParameters.getKey(i2), weiboParameters.getValue(i2));
            i = i2 + 1;
        }
    }

    public void clear() {
        this.mKeys.clear();
        this.mValues.clear();
    }

    public String getKey(int i) {
        return (i < 0 || i >= this.mKeys.size()) ? "" : this.mKeys.get(i);
    }

    public String getValue(int i) {
        if (i < 0 || i >= this.mKeys.size()) {
            return null;
        }
        return this.mValues.get(i);
    }

    public String getValue(String str) {
        int location = getLocation(str);
        if (location < 0 || location >= this.mKeys.size()) {
            return null;
        }
        return this.mValues.get(location);
    }

    public void remove(int i) {
        if (i < this.mKeys.size()) {
            this.mKeys.remove(i);
            this.mValues.remove(i);
        }
    }

    public void remove(String str) {
        int indexOf = this.mKeys.indexOf(str);
        if (indexOf >= 0) {
            this.mKeys.remove(indexOf);
            this.mValues.remove(indexOf);
        }
    }

    public int size() {
        return this.mKeys.size();
    }
}
