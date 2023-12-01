package com.tencent.tendinsv.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/l.class */
public class l implements k {

    /* renamed from: a  reason: collision with root package name */
    protected static boolean f39012a = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f39013c;
    protected boolean b = false;
    private String d;
    private String e;
    private String[] f;

    public l(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public void a(String[] strArr) {
        this.f = strArr;
    }

    @Override // com.tencent.tendinsv.b.k
    public String b(Context context) {
        if (TextUtils.isEmpty(f39013c)) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://" + this.d + BridgeUtil.SPLIT_MARK + this.e), null, null, this.f, null);
                if (query != null) {
                    query.moveToFirst();
                    f39013c = query.getString(query.getColumnIndex("value"));
                }
            } catch (Throwable th) {
                f39013c = null;
            }
        }
        return f39013c;
    }

    @Override // com.tencent.tendinsv.b.k
    public boolean b_(Context context) {
        PackageManager packageManager;
        boolean z;
        if (this.b) {
            return f39012a;
        }
        if (context == null) {
            return false;
        }
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable th) {
            f39012a = false;
        }
        if (packageManager != null && packageManager.resolveContentProvider(this.d, 0) != null) {
            z = true;
            f39012a = z;
            this.b = true;
            return f39012a;
        }
        z = false;
        f39012a = z;
        this.b = true;
        return f39012a;
    }

    @Override // com.tencent.tendinsv.b.k
    public boolean c_(Context context) {
        return true;
    }
}
