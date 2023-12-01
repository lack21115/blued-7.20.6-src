package com.getui.gtc.base.log.a;

import android.content.Context;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.ILogController;
import com.getui.gtc.base.log.ILogFormatter;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/a/a.class */
public class a implements ILogController {
    private static List<String> b;

    /* renamed from: a  reason: collision with root package name */
    private String f8299a;

    /* renamed from: c  reason: collision with root package name */
    private ILogFormatter f8300c;
    private boolean d;

    public a() {
        this(new com.getui.gtc.base.log.c.a());
    }

    public a(ILogFormatter iLogFormatter) {
        this.f8299a = "sdk.debug";
        this.f8300c = (ILogFormatter) com.getui.gtc.base.log.e.a.a(iLogFormatter);
        a(this.f8299a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:4|(3:6|7|8)(7:61|(2:63|64)(2:78|79)|65|66|67|(3:73|74|75)|51)|9|10|11|12|13|14|15|(4:16|17|18|(7:20|21|22|23|24|(5:30|31|32|33|(5:35|36|37|38|39)(1:41))|40)(1:44))|45|(2:54|51)|47|48|50|51) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.String> a(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.base.log.a.a.a(android.content.Context):java.util.List");
    }

    private static boolean b(String str) {
        try {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        Context context = GtcProvider.context();
                        if (context == null) {
                            return false;
                        }
                        b = Collections.unmodifiableList(a(context));
                    }
                }
            }
            return b.contains(str);
        } catch (Throwable th) {
            return false;
        }
    }

    public final void a(String str) {
        this.f8299a = str;
        this.d = b(str);
    }

    @Override // com.getui.gtc.base.log.ILogController
    public boolean isLoggable(int i, String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 32) {
            return this.d;
        }
        return false;
    }

    @Override // com.getui.gtc.base.log.ILogController
    public void log(int i, String str, String str2, Throwable th) {
        int i2 = i;
        if ((i & 240) != 0) {
            i2 = i & 15;
        }
        this.f8300c.log(i2, str, str2, th);
    }
}
