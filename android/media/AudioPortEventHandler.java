package android.media;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/AudioPortEventHandler.class */
public class AudioPortEventHandler {
    private static final int AUDIOPORT_EVENT_NEW_LISTENER = 4;
    private static final int AUDIOPORT_EVENT_PATCH_LIST_UPDATED = 2;
    private static final int AUDIOPORT_EVENT_PORT_LIST_UPDATED = 1;
    private static final int AUDIOPORT_EVENT_SERVICE_DIED = 3;
    private static final String TAG = "AudioPortEventHandler";
    private Handler mHandler;
    private final ArrayList<AudioManager.OnAudioPortUpdateListener> mListeners = new ArrayList<>();

    private native void native_finalize();

    private native void native_setup(Object obj);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        Handler handler;
        AudioPortEventHandler audioPortEventHandler = (AudioPortEventHandler) ((WeakReference) obj).get();
        if (audioPortEventHandler == null || audioPortEventHandler == null || (handler = audioPortEventHandler.handler()) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(i, i2, i3, obj2));
    }

    protected void finalize() {
        native_finalize();
    }

    Handler handler() {
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        synchronized (this) {
            if (this.mHandler != null) {
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mHandler = new Handler(mainLooper) { // from class: android.media.AudioPortEventHandler.1
                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        ArrayList arrayList;
                        synchronized (this) {
                            if (message.what == 4) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList = arrayList2;
                                if (AudioPortEventHandler.this.mListeners.contains(message.obj)) {
                                    arrayList2.add((AudioManager.OnAudioPortUpdateListener) message.obj);
                                    arrayList = arrayList2;
                                }
                            } else {
                                arrayList = AudioPortEventHandler.this.mListeners;
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        if (message.what == 1 || message.what == 2 || message.what == 3) {
                            AudioManager.resetAudioPortGeneration();
                        }
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        if (message.what != 3 && AudioManager.updateAudioPortCache(arrayList3, arrayList4) != 0) {
                            return;
                        }
                        switch (message.what) {
                            case 1:
                            case 4:
                                AudioPort[] audioPortArr = (AudioPort[]) arrayList3.toArray(new AudioPort[0]);
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 < arrayList.size()) {
                                        ((AudioManager.OnAudioPortUpdateListener) arrayList.get(i2)).onAudioPortListUpdate(audioPortArr);
                                        i = i2 + 1;
                                    } else if (message.what == 1) {
                                        return;
                                    }
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= arrayList.size()) {
                                        return;
                                    }
                                    ((AudioManager.OnAudioPortUpdateListener) arrayList.get(i4)).onServiceDied();
                                    i3 = i4 + 1;
                                }
                            default:
                                return;
                        }
                        AudioPatch[] audioPatchArr = (AudioPatch[]) arrayList4.toArray(new AudioPatch[0]);
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= arrayList.size()) {
                                return;
                            }
                            ((AudioManager.OnAudioPortUpdateListener) arrayList.get(i6)).onAudioPatchListUpdate(audioPatchArr);
                            i5 = i6 + 1;
                        }
                    }
                };
                native_setup(new WeakReference(this));
            } else {
                this.mHandler = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerListener(AudioManager.OnAudioPortUpdateListener onAudioPortUpdateListener) {
        synchronized (this) {
            this.mListeners.add(onAudioPortUpdateListener);
        }
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(4, 0, 0, onAudioPortUpdateListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterListener(AudioManager.OnAudioPortUpdateListener onAudioPortUpdateListener) {
        synchronized (this) {
            this.mListeners.remove(onAudioPortUpdateListener);
        }
    }
}
