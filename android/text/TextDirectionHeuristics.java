package android.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/text/TextDirectionHeuristics.class */
public class TextDirectionHeuristics {
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;
    public static final TextDirectionHeuristic LTR = new TextDirectionHeuristicInternal(null, false);
    public static final TextDirectionHeuristic RTL = new TextDirectionHeuristicInternal(null, true);
    public static final TextDirectionHeuristic FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
    public static final TextDirectionHeuristic FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
    public static final TextDirectionHeuristic ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
    public static final TextDirectionHeuristic LOCALE = TextDirectionHeuristicLocale.INSTANCE;

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextDirectionHeuristics$AnyStrong.class */
    private static class AnyStrong implements TextDirectionAlgorithm {
        private final boolean mLookForRtl;
        public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);

        private AnyStrong(boolean z) {
            this.mLookForRtl = z;
        }

        @Override // android.text.TextDirectionHeuristics.TextDirectionAlgorithm
        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3;
            boolean z = false;
            int i4 = i;
            while (true) {
                int i5 = i4;
                if (i5 < i + i2) {
                    switch (TextDirectionHeuristics.isRtlText(Character.getDirectionality(charSequence.charAt(i5)))) {
                        case 0:
                            if (!this.mLookForRtl) {
                                z = true;
                                break;
                            } else {
                                i3 = 0;
                                break;
                            }
                        case 1:
                            i3 = 1;
                            if (!this.mLookForRtl) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                    i4 = i5 + 1;
                } else if (!z) {
                    return 2;
                } else {
                    i3 = 1;
                    if (!this.mLookForRtl) {
                        return 0;
                    }
                }
            }
            return i3;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextDirectionHeuristics$FirstStrong.class */
    private static class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong INSTANCE = new FirstStrong();

        private FirstStrong() {
        }

        @Override // android.text.TextDirectionHeuristics.TextDirectionAlgorithm
        public int checkRtl(CharSequence charSequence, int i, int i2) {
            int i3 = 2;
            int i4 = i;
            while (true) {
                int i5 = i4;
                if (i5 >= i + i2 || i3 != 2) {
                    break;
                }
                i3 = TextDirectionHeuristics.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(i5)));
                i4 = i5 + 1;
            }
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/TextDirectionHeuristics$TextDirectionAlgorithm.class */
    public interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i, int i2);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextDirectionHeuristics$TextDirectionHeuristicImpl.class */
    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristic {
        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(CharSequence charSequence, int i, int i2) {
            switch (this.mAlgorithm.checkRtl(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return defaultIsRtl();
            }
        }

        protected abstract boolean defaultIsRtl();

        @Override // android.text.TextDirectionHeuristic
        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.mAlgorithm == null ? defaultIsRtl() : doCheck(charSequence, i, i2);
        }

        @Override // android.text.TextDirectionHeuristic
        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl(CharBuffer.wrap(cArr), i, i2);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextDirectionHeuristics$TextDirectionHeuristicInternal.class */
    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        private TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.mDefaultIsRtl = z;
        }

        @Override // android.text.TextDirectionHeuristics.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/TextDirectionHeuristics$TextDirectionHeuristicLocale.class */
    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // android.text.TextDirectionHeuristics.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int isRtlText(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int isRtlTextOrFormat(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
