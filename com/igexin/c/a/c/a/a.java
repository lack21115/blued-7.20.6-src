package com.igexin.c.a.c.a;

import com.igexin.sdk.IUserLoggerInterface;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/c/a/a.class */
public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23252a = "[GT-PUSH] ";
    private IUserLoggerInterface b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuffer f23253c = new StringBuffer();

    private void b() {
        if (this.f23253c.length() > 0) {
            if (this.f23253c.toString().contains("\n")) {
                String[] split = this.f23253c.toString().split("\n");
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str = split[i2];
                    IUserLoggerInterface iUserLoggerInterface = this.b;
                    if (iUserLoggerInterface != null) {
                        iUserLoggerInterface.log(f23252a.concat(String.valueOf(str)));
                    }
                    i = i2 + 1;
                }
            } else {
                IUserLoggerInterface iUserLoggerInterface2 = this.b;
                iUserLoggerInterface2.log(f23252a + this.f23253c.toString());
            }
            this.f23253c.setLength(0);
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void a() {
        if (this.b != null) {
            b();
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void a(IUserLoggerInterface iUserLoggerInterface) {
        if (iUserLoggerInterface != null) {
            this.b = iUserLoggerInterface;
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void a(String str) {
        if (this.b != null) {
            b();
            this.b.log(f23252a.concat(String.valueOf(str)));
        } else if (this.f23253c.length() + str.length() < 5120) {
            StringBuffer stringBuffer = this.f23253c;
            stringBuffer.append(str);
            stringBuffer.append("\n");
        } else if (this.f23253c.length() > 5120 || this.f23253c.length() + 135 <= 5120) {
        } else {
            StringBuffer stringBuffer2 = this.f23253c;
            stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
            stringBuffer2.append("\n");
        }
    }

    @Override // com.igexin.c.a.c.a.b
    public final void b(String str) {
        if (this.f23253c.length() + str.length() < 5120) {
            StringBuffer stringBuffer = this.f23253c;
            stringBuffer.append(str);
            stringBuffer.append("\n");
        } else if (this.f23253c.length() > 5120 || this.f23253c.length() + 135 <= 5120) {
        } else {
            StringBuffer stringBuffer2 = this.f23253c;
            stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
            stringBuffer2.append("\n");
        }
    }
}
