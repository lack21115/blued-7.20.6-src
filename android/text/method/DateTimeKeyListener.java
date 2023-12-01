package android.text.method;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/DateTimeKeyListener.class */
public class DateTimeKeyListener extends NumberKeyListener {
    public static final char[] CHARACTERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm', 'p', ':', '/', '-', ' '};
    private static DateTimeKeyListener sInstance;

    public static DateTimeKeyListener getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        sInstance = new DateTimeKeyListener();
        return sInstance;
    }

    @Override // android.text.method.NumberKeyListener
    protected char[] getAcceptedChars() {
        return CHARACTERS;
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return 4;
    }
}
