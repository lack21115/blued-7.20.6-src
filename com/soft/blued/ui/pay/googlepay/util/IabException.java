package com.soft.blued.ui.pay.googlepay.util;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/googlepay/util/IabException.class */
public class IabException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    IabResult f32998a;

    public IabException(int i, String str) {
        this(new IabResult(i, str));
    }

    public IabException(int i, String str, Exception exc) {
        this(new IabResult(i, str), exc);
    }

    public IabException(IabResult iabResult) {
        this(iabResult, (Exception) null);
    }

    public IabException(IabResult iabResult, Exception exc) {
        super(iabResult.a(), exc);
        this.f32998a = iabResult;
    }

    public IabResult a() {
        return this.f32998a;
    }
}
