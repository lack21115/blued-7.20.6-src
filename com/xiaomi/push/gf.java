package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gf.class */
public class gf extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private go f41435a;

    /* renamed from: a  reason: collision with other field name */
    private gp f508a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f509a;

    public gf() {
        this.f41435a = null;
        this.f508a = null;
        this.f509a = null;
    }

    public gf(go goVar) {
        this.f41435a = null;
        this.f508a = null;
        this.f509a = null;
        this.f41435a = goVar;
    }

    public gf(String str) {
        super(str);
        this.f41435a = null;
        this.f508a = null;
        this.f509a = null;
    }

    public gf(String str, Throwable th) {
        super(str);
        this.f41435a = null;
        this.f508a = null;
        this.f509a = null;
        this.f509a = th;
    }

    public gf(Throwable th) {
        this.f41435a = null;
        this.f508a = null;
        this.f509a = null;
        this.f509a = th;
    }

    public Throwable a() {
        return this.f509a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        gp gpVar;
        String message = super.getMessage();
        if (message != null || (gpVar = this.f508a) == null) {
            String str = message;
            if (message == null) {
                go goVar = this.f41435a;
                str = message;
                if (goVar != null) {
                    str = goVar.toString();
                }
            }
            return str;
        }
        return gpVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f509a != null) {
            printStream.println("Nested Exception: ");
            this.f509a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f509a != null) {
            printWriter.println("Nested Exception: ");
            this.f509a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        gp gpVar = this.f508a;
        if (gpVar != null) {
            sb.append(gpVar);
        }
        go goVar = this.f41435a;
        if (goVar != null) {
            sb.append(goVar);
        }
        if (this.f509a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f509a);
        }
        return sb.toString();
    }
}
