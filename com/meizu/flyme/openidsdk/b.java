package com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.database.Cursor;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/flyme/openidsdk/b.class */
public class b {
    public static volatile b g;
    public static boolean h;
    public Boolean e;
    public BroadcastReceiver f;

    /* renamed from: a  reason: collision with root package name */
    public OpenId f24197a = new OpenId("udid");
    public OpenId b = new OpenId("oaid");
    public OpenId d = new OpenId("vaid");

    /* renamed from: c  reason: collision with root package name */
    public OpenId f24198c = new OpenId("aaid");

    public static native ValueData a(Cursor cursor);

    public static final native b a();

    public static native void b(String str);

    public native OpenId a(String str);

    public final native String a(Context context, OpenId openId);

    public final native synchronized void a(Context context);

    public final native boolean a(Context context, boolean z);
}
