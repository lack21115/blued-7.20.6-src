package android.view;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import java.text.BreakIterator;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityIterators.class */
public final class AccessibilityIterators {

    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityIterators$AbstractTextSegmentIterator.class */
    public static abstract class AbstractTextSegmentIterator implements TextSegmentIterator {
        private final int[] mSegment = new int[2];
        protected String mText;

        /* JADX INFO: Access modifiers changed from: protected */
        public int[] getRange(int i, int i2) {
            if (i < 0 || i2 < 0 || i == i2) {
                return null;
            }
            this.mSegment[0] = i;
            this.mSegment[1] = i2;
            return this.mSegment;
        }

        public void initialize(String str) {
            this.mText = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityIterators$CharacterTextSegmentIterator.class */
    public static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator implements ComponentCallbacks {
        private static CharacterTextSegmentIterator sInstance;
        protected BreakIterator mImpl;
        private Locale mLocale;

        private CharacterTextSegmentIterator(Locale locale) {
            this.mLocale = locale;
            onLocaleChanged(locale);
            ViewRootImpl.addConfigCallback(this);
        }

        public static CharacterTextSegmentIterator getInstance(Locale locale) {
            if (sInstance == null) {
                sInstance = new CharacterTextSegmentIterator(locale);
            }
            return sInstance;
        }

        @Override // android.view.AccessibilityIterators.TextSegmentIterator
        public int[] following(int i) {
            int length = this.mText.length();
            if (length > 0 && i < length) {
                int i2 = i;
                if (i < 0) {
                    i2 = 0;
                }
                while (!this.mImpl.isBoundary(i2)) {
                    int following = this.mImpl.following(i2);
                    i2 = following;
                    if (following == -1) {
                        return null;
                    }
                }
                int following2 = this.mImpl.following(i2);
                if (following2 != -1) {
                    return getRange(i2, following2);
                }
                return null;
            }
            return null;
        }

        @Override // android.view.AccessibilityIterators.AbstractTextSegmentIterator
        public void initialize(String str) {
            super.initialize(str);
            this.mImpl.setText(str);
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            Locale locale = configuration.locale;
            if (this.mLocale.equals(locale)) {
                return;
            }
            this.mLocale = locale;
            onLocaleChanged(locale);
        }

        protected void onLocaleChanged(Locale locale) {
            this.mImpl = BreakIterator.getCharacterInstance(locale);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.view.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int i) {
            int length = this.mText.length();
            if (length > 0 && i > 0) {
                int i2 = i;
                if (i > length) {
                    i2 = length;
                }
                while (!this.mImpl.isBoundary(i2)) {
                    int preceding = this.mImpl.preceding(i2);
                    i2 = preceding;
                    if (preceding == -1) {
                        return null;
                    }
                }
                int preceding2 = this.mImpl.preceding(i2);
                if (preceding2 != -1) {
                    return getRange(preceding2, i2);
                }
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityIterators$ParagraphTextSegmentIterator.class */
    public static class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {
        private static ParagraphTextSegmentIterator sInstance;

        ParagraphTextSegmentIterator() {
        }

        public static ParagraphTextSegmentIterator getInstance() {
            if (sInstance == null) {
                sInstance = new ParagraphTextSegmentIterator();
            }
            return sInstance;
        }

        private boolean isEndBoundary(int i) {
            if (i <= 0 || this.mText.charAt(i - 1) == '\n') {
                return false;
            }
            return i == this.mText.length() || this.mText.charAt(i) == '\n';
        }

        private boolean isStartBoundary(int i) {
            if (this.mText.charAt(i) != '\n') {
                return i == 0 || this.mText.charAt(i - 1) == '\n';
            }
            return false;
        }

        @Override // android.view.AccessibilityIterators.TextSegmentIterator
        public int[] following(int i) {
            int i2;
            int length = this.mText.length();
            if (length > 0 && i < length) {
                int i3 = i;
                if (i < 0) {
                    i3 = 0;
                }
                while (i3 < length && this.mText.charAt(i3) == '\n' && !isStartBoundary(i3)) {
                    i3++;
                }
                if (i3 < length) {
                    int i4 = i3;
                    while (true) {
                        i2 = i4 + 1;
                        if (i2 >= length || isEndBoundary(i2)) {
                            break;
                        }
                        i4 = i2;
                    }
                    return getRange(i3, i2);
                }
                return null;
            }
            return null;
        }

        @Override // android.view.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int i) {
            int i2;
            int length = this.mText.length();
            if (length > 0 && i > 0) {
                int i3 = i;
                if (i > length) {
                    i3 = length;
                }
                while (i3 > 0 && this.mText.charAt(i3 - 1) == '\n' && !isEndBoundary(i3)) {
                    i3--;
                }
                if (i3 > 0) {
                    int i4 = i3;
                    while (true) {
                        i2 = i4 - 1;
                        if (i2 <= 0 || isStartBoundary(i2)) {
                            break;
                        }
                        i4 = i2;
                    }
                    return getRange(i2, i3);
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityIterators$TextSegmentIterator.class */
    public interface TextSegmentIterator {
        int[] following(int i);

        int[] preceding(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/AccessibilityIterators$WordTextSegmentIterator.class */
    public static class WordTextSegmentIterator extends CharacterTextSegmentIterator {
        private static WordTextSegmentIterator sInstance;

        private WordTextSegmentIterator(Locale locale) {
            super(locale);
        }

        public static WordTextSegmentIterator getInstance(Locale locale) {
            if (sInstance == null) {
                sInstance = new WordTextSegmentIterator(locale);
            }
            return sInstance;
        }

        private boolean isEndBoundary(int i) {
            if (i <= 0 || !isLetterOrDigit(i - 1)) {
                return false;
            }
            return i == this.mText.length() || !isLetterOrDigit(i);
        }

        private boolean isLetterOrDigit(int i) {
            if (i < 0 || i >= this.mText.length()) {
                return false;
            }
            return Character.isLetterOrDigit(this.mText.codePointAt(i));
        }

        private boolean isStartBoundary(int i) {
            if (isLetterOrDigit(i)) {
                return i == 0 || !isLetterOrDigit(i - 1);
            }
            return false;
        }

        @Override // android.view.AccessibilityIterators.CharacterTextSegmentIterator, android.view.AccessibilityIterators.TextSegmentIterator
        public int[] following(int i) {
            if (this.mText.length() > 0 && i < this.mText.length()) {
                int i2 = i;
                if (i < 0) {
                    i2 = 0;
                }
                while (!isLetterOrDigit(i2) && !isStartBoundary(i2)) {
                    int following = this.mImpl.following(i2);
                    i2 = following;
                    if (following == -1) {
                        return null;
                    }
                }
                int following2 = this.mImpl.following(i2);
                if (following2 == -1 || !isEndBoundary(following2)) {
                    return null;
                }
                return getRange(i2, following2);
            }
            return null;
        }

        @Override // android.view.AccessibilityIterators.CharacterTextSegmentIterator
        protected void onLocaleChanged(Locale locale) {
            this.mImpl = BreakIterator.getWordInstance(locale);
        }

        @Override // android.view.AccessibilityIterators.CharacterTextSegmentIterator, android.view.AccessibilityIterators.TextSegmentIterator
        public int[] preceding(int i) {
            int length = this.mText.length();
            if (length > 0 && i > 0) {
                int i2 = i;
                if (i > length) {
                    i2 = length;
                }
                while (i2 > 0 && !isLetterOrDigit(i2 - 1) && !isEndBoundary(i2)) {
                    int preceding = this.mImpl.preceding(i2);
                    i2 = preceding;
                    if (preceding == -1) {
                        return null;
                    }
                }
                int preceding2 = this.mImpl.preceding(i2);
                if (preceding2 == -1 || !isStartBoundary(preceding2)) {
                    return null;
                }
                return getRange(preceding2, i2);
            }
            return null;
        }
    }
}
