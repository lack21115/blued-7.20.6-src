package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/SpannableBuilder.class */
public final class SpannableBuilder extends SpannableStringBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2797a;
    private final List<WatcherWrapper> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/SpannableBuilder$WatcherWrapper.class */
    public static class WatcherWrapper implements SpanWatcher, TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final Object f2798a;
        private final AtomicInteger b = new AtomicInteger(0);

        WatcherWrapper(Object obj) {
            this.f2798a = obj;
        }

        private boolean a(Object obj) {
            return obj instanceof EmojiSpan;
        }

        final void a() {
            this.b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f2798a).afterTextChanged(editable);
        }

        final void b() {
            this.b.decrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f2798a).beforeTextChanged(charSequence, i, i2, i3);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (this.b.get() <= 0 || !a(obj)) {
                ((SpanWatcher) this.f2798a).onSpanAdded(spannable, obj, i, i2);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            if (this.b.get() <= 0 || !a(obj)) {
                ((SpanWatcher) this.f2798a).onSpanChanged(spannable, obj, i, i2, i3, i4);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (this.b.get() <= 0 || !a(obj)) {
                ((SpanWatcher) this.f2798a).onSpanRemoved(spannable, obj, i, i2);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f2798a).onTextChanged(charSequence, i, i2, i3);
        }
    }

    SpannableBuilder(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.b = new ArrayList();
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.f2797a = cls;
    }

    SpannableBuilder(Class<?> cls, CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        this.b = new ArrayList();
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.f2797a = cls;
    }

    private void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            this.b.get(i2).a();
            i = i2 + 1;
        }
    }

    private boolean a(Class<?> cls) {
        return this.f2797a == cls;
    }

    private boolean a(Object obj) {
        return obj != null && a(obj.getClass());
    }

    private WatcherWrapper b(Object obj) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return null;
            }
            WatcherWrapper watcherWrapper = this.b.get(i2);
            if (watcherWrapper.f2798a == obj) {
                return watcherWrapper;
            }
            i = i2 + 1;
        }
    }

    private void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            this.b.get(i2).b();
            i = i2 + 1;
        }
    }

    private void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            this.b.get(i2).onTextChanged(this, 0, length(), length());
            i = i2 + 1;
        }
    }

    public static SpannableBuilder create(Class<?> cls, CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable
    public SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i, int i2) {
        super.append(charSequence, i, i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }

    public void beginBatchEdit() {
        a();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i, int i2) {
        super.delete(i, i2);
        return this;
    }

    public void endBatchEdit() {
        b();
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        WatcherWrapper watcherWrapper = obj;
        if (a(obj)) {
            WatcherWrapper b = b(obj);
            watcherWrapper = obj;
            if (b != null) {
                watcherWrapper = b;
            }
        }
        return super.getSpanEnd(watcherWrapper);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        WatcherWrapper watcherWrapper = obj;
        if (a(obj)) {
            WatcherWrapper b = b(obj);
            watcherWrapper = obj;
            if (b != null) {
                watcherWrapper = b;
            }
        }
        return super.getSpanFlags(watcherWrapper);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        WatcherWrapper watcherWrapper = obj;
        if (a(obj)) {
            WatcherWrapper b = b(obj);
            watcherWrapper = obj;
            if (b != null) {
                watcherWrapper = b;
            }
        }
        return super.getSpanStart(watcherWrapper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (!a((Class<?>) cls)) {
            return (T[]) super.getSpans(i, i2, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i, i2, WatcherWrapper.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, watcherWrapperArr.length));
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= watcherWrapperArr.length) {
                return tArr;
            }
            tArr[i4] = watcherWrapperArr[i4].f2798a;
            i3 = i4 + 1;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        super.insert(i, charSequence, i2, i3);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (a((java.lang.Class<?>) r8) != false) goto L8;
     */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int nextSpanTransition(int r6, int r7, java.lang.Class r8) {
        /*
            r5 = this;
            r0 = r8
            if (r0 == 0) goto Lf
            r0 = r8
            r9 = r0
            r0 = r5
            r1 = r8
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L13
        Lf:
            java.lang.Class<androidx.emoji2.text.SpannableBuilder$WatcherWrapper> r0 = androidx.emoji2.text.SpannableBuilder.WatcherWrapper.class
            r9 = r0
        L13:
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r9
            int r0 = super.nextSpanTransition(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.SpannableBuilder.nextSpanTransition(int, int, java.lang.Class):int");
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (a(obj)) {
            WatcherWrapper b = b(obj);
            watcherWrapper = b;
            if (b != null) {
                obj = b;
                watcherWrapper = b;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.b.remove(watcherWrapper);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        a();
        super.replace(i, i2, charSequence);
        b();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        a();
        super.replace(i, i2, charSequence, i3, i4);
        b();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        WatcherWrapper watcherWrapper = obj;
        if (a(obj)) {
            watcherWrapper = new WatcherWrapper(obj);
            this.b.add(watcherWrapper);
        }
        super.setSpan(watcherWrapper, i, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return new SpannableBuilder(this.f2797a, this, i, i2);
    }
}
