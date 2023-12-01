package android.speech.tts;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.speech.tts.ITextToSpeechCallback;
import android.speech.tts.ITextToSpeechService;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech.class */
public class TextToSpeech {
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED = "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
    public static final int ERROR = -1;
    public static final int ERROR_INVALID_REQUEST = -8;
    public static final int ERROR_NETWORK = -6;
    public static final int ERROR_NETWORK_TIMEOUT = -7;
    public static final int ERROR_NOT_INSTALLED_YET = -9;
    public static final int ERROR_OUTPUT = -5;
    public static final int ERROR_SERVICE = -4;
    public static final int ERROR_SYNTHESIS = -3;
    public static final int LANG_AVAILABLE = 0;
    public static final int LANG_COUNTRY_AVAILABLE = 1;
    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    public static final int LANG_MISSING_DATA = -1;
    public static final int LANG_NOT_SUPPORTED = -2;
    public static final int QUEUE_ADD = 1;
    static final int QUEUE_DESTROY = 2;
    public static final int QUEUE_FLUSH = 0;
    public static final int STOPPED = -2;
    public static final int SUCCESS = 0;
    private static final String TAG = "TextToSpeech";
    private Connection mConnectingServiceConnection;
    private final Context mContext;
    private volatile String mCurrentEngine;
    private final Map<String, Uri> mEarcons;
    private final TtsEngines mEnginesHelper;
    private OnInitListener mInitListener;
    private final Bundle mParams;
    private String mRequestedEngine;
    private Connection mServiceConnection;
    private final Object mStartLock;
    private final boolean mUseFallback;
    private volatile UtteranceProgressListener mUtteranceProgressListener;
    private final Map<CharSequence, Uri> mUtterances;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech$Action.class */
    public interface Action<R> {
        R run(ITextToSpeechService iTextToSpeechService) throws RemoteException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech$Connection.class */
    public class Connection implements ServiceConnection {
        private final ITextToSpeechCallback.Stub mCallback;
        private boolean mEstablished;
        private SetupConnectionAsyncTask mOnSetupConnectionAsyncTask;
        private ITextToSpeechService mService;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech$Connection$SetupConnectionAsyncTask.class */
        public class SetupConnectionAsyncTask extends AsyncTask<Void, Void, Integer> {
            private final ComponentName mName;

            public SetupConnectionAsyncTask(ComponentName componentName) {
                this.mName = componentName;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Integer doInBackground(Void... voidArr) {
                synchronized (TextToSpeech.this.mStartLock) {
                    if (isCancelled()) {
                        return null;
                    }
                    try {
                        Connection.this.mService.setCallback(Connection.this.getCallerIdentity(), Connection.this.mCallback);
                        if (TextToSpeech.this.mParams.getString("language") == null) {
                            String[] clientDefaultLanguage = Connection.this.mService.getClientDefaultLanguage();
                            TextToSpeech.this.mParams.putString("language", clientDefaultLanguage[0]);
                            TextToSpeech.this.mParams.putString("country", clientDefaultLanguage[1]);
                            TextToSpeech.this.mParams.putString(Engine.KEY_PARAM_VARIANT, clientDefaultLanguage[2]);
                            TextToSpeech.this.mParams.putString(Engine.KEY_PARAM_VOICE_NAME, Connection.this.mService.getDefaultVoiceNameFor(clientDefaultLanguage[0], clientDefaultLanguage[1], clientDefaultLanguage[2]));
                        }
                        Log.i(TextToSpeech.TAG, "Set up connection to " + this.mName);
                        return 0;
                    } catch (RemoteException e) {
                        Log.e(TextToSpeech.TAG, "Error connecting to service, setCallback() failed");
                        return -1;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Integer num) {
                synchronized (TextToSpeech.this.mStartLock) {
                    if (Connection.this.mOnSetupConnectionAsyncTask == this) {
                        Connection.this.mOnSetupConnectionAsyncTask = null;
                    }
                    Connection.this.mEstablished = true;
                    TextToSpeech.this.dispatchOnInit(num.intValue());
                }
            }
        }

        private Connection() {
            this.mCallback = new ITextToSpeechCallback.Stub() { // from class: android.speech.tts.TextToSpeech.Connection.1
                @Override // android.speech.tts.ITextToSpeechCallback
                public void onError(String str, int i) {
                    UtteranceProgressListener utteranceProgressListener = TextToSpeech.this.mUtteranceProgressListener;
                    if (utteranceProgressListener != null) {
                        utteranceProgressListener.onError(str);
                    }
                }

                @Override // android.speech.tts.ITextToSpeechCallback
                public void onStart(String str) {
                    UtteranceProgressListener utteranceProgressListener = TextToSpeech.this.mUtteranceProgressListener;
                    if (utteranceProgressListener != null) {
                        utteranceProgressListener.onStart(str);
                    }
                }

                @Override // android.speech.tts.ITextToSpeechCallback
                public void onStop(String str) throws RemoteException {
                    UtteranceProgressListener utteranceProgressListener = TextToSpeech.this.mUtteranceProgressListener;
                    if (utteranceProgressListener != null) {
                        utteranceProgressListener.onDone(str);
                    }
                }

                @Override // android.speech.tts.ITextToSpeechCallback
                public void onSuccess(String str) {
                    UtteranceProgressListener utteranceProgressListener = TextToSpeech.this.mUtteranceProgressListener;
                    if (utteranceProgressListener != null) {
                        utteranceProgressListener.onDone(str);
                    }
                }
            };
        }

        private boolean clearServiceConnection() {
            boolean z;
            synchronized (TextToSpeech.this.mStartLock) {
                z = false;
                if (this.mOnSetupConnectionAsyncTask != null) {
                    z = this.mOnSetupConnectionAsyncTask.cancel(false);
                    this.mOnSetupConnectionAsyncTask = null;
                }
                this.mService = null;
                if (TextToSpeech.this.mServiceConnection == this) {
                    TextToSpeech.this.mServiceConnection = null;
                }
            }
            return z;
        }

        public void disconnect() {
            TextToSpeech.this.mContext.unbindService(this);
            clearServiceConnection();
        }

        public IBinder getCallerIdentity() {
            return this.mCallback;
        }

        public boolean isEstablished() {
            return this.mService != null && this.mEstablished;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (TextToSpeech.this.mStartLock) {
                TextToSpeech.this.mConnectingServiceConnection = null;
                Log.i(TextToSpeech.TAG, "Connected to " + componentName);
                if (this.mOnSetupConnectionAsyncTask != null) {
                    this.mOnSetupConnectionAsyncTask.cancel(false);
                }
                this.mService = ITextToSpeechService.Stub.asInterface(iBinder);
                TextToSpeech.this.mServiceConnection = this;
                this.mEstablished = false;
                this.mOnSetupConnectionAsyncTask = new SetupConnectionAsyncTask(componentName);
                this.mOnSetupConnectionAsyncTask.execute(new Void[0]);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(TextToSpeech.TAG, "Asked to disconnect from " + componentName);
            if (clearServiceConnection()) {
                TextToSpeech.this.dispatchOnInit(-1);
            }
        }

        public <R> R runAction(Action<R> action, R r, String str, boolean z, boolean z2) {
            synchronized (TextToSpeech.this.mStartLock) {
                try {
                    if (this.mService == null) {
                        Log.w(TextToSpeech.TAG, str + " failed: not connected to TTS engine");
                        return r;
                    } else if (!z2 || isEstablished()) {
                        return action.run(this.mService);
                    } else {
                        Log.w(TextToSpeech.TAG, str + " failed: TTS engine connection not fully set up");
                        return r;
                    }
                } catch (RemoteException e) {
                    Log.e(TextToSpeech.TAG, str + " failed", e);
                    if (z) {
                        disconnect();
                        TextToSpeech.this.initTts();
                    }
                    return r;
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech$Engine.class */
    public class Engine {
        public static final String ACTION_CHECK_TTS_DATA = "android.speech.tts.engine.CHECK_TTS_DATA";
        public static final String ACTION_GET_SAMPLE_TEXT = "android.speech.tts.engine.GET_SAMPLE_TEXT";
        public static final String ACTION_INSTALL_TTS_DATA = "android.speech.tts.engine.INSTALL_TTS_DATA";
        public static final String ACTION_TTS_DATA_INSTALLED = "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @Deprecated
        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        public static final int CHECK_VOICE_DATA_FAIL = 0;
        @Deprecated
        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        @Deprecated
        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        public static final int CHECK_VOICE_DATA_PASS = 1;
        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        public static final float DEFAULT_PAN = 0.0f;
        public static final int DEFAULT_PITCH = 100;
        public static final int DEFAULT_RATE = 100;
        public static final int DEFAULT_STREAM = 3;
        public static final float DEFAULT_VOLUME = 1.0f;
        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        @Deprecated
        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        public static final String EXTRA_SAMPLE_TEXT = "sampleText";
        @Deprecated
        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        @Deprecated
        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        @Deprecated
        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        @Deprecated
        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        public static final String INTENT_ACTION_TTS_SERVICE = "android.intent.action.TTS_SERVICE";
        @Deprecated
        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
        public static final String KEY_FEATURE_NETWORK_RETRIES_COUNT = "networkRetriesCount";
        @Deprecated
        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        public static final String KEY_FEATURE_NETWORK_TIMEOUT_MS = "networkTimeoutMs";
        public static final String KEY_FEATURE_NOT_INSTALLED = "notInstalled";
        public static final String KEY_PARAM_AUDIO_ATTRIBUTES = "audioAttributes";
        public static final String KEY_PARAM_COUNTRY = "country";
        public static final String KEY_PARAM_ENGINE = "engine";
        public static final String KEY_PARAM_LANGUAGE = "language";
        public static final String KEY_PARAM_PAN = "pan";
        public static final String KEY_PARAM_PITCH = "pitch";
        public static final String KEY_PARAM_RATE = "rate";
        public static final String KEY_PARAM_SESSION_ID = "sessionId";
        public static final String KEY_PARAM_STREAM = "streamType";
        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        public static final String KEY_PARAM_VARIANT = "variant";
        public static final String KEY_PARAM_VOICE_NAME = "voiceName";
        public static final String KEY_PARAM_VOLUME = "volume";
        public static final String SERVICE_META_DATA = "android.speech.tts";
        public static final int USE_DEFAULTS = 0;

        public Engine() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech$EngineInfo.class */
    public static class EngineInfo {
        public int icon;
        public String label;
        public String name;
        public int priority;
        public boolean system;

        public String toString() {
            return "EngineInfo{name=" + this.name + i.d;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech$OnInitListener.class */
    public interface OnInitListener {
        void onInit(int i);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/speech/tts/TextToSpeech$OnUtteranceCompletedListener.class */
    public interface OnUtteranceCompletedListener {
        void onUtteranceCompleted(String str);
    }

    public TextToSpeech(Context context, OnInitListener onInitListener) {
        this(context, onInitListener, null);
    }

    public TextToSpeech(Context context, OnInitListener onInitListener, String str) {
        this(context, onInitListener, str, null, true);
    }

    public TextToSpeech(Context context, OnInitListener onInitListener, String str, String str2, boolean z) {
        this.mStartLock = new Object();
        this.mParams = new Bundle();
        this.mCurrentEngine = null;
        this.mContext = context;
        this.mInitListener = onInitListener;
        this.mRequestedEngine = str;
        this.mUseFallback = z;
        this.mEarcons = new HashMap();
        this.mUtterances = new HashMap();
        this.mUtteranceProgressListener = null;
        this.mEnginesHelper = new TtsEngines(this.mContext);
        initTts();
    }

    private boolean connectToEngine(String str) {
        Connection connection = new Connection();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(str);
        if (!this.mContext.bindService(intent, connection, 1)) {
            Log.e(TAG, "Failed to bind to " + str);
            return false;
        }
        Log.i(TAG, "Sucessfully bound to " + str);
        this.mConnectingServiceConnection = connection;
        return true;
    }

    private Bundle convertParamsHashMaptoBundle(HashMap<String, String> hashMap) {
        Bundle bundle;
        if (hashMap == null || hashMap.isEmpty()) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            copyIntParam(bundle2, hashMap, Engine.KEY_PARAM_STREAM);
            copyIntParam(bundle2, hashMap, Engine.KEY_PARAM_SESSION_ID);
            copyStringParam(bundle2, hashMap, Engine.KEY_PARAM_UTTERANCE_ID);
            copyFloatParam(bundle2, hashMap, "volume");
            copyFloatParam(bundle2, hashMap, Engine.KEY_PARAM_PAN);
            copyStringParam(bundle2, hashMap, Engine.KEY_FEATURE_NETWORK_SYNTHESIS);
            copyStringParam(bundle2, hashMap, Engine.KEY_FEATURE_EMBEDDED_SYNTHESIS);
            copyIntParam(bundle2, hashMap, Engine.KEY_FEATURE_NETWORK_TIMEOUT_MS);
            copyIntParam(bundle2, hashMap, Engine.KEY_FEATURE_NETWORK_RETRIES_COUNT);
            bundle = bundle2;
            if (!TextUtils.isEmpty(this.mCurrentEngine)) {
                Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                while (true) {
                    bundle = bundle2;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    if (key != null && key.startsWith(this.mCurrentEngine)) {
                        bundle2.putString(key, next.getValue());
                    }
                }
            }
        }
        return bundle;
    }

    private void copyFloatParam(Bundle bundle, HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            bundle.putFloat(str, Float.parseFloat(str2));
        } catch (NumberFormatException e) {
        }
    }

    private void copyIntParam(Bundle bundle, HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            bundle.putInt(str, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
        }
    }

    private void copyStringParam(Bundle bundle, HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnInit(int i) {
        synchronized (this.mStartLock) {
            if (this.mInitListener != null) {
                this.mInitListener.onInit(i);
                this.mInitListener = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IBinder getCallerIdentity() {
        return this.mServiceConnection.getCallerIdentity();
    }

    public static int getMaxSpeechInputLength() {
        return 4000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle getParams(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return this.mParams;
        }
        Bundle bundle2 = new Bundle(this.mParams);
        bundle2.putAll(bundle);
        verifyIntegerBundleParam(bundle2, Engine.KEY_PARAM_STREAM);
        verifyIntegerBundleParam(bundle2, Engine.KEY_PARAM_SESSION_ID);
        verifyStringBundleParam(bundle2, Engine.KEY_PARAM_UTTERANCE_ID);
        verifyFloatBundleParam(bundle2, "volume");
        verifyFloatBundleParam(bundle2, Engine.KEY_PARAM_PAN);
        verifyBooleanBundleParam(bundle2, Engine.KEY_FEATURE_NETWORK_SYNTHESIS);
        verifyBooleanBundleParam(bundle2, Engine.KEY_FEATURE_EMBEDDED_SYNTHESIS);
        verifyIntegerBundleParam(bundle2, Engine.KEY_FEATURE_NETWORK_TIMEOUT_MS);
        verifyIntegerBundleParam(bundle2, Engine.KEY_FEATURE_NETWORK_RETRIES_COUNT);
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int initTts() {
        if (this.mRequestedEngine != null) {
            if (this.mEnginesHelper.isEngineInstalled(this.mRequestedEngine)) {
                if (connectToEngine(this.mRequestedEngine)) {
                    this.mCurrentEngine = this.mRequestedEngine;
                    return 0;
                } else if (!this.mUseFallback) {
                    this.mCurrentEngine = null;
                    dispatchOnInit(-1);
                    return -1;
                }
            } else if (!this.mUseFallback) {
                Log.i(TAG, "Requested engine not installed: " + this.mRequestedEngine);
                this.mCurrentEngine = null;
                dispatchOnInit(-1);
                return -1;
            }
        }
        String defaultEngine = getDefaultEngine();
        if (defaultEngine != null && !defaultEngine.equals(this.mRequestedEngine) && connectToEngine(defaultEngine)) {
            this.mCurrentEngine = defaultEngine;
            return 0;
        }
        String highestRankedEngineName = this.mEnginesHelper.getHighestRankedEngineName();
        if (highestRankedEngineName != null && !highestRankedEngineName.equals(this.mRequestedEngine) && !highestRankedEngineName.equals(defaultEngine) && connectToEngine(highestRankedEngineName)) {
            this.mCurrentEngine = highestRankedEngineName;
            return 0;
        }
        this.mCurrentEngine = null;
        dispatchOnInit(-1);
        return -1;
    }

    private Uri makeResourceUri(String str, int i) {
        return new Uri.Builder().scheme(ContentResolver.SCHEME_ANDROID_RESOURCE).encodedAuthority(str).appendEncodedPath(String.valueOf(i)).build();
    }

    private <R> R runAction(Action<R> action, R r, String str) {
        return (R) runAction(action, r, str, true, true);
    }

    private <R> R runAction(Action<R> action, R r, String str, boolean z, boolean z2) {
        synchronized (this.mStartLock) {
            if (this.mServiceConnection == null) {
                Log.w(TAG, str + " failed: not bound to TTS engine");
                return r;
            }
            return (R) this.mServiceConnection.runAction(action, r, str, z, z2);
        }
    }

    private <R> R runActionNoReconnect(Action<R> action, R r, String str, boolean z) {
        return (R) runAction(action, r, str, false, z);
    }

    private static boolean verifyBooleanBundleParam(Bundle bundle, String str) {
        if (!bundle.containsKey(str) || (bundle.get(str) instanceof Boolean) || (bundle.get(str) instanceof String)) {
            return true;
        }
        bundle.remove(str);
        Log.w(TAG, "Synthesis request paramter " + str + " containst value  with invalid type. Should be a Boolean or String");
        return false;
    }

    private static boolean verifyFloatBundleParam(Bundle bundle, String str) {
        if (!bundle.containsKey(str) || (bundle.get(str) instanceof Float) || (bundle.get(str) instanceof Double)) {
            return true;
        }
        bundle.remove(str);
        Log.w(TAG, "Synthesis request paramter " + str + " containst value  with invalid type. Should be a Float or a Double");
        return false;
    }

    private static boolean verifyIntegerBundleParam(Bundle bundle, String str) {
        if (!bundle.containsKey(str) || (bundle.get(str) instanceof Integer) || (bundle.get(str) instanceof Long)) {
            return true;
        }
        bundle.remove(str);
        Log.w(TAG, "Synthesis request paramter " + str + " containst value  with invalid type. Should be an Integer or a Long");
        return false;
    }

    private static boolean verifyStringBundleParam(Bundle bundle, String str) {
        if (!bundle.containsKey(str) || (bundle.get(str) instanceof String)) {
            return true;
        }
        bundle.remove(str);
        Log.w(TAG, "Synthesis request paramter " + str + " containst value  with invalid type. Should be a String");
        return false;
    }

    public int addEarcon(String str, File file) {
        synchronized (this.mStartLock) {
            this.mEarcons.put(str, Uri.fromFile(file));
        }
        return 0;
    }

    @Deprecated
    public int addEarcon(String str, String str2) {
        synchronized (this.mStartLock) {
            this.mEarcons.put(str, Uri.parse(str2));
        }
        return 0;
    }

    public int addEarcon(String str, String str2, int i) {
        synchronized (this.mStartLock) {
            this.mEarcons.put(str, makeResourceUri(str2, i));
        }
        return 0;
    }

    public int addSpeech(CharSequence charSequence, File file) {
        synchronized (this.mStartLock) {
            this.mUtterances.put(charSequence, Uri.fromFile(file));
        }
        return 0;
    }

    public int addSpeech(CharSequence charSequence, String str, int i) {
        synchronized (this.mStartLock) {
            this.mUtterances.put(charSequence, makeResourceUri(str, i));
        }
        return 0;
    }

    public int addSpeech(String str, String str2) {
        synchronized (this.mStartLock) {
            this.mUtterances.put(str, Uri.parse(str2));
        }
        return 0;
    }

    public int addSpeech(String str, String str2, int i) {
        synchronized (this.mStartLock) {
            this.mUtterances.put(str, makeResourceUri(str2, i));
        }
        return 0;
    }

    @Deprecated
    public boolean areDefaultsEnforced() {
        return false;
    }

    public Set<Locale> getAvailableLanguages() {
        return (Set) runAction(new Action<Set<Locale>>() { // from class: android.speech.tts.TextToSpeech.11
            @Override // android.speech.tts.TextToSpeech.Action
            public Set<Locale> run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                HashSet hashSet;
                List<Voice> voices = iTextToSpeechService.getVoices();
                if (voices != null) {
                    HashSet hashSet2 = new HashSet();
                    Iterator<Voice> it = voices.iterator();
                    while (true) {
                        hashSet = hashSet2;
                        if (!it.hasNext()) {
                            break;
                        }
                        hashSet2.add(it.next().getLocale());
                    }
                } else {
                    hashSet = new HashSet();
                }
                return hashSet;
            }
        }, null, "getAvailableLanguages");
    }

    public String getCurrentEngine() {
        return this.mCurrentEngine;
    }

    public String getDefaultEngine() {
        return this.mEnginesHelper.getDefaultEngine();
    }

    @Deprecated
    public Locale getDefaultLanguage() {
        return (Locale) runAction(new Action<Locale>() { // from class: android.speech.tts.TextToSpeech.8
            @Override // android.speech.tts.TextToSpeech.Action
            public Locale run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                String[] clientDefaultLanguage = iTextToSpeechService.getClientDefaultLanguage();
                return new Locale(clientDefaultLanguage[0], clientDefaultLanguage[1], clientDefaultLanguage[2]);
            }
        }, null, "getDefaultLanguage");
    }

    public Voice getDefaultVoice() {
        return (Voice) runAction(new Action<Voice>() { // from class: android.speech.tts.TextToSpeech.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Voice run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                List<Voice> voices;
                String[] clientDefaultLanguage = iTextToSpeechService.getClientDefaultLanguage();
                if (clientDefaultLanguage == null || clientDefaultLanguage.length == 0) {
                    Log.e(TextToSpeech.TAG, "service.getClientDefaultLanguage() returned empty array");
                    return null;
                }
                String str = clientDefaultLanguage[0];
                String str2 = clientDefaultLanguage.length > 1 ? clientDefaultLanguage[1] : "";
                String str3 = clientDefaultLanguage.length > 2 ? clientDefaultLanguage[2] : "";
                int isLanguageAvailable = iTextToSpeechService.isLanguageAvailable(str, str2, str3);
                if (isLanguageAvailable >= 0) {
                    String str4 = str2;
                    if (isLanguageAvailable < 2) {
                        str4 = str2;
                        str3 = "";
                        if (isLanguageAvailable < 1) {
                            str4 = "";
                            str3 = "";
                        }
                    }
                    String defaultVoiceNameFor = iTextToSpeechService.getDefaultVoiceNameFor(str, str4, str3);
                    if (TextUtils.isEmpty(defaultVoiceNameFor) || (voices = iTextToSpeechService.getVoices()) == null) {
                        return null;
                    }
                    for (Voice voice : voices) {
                        if (voice.getName().equals(defaultVoiceNameFor)) {
                            return voice;
                        }
                    }
                    return null;
                }
                return null;
            }
        }, null, "getDefaultVoice");
    }

    public List<EngineInfo> getEngines() {
        return this.mEnginesHelper.getEngines();
    }

    @Deprecated
    public Set<String> getFeatures(final Locale locale) {
        return (Set) runAction(new Action<Set<String>>() { // from class: android.speech.tts.TextToSpeech.5
            @Override // android.speech.tts.TextToSpeech.Action
            public Set<String> run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                try {
                    String[] featuresForLanguage = iTextToSpeechService.getFeaturesForLanguage(locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
                    HashSet hashSet = null;
                    if (featuresForLanguage != null) {
                        hashSet = new HashSet();
                        Collections.addAll(hashSet, featuresForLanguage);
                    }
                    return hashSet;
                } catch (MissingResourceException e) {
                    Log.w(TextToSpeech.TAG, "Couldn't retrieve 3 letter ISO 639-2/T language and/or ISO 3166 country code for locale: " + locale, e);
                    return null;
                }
            }
        }, null, "getFeatures");
    }

    @Deprecated
    public Locale getLanguage() {
        return (Locale) runAction(new Action<Locale>() { // from class: android.speech.tts.TextToSpeech.10
            @Override // android.speech.tts.TextToSpeech.Action
            public Locale run(ITextToSpeechService iTextToSpeechService) {
                return new Locale(TextToSpeech.this.mParams.getString("language", ""), TextToSpeech.this.mParams.getString("country", ""), TextToSpeech.this.mParams.getString(Engine.KEY_PARAM_VARIANT, ""));
            }
        }, null, "getLanguage");
    }

    public Voice getVoice() {
        return (Voice) runAction(new Action<Voice>() { // from class: android.speech.tts.TextToSpeech.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Voice run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                List<Voice> voices;
                String string = TextToSpeech.this.mParams.getString(Engine.KEY_PARAM_VOICE_NAME, "");
                if (TextUtils.isEmpty(string) || (voices = iTextToSpeechService.getVoices()) == null) {
                    return null;
                }
                for (Voice voice : voices) {
                    if (voice.getName().equals(string)) {
                        return voice;
                    }
                }
                return null;
            }
        }, null, "getVoice");
    }

    public Set<Voice> getVoices() {
        return (Set) runAction(new Action<Set<Voice>>() { // from class: android.speech.tts.TextToSpeech.12
            @Override // android.speech.tts.TextToSpeech.Action
            public Set<Voice> run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                List<Voice> voices = iTextToSpeechService.getVoices();
                return voices != null ? new HashSet(voices) : new HashSet();
            }
        }, null, "getVoices");
    }

    public int isLanguageAvailable(final Locale locale) {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                try {
                    try {
                        return Integer.valueOf(iTextToSpeechService.isLanguageAvailable(locale.getISO3Language(), locale.getISO3Country(), locale.getVariant()));
                    } catch (MissingResourceException e) {
                        Log.w(TextToSpeech.TAG, "Couldn't retrieve ISO 3166 country code for locale: " + locale, e);
                        return -2;
                    }
                } catch (MissingResourceException e2) {
                    Log.w(TextToSpeech.TAG, "Couldn't retrieve ISO 639-2/T language code for locale: " + locale, e2);
                    return -2;
                }
            }
        }, -2, "isLanguageAvailable")).intValue();
    }

    public boolean isSpeaking() {
        return ((Boolean) runAction(new Action<Boolean>() { // from class: android.speech.tts.TextToSpeech.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Boolean run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                return Boolean.valueOf(iTextToSpeechService.isSpeaking());
            }
        }, false, "isSpeaking")).booleanValue();
    }

    public int playEarcon(final String str, final int i, final Bundle bundle, final String str2) {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                Uri uri = (Uri) TextToSpeech.this.mEarcons.get(str);
                if (uri == null) {
                    return -1;
                }
                return Integer.valueOf(iTextToSpeechService.playAudio(TextToSpeech.this.getCallerIdentity(), uri, i, TextToSpeech.this.getParams(bundle), str2));
            }
        }, -1, "playEarcon")).intValue();
    }

    @Deprecated
    public int playEarcon(String str, int i, HashMap<String, String> hashMap) {
        return playEarcon(str, i, convertParamsHashMaptoBundle(hashMap), hashMap == null ? null : hashMap.get(Engine.KEY_PARAM_UTTERANCE_ID));
    }

    @Deprecated
    public int playSilence(long j, int i, HashMap<String, String> hashMap) {
        return playSilentUtterance(j, i, hashMap == null ? null : hashMap.get(Engine.KEY_PARAM_UTTERANCE_ID));
    }

    public int playSilentUtterance(final long j, final int i, final String str) {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                return Integer.valueOf(iTextToSpeechService.playSilence(TextToSpeech.this.getCallerIdentity(), j, i, str));
            }
        }, -1, "playSilentUtterance")).intValue();
    }

    public int setAudioAttributes(AudioAttributes audioAttributes) {
        if (audioAttributes != null) {
            synchronized (this.mStartLock) {
                this.mParams.putParcelable(Engine.KEY_PARAM_AUDIO_ATTRIBUTES, audioAttributes);
            }
            return 0;
        }
        return -1;
    }

    @Deprecated
    public int setEngineByPackageName(String str) {
        this.mRequestedEngine = str;
        return initTts();
    }

    public int setLanguage(final Locale locale) {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                if (locale == null) {
                    return -2;
                }
                try {
                    String iSO3Language = locale.getISO3Language();
                    try {
                        String iSO3Country = locale.getISO3Country();
                        String variant = locale.getVariant();
                        int isLanguageAvailable = iTextToSpeechService.isLanguageAvailable(iSO3Language, iSO3Country, variant);
                        if (isLanguageAvailable >= 0) {
                            String str = iSO3Country;
                            if (isLanguageAvailable < 2) {
                                str = iSO3Country;
                                variant = "";
                                if (isLanguageAvailable < 1) {
                                    str = "";
                                    variant = "";
                                }
                            }
                            String defaultVoiceNameFor = iTextToSpeechService.getDefaultVoiceNameFor(iSO3Language, str, variant);
                            if (TextUtils.isEmpty(defaultVoiceNameFor)) {
                                Log.w(TextToSpeech.TAG, "Couldn't find the default voice for " + iSO3Language + BridgeUtil.SPLIT_MARK + str + BridgeUtil.SPLIT_MARK + variant);
                                return -2;
                            } else if (iTextToSpeechService.loadVoice(TextToSpeech.this.getCallerIdentity(), defaultVoiceNameFor) == -1) {
                                return -2;
                            } else {
                                TextToSpeech.this.mParams.putString(Engine.KEY_PARAM_VOICE_NAME, defaultVoiceNameFor);
                                TextToSpeech.this.mParams.putString("language", iSO3Language);
                                TextToSpeech.this.mParams.putString("country", str);
                                TextToSpeech.this.mParams.putString(Engine.KEY_PARAM_VARIANT, variant);
                            }
                        }
                        return Integer.valueOf(isLanguageAvailable);
                    } catch (MissingResourceException e) {
                        Log.w(TextToSpeech.TAG, "Couldn't retrieve ISO 3166 country code for locale: " + locale, e);
                        return -2;
                    }
                } catch (MissingResourceException e2) {
                    Log.w(TextToSpeech.TAG, "Couldn't retrieve ISO 639-2/T language code for locale: " + locale, e2);
                    return -2;
                }
            }
        }, -2, "setLanguage")).intValue();
    }

    @Deprecated
    public int setOnUtteranceCompletedListener(OnUtteranceCompletedListener onUtteranceCompletedListener) {
        this.mUtteranceProgressListener = UtteranceProgressListener.from(onUtteranceCompletedListener);
        return 0;
    }

    public int setOnUtteranceProgressListener(UtteranceProgressListener utteranceProgressListener) {
        this.mUtteranceProgressListener = utteranceProgressListener;
        return 0;
    }

    public int setPitch(float f) {
        int i;
        if (f <= 0.0f || (i = (int) (100.0f * f)) <= 0) {
            return -1;
        }
        synchronized (this.mStartLock) {
            this.mParams.putInt(Engine.KEY_PARAM_PITCH, i);
        }
        return 0;
    }

    public int setSpeechRate(float f) {
        int i;
        if (f <= 0.0f || (i = (int) (100.0f * f)) <= 0) {
            return -1;
        }
        synchronized (this.mStartLock) {
            this.mParams.putInt(Engine.KEY_PARAM_RATE, i);
        }
        return 0;
    }

    public int setVoice(final Voice voice) {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                int loadVoice = iTextToSpeechService.loadVoice(TextToSpeech.this.getCallerIdentity(), voice.getName());
                if (loadVoice == 0) {
                    TextToSpeech.this.mParams.putString(Engine.KEY_PARAM_VOICE_NAME, voice.getName());
                    String str = "";
                    try {
                        str = voice.getLocale().getISO3Language();
                    } catch (MissingResourceException e) {
                        Log.w(TextToSpeech.TAG, "Couldn't retrieve ISO 639-2/T language code for locale: " + voice.getLocale(), e);
                    }
                    String str2 = "";
                    try {
                        str2 = voice.getLocale().getISO3Country();
                    } catch (MissingResourceException e2) {
                        Log.w(TextToSpeech.TAG, "Couldn't retrieve ISO 3166 country code for locale: " + voice.getLocale(), e2);
                    }
                    TextToSpeech.this.mParams.putString("language", str);
                    TextToSpeech.this.mParams.putString("country", str2);
                    TextToSpeech.this.mParams.putString(Engine.KEY_PARAM_VARIANT, voice.getLocale().getVariant());
                }
                return Integer.valueOf(loadVoice);
            }
        }, -2, "setVoice")).intValue();
    }

    public void shutdown() {
        synchronized (this.mStartLock) {
            if (this.mConnectingServiceConnection == null) {
                runActionNoReconnect(new Action<Void>() { // from class: android.speech.tts.TextToSpeech.1
                    @Override // android.speech.tts.TextToSpeech.Action
                    public Void run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                        iTextToSpeechService.setCallback(TextToSpeech.this.getCallerIdentity(), null);
                        iTextToSpeechService.stop(TextToSpeech.this.getCallerIdentity());
                        TextToSpeech.this.mServiceConnection.disconnect();
                        TextToSpeech.this.mServiceConnection = null;
                        TextToSpeech.this.mCurrentEngine = null;
                        return null;
                    }
                }, null, "shutdown", false);
                return;
            }
            this.mContext.unbindService(this.mConnectingServiceConnection);
            this.mConnectingServiceConnection = null;
        }
    }

    public int speak(final CharSequence charSequence, final int i, final Bundle bundle, final String str) {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                Uri uri = (Uri) TextToSpeech.this.mUtterances.get(charSequence);
                return uri != null ? Integer.valueOf(iTextToSpeechService.playAudio(TextToSpeech.this.getCallerIdentity(), uri, i, TextToSpeech.this.getParams(bundle), str)) : Integer.valueOf(iTextToSpeechService.speak(TextToSpeech.this.getCallerIdentity(), charSequence, i, TextToSpeech.this.getParams(bundle), str));
            }
        }, -1, "speak")).intValue();
    }

    @Deprecated
    public int speak(String str, int i, HashMap<String, String> hashMap) {
        return speak(str, i, convertParamsHashMaptoBundle(hashMap), hashMap == null ? null : hashMap.get(Engine.KEY_PARAM_UTTERANCE_ID));
    }

    public int stop() {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                return Integer.valueOf(iTextToSpeechService.stop(TextToSpeech.this.getCallerIdentity()));
            }
        }, -1, "stop")).intValue();
    }

    public int synthesizeToFile(final CharSequence charSequence, final Bundle bundle, final File file, final String str) {
        return ((Integer) runAction(new Action<Integer>() { // from class: android.speech.tts.TextToSpeech.17
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.speech.tts.TextToSpeech.Action
            public Integer run(ITextToSpeechService iTextToSpeechService) throws RemoteException {
                try {
                    if (file.exists() && !file.canWrite()) {
                        Log.e(TextToSpeech.TAG, "Can't write to " + file);
                        return -1;
                    }
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 738197504);
                    int synthesizeToFileDescriptor = iTextToSpeechService.synthesizeToFileDescriptor(TextToSpeech.this.getCallerIdentity(), charSequence, open, TextToSpeech.this.getParams(bundle), str);
                    open.close();
                    return Integer.valueOf(synthesizeToFileDescriptor);
                } catch (FileNotFoundException e) {
                    Log.e(TextToSpeech.TAG, "Opening file " + file + " failed", e);
                    return -1;
                } catch (IOException e2) {
                    Log.e(TextToSpeech.TAG, "Closing file " + file + " failed", e2);
                    return -1;
                }
            }
        }, -1, "synthesizeToFile")).intValue();
    }

    @Deprecated
    public int synthesizeToFile(String str, HashMap<String, String> hashMap, String str2) {
        return synthesizeToFile(str, convertParamsHashMaptoBundle(hashMap), new File(str2), hashMap.get(Engine.KEY_PARAM_UTTERANCE_ID));
    }
}
