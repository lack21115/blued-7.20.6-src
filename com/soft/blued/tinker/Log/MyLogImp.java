package com.soft.blued.tinker.Log;

import android.util.Log;
import com.soft.blued.utils.Logger;
import com.tencent.tinker.lib.util.TinkerLog;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/Log/MyLogImp.class */
public class MyLogImp implements TinkerLog.TinkerLogImp {

    /* renamed from: a  reason: collision with root package name */
    private static int f29768a;

    @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
    public void d(String str, String str2, Object... objArr) {
        if (f29768a <= 1) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Logger.c(str, str2);
        }
    }

    @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
    public void e(String str, String str2, Object... objArr) {
        if (f29768a <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Logger.e(str, str2);
        }
    }

    @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
    public void i(String str, String str2, Object... objArr) {
        if (f29768a <= 2) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Logger.b(str, str2);
        }
    }

    @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        Logger.e(str, str3 + "  " + Log.getStackTraceString(th));
    }

    @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
    public void v(String str, String str2, Object... objArr) {
        if (f29768a <= 0) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Logger.a(str, str2);
        }
    }

    @Override // com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp
    public void w(String str, String str2, Object... objArr) {
        if (f29768a <= 3) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            Logger.d(str, str2);
        }
    }
}
