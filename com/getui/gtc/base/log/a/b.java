package com.getui.gtc.base.log.a;

import com.getui.gtc.base.log.ILogController;
import com.getui.gtc.base.log.ILogFormatter;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/a/b.class */
public final class b implements ILogController {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8301a;
    private ILogFormatter b;

    public b() {
        this(new com.getui.gtc.base.log.c.b());
    }

    public b(ILogFormatter iLogFormatter) {
        this.f8301a = true;
        this.b = (ILogFormatter) com.getui.gtc.base.log.e.a.a(iLogFormatter);
    }

    @Override // com.getui.gtc.base.log.ILogController
    public final boolean isLoggable(int i, String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 16) {
            return this.f8301a;
        }
        return false;
    }

    @Override // com.getui.gtc.base.log.ILogController
    public final void log(int i, String str, String str2, Throwable th) {
        int i2 = i;
        if ((i & 240) != 0) {
            i2 = i & 15;
        }
        this.b.log(i2, str, str2, th);
    }
}
