package java.nio.charset;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.spi.CharsetProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import libcore.icu.NativeConverter;

/* loaded from: source-2895416-dex2jar.jar:java/nio/charset/Charset.class */
public abstract class Charset implements Comparable<Charset> {
    private static final HashMap<String, Charset> CACHED_CHARSETS = new HashMap<>();
    private static final Charset DEFAULT_CHARSET = getDefaultCharset();
    private final HashSet<String> aliasesSet;
    private final String canonicalName;

    /* JADX INFO: Access modifiers changed from: protected */
    public Charset(String str, String[] strArr) {
        checkCharsetName(str);
        this.canonicalName = str;
        this.aliasesSet = new HashSet<>();
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = strArr[i2];
            checkCharsetName(str2);
            this.aliasesSet.add(str2);
            i = i2 + 1;
        }
    }

    public static SortedMap<String, Charset> availableCharsets() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        String[] availableCharsetNames = NativeConverter.getAvailableCharsetNames();
        int length = availableCharsetNames.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Charset charsetForName = NativeConverter.charsetForName(availableCharsetNames[i2]);
            treeMap.put(charsetForName.name(), charsetForName);
            i = i2 + 1;
        }
        Iterator it = ServiceLoader.load(CharsetProvider.class).iterator();
        while (it.hasNext()) {
            Iterator<Charset> charsets = ((CharsetProvider) it.next()).charsets();
            while (charsets.hasNext()) {
                Charset next = charsets.next();
                if (!treeMap.containsKey(next.name())) {
                    treeMap.put(next.name(), next);
                }
            }
        }
        return Collections.unmodifiableSortedMap(treeMap);
    }

    private static Charset cacheCharset(String str, Charset charset) {
        Charset charset2;
        synchronized (CACHED_CHARSETS) {
            String name = charset.name();
            Charset charset3 = CACHED_CHARSETS.get(name);
            charset2 = charset3;
            if (charset3 == null) {
                charset2 = charset;
            }
            CACHED_CHARSETS.put(name, charset2);
            CACHED_CHARSETS.put(str, charset2);
            Iterator<String> it = charset.aliasesSet.iterator();
            while (it.hasNext()) {
                CACHED_CHARSETS.put(it.next(), charset2);
            }
        }
        return charset2;
    }

    private static void checkCharsetName(String str) {
        if (str.isEmpty()) {
            throw new IllegalCharsetNameException(str);
        }
        if (!isValidCharsetNameStart(str.charAt(0))) {
            throw new IllegalCharsetNameException(str);
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            if (!isValidCharsetNamePart(str.charAt(i2))) {
                throw new IllegalCharsetNameException(str);
            }
            i = i2 + 1;
        }
    }

    public static Charset defaultCharset() {
        return DEFAULT_CHARSET;
    }

    public static Charset forName(String str) {
        synchronized (CACHED_CHARSETS) {
            Charset charset = CACHED_CHARSETS.get(str);
            if (charset != null) {
                return charset;
            }
            if (str == null) {
                throw new IllegalCharsetNameException(null);
            }
            checkCharsetName(str);
            Charset charsetForName = NativeConverter.charsetForName(str);
            if (charsetForName != null) {
                return cacheCharset(str, charsetForName);
            }
            Iterator it = ServiceLoader.load(CharsetProvider.class).iterator();
            while (it.hasNext()) {
                Charset charsetForName2 = ((CharsetProvider) it.next()).charsetForName(str);
                if (charsetForName2 != null) {
                    return cacheCharset(str, charsetForName2);
                }
            }
            throw new UnsupportedCharsetException(str);
        }
    }

    public static Charset forNameUEE(String str) throws UnsupportedEncodingException {
        try {
            return forName(str);
        } catch (Exception e) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e);
            throw unsupportedEncodingException;
        }
    }

    private static Charset getDefaultCharset() {
        try {
            return forName(System.getProperty("file.encoding", "UTF-8"));
        } catch (UnsupportedCharsetException e) {
            return forName("UTF-8");
        }
    }

    public static boolean isSupported(String str) {
        try {
            forName(str);
            return true;
        } catch (UnsupportedCharsetException e) {
            return false;
        }
    }

    private static boolean isValidCharsetNamePart(char c) {
        if (c < 'A' || c > 'Z') {
            if (c < 'a' || c > 'z') {
                return (c >= '0' && c <= '9') || c == '-' || c == '.' || c == ':' || c == '_';
            }
            return true;
        }
        return true;
    }

    private static boolean isValidCharsetNameStart(char c) {
        if (c < 'A' || c > 'Z') {
            if (c < 'a' || c > 'z') {
                return c >= '0' && c <= '9';
            }
            return true;
        }
        return true;
    }

    public final Set<String> aliases() {
        return Collections.unmodifiableSet(this.aliasesSet);
    }

    public boolean canEncode() {
        return true;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Charset charset) {
        return this.canonicalName.compareToIgnoreCase(charset.canonicalName);
    }

    public abstract boolean contains(Charset charset);

    public final CharBuffer decode(ByteBuffer byteBuffer) {
        try {
            return newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(byteBuffer);
        } catch (CharacterCodingException e) {
            throw new Error(e.getMessage(), e);
        }
    }

    public String displayName() {
        return this.canonicalName;
    }

    public String displayName(Locale locale) {
        return this.canonicalName;
    }

    public final ByteBuffer encode(String str) {
        return encode(CharBuffer.wrap(str));
    }

    public final ByteBuffer encode(CharBuffer charBuffer) {
        try {
            return newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).encode(charBuffer);
        } catch (CharacterCodingException e) {
            throw new Error(e.getMessage(), e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Charset) {
            return this.canonicalName.equals(((Charset) obj).canonicalName);
        }
        return false;
    }

    public final int hashCode() {
        return this.canonicalName.hashCode();
    }

    public final boolean isRegistered() {
        return (this.canonicalName.startsWith("x-") || this.canonicalName.startsWith("X-")) ? false : true;
    }

    public final String name() {
        return this.canonicalName;
    }

    public abstract CharsetDecoder newDecoder();

    public abstract CharsetEncoder newEncoder();

    public final String toString() {
        return getClass().getName() + "[" + this.canonicalName + "]";
    }
}
