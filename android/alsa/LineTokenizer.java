package android.alsa;

/* loaded from: source-9557208-dex2jar.jar:android/alsa/LineTokenizer.class */
public class LineTokenizer {
    public static final int kTokenNotFound = -1;
    private String mDelimiters;

    public LineTokenizer(String str) {
        this.mDelimiters = "";
        this.mDelimiters = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nextDelimiter(String str, int i) {
        int length = str.length();
        while (i < length && this.mDelimiters.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        if (i < length) {
            return i;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int nextToken(String str, int i) {
        int length = str.length();
        while (i < length && this.mDelimiters.indexOf(str.charAt(i)) != -1) {
            i++;
        }
        if (i < length) {
            return i;
        }
        return -1;
    }
}
