package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiEditableFactory.class */
final class EmojiEditableFactory extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2881a = new Object();
    private static volatile Editable.Factory b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f2882c;

    private EmojiEditableFactory() {
        try {
            f2882c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, getClass().getClassLoader());
        } catch (Throwable th) {
        }
    }

    public static Editable.Factory getInstance() {
        if (b == null) {
            synchronized (f2881a) {
                if (b == null) {
                    b = new EmojiEditableFactory();
                }
            }
        }
        return b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f2882c;
        return cls != null ? SpannableBuilder.create(cls, charSequence) : super.newEditable(charSequence);
    }
}
