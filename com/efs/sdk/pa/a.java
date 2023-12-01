package com.efs.sdk.pa;

import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/pa/a.class */
public final class a implements PAANRListener {

    /* renamed from: a  reason: collision with root package name */
    private PAFactory f21848a;
    private PATraceListener b;

    public a(PAFactory pAFactory) {
        this.f21848a = pAFactory;
        this.b = pAFactory.getTraceListener();
        boolean enableTracer = pAFactory.getConfigManager().enableTracer();
        if (enableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            c.a(this.f21848a, "patracepv", null);
        }
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(enableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        c.a(this.f21848a, "patrace", str);
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onAnrTrace();
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
