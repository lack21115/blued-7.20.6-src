package com.igexin.base.b;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/b/b.class */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private Context f23208a;
    private SharedPreferences b;

    public b(Context context, String str) {
        this.f23208a = context;
        this.b = context.getSharedPreferences(str, 0);
    }

    @Override // com.igexin.base.b.a
    public final Object getParam(String str, Object obj) {
        SharedPreferences sharedPreferences = this.b;
        return sharedPreferences == null ? obj : obj instanceof String ? sharedPreferences.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }

    @Override // com.igexin.base.b.a
    public final boolean remove(String str) {
        SharedPreferences.Editor edit = this.b.edit();
        edit.remove(str);
        edit.commit();
        return false;
    }

    @Override // com.igexin.base.b.a
    public final boolean saveParam(String str, Object obj) {
        if (obj == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.b.edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        return edit.commit();
    }
}
