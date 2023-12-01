package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/Spannable.class */
public interface Spannable extends Spanned {

    /* loaded from: source-9557208-dex2jar.jar:android/text/Spannable$Factory.class */
    public static class Factory {
        private static Factory sInstance = new Factory();

        public static Factory getInstance() {
            return sInstance;
        }

        public Spannable newSpannable(CharSequence charSequence) {
            return new SpannableString(charSequence);
        }
    }

    void removeSpan(Object obj);

    void setSpan(Object obj, int i, int i2, int i3);
}
