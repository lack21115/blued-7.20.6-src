package android.widget;

import android.app.INotificationManager;
import android.app.ITransientNotification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/widget/Toast.class */
public class Toast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    static final String TAG = "Toast";
    static final boolean localLOGV = false;
    private static INotificationManager sService;
    final Context mContext;
    int mDuration;
    View mNextView;
    final TN mTN = new TN();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/Toast$TN.class */
    public static class TN extends ITransientNotification.Stub {
        int mGravity;
        float mHorizontalMargin;
        View mNextView;
        float mVerticalMargin;
        View mView;
        WindowManager mWM;
        int mX;
        int mY;
        final Runnable mShow = new Runnable() { // from class: android.widget.Toast.TN.1
            @Override // java.lang.Runnable
            public void run() {
                TN.this.handleShow();
            }
        };
        final Runnable mHide = new Runnable() { // from class: android.widget.Toast.TN.2
            @Override // java.lang.Runnable
            public void run() {
                TN.this.handleHide();
                TN.this.mNextView = null;
            }
        };
        private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        final Handler mHandler = new Handler();

        TN() {
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation_Toast;
            layoutParams.type = 2005;
            layoutParams.setTitle(Toast.TAG);
            layoutParams.flags = 152;
        }

        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(this.mView.getContext());
            if (accessibilityManager.isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(64);
                obtain.setClassName(getClass().getName());
                obtain.setPackageName(this.mView.getContext().getPackageName());
                this.mView.dispatchPopulateAccessibilityEvent(obtain);
                accessibilityManager.sendAccessibilityEvent(obtain);
            }
        }

        public void handleHide() {
            if (this.mView != null) {
                if (this.mView.getParent() != null) {
                    this.mWM.removeView(this.mView);
                }
                this.mView = null;
            }
        }

        public void handleShow() {
            if (this.mView != this.mNextView) {
                handleHide();
                this.mView = this.mNextView;
                Context applicationContext = this.mView.getContext().getApplicationContext();
                String opPackageName = this.mView.getContext().getOpPackageName();
                Context context = applicationContext;
                if (applicationContext == null) {
                    context = this.mView.getContext();
                }
                ImageView imageView = (ImageView) this.mView.findViewById(R.id.icon);
                if (imageView != null) {
                    Drawable drawable = null;
                    try {
                        drawable = context.getPackageManager().getApplicationIcon(opPackageName);
                    } catch (PackageManager.NameNotFoundException e) {
                    }
                    imageView.setImageDrawable(drawable);
                }
                this.mWM = (WindowManager) context.getSystemService("window");
                int absoluteGravity = Gravity.getAbsoluteGravity(this.mGravity, this.mView.getContext().getResources().getConfiguration().getLayoutDirection());
                this.mParams.gravity = absoluteGravity;
                if ((absoluteGravity & 7) == 7) {
                    this.mParams.horizontalWeight = 1.0f;
                }
                if ((absoluteGravity & 112) == 112) {
                    this.mParams.verticalWeight = 1.0f;
                }
                this.mParams.x = this.mX;
                this.mParams.y = this.mY;
                this.mParams.verticalMargin = this.mVerticalMargin;
                this.mParams.horizontalMargin = this.mHorizontalMargin;
                this.mParams.packageName = opPackageName;
                if (this.mView.getParent() != null) {
                    this.mWM.removeView(this.mView);
                }
                this.mWM.addView(this.mView, this.mParams);
                trySendAccessibilityEvent();
            }
        }

        public void hide() {
            this.mHandler.post(this.mHide);
        }

        public void show() {
            this.mHandler.post(this.mShow);
        }
    }

    public Toast(Context context) {
        this.mContext = context;
        this.mTN.mY = context.getResources().getDimensionPixelSize(R.dimen.toast_y_offset);
        this.mTN.mGravity = context.getResources().getInteger(R.integer.config_toastDefaultGravity);
    }

    private static INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        return sService;
    }

    public static Toast makeText(Context context, int i, int i2) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(i), i2);
    }

    public static Toast makeText(Context context, CharSequence charSequence, int i) {
        Toast toast = new Toast(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.transient_notification, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.message)).setText(charSequence);
        toast.mNextView = inflate;
        toast.mDuration = i;
        return toast;
    }

    public void cancel() {
        this.mTN.hide();
        try {
            getService().cancelToast(this.mContext.getPackageName(), this.mTN);
        } catch (RemoteException e) {
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getGravity() {
        return this.mTN.mGravity;
    }

    public float getHorizontalMargin() {
        return this.mTN.mHorizontalMargin;
    }

    public float getVerticalMargin() {
        return this.mTN.mVerticalMargin;
    }

    public View getView() {
        return this.mNextView;
    }

    public WindowManager.LayoutParams getWindowParams() {
        return this.mTN.mParams;
    }

    public int getXOffset() {
        return this.mTN.mX;
    }

    public int getYOffset() {
        return this.mTN.mY;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setGravity(int i, int i2, int i3) {
        this.mTN.mGravity = i;
        this.mTN.mX = i2;
        this.mTN.mY = i3;
    }

    public void setMargin(float f, float f2) {
        this.mTN.mHorizontalMargin = f;
        this.mTN.mVerticalMargin = f2;
    }

    public void setText(int i) {
        setText(this.mContext.getText(i));
    }

    public void setText(CharSequence charSequence) {
        if (this.mNextView == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView textView = (TextView) this.mNextView.findViewById(R.id.message);
        if (textView == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        textView.setText(charSequence);
    }

    public void setView(View view) {
        this.mNextView = view;
    }

    public void show() {
        if (this.mNextView == null) {
            throw new RuntimeException("setView must have been called");
        }
        INotificationManager service = getService();
        String opPackageName = this.mContext.getOpPackageName();
        TN tn = this.mTN;
        tn.mNextView = this.mNextView;
        try {
            service.enqueueToast(opPackageName, tn, this.mDuration);
        } catch (RemoteException e) {
        }
    }
}
