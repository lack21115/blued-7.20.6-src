package a.a.a.a.a.c;

import a.a.a.a.a.e.h;
import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1340a = {"com.panda.videoliveplatform", "tv.panda.live.broadcast", "com.panda.videolivetv", "com.panda.videolivehd"};
    public static a b = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f1341c = false;

    public static a a() {
        return b;
    }

    public void a(Context context) {
        this.f1341c = false;
        String i = h.i(context);
        if (i == null || i.isEmpty()) {
            return;
        }
        int length = f1340a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i.equals(f1340a[i2])) {
                this.f1341c = true;
                return;
            }
        }
    }

    public boolean b() {
        return this.f1341c;
    }
}
