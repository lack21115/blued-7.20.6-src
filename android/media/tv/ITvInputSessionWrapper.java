package android.media.tv;

import android.content.Context;
import android.graphics.Rect;
import android.media.tv.ITvInputSession;
import android.media.tv.TvInputService;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.Surface;
import com.android.internal.os.HandlerCaller;
import com.android.internal.os.SomeArgs;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/ITvInputSessionWrapper.class */
public class ITvInputSessionWrapper extends ITvInputSession.Stub implements HandlerCaller.Callback {
    private static final int DO_APP_PRIVATE_COMMAND = 9;
    private static final int DO_CREATE_OVERLAY_VIEW = 10;
    private static final int DO_DISPATCH_SURFACE_CHANGED = 4;
    private static final int DO_RELAYOUT_OVERLAY_VIEW = 11;
    private static final int DO_RELEASE = 1;
    private static final int DO_REMOVE_OVERLAY_VIEW = 12;
    private static final int DO_REQUEST_UNBLOCK_CONTENT = 13;
    private static final int DO_SELECT_TRACK = 8;
    private static final int DO_SET_CAPTION_ENABLED = 7;
    private static final int DO_SET_MAIN = 2;
    private static final int DO_SET_STREAM_VOLUME = 5;
    private static final int DO_SET_SURFACE = 3;
    private static final int DO_TUNE = 6;
    private static final int MESSAGE_HANDLING_DURATION_THRESHOLD_MILLIS = 50;
    private static final int MESSAGE_TUNE_DURATION_THRESHOLD_MILLIS = 2000;
    private static final String TAG = "TvInputSessionWrapper";
    private final HandlerCaller mCaller;
    private InputChannel mChannel;
    private TvInputEventReceiver mReceiver;
    private TvInputService.Session mTvInputSessionImpl;

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/ITvInputSessionWrapper$TvInputEventReceiver.class */
    private final class TvInputEventReceiver extends InputEventReceiver {
        public TvInputEventReceiver(InputChannel inputChannel, Looper looper) {
            super(inputChannel, looper);
        }

        @Override // android.view.InputEventReceiver
        public void onInputEvent(InputEvent inputEvent) {
            boolean z = true;
            if (ITvInputSessionWrapper.this.mTvInputSessionImpl == null) {
                finishInputEvent(inputEvent, false);
                return;
            }
            int dispatchInputEvent = ITvInputSessionWrapper.this.mTvInputSessionImpl.dispatchInputEvent(inputEvent, this);
            if (dispatchInputEvent != -1) {
                if (dispatchInputEvent != 1) {
                    z = false;
                }
                finishInputEvent(inputEvent, z);
            }
        }
    }

    public ITvInputSessionWrapper(Context context, TvInputService.Session session, InputChannel inputChannel) {
        this.mCaller = new HandlerCaller(context, null, this, true);
        this.mTvInputSessionImpl = session;
        this.mChannel = inputChannel;
        if (inputChannel != null) {
            this.mReceiver = new TvInputEventReceiver(inputChannel, context.getMainLooper());
        }
    }

    @Override // android.media.tv.ITvInputSession
    public void appPrivateCommand(String str, Bundle bundle) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(9, str, bundle));
    }

    @Override // android.media.tv.ITvInputSession
    public void createOverlayView(IBinder iBinder, Rect rect) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(10, iBinder, rect));
    }

    @Override // android.media.tv.ITvInputSession
    public void dispatchSurfaceChanged(int i, int i2, int i3) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageIIII(4, i, i2, i3, 0));
    }

    @Override // com.android.internal.os.HandlerCaller.Callback
    public void executeMessage(Message message) {
        if (this.mTvInputSessionImpl == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        switch (message.what) {
            case 1:
                this.mTvInputSessionImpl.release();
                this.mTvInputSessionImpl = null;
                if (this.mReceiver != null) {
                    this.mReceiver.dispose();
                    this.mReceiver = null;
                }
                if (this.mChannel != null) {
                    this.mChannel.dispose();
                    this.mChannel = null;
                    break;
                }
                break;
            case 2:
                this.mTvInputSessionImpl.setMain(((Boolean) message.obj).booleanValue());
                break;
            case 3:
                this.mTvInputSessionImpl.setSurface((Surface) message.obj);
                break;
            case 4:
                SomeArgs someArgs = (SomeArgs) message.obj;
                this.mTvInputSessionImpl.dispatchSurfaceChanged(someArgs.argi1, someArgs.argi2, someArgs.argi3);
                someArgs.recycle();
                break;
            case 5:
                this.mTvInputSessionImpl.setStreamVolume(((Float) message.obj).floatValue());
                break;
            case 6:
                SomeArgs someArgs2 = (SomeArgs) message.obj;
                this.mTvInputSessionImpl.tune((Uri) someArgs2.arg1, (Bundle) someArgs2.arg2);
                someArgs2.recycle();
                break;
            case 7:
                this.mTvInputSessionImpl.setCaptionEnabled(((Boolean) message.obj).booleanValue());
                break;
            case 8:
                SomeArgs someArgs3 = (SomeArgs) message.obj;
                this.mTvInputSessionImpl.selectTrack(((Integer) someArgs3.arg1).intValue(), (String) someArgs3.arg2);
                someArgs3.recycle();
                break;
            case 9:
                SomeArgs someArgs4 = (SomeArgs) message.obj;
                this.mTvInputSessionImpl.appPrivateCommand((String) someArgs4.arg1, (Bundle) someArgs4.arg2);
                someArgs4.recycle();
                break;
            case 10:
                SomeArgs someArgs5 = (SomeArgs) message.obj;
                this.mTvInputSessionImpl.createOverlayView((IBinder) someArgs5.arg1, (Rect) someArgs5.arg2);
                someArgs5.recycle();
                break;
            case 11:
                this.mTvInputSessionImpl.relayoutOverlayView((Rect) message.obj);
                break;
            case 12:
                this.mTvInputSessionImpl.removeOverlayView(true);
                break;
            case 13:
                this.mTvInputSessionImpl.unblockContent((String) message.obj);
                break;
            default:
                Log.w(TAG, "Unhandled message code: " + message.what);
                break;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            Log.w(TAG, "Handling message (" + message.what + ") took too long time (duration=" + currentTimeMillis2 + "ms)");
            if (message.what == 6 && currentTimeMillis2 > 2000) {
                throw new RuntimeException("Too much time to handle tune request. (" + currentTimeMillis2 + "ms > 2000ms) Consider handling the tune request in a separate thread.");
            }
        }
    }

    @Override // android.media.tv.ITvInputSession
    public void relayoutOverlayView(Rect rect) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(11, rect));
    }

    @Override // android.media.tv.ITvInputSession
    public void release() {
        this.mTvInputSessionImpl.scheduleOverlayViewCleanup();
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessage(1));
    }

    @Override // android.media.tv.ITvInputSession
    public void removeOverlayView() {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessage(12));
    }

    @Override // android.media.tv.ITvInputSession
    public void requestUnblockContent(String str) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(13, str));
    }

    @Override // android.media.tv.ITvInputSession
    public void selectTrack(int i, String str) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(8, Integer.valueOf(i), str));
    }

    @Override // android.media.tv.ITvInputSession
    public void setCaptionEnabled(boolean z) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(7, Boolean.valueOf(z)));
    }

    @Override // android.media.tv.ITvInputSession
    public void setMain(boolean z) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(2, Boolean.valueOf(z)));
    }

    @Override // android.media.tv.ITvInputSession
    public void setSurface(Surface surface) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(3, surface));
    }

    @Override // android.media.tv.ITvInputSession
    public final void setVolume(float f) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(5, Float.valueOf(f)));
    }

    @Override // android.media.tv.ITvInputSession
    public void tune(Uri uri, Bundle bundle) {
        this.mCaller.removeMessages(6);
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(6, uri, bundle));
    }
}
