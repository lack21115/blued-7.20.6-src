package android.text;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.provider.UserDictionary;
import android.view.View;
import com.android.internal.util.XmlUtils;
import com.cdo.oaps.ad.OapsKey;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/text/AutoText.class */
public class AutoText {
    private static final int DEFAULT = 14337;
    private static final int INCREMENT = 1024;
    private static final int RIGHT = 9300;
    private static final int TRIE_C = 0;
    private static final int TRIE_CHILD = 2;
    private static final int TRIE_NEXT = 3;
    private static final char TRIE_NULL = 65535;
    private static final int TRIE_OFF = 1;
    private static final int TRIE_ROOT = 0;
    private static final int TRIE_SIZEOF = 4;
    private static AutoText sInstance = new AutoText(Resources.getSystem());
    private static Object sLock = new Object();
    private Locale mLocale;
    private int mSize;
    private String mText;
    private char[] mTrie;
    private char mTrieUsed;

    private AutoText(Resources resources) {
        this.mLocale = resources.getConfiguration().locale;
        init(resources);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0074, code lost:
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007a, code lost:
        if (r13 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007d, code lost:
        r5.mTrie[r10] = newTrieNode();
        r5.mTrie[r5.mTrie[r10] + 0] = r0;
        r5.mTrie[r5.mTrie[r10] + 1] = 65535;
        r5.mTrie[r5.mTrie[r10] + 3] = 65535;
        r5.mTrie[r5.mTrie[r10] + 2] = 65535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d1, code lost:
        if (r12 != (r0 - 1)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00d4, code lost:
        r5.mTrie[r5.mTrie[r10] + 1] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00e3, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f2, code lost:
        r11 = r5.mTrie[r10] + 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void add(java.lang.String r6, char r7) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.AutoText.add(java.lang.String, char):void");
    }

    public static String get(CharSequence charSequence, int i, int i2, View view) {
        return getInstance(view).lookup(charSequence, i, i2);
    }

    private static AutoText getInstance(View view) {
        AutoText autoText;
        Resources resources = view.getContext().getResources();
        Locale locale = resources.getConfiguration().locale;
        synchronized (sLock) {
            AutoText autoText2 = sInstance;
            autoText = autoText2;
            if (!locale.equals(autoText2.mLocale)) {
                autoText = new AutoText(resources);
                sInstance = autoText;
            }
        }
        return autoText;
    }

    private int getSize() {
        return this.mSize;
    }

    public static int getSize(View view) {
        return getInstance(view).getSize();
    }

    private void init(Resources resources) {
        char length;
        XmlResourceParser xml = resources.getXml(17891330);
        StringBuilder sb = new StringBuilder((int) RIGHT);
        this.mTrie = new char[14337];
        this.mTrie[0] = 65535;
        this.mTrieUsed = (char) 1;
        try {
            try {
                XmlUtils.beginDocument(xml, "words");
                while (true) {
                    XmlUtils.nextElement(xml);
                    String name = xml.getName();
                    if (name == null || !name.equals(UserDictionary.Words.WORD)) {
                        break;
                    }
                    String attributeValue = xml.getAttributeValue(null, OapsKey.KEY_SRC);
                    if (xml.next() == 4) {
                        String text = xml.getText();
                        if (text.equals("")) {
                            length = 0;
                        } else {
                            length = (char) sb.length();
                            sb.append((char) text.length());
                            sb.append(text);
                        }
                        add(attributeValue, length);
                    }
                }
                resources.flushLayoutCache();
                xml.close();
                this.mText = sb.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (XmlPullParserException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    private String lookup(CharSequence charSequence, int i, int i2) {
        String str;
        int i3 = i;
        char c2 = this.mTrie[0];
        while (true) {
            str = null;
            if (i3 >= i2) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            char c3 = c2;
            while (true) {
                char c4 = c3;
                c2 = c4;
                if (c4 == 65535) {
                    break;
                } else if (charAt != this.mTrie[c4 + 0]) {
                    c3 = this.mTrie[c4 + 3];
                } else if (i3 == i2 - 1 && this.mTrie[c4 + 1] != 65535) {
                    char c5 = this.mTrie[c4 + 1];
                    str = this.mText.substring(c5 + 1, c5 + 1 + this.mText.charAt(c5));
                    break;
                } else {
                    c2 = this.mTrie[c4 + 2];
                }
            }
            str = null;
            if (c2 == 65535) {
                break;
            }
            i3++;
        }
        return str;
    }

    private char newTrieNode() {
        if (this.mTrieUsed + 4 > this.mTrie.length) {
            char[] cArr = new char[this.mTrie.length + 1024];
            System.arraycopy(this.mTrie, 0, cArr, 0, this.mTrie.length);
            this.mTrie = cArr;
        }
        char c2 = this.mTrieUsed;
        this.mTrieUsed = (char) (this.mTrieUsed + 4);
        return c2;
    }
}
