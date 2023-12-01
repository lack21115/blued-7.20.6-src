package com.android.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PasswordEntryKeyboardHelper.class */
public class PasswordEntryKeyboardHelper implements KeyboardView.OnKeyboardActionListener {
    public static final int KEYBOARD_MODE_ALPHA = 0;
    public static final int KEYBOARD_MODE_NUMERIC = 1;
    private static final int KEYBOARD_STATE_CAPSLOCK = 2;
    private static final int KEYBOARD_STATE_NORMAL = 0;
    private static final int KEYBOARD_STATE_SHIFTED = 1;
    private static final int NUMERIC = 0;
    private static final int QWERTY = 1;
    private static final int QWERTY_SHIFTED = 2;
    private static final int SYMBOLS = 3;
    private static final int SYMBOLS_SHIFTED = 4;
    private static final String TAG = "PasswordEntryKeyboardHelper";
    private final Context mContext;
    private boolean mEnableHaptics;
    private int mKeyboardMode;
    private int mKeyboardState;
    private final KeyboardView mKeyboardView;
    int[] mLayouts;
    private PasswordEntryKeyboard mNumericKeyboard;
    private PasswordEntryKeyboard mQwertyKeyboard;
    private PasswordEntryKeyboard mQwertyKeyboardShifted;
    private PasswordEntryKeyboard mSymbolsKeyboard;
    private PasswordEntryKeyboard mSymbolsKeyboardShifted;
    private final View mTargetView;
    private boolean mUsingScreenWidth;
    private long[] mVibratePattern;

    public PasswordEntryKeyboardHelper(Context context, KeyboardView keyboardView, View view) {
        this(context, keyboardView, view, true, null);
    }

    public PasswordEntryKeyboardHelper(Context context, KeyboardView keyboardView, View view, boolean z) {
        this(context, keyboardView, view, z, null);
    }

    public PasswordEntryKeyboardHelper(Context context, KeyboardView keyboardView, View view, boolean z, int[] iArr) {
        this.mKeyboardMode = 0;
        this.mKeyboardState = 0;
        this.mEnableHaptics = false;
        this.mLayouts = new int[]{R.xml.password_kbd_numeric, R.xml.password_kbd_qwerty, R.xml.password_kbd_qwerty_shifted, R.xml.password_kbd_symbols, R.xml.password_kbd_symbols_shift};
        this.mContext = context;
        this.mTargetView = view;
        this.mKeyboardView = keyboardView;
        this.mKeyboardView.setOnKeyboardActionListener(this);
        this.mUsingScreenWidth = z;
        if (iArr != null) {
            if (iArr.length == this.mLayouts.length) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mLayouts.length) {
                        break;
                    }
                    this.mLayouts[i2] = iArr[i2];
                    i = i2 + 1;
                }
            } else {
                throw new RuntimeException("Wrong number of layouts");
            }
        }
        createKeyboards();
    }

    private void createKeyboardsWithDefaultWidth() {
        this.mNumericKeyboard = new PasswordEntryKeyboard(this.mContext, this.mLayouts[0]);
        this.mQwertyKeyboard = new PasswordEntryKeyboard(this.mContext, this.mLayouts[1], R.id.mode_normal);
        this.mQwertyKeyboard.enableShiftLock();
        this.mQwertyKeyboardShifted = new PasswordEntryKeyboard(this.mContext, this.mLayouts[2], R.id.mode_normal);
        this.mQwertyKeyboardShifted.enableShiftLock();
        this.mQwertyKeyboardShifted.setShifted(true);
        this.mSymbolsKeyboard = new PasswordEntryKeyboard(this.mContext, this.mLayouts[3]);
        this.mSymbolsKeyboard.enableShiftLock();
        this.mSymbolsKeyboardShifted = new PasswordEntryKeyboard(this.mContext, this.mLayouts[4]);
        this.mSymbolsKeyboardShifted.enableShiftLock();
        this.mSymbolsKeyboardShifted.setShifted(true);
    }

    private void createKeyboardsWithSpecificSize(int i, int i2) {
        this.mNumericKeyboard = new PasswordEntryKeyboard(this.mContext, this.mLayouts[0], i, i2);
        this.mQwertyKeyboard = new PasswordEntryKeyboard(this.mContext, this.mLayouts[1], (int) R.id.mode_normal, i, i2);
        this.mQwertyKeyboard.enableShiftLock();
        this.mQwertyKeyboardShifted = new PasswordEntryKeyboard(this.mContext, this.mLayouts[2], (int) R.id.mode_normal, i, i2);
        this.mQwertyKeyboardShifted.enableShiftLock();
        this.mQwertyKeyboardShifted.setShifted(true);
        this.mSymbolsKeyboard = new PasswordEntryKeyboard(this.mContext, this.mLayouts[3], i, i2);
        this.mSymbolsKeyboard.enableShiftLock();
        this.mSymbolsKeyboardShifted = new PasswordEntryKeyboard(this.mContext, this.mLayouts[4], i, i2);
        this.mSymbolsKeyboardShifted.enableShiftLock();
        this.mSymbolsKeyboardShifted.setShifted(true);
    }

    private void handleCharacter(int i, int[] iArr) {
        int i2 = i;
        if (this.mKeyboardView.isShifted()) {
            i2 = i;
            if (i != 32) {
                i2 = i;
                if (i != 10) {
                    i2 = Character.toUpperCase(i);
                }
            }
        }
        sendKeyEventsToTarget(i2);
    }

    private void handleClose() {
    }

    private void handleModeChange() {
        Keyboard keyboard = this.mKeyboardView.getKeyboard();
        PasswordEntryKeyboard passwordEntryKeyboard = null;
        if (keyboard == this.mQwertyKeyboard || keyboard == this.mQwertyKeyboardShifted) {
            passwordEntryKeyboard = this.mSymbolsKeyboard;
        } else if (keyboard == this.mSymbolsKeyboard || keyboard == this.mSymbolsKeyboardShifted) {
            passwordEntryKeyboard = this.mQwertyKeyboard;
        }
        if (passwordEntryKeyboard != null) {
            this.mKeyboardView.setKeyboard(passwordEntryKeyboard);
            this.mKeyboardState = 0;
        }
    }

    private void handleShift() {
        if (this.mKeyboardView == null) {
            return;
        }
        Keyboard keyboard = this.mKeyboardView.getKeyboard();
        PasswordEntryKeyboard passwordEntryKeyboard = null;
        boolean z = keyboard == this.mQwertyKeyboard || keyboard == this.mQwertyKeyboardShifted;
        if (this.mKeyboardState == 0) {
            this.mKeyboardState = z ? 1 : 2;
            passwordEntryKeyboard = z ? this.mQwertyKeyboardShifted : this.mSymbolsKeyboardShifted;
        } else if (this.mKeyboardState == 1) {
            this.mKeyboardState = 2;
            passwordEntryKeyboard = z ? this.mQwertyKeyboardShifted : this.mSymbolsKeyboardShifted;
        } else if (this.mKeyboardState == 2) {
            this.mKeyboardState = 0;
            passwordEntryKeyboard = z ? this.mQwertyKeyboard : this.mSymbolsKeyboard;
        }
        if (passwordEntryKeyboard != null) {
            if (passwordEntryKeyboard != keyboard) {
                this.mKeyboardView.setKeyboard(passwordEntryKeyboard);
            }
            passwordEntryKeyboard.setShiftLocked(this.mKeyboardState == 2);
            this.mKeyboardView.setShifted(this.mKeyboardState != 0);
        }
    }

    private void performHapticFeedback() {
        if (this.mEnableHaptics) {
            this.mKeyboardView.performHapticFeedback(1, 3);
        }
    }

    private void sendKeyEventsToTarget(int i) {
        ViewRootImpl viewRootImpl = this.mTargetView.getViewRootImpl();
        KeyEvent[] events = KeyCharacterMap.load(-1).getEvents(new char[]{(char) i});
        if (events == null) {
            return;
        }
        int length = events.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            KeyEvent keyEvent = events[i3];
            viewRootImpl.dispatchInputEvent(KeyEvent.changeFlags(keyEvent, keyEvent.getFlags() | 2 | 4));
            i2 = i3 + 1;
        }
    }

    public void createKeyboards() {
        ViewGroup.LayoutParams layoutParams = this.mKeyboardView.getLayoutParams();
        if (this.mUsingScreenWidth || layoutParams.width == -1) {
            createKeyboardsWithDefaultWidth();
        } else {
            createKeyboardsWithSpecificSize(layoutParams.width, layoutParams.height);
        }
    }

    public void handleBackspace() {
        sendDownUpKeyEvents(67);
        performHapticFeedback();
    }

    public boolean isAlpha() {
        return this.mKeyboardMode == 0;
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onKey(int i, int[] iArr) {
        if (i == -5) {
            handleBackspace();
        } else if (i == -1) {
            handleShift();
        } else if (i == -3) {
            handleClose();
        } else if (i == -2 && this.mKeyboardView != null) {
            handleModeChange();
        } else {
            handleCharacter(i, iArr);
            if (this.mKeyboardState == 1) {
                this.mKeyboardState = 2;
                handleShift();
            }
        }
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onPress(int i) {
        performHapticFeedback();
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onRelease(int i) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void onText(CharSequence charSequence) {
    }

    public void sendDownUpKeyEvents(int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        ViewRootImpl viewRootImpl = this.mTargetView.getViewRootImpl();
        viewRootImpl.dispatchKeyFromIme(new KeyEvent(uptimeMillis, uptimeMillis, 0, i, 0, 0, -1, 0, 6));
        viewRootImpl.dispatchKeyFromIme(new KeyEvent(uptimeMillis, uptimeMillis, 1, i, 0, 0, -1, 0, 6));
    }

    public void setEnableHaptics(boolean z) {
        this.mEnableHaptics = z;
    }

    public void setKeyboardMode(int i) {
        boolean z = true;
        switch (i) {
            case 0:
                this.mKeyboardView.setKeyboard(this.mQwertyKeyboard);
                this.mKeyboardState = 0;
                if (Settings.System.getInt(this.mContext.getContentResolver(), "show_password", 1) == 0) {
                    z = false;
                }
                KeyboardView keyboardView = this.mKeyboardView;
                if (z) {
                }
                keyboardView.setPreviewEnabled(false);
                break;
            case 1:
                this.mKeyboardView.setKeyboard(this.mNumericKeyboard);
                this.mKeyboardState = 0;
                this.mKeyboardView.setPreviewEnabled(false);
                break;
        }
        this.mKeyboardMode = i;
    }

    public void setVibratePattern(int i) {
        int[] iArr;
        try {
            iArr = this.mContext.getResources().getIntArray(i);
        } catch (Resources.NotFoundException e) {
            iArr = null;
            if (i != 0) {
                Log.e(TAG, "Vibrate pattern missing", e);
                iArr = null;
            }
        }
        if (iArr == null) {
            this.mVibratePattern = null;
            return;
        }
        this.mVibratePattern = new long[iArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return;
            }
            this.mVibratePattern[i3] = iArr[i3];
            i2 = i3 + 1;
        }
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public void swipeUp() {
    }
}
