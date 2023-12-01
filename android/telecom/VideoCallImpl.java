package android.telecom;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.telecom.InCallService;
import android.view.Surface;
import com.android.internal.os.SomeArgs;
import com.android.internal.telecom.IVideoCallback;
import com.android.internal.telecom.IVideoProvider;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/VideoCallImpl.class */
public class VideoCallImpl extends InCallService.VideoCall {
    private static final int MSG_CHANGE_CALL_DATA_USAGE = 5;
    private static final int MSG_CHANGE_CAMERA_CAPABILITIES = 6;
    private static final int MSG_CHANGE_PEER_DIMENSIONS = 4;
    private static final int MSG_CHANGE_VIDEO_QUALITY = 7;
    private static final int MSG_HANDLE_CALL_SESSION_EVENT = 3;
    private static final int MSG_RECEIVE_SESSION_MODIFY_REQUEST = 1;
    private static final int MSG_RECEIVE_SESSION_MODIFY_RESPONSE = 2;
    private final VideoCallListenerBinder mBinder;
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: android.telecom.VideoCallImpl.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            VideoCallImpl.this.mVideoProvider.asBinder().unlinkToDeath(this, 0);
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: android.telecom.VideoCallImpl.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SomeArgs someArgs;
            if (VideoCallImpl.this.mVideoCallListener == null) {
                return;
            }
            switch (message.what) {
                case 1:
                    VideoCallImpl.this.mVideoCallListener.onSessionModifyRequestReceived((VideoProfile) message.obj);
                    return;
                case 2:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        VideoCallImpl.this.mVideoCallListener.onSessionModifyResponseReceived(((Integer) someArgs.arg1).intValue(), (VideoProfile) someArgs.arg2, (VideoProfile) someArgs.arg3);
                        return;
                    } finally {
                    }
                case 3:
                    VideoCallImpl.this.mVideoCallListener.onCallSessionEvent(((Integer) message.obj).intValue());
                    return;
                case 4:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        VideoCallImpl.this.mVideoCallListener.onPeerDimensionsChanged(((Integer) someArgs.arg1).intValue(), ((Integer) someArgs.arg2).intValue());
                        return;
                    } finally {
                    }
                case 5:
                    VideoCallImpl.this.mVideoCallListener.onCallDataUsageChanged(message.arg1);
                    return;
                case 6:
                    VideoCallImpl.this.mVideoCallListener.onCameraCapabilitiesChanged((CameraCapabilities) message.obj);
                    return;
                case 7:
                    VideoCallImpl.this.mVideoCallListener.onVideoQualityChanged(message.arg1);
                    return;
                default:
                    return;
            }
        }
    };
    private InCallService.VideoCall.Listener mVideoCallListener;
    private final IVideoProvider mVideoProvider;

    /* loaded from: source-9557208-dex2jar.jar:android/telecom/VideoCallImpl$VideoCallListenerBinder.class */
    private final class VideoCallListenerBinder extends IVideoCallback.Stub {
        private VideoCallListenerBinder() {
        }

        public void changeCallDataUsage(int i) {
            VideoCallImpl.this.mHandler.obtainMessage(5, Integer.valueOf(i)).sendToTarget();
        }

        public void changeCameraCapabilities(CameraCapabilities cameraCapabilities) {
            VideoCallImpl.this.mHandler.obtainMessage(6, cameraCapabilities).sendToTarget();
        }

        public void changePeerDimensions(int i, int i2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = Integer.valueOf(i);
            obtain.arg2 = Integer.valueOf(i2);
            VideoCallImpl.this.mHandler.obtainMessage(4, obtain).sendToTarget();
        }

        public void changeVideoQuality(int i) {
            VideoCallImpl.this.mHandler.obtainMessage(7, i, 0).sendToTarget();
        }

        public void handleCallSessionEvent(int i) {
            VideoCallImpl.this.mHandler.obtainMessage(3, Integer.valueOf(i)).sendToTarget();
        }

        public void receiveSessionModifyRequest(VideoProfile videoProfile) {
            VideoCallImpl.this.mHandler.obtainMessage(1, videoProfile).sendToTarget();
        }

        public void receiveSessionModifyResponse(int i, VideoProfile videoProfile, VideoProfile videoProfile2) {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = Integer.valueOf(i);
            obtain.arg2 = videoProfile;
            obtain.arg3 = videoProfile2;
            VideoCallImpl.this.mHandler.obtainMessage(2, obtain).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoCallImpl(IVideoProvider iVideoProvider) throws RemoteException {
        this.mVideoProvider = iVideoProvider;
        this.mVideoProvider.asBinder().linkToDeath(this.mDeathRecipient, 0);
        this.mBinder = new VideoCallListenerBinder();
        this.mVideoProvider.setVideoCallback(this.mBinder);
    }

    @Override // android.telecom.InCallService.VideoCall
    public void requestCallDataUsage() {
        try {
            this.mVideoProvider.requestCallDataUsage();
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void requestCameraCapabilities() {
        try {
            this.mVideoProvider.requestCameraCapabilities();
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void sendSessionModifyRequest(VideoProfile videoProfile) {
        try {
            this.mVideoProvider.sendSessionModifyRequest(videoProfile);
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void sendSessionModifyResponse(VideoProfile videoProfile) {
        try {
            this.mVideoProvider.sendSessionModifyResponse(videoProfile);
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void setCamera(String str) {
        try {
            this.mVideoProvider.setCamera(str);
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void setDeviceOrientation(int i) {
        try {
            this.mVideoProvider.setDeviceOrientation(i);
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void setDisplaySurface(Surface surface) {
        try {
            this.mVideoProvider.setDisplaySurface(surface);
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void setPauseImage(String str) {
        try {
            this.mVideoProvider.setPauseImage(str);
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void setPreviewSurface(Surface surface) {
        try {
            this.mVideoProvider.setPreviewSurface(surface);
        } catch (RemoteException e) {
        }
    }

    @Override // android.telecom.InCallService.VideoCall
    public void setVideoCallListener(InCallService.VideoCall.Listener listener) {
        this.mVideoCallListener = listener;
    }

    @Override // android.telecom.InCallService.VideoCall
    public void setZoom(float f) {
        try {
            this.mVideoProvider.setZoom(f);
        } catch (RemoteException e) {
        }
    }
}
