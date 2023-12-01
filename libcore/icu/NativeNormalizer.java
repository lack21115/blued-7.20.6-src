package libcore.icu;

import java.text.Normalizer;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeNormalizer.class */
public final class NativeNormalizer {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: libcore.icu.NativeNormalizer$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeNormalizer$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$text$Normalizer$Form = new int[Normalizer.Form.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:19:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$java$text$Normalizer$Form[Normalizer.Form.NFC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$text$Normalizer$Form[Normalizer.Form.NFD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$text$Normalizer$Form[Normalizer.Form.NFKC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$text$Normalizer$Form[Normalizer.Form.NFKD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private NativeNormalizer() {
    }

    public static boolean isNormalized(CharSequence charSequence, Normalizer.Form form) {
        return isNormalizedImpl(charSequence.toString(), toUNormalizationMode(form));
    }

    private static native boolean isNormalizedImpl(String str, int i);

    public static String normalize(CharSequence charSequence, Normalizer.Form form) {
        return normalizeImpl(charSequence.toString(), toUNormalizationMode(form));
    }

    private static native String normalizeImpl(String str, int i);

    private static int toUNormalizationMode(Normalizer.Form form) {
        switch (AnonymousClass1.$SwitchMap$java$text$Normalizer$Form[form.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 2;
            case 3:
                return 5;
            case 4:
                return 3;
            default:
                throw new AssertionError("unknown Normalizer.Form " + form);
        }
    }
}
