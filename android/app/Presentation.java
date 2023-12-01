package android.app;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.WindowManagerImpl;

/* loaded from: source-9557208-dex2jar.jar:android/app/Presentation.class */
public class Presentation extends Dialog {
    private static final int MSG_CANCEL = 1;
    private static final String TAG = "Presentation";
    private final Display mDisplay;
    private final DisplayManager.DisplayListener mDisplayListener;
    private final DisplayManager mDisplayManager;
    private final Handler mHandler;

    public Presentation(Context context, Display display) {
        this(context, display, 0);
    }

    public Presentation(Context context, Display display, int i) {
        super(createPresentationContext(context, display, i), i, false);
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: android.app.Presentation.2
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i2) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i2) {
                if (i2 == Presentation.this.mDisplay.getDisplayId()) {
                    Presentation.this.handleDisplayChanged();
                }
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i2) {
                if (i2 == Presentation.this.mDisplay.getDisplayId()) {
                    Presentation.this.handleDisplayRemoved();
                }
            }
        };
        this.mHandler = new Handler() { // from class: android.app.Presentation.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        Presentation.this.cancel();
                        return;
                    default:
                        return;
                }
            }
        };
        this.mDisplay = display;
        this.mDisplayManager = (DisplayManager) getContext().getSystemService("display");
        getWindow().setGravity(119);
        setCanceledOnTouchOutside(false);
    }

    private static Context createPresentationContext(Context context, Display display, int i) {
        if (context == null) {
            throw new IllegalArgumentException("outerContext must not be null");
        }
        if (display == null) {
            throw new IllegalArgumentException("display must not be null");
        }
        Context createDisplayContext = context.createDisplayContext(display);
        int i2 = i;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            createDisplayContext.getTheme().resolveAttribute(16843712, typedValue, true);
            i2 = typedValue.resourceId;
        }
        final WindowManagerImpl createPresentationWindowManager = ((WindowManagerImpl) context.getSystemService(Context.WINDOW_SERVICE)).createPresentationWindowManager(display);
        return new ContextThemeWrapper(createDisplayContext, i2) { // from class: android.app.Presentation.1
            @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
            public Object getSystemService(String str) {
                return Context.WINDOW_SERVICE.equals(str) ? createPresentationWindowManager : super.getSystemService(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDisplayChanged() {
        onDisplayChanged();
        if (isConfigurationStillValid()) {
            return;
        }
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDisplayRemoved() {
        onDisplayRemoved();
        cancel();
    }

    private boolean isConfigurationStillValid() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mDisplay.getMetrics(displayMetrics);
        return displayMetrics.equalsPhysical(getResources().getDisplayMetrics());
    }

    public Display getDisplay() {
        return this.mDisplay;
    }

    public Resources getResources() {
        return getContext().getResources();
    }

    public void onDisplayChanged() {
    }

    public void onDisplayRemoved() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.mDisplayManager.registerDisplayListener(this.mDisplayListener, this.mHandler);
        if (isConfigurationStillValid()) {
            return;
        }
        Log.i(TAG, "Presentation is being immediately dismissed because the display metrics have changed since it was created.");
        this.mHandler.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onStop() {
        this.mDisplayManager.unregisterDisplayListener(this.mDisplayListener);
        super.onStop();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
