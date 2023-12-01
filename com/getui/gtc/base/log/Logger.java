package com.getui.gtc.base.log;

import android.content.Context;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.a.a;
import com.getui.gtc.base.log.a.b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/Logger.class */
public class Logger {
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static final int INFO = 3;
    public static final int VERBOSE = 1;
    public static final int WARN = 4;
    private a fileLogController;
    private com.getui.gtc.base.log.b.a fileLogDestnation;
    private com.getui.gtc.base.log.c.a fileLogFormatter;
    private com.getui.gtc.base.log.d.a logPrinter;
    private b logcatLogController;
    private com.getui.gtc.base.log.b.b logcatLogDestnation;
    private com.getui.gtc.base.log.c.b logcatLogFormatter;

    public Logger() {
        this(null);
    }

    public Logger(Context context) {
        this.logPrinter = new com.getui.gtc.base.log.d.b();
        if (context != null) {
            GtcProvider.setContext(context.getApplicationContext());
        }
        if (GtcProvider.context() != null) {
            com.getui.gtc.base.log.b.a aVar = new com.getui.gtc.base.log.b.a();
            this.fileLogDestnation = aVar;
            com.getui.gtc.base.log.c.a aVar2 = new com.getui.gtc.base.log.c.a(aVar);
            this.fileLogFormatter = aVar2;
            a aVar3 = new a(aVar2);
            this.fileLogController = aVar3;
            this.logPrinter.a(aVar3);
        }
        com.getui.gtc.base.log.b.b bVar = new com.getui.gtc.base.log.b.b();
        this.logcatLogDestnation = bVar;
        com.getui.gtc.base.log.c.b bVar2 = new com.getui.gtc.base.log.c.b(bVar);
        this.logcatLogFormatter = bVar2;
        b bVar3 = new b(bVar2);
        this.logcatLogController = bVar3;
        this.logPrinter.a(bVar3);
    }

    public void addController(ILogController iLogController) {
        if (iLogController == null) {
            return;
        }
        this.logPrinter.a(iLogController);
    }

    public void d(String str) {
        this.logPrinter.a(2, null, str, null);
    }

    public void d(String str, String str2) {
        this.logPrinter.a(2, str, str2, null);
    }

    public void d(String str, String str2, Throwable th) {
        this.logPrinter.a(2, str, str2, th);
    }

    public void d(String str, Throwable th) {
        this.logPrinter.a(2, str, null, th);
    }

    public void d(Throwable th) {
        this.logPrinter.a(2, null, null, th);
    }

    public void e(String str) {
        this.logPrinter.a(5, null, str, null);
    }

    public void e(String str, String str2) {
        this.logPrinter.a(5, str, str2, null);
    }

    public void e(String str, String str2, Throwable th) {
        this.logPrinter.a(5, str, str2, th);
    }

    public void e(String str, Throwable th) {
        this.logPrinter.a(5, null, str, th);
    }

    public void e(Throwable th) {
        this.logPrinter.a(5, null, null, th);
    }

    public void filelog(int i, String str, String str2, Throwable th) {
        this.logPrinter.a(i | 32, str, str2, th);
    }

    public void i(String str) {
        this.logPrinter.a(3, null, str, null);
    }

    public void i(String str, String str2) {
        this.logPrinter.a(3, str, str2, null);
    }

    public void i(String str, String str2, Throwable th) {
        this.logPrinter.a(3, str, str2, th);
    }

    public void i(String str, Throwable th) {
        this.logPrinter.a(3, str, null, th);
    }

    public void i(Throwable th) {
        this.logPrinter.a(3, null, null, th);
    }

    public void logcat(int i, String str, String str2, Throwable th) {
        this.logPrinter.a(i | 16, str, str2, th);
    }

    public void removeController(ILogController iLogController) {
        this.logPrinter.b(iLogController);
    }

    public void setFileEnableProperty(String str) {
        a aVar = this.fileLogController;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void setGlobalTag(String str) {
        this.logcatLogFormatter.f21916a = str;
        com.getui.gtc.base.log.c.a aVar = this.fileLogFormatter;
        if (aVar != null) {
            aVar.f21914a = str;
        }
    }

    public void setLogFileNameSuffix(String str) {
        com.getui.gtc.base.log.b.a aVar = this.fileLogDestnation;
        if (aVar != null) {
            aVar.f21910c = aVar.f21909a.getPackageName() + "-" + str + "-" + new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()) + com.anythink.china.common.a.a.f;
            aVar.b = new File(aVar.f21909a.getExternalFilesDir(null), aVar.f21910c);
        }
    }

    public void setLogcatEnable(boolean z) {
        this.logcatLogController.f21908a = z;
    }

    public void setStackOffset(int i) {
        int i2 = i + 8;
        this.logcatLogFormatter.b = i2;
        com.getui.gtc.base.log.c.a aVar = this.fileLogFormatter;
        if (aVar != null) {
            aVar.b = i2;
        }
    }

    public void v(String str) {
        this.logPrinter.a(1, null, str, null);
    }

    public void v(String str, String str2) {
        this.logPrinter.a(1, str, str2, null);
    }

    public void v(String str, String str2, Throwable th) {
        this.logPrinter.a(1, str, str2, th);
    }

    public void v(String str, Throwable th) {
        this.logPrinter.a(1, str, null, th);
    }

    public void v(Throwable th) {
        this.logPrinter.a(1, null, null, th);
    }

    public void w(String str) {
        this.logPrinter.a(4, null, str, null);
    }

    public void w(String str, String str2) {
        this.logPrinter.a(4, str, str2, null);
    }

    public void w(String str, String str2, Throwable th) {
        this.logPrinter.a(4, str, str2, th);
    }

    public void w(String str, Throwable th) {
        this.logPrinter.a(4, null, str, th);
    }

    public void w(Throwable th) {
        this.logPrinter.a(4, null, null, th);
    }
}
