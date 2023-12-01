package androidx.core.content;

import android.content.SharedPreferences;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/SharedPreferencesCompat.class */
public final class SharedPreferencesCompat {

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/SharedPreferencesCompat$EditorCompat.class */
    public static final class EditorCompat {

        /* renamed from: a  reason: collision with root package name */
        private static EditorCompat f2408a;
        private final Helper b = new Helper();

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/SharedPreferencesCompat$EditorCompat$Helper.class */
        static class Helper {
            Helper() {
            }

            public void apply(SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError e) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (f2408a == null) {
                f2408a = new EditorCompat();
            }
            return f2408a;
        }

        @Deprecated
        public void apply(SharedPreferences.Editor editor) {
            this.b.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
