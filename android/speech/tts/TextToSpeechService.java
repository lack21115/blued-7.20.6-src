package android.speech.tts;

import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.provider.Settings;
import android.speech.tts.ITextToSpeechService;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService.class */
public abstract class TextToSpeechService extends Service {
    private static final boolean DBG = false;
    private static final String SYNTH_THREAD_NAME = "SynthThread";
    private static final String TAG = "TextToSpeechService";
    private AudioPlaybackHandler mAudioPlaybackHandler;
    private CallbackMap mCallbacks;
    private TtsEngines mEngineHelper;
    private String mPackageName;
    private SynthHandler mSynthHandler;
    private final Object mVoicesInfoLock = new Object();
    private final ITextToSpeechService.Stub mBinder = new ITextToSpeechService.Stub() { // from class: android.speech.tts.TextToSpeechService.1
        private boolean checkNonNull(Object... objArr) {
            int length = objArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return true;
                }
                if (objArr[i2] == null) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        private String intern(String str) {
            return str.intern();
        }

        @Override // android.speech.tts.ITextToSpeechService
        public String[] getClientDefaultLanguage() {
            return TextToSpeechService.this.getSettingsLocale();
        }

        @Override // android.speech.tts.ITextToSpeechService
        public String getDefaultVoiceNameFor(String str, String str2, String str3) {
            if (checkNonNull(str)) {
                int onIsLanguageAvailable = TextToSpeechService.this.onIsLanguageAvailable(str, str2, str3);
                if (onIsLanguageAvailable == 0 || onIsLanguageAvailable == 1 || onIsLanguageAvailable == 2) {
                    return TextToSpeechService.this.onGetDefaultVoiceNameFor(str, str2, str3);
                }
                return null;
            }
            return null;
        }

        @Override // android.speech.tts.ITextToSpeechService
        public String[] getFeaturesForLanguage(String str, String str2, String str3) {
            Set<String> onGetFeaturesForLanguage = TextToSpeechService.this.onGetFeaturesForLanguage(str, str2, str3);
            if (onGetFeaturesForLanguage != null) {
                String[] strArr = new String[onGetFeaturesForLanguage.size()];
                onGetFeaturesForLanguage.toArray(strArr);
                return strArr;
            }
            return new String[0];
        }

        @Override // android.speech.tts.ITextToSpeechService
        public String[] getLanguage() {
            return TextToSpeechService.this.onGetLanguage();
        }

        @Override // android.speech.tts.ITextToSpeechService
        public List<Voice> getVoices() {
            return TextToSpeechService.this.onGetVoices();
        }

        @Override // android.speech.tts.ITextToSpeechService
        public int isLanguageAvailable(String str, String str2, String str3) {
            if (checkNonNull(str)) {
                return TextToSpeechService.this.onIsLanguageAvailable(str, str2, str3);
            }
            return -1;
        }

        @Override // android.speech.tts.ITextToSpeechService
        public boolean isSpeaking() {
            return TextToSpeechService.this.mSynthHandler.isSpeaking() || TextToSpeechService.this.mAudioPlaybackHandler.isSpeaking();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
            if (r0 == 2) goto L13;
         */
        @Override // android.speech.tts.ITextToSpeechService
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int loadLanguage(android.os.IBinder r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
            /*
                r10 = this;
                r0 = r10
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = r1
                r3 = 0
                r4 = r12
                r2[r3] = r4
                boolean r0 = r0.checkNonNull(r1)
                if (r0 != 0) goto L15
                r0 = -1
                r15 = r0
            L12:
                r0 = r15
                return r0
            L15:
                r0 = r10
                android.speech.tts.TextToSpeechService r0 = android.speech.tts.TextToSpeechService.this
                r1 = r12
                r2 = r13
                r3 = r14
                int r0 = r0.onIsLanguageAvailable(r1, r2, r3)
                r16 = r0
                r0 = r16
                if (r0 == 0) goto L37
                r0 = r16
                r1 = 1
                if (r0 == r1) goto L37
                r0 = r16
                r15 = r0
                r0 = r16
                r1 = 2
                if (r0 != r1) goto L12
            L37:
                android.speech.tts.TextToSpeechService$LoadLanguageItem r0 = new android.speech.tts.TextToSpeechService$LoadLanguageItem
                r1 = r0
                r2 = r10
                android.speech.tts.TextToSpeechService r2 = android.speech.tts.TextToSpeechService.this
                r3 = r11
                int r4 = android.os.Binder.getCallingUid()
                int r5 = android.os.Binder.getCallingPid()
                r6 = r12
                r7 = r13
                r8 = r14
                r1.<init>(r3, r4, r5, r6, r7, r8)
                r11 = r0
                r0 = r16
                r15 = r0
                r0 = r10
                android.speech.tts.TextToSpeechService r0 = android.speech.tts.TextToSpeechService.this
                android.speech.tts.TextToSpeechService$SynthHandler r0 = android.speech.tts.TextToSpeechService.access$700(r0)
                r1 = 1
                r2 = r11
                int r0 = r0.enqueueSpeechItem(r1, r2)
                if (r0 == 0) goto L12
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.speech.tts.TextToSpeechService.AnonymousClass1.loadLanguage(android.os.IBinder, java.lang.String, java.lang.String, java.lang.String):int");
        }

        @Override // android.speech.tts.ITextToSpeechService
        public int loadVoice(IBinder iBinder, String str) {
            int i;
            if (checkNonNull(str)) {
                int onIsValidVoiceName = TextToSpeechService.this.onIsValidVoiceName(str);
                i = onIsValidVoiceName;
                if (onIsValidVoiceName == 0) {
                    i = onIsValidVoiceName;
                    if (TextToSpeechService.this.mSynthHandler.enqueueSpeechItem(1, new LoadVoiceItem(iBinder, Binder.getCallingUid(), Binder.getCallingPid(), str)) != 0) {
                        return -1;
                    }
                }
            } else {
                i = -1;
            }
            return i;
        }

        @Override // android.speech.tts.ITextToSpeechService
        public int playAudio(IBinder iBinder, Uri uri, int i, Bundle bundle, String str) {
            if (checkNonNull(iBinder, uri, bundle)) {
                return TextToSpeechService.this.mSynthHandler.enqueueSpeechItem(i, new AudioSpeechItemV1(iBinder, Binder.getCallingUid(), Binder.getCallingPid(), bundle, str, uri));
            }
            return -1;
        }

        @Override // android.speech.tts.ITextToSpeechService
        public int playSilence(IBinder iBinder, long j, int i, String str) {
            if (checkNonNull(iBinder)) {
                return TextToSpeechService.this.mSynthHandler.enqueueSpeechItem(i, new SilenceSpeechItem(iBinder, Binder.getCallingUid(), Binder.getCallingPid(), str, j));
            }
            return -1;
        }

        @Override // android.speech.tts.ITextToSpeechService
        public void setCallback(IBinder iBinder, ITextToSpeechCallback iTextToSpeechCallback) {
            if (checkNonNull(iBinder)) {
                TextToSpeechService.this.mCallbacks.setCallback(iBinder, iTextToSpeechCallback);
            }
        }

        @Override // android.speech.tts.ITextToSpeechService
        public int speak(IBinder iBinder, CharSequence charSequence, int i, Bundle bundle, String str) {
            if (checkNonNull(iBinder, charSequence, bundle)) {
                return TextToSpeechService.this.mSynthHandler.enqueueSpeechItem(i, new SynthesisSpeechItemV1(iBinder, Binder.getCallingUid(), Binder.getCallingPid(), bundle, str, charSequence));
            }
            return -1;
        }

        @Override // android.speech.tts.ITextToSpeechService
        public int stop(IBinder iBinder) {
            if (checkNonNull(iBinder)) {
                return TextToSpeechService.this.mSynthHandler.stopForApp(iBinder);
            }
            return -1;
        }

        @Override // android.speech.tts.ITextToSpeechService
        public int synthesizeToFileDescriptor(IBinder iBinder, CharSequence charSequence, ParcelFileDescriptor parcelFileDescriptor, Bundle bundle, String str) {
            if (checkNonNull(iBinder, charSequence, parcelFileDescriptor, bundle)) {
                return TextToSpeechService.this.mSynthHandler.enqueueSpeechItem(1, new SynthesisToFileOutputStreamSpeechItemV1(iBinder, Binder.getCallingUid(), Binder.getCallingPid(), bundle, str, charSequence, new ParcelFileDescriptor.AutoCloseOutputStream(ParcelFileDescriptor.adoptFd(parcelFileDescriptor.detachFd()))));
            }
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$AudioOutputParams.class */
    public static class AudioOutputParams {
        public final AudioAttributes mAudioAttributes;
        public final float mPan;
        public final int mSessionId;
        public final float mVolume;

        AudioOutputParams() {
            this.mSessionId = 0;
            this.mVolume = 1.0f;
            this.mPan = 0.0f;
            this.mAudioAttributes = null;
        }

        AudioOutputParams(int i, float f, float f2, AudioAttributes audioAttributes) {
            this.mSessionId = i;
            this.mVolume = f;
            this.mPan = f2;
            this.mAudioAttributes = audioAttributes;
        }

        static AudioOutputParams createFromV1ParamsBundle(Bundle bundle, boolean z) {
            if (bundle == null) {
                return new AudioOutputParams();
            }
            AudioAttributes audioAttributes = (AudioAttributes) bundle.getParcelable(TextToSpeech.Engine.KEY_PARAM_AUDIO_ATTRIBUTES);
            AudioAttributes audioAttributes2 = audioAttributes;
            if (audioAttributes == null) {
                audioAttributes2 = new AudioAttributes.Builder().setLegacyStreamType(bundle.getInt(TextToSpeech.Engine.KEY_PARAM_STREAM, 3)).setContentType(z ? 1 : 4).build();
            }
            return new AudioOutputParams(bundle.getInt(TextToSpeech.Engine.KEY_PARAM_SESSION_ID, 0), bundle.getFloat("volume", 1.0f), bundle.getFloat(TextToSpeech.Engine.KEY_PARAM_PAN, 0.0f), audioAttributes2);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$AudioSpeechItemV1.class */
    private class AudioSpeechItemV1 extends SpeechItemV1 {
        private final AudioPlaybackQueueItem mItem;

        public AudioSpeechItemV1(Object obj, int i, int i2, Bundle bundle, String str, Uri uri) {
            super(obj, i, i2, bundle, str);
            this.mItem = new AudioPlaybackQueueItem(this, getCallerIdentity(), TextToSpeechService.this, uri, getAudioParams());
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItemV1
        AudioOutputParams getAudioParams() {
            return AudioOutputParams.createFromV1ParamsBundle(this.mParams, false);
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItemV1, android.speech.tts.TextToSpeechService.UtteranceSpeechItem
        public String getUtteranceId() {
            return getStringParam(this.mParams, TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, null);
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        public boolean isValid() {
            return true;
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void playImpl() {
            TextToSpeechService.this.mAudioPlaybackHandler.enqueue(this.mItem);
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void stopImpl() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$CallbackMap.class */
    public class CallbackMap extends RemoteCallbackList<ITextToSpeechCallback> {
        private final HashMap<IBinder, ITextToSpeechCallback> mCallerToCallback;

        private CallbackMap() {
            this.mCallerToCallback = new HashMap<>();
        }

        private ITextToSpeechCallback getCallbackFor(Object obj) {
            ITextToSpeechCallback iTextToSpeechCallback;
            IBinder iBinder = (IBinder) obj;
            synchronized (this.mCallerToCallback) {
                iTextToSpeechCallback = this.mCallerToCallback.get(iBinder);
            }
            return iTextToSpeechCallback;
        }

        public void dispatchOnError(Object obj, String str, int i) {
            ITextToSpeechCallback callbackFor = getCallbackFor(obj);
            if (callbackFor == null) {
                return;
            }
            try {
                callbackFor.onError(str, i);
            } catch (RemoteException e) {
                Log.e(TextToSpeechService.TAG, "Callback onError failed: " + e);
            }
        }

        public void dispatchOnStart(Object obj, String str) {
            ITextToSpeechCallback callbackFor = getCallbackFor(obj);
            if (callbackFor == null) {
                return;
            }
            try {
                callbackFor.onStart(str);
            } catch (RemoteException e) {
                Log.e(TextToSpeechService.TAG, "Callback onStart failed: " + e);
            }
        }

        public void dispatchOnStop(Object obj, String str) {
            ITextToSpeechCallback callbackFor = getCallbackFor(obj);
            if (callbackFor == null) {
                return;
            }
            try {
                callbackFor.onStop(str);
            } catch (RemoteException e) {
                Log.e(TextToSpeechService.TAG, "Callback onStop failed: " + e);
            }
        }

        public void dispatchOnSuccess(Object obj, String str) {
            ITextToSpeechCallback callbackFor = getCallbackFor(obj);
            if (callbackFor == null) {
                return;
            }
            try {
                callbackFor.onSuccess(str);
            } catch (RemoteException e) {
                Log.e(TextToSpeechService.TAG, "Callback onDone failed: " + e);
            }
        }

        @Override // android.os.RemoteCallbackList
        public void kill() {
            synchronized (this.mCallerToCallback) {
                this.mCallerToCallback.clear();
                super.kill();
            }
        }

        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(ITextToSpeechCallback iTextToSpeechCallback, Object obj) {
            IBinder iBinder = (IBinder) obj;
            synchronized (this.mCallerToCallback) {
                this.mCallerToCallback.remove(iBinder);
            }
        }

        public void setCallback(IBinder iBinder, ITextToSpeechCallback iTextToSpeechCallback) {
            ITextToSpeechCallback remove;
            synchronized (this.mCallerToCallback) {
                if (iTextToSpeechCallback != null) {
                    register(iTextToSpeechCallback, iBinder);
                    remove = this.mCallerToCallback.put(iBinder, iTextToSpeechCallback);
                } else {
                    remove = this.mCallerToCallback.remove(iBinder);
                }
                if (remove != null && remove != iTextToSpeechCallback) {
                    unregister(remove);
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$LoadLanguageItem.class */
    private class LoadLanguageItem extends SpeechItem {
        private final String mCountry;
        private final String mLanguage;
        private final String mVariant;

        public LoadLanguageItem(Object obj, int i, int i2, String str, String str2, String str3) {
            super(obj, i, i2);
            this.mLanguage = str;
            this.mCountry = str2;
            this.mVariant = str3;
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        public boolean isValid() {
            return true;
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void playImpl() {
            TextToSpeechService.this.onLoadLanguage(this.mLanguage, this.mCountry, this.mVariant);
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void stopImpl() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$LoadVoiceItem.class */
    private class LoadVoiceItem extends SpeechItem {
        private final String mVoiceName;

        public LoadVoiceItem(Object obj, int i, int i2, String str) {
            super(obj, i, i2);
            this.mVoiceName = str;
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        public boolean isValid() {
            return true;
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void playImpl() {
            TextToSpeechService.this.onLoadVoice(this.mVoiceName);
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void stopImpl() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$SilenceSpeechItem.class */
    private class SilenceSpeechItem extends UtteranceSpeechItem {
        private final long mDuration;
        private final String mUtteranceId;

        public SilenceSpeechItem(Object obj, int i, int i2, String str, long j) {
            super(obj, i, i2);
            this.mUtteranceId = str;
            this.mDuration = j;
        }

        @Override // android.speech.tts.TextToSpeechService.UtteranceSpeechItem
        public String getUtteranceId() {
            return this.mUtteranceId;
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        public boolean isValid() {
            return true;
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void playImpl() {
            TextToSpeechService.this.mAudioPlaybackHandler.enqueue(new SilencePlaybackQueueItem(this, getCallerIdentity(), this.mDuration));
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void stopImpl() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$SpeechItem.class */
    public abstract class SpeechItem {
        private final Object mCallerIdentity;
        private final int mCallerPid;
        private final int mCallerUid;
        private boolean mStarted = false;
        private boolean mStopped = false;

        public SpeechItem(Object obj, int i, int i2) {
            this.mCallerIdentity = obj;
            this.mCallerUid = i;
            this.mCallerPid = i2;
        }

        public Object getCallerIdentity() {
            return this.mCallerIdentity;
        }

        public int getCallerPid() {
            return this.mCallerPid;
        }

        public int getCallerUid() {
            return this.mCallerUid;
        }

        protected boolean isStopped() {
            boolean z;
            synchronized (this) {
                z = this.mStopped;
            }
            return z;
        }

        public abstract boolean isValid();

        public void play() {
            synchronized (this) {
                if (this.mStarted) {
                    throw new IllegalStateException("play() called twice");
                }
                this.mStarted = true;
            }
            playImpl();
        }

        protected abstract void playImpl();

        public void stop() {
            synchronized (this) {
                if (this.mStopped) {
                    throw new IllegalStateException("stop() called twice");
                }
                this.mStopped = true;
            }
            stopImpl();
        }

        protected abstract void stopImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$SpeechItemV1.class */
    public abstract class SpeechItemV1 extends UtteranceSpeechItem {
        protected final Bundle mParams;
        protected final String mUtteranceId;

        SpeechItemV1(Object obj, int i, int i2, Bundle bundle, String str) {
            super(obj, i, i2);
            this.mParams = bundle;
            this.mUtteranceId = str;
        }

        AudioOutputParams getAudioParams() {
            return AudioOutputParams.createFromV1ParamsBundle(this.mParams, true);
        }

        int getPitch() {
            return getIntParam(this.mParams, TextToSpeech.Engine.KEY_PARAM_PITCH, 100);
        }

        int getSpeechRate() {
            return getIntParam(this.mParams, TextToSpeech.Engine.KEY_PARAM_RATE, TextToSpeechService.this.getDefaultSpeechRate());
        }

        @Override // android.speech.tts.TextToSpeechService.UtteranceSpeechItem
        public String getUtteranceId() {
            return this.mUtteranceId;
        }

        boolean hasLanguage() {
            return !TextUtils.isEmpty(getStringParam(this.mParams, "language", null));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$SynthHandler.class */
    private class SynthHandler extends Handler {
        private SpeechItem mCurrentSpeechItem;

        public SynthHandler(Looper looper) {
            super(looper);
            this.mCurrentSpeechItem = null;
        }

        private SpeechItem getCurrentSpeechItem() {
            SpeechItem speechItem;
            synchronized (this) {
                speechItem = this.mCurrentSpeechItem;
            }
            return speechItem;
        }

        private SpeechItem maybeRemoveCurrentSpeechItem(Object obj) {
            SpeechItem speechItem;
            synchronized (this) {
                speechItem = null;
                if (this.mCurrentSpeechItem != null) {
                    speechItem = null;
                    if (this.mCurrentSpeechItem.getCallerIdentity() == obj) {
                        speechItem = this.mCurrentSpeechItem;
                        this.mCurrentSpeechItem = null;
                    }
                }
            }
            return speechItem;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SpeechItem setCurrentSpeechItem(SpeechItem speechItem) {
            SpeechItem speechItem2;
            synchronized (this) {
                speechItem2 = this.mCurrentSpeechItem;
                this.mCurrentSpeechItem = speechItem;
            }
            return speechItem2;
        }

        public int enqueueSpeechItem(int i, final SpeechItem speechItem) {
            UtteranceProgressDispatcher utteranceProgressDispatcher = null;
            if (speechItem instanceof UtteranceProgressDispatcher) {
                utteranceProgressDispatcher = (UtteranceProgressDispatcher) speechItem;
            }
            if (!speechItem.isValid()) {
                if (utteranceProgressDispatcher != null) {
                    utteranceProgressDispatcher.dispatchOnError(-8);
                    return -1;
                }
                return -1;
            }
            if (i == 0) {
                stopForApp(speechItem.getCallerIdentity());
            } else if (i == 2) {
                stopAll();
            }
            Message obtain = Message.obtain(this, new Runnable() { // from class: android.speech.tts.TextToSpeechService.SynthHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    SynthHandler.this.setCurrentSpeechItem(speechItem);
                    speechItem.play();
                    SynthHandler.this.setCurrentSpeechItem(null);
                }
            });
            obtain.obj = speechItem.getCallerIdentity();
            if (sendMessage(obtain)) {
                return 0;
            }
            Log.w(TextToSpeechService.TAG, "SynthThread has quit");
            if (utteranceProgressDispatcher != null) {
                utteranceProgressDispatcher.dispatchOnError(-4);
                return -1;
            }
            return -1;
        }

        public boolean isSpeaking() {
            return getCurrentSpeechItem() != null;
        }

        public void quit() {
            getLooper().quit();
            SpeechItem currentSpeechItem = setCurrentSpeechItem(null);
            if (currentSpeechItem != null) {
                currentSpeechItem.stop();
            }
        }

        public int stopAll() {
            SpeechItem currentSpeechItem = setCurrentSpeechItem(null);
            if (currentSpeechItem != null) {
                currentSpeechItem.stop();
            }
            removeCallbacksAndMessages(null);
            TextToSpeechService.this.mAudioPlaybackHandler.stop();
            return 0;
        }

        public int stopForApp(Object obj) {
            if (obj == null) {
                return -1;
            }
            removeCallbacksAndMessages(obj);
            SpeechItem maybeRemoveCurrentSpeechItem = maybeRemoveCurrentSpeechItem(obj);
            if (maybeRemoveCurrentSpeechItem != null) {
                maybeRemoveCurrentSpeechItem.stop();
            }
            TextToSpeechService.this.mAudioPlaybackHandler.stopForApp(obj);
            return 0;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$SynthThread.class */
    private class SynthThread extends HandlerThread implements MessageQueue.IdleHandler {
        private boolean mFirstIdle;

        public SynthThread() {
            super(TextToSpeechService.SYNTH_THREAD_NAME, 0);
            this.mFirstIdle = true;
        }

        private void broadcastTtsQueueProcessingCompleted() {
            TextToSpeechService.this.sendBroadcast(new Intent(TextToSpeech.ACTION_TTS_QUEUE_PROCESSING_COMPLETED));
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            getLooper().getQueue().addIdleHandler(this);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (this.mFirstIdle) {
                this.mFirstIdle = false;
                return true;
            }
            broadcastTtsQueueProcessingCompleted();
            return true;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$SynthesisSpeechItemV1.class */
    class SynthesisSpeechItemV1 extends SpeechItemV1 {
        private final int mCallerUid;
        private final String[] mDefaultLocale;
        private final EventLoggerV1 mEventLogger;
        private AbstractSynthesisCallback mSynthesisCallback;
        private final SynthesisRequest mSynthesisRequest;
        private final CharSequence mText;

        public SynthesisSpeechItemV1(Object obj, int i, int i2, Bundle bundle, String str, CharSequence charSequence) {
            super(obj, i, i2, bundle, str);
            this.mText = charSequence;
            this.mCallerUid = i;
            this.mSynthesisRequest = new SynthesisRequest(this.mText, this.mParams);
            this.mDefaultLocale = TextToSpeechService.this.getSettingsLocale();
            setRequestParams(this.mSynthesisRequest);
            this.mEventLogger = new EventLoggerV1(this.mSynthesisRequest, i, i2, TextToSpeechService.this.mPackageName);
        }

        private String getCountry() {
            return !hasLanguage() ? this.mDefaultLocale[1] : getStringParam(this.mParams, "country", "");
        }

        private String getVariant() {
            return !hasLanguage() ? this.mDefaultLocale[2] : getStringParam(this.mParams, TextToSpeech.Engine.KEY_PARAM_VARIANT, "");
        }

        private void setRequestParams(SynthesisRequest synthesisRequest) {
            String voiceName = getVoiceName();
            synthesisRequest.setLanguage(getLanguage(), getCountry(), getVariant());
            if (!TextUtils.isEmpty(voiceName)) {
                synthesisRequest.setVoiceName(getVoiceName());
            }
            synthesisRequest.setSpeechRate(getSpeechRate());
            synthesisRequest.setCallerUid(this.mCallerUid);
            synthesisRequest.setPitch(getPitch());
        }

        protected AbstractSynthesisCallback createSynthesisCallback() {
            return new PlaybackSynthesisCallback(getAudioParams(), TextToSpeechService.this.mAudioPlaybackHandler, this, getCallerIdentity(), this.mEventLogger, false);
        }

        public String getLanguage() {
            return getStringParam(this.mParams, "language", this.mDefaultLocale[0]);
        }

        public CharSequence getText() {
            return this.mText;
        }

        public String getVoiceName() {
            return getStringParam(this.mParams, TextToSpeech.Engine.KEY_PARAM_VOICE_NAME, "");
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        public boolean isValid() {
            if (this.mText == null) {
                Log.e(TextToSpeechService.TAG, "null synthesis text");
                return false;
            } else if (this.mText.length() >= TextToSpeech.getMaxSpeechInputLength()) {
                Log.w(TextToSpeechService.TAG, "Text too long: " + this.mText.length() + " chars");
                return false;
            } else {
                return true;
            }
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void playImpl() {
            this.mEventLogger.onRequestProcessingStart();
            synchronized (this) {
                if (isStopped()) {
                    return;
                }
                this.mSynthesisCallback = createSynthesisCallback();
                AbstractSynthesisCallback abstractSynthesisCallback = this.mSynthesisCallback;
                TextToSpeechService.this.onSynthesizeText(this.mSynthesisRequest, abstractSynthesisCallback);
                if (!abstractSynthesisCallback.hasStarted() || abstractSynthesisCallback.hasFinished()) {
                    return;
                }
                abstractSynthesisCallback.done();
            }
        }

        @Override // android.speech.tts.TextToSpeechService.SpeechItem
        protected void stopImpl() {
            AbstractSynthesisCallback abstractSynthesisCallback;
            synchronized (this) {
                abstractSynthesisCallback = this.mSynthesisCallback;
            }
            if (abstractSynthesisCallback != null) {
                abstractSynthesisCallback.stop();
                TextToSpeechService.this.onStop();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$SynthesisToFileOutputStreamSpeechItemV1.class */
    private class SynthesisToFileOutputStreamSpeechItemV1 extends SynthesisSpeechItemV1 {
        private final FileOutputStream mFileOutputStream;

        public SynthesisToFileOutputStreamSpeechItemV1(Object obj, int i, int i2, Bundle bundle, String str, CharSequence charSequence, FileOutputStream fileOutputStream) {
            super(obj, i, i2, bundle, str, charSequence);
            this.mFileOutputStream = fileOutputStream;
        }

        @Override // android.speech.tts.TextToSpeechService.SynthesisSpeechItemV1
        protected AbstractSynthesisCallback createSynthesisCallback() {
            return new FileSynthesisCallback(this.mFileOutputStream.getChannel(), this, getCallerIdentity(), false);
        }

        @Override // android.speech.tts.TextToSpeechService.SynthesisSpeechItemV1, android.speech.tts.TextToSpeechService.SpeechItem
        protected void playImpl() {
            dispatchOnStart();
            super.playImpl();
            try {
                this.mFileOutputStream.close();
            } catch (IOException e) {
                Log.w(TextToSpeechService.TAG, "Failed to close output file", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$UtteranceProgressDispatcher.class */
    public interface UtteranceProgressDispatcher {
        void dispatchOnError(int i);

        void dispatchOnStart();

        void dispatchOnStop();

        void dispatchOnSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeechService$UtteranceSpeechItem.class */
    public abstract class UtteranceSpeechItem extends SpeechItem implements UtteranceProgressDispatcher {
        public UtteranceSpeechItem(Object obj, int i, int i2) {
            super(obj, i, i2);
        }

        @Override // android.speech.tts.TextToSpeechService.UtteranceProgressDispatcher
        public void dispatchOnError(int i) {
            String utteranceId = getUtteranceId();
            if (utteranceId != null) {
                TextToSpeechService.this.mCallbacks.dispatchOnError(getCallerIdentity(), utteranceId, i);
            }
        }

        @Override // android.speech.tts.TextToSpeechService.UtteranceProgressDispatcher
        public void dispatchOnStart() {
            String utteranceId = getUtteranceId();
            if (utteranceId != null) {
                TextToSpeechService.this.mCallbacks.dispatchOnStart(getCallerIdentity(), utteranceId);
            }
        }

        @Override // android.speech.tts.TextToSpeechService.UtteranceProgressDispatcher
        public void dispatchOnStop() {
            String utteranceId = getUtteranceId();
            if (utteranceId != null) {
                TextToSpeechService.this.mCallbacks.dispatchOnStop(getCallerIdentity(), utteranceId);
            }
        }

        @Override // android.speech.tts.TextToSpeechService.UtteranceProgressDispatcher
        public void dispatchOnSuccess() {
            String utteranceId = getUtteranceId();
            if (utteranceId != null) {
                TextToSpeechService.this.mCallbacks.dispatchOnSuccess(getCallerIdentity(), utteranceId);
            }
        }

        float getFloatParam(Bundle bundle, String str, float f) {
            return bundle == null ? f : bundle.getFloat(str, f);
        }

        int getIntParam(Bundle bundle, String str, int i) {
            return bundle == null ? i : bundle.getInt(str, i);
        }

        String getStringParam(Bundle bundle, String str, String str2) {
            return bundle == null ? str2 : bundle.getString(str, str2);
        }

        public abstract String getUtteranceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDefaultSpeechRate() {
        return getSecureSettingInt(Settings.Secure.TTS_DEFAULT_RATE, 100);
    }

    private int getExpectedLanguageAvailableStatus(Locale locale) {
        int i = 2;
        if (locale.getVariant().isEmpty()) {
            if (!locale.getCountry().isEmpty()) {
                return 1;
            }
            i = 0;
        }
        return i;
    }

    private int getSecureSettingInt(String str, int i) {
        return Settings.Secure.getInt(getContentResolver(), str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] getSettingsLocale() {
        return TtsEngines.toOldLocaleStringFormat(this.mEngineHelper.getLocalePrefForEngine(this.mPackageName));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (TextToSpeech.Engine.INTENT_ACTION_TTS_SERVICE.equals(intent.getAction())) {
            return this.mBinder;
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SynthThread synthThread = new SynthThread();
        synthThread.start();
        this.mSynthHandler = new SynthHandler(synthThread.getLooper());
        this.mAudioPlaybackHandler = new AudioPlaybackHandler();
        this.mAudioPlaybackHandler.start();
        this.mEngineHelper = new TtsEngines(this);
        this.mCallbacks = new CallbackMap();
        this.mPackageName = getApplicationInfo().packageName;
        String[] settingsLocale = getSettingsLocale();
        onLoadLanguage(settingsLocale[0], settingsLocale[1], settingsLocale[2]);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mSynthHandler.quit();
        this.mAudioPlaybackHandler.quit();
        this.mCallbacks.kill();
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String onGetDefaultVoiceNameFor(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            int r0 = r0.onIsLanguageAvailable(r1, r2, r3)
            switch(r0) {
                case 0: goto L24;
                case 1: goto L41;
                case 2: goto L4e;
                default: goto L20;
            }
        L20:
            r0 = 0
            r7 = r0
        L22:
            r0 = r7
            return r0
        L24:
            java.util.Locale r0 = new java.util.Locale
            r1 = r0
            r2 = r7
            r1.<init>(r2)
            r7 = r0
        L2d:
            r0 = r7
            java.util.Locale r0 = android.speech.tts.TtsEngines.normalizeTTSLocale(r0)
            java.lang.String r0 = r0.toLanguageTag()
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r6
            r1 = r8
            int r0 = r0.onIsValidVoiceName(r1)
            if (r0 == 0) goto L22
            r0 = 0
            return r0
        L41:
            java.util.Locale r0 = new java.util.Locale
            r1 = r0
            r2 = r7
            r3 = r8
            r1.<init>(r2, r3)
            r7 = r0
            goto L2d
        L4e:
            java.util.Locale r0 = new java.util.Locale
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r1.<init>(r2, r3, r4)
            r7 = r0
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: android.speech.tts.TextToSpeechService.onGetDefaultVoiceNameFor(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    protected Set<String> onGetFeaturesForLanguage(String str, String str2, String str3) {
        return null;
    }

    protected abstract String[] onGetLanguage();

    public List<Voice> onGetVoices() {
        ArrayList arrayList = new ArrayList();
        Locale[] availableLocales = Locale.getAvailableLocales();
        int length = availableLocales.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            Locale locale = availableLocales[i2];
            try {
                if (onIsLanguageAvailable(locale.getISO3Language(), locale.getISO3Country(), locale.getVariant()) == getExpectedLanguageAvailableStatus(locale)) {
                    arrayList.add(new Voice(locale.toLanguageTag(), locale, 300, 300, false, onGetFeaturesForLanguage(locale.getISO3Language(), locale.getISO3Country(), locale.getVariant())));
                }
            } catch (MissingResourceException e) {
            }
            i = i2 + 1;
        }
    }

    protected abstract int onIsLanguageAvailable(String str, String str2, String str3);

    public int onIsValidVoiceName(String str) {
        Locale forLanguageTag = Locale.forLanguageTag(str);
        if (forLanguageTag == null) {
            return -1;
        }
        try {
            return onIsLanguageAvailable(forLanguageTag.getISO3Language(), forLanguageTag.getISO3Country(), forLanguageTag.getVariant()) == getExpectedLanguageAvailableStatus(forLanguageTag) ? 0 : -1;
        } catch (MissingResourceException e) {
            return -1;
        }
    }

    protected abstract int onLoadLanguage(String str, String str2, String str3);

    public int onLoadVoice(String str) {
        Locale forLanguageTag = Locale.forLanguageTag(str);
        if (forLanguageTag == null) {
            return -1;
        }
        try {
            if (onIsLanguageAvailable(forLanguageTag.getISO3Language(), forLanguageTag.getISO3Country(), forLanguageTag.getVariant()) == getExpectedLanguageAvailableStatus(forLanguageTag)) {
                onLoadLanguage(forLanguageTag.getISO3Language(), forLanguageTag.getISO3Country(), forLanguageTag.getVariant());
                return 0;
            }
            return -1;
        } catch (MissingResourceException e) {
            return -1;
        }
    }

    protected abstract void onStop();

    protected abstract void onSynthesizeText(SynthesisRequest synthesisRequest, SynthesisCallback synthesisCallback);
}
