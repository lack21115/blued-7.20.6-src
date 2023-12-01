package android.service.textservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.text.method.WordIterator;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import com.android.internal.textservice.ISpellCheckerService;
import com.android.internal.textservice.ISpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/service/textservice/SpellCheckerService.class */
public abstract class SpellCheckerService extends Service {
    private static final boolean DBG = false;
    public static final String SERVICE_INTERFACE = "android.service.textservice.SpellCheckerService";
    private static final String TAG = SpellCheckerService.class.getSimpleName();
    private final SpellCheckerServiceBinder mBinder = new SpellCheckerServiceBinder(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/textservice/SpellCheckerService$InternalISpellCheckerSession.class */
    public static class InternalISpellCheckerSession extends ISpellCheckerSession.Stub {
        private final Bundle mBundle;
        private ISpellCheckerSessionListener mListener;
        private final String mLocale;
        private final Session mSession;

        public InternalISpellCheckerSession(String str, ISpellCheckerSessionListener iSpellCheckerSessionListener, Bundle bundle, Session session) {
            this.mListener = iSpellCheckerSessionListener;
            this.mSession = session;
            this.mLocale = str;
            this.mBundle = bundle;
            session.setInternalISpellCheckerSession(this);
        }

        public Bundle getBundle() {
            return this.mBundle;
        }

        public String getLocale() {
            return this.mLocale;
        }

        public void onCancel() {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            try {
                Process.setThreadPriority(10);
                this.mSession.onCancel();
            } finally {
                Process.setThreadPriority(threadPriority);
            }
        }

        public void onClose() {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            try {
                Process.setThreadPriority(10);
                this.mSession.onClose();
            } finally {
                Process.setThreadPriority(threadPriority);
                this.mListener = null;
            }
        }

        public void onGetSentenceSuggestionsMultiple(TextInfo[] textInfoArr, int i) {
            try {
                this.mListener.onGetSentenceSuggestions(this.mSession.onGetSentenceSuggestionsMultiple(textInfoArr, i));
            } catch (RemoteException e) {
            }
        }

        public void onGetSuggestionsMultiple(TextInfo[] textInfoArr, int i, boolean z) {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            try {
                Process.setThreadPriority(10);
                this.mListener.onGetSuggestions(this.mSession.onGetSuggestionsMultiple(textInfoArr, i, z));
            } catch (RemoteException e) {
            } finally {
                Process.setThreadPriority(threadPriority);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/textservice/SpellCheckerService$SentenceLevelAdapter.class */
    public static class SentenceLevelAdapter {
        public static final SentenceSuggestionsInfo[] EMPTY_SENTENCE_SUGGESTIONS_INFOS = new SentenceSuggestionsInfo[0];
        private static final SuggestionsInfo EMPTY_SUGGESTIONS_INFO = new SuggestionsInfo(0, null);
        private final WordIterator mWordIterator;

        /* loaded from: source-9557208-dex2jar.jar:android/service/textservice/SpellCheckerService$SentenceLevelAdapter$SentenceTextInfoParams.class */
        public static class SentenceTextInfoParams {
            final ArrayList<SentenceWordItem> mItems;
            final TextInfo mOriginalTextInfo;
            final int mSize;

            public SentenceTextInfoParams(TextInfo textInfo, ArrayList<SentenceWordItem> arrayList) {
                this.mOriginalTextInfo = textInfo;
                this.mItems = arrayList;
                this.mSize = arrayList.size();
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/service/textservice/SpellCheckerService$SentenceLevelAdapter$SentenceWordItem.class */
        public static class SentenceWordItem {
            public final int mLength;
            public final int mStart;
            public final TextInfo mTextInfo;

            public SentenceWordItem(TextInfo textInfo, int i, int i2) {
                this.mTextInfo = textInfo;
                this.mStart = i;
                this.mLength = i2 - i;
            }
        }

        public SentenceLevelAdapter(Locale locale) {
            this.mWordIterator = new WordIterator(locale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SentenceTextInfoParams getSplitWords(TextInfo textInfo) {
            WordIterator wordIterator = this.mWordIterator;
            String text = textInfo.getText();
            int cookie = textInfo.getCookie();
            int length = text.length();
            ArrayList arrayList = new ArrayList();
            wordIterator.setCharSequence(text, 0, text.length());
            int following = wordIterator.following(0);
            int beginning = wordIterator.getBeginning(following);
            while (true) {
                int i = beginning;
                if (i > length || following == -1 || i == -1) {
                    break;
                }
                if (following >= 0 && following > i) {
                    CharSequence subSequence = text.subSequence(i, following);
                    arrayList.add(new SentenceWordItem(new TextInfo(subSequence, 0, subSequence.length(), cookie, subSequence.hashCode()), i, following));
                }
                following = wordIterator.following(following);
                if (following == -1) {
                    break;
                }
                beginning = wordIterator.getBeginning(following);
            }
            return new SentenceTextInfoParams(textInfo, arrayList);
        }

        public static SentenceSuggestionsInfo reconstructSuggestions(SentenceTextInfoParams sentenceTextInfoParams, SuggestionsInfo[] suggestionsInfoArr) {
            SuggestionsInfo suggestionsInfo;
            if (suggestionsInfoArr == null || suggestionsInfoArr.length == 0 || sentenceTextInfoParams == null) {
                return null;
            }
            int cookie = sentenceTextInfoParams.mOriginalTextInfo.getCookie();
            int sequence = sentenceTextInfoParams.mOriginalTextInfo.getSequence();
            int i = sentenceTextInfoParams.mSize;
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            SuggestionsInfo[] suggestionsInfoArr2 = new SuggestionsInfo[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return new SentenceSuggestionsInfo(suggestionsInfoArr2, iArr, iArr2);
                }
                SentenceWordItem sentenceWordItem = sentenceTextInfoParams.mItems.get(i3);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    suggestionsInfo = null;
                    if (i5 >= suggestionsInfoArr.length) {
                        break;
                    }
                    suggestionsInfo = suggestionsInfoArr[i5];
                    if (suggestionsInfo != null && suggestionsInfo.getSequence() == sentenceWordItem.mTextInfo.getSequence()) {
                        suggestionsInfo.setCookieAndSequence(cookie, sequence);
                        break;
                    }
                    i4 = i5 + 1;
                }
                iArr[i3] = sentenceWordItem.mStart;
                iArr2[i3] = sentenceWordItem.mLength;
                if (suggestionsInfo == null) {
                    suggestionsInfo = EMPTY_SUGGESTIONS_INFO;
                }
                suggestionsInfoArr2[i3] = suggestionsInfo;
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/textservice/SpellCheckerService$Session.class */
    public static abstract class Session {
        private InternalISpellCheckerSession mInternalSession;
        private volatile SentenceLevelAdapter mSentenceLevelAdapter;

        public Bundle getBundle() {
            return this.mInternalSession.getBundle();
        }

        public String getLocale() {
            return this.mInternalSession.getLocale();
        }

        public void onCancel() {
        }

        public void onClose() {
        }

        public abstract void onCreate();

        public SentenceSuggestionsInfo[] onGetSentenceSuggestionsMultiple(TextInfo[] textInfoArr, int i) {
            SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr;
            if (textInfoArr != null && textInfoArr.length != 0) {
                if (this.mSentenceLevelAdapter == null) {
                    synchronized (this) {
                        if (this.mSentenceLevelAdapter == null) {
                            String locale = getLocale();
                            if (!TextUtils.isEmpty(locale)) {
                                this.mSentenceLevelAdapter = new SentenceLevelAdapter(new Locale(locale));
                            }
                        }
                    }
                }
                if (this.mSentenceLevelAdapter != null) {
                    int length = textInfoArr.length;
                    SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr2 = new SentenceSuggestionsInfo[length];
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        sentenceSuggestionsInfoArr = sentenceSuggestionsInfoArr2;
                        if (i3 >= length) {
                            break;
                        }
                        SentenceLevelAdapter.SentenceTextInfoParams splitWords = this.mSentenceLevelAdapter.getSplitWords(textInfoArr[i3]);
                        ArrayList<SentenceLevelAdapter.SentenceWordItem> arrayList = splitWords.mItems;
                        int size = arrayList.size();
                        TextInfo[] textInfoArr2 = new TextInfo[size];
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 < size) {
                                textInfoArr2[i5] = arrayList.get(i5).mTextInfo;
                                i4 = i5 + 1;
                            }
                        }
                        sentenceSuggestionsInfoArr2[i3] = SentenceLevelAdapter.reconstructSuggestions(splitWords, onGetSuggestionsMultiple(textInfoArr2, i, true));
                        i2 = i3 + 1;
                    }
                } else {
                    return SentenceLevelAdapter.EMPTY_SENTENCE_SUGGESTIONS_INFOS;
                }
            } else {
                sentenceSuggestionsInfoArr = SentenceLevelAdapter.EMPTY_SENTENCE_SUGGESTIONS_INFOS;
            }
            return sentenceSuggestionsInfoArr;
        }

        public abstract SuggestionsInfo onGetSuggestions(TextInfo textInfo, int i);

        public SuggestionsInfo[] onGetSuggestionsMultiple(TextInfo[] textInfoArr, int i, boolean z) {
            int length = textInfoArr.length;
            SuggestionsInfo[] suggestionsInfoArr = new SuggestionsInfo[length];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return suggestionsInfoArr;
                }
                suggestionsInfoArr[i3] = onGetSuggestions(textInfoArr[i3], i);
                suggestionsInfoArr[i3].setCookieAndSequence(textInfoArr[i3].getCookie(), textInfoArr[i3].getSequence());
                i2 = i3 + 1;
            }
        }

        public final void setInternalISpellCheckerSession(InternalISpellCheckerSession internalISpellCheckerSession) {
            this.mInternalSession = internalISpellCheckerSession;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/textservice/SpellCheckerService$SpellCheckerServiceBinder.class */
    private static class SpellCheckerServiceBinder extends ISpellCheckerService.Stub {
        private final WeakReference<SpellCheckerService> mInternalServiceRef;

        public SpellCheckerServiceBinder(SpellCheckerService spellCheckerService) {
            this.mInternalServiceRef = new WeakReference<>(spellCheckerService);
        }

        public ISpellCheckerSession getISpellCheckerSession(String str, ISpellCheckerSessionListener iSpellCheckerSessionListener, Bundle bundle) {
            SpellCheckerService spellCheckerService = this.mInternalServiceRef.get();
            if (spellCheckerService == null) {
                return null;
            }
            Session createSession = spellCheckerService.createSession();
            InternalISpellCheckerSession internalISpellCheckerSession = new InternalISpellCheckerSession(str, iSpellCheckerSessionListener, bundle, createSession);
            createSession.onCreate();
            return internalISpellCheckerSession;
        }
    }

    public abstract Session createSession();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
