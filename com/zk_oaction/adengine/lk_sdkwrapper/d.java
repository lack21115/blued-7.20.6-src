package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.SoundPool;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import com.zk_oaction.adengine.bitmap.g;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/d.class */
public class d implements com.zk_oaction.adengine.lk_interfaces.a {

    /* renamed from: a  reason: collision with root package name */
    protected g f28276a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f28277c;
    private Context d;
    private com.zk_oaction.adengine.lk_sdk.b e;
    private SoundPool f;
    private HashMap<String, Integer> g;
    private int h;
    private View i;
    private com.zk_oaction.adengine.lk_interfaces.c j;
    private com.zk_oaction.adengine.lk_sensor.b k;
    private boolean l;

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0031, code lost:
        if (r9 == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public d(android.content.Context r6, int r7, int r8, int r9) {
        /*
            r5 = this;
            r0 = r5
            r0.<init>()
            r0 = r5
            r1 = r6
            r0.d = r1
            com.zk_oaction.adengine.lk_sdk.b r0 = new com.zk_oaction.adengine.lk_sdk.b
            r1 = r0
            r2 = r6
            r3 = r5
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r5
            r1 = r6
            r0.e = r1
            r0 = r6
            r1 = r7
            r0.a(r1)
            r0 = r5
            com.zk_oaction.adengine.bitmap.g r1 = new com.zk_oaction.adengine.bitmap.g
            r2 = r1
            r2.<init>()
            r0.f28276a = r1
            r0 = r8
            if (r0 == 0) goto L34
            r0 = r9
            r7 = r0
            r0 = r9
            if (r0 != 0) goto L42
        L34:
            r0 = r5
            r0.k()
            r0 = r5
            int r0 = r0.b
            r8 = r0
            r0 = r5
            int r0 = r0.f28277c
            r7 = r0
        L42:
            r0 = r5
            com.zk_oaction.adengine.bitmap.g r0 = r0.f28276a
            r1 = r8
            r2 = r7
            r0.a(r1, r2)
            r0 = r5
            com.zk_oaction.adengine.bitmap.g r0 = r0.f28276a
            r1 = 0
            r0.a(r1)
            r0 = r5
            com.zk_oaction.adengine.bitmap.g r0 = r0.f28276a
            r1 = r5
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdkwrapper.d.<init>(android.content.Context, int, int, int):void");
    }

    private void i() {
        com.zk_oaction.adengine.lk_sensor.b bVar;
        if (!this.l || (bVar = this.k) == null) {
            return;
        }
        bVar.a();
    }

    private void j() {
        com.zk_oaction.adengine.lk_sensor.b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdkwrapper.d.k():void");
    }

    public View a(String str, com.zk_oaction.adengine.lk_interfaces.c cVar) {
        View view;
        synchronized (this) {
            this.j = cVar;
            if (this.i == null) {
                this.i = this.e.a(str, cVar);
            }
            view = this.i;
        }
        return view;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public com.zk_oaction.adengine.lk_interfaces.b a(int i, int i2, Bitmap.Config config) {
        g gVar = this.f28276a;
        if (gVar != null) {
            return gVar.a(i, i2, config);
        }
        return null;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public com.zk_oaction.adengine.lk_interfaces.b a(String str, float f, int i) {
        g gVar = this.f28276a;
        if (gVar != null) {
            return gVar.b(str, f, i);
        }
        return null;
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a() {
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(long j) {
        try {
            ((Vibrator) this.d.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(Intent intent) {
        try {
            this.d.startActivity(intent);
        } catch (Throwable th) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(MotionEvent motionEvent, int i, int i2) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.a(motionEvent, i, i2);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.a(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(View view, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.a(view, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str) {
        try {
            if (this.g == null) {
                this.g = new HashMap<>();
            }
            if (this.f == null) {
                this.f = new SoundPool(10, 3, 0);
            }
            this.g.put(str, Integer.valueOf(this.f.load(str, 1)));
        } catch (Throwable th) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str, float f, boolean z, boolean z2) {
        if (!z2) {
            try {
                int i = this.h;
                if (i != 0) {
                    this.f.stop(i);
                    this.h = 0;
                }
            } catch (Throwable th) {
                return;
            }
        }
        int i2 = z ? -1 : 0;
        Integer num = this.g.get(str);
        Integer num2 = num;
        if (num == null) {
            a(str);
            num2 = this.g.get(str);
        }
        this.h = this.f.play(num2.intValue(), f, f, 0, i2, 1.0f);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str, int i, int i2, int i3, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.a(str, i, i2, i3, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str, int i, int i2, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.a(str, i, i2, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str, int i, String str2) {
        if (str == null) {
            return;
        }
        try {
            com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
            if (cVar != null) {
                cVar.a(str, i, str2);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str, int i, String str2, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.a(str, i, str2, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str, String[] strArr) {
        try {
            if (this.k == null) {
                this.k = new com.zk_oaction.adengine.lk_sensor.b(this.d, this.e);
            }
            this.k.a(str, strArr, this.l);
        } catch (Throwable th) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String[] strArr3, String[] strArr4) {
    }

    public void a(boolean z) {
        try {
            com.zk_oaction.adengine.lk_sdk.b bVar = this.e;
            if (bVar != null) {
                bVar.a(z);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void b() {
        this.f28276a.a(300L);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void b(MotionEvent motionEvent, int i, int i2) {
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void b(String str, int i, int i2, int i3, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.b(str, i, i2, i3, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void c() {
        g gVar = this.f28276a;
        if (gVar == null) {
            return;
        }
        gVar.e();
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void c(MotionEvent motionEvent, int i, int i2) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.b(motionEvent, i, i2);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void c(String str, int i, int i2, int i3, Map map) {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.c(str, i, i2, i3, map);
        }
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.a
    public void d() {
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.j;
        if (cVar != null) {
            cVar.b();
        }
    }

    public com.zk_oaction.adengine.lk_sdk.b e() {
        return this.e;
    }

    public void f() {
        try {
            this.l = true;
            this.e.a();
            i();
        } catch (Throwable th) {
        }
    }

    public void g() {
        try {
            this.l = false;
            this.e.b();
            SoundPool soundPool = this.f;
            if (soundPool != null) {
                soundPool.autoPause();
            }
            j();
        } catch (Throwable th) {
        }
    }

    public void h() {
        try {
            this.e.c();
            g gVar = this.f28276a;
            if (gVar != null) {
                gVar.d();
                this.f28276a = null;
            }
            SoundPool soundPool = this.f;
            if (soundPool != null) {
                soundPool.release();
                this.f = null;
            }
            HashMap<String, Integer> hashMap = this.g;
            if (hashMap != null) {
                hashMap.clear();
                this.g = null;
            }
            j();
            com.zk_oaction.adengine.lk_sensor.b bVar = this.k;
            if (bVar != null) {
                bVar.c();
            }
            this.i = null;
        } catch (Throwable th) {
        }
    }
}
