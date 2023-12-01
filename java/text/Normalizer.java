package java.text;

import libcore.icu.NativeNormalizer;

/* loaded from: source-2895416-dex2jar.jar:java/text/Normalizer.class */
public final class Normalizer {

    /* loaded from: source-2895416-dex2jar.jar:java/text/Normalizer$Form.class */
    public enum Form {
        NFD,
        NFC,
        NFKD,
        NFKC
    }

    private Normalizer() {
    }

    public static boolean isNormalized(CharSequence charSequence, Form form) {
        return NativeNormalizer.isNormalized(charSequence, form);
    }

    public static String normalize(CharSequence charSequence, Form form) {
        return NativeNormalizer.normalize(charSequence, form);
    }
}
