package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.os.Build;
import com.uc.crashsdk.export.LogType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f27475a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.f27475a = context;
    }

    private void c(i iVar) {
        iVar.a(ReportField.crash_time, String.valueOf(System.currentTimeMillis() / 1000));
        iVar.a(ReportField.phone_model, k.a());
        iVar.a(ReportField.os_platform, "android");
        iVar.a(ReportField.os_version, Build.VERSION.RELEASE);
        iVar.a(ReportField.sdk_version, "3.1.1");
        iVar.a(ReportField.bundle_id, this.f27475a.getPackageName());
        iVar.a(ReportField.app_name, k.b(this.f27475a));
        iVar.a(ReportField.app_version, k.e(this.f27475a));
        iVar.a(ReportField.device_id, k.c(this.f27475a));
        iVar.a(ReportField.gl_version, k.d(this.f27475a));
        iVar.a(ReportField.crash_version, "1.0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(i iVar) {
        if (iVar.b() != null) {
            String a2 = k.a(iVar.b());
            String substring = a2.substring(a2.lastIndexOf("Caused by"));
            if (substring.substring(0, substring.indexOf("...")).contains("com.qiniu.pili.droid.shortvideo")) {
                iVar.a(ReportField.java_stacktrace, a2).a(ReportField.crash_type, LogType.JAVA_TYPE);
                return true;
            }
            return false;
        }
        String a3 = iVar.a("backtrace");
        Matcher matcher = Pattern.compile("([a-z]+_){1,2}[a-z]+.so").matcher(a3);
        String group = matcher.find() ? matcher.group(0) : "";
        if (b.b.contains(group) || a3.contains("com.qiniu.pili.droid.shortvideo")) {
            iVar.a(ReportField.native_backtrace, a3).a(ReportField.so_name, group).a(ReportField.crash_type, iVar.a("Crash type"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        c(iVar);
        if (iVar.a("java stacktrace") == null) {
            String a2 = iVar.a(ReportField.java_stacktrace);
            try {
                iVar.a(ReportField.exception_name, k.a(a2));
                iVar.a(ReportField.exception_location, k.b(a2));
            } catch (Exception e) {
            }
        }
        if (com.anythink.expressad.foundation.g.a.f.f7832a.equals(iVar.a(ReportField.crash_type))) {
            String a3 = iVar.a("build id");
            if (a3 != null) {
                iVar.a(ReportField.build_id, k.c(a3));
            }
            String a4 = iVar.a("stack");
            if (a4 != null) {
                iVar.a(ReportField.native_stack, a4);
            }
            String a5 = iVar.a("signal");
            if (a5 != null) {
                iVar.a(ReportField.signal, a5);
            }
            String a6 = iVar.a("code");
            if (a6 != null) {
                iVar.a(ReportField.code, a6);
            }
            String a7 = iVar.a("fault addr");
            if (a7 != null) {
                iVar.a(ReportField.fault_addr, a7);
            }
        }
        if (LogType.ANR_TYPE.equals(iVar.a(ReportField.crash_type))) {
            try {
                iVar.a(ReportField.dropbox, new e().a(this.f27475a));
            } catch (Exception e2) {
            }
        }
        String a8 = iVar.a("tname");
        if (a8 == null) {
            try {
                iVar.a(ReportField.thread_name, iVar.a().getName());
            } catch (Exception e3) {
            }
        } else {
            iVar.a(ReportField.thread_name, a8);
        }
        try {
            iVar.a(ReportField.logcat, k.c());
        } catch (Exception e4) {
        }
    }
}
