package com.sobot.chat.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotCustomPopWindow.class */
public class SobotCustomPopWindow implements PopupWindow.OnDismissListener {
    private static final float DEFAULT_ALPHA = 0.7f;
    private static final String TAG = "SobotCustomPopWindow";
    private boolean enableOutsideTouchDisMiss;
    private int mAnimationStyle;
    private float mBackgroundDrakValue;
    private boolean mClippEnable;
    private View mContentView;
    private Context mContext;
    private int mHeight;
    private boolean mIgnoreCheekPress;
    private int mInputMode;
    private boolean mIsBackgroundDark;
    private boolean mIsFocusable;
    private boolean mIsOutside;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private View.OnTouchListener mOnTouchListener;
    private PopupWindow mPopupWindow;
    private int mResLayoutId;
    private int mSoftInputMode;
    private boolean mTouchable;
    private int mWidth;
    private Window mWindow;
    private boolean widthMatchParent;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotCustomPopWindow$PopupWindowBuilder.class */
    public static class PopupWindowBuilder {
        private SobotCustomPopWindow mCustomPopWindow;

        public PopupWindowBuilder(Context context) {
            this.mCustomPopWindow = new SobotCustomPopWindow(context);
        }

        public SobotCustomPopWindow create() {
            this.mCustomPopWindow.build();
            return this.mCustomPopWindow;
        }

        public PopupWindowBuilder enableBackgroundDark(boolean z) {
            this.mCustomPopWindow.mIsBackgroundDark = z;
            return this;
        }

        public PopupWindowBuilder enableOutsideTouchableDissmiss(boolean z) {
            this.mCustomPopWindow.enableOutsideTouchDisMiss = z;
            return this;
        }

        public PopupWindowBuilder setAnimationStyle(int i) {
            this.mCustomPopWindow.mAnimationStyle = i;
            return this;
        }

        public PopupWindowBuilder setBgDarkAlpha(float f) {
            this.mCustomPopWindow.mBackgroundDrakValue = f;
            return this;
        }

        public PopupWindowBuilder setClippingEnable(boolean z) {
            this.mCustomPopWindow.mClippEnable = z;
            return this;
        }

        public PopupWindowBuilder setFocusable(boolean z) {
            this.mCustomPopWindow.mIsFocusable = z;
            return this;
        }

        public PopupWindowBuilder setIgnoreCheekPress(boolean z) {
            this.mCustomPopWindow.mIgnoreCheekPress = z;
            return this;
        }

        public PopupWindowBuilder setInputMethodMode(int i) {
            this.mCustomPopWindow.mInputMode = i;
            return this;
        }

        public PopupWindowBuilder setOnDissmissListener(PopupWindow.OnDismissListener onDismissListener) {
            this.mCustomPopWindow.mOnDismissListener = onDismissListener;
            return this;
        }

        public PopupWindowBuilder setOutsideTouchable(boolean z) {
            this.mCustomPopWindow.mIsOutside = z;
            return this;
        }

        public PopupWindowBuilder setSoftInputMode(int i) {
            this.mCustomPopWindow.mSoftInputMode = i;
            return this;
        }

        public PopupWindowBuilder setTouchIntercepter(View.OnTouchListener onTouchListener) {
            this.mCustomPopWindow.mOnTouchListener = onTouchListener;
            return this;
        }

        public PopupWindowBuilder setTouchable(boolean z) {
            this.mCustomPopWindow.mTouchable = z;
            return this;
        }

        public PopupWindowBuilder setView(int i) {
            this.mCustomPopWindow.mResLayoutId = i;
            this.mCustomPopWindow.mContentView = null;
            return this;
        }

        public PopupWindowBuilder setView(View view) {
            this.mCustomPopWindow.mContentView = view;
            this.mCustomPopWindow.mResLayoutId = -1;
            return this;
        }

        public PopupWindowBuilder setWidthMatchParent(boolean z) {
            this.mCustomPopWindow.widthMatchParent = z;
            return this;
        }

        public PopupWindowBuilder size(int i, int i2) {
            this.mCustomPopWindow.mWidth = i;
            this.mCustomPopWindow.mHeight = i2;
            return this;
        }
    }

    private SobotCustomPopWindow(Context context) {
        this.mIsFocusable = true;
        this.widthMatchParent = false;
        this.mIsOutside = true;
        this.mResLayoutId = -1;
        this.mAnimationStyle = -1;
        this.mClippEnable = true;
        this.mIgnoreCheekPress = false;
        this.mInputMode = -1;
        this.mSoftInputMode = -1;
        this.mTouchable = true;
        this.mIsBackgroundDark = false;
        this.mBackgroundDrakValue = 0.0f;
        this.enableOutsideTouchDisMiss = true;
        this.mContext = context;
    }

    private void apply(PopupWindow popupWindow) {
        popupWindow.setClippingEnabled(this.mClippEnable);
        if (this.mIgnoreCheekPress) {
            popupWindow.setIgnoreCheekPress();
        }
        int i = this.mInputMode;
        if (i != -1) {
            popupWindow.setInputMethodMode(i);
        }
        int i2 = this.mSoftInputMode;
        if (i2 != -1) {
            popupWindow.setSoftInputMode(i2);
        }
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
        View.OnTouchListener onTouchListener = this.mOnTouchListener;
        if (onTouchListener != null) {
            popupWindow.setTouchInterceptor(onTouchListener);
        }
        popupWindow.setTouchable(this.mTouchable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupWindow build() {
        if (this.mContentView == null) {
            this.mContentView = LayoutInflater.from(this.mContext).inflate(this.mResLayoutId, (ViewGroup) null);
        }
        Activity activity = (Activity) this.mContentView.getContext();
        if (activity != null && this.mIsBackgroundDark) {
            float f = this.mBackgroundDrakValue;
            if (f <= 0.0f || f >= 1.0f) {
                f = 0.7f;
            }
            Window window = activity.getWindow();
            this.mWindow = window;
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            this.mWindow.addFlags(2);
            this.mWindow.setAttributes(attributes);
        }
        if (this.mWidth != 0 && this.mHeight != 0) {
            this.mPopupWindow = new PopupWindow(this.mContentView, this.mWidth, this.mHeight);
        } else if (this.widthMatchParent) {
            this.mPopupWindow = new PopupWindow(this.mContentView, -1, -2);
        } else {
            this.mPopupWindow = new PopupWindow(this.mContentView, -2, -2);
        }
        int i = this.mAnimationStyle;
        if (i != -1) {
            this.mPopupWindow.setAnimationStyle(i);
        }
        apply(this.mPopupWindow);
        if (this.mWidth == 0 || this.mHeight == 0) {
            this.mPopupWindow.getContentView().measure(0, 0);
            this.mWidth = this.mPopupWindow.getContentView().getMeasuredWidth();
            this.mHeight = this.mPopupWindow.getContentView().getMeasuredHeight();
        }
        this.mPopupWindow.setOnDismissListener(this);
        if (this.enableOutsideTouchDisMiss) {
            this.mPopupWindow.setFocusable(this.mIsFocusable);
            this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mPopupWindow.setOutsideTouchable(this.mIsOutside);
        } else {
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(null);
            this.mPopupWindow.getContentView().setFocusable(true);
            this.mPopupWindow.getContentView().setFocusableInTouchMode(true);
            this.mPopupWindow.getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: com.sobot.chat.widget.SobotCustomPopWindow.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    if (i2 == 4) {
                        SobotCustomPopWindow.this.mPopupWindow.dismiss();
                        return true;
                    }
                    return false;
                }
            });
            this.mPopupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.sobot.chat.widget.SobotCustomPopWindow.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (motionEvent.getAction() != 0 || (x >= 0 && x < SobotCustomPopWindow.this.mWidth && y >= 0 && y < SobotCustomPopWindow.this.mHeight)) {
                        if (motionEvent.getAction() == 4) {
                            Log.e(SobotCustomPopWindow.TAG, "out side ...");
                            return true;
                        }
                        return false;
                    }
                    Log.e(SobotCustomPopWindow.TAG, "out side ");
                    Log.e(SobotCustomPopWindow.TAG, "width:" + SobotCustomPopWindow.this.mPopupWindow.getWidth() + "height:" + SobotCustomPopWindow.this.mPopupWindow.getHeight() + " x:" + x + " y  :" + y);
                    return true;
                }
            });
        }
        this.mPopupWindow.update();
        return this.mPopupWindow;
    }

    public void dissmiss() {
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        Window window = this.mWindow;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            this.mWindow.setAttributes(attributes);
        }
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopupWindow.dismiss();
    }

    public int getHeight() {
        return this.mHeight;
    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    public int getWidth() {
        return this.mWidth;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        dissmiss();
    }

    public SobotCustomPopWindow showAsDropDown(View view) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            try {
                popupWindow.showAsDropDown(view);
            } catch (Exception e) {
                return this;
            }
        }
        return this;
    }

    public SobotCustomPopWindow showAsDropDown(View view, int i, int i2) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            try {
                popupWindow.showAsDropDown(view, i, i2);
            } catch (Exception e) {
                return this;
            }
        }
        return this;
    }

    public SobotCustomPopWindow showAsDropDown(View view, int i, int i2, int i3) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            try {
                popupWindow.showAsDropDown(view, i, i2, i3);
            } catch (Exception e) {
                return this;
            }
        }
        return this;
    }

    public SobotCustomPopWindow showAtLocation(View view, int i, int i2, int i3) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            try {
                popupWindow.showAtLocation(view, i, i2, i3);
            } catch (Exception e) {
                return this;
            }
        }
        return this;
    }
}
