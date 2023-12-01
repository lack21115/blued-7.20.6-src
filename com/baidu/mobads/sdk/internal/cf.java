package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.u;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cf.class */
public class cf implements Observer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9375a = "APKParser";
    private static final String g = "__xadsdk_downloaded__version__";
    private static final String h = "version";
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private URL f9376c;
    private String d;
    private final bu e;
    private a f;
    private SharedPreferences i;
    private SharedPreferences.OnSharedPreferenceChangeListener j;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/cf$a.class */
    public interface a {
        void a(bu buVar);

        void b(bu buVar);
    }

    public cf(Context context, String str, bu buVar, a aVar) {
        this.f9376c = null;
        this.d = null;
        this.j = new cg(this);
        this.d = str;
        this.e = buVar;
        a(context, aVar);
    }

    public cf(Context context, URL url, bu buVar, a aVar) {
        this.f9376c = null;
        this.d = null;
        this.j = new cg(this);
        this.f9376c = url;
        this.e = buVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.b = context;
        this.f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(g, 0);
        this.i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.j);
    }

    public void a(String str, String str2) {
        al alVar = new al(this.b, this.d != null ? new URL(this.d) : this.f9376c, str, str2, false);
        alVar.addObserver(this);
        alVar.a();
        SharedPreferences.Editor edit = this.i.edit();
        edit.putString("version", this.e.toString());
        edit.apply();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        u uVar = (u) observable;
        if (uVar.l() == u.a.COMPLETED) {
            this.f.a(new bu(this.e, uVar.g(), true));
        }
        if (uVar.l() == u.a.ERROR) {
            this.f.b(new bu(this.e, uVar.g(), false));
        }
    }
}
