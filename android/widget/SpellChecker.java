package android.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.WordIterator;
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionSpan;
import android.util.Log;
import android.util.LruCache;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.GrowingArrayUtils;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:android/widget/SpellChecker.class */
public class SpellChecker implements SpellCheckerSession.SpellCheckerSessionListener {
    public static final int AVERAGE_WORD_LENGTH = 7;
    private static final boolean DBG = false;
    public static final int MAX_NUMBER_OF_WORDS = 50;
    private static final int MIN_SENTENCE_LENGTH = 50;
    private static final int SPELL_PAUSE_DURATION = 400;
    private static final int SUGGESTION_SPAN_CACHE_SIZE = 10;
    private static final String TAG = SpellChecker.class.getSimpleName();
    private static final int USE_SPAN_RANGE = -1;
    public static final int WORD_ITERATOR_INTERVAL = 350;
    final int mCookie;
    private Locale mCurrentLocale;
    private boolean mIsSentenceSpellCheckSupported;
    private int mLength;
    SpellCheckerSession mSpellCheckerSession;
    private Runnable mSpellRunnable;
    private TextServicesManager mTextServicesManager;
    private final TextView mTextView;
    private WordIterator mWordIterator;
    private SpellParser[] mSpellParsers = new SpellParser[0];
    private int mSpanSequenceCounter = 0;
    private final LruCache<Long, SuggestionSpan> mSuggestionSpanCache = new LruCache<>(10);
    private int[] mIds = ArrayUtils.newUnpaddedIntArray(1);
    private SpellCheckSpan[] mSpellCheckSpans = new SpellCheckSpan[this.mIds.length];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/SpellChecker$SpellParser.class */
    public class SpellParser {
        private Object mRange;

        private SpellParser() {
            this.mRange = new Object();
        }

        private void removeRangeSpan(Editable editable) {
            editable.removeSpan(this.mRange);
        }

        private <T> void removeSpansAt(Editable editable, int i, T[] tArr) {
            int length = tArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                T t = tArr[i3];
                if (editable.getSpanStart(t) <= i && editable.getSpanEnd(t) >= i) {
                    editable.removeSpan(t);
                }
                i2 = i3 + 1;
            }
        }

        private void setRangeSpan(Editable editable, int i, int i2) {
            editable.setSpan(this.mRange, i, i2, 33);
        }

        public boolean isFinished() {
            return ((Editable) SpellChecker.this.mTextView.getText()).getSpanStart(this.mRange) < 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:114:0x037e, code lost:
            if (r0 >= r12) goto L128;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void parse() {
            /*
                Method dump skipped, instructions count: 1012
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.SpellChecker.SpellParser.parse():void");
        }

        public void parse(int i, int i2) {
            int length = SpellChecker.this.mTextView.length();
            if (i2 > length) {
                Log.w(SpellChecker.TAG, "Parse invalid region, from " + i + " to " + i2);
                i2 = length;
            }
            if (i2 > i) {
                setRangeSpan((Editable) SpellChecker.this.mTextView.getText(), i, i2);
                parse();
            }
        }

        public void stop() {
            removeRangeSpan((Editable) SpellChecker.this.mTextView.getText());
        }
    }

    public SpellChecker(TextView textView) {
        this.mTextView = textView;
        setLocale(this.mTextView.getSpellCheckerLocale());
        this.mCookie = hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSpellCheckSpan(Editable editable, int i, int i2) {
        int nextSpellCheckSpanIndex = nextSpellCheckSpanIndex();
        SpellCheckSpan spellCheckSpan = this.mSpellCheckSpans[nextSpellCheckSpanIndex];
        editable.setSpan(spellCheckSpan, i, i2, 33);
        spellCheckSpan.setSpellCheckInProgress(false);
        int[] iArr = this.mIds;
        int i3 = this.mSpanSequenceCounter;
        this.mSpanSequenceCounter = i3 + 1;
        iArr[nextSpellCheckSpanIndex] = i3;
    }

    private void createMisspelledSuggestionSpan(Editable editable, SuggestionsInfo suggestionsInfo, SpellCheckSpan spellCheckSpan, int i, int i2) {
        int i3;
        int i4;
        String[] strArr;
        int spanStart = editable.getSpanStart(spellCheckSpan);
        int spanEnd = editable.getSpanEnd(spellCheckSpan);
        if (spanStart < 0 || spanEnd <= spanStart) {
            return;
        }
        if (i == -1 || i2 == -1) {
            i3 = spanStart;
            i4 = spanEnd;
        } else {
            int i5 = spanStart + i;
            int i6 = i5 + i2;
            i3 = i5;
            i4 = i6;
        }
        int suggestionsCount = suggestionsInfo.getSuggestionsCount();
        if (suggestionsCount > 0) {
            String[] strArr2 = new String[suggestionsCount];
            int i7 = 0;
            while (true) {
                int i8 = i7;
                strArr = strArr2;
                if (i8 >= suggestionsCount) {
                    break;
                }
                strArr2[i8] = suggestionsInfo.getSuggestionAt(i8);
                i7 = i8 + 1;
            }
        } else {
            strArr = (String[]) ArrayUtils.emptyArray(String.class);
        }
        SuggestionSpan suggestionSpan = new SuggestionSpan(this.mTextView.getContext(), strArr, 3);
        if (this.mIsSentenceSpellCheckSupported) {
            Long valueOf = Long.valueOf(TextUtils.packRangeInLong(i3, i4));
            SuggestionSpan suggestionSpan2 = this.mSuggestionSpanCache.get(valueOf);
            if (suggestionSpan2 != null) {
                editable.removeSpan(suggestionSpan2);
            }
            this.mSuggestionSpanCache.put(valueOf, suggestionSpan);
        }
        editable.setSpan(suggestionSpan, i3, i4, 33);
        this.mTextView.invalidateRegion(i3, i4, false);
    }

    public static boolean haveWordBoundariesChanged(Editable editable, int i, int i2, int i3, int i4) {
        if (i4 == i || i3 == i2) {
            if (i4 != i || i >= editable.length()) {
                if (i3 != i2 || i2 <= 0) {
                    return false;
                }
                return Character.isLetterOrDigit(Character.codePointBefore(editable, i2));
            }
            return Character.isLetterOrDigit(Character.codePointAt(editable, i));
        }
        return true;
    }

    private boolean isSessionActive() {
        return this.mSpellCheckerSession != null;
    }

    private int nextSpellCheckSpanIndex() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mLength) {
                this.mIds = GrowingArrayUtils.append(this.mIds, this.mLength, 0);
                this.mSpellCheckSpans = (SpellCheckSpan[]) GrowingArrayUtils.append(this.mSpellCheckSpans, this.mLength, new SpellCheckSpan());
                this.mLength++;
                return this.mLength - 1;
            } else if (this.mIds[i2] < 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
    }

    private SpellCheckSpan onGetSuggestionsInternal(SuggestionsInfo suggestionsInfo, int i, int i2) {
        SpellCheckSpan spellCheckSpan;
        int i3;
        int i4;
        if (suggestionsInfo == null || suggestionsInfo.getCookie() != this.mCookie) {
            spellCheckSpan = null;
        } else {
            Editable editable = (Editable) this.mTextView.getText();
            int sequence = suggestionsInfo.getSequence();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.mLength) {
                    return null;
                }
                if (sequence == this.mIds[i6]) {
                    int suggestionsAttributes = suggestionsInfo.getSuggestionsAttributes();
                    boolean z = (suggestionsAttributes & 1) > 0;
                    boolean z2 = (suggestionsAttributes & 2) > 0;
                    SpellCheckSpan spellCheckSpan2 = this.mSpellCheckSpans[i6];
                    if (!z && z2) {
                        createMisspelledSuggestionSpan(editable, suggestionsInfo, spellCheckSpan2, i, i2);
                        return spellCheckSpan2;
                    }
                    spellCheckSpan = spellCheckSpan2;
                    if (this.mIsSentenceSpellCheckSupported) {
                        int spanStart = editable.getSpanStart(spellCheckSpan2);
                        int spanEnd = editable.getSpanEnd(spellCheckSpan2);
                        if (i == -1 || i2 == -1) {
                            i3 = spanStart;
                            i4 = spanEnd;
                        } else {
                            int i7 = spanStart + i;
                            int i8 = i7 + i2;
                            i3 = i7;
                            i4 = i8;
                        }
                        spellCheckSpan = spellCheckSpan2;
                        if (spanStart >= 0) {
                            spellCheckSpan = spellCheckSpan2;
                            if (spanEnd > spanStart) {
                                spellCheckSpan = spellCheckSpan2;
                                if (i4 > i3) {
                                    Long valueOf = Long.valueOf(TextUtils.packRangeInLong(i3, i4));
                                    Object obj = (SuggestionSpan) this.mSuggestionSpanCache.get(valueOf);
                                    spellCheckSpan = spellCheckSpan2;
                                    if (obj != null) {
                                        editable.removeSpan(obj);
                                        this.mSuggestionSpanCache.remove(valueOf);
                                        return spellCheckSpan2;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    i5 = i6 + 1;
                }
            }
        }
        return spellCheckSpan;
    }

    private void resetSession() {
        closeSession();
        this.mTextServicesManager = (TextServicesManager) this.mTextView.getContext().getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        if (!this.mTextServicesManager.isSpellCheckerEnabled() || this.mCurrentLocale == null || this.mTextServicesManager.getCurrentSpellCheckerSubtype(true) == null) {
            this.mSpellCheckerSession = null;
        } else {
            this.mSpellCheckerSession = this.mTextServicesManager.newSpellCheckerSession(null, this.mCurrentLocale, this, false);
            this.mIsSentenceSpellCheckSupported = true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mLength) {
                this.mLength = 0;
                this.mTextView.removeMisspelledSpans((Editable) this.mTextView.getText());
                this.mSuggestionSpanCache.evictAll();
                return;
            }
            this.mIds[i2] = -1;
            i = i2 + 1;
        }
    }

    private void scheduleNewSpellCheck() {
        if (this.mSpellRunnable == null) {
            this.mSpellRunnable = new Runnable() { // from class: android.widget.SpellChecker.1
                @Override // java.lang.Runnable
                public void run() {
                    int length = SpellChecker.this.mSpellParsers.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return;
                        }
                        SpellParser spellParser = SpellChecker.this.mSpellParsers[i2];
                        if (!spellParser.isFinished()) {
                            spellParser.parse();
                            return;
                        }
                        i = i2 + 1;
                    }
                }
            };
        } else {
            this.mTextView.removeCallbacks(this.mSpellRunnable);
        }
        this.mTextView.postDelayed(this.mSpellRunnable, 400L);
    }

    private void setLocale(Locale locale) {
        this.mCurrentLocale = locale;
        resetSession();
        if (locale != null) {
            this.mWordIterator = new WordIterator(locale);
        }
        this.mTextView.onLocaleChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void spellCheck() {
        if (this.mSpellCheckerSession == null) {
            return;
        }
        Editable editable = (Editable) this.mTextView.getText();
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        TextInfo[] textInfoArr = new TextInfo[this.mLength];
        int i = 0;
        int i2 = 0;
        while (i2 < this.mLength) {
            SpellCheckSpan spellCheckSpan = this.mSpellCheckSpans[i2];
            int i3 = i;
            if (this.mIds[i2] >= 0) {
                if (spellCheckSpan.isSpellCheckInProgress()) {
                    i3 = i;
                } else {
                    int spanStart = editable.getSpanStart(spellCheckSpan);
                    int spanEnd = editable.getSpanEnd(spellCheckSpan);
                    boolean z = selectionStart == spanEnd + 1 && editable.charAt(spanEnd) == '\'';
                    boolean z2 = this.mIsSentenceSpellCheckSupported ? !z && (selectionEnd <= spanStart || selectionStart > spanEnd) : !z && (selectionEnd < spanStart || selectionStart > spanEnd);
                    i3 = i;
                    if (spanStart >= 0) {
                        i3 = i;
                        if (spanEnd > spanStart) {
                            i3 = i;
                            if (z2) {
                                spellCheckSpan.setSpellCheckInProgress(true);
                                textInfoArr[i] = new TextInfo(editable, spanStart, spanEnd, this.mCookie, this.mIds[i2]);
                                i3 = i + 1;
                            }
                        }
                    }
                }
            }
            i2++;
            i = i3;
        }
        if (i > 0) {
            TextInfo[] textInfoArr2 = textInfoArr;
            if (i < textInfoArr.length) {
                textInfoArr2 = new TextInfo[i];
                System.arraycopy(textInfoArr, 0, textInfoArr2, 0, i);
            }
            if (this.mIsSentenceSpellCheckSupported) {
                this.mSpellCheckerSession.getSentenceSuggestions(textInfoArr2, 5);
            } else {
                this.mSpellCheckerSession.getSuggestions(textInfoArr2, 5, false);
            }
        }
    }

    public void closeSession() {
        if (this.mSpellCheckerSession != null) {
            this.mSpellCheckerSession.close();
        }
        int length = this.mSpellParsers.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            this.mSpellParsers[i2].stop();
            i = i2 + 1;
        }
        if (this.mSpellRunnable != null) {
            this.mTextView.removeCallbacks(this.mSpellRunnable);
        }
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        SpellCheckSpan spellCheckSpan;
        Editable editable = (Editable) this.mTextView.getText();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sentenceSuggestionsInfoArr.length) {
                scheduleNewSpellCheck();
                return;
            }
            SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[i2];
            if (sentenceSuggestionsInfo != null) {
                SpellCheckSpan spellCheckSpan2 = null;
                int i3 = 0;
                while (i3 < sentenceSuggestionsInfo.getSuggestionsCount()) {
                    SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i3);
                    if (suggestionsInfoAt == null) {
                        spellCheckSpan = spellCheckSpan2;
                    } else {
                        SpellCheckSpan onGetSuggestionsInternal = onGetSuggestionsInternal(suggestionsInfoAt, sentenceSuggestionsInfo.getOffsetAt(i3), sentenceSuggestionsInfo.getLengthAt(i3));
                        spellCheckSpan = spellCheckSpan2;
                        if (spellCheckSpan2 == null) {
                            spellCheckSpan = spellCheckSpan2;
                            if (onGetSuggestionsInternal != null) {
                                spellCheckSpan = onGetSuggestionsInternal;
                            }
                        }
                    }
                    i3++;
                    spellCheckSpan2 = spellCheckSpan;
                }
                if (spellCheckSpan2 != null) {
                    editable.removeSpan(spellCheckSpan2);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
        Editable editable = (Editable) this.mTextView.getText();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= suggestionsInfoArr.length) {
                scheduleNewSpellCheck();
                return;
            }
            SpellCheckSpan onGetSuggestionsInternal = onGetSuggestionsInternal(suggestionsInfoArr[i2], -1, -1);
            if (onGetSuggestionsInternal != null) {
                editable.removeSpan(onGetSuggestionsInternal);
            }
            i = i2 + 1;
        }
    }

    public void onSelectionChanged() {
        spellCheck();
    }

    public void onSpellCheckSpanRemoved(SpellCheckSpan spellCheckSpan) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mLength) {
                return;
            }
            if (this.mSpellCheckSpans[i2] == spellCheckSpan) {
                this.mIds[i2] = -1;
                return;
            }
            i = i2 + 1;
        }
    }

    public void spellCheck(int i, int i2) {
        int i3;
        int length;
        Locale spellCheckerLocale = this.mTextView.getSpellCheckerLocale();
        boolean isSessionActive = isSessionActive();
        if (spellCheckerLocale == null || this.mCurrentLocale == null || !this.mCurrentLocale.equals(spellCheckerLocale)) {
            setLocale(spellCheckerLocale);
            i3 = 0;
            length = this.mTextView.getText().length();
        } else {
            i3 = i;
            length = i2;
            if (isSessionActive != this.mTextServicesManager.isSpellCheckerEnabled()) {
                resetSession();
                i3 = i;
                length = i2;
            }
        }
        if (!isSessionActive) {
            return;
        }
        int length2 = this.mSpellParsers.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length2) {
                SpellParser[] spellParserArr = new SpellParser[length2 + 1];
                System.arraycopy(this.mSpellParsers, 0, spellParserArr, 0, length2);
                this.mSpellParsers = spellParserArr;
                SpellParser spellParser = new SpellParser();
                this.mSpellParsers[length2] = spellParser;
                spellParser.parse(i3, length);
                return;
            }
            SpellParser spellParser2 = this.mSpellParsers[i5];
            if (spellParser2.isFinished()) {
                spellParser2.parse(i3, length);
                return;
            }
            i4 = i5 + 1;
        }
    }
}
