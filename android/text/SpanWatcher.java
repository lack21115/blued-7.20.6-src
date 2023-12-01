package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/SpanWatcher.class */
public interface SpanWatcher extends NoCopySpan {
    void onSpanAdded(Spannable spannable, Object obj, int i, int i2);

    void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4);

    void onSpanRemoved(Spannable spannable, Object obj, int i, int i2);
}
