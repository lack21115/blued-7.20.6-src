package com.zk_oaction.adengine.lk_interfaces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_interfaces/a.class */
public interface a {
    b a(int i, int i2, Bitmap.Config config);

    b a(String str, float f, int i);

    void a();

    void a(long j);

    void a(Intent intent);

    void a(MotionEvent motionEvent, int i, int i2);

    void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    void a(View view, Map map);

    void a(String str);

    void a(String str, float f, boolean z, boolean z2);

    void a(String str, int i, int i2, int i3, Map map);

    void a(String str, int i, int i2, Map map);

    void a(String str, int i, String str2);

    void a(String str, int i, String str2, Map map);

    void a(String str, String[] strArr);

    void a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String[] strArr3, String[] strArr4);

    void b();

    void b(MotionEvent motionEvent, int i, int i2);

    void b(String str, int i, int i2, int i3, Map map);

    void c();

    void c(MotionEvent motionEvent, int i, int i2);

    void c(String str, int i, int i2, int i3, Map map);

    void d();
}
