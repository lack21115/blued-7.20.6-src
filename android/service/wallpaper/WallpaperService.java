package android.service.wallpaper;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.service.wallpaper.IWallpaperEngine;
import android.service.wallpaper.IWallpaperService;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.IWindowSession;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import com.android.internal.os.HandlerCaller;
import com.android.internal.view.BaseIWindow;
import com.android.internal.view.BaseSurfaceHolder;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/service/wallpaper/WallpaperService.class */
public abstract class WallpaperService extends Service {
    static final boolean DEBUG = false;
    private static final int DO_ATTACH = 10;
    private static final int DO_DETACH = 20;
    private static final int DO_SET_DESIRED_SIZE = 30;
    private static final int DO_SET_DISPLAY_PADDING = 40;
    private static final int MSG_TOUCH_EVENT = 10040;
    private static final int MSG_UPDATE_SURFACE = 10000;
    private static final int MSG_VISIBILITY_CHANGED = 10010;
    private static final int MSG_WALLPAPER_COMMAND = 10025;
    private static final int MSG_WALLPAPER_OFFSETS = 10020;
    private static final int MSG_WINDOW_MOVED = 10035;
    private static final int MSG_WINDOW_RESIZED = 10030;
    public static final String SERVICE_INTERFACE = "android.service.wallpaper.WallpaperService";
    public static final String SERVICE_META_DATA = "android.service.wallpaper";
    static final String TAG = "WallpaperService";
    private final ArrayList<Engine> mActiveEngines = new ArrayList<>();

    /* loaded from: source-9557208-dex2jar.jar:android/service/wallpaper/WallpaperService$Engine.class */
    public class Engine {
        HandlerCaller mCaller;
        IWallpaperConnection mConnection;
        boolean mCreated;
        int mCurHeight;
        int mCurWidth;
        boolean mDestroyed;
        Display mDisplay;
        DisplayManager mDisplayManager;
        boolean mDrawingAllowed;
        boolean mFixedSizeAllowed;
        int mFormat;
        int mHeight;
        IWallpaperEngineWrapper mIWallpaperEngine;
        InputChannel mInputChannel;
        WallpaperInputEventReceiver mInputEventReceiver;
        private boolean mIsCircularEmulator;
        boolean mIsCreating;
        private boolean mIsEmulator;
        boolean mOffsetMessageEnqueued;
        boolean mOffsetsChanged;
        TypedValue mOutsetBottom;
        MotionEvent mPendingMove;
        boolean mPendingSync;
        float mPendingXOffset;
        float mPendingXOffsetStep;
        float mPendingYOffset;
        float mPendingYOffsetStep;
        boolean mReportedVisible;
        IWindowSession mSession;
        boolean mSurfaceCreated;
        int mType;
        boolean mVisible;
        int mWidth;
        private boolean mWindowIsRound;
        IBinder mWindowToken;
        boolean mInitializing = true;
        int mWindowFlags = 16;
        int mWindowPrivateFlags = 4;
        int mCurWindowFlags = this.mWindowFlags;
        int mCurWindowPrivateFlags = this.mWindowPrivateFlags;
        final Rect mVisibleInsets = new Rect();
        final Rect mWinFrame = new Rect();
        final Rect mOverscanInsets = new Rect();
        final Rect mContentInsets = new Rect();
        final Rect mStableInsets = new Rect();
        final Rect mDispatchedOverscanInsets = new Rect();
        final Rect mDispatchedContentInsets = new Rect();
        final Rect mDispatchedStableInsets = new Rect();
        final Rect mFinalSystemInsets = new Rect();
        final Rect mFinalStableInsets = new Rect();
        final Configuration mConfiguration = new Configuration();
        final WindowManager.LayoutParams mLayout = new WindowManager.LayoutParams();
        final Object mLock = new Object();
        final BaseSurfaceHolder mSurfaceHolder = new BaseSurfaceHolder() { // from class: android.service.wallpaper.WallpaperService.Engine.1
            {
                this.mRequestedFormat = 2;
            }

            public boolean isCreating() {
                return Engine.this.mIsCreating;
            }

            public boolean onAllowLockCanvas() {
                return Engine.this.mDrawingAllowed;
            }

            public void onRelayoutContainer() {
                Engine.this.mCaller.sendMessage(Engine.this.mCaller.obtainMessage(10000));
            }

            public void onUpdateSurface() {
                Engine.this.mCaller.sendMessage(Engine.this.mCaller.obtainMessage(10000));
            }

            public void setFixedSize(int i, int i2) {
                if (!Engine.this.mFixedSizeAllowed) {
                    throw new UnsupportedOperationException("Wallpapers currently only support sizing from layout");
                }
                super.setFixedSize(i, i2);
            }

            public void setKeepScreenOn(boolean z) {
                throw new UnsupportedOperationException("Wallpapers do not support keep screen on");
            }
        };
        final BaseIWindow mWindow = new BaseIWindow() { // from class: android.service.wallpaper.WallpaperService.Engine.2
            public void dispatchAppVisibility(boolean z) {
                if (Engine.this.mIWallpaperEngine.mIsPreview) {
                    return;
                }
                Engine.this.mCaller.sendMessage(Engine.this.mCaller.obtainMessageI(10010, z ? 1 : 0));
            }

            public void dispatchWallpaperCommand(String str, int i, int i2, int i3, Bundle bundle, boolean z) {
                synchronized (Engine.this.mLock) {
                    WallpaperCommand wallpaperCommand = new WallpaperCommand();
                    wallpaperCommand.action = str;
                    wallpaperCommand.x = i;
                    wallpaperCommand.y = i2;
                    wallpaperCommand.z = i3;
                    wallpaperCommand.extras = bundle;
                    wallpaperCommand.sync = z;
                    Message obtainMessage = Engine.this.mCaller.obtainMessage((int) WallpaperService.MSG_WALLPAPER_COMMAND);
                    obtainMessage.obj = wallpaperCommand;
                    Engine.this.mCaller.sendMessage(obtainMessage);
                }
            }

            public void dispatchWallpaperOffsets(float f, float f2, float f3, float f4, boolean z) {
                synchronized (Engine.this.mLock) {
                    Engine.this.mPendingXOffset = f;
                    Engine.this.mPendingYOffset = f2;
                    Engine.this.mPendingXOffsetStep = f3;
                    Engine.this.mPendingYOffsetStep = f4;
                    if (z) {
                        Engine.this.mPendingSync = true;
                    }
                    if (!Engine.this.mOffsetMessageEnqueued) {
                        Engine.this.mOffsetMessageEnqueued = true;
                        Engine.this.mCaller.sendMessage(Engine.this.mCaller.obtainMessage((int) WallpaperService.MSG_WALLPAPER_OFFSETS));
                    }
                }
            }

            public void moved(int i, int i2) {
                Engine.this.mCaller.sendMessage(Engine.this.mCaller.obtainMessageII((int) WallpaperService.MSG_WINDOW_MOVED, i, i2));
            }

            public void resized(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5, boolean z, Configuration configuration) {
                Engine.this.mCaller.sendMessage(Engine.this.mCaller.obtainMessageI((int) WallpaperService.MSG_WINDOW_RESIZED, z ? 1 : 0));
            }
        };
        private final DisplayManager.DisplayListener mDisplayListener = new DisplayManager.DisplayListener() { // from class: android.service.wallpaper.WallpaperService.Engine.3
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i) {
                if (Engine.this.mDisplay.getDisplayId() == i) {
                    Engine.this.reportVisibility();
                }
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i) {
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-9557208-dex2jar.jar:android/service/wallpaper/WallpaperService$Engine$WallpaperInputEventReceiver.class */
        public final class WallpaperInputEventReceiver extends InputEventReceiver {
            public WallpaperInputEventReceiver(InputChannel inputChannel, Looper looper) {
                super(inputChannel, looper);
            }

            @Override // android.view.InputEventReceiver
            public void onInputEvent(InputEvent inputEvent) {
                boolean z = false;
                try {
                    if (inputEvent instanceof MotionEvent) {
                        z = false;
                        if ((inputEvent.getSource() & 2) != 0) {
                            Engine.this.dispatchPointer(MotionEvent.obtainNoHistory((MotionEvent) inputEvent));
                            z = true;
                        }
                    }
                    finishInputEvent(inputEvent, z);
                } catch (Throwable th) {
                    finishInputEvent(inputEvent, false);
                    throw th;
                }
            }
        }

        public Engine() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispatchPointer(MotionEvent motionEvent) {
            if (!motionEvent.isTouchEvent()) {
                motionEvent.recycle();
                return;
            }
            synchronized (this.mLock) {
                if (motionEvent.getAction() == 2) {
                    this.mPendingMove = motionEvent;
                } else {
                    this.mPendingMove = null;
                }
            }
            this.mCaller.sendMessage(this.mCaller.obtainMessageO((int) WallpaperService.MSG_TOUCH_EVENT, motionEvent));
        }

        void attach(IWallpaperEngineWrapper iWallpaperEngineWrapper) {
            if (this.mDestroyed) {
                return;
            }
            this.mIWallpaperEngine = iWallpaperEngineWrapper;
            this.mCaller = iWallpaperEngineWrapper.mCaller;
            this.mConnection = iWallpaperEngineWrapper.mConnection;
            this.mWindowToken = iWallpaperEngineWrapper.mWindowToken;
            this.mSurfaceHolder.setSizeFromLayout();
            this.mInitializing = true;
            this.mSession = WindowManagerGlobal.getWindowSession();
            this.mWindow.setSession(this.mSession);
            this.mDisplayManager = (DisplayManager) WallpaperService.this.getSystemService("display");
            this.mDisplayManager.registerDisplayListener(this.mDisplayListener, this.mCaller.getHandler());
            this.mDisplay = this.mDisplayManager.getDisplay(0);
            onCreate(this.mSurfaceHolder);
            this.mInitializing = false;
            this.mReportedVisible = false;
            updateSurface(false, false, false);
        }

        void detach() {
            if (this.mDestroyed) {
                return;
            }
            this.mDestroyed = true;
            if (this.mDisplayManager != null) {
                this.mDisplayManager.unregisterDisplayListener(this.mDisplayListener);
            }
            if (this.mVisible) {
                this.mVisible = false;
                onVisibilityChanged(false);
            }
            reportSurfaceDestroyed();
            onDestroy();
            if (this.mCreated) {
                try {
                    if (this.mInputEventReceiver != null) {
                        this.mInputEventReceiver.dispose();
                        this.mInputEventReceiver = null;
                    }
                    this.mSession.remove(this.mWindow);
                } catch (RemoteException e) {
                }
                this.mSurfaceHolder.mSurface.release();
                this.mCreated = false;
                if (this.mInputChannel != null) {
                    this.mInputChannel.dispose();
                    this.mInputChannel = null;
                }
            }
        }

        void doCommand(WallpaperCommand wallpaperCommand) {
            Bundle onCommand = !this.mDestroyed ? onCommand(wallpaperCommand.action, wallpaperCommand.x, wallpaperCommand.y, wallpaperCommand.z, wallpaperCommand.extras, wallpaperCommand.sync) : null;
            if (wallpaperCommand.sync) {
                try {
                    this.mSession.wallpaperCommandComplete(this.mWindow.asBinder(), onCommand);
                } catch (RemoteException e) {
                }
            }
        }

        void doDesiredSizeChanged(int i, int i2) {
            if (this.mDestroyed) {
                return;
            }
            this.mIWallpaperEngine.mReqWidth = i;
            this.mIWallpaperEngine.mReqHeight = i2;
            onDesiredSizeChanged(i, i2);
            doOffsetsChanged(true);
        }

        void doDisplayPaddingChanged(Rect rect) {
            if (this.mDestroyed || this.mIWallpaperEngine.mDisplayPadding.equals(rect)) {
                return;
            }
            this.mIWallpaperEngine.mDisplayPadding.set(rect);
            updateSurface(true, false, false);
        }

        void doOffsetsChanged(boolean z) {
            float f;
            float f2;
            float f3;
            float f4;
            boolean z2;
            if (this.mDestroyed) {
                return;
            }
            if (z || this.mOffsetsChanged) {
                synchronized (this.mLock) {
                    f = this.mPendingXOffset;
                    f2 = this.mPendingYOffset;
                    f3 = this.mPendingXOffsetStep;
                    f4 = this.mPendingYOffsetStep;
                    z2 = this.mPendingSync;
                    this.mPendingSync = false;
                    this.mOffsetMessageEnqueued = false;
                }
                if (this.mSurfaceCreated) {
                    if (this.mReportedVisible) {
                        int i = this.mIWallpaperEngine.mReqWidth - this.mCurWidth;
                        int i2 = i > 0 ? -((int) ((i * f) + 0.5f)) : 0;
                        int i3 = this.mIWallpaperEngine.mReqHeight - this.mCurHeight;
                        onOffsetsChanged(f, f2, f3, f4, i2, i3 > 0 ? -((int) ((i3 * f2) + 0.5f)) : 0);
                    } else {
                        this.mOffsetsChanged = true;
                    }
                }
                if (z2) {
                    try {
                        this.mSession.wallpaperOffsetsComplete(this.mWindow.asBinder());
                    } catch (RemoteException e) {
                    }
                }
            }
        }

        void doVisibilityChanged(boolean z) {
            if (this.mDestroyed) {
                return;
            }
            this.mVisible = z;
            reportVisibility();
        }

        protected void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mInitializing=");
            printWriter.print(this.mInitializing);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.mDestroyed);
            printWriter.print(str);
            printWriter.print("mVisible=");
            printWriter.print(this.mVisible);
            printWriter.print(" mReportedVisible=");
            printWriter.println(this.mReportedVisible);
            printWriter.print(str);
            printWriter.print("mDisplay=");
            printWriter.println(this.mDisplay);
            printWriter.print(str);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mSurfaceCreated=");
            printWriter.print(this.mSurfaceCreated);
            printWriter.print(" mIsCreating=");
            printWriter.print(this.mIsCreating);
            printWriter.print(" mDrawingAllowed=");
            printWriter.println(this.mDrawingAllowed);
            printWriter.print(str);
            printWriter.print("mWidth=");
            printWriter.print(this.mWidth);
            printWriter.print(" mCurWidth=");
            printWriter.print(this.mCurWidth);
            printWriter.print(" mHeight=");
            printWriter.print(this.mHeight);
            printWriter.print(" mCurHeight=");
            printWriter.println(this.mCurHeight);
            printWriter.print(str);
            printWriter.print("mType=");
            printWriter.print(this.mType);
            printWriter.print(" mWindowFlags=");
            printWriter.print(this.mWindowFlags);
            printWriter.print(" mCurWindowFlags=");
            printWriter.println(this.mCurWindowFlags);
            printWriter.print(str);
            printWriter.print("mWindowPrivateFlags=");
            printWriter.print(this.mWindowPrivateFlags);
            printWriter.print(" mCurWindowPrivateFlags=");
            printWriter.println(this.mCurWindowPrivateFlags);
            printWriter.print(str);
            printWriter.print("mVisibleInsets=");
            printWriter.print(this.mVisibleInsets.toShortString());
            printWriter.print(" mWinFrame=");
            printWriter.print(this.mWinFrame.toShortString());
            printWriter.print(" mContentInsets=");
            printWriter.println(this.mContentInsets.toShortString());
            printWriter.print(str);
            printWriter.print("mConfiguration=");
            printWriter.println(this.mConfiguration);
            printWriter.print(str);
            printWriter.print("mLayout=");
            printWriter.println(this.mLayout);
            synchronized (this.mLock) {
                printWriter.print(str);
                printWriter.print("mPendingXOffset=");
                printWriter.print(this.mPendingXOffset);
                printWriter.print(" mPendingXOffset=");
                printWriter.println(this.mPendingXOffset);
                printWriter.print(str);
                printWriter.print("mPendingXOffsetStep=");
                printWriter.print(this.mPendingXOffsetStep);
                printWriter.print(" mPendingXOffsetStep=");
                printWriter.println(this.mPendingXOffsetStep);
                printWriter.print(str);
                printWriter.print("mOffsetMessageEnqueued=");
                printWriter.print(this.mOffsetMessageEnqueued);
                printWriter.print(" mPendingSync=");
                printWriter.println(this.mPendingSync);
                if (this.mPendingMove != null) {
                    printWriter.print(str);
                    printWriter.print("mPendingMove=");
                    printWriter.println(this.mPendingMove);
                }
            }
        }

        public int getDesiredMinimumHeight() {
            return this.mIWallpaperEngine.mReqHeight;
        }

        public int getDesiredMinimumWidth() {
            return this.mIWallpaperEngine.mReqWidth;
        }

        public SurfaceHolder getSurfaceHolder() {
            return this.mSurfaceHolder;
        }

        public boolean isPreview() {
            return this.mIWallpaperEngine.mIsPreview;
        }

        public boolean isVisible() {
            return this.mReportedVisible;
        }

        public void onApplyWindowInsets(WindowInsets windowInsets) {
        }

        public Bundle onCommand(String str, int i, int i2, int i3, Bundle bundle, boolean z) {
            return null;
        }

        public void onCreate(SurfaceHolder surfaceHolder) {
        }

        public void onDesiredSizeChanged(int i, int i2) {
        }

        public void onDestroy() {
        }

        public void onOffsetsChanged(float f, float f2, float f3, float f4, int i, int i2) {
        }

        public void onSurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
        }

        public void onSurfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        }

        public void onTouchEvent(MotionEvent motionEvent) {
        }

        public void onVisibilityChanged(boolean z) {
        }

        void reportSurfaceDestroyed() {
            if (this.mSurfaceCreated) {
                this.mSurfaceCreated = false;
                this.mSurfaceHolder.ungetCallbacks();
                SurfaceHolder.Callback[] callbacks = this.mSurfaceHolder.getCallbacks();
                if (callbacks != null) {
                    int length = callbacks.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        callbacks[i2].surfaceDestroyed(this.mSurfaceHolder);
                        i = i2 + 1;
                    }
                }
                onSurfaceDestroyed(this.mSurfaceHolder);
            }
        }

        void reportVisibility() {
            boolean z = true;
            if (this.mDestroyed) {
                return;
            }
            if (!((this.mDisplay != null) & this.mVisible) || this.mDisplay.getState() == 1) {
                z = false;
            }
            if (this.mReportedVisible != z) {
                this.mReportedVisible = z;
                if (z) {
                    doOffsetsChanged(false);
                    updateSurface(false, false, false);
                }
                onVisibilityChanged(z);
            }
        }

        public void setFixedSizeAllowed(boolean z) {
            this.mFixedSizeAllowed = z;
        }

        public void setOffsetNotificationsEnabled(boolean z) {
            this.mWindowPrivateFlags = z ? this.mWindowPrivateFlags | 4 : this.mWindowPrivateFlags & (-5);
            if (this.mCreated) {
                updateSurface(false, false, false);
            }
        }

        public void setTouchEventsEnabled(boolean z) {
            this.mWindowFlags = z ? this.mWindowFlags & (-17) : this.mWindowFlags | 16;
            if (this.mCreated) {
                updateSurface(false, false, false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:179:0x062e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void updateSurface(boolean r17, boolean r18, boolean r19) {
            /*
                Method dump skipped, instructions count: 1979
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.service.wallpaper.WallpaperService.Engine.updateSurface(boolean, boolean, boolean):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/wallpaper/WallpaperService$IWallpaperEngineWrapper.class */
    public class IWallpaperEngineWrapper extends IWallpaperEngine.Stub implements HandlerCaller.Callback {
        private final HandlerCaller mCaller;
        final IWallpaperConnection mConnection;
        final Rect mDisplayPadding = new Rect();
        Engine mEngine;
        final boolean mIsPreview;
        int mReqHeight;
        int mReqWidth;
        boolean mShownReported;
        final IBinder mWindowToken;
        final int mWindowType;

        IWallpaperEngineWrapper(WallpaperService wallpaperService, IWallpaperConnection iWallpaperConnection, IBinder iBinder, int i, boolean z, int i2, int i3, Rect rect) {
            this.mCaller = new HandlerCaller(wallpaperService, wallpaperService.getMainLooper(), this, true);
            this.mConnection = iWallpaperConnection;
            this.mWindowToken = iBinder;
            this.mWindowType = i;
            this.mIsPreview = z;
            this.mReqWidth = i2;
            this.mReqHeight = i3;
            this.mDisplayPadding.set(rect);
            this.mCaller.sendMessage(this.mCaller.obtainMessage(10));
        }

        @Override // android.service.wallpaper.IWallpaperEngine
        public void destroy() {
            this.mCaller.sendMessage(this.mCaller.obtainMessage(20));
        }

        @Override // android.service.wallpaper.IWallpaperEngine
        public void dispatchPointer(MotionEvent motionEvent) {
            if (this.mEngine != null) {
                this.mEngine.dispatchPointer(motionEvent);
            } else {
                motionEvent.recycle();
            }
        }

        @Override // android.service.wallpaper.IWallpaperEngine
        public void dispatchWallpaperCommand(String str, int i, int i2, int i3, Bundle bundle) {
            if (this.mEngine != null) {
                this.mEngine.mWindow.dispatchWallpaperCommand(str, i, i2, i3, bundle, false);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void executeMessage(Message message) {
            switch (message.what) {
                case 10:
                    try {
                        this.mConnection.attachEngine(this);
                        Engine onCreateEngine = WallpaperService.this.onCreateEngine();
                        this.mEngine = onCreateEngine;
                        WallpaperService.this.mActiveEngines.add(onCreateEngine);
                        onCreateEngine.attach(this);
                        return;
                    } catch (RemoteException e) {
                        Log.w(WallpaperService.TAG, "Wallpaper host disappeared", e);
                        return;
                    }
                case 20:
                    WallpaperService.this.mActiveEngines.remove(this.mEngine);
                    this.mEngine.detach();
                    return;
                case 30:
                    this.mEngine.doDesiredSizeChanged(message.arg1, message.arg2);
                    return;
                case 40:
                    this.mEngine.doDisplayPaddingChanged((Rect) message.obj);
                    break;
                case 10000:
                    break;
                case 10010:
                    this.mEngine.doVisibilityChanged(message.arg1 != 0);
                    return;
                case WallpaperService.MSG_WALLPAPER_OFFSETS /* 10020 */:
                    this.mEngine.doOffsetsChanged(true);
                    return;
                case WallpaperService.MSG_WALLPAPER_COMMAND /* 10025 */:
                    this.mEngine.doCommand((WallpaperCommand) message.obj);
                    return;
                case WallpaperService.MSG_WINDOW_RESIZED /* 10030 */:
                    this.mEngine.updateSurface(true, false, message.arg1 != 0);
                    this.mEngine.doOffsetsChanged(true);
                    return;
                case WallpaperService.MSG_WINDOW_MOVED /* 10035 */:
                    return;
                case WallpaperService.MSG_TOUCH_EVENT /* 10040 */:
                    boolean z = false;
                    MotionEvent motionEvent = (MotionEvent) message.obj;
                    if (motionEvent.getAction() == 2) {
                        synchronized (this.mEngine.mLock) {
                            if (this.mEngine.mPendingMove == motionEvent) {
                                this.mEngine.mPendingMove = null;
                                z = false;
                            } else {
                                z = true;
                            }
                        }
                    }
                    if (!z) {
                        this.mEngine.onTouchEvent(motionEvent);
                    }
                    motionEvent.recycle();
                    return;
                default:
                    Log.w(WallpaperService.TAG, "Unknown message type " + message.what);
                    return;
            }
            this.mEngine.updateSurface(true, false, false);
        }

        public void reportShown() {
            if (this.mShownReported) {
                return;
            }
            this.mShownReported = true;
            try {
                this.mConnection.engineShown(this);
            } catch (RemoteException e) {
                Log.w(WallpaperService.TAG, "Wallpaper host disappeared", e);
            }
        }

        @Override // android.service.wallpaper.IWallpaperEngine
        public void setDesiredSize(int i, int i2) {
            this.mCaller.sendMessage(this.mCaller.obtainMessageII(30, i, i2));
        }

        @Override // android.service.wallpaper.IWallpaperEngine
        public void setDisplayPadding(Rect rect) {
            this.mCaller.sendMessage(this.mCaller.obtainMessageO(40, rect));
        }

        @Override // android.service.wallpaper.IWallpaperEngine
        public void setVisibility(boolean z) {
            this.mCaller.sendMessage(this.mCaller.obtainMessageI(10010, z ? 1 : 0));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/wallpaper/WallpaperService$IWallpaperServiceWrapper.class */
    class IWallpaperServiceWrapper extends IWallpaperService.Stub {
        private final WallpaperService mTarget;

        public IWallpaperServiceWrapper(WallpaperService wallpaperService) {
            this.mTarget = wallpaperService;
        }

        @Override // android.service.wallpaper.IWallpaperService
        public void attach(IWallpaperConnection iWallpaperConnection, IBinder iBinder, int i, boolean z, int i2, int i3, Rect rect) {
            new IWallpaperEngineWrapper(this.mTarget, iWallpaperConnection, iBinder, i, z, i2, i3, rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/wallpaper/WallpaperService$WallpaperCommand.class */
    public static final class WallpaperCommand {
        String action;
        Bundle extras;
        boolean sync;
        int x;
        int y;
        int z;

        WallpaperCommand() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print("State of wallpaper ");
        printWriter.print(this);
        printWriter.println(":");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mActiveEngines.size()) {
                return;
            }
            Engine engine = this.mActiveEngines.get(i2);
            printWriter.print("  Engine ");
            printWriter.print(engine);
            printWriter.println(":");
            engine.dump("    ", fileDescriptor, printWriter, strArr);
            i = i2 + 1;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new IWallpaperServiceWrapper(this);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    public abstract Engine onCreateEngine();

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mActiveEngines.size()) {
                this.mActiveEngines.clear();
                return;
            } else {
                this.mActiveEngines.get(i2).detach();
                i = i2 + 1;
            }
        }
    }
}
