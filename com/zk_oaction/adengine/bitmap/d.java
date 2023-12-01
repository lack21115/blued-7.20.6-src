package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/d.class */
class d {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, a> f41874a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/d$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private String f41875a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private int f41876c;
        private int d;
        private WeakReference<Bitmap> e;

        a(d dVar, String str, float f, int i, int i2) {
            this.f41875a = str;
            this.b = f;
            this.f41876c = i;
            this.d = i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
            if (r9.getHeight() != r8.d) goto L48;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap a(byte[] r9) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.bitmap.d.a.a(byte[]):android.graphics.Bitmap");
        }
    }

    private a a(String str, float f, int i, int i2) {
        a aVar;
        String a2 = a(str, f);
        synchronized (this) {
            if (this.f41874a.get(a2) == null) {
                this.f41874a.put(a2, new a(this, str, f, i, i2));
            }
            aVar = this.f41874a.get(a2);
        }
        return aVar;
    }

    public Bitmap a(String str, float f, int i, int i2, byte[] bArr) {
        return a(str, f, i, i2).a(bArr);
    }

    protected String a(String str, float f) {
        return str + BridgeUtil.UNDERLINE_STR + f;
    }
}
