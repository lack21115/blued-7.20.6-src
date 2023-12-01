package com.android.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PasswordEntryKeyboard.class */
public class PasswordEntryKeyboard extends Keyboard {
    public static final int KEYCODE_SPACE = 32;
    private static final int SHIFT_LOCKED = 2;
    private static final int SHIFT_OFF = 0;
    private static final int SHIFT_ON = 1;
    static int sSpacebarVerticalCorrection;
    private Keyboard.Key mEnterKey;
    private Keyboard.Key mF1Key;
    private Drawable[] mOldShiftIcons;
    private Drawable mShiftIcon;
    private Keyboard.Key[] mShiftKeys;
    private Drawable mShiftLockIcon;
    private int mShiftState;
    private Keyboard.Key mSpaceKey;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PasswordEntryKeyboard$LatinKey.class */
    static class LatinKey extends Keyboard.Key {
        private boolean mEnabled;
        private boolean mShiftLockEnabled;

        public LatinKey(Resources resources, Keyboard.Row row, int i, int i2, XmlResourceParser xmlResourceParser) {
            super(resources, row, i, i2, xmlResourceParser);
            this.mEnabled = true;
            if (this.popupCharacters == null || this.popupCharacters.length() != 0) {
                return;
            }
            this.popupResId = 0;
        }

        void enableShiftLock() {
            this.mShiftLockEnabled = true;
        }

        @Override // android.inputmethodservice.Keyboard.Key
        public boolean isInside(int i, int i2) {
            int i3;
            int i4;
            if (this.mEnabled) {
                int i5 = this.codes[0];
                if (i5 == -1 || i5 == -5) {
                    int i6 = i2 - (this.height / 10);
                    int i7 = i;
                    if (i5 == -1) {
                        i7 = i + (this.width / 6);
                    }
                    i3 = i7;
                    i4 = i6;
                    if (i5 == -5) {
                        i3 = i7 - (this.width / 6);
                        i4 = i6;
                    }
                } else {
                    i3 = i;
                    i4 = i2;
                    if (i5 == 32) {
                        i4 = i2 + PasswordEntryKeyboard.sSpacebarVerticalCorrection;
                        i3 = i;
                    }
                }
                return super.isInside(i3, i4);
            }
            return false;
        }

        @Override // android.inputmethodservice.Keyboard.Key
        public void onReleased(boolean z) {
            if (this.mShiftLockEnabled) {
                this.pressed = !this.pressed;
            } else {
                super.onReleased(z);
            }
        }

        void setEnabled(boolean z) {
            this.mEnabled = z;
        }
    }

    public PasswordEntryKeyboard(Context context, int i) {
        this(context, i, 0);
    }

    public PasswordEntryKeyboard(Context context, int i, int i2) {
        super(context, i, i2);
        this.mOldShiftIcons = new Drawable[]{null, null};
        this.mShiftKeys = new Keyboard.Key[]{null, null};
        this.mShiftState = 0;
        init(context);
    }

    public PasswordEntryKeyboard(Context context, int i, int i2, int i3) {
        this(context, i, 0, i2, i3);
    }

    public PasswordEntryKeyboard(Context context, int i, int i2, int i3, int i4) {
        super(context, i, i2, i3, i4);
        this.mOldShiftIcons = new Drawable[]{null, null};
        this.mShiftKeys = new Keyboard.Key[]{null, null};
        this.mShiftState = 0;
        init(context);
    }

    public PasswordEntryKeyboard(Context context, int i, CharSequence charSequence, int i2, int i3) {
        super(context, i, charSequence, i2, i3);
        this.mOldShiftIcons = new Drawable[]{null, null};
        this.mShiftKeys = new Keyboard.Key[]{null, null};
        this.mShiftState = 0;
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.mShiftIcon = context.getDrawable(R.drawable.sym_keyboard_shift);
        this.mShiftLockIcon = context.getDrawable(R.drawable.sym_keyboard_shift_locked);
        sSpacebarVerticalCorrection = resources.getDimensionPixelOffset(R.dimen.password_keyboard_spacebar_vertical_correction);
    }

    @Override // android.inputmethodservice.Keyboard
    protected Keyboard.Key createKeyFromXml(Resources resources, Keyboard.Row row, int i, int i2, XmlResourceParser xmlResourceParser) {
        LatinKey latinKey = new LatinKey(resources, row, i, i2, xmlResourceParser);
        int i3 = latinKey.codes[0];
        if (i3 >= 0 && i3 != 10 && (i3 < 32 || i3 > 127)) {
            latinKey.label = " ";
            latinKey.setEnabled(false);
        }
        switch (latinKey.codes[0]) {
            case PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES /* -103 */:
                this.mF1Key = latinKey;
                return latinKey;
            case 10:
                this.mEnterKey = latinKey;
                return latinKey;
            case 32:
                this.mSpaceKey = latinKey;
                return latinKey;
            default:
                return latinKey;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enableShiftLock() {
        int i = 0;
        int[] shiftKeyIndices = getShiftKeyIndices();
        int length = shiftKeyIndices.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = shiftKeyIndices[i2];
            int i4 = i;
            if (i3 >= 0) {
                i4 = i;
                if (i < this.mShiftKeys.length) {
                    this.mShiftKeys[i] = getKeys().get(i3);
                    if (this.mShiftKeys[i] instanceof LatinKey) {
                        ((LatinKey) this.mShiftKeys[i]).enableShiftLock();
                    }
                    this.mOldShiftIcons[i] = this.mShiftKeys[i].icon;
                    i4 = i + 1;
                }
            }
            i2++;
            i = i4;
        }
    }

    @Override // android.inputmethodservice.Keyboard
    public boolean isShifted() {
        boolean z = false;
        if (this.mShiftKeys[0] != null) {
            if (this.mShiftState != 0) {
                z = true;
            }
            return z;
        }
        return super.isShifted();
    }

    void setEnterKeyResources(Resources resources, int i, int i2, int i3) {
        if (this.mEnterKey != null) {
            this.mEnterKey.popupCharacters = null;
            this.mEnterKey.popupResId = 0;
            this.mEnterKey.text = null;
            this.mEnterKey.iconPreview = resources.getDrawable(i);
            this.mEnterKey.icon = resources.getDrawable(i2);
            this.mEnterKey.label = resources.getText(i3);
            if (this.mEnterKey.iconPreview != null) {
                this.mEnterKey.iconPreview.setBounds(0, 0, this.mEnterKey.iconPreview.getIntrinsicWidth(), this.mEnterKey.iconPreview.getIntrinsicHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShiftLocked(boolean z) {
        Keyboard.Key[] keyArr = this.mShiftKeys;
        int length = keyArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Keyboard.Key key = keyArr[i2];
            if (key != null) {
                key.on = z;
                key.icon = this.mShiftLockIcon;
            }
            i = i2 + 1;
        }
        this.mShiftState = z ? 2 : 1;
    }

    @Override // android.inputmethodservice.Keyboard
    public boolean setShifted(boolean z) {
        boolean z2 = false;
        if (!z) {
            z2 = this.mShiftState != 0;
            this.mShiftState = 0;
        } else if (this.mShiftState == 0) {
            z2 = this.mShiftState == 0;
            this.mShiftState = 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mShiftKeys.length) {
                return z2;
            }
            if (this.mShiftKeys[i2] != null) {
                if (!z) {
                    this.mShiftKeys[i2].on = false;
                    this.mShiftKeys[i2].icon = this.mOldShiftIcons[i2];
                } else if (this.mShiftState == 0) {
                    this.mShiftKeys[i2].on = false;
                    this.mShiftKeys[i2].icon = this.mShiftIcon;
                }
            }
            i = i2 + 1;
        }
    }
}
