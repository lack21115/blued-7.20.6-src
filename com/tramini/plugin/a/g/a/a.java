package com.tramini.plugin.a.g.a;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/a/a.class */
public final class a implements CharSequence {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f40536a;

    public a(CharSequence charSequence) {
        this.f40536a = charSequence;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (Thread.currentThread().isInterrupted()) {
            throw new RuntimeException("Interrupted!");
        }
        return this.f40536a.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f40536a.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new a(this.f40536a.subSequence(i, i2));
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f40536a.toString();
    }
}
