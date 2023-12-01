package android.telecom;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.android.internal.os.SomeArgs;
import com.android.internal.telecom.IVideoCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/telecom/VideoCallbackServant.class */
public final class VideoCallbackServant {
    private static final int MSG_CHANGE_CALL_DATA_USAGE = 4;
    private static final int MSG_CHANGE_CAMERA_CAPABILITIES = 5;
    private static final int MSG_CHANGE_PEER_DIMENSIONS = 3;
    private static final int MSG_CHANGE_VIDEO_QUALITY = 6;
    private static final int MSG_HANDLE_CALL_SESSION_EVENT = 2;
    private static final int MSG_RECEIVE_SESSION_MODIFY_REQUEST = 0;
    private static final int MSG_RECEIVE_SESSION_MODIFY_RESPONSE = 1;
    private final IVideoCallback mDelegate;
    private final Handler mHandler = new Handler() { // from class: android.telecom.VideoCallbackServant.1
        private void internalHandleMessage(Message message) throws RemoteException {
            SomeArgs someArgs;
            switch (message.what) {
                case 0:
                    VideoCallbackServant.this.mDelegate.receiveSessionModifyRequest((VideoProfile) message.obj);
                    return;
                case 1:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        VideoCallbackServant.this.mDelegate.receiveSessionModifyResponse(someArgs.argi1, (VideoProfile) someArgs.arg1, (VideoProfile) someArgs.arg2);
                        return;
                    } finally {
                    }
                case 2:
                    try {
                        VideoCallbackServant.this.mDelegate.handleCallSessionEvent(((SomeArgs) message.obj).argi1);
                        return;
                    } finally {
                    }
                case 3:
                    someArgs = (SomeArgs) message.obj;
                    try {
                        VideoCallbackServant.this.mDelegate.changePeerDimensions(someArgs.argi1, someArgs.argi2);
                        return;
                    } finally {
                    }
                case 4:
                    try {
                        VideoCallbackServant.this.mDelegate.changeCallDataUsage(((SomeArgs) message.obj).argi1);
                        return;
                    } finally {
                    }
                case 5:
                    VideoCallbackServant.this.mDelegate.changeCameraCapabilities((CameraCapabilities) message.obj);
                    return;
                case 6:
                    VideoCallbackServant.this.mDelegate.changeVideoQuality(message.arg1);
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                internalHandleMessage(message);
            } catch (RemoteException e) {
            }
        }
    };
    private final IVideoCallback mStub = new IVideoCallback.Stub() { // from class: android.telecom.VideoCallbackServant.2
        public void changeCallDataUsage(int i) throws RemoteException {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.argi1 = i;
            VideoCallbackServant.this.mHandler.obtainMessage(4, obtain).sendToTarget();
        }

        public void changeCameraCapabilities(CameraCapabilities cameraCapabilities) throws RemoteException {
            VideoCallbackServant.this.mHandler.obtainMessage(5, cameraCapabilities).sendToTarget();
        }

        public void changePeerDimensions(int i, int i2) throws RemoteException {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.argi1 = i;
            obtain.argi2 = i2;
            VideoCallbackServant.this.mHandler.obtainMessage(3, obtain).sendToTarget();
        }

        public void changeVideoQuality(int i) throws RemoteException {
            VideoCallbackServant.this.mHandler.obtainMessage(6, i, 0).sendToTarget();
        }

        public void handleCallSessionEvent(int i) throws RemoteException {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.argi1 = i;
            VideoCallbackServant.this.mHandler.obtainMessage(2, obtain).sendToTarget();
        }

        public void receiveSessionModifyRequest(VideoProfile videoProfile) throws RemoteException {
            VideoCallbackServant.this.mHandler.obtainMessage(0, videoProfile).sendToTarget();
        }

        public void receiveSessionModifyResponse(int i, VideoProfile videoProfile, VideoProfile videoProfile2) throws RemoteException {
            SomeArgs obtain = SomeArgs.obtain();
            obtain.argi1 = i;
            obtain.arg1 = videoProfile;
            obtain.arg2 = videoProfile2;
            VideoCallbackServant.this.mHandler.obtainMessage(1, obtain).sendToTarget();
        }
    };

    public VideoCallbackServant(IVideoCallback iVideoCallback) {
        this.mDelegate = iVideoCallback;
    }

    public IVideoCallback getStub() {
        return this.mStub;
    }
}
