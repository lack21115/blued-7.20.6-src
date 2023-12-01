package com.tramini.plugin.a.g.a;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/a/a.class */
public final class a implements CharSequence {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f26845a;

    public a(CharSequence charSequence) {
        this.f26845a = charSequence;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (Thread.currentThread().isInterrupted()) {
            throw new RuntimeException("Interrupted!");
        }
        return this.f26845a.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f26845a.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new a(this.f26845a.subSequence(i, i2));
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f26845a.toString();
    }
}
