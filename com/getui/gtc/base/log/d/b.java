package com.getui.gtc.base.log.d;

import com.getui.gtc.base.log.ILogController;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/d/b.class */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final List<ILogController> f8311a = new ArrayList();

    @Override // com.getui.gtc.base.log.d.a
    public final void a(int i, String str, String str2, Throwable th) {
        for (ILogController iLogController : this.f8311a) {
            try {
                if (iLogController.isLoggable(i, str)) {
                    iLogController.log(i, str, str2, th);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.getui.gtc.base.log.d.a
    public final void a(ILogController iLogController) {
        if (iLogController == null) {
            return;
        }
        this.f8311a.add(iLogController);
    }

    @Override // com.getui.gtc.base.log.d.a
    public final void b(ILogController iLogController) {
        if (this.f8311a.contains(iLogController)) {
            this.f8311a.remove(iLogController);
        }
    }
}
