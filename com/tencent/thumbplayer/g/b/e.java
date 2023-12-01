package com.tencent.thumbplayer.g.b;

import android.media.MediaFormat;
import android.os.Build;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/e.class */
public final class e {
    public int d;
    public int e;
    public int f;
    public final String j;
    private boolean k;
    private boolean l;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<byte[]> f39326a = new ArrayList<>();
    public int b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f39327c = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;

    public e(String str) {
        this.j = str;
    }

    public static int a(MediaFormat mediaFormat, String str) {
        return a(mediaFormat, str, -1);
    }

    public static int a(MediaFormat mediaFormat, String str, int i) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i;
    }

    public static e a(MediaFormat mediaFormat) {
        e eVar = new e(mediaFormat.getString(MediaFormat.KEY_MIME));
        try {
            eVar.f = a(mediaFormat, MediaFormat.KEY_SAMPLE_RATE);
            eVar.i = a(mediaFormat, MediaFormat.KEY_MAX_INPUT_SIZE);
            eVar.f39326a = com.tencent.thumbplayer.g.h.c.a(mediaFormat);
        } catch (Throwable th) {
            com.tencent.thumbplayer.g.h.b.b("FormatWrapper", "create format error", th);
        }
        if (!eVar.a()) {
            eVar.e = a(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT);
            return eVar;
        }
        eVar.d = a(mediaFormat, "rotation-degrees");
        eVar.b = a(mediaFormat, "width");
        eVar.f39327c = a(mediaFormat, "height");
        if (Build.VERSION.SDK_INT >= 19) {
            eVar.g = a(mediaFormat, MediaFormat.KEY_MAX_WIDTH);
            eVar.h = a(mediaFormat, MediaFormat.KEY_MAX_HEIGHT);
            return eVar;
        }
        return eVar;
    }

    private static String a(String str, byte[] bArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(", length:");
        sb.append(bArr.length);
        sb.append("  [");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(bArr.length, 20)) {
                sb.append("]");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(" ,");
            }
            sb.append((int) bArr[i2]);
            i = i2 + 1;
        }
    }

    public static void a(ArrayList<byte[]> arrayList) {
        if (arrayList == null || !com.tencent.thumbplayer.g.h.b.a()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                com.tencent.thumbplayer.g.h.b.b("FormatWrapper", "csdData size:" + arrayList.size() + "    " + sb.toString());
                return;
            }
            sb.append(a(com.tencent.thumbplayer.g.h.c.f39360a[i2], arrayList.get(i2)));
            sb.append("\n");
            i = i2 + 1;
        }
    }

    public final boolean a() {
        if (!this.k) {
            this.k = true;
            this.l = com.tencent.thumbplayer.g.h.c.a(this.j);
        }
        return this.l;
    }

    public final boolean a(e eVar) {
        if (this.f39326a.size() != eVar.f39326a.size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f39326a.size()) {
                return true;
            }
            if (!this.f39326a.get(i2).equals(eVar.f39326a.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
