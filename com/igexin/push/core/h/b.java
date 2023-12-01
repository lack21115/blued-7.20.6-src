package com.igexin.push.core.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.igexin.push.core.b.k;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.f.j;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/h/b.class */
public final class b extends com.igexin.push.e.a.d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9946a = 2;
    public static final int b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9947c = 65557;
    private static final String d = "EXT-DownloadImgPlugin";
    private String n;
    private BaseActionBean o;
    private int p;
    private d q;
    private String r;

    public b(String str, String str2, String str3, BaseActionBean baseActionBean, int i, d dVar) {
        super(str);
        this.o = baseActionBean;
        this.n = str3;
        this.p = i;
        this.q = dVar;
        this.r = str2;
        this.l = false;
    }

    private void a(String str) {
        int i = this.p;
        if (i == 2) {
            ((k) this.o).z = str;
        } else if (i != 8) {
        } else {
            ((k) this.o).A = str;
        }
    }

    private static void b() {
        File file = new File(j.f);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    @Override // com.igexin.push.e.a.d
    public final void a(Exception exc) {
        d dVar = this.q;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.igexin.push.e.a.d
    public final void a(byte[] bArr) {
        this.m = false;
        try {
            File file = new File(j.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = j.f + com.igexin.assist.util.a.a(this.r) + ".bin";
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray != null) {
                decodeByteArray.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.close();
                decodeByteArray.recycle();
                int i = this.p;
                if (i == 2) {
                    ((k) this.o).z = str;
                } else if (i == 8) {
                    ((k) this.o).A = str;
                }
                this.m = true;
            } else {
                fileOutputStream.close();
                this.m = false;
            }
            if (this.q != null) {
                if (this.m) {
                    this.q.a(this.o);
                    return;
                }
                d dVar = this.q;
                new Exception("no target existed or downloading bitmap failed!");
                dVar.a();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return f9947c;
    }
}
