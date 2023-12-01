package android.view.textservice;

import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.textservice.ISpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import com.android.internal.textservice.ITextServicesManager;
import com.android.internal.textservice.ITextServicesSessionListener;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: source-4181928-dex2jar.jar:android/view/textservice/SpellCheckerSession.class */
public class SpellCheckerSession {
    private static final boolean DBG = false;
    private static final int MSG_ON_GET_SUGGESTION_MULTIPLE = 1;
    private static final int MSG_ON_GET_SUGGESTION_MULTIPLE_FOR_SENTENCE = 2;
    public static final String SERVICE_META_DATA = "android.view.textservice.scs";
    private static final String TAG = SpellCheckerSession.class.getSimpleName();
    private final Handler mHandler = new Handler() { // from class: android.view.textservice.SpellCheckerSession.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    SpellCheckerSession.this.handleOnGetSuggestionsMultiple((SuggestionsInfo[]) message.obj);
                    return;
                case 2:
                    SpellCheckerSession.this.handleOnGetSentenceSuggestionsMultiple((SentenceSuggestionsInfo[]) message.obj);
                    return;
                default:
                    return;
            }
        }
    };
    private final InternalListener mInternalListener;
    private boolean mIsUsed;
    private final SpellCheckerInfo mSpellCheckerInfo;
    private SpellCheckerSessionListener mSpellCheckerSessionListener;
    private final SpellCheckerSessionListenerImpl mSpellCheckerSessionListenerImpl;
    private final SpellCheckerSubtype mSubtype;
    private final ITextServicesManager mTextServicesManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/textservice/SpellCheckerSession$InternalListener.class */
    public static class InternalListener extends ITextServicesSessionListener.Stub {
        private final SpellCheckerSessionListenerImpl mParentSpellCheckerSessionListenerImpl;

        public InternalListener(SpellCheckerSessionListenerImpl spellCheckerSessionListenerImpl) {
            this.mParentSpellCheckerSessionListenerImpl = spellCheckerSessionListenerImpl;
        }

        @Override // com.android.internal.textservice.ITextServicesSessionListener
        public void onServiceConnected(ISpellCheckerSession iSpellCheckerSession) {
            this.mParentSpellCheckerSessionListenerImpl.onServiceConnected(iSpellCheckerSession);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/textservice/SpellCheckerSession$SpellCheckerSessionListener.class */
    public interface SpellCheckerSessionListener {
        void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr);

        void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/textservice/SpellCheckerSession$SpellCheckerSessionListenerImpl.class */
    public static class SpellCheckerSessionListenerImpl extends ISpellCheckerSessionListener.Stub {
        private static final int TASK_CANCEL = 1;
        private static final int TASK_CLOSE = 3;
        private static final int TASK_GET_SUGGESTIONS_MULTIPLE = 2;
        private static final int TASK_GET_SUGGESTIONS_MULTIPLE_FOR_SENTENCE = 4;
        private Handler mAsyncHandler;
        private Handler mHandler;
        private ISpellCheckerSession mISpellCheckerSession;
        private HandlerThread mThread;
        private final Queue<SpellCheckerParams> mPendingTasks = new LinkedList();
        private boolean mOpened = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-4181928-dex2jar.jar:android/view/textservice/SpellCheckerSession$SpellCheckerSessionListenerImpl$SpellCheckerParams.class */
        public static class SpellCheckerParams {
            public final boolean mSequentialWords;
            public ISpellCheckerSession mSession;
            public final int mSuggestionsLimit;
            public final TextInfo[] mTextInfos;
            public final int mWhat;

            public SpellCheckerParams(int i, TextInfo[] textInfoArr, int i2, boolean z) {
                this.mWhat = i;
                this.mTextInfos = textInfoArr;
                this.mSuggestionsLimit = i2;
                this.mSequentialWords = z;
            }
        }

        public SpellCheckerSessionListenerImpl(Handler handler) {
            this.mHandler = handler;
        }

        private void processOrEnqueueTask(SpellCheckerParams spellCheckerParams) {
            synchronized (this) {
                ISpellCheckerSession iSpellCheckerSession = this.mISpellCheckerSession;
                if (iSpellCheckerSession != null) {
                    processTask(iSpellCheckerSession, spellCheckerParams, false);
                    return;
                }
                SpellCheckerParams spellCheckerParams2 = null;
                SpellCheckerParams spellCheckerParams3 = null;
                if (spellCheckerParams.mWhat == 1) {
                    while (true) {
                        spellCheckerParams2 = spellCheckerParams3;
                        if (this.mPendingTasks.isEmpty()) {
                            break;
                        }
                        SpellCheckerParams poll = this.mPendingTasks.poll();
                        if (poll.mWhat == 3) {
                            spellCheckerParams3 = poll;
                        }
                    }
                }
                this.mPendingTasks.offer(spellCheckerParams);
                if (spellCheckerParams2 != null) {
                    this.mPendingTasks.offer(spellCheckerParams2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void processTask(ISpellCheckerSession iSpellCheckerSession, SpellCheckerParams spellCheckerParams, boolean z) {
            if (z || this.mAsyncHandler == null) {
                switch (spellCheckerParams.mWhat) {
                    case 1:
                        try {
                            iSpellCheckerSession.onCancel();
                            break;
                        } catch (RemoteException e) {
                            Log.e(SpellCheckerSession.TAG, "Failed to cancel " + e);
                            break;
                        }
                    case 2:
                        try {
                            iSpellCheckerSession.onGetSuggestionsMultiple(spellCheckerParams.mTextInfos, spellCheckerParams.mSuggestionsLimit, spellCheckerParams.mSequentialWords);
                            break;
                        } catch (RemoteException e2) {
                            Log.e(SpellCheckerSession.TAG, "Failed to get suggestions " + e2);
                            break;
                        }
                    case 3:
                        try {
                            iSpellCheckerSession.onClose();
                            break;
                        } catch (RemoteException e3) {
                            Log.e(SpellCheckerSession.TAG, "Failed to close " + e3);
                            break;
                        }
                    case 4:
                        try {
                            iSpellCheckerSession.onGetSentenceSuggestionsMultiple(spellCheckerParams.mTextInfos, spellCheckerParams.mSuggestionsLimit);
                            break;
                        } catch (RemoteException e4) {
                            Log.e(SpellCheckerSession.TAG, "Failed to get suggestions " + e4);
                            break;
                        }
                }
            } else {
                spellCheckerParams.mSession = iSpellCheckerSession;
                this.mAsyncHandler.sendMessage(Message.obtain(this.mAsyncHandler, 1, spellCheckerParams));
            }
            if (spellCheckerParams.mWhat == 3) {
                synchronized (this) {
                    this.mISpellCheckerSession = null;
                    this.mHandler = null;
                    if (this.mThread != null) {
                        this.mThread.quit();
                    }
                    this.mThread = null;
                    this.mAsyncHandler = null;
                }
            }
        }

        public void cancel() {
            processOrEnqueueTask(new SpellCheckerParams(1, null, 0, false));
        }

        public void close() {
            processOrEnqueueTask(new SpellCheckerParams(3, null, 0, false));
        }

        public void getSentenceSuggestionsMultiple(TextInfo[] textInfoArr, int i) {
            processOrEnqueueTask(new SpellCheckerParams(4, textInfoArr, i, false));
        }

        public void getSuggestionsMultiple(TextInfo[] textInfoArr, int i, boolean z) {
            processOrEnqueueTask(new SpellCheckerParams(2, textInfoArr, i, z));
        }

        public boolean isDisconnected() {
            return this.mOpened && this.mISpellCheckerSession == null;
        }

        @Override // com.android.internal.textservice.ISpellCheckerSessionListener
        public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
            synchronized (this) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(Message.obtain(this.mHandler, 2, sentenceSuggestionsInfoArr));
                }
            }
        }

        @Override // com.android.internal.textservice.ISpellCheckerSessionListener
        public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
            synchronized (this) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(Message.obtain(this.mHandler, 1, suggestionsInfoArr));
                }
            }
        }

        public void onServiceConnected(ISpellCheckerSession iSpellCheckerSession) {
            synchronized (this) {
                synchronized (this) {
                    this.mISpellCheckerSession = iSpellCheckerSession;
                    if ((iSpellCheckerSession.asBinder() instanceof Binder) && this.mThread == null) {
                        this.mThread = new HandlerThread("SpellCheckerSession", 10);
                        this.mThread.start();
                        this.mAsyncHandler = new Handler(this.mThread.getLooper()) { // from class: android.view.textservice.SpellCheckerSession.SpellCheckerSessionListenerImpl.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                SpellCheckerParams spellCheckerParams = (SpellCheckerParams) message.obj;
                                SpellCheckerSessionListenerImpl.this.processTask(spellCheckerParams.mSession, spellCheckerParams, true);
                            }
                        };
                    }
                    this.mOpened = true;
                }
            }
            while (!this.mPendingTasks.isEmpty()) {
                processTask(iSpellCheckerSession, this.mPendingTasks.poll(), false);
            }
        }
    }

    public SpellCheckerSession(SpellCheckerInfo spellCheckerInfo, ITextServicesManager iTextServicesManager, SpellCheckerSessionListener spellCheckerSessionListener, SpellCheckerSubtype spellCheckerSubtype) {
        if (spellCheckerInfo == null || spellCheckerSessionListener == null || iTextServicesManager == null) {
            throw new NullPointerException();
        }
        this.mSpellCheckerInfo = spellCheckerInfo;
        this.mSpellCheckerSessionListenerImpl = new SpellCheckerSessionListenerImpl(this.mHandler);
        this.mInternalListener = new InternalListener(this.mSpellCheckerSessionListenerImpl);
        this.mTextServicesManager = iTextServicesManager;
        this.mIsUsed = true;
        this.mSpellCheckerSessionListener = spellCheckerSessionListener;
        this.mSubtype = spellCheckerSubtype;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnGetSentenceSuggestionsMultiple(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        this.mSpellCheckerSessionListener.onGetSentenceSuggestions(sentenceSuggestionsInfoArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnGetSuggestionsMultiple(SuggestionsInfo[] suggestionsInfoArr) {
        this.mSpellCheckerSessionListener.onGetSuggestions(suggestionsInfoArr);
    }

    public void cancel() {
        this.mSpellCheckerSessionListenerImpl.cancel();
    }

    public void close() {
        this.mIsUsed = false;
        try {
            this.mSpellCheckerSessionListenerImpl.close();
            this.mTextServicesManager.finishSpellCheckerService(this.mSpellCheckerSessionListenerImpl);
        } catch (RemoteException e) {
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mIsUsed) {
            Log.e(TAG, "SpellCheckerSession was not finished properly.You should call finishShession() when you finished to use a spell checker.");
            close();
        }
    }

    public void getSentenceSuggestions(TextInfo[] textInfoArr, int i) {
        this.mSpellCheckerSessionListenerImpl.getSentenceSuggestionsMultiple(textInfoArr, i);
    }

    public SpellCheckerInfo getSpellChecker() {
        return this.mSpellCheckerInfo;
    }

    public ISpellCheckerSessionListener getSpellCheckerSessionListener() {
        return this.mSpellCheckerSessionListenerImpl;
    }

    @Deprecated
    public void getSuggestions(TextInfo textInfo, int i) {
        getSuggestions(new TextInfo[]{textInfo}, i, false);
    }

    @Deprecated
    public void getSuggestions(TextInfo[] textInfoArr, int i, boolean z) {
        this.mSpellCheckerSessionListenerImpl.getSuggestionsMultiple(textInfoArr, i, z);
    }

    public ITextServicesSessionListener getTextServicesSessionListener() {
        return this.mInternalListener;
    }

    public boolean isSessionDisconnected() {
        return this.mSpellCheckerSessionListenerImpl.isDisconnected();
    }
}
