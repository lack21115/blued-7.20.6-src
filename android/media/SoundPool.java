package android.media;

import android.app.ActivityThread;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.AndroidRuntimeException;
import android.util.Log;
import com.android.internal.app.IAppOpsService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/media/SoundPool.class */
public class SoundPool {
    private final SoundPoolDelegate mImpl;

    /* loaded from: source-9557208-dex2jar.jar:android/media/SoundPool$Builder.class */
    public static class Builder {
        private AudioAttributes mAudioAttributes;
        private int mMaxStreams = 1;

        public SoundPool build() {
            if (this.mAudioAttributes == null) {
                this.mAudioAttributes = new AudioAttributes.Builder().setUsage(1).build();
            }
            return new SoundPool(this.mMaxStreams, this.mAudioAttributes);
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes) throws IllegalArgumentException {
            if (audioAttributes == null) {
                throw new IllegalArgumentException("Invalid null AudioAttributes");
            }
            this.mAudioAttributes = audioAttributes;
            return this;
        }

        public Builder setMaxStreams(int i) throws IllegalArgumentException {
            if (i <= 0) {
                throw new IllegalArgumentException("Strictly positive value required for the maximum number of streams");
            }
            this.mMaxStreams = i;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/SoundPool$OnLoadCompleteListener.class */
    public interface OnLoadCompleteListener {
        void onLoadComplete(SoundPool soundPool, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/SoundPool$SoundPoolDelegate.class */
    public interface SoundPoolDelegate {
        void autoPause();

        void autoResume();

        int load(Context context, int i, int i2);

        int load(AssetFileDescriptor assetFileDescriptor, int i);

        int load(FileDescriptor fileDescriptor, long j, long j2, int i);

        int load(String str, int i);

        void pause(int i);

        int play(int i, float f, float f2, int i2, int i3, float f3);

        void release();

        void resume(int i);

        void setLoop(int i, int i2);

        void setOnLoadCompleteListener(OnLoadCompleteListener onLoadCompleteListener);

        void setPriority(int i, int i2);

        void setRate(int i, float f);

        void setVolume(int i, float f);

        void setVolume(int i, float f, float f2);

        void stop(int i);

        boolean unload(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/SoundPool$SoundPoolImpl.class */
    static class SoundPoolImpl implements SoundPoolDelegate {
        private static final boolean DEBUG = false;
        private static final int SAMPLE_LOADED = 1;
        private static final String TAG = "SoundPool";
        private final IAppOpsService mAppOps;
        private final AudioAttributes mAttributes;
        private EventHandler mEventHandler;
        private final boolean mIsRestricted;
        private final Object mLock;
        private long mNativeContext;
        private OnLoadCompleteListener mOnLoadCompleteListener;
        private SoundPool mProxy;

        /* loaded from: source-9557208-dex2jar.jar:android/media/SoundPool$SoundPoolImpl$EventHandler.class */
        private class EventHandler extends Handler {
            private SoundPool mSoundPool;

            public EventHandler(SoundPool soundPool, Looper looper) {
                super(looper);
                this.mSoundPool = soundPool;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        synchronized (SoundPoolImpl.this.mLock) {
                            if (SoundPoolImpl.this.mOnLoadCompleteListener != null) {
                                SoundPoolImpl.this.mOnLoadCompleteListener.onLoadComplete(this.mSoundPool, message.arg1, message.arg2);
                            }
                        }
                        return;
                    default:
                        Log.e(SoundPoolImpl.TAG, "Unknown message type " + message.what);
                        return;
                }
            }
        }

        static {
            System.loadLibrary("soundpool");
        }

        public SoundPoolImpl(SoundPool soundPool, int i, AudioAttributes audioAttributes) {
            if (native_setup(new WeakReference(this), i, audioAttributes) != 0) {
                throw new RuntimeException("Native setup failed");
            }
            this.mLock = new Object();
            this.mProxy = soundPool;
            this.mAttributes = audioAttributes;
            this.mAppOps = IAppOpsService.Stub.asInterface(ServiceManager.getService(Context.APP_OPS_SERVICE));
            this.mIsRestricted = isRestricted();
        }

        private final native int _load(FileDescriptor fileDescriptor, long j, long j2, int i);

        private final native int _load(String str, int i);

        private final native void _setVolume(int i, float f, float f2);

        private boolean isRestricted() {
            boolean z = false;
            try {
                if (this.mAppOps.checkAudioOperation(28, this.mAttributes.getUsage(), Process.myUid(), ActivityThread.currentPackageName()) != 0) {
                    z = true;
                }
                return z;
            } catch (RemoteException e) {
                return false;
            }
        }

        private final native int native_setup(Object obj, int i, Object obj2);

        private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
            SoundPoolImpl soundPoolImpl = (SoundPoolImpl) ((WeakReference) obj).get();
            if (soundPoolImpl == null || soundPoolImpl.mEventHandler == null) {
                return;
            }
            soundPoolImpl.mEventHandler.sendMessage(soundPoolImpl.mEventHandler.obtainMessage(i, i2, i3, obj2));
        }

        public final native int _play(int i, float f, float f2, int i2, int i3, float f3);

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void autoPause();

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void autoResume();

        protected void finalize() {
            release();
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(Context context, int i, int i2) {
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(i);
            int i3 = 0;
            if (openRawResourceFd != null) {
                i3 = _load(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength(), i2);
                try {
                    openRawResourceFd.close();
                } catch (IOException e) {
                    return i3;
                }
            }
            return i3;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(AssetFileDescriptor assetFileDescriptor, int i) {
            if (assetFileDescriptor != null) {
                long length = assetFileDescriptor.getLength();
                if (length < 0) {
                    throw new AndroidRuntimeException("no length for fd");
                }
                return _load(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), length, i);
            }
            return 0;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(FileDescriptor fileDescriptor, long j, long j2, int i) {
            return _load(fileDescriptor, j, j2, i);
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(String str, int i) {
            int i2;
            if (str.startsWith("http:")) {
                i2 = _load(str, i);
            } else {
                int i3 = 0;
                try {
                    File file = new File(str);
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
                    i2 = 0;
                    if (open != null) {
                        int _load = _load(open.getFileDescriptor(), 0L, file.length(), i);
                        i3 = _load;
                        open.close();
                        return _load;
                    }
                } catch (IOException e) {
                    Log.e(TAG, "error loading " + str);
                    return i3;
                }
            }
            return i2;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void pause(int i);

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final int play(int i, float f, float f2, int i2, int i3, float f3) {
            if (this.mIsRestricted) {
                f2 = 0.0f;
                f = 0.0f;
            }
            return _play(i, f, f2, i2, i3, f3);
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void release();

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void resume(int i);

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void setLoop(int i, int i2);

        @Override // android.media.SoundPool.SoundPoolDelegate
        public void setOnLoadCompleteListener(OnLoadCompleteListener onLoadCompleteListener) {
            synchronized (this.mLock) {
                if (onLoadCompleteListener != null) {
                    Looper myLooper = Looper.myLooper();
                    if (myLooper != null) {
                        this.mEventHandler = new EventHandler(this.mProxy, myLooper);
                    } else {
                        Looper mainLooper = Looper.getMainLooper();
                        if (mainLooper != null) {
                            this.mEventHandler = new EventHandler(this.mProxy, mainLooper);
                        } else {
                            this.mEventHandler = null;
                        }
                    }
                } else {
                    this.mEventHandler = null;
                }
                this.mOnLoadCompleteListener = onLoadCompleteListener;
            }
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void setPriority(int i, int i2);

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void setRate(int i, float f);

        @Override // android.media.SoundPool.SoundPoolDelegate
        public void setVolume(int i, float f) {
            setVolume(i, f, f);
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void setVolume(int i, float f, float f2) {
            if (this.mIsRestricted) {
                return;
            }
            _setVolume(i, f, f2);
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native void stop(int i);

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final native boolean unload(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/SoundPool$SoundPoolStub.class */
    static class SoundPoolStub implements SoundPoolDelegate {
        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void autoPause() {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void autoResume() {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(Context context, int i, int i2) {
            return 0;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(AssetFileDescriptor assetFileDescriptor, int i) {
            return 0;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(FileDescriptor fileDescriptor, long j, long j2, int i) {
            return 0;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public int load(String str, int i) {
            return 0;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void pause(int i) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final int play(int i, float f, float f2, int i2, int i3, float f3) {
            return 0;
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void release() {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void resume(int i) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void setLoop(int i, int i2) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public void setOnLoadCompleteListener(OnLoadCompleteListener onLoadCompleteListener) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void setPriority(int i, int i2) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void setRate(int i, float f) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public void setVolume(int i, float f) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void setVolume(int i, float f, float f2) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final void stop(int i) {
        }

        @Override // android.media.SoundPool.SoundPoolDelegate
        public final boolean unload(int i) {
            return true;
        }
    }

    public SoundPool(int i, int i2, int i3) {
        this(i, new AudioAttributes.Builder().setInternalLegacyStreamType(i2).build());
    }

    private SoundPool(int i, AudioAttributes audioAttributes) {
        if (SystemProperties.getBoolean("config.disable_media", false)) {
            this.mImpl = new SoundPoolStub();
        } else {
            this.mImpl = new SoundPoolImpl(this, i, audioAttributes);
        }
    }

    public final void autoPause() {
        this.mImpl.autoPause();
    }

    public final void autoResume() {
        this.mImpl.autoResume();
    }

    public int load(Context context, int i, int i2) {
        return this.mImpl.load(context, i, i2);
    }

    public int load(AssetFileDescriptor assetFileDescriptor, int i) {
        return this.mImpl.load(assetFileDescriptor, i);
    }

    public int load(FileDescriptor fileDescriptor, long j, long j2, int i) {
        return this.mImpl.load(fileDescriptor, j, j2, i);
    }

    public int load(String str, int i) {
        return this.mImpl.load(str, i);
    }

    public final void pause(int i) {
        this.mImpl.pause(i);
    }

    public final int play(int i, float f, float f2, int i2, int i3, float f3) {
        return this.mImpl.play(i, f, f2, i2, i3, f3);
    }

    public final void release() {
        this.mImpl.release();
    }

    public final void resume(int i) {
        this.mImpl.resume(i);
    }

    public final void setLoop(int i, int i2) {
        this.mImpl.setLoop(i, i2);
    }

    public void setOnLoadCompleteListener(OnLoadCompleteListener onLoadCompleteListener) {
        this.mImpl.setOnLoadCompleteListener(onLoadCompleteListener);
    }

    public final void setPriority(int i, int i2) {
        this.mImpl.setPriority(i, i2);
    }

    public final void setRate(int i, float f) {
        this.mImpl.setRate(i, f);
    }

    public void setVolume(int i, float f) {
        setVolume(i, f, f);
    }

    public final void setVolume(int i, float f, float f2) {
        this.mImpl.setVolume(i, f, f2);
    }

    public final void stop(int i) {
        this.mImpl.stop(i);
    }

    public final boolean unload(int i) {
        return this.mImpl.unload(i);
    }
}
