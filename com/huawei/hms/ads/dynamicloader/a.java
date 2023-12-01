package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamicloader/a.class */
public class a extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f22464a;
    private Resources.Theme b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f22465c;

    public a(Context context) {
        super(context);
    }

    private void a() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.f22464a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (Context.LAYOUT_INFLATER_SERVICE.equals(str)) {
            if (this.f22465c == null) {
                this.f22465c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f22465c;
        }
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        Resources.Theme theme2 = theme;
        if (theme == null) {
            int i = this.f22464a;
            int i2 = getApplicationInfo().targetSdkVersion;
            int i3 = i;
            if (i == 0) {
                i3 = i2 < 11 ? 16973829 : i2 >= 14 ? i2 < 24 ? 16974120 : 16974143 : 16973931;
            }
            this.f22464a = i3;
            a();
            theme2 = this.b;
        }
        return theme2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.f22464a != i) {
            this.f22464a = i;
            a();
        }
    }
}
