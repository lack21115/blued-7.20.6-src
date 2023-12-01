package android.telecom;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.android.internal.os.SomeArgs;
import com.android.internal.telecom.IInCallAdapter;
import com.android.internal.telecom.IInCallService;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/InCallService.class */
public abstract class InCallService extends Service {
    private static final int MSG_ADD_CALL = 2;
    private static final int MSG_BRING_TO_FOREGROUND = 6;
    private static final int MSG_ON_AUDIO_STATE_CHANGED = 5;
    private static final int MSG_ON_CAN_ADD_CALL_CHANGED = 7;
    private static final int MSG_SET_IN_CALL_ADAPTER = 1;
    private static final int MSG_SET_POST_DIAL_WAIT = 4;
    private static final int MSG_UPDATE_CALL = 3;
    public static final String SERVICE_INTERFACE = "android.telecom.InCallService";
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: android.telecom.InCallService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = true;
            if (InCallService.this.mPhone != null || message.what == 1) {
                switch (message.what) {
                    case 1:
                        InCallService.this.mPhone = new Phone(new InCallAdapter((IInCallAdapter) message.obj));
                        InCallService.this.onPhoneCreated(InCallService.this.mPhone);
                        return;
                    case 2:
                        InCallService.this.mPhone.internalAddCall((ParcelableCall) message.obj);
                        return;
                    case 3:
                        InCallService.this.mPhone.internalUpdateCall((ParcelableCall) message.obj);
                        return;
                    case 4:
                        SomeArgs someArgs = (SomeArgs) message.obj;
                        try {
                            InCallService.this.mPhone.internalSetPostDialWait((String) someArgs.arg1, (String) someArgs.arg2);
                            return;
                        } finally {
                            someArgs.recycle();
                        }
                    case 5:
                        InCallService.this.mPhone.internalAudioStateChanged((AudioState) message.obj);
                        return;
                    case 6:
                        Phone phone = InCallService.this.mPhone;
                        if (message.arg1 != 1) {
                            z = false;
                        }
                        phone.internalBringToForeground(z);
                        return;
                    case 7:
                        InCallService.this.mPhone.internalSetCanAddCall(message.arg1 == 1);
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private Phone mPhone;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/InCallService$InCallServiceBinder.class */
    private final class InCallServiceBinder extends IInCallService.Stub {
        private InCallServiceBinder() {
        }

        @Override // com.android.internal.telecom.IInCallService
        public void addCall(ParcelableCall parcelableCall) {
            InCallService.this.mHandler.obtainMessage(2, parcelableCall).sendToTarget();
        }

        @Override // com.android.internal.telecom.IInCallService
        public void bringToForeground(boolean z) {
            InCallService.this.mHandler.obtainMessage(6, z ? 1 : 0, 0).sendToTarget();
        }

        @Override // com.android.internal.telecom.IInCallService
        public void onAudioStateChanged(AudioState audioState) {
            InCallService.this.mHandler.obtainMessage(5, audioState).sendToTarget();
        }

        @Override // com.android.internal.telecom.IInCallService
        public void onCanAddCallChanged(boolean z) {
            InCallService.this.mHandler.obtainMessage(7, z ? 1 : 0, 0).sendToTarget();
        }

        @Override // com.android.internal.telecom.IInCallService
        public void setInCallAdapter(IInCallAdapter iInCallAdapter) {
            InCallService.this.mHandler.obtainMessage(1, iInCallAdapter).sendToTarget();
        }

        @Override // com.android.internal.telecom.IInCallService
        public void setPostDial(String str, String str2) {
        }

        @Override // com.android.internal.telecom.IInCallService
        public void setPostDialWait(String str, String str2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = str;
            obtain.arg2 = str2;
            InCallService.this.mHandler.obtainMessage(4, obtain).sendToTarget();
        }

        @Override // com.android.internal.telecom.IInCallService
        public void updateCall(ParcelableCall parcelableCall) {
            InCallService.this.mHandler.obtainMessage(3, parcelableCall).sendToTarget();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/InCallService$VideoCall.class */
    public static abstract class VideoCall {

        /* loaded from: source-9557208-dex2jar.jar:android/telecom/InCallService$VideoCall$Listener.class */
        public static abstract class Listener {
            public abstract void onCallDataUsageChanged(int i);

            public abstract void onCallSessionEvent(int i);

            public abstract void onCameraCapabilitiesChanged(CameraCapabilities cameraCapabilities);

            public abstract void onPeerDimensionsChanged(int i, int i2);

            public abstract void onSessionModifyRequestReceived(VideoProfile videoProfile);

            public abstract void onSessionModifyResponseReceived(int i, VideoProfile videoProfile, VideoProfile videoProfile2);

            public abstract void onVideoQualityChanged(int i);
        }

        public abstract void requestCallDataUsage();

        public abstract void requestCameraCapabilities();

        public abstract void sendSessionModifyRequest(VideoProfile videoProfile);

        public abstract void sendSessionModifyResponse(VideoProfile videoProfile);

        public abstract void setCamera(String str);

        public abstract void setDeviceOrientation(int i);

        public abstract void setDisplaySurface(Surface surface);

        public abstract void setPauseImage(String str);

        public abstract void setPreviewSurface(Surface surface);

        public abstract void setVideoCallListener(Listener listener);

        public abstract void setZoom(float f);
    }

    public Phone getPhone() {
        return this.mPhone;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new InCallServiceBinder();
    }

    public void onPhoneCreated(Phone phone) {
    }

    public void onPhoneDestroyed(Phone phone) {
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (this.mPhone != null) {
            Phone phone = this.mPhone;
            this.mPhone = null;
            phone.destroy();
            onPhoneDestroyed(phone);
            return false;
        }
        return false;
    }
}
