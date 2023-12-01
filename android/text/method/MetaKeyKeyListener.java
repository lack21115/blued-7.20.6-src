package android.text.method;

import android.content.Context;
import android.os.IPowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/MetaKeyKeyListener.class */
public abstract class MetaKeyKeyListener {
    private static final int LOCKED = 67108881;
    private static final int LOCKED_RETURN_VALUE = 2;
    public static final int META_ALT_LOCKED = 512;
    private static final long META_ALT_MASK = 565157566611970L;
    public static final int META_ALT_ON = 2;
    private static final long META_ALT_PRESSED = 2199023255552L;
    private static final long META_ALT_RELEASED = 562949953421312L;
    private static final long META_ALT_USED = 8589934592L;
    public static final int META_CAP_LOCKED = 256;
    private static final long META_CAP_PRESSED = 1099511627776L;
    private static final long META_CAP_RELEASED = 281474976710656L;
    private static final long META_CAP_USED = 4294967296L;
    public static final int META_SELECTING = 2048;
    private static final long META_SHIFT_MASK = 282578783305985L;
    public static final int META_SHIFT_ON = 1;
    public static final int META_SYM_LOCKED = 1024;
    private static final long META_SYM_MASK = 1130315133223940L;
    public static final int META_SYM_ON = 4;
    private static final long META_SYM_PRESSED = 4398046511104L;
    private static final long META_SYM_RELEASED = 1125899906842624L;
    private static final long META_SYM_USED = 17179869184L;
    private static final int PRESSED = 16777233;
    private static final int PRESSED_RETURN_VALUE = 1;
    private static final int RELEASED = 33554449;
    private static final int USED = 50331665;
    private static final Object CAP = new NoCopySpan.Concrete();
    private static final Object ALT = new NoCopySpan.Concrete();
    private static final Object SYM = new NoCopySpan.Concrete();
    private static final Object SELECTING = new NoCopySpan.Concrete();

    private static void adjust(Spannable spannable, Object obj) {
        int spanFlags = spannable.getSpanFlags(obj);
        if (spanFlags == PRESSED) {
            spannable.setSpan(obj, 0, 0, USED);
        } else if (spanFlags == RELEASED) {
            spannable.removeSpan(obj);
        }
    }

    public static long adjustMetaAfterKeypress(long j) {
        long j2;
        long j3;
        long j4;
        if ((1099511627776L & j) != 0) {
            j2 = (j & (-282578783305986L)) | 1 | 4294967296L;
        } else {
            j2 = j;
            if ((281474976710656L & j) != 0) {
                j2 = j & (-282578783305986L);
            }
        }
        if ((2199023255552L & j2) != 0) {
            j3 = (j2 & (-565157566611971L)) | 2 | 8589934592L;
        } else {
            j3 = j2;
            if ((562949953421312L & j2) != 0) {
                j3 = j2 & (-565157566611971L);
            }
        }
        if ((4398046511104L & j3) != 0) {
            j4 = (j3 & (-1130315133223941L)) | 4 | 17179869184L;
        } else {
            j4 = j3;
            if ((1125899906842624L & j3) != 0) {
                return j3 & (-1130315133223941L);
            }
        }
        return j4;
    }

    public static void adjustMetaAfterKeypress(Spannable spannable) {
        adjust(spannable, CAP);
        adjust(spannable, ALT);
        adjust(spannable, SYM);
        try {
            IPowerManager asInterface = IPowerManager.Stub.asInterface(ServiceManager.getService(Context.POWER_SERVICE));
            if (getMetaState(spannable, 1) <= 0) {
                asInterface.setKeyboardLight(false, 1);
            }
            if (getMetaState(spannable, 2) <= 0) {
                asInterface.setKeyboardLight(false, 2);
            }
        } catch (RemoteException e) {
        }
    }

    public static void clearMetaKeyState(Editable editable, int i) {
        if ((i & 1) != 0) {
            editable.removeSpan(CAP);
        }
        if ((i & 2) != 0) {
            editable.removeSpan(ALT);
        }
        if ((i & 4) != 0) {
            editable.removeSpan(SYM);
        }
        if ((i & 2048) != 0) {
            editable.removeSpan(SELECTING);
        }
    }

    private static int getActive(CharSequence charSequence, Object obj, int i, int i2) {
        if (charSequence instanceof Spanned) {
            int spanFlags = ((Spanned) charSequence).getSpanFlags(obj);
            if (spanFlags != LOCKED) {
                if (spanFlags != 0) {
                    return i;
                }
                return 0;
            }
        } else {
            i2 = 0;
        }
        return i2;
    }

    public static final int getMetaState(long j) {
        int i;
        int i2;
        int i3 = 0;
        if ((256 & j) != 0) {
            i3 = 0 | 256;
        } else if ((1 & j) != 0) {
            i3 = 0 | 1;
        }
        if ((512 & j) != 0) {
            i = i3 | 512;
        } else {
            i = i3;
            if ((2 & j) != 0) {
                i = i3 | 2;
            }
        }
        if ((1024 & j) != 0) {
            i2 = i | 1024;
        } else {
            i2 = i;
            if ((4 & j) != 0) {
                return i | 4;
            }
        }
        return i2;
    }

    public static final int getMetaState(long j, int i) {
        int i2;
        switch (i) {
            case 1:
                i2 = 2;
                if ((256 & j) == 0) {
                    return (1 & j) != 0 ? 1 : 0;
                }
                break;
            case 2:
                i2 = 2;
                if ((512 & j) == 0) {
                    return (2 & j) != 0 ? 1 : 0;
                }
                break;
            case 3:
            default:
                i2 = 0;
                break;
            case 4:
                i2 = 2;
                if ((1024 & j) == 0) {
                    return (4 & j) != 0 ? 1 : 0;
                }
                break;
        }
        return i2;
    }

    public static final int getMetaState(CharSequence charSequence) {
        return getActive(charSequence, CAP, 1, 256) | getActive(charSequence, ALT, 2, 512) | getActive(charSequence, SYM, 4, 1024) | getActive(charSequence, SELECTING, 2048, 2048);
    }

    public static final int getMetaState(CharSequence charSequence, int i) {
        switch (i) {
            case 1:
                return getActive(charSequence, CAP, 1, 2);
            case 2:
                return getActive(charSequence, ALT, 1, 2);
            case 4:
                return getActive(charSequence, SYM, 1, 2);
            case 2048:
                return getActive(charSequence, SELECTING, 1, 2);
            default:
                return 0;
        }
    }

    public static final int getMetaState(CharSequence charSequence, int i, KeyEvent keyEvent) {
        int metaState = keyEvent.getMetaState();
        int i2 = metaState;
        if (keyEvent.getKeyCharacterMap().getModifierBehavior() == 1) {
            i2 = metaState | getMetaState(charSequence);
        }
        return 2048 == i ? (i2 & 2048) != 0 ? 1 : 0 : getMetaState(i2, i);
    }

    public static final int getMetaState(CharSequence charSequence, KeyEvent keyEvent) {
        int metaState = keyEvent.getMetaState();
        int i = metaState;
        if (keyEvent.getKeyCharacterMap().getModifierBehavior() == 1) {
            i = metaState | getMetaState(charSequence);
        }
        return i;
    }

    public static long handleKeyDown(long j, int i, KeyEvent keyEvent) {
        long press;
        if (i == 59 || i == 60) {
            press = press(j, 1, META_SHIFT_MASK, 256L, 1099511627776L, 281474976710656L, 4294967296L);
        } else if (i == 57 || i == 58 || i == 78) {
            return press(j, 2, META_ALT_MASK, 512L, 2199023255552L, 562949953421312L, 8589934592L);
        } else {
            press = j;
            if (i == 63) {
                return press(j, 4, META_SYM_MASK, 1024L, 4398046511104L, 1125899906842624L, 17179869184L);
            }
        }
        return press;
    }

    public static long handleKeyUp(long j, int i, KeyEvent keyEvent) {
        long release;
        if (i == 59 || i == 60) {
            release = release(j, 1, META_SHIFT_MASK, 1099511627776L, 281474976710656L, 4294967296L, keyEvent);
        } else if (i == 57 || i == 58 || i == 78) {
            return release(j, 2, META_ALT_MASK, 2199023255552L, 562949953421312L, 8589934592L, keyEvent);
        } else {
            release = j;
            if (i == 63) {
                return release(j, 4, META_SYM_MASK, 4398046511104L, 1125899906842624L, 17179869184L, keyEvent);
            }
        }
        return release;
    }

    public static boolean isMetaTracker(CharSequence charSequence, Object obj) {
        return obj == CAP || obj == ALT || obj == SYM || obj == SELECTING;
    }

    public static boolean isSelectingMetaTracker(CharSequence charSequence, Object obj) {
        return obj == SELECTING;
    }

    private static long press(long j, int i, long j2, long j3, long j4, long j5, long j6) {
        if ((j & j4) == 0) {
            if ((j & j5) != 0) {
                return (((-1) ^ j2) & j) | i | j3;
            }
            if ((j & j6) == 0) {
                return (j & j3) != 0 ? j & ((-1) ^ j2) : j | i | j4;
            }
        }
        return j;
    }

    private void press(Editable editable, Object obj) {
        int spanFlags = editable.getSpanFlags(obj);
        if (spanFlags == PRESSED) {
            return;
        }
        if (spanFlags == RELEASED) {
            editable.setSpan(obj, 0, 0, LOCKED);
        } else if (spanFlags != USED) {
            if (spanFlags == LOCKED) {
                editable.removeSpan(obj);
            } else {
                editable.setSpan(obj, 0, 0, PRESSED);
            }
        }
    }

    private static long release(long j, int i, long j2, long j3, long j4, long j5, KeyEvent keyEvent) {
        long j6;
        switch (keyEvent.getKeyCharacterMap().getModifierBehavior()) {
            case 1:
                if ((j & j5) != 0) {
                    return j & ((-1) ^ j2);
                }
                j6 = j;
                if ((j & j3) != 0) {
                    return j | i | j4;
                }
                break;
            default:
                j6 = j & ((-1) ^ j2);
                break;
        }
        return j6;
    }

    private void release(Editable editable, Object obj, KeyEvent keyEvent) {
        int spanFlags = editable.getSpanFlags(obj);
        switch (keyEvent.getKeyCharacterMap().getModifierBehavior()) {
            case 1:
                if (spanFlags == USED) {
                    editable.removeSpan(obj);
                    return;
                } else if (spanFlags == PRESSED) {
                    editable.setSpan(obj, 0, 0, RELEASED);
                    return;
                } else {
                    return;
                }
            default:
                editable.removeSpan(obj);
                return;
        }
    }

    private static void resetLock(Spannable spannable, Object obj) {
        if (spannable.getSpanFlags(obj) == LOCKED) {
            spannable.removeSpan(obj);
        }
    }

    public static long resetLockedMeta(long j) {
        long j2 = j;
        if ((256 & j) != 0) {
            j2 = j & (-282578783305986L);
        }
        long j3 = j2;
        if ((512 & j2) != 0) {
            j3 = j2 & (-565157566611971L);
        }
        long j4 = j3;
        if ((1024 & j3) != 0) {
            j4 = j3 & (-1130315133223941L);
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void resetLockedMeta(Spannable spannable) {
        resetLock(spannable, CAP);
        resetLock(spannable, ALT);
        resetLock(spannable, SYM);
        resetLock(spannable, SELECTING);
    }

    public static void resetMetaState(Spannable spannable) {
        spannable.removeSpan(CAP);
        spannable.removeSpan(ALT);
        spannable.removeSpan(SYM);
        spannable.removeSpan(SELECTING);
    }

    public static void startSelecting(View view, Spannable spannable) {
        spannable.setSpan(SELECTING, 0, 0, PRESSED);
    }

    public static void stopSelecting(View view, Spannable spannable) {
        spannable.removeSpan(SELECTING);
    }

    public long clearMetaKeyState(long j, int i) {
        long j2 = j;
        if ((i & 1) != 0) {
            j2 = j;
            if ((256 & j) != 0) {
                j2 = j & (-282578783305986L);
            }
        }
        long j3 = j2;
        if ((i & 2) != 0) {
            j3 = j2;
            if ((512 & j2) != 0) {
                j3 = j2 & (-565157566611971L);
            }
        }
        long j4 = j3;
        if ((i & 4) != 0) {
            j4 = j3;
            if ((1024 & j3) != 0) {
                j4 = j3 & (-1130315133223941L);
            }
        }
        return j4;
    }

    public void clearMetaKeyState(View view, Editable editable, int i) {
        clearMetaKeyState(editable, i);
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        if (i == 59 || i == 60) {
            press(editable, CAP);
            try {
                IPowerManager asInterface = IPowerManager.Stub.asInterface(ServiceManager.getService(Context.POWER_SERVICE));
                int spanFlags = editable.getSpanFlags(CAP);
                if (spanFlags == PRESSED || spanFlags == LOCKED) {
                    asInterface.setKeyboardLight(true, 1);
                    return true;
                }
                asInterface.setKeyboardLight(false, 1);
                return true;
            } catch (RemoteException e) {
                return true;
            }
        } else if (i != 57 && i != 58 && i != 78) {
            if (i == 63) {
                press(editable, SYM);
                return true;
            }
            return false;
        } else {
            press(editable, ALT);
            try {
                IPowerManager asInterface2 = IPowerManager.Stub.asInterface(ServiceManager.getService(Context.POWER_SERVICE));
                int spanFlags2 = editable.getSpanFlags(ALT);
                if (spanFlags2 == PRESSED || spanFlags2 == LOCKED) {
                    asInterface2.setKeyboardLight(true, 2);
                    return true;
                }
                asInterface2.setKeyboardLight(false, 2);
                return true;
            } catch (RemoteException e2) {
                return true;
            }
        }
    }

    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        if (i == 59 || i == 60) {
            release(editable, CAP, keyEvent);
            return true;
        } else if (i == 57 || i == 58 || i == 78) {
            release(editable, ALT, keyEvent);
            return true;
        } else if (i == 63) {
            release(editable, SYM, keyEvent);
            return true;
        } else {
            return false;
        }
    }
}
