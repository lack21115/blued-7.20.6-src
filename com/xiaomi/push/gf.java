package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gf.class */
public class gf extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private go f27744a;

    /* renamed from: a  reason: collision with other field name */
    private gp f461a;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f462a;

    public gf() {
        this.f27744a = null;
        this.f461a = null;
        this.f462a = null;
    }

    public gf(go goVar) {
        this.f27744a = null;
        this.f461a = null;
        this.f462a = null;
        this.f27744a = goVar;
    }

    public gf(String str) {
        super(str);
        this.f27744a = null;
        this.f461a = null;
        this.f462a = null;
    }

    public gf(String str, Throwable th) {
        super(str);
        this.f27744a = null;
        this.f461a = null;
        this.f462a = null;
        this.f462a = th;
    }

    public gf(Throwable th) {
        this.f27744a = null;
        this.f461a = null;
        this.f462a = null;
        this.f462a = th;
    }

    public Throwable a() {
        return this.f462a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        gp gpVar;
        String message = super.getMessage();
        if (message != null || (gpVar = this.f461a) == null) {
            String str = message;
            if (message == null) {
                go goVar = this.f27744a;
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
        if (this.f462a != null) {
            printStream.println("Nested Exception: ");
            this.f462a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f462a != null) {
            printWriter.println("Nested Exception: ");
            this.f462a.printStackTrace(printWriter);
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
        gp gpVar = this.f461a;
        if (gpVar != null) {
            sb.append(gpVar);
        }
        go goVar = this.f27744a;
        if (goVar != null) {
            sb.append(goVar);
        }
        if (this.f462a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f462a);
        }
        return sb.toString();
    }
}
