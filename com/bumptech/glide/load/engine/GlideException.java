package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/GlideException.class */
public final class GlideException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement[] f20784a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> b;

    /* renamed from: c  reason: collision with root package name */
    private Key f20785c;
    private DataSource d;
    private Class<?> e;
    private String f;
    private Exception g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/GlideException$IndentedAppendable.class */
    public static final class IndentedAppendable implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f20786a;
        private boolean b = true;

        IndentedAppendable(Appendable appendable) {
            this.f20786a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            if (charSequence == null) {
                charSequence2 = "";
            }
            return charSequence2;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.b) {
                this.b = false;
                this.f20786a.append("  ");
            }
            if (c2 == '\n') {
                z = true;
            }
            this.b = z;
            this.f20786a.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence a2 = a(charSequence);
            if (this.b) {
                this.b = false;
                this.f20786a.append("  ");
            }
            boolean z = false;
            if (a2.length() > 0) {
                z = false;
                if (a2.charAt(i2 - 1) == '\n') {
                    z = true;
                }
            }
            this.b = z;
            this.f20786a.append(a2, i, i2);
            return this;
        }
    }

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.f = str;
        setStackTrace(f20784a);
        this.b = list;
    }

    private void a(Appendable appendable) {
        a(this, appendable);
        a(b(), new IndentedAppendable(appendable));
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException e) {
            throw new RuntimeException(th);
        }
    }

    private void a(Throwable th, List<Throwable> list) {
        if (!(th instanceof GlideException)) {
            list.add(th);
            return;
        }
        for (Throwable th2 : ((GlideException) th).b()) {
            a(th2, list);
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i = i3;
        }
    }

    public Exception a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Key key, DataSource dataSource) {
        a(key, dataSource, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Key key, DataSource dataSource, Class<?> cls) {
        this.f20785c = key;
        this.d = dataSource;
        this.e = cls;
    }

    public void a(Exception exc) {
        this.g = exc;
    }

    public void a(String str) {
        List<Throwable> c2 = c();
        int size = c2.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), c2.get(i2));
            i = i3;
        }
    }

    public List<Throwable> b() {
        return this.b;
    }

    public List<Throwable> c() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f);
        sb.append(this.e != null ? ", " + this.e : "");
        sb.append(this.d != null ? ", " + this.d : "");
        sb.append(this.f20785c != null ? ", " + this.f20785c : "");
        List<Throwable> c2 = c();
        if (c2.isEmpty()) {
            return sb.toString();
        }
        if (c2.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(c2.size());
            sb.append(" causes:");
        }
        for (Throwable th : c2) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(printWriter);
    }
}
