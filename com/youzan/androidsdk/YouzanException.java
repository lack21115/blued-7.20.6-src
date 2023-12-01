package com.youzan.androidsdk;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/YouzanException.class */
public class YouzanException extends Exception {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f1094;

    public YouzanException(int i, String str) {
        super(str);
        this.f1094 = 0;
        this.f1094 = i;
    }

    public YouzanException(String str) {
        super(str);
        this.f1094 = 0;
    }

    public YouzanException(Throwable th) {
        super(th);
        this.f1094 = 0;
        if (th instanceof YouzanException) {
            this.f1094 = ((YouzanException) th).getCode();
        }
    }

    public int getCode() {
        return this.f1094;
    }

    public String getMsg() {
        return getMessage();
    }
}
