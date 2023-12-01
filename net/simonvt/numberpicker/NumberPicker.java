package net.simonvt.numberpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.blued.blued_third_library.R;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.timepicker.TimeModel;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker.class */
public class NumberPicker extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final TwoDigitFormatter f43821a = new TwoDigitFormatter();
    private static final char[] ah = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785};
    private int A;
    private final Scroller B;
    private final Scroller C;
    private int D;
    private SetSelectionCommand E;
    private ChangeCurrentByOneFromLongPressCommand F;
    private BeginSoftInputOnLongPressCommand G;
    private float H;
    private long I;
    private float J;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private final int P;
    private final boolean Q;
    private final Drawable R;
    private final int S;
    private int T;
    private boolean U;
    private boolean V;
    private int W;
    private int aa;
    private int ab;
    private boolean ac;
    private boolean ad;
    private SupportAccessibilityNodeProvider ae;
    private final PressedStateHelper af;
    private int ag;
    private final ImageButton b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageButton f43822c;
    private final EditText d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private int i;
    private final boolean j;
    private final int k;
    private int l;
    private String[] m;
    private int n;
    private int o;
    private int p;
    private OnValueChangeListener q;
    private OnScrollListener r;
    private Formatter s;
    private long t;
    private final SparseArray<String> u;
    private final int[] v;
    private final Paint w;
    private final Drawable x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$AccessibilityNodeProviderImpl.class */
    public class AccessibilityNodeProviderImpl extends AccessibilityNodeProvider {
        private final Rect b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final int[] f43827c = new int[2];
        private int d = Integer.MIN_VALUE;

        AccessibilityNodeProviderImpl() {
        }

        private AccessibilityNodeInfo a() {
            AccessibilityNodeInfo createAccessibilityNodeInfo = NumberPicker.this.d.createAccessibilityNodeInfo();
            createAccessibilityNodeInfo.setSource(NumberPicker.this, 2);
            if (this.d != 2) {
                createAccessibilityNodeInfo.addAction(64);
            }
            if (this.d == 2) {
                createAccessibilityNodeInfo.addAction(128);
            }
            return createAccessibilityNodeInfo;
        }

        private AccessibilityNodeInfo a(int i, int i2, int i3, int i4) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(NumberPicker.class.getName());
            obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
            obtain.setSource(NumberPicker.this);
            if (b()) {
                obtain.addChild(NumberPicker.this, 3);
            }
            obtain.addChild(NumberPicker.this, 2);
            if (c()) {
                obtain.addChild(NumberPicker.this, 1);
            }
            obtain.setParent((View) NumberPicker.this.getParentForAccessibility());
            obtain.setEnabled(NumberPicker.this.isEnabled());
            obtain.setScrollable(true);
            if (this.d != -1) {
                obtain.addAction(64);
            }
            if (this.d == -1) {
                obtain.addAction(128);
            }
            if (NumberPicker.this.isEnabled()) {
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue()) {
                    obtain.addAction(4096);
                }
                if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue()) {
                    obtain.addAction(8192);
                }
            }
            return obtain;
        }

        private AccessibilityNodeInfo a(int i, String str, int i2, int i3, int i4, int i5) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.setClassName(Button.class.getName());
            obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
            obtain.setSource(NumberPicker.this, i);
            obtain.setParent(NumberPicker.this);
            obtain.setText(str);
            obtain.setClickable(true);
            obtain.setLongClickable(true);
            obtain.setEnabled(NumberPicker.this.isEnabled());
            Rect rect = this.b;
            rect.set(i2, i3, i4, i5);
            obtain.setBoundsInParent(rect);
            int[] iArr = this.f43827c;
            NumberPicker.this.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            obtain.setBoundsInScreen(rect);
            if (this.d != i) {
                obtain.addAction(64);
            }
            if (this.d == i) {
                obtain.addAction(128);
            }
            if (NumberPicker.this.isEnabled()) {
                obtain.addAction(16);
            }
            return obtain;
        }

        private void a(int i) {
            if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService(Context.ACCESSIBILITY_SERVICE)).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
                NumberPicker.this.d.onInitializeAccessibilityEvent(obtain);
                NumberPicker.this.d.onPopulateAccessibilityEvent(obtain);
                obtain.setSource(NumberPicker.this, 2);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
            }
        }

        private void a(int i, int i2, String str) {
            if (((AccessibilityManager) NumberPicker.this.getContext().getSystemService(Context.ACCESSIBILITY_SERVICE)).isEnabled()) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
                obtain.setClassName(Button.class.getName());
                obtain.setPackageName(NumberPicker.this.getContext().getPackageName());
                obtain.getText().add(str);
                obtain.setEnabled(NumberPicker.this.isEnabled());
                obtain.setSource(NumberPicker.this, i);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.requestSendAccessibilityEvent(numberPicker, obtain);
            }
        }

        private void a(String str, int i, List<AccessibilityNodeInfo> list) {
            if (i == 1) {
                String e = e();
                if (TextUtils.isEmpty(e) || !e.toString().toLowerCase().contains(str)) {
                    return;
                }
                list.add(createAccessibilityNodeInfo(1));
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                String d = d();
                if (TextUtils.isEmpty(d) || !d.toString().toLowerCase().contains(str)) {
                    return;
                }
                list.add(createAccessibilityNodeInfo(3));
            } else {
                Editable text = NumberPicker.this.d.getText();
                if (!TextUtils.isEmpty(text) && text.toString().toLowerCase().contains(str)) {
                    list.add(createAccessibilityNodeInfo(2));
                    return;
                }
                Editable text2 = NumberPicker.this.d.getText();
                if (TextUtils.isEmpty(text2) || !text2.toString().toLowerCase().contains(str)) {
                    return;
                }
                list.add(createAccessibilityNodeInfo(2));
            }
        }

        private boolean b() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue();
        }

        private boolean c() {
            return NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue();
        }

        private String d() {
            int i = NumberPicker.this.p - 1;
            int i2 = i;
            if (NumberPicker.this.O) {
                i2 = NumberPicker.this.c(i);
            }
            if (i2 >= NumberPicker.this.n) {
                return NumberPicker.this.m == null ? NumberPicker.this.e(i2) : NumberPicker.this.m[i2 - NumberPicker.this.n];
            }
            return null;
        }

        private String e() {
            int i = NumberPicker.this.p + 1;
            int i2 = i;
            if (NumberPicker.this.O) {
                i2 = NumberPicker.this.c(i);
            }
            if (i2 <= NumberPicker.this.o) {
                return NumberPicker.this.m == null ? NumberPicker.this.e(i2) : NumberPicker.this.m[i2 - NumberPicker.this.n];
            }
            return null;
        }

        public void a(int i, int i2) {
            if (i == 1) {
                if (c()) {
                    a(i, i2, e());
                }
            } else if (i == 2) {
                a(i2);
            } else if (i == 3 && b()) {
                a(i, i2, d());
            }
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return i != -1 ? i != 1 ? i != 2 ? i != 3 ? super.createAccessibilityNodeInfo(i) : a(3, d(), NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.W + NumberPicker.this.S) : a() : a(1, e(), NumberPicker.this.getScrollX(), NumberPicker.this.aa - NumberPicker.this.S, NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop())) : a(NumberPicker.this.getScrollX(), NumberPicker.this.getScrollY(), NumberPicker.this.getScrollX() + (NumberPicker.this.getRight() - NumberPicker.this.getLeft()), NumberPicker.this.getScrollY() + (NumberPicker.this.getBottom() - NumberPicker.this.getTop()));
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptyList();
            }
            String lowerCase = str.toLowerCase();
            ArrayList arrayList = new ArrayList();
            if (i == -1) {
                a(lowerCase, 3, arrayList);
                a(lowerCase, 2, arrayList);
                a(lowerCase, 1, arrayList);
                return arrayList;
            } else if (i == 1 || i == 2 || i == 3) {
                a(lowerCase, i, arrayList);
                return arrayList;
            } else {
                return super.findAccessibilityNodeInfosByText(str, i);
            }
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i != -1) {
                if (i == 1) {
                    if (i2 == 16) {
                        if (NumberPicker.this.isEnabled()) {
                            NumberPicker.this.a(true);
                            a(i, 1);
                            return true;
                        }
                        return false;
                    } else if (i2 == 64) {
                        if (this.d != i) {
                            this.d = i;
                            a(i, 32768);
                            NumberPicker numberPicker = NumberPicker.this;
                            numberPicker.invalidate(0, numberPicker.aa, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                            return true;
                        }
                        return false;
                    } else if (i2 == 128 && this.d == i) {
                        this.d = Integer.MIN_VALUE;
                        a(i, 65536);
                        NumberPicker numberPicker2 = NumberPicker.this;
                        numberPicker2.invalidate(0, numberPicker2.aa, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                        return true;
                    } else {
                        return false;
                    }
                } else if (i == 2) {
                    if (i2 == 1) {
                        if (!NumberPicker.this.isEnabled() || NumberPicker.this.d.isFocused()) {
                            return false;
                        }
                        return NumberPicker.this.d.requestFocus();
                    } else if (i2 == 2) {
                        if (NumberPicker.this.isEnabled() && NumberPicker.this.d.isFocused()) {
                            NumberPicker.this.d.clearFocus();
                            return true;
                        }
                        return false;
                    } else if (i2 == 16) {
                        if (NumberPicker.this.isEnabled()) {
                            NumberPicker.this.b();
                            return true;
                        }
                        return false;
                    } else if (i2 == 64) {
                        if (this.d != i) {
                            this.d = i;
                            a(i, 32768);
                            NumberPicker.this.d.invalidate();
                            return true;
                        }
                        return false;
                    } else if (i2 != 128) {
                        return NumberPicker.this.d.performAccessibilityAction(i2, bundle);
                    } else {
                        if (this.d == i) {
                            this.d = Integer.MIN_VALUE;
                            a(i, 65536);
                            NumberPicker.this.d.invalidate();
                            return true;
                        }
                        return false;
                    }
                } else if (i == 3) {
                    if (i2 == 16) {
                        if (NumberPicker.this.isEnabled()) {
                            if (i == 1) {
                                z = true;
                            }
                            NumberPicker.this.a(z);
                            a(i, 1);
                            return true;
                        }
                        return false;
                    } else if (i2 == 64) {
                        if (this.d != i) {
                            this.d = i;
                            a(i, 32768);
                            NumberPicker numberPicker3 = NumberPicker.this;
                            numberPicker3.invalidate(0, 0, numberPicker3.getRight(), NumberPicker.this.W);
                            return true;
                        }
                        return false;
                    } else if (i2 == 128 && this.d == i) {
                        this.d = Integer.MIN_VALUE;
                        a(i, 65536);
                        NumberPicker numberPicker4 = NumberPicker.this;
                        numberPicker4.invalidate(0, 0, numberPicker4.getRight(), NumberPicker.this.W);
                        return true;
                    } else {
                        return false;
                    }
                }
            } else if (i2 == 64) {
                if (this.d != i) {
                    this.d = i;
                    NumberPicker.this.performAccessibilityAction(64, null);
                    return true;
                }
                return false;
            } else if (i2 == 128) {
                if (this.d == i) {
                    this.d = Integer.MIN_VALUE;
                    NumberPicker.this.performAccessibilityAction(128, null);
                    return true;
                }
                return false;
            } else if (i2 == 4096) {
                if (NumberPicker.this.isEnabled()) {
                    if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() < NumberPicker.this.getMaxValue()) {
                        NumberPicker.this.a(true);
                        return true;
                    }
                    return false;
                }
                return false;
            } else if (i2 == 8192) {
                if (NumberPicker.this.isEnabled()) {
                    if (NumberPicker.this.getWrapSelectorWheel() || NumberPicker.this.getValue() > NumberPicker.this.getMinValue()) {
                        NumberPicker.this.a(false);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return super.performAction(i, i2, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$BeginSoftInputOnLongPressCommand.class */
    public class BeginSoftInputOnLongPressCommand implements Runnable {
        BeginSoftInputOnLongPressCommand() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.b();
            NumberPicker.this.U = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$ChangeCurrentByOneFromLongPressCommand.class */
    public class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        private boolean b;

        ChangeCurrentByOneFromLongPressCommand() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.a(this.b);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed(this, numberPicker.t);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$CustomEditText.class */
    public static class CustomEditText extends EditText {
        public CustomEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.TextView
        public void onEditorAction(int i) {
            super.onEditorAction(i);
            if (i == 6) {
                clearFocus();
            }
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$Formatter.class */
    public interface Formatter {
        String a(int i);
    }

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$InputTextFilter.class */
    class InputTextFilter extends NumberKeyListener {
        InputTextFilter() {
        }

        @Override // android.text.method.NumberKeyListener, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            String valueOf;
            if (NumberPicker.this.m == null) {
                CharSequence filter = super.filter(charSequence, i, i2, spanned, i3, i4);
                CharSequence charSequence2 = filter;
                if (filter == null) {
                    charSequence2 = charSequence.subSequence(i, i2);
                }
                String str = String.valueOf(spanned.subSequence(0, i3)) + ((Object) charSequence2) + ((Object) spanned.subSequence(i4, spanned.length()));
                return "".equals(str) ? str : NumberPicker.this.a(str) > NumberPicker.this.o ? "" : charSequence2;
            }
            if (TextUtils.isEmpty(String.valueOf(charSequence.subSequence(i, i2)))) {
                return "";
            }
            String str2 = String.valueOf(spanned.subSequence(0, i3)) + ((Object) valueOf) + ((Object) spanned.subSequence(i4, spanned.length()));
            String lowerCase = String.valueOf(str2).toLowerCase();
            String[] strArr = NumberPicker.this.m;
            int length = strArr.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    return "";
                }
                String str3 = strArr[i6];
                if (str3.toLowerCase().startsWith(lowerCase)) {
                    NumberPicker.this.c(str2.length(), str3.length());
                    return str3.subSequence(i3, str3.length());
                }
                i5 = i6 + 1;
            }
        }

        @Override // android.text.method.NumberKeyListener
        protected char[] getAcceptedChars() {
            return NumberPicker.ah;
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return 1;
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$OnScrollListener.class */
    public interface OnScrollListener {
        void a(NumberPicker numberPicker, int i);
    }

    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$OnValueChangeListener.class */
    public interface OnValueChangeListener {
        void onValueChange(NumberPicker numberPicker, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$PressedStateHelper.class */
    public class PressedStateHelper implements Runnable {
        private final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        private final int f43832c = 2;
        private int d;
        private int e;

        PressedStateHelper() {
        }

        public void a() {
            this.e = 0;
            this.d = 0;
            NumberPicker.this.removeCallbacks(this);
            if (NumberPicker.this.ac) {
                NumberPicker.this.ac = false;
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.invalidate(0, numberPicker.aa, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
            }
            NumberPicker.this.ad = false;
            if (NumberPicker.this.ad) {
                NumberPicker numberPicker2 = NumberPicker.this;
                numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.W);
            }
        }

        public void a(int i) {
            a();
            this.e = 1;
            this.d = i;
            NumberPicker.this.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        public void b(int i) {
            a();
            this.e = 2;
            this.d = i;
            NumberPicker.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.e;
            if (i == 1) {
                int i2 = this.d;
                if (i2 == 1) {
                    NumberPicker.this.ac = true;
                    NumberPicker numberPicker = NumberPicker.this;
                    numberPicker.invalidate(0, numberPicker.aa, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                } else if (i2 != 2) {
                } else {
                    NumberPicker.this.ad = true;
                    NumberPicker numberPicker2 = NumberPicker.this;
                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.W);
                }
            } else if (i != 2) {
            } else {
                int i3 = this.d;
                if (i3 == 1) {
                    if (!NumberPicker.this.ac) {
                        NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                    }
                    NumberPicker numberPicker3 = NumberPicker.this;
                    numberPicker3.ac = !numberPicker3.ac;
                    NumberPicker numberPicker4 = NumberPicker.this;
                    numberPicker4.invalidate(0, numberPicker4.aa, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                } else if (i3 != 2) {
                } else {
                    if (!NumberPicker.this.ad) {
                        NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                    }
                    NumberPicker numberPicker5 = NumberPicker.this;
                    numberPicker5.ad = !numberPicker5.ad;
                    NumberPicker numberPicker6 = NumberPicker.this;
                    numberPicker6.invalidate(0, 0, numberPicker6.getRight(), NumberPicker.this.W);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$SetSelectionCommand.class */
    public class SetSelectionCommand implements Runnable {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f43834c;

        SetSelectionCommand() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.d.setSelection(this.b, this.f43834c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$SupportAccessibilityNodeProvider.class */
    public class SupportAccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        AccessibilityNodeProviderImpl f43835a;

        private SupportAccessibilityNodeProvider() {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f43835a = new AccessibilityNodeProviderImpl();
            }
        }

        public void a(int i, int i2) {
            AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = this.f43835a;
            if (accessibilityNodeProviderImpl != null) {
                accessibilityNodeProviderImpl.a(i, i2);
            }
        }

        public boolean a(int i, int i2, Bundle bundle) {
            AccessibilityNodeProviderImpl accessibilityNodeProviderImpl = this.f43835a;
            if (accessibilityNodeProviderImpl != null) {
                return accessibilityNodeProviderImpl.performAction(i, i2, bundle);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/NumberPicker$TwoDigitFormatter.class */
    public static class TwoDigitFormatter implements Formatter {
        char b;

        /* renamed from: c  reason: collision with root package name */
        java.util.Formatter f43837c;

        /* renamed from: a  reason: collision with root package name */
        final StringBuilder f43836a = new StringBuilder();
        final Object[] d = new Object[1];

        TwoDigitFormatter() {
            a(Locale.getDefault());
        }

        private void a(Locale locale) {
            this.f43837c = c(locale);
            this.b = b(locale);
        }

        private static char b(Locale locale) {
            return new DecimalFormatSymbols(locale).getZeroDigit();
        }

        private java.util.Formatter c(Locale locale) {
            return new java.util.Formatter(this.f43836a, locale);
        }

        @Override // net.simonvt.numberpicker.NumberPicker.Formatter
        public String a(int i) {
            Locale locale = Locale.getDefault();
            if (this.b != b(locale)) {
                a(locale);
            }
            this.d[0] = Integer.valueOf(i);
            StringBuilder sb = this.f43836a;
            sb.delete(0, sb.length());
            this.f43837c.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, this.d);
            return this.f43837c.toString();
        }
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.numberPickerStyle);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.t = 300L;
        this.u = new SparseArray<>();
        this.v = new int[3];
        this.z = Integer.MIN_VALUE;
        this.T = 0;
        this.ag = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberPicker, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NumberPicker_internalLayout, 0);
        this.Q = resourceId != 0;
        this.P = obtainStyledAttributes.getColor(R.styleable.NumberPicker_solidColor, 0);
        this.R = obtainStyledAttributes.getDrawable(R.styleable.NumberPicker_selectionDivider);
        this.S = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_selectionDividerHeight, (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_selectionDividersDistance, (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics()));
        this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_internalMinHeight, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_internalMaxHeight, -1);
        this.g = dimensionPixelSize;
        int i2 = this.f;
        if (i2 != -1 && dimensionPixelSize != -1 && i2 > dimensionPixelSize) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_internalMinWidth, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_internalMaxWidth, -1);
        this.i = dimensionPixelSize2;
        int i3 = this.h;
        if (i3 != -1 && dimensionPixelSize2 != -1 && i3 > dimensionPixelSize2) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        this.j = this.i == -1;
        this.x = obtainStyledAttributes.getDrawable(R.styleable.NumberPicker_virtualButtonPressedDrawable);
        obtainStyledAttributes.recycle();
        this.af = new PressedStateHelper();
        setWillNotDraw(!this.Q);
        ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(resourceId, (ViewGroup) this, true);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: net.simonvt.numberpicker.NumberPicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                NumberPicker.this.c();
                NumberPicker.this.d.clearFocus();
                if (view.getId() == R.id.np__increment) {
                    NumberPicker.this.a(true);
                } else {
                    NumberPicker.this.a(false);
                }
            }
        };
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: net.simonvt.numberpicker.NumberPicker.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                NumberPicker.this.c();
                NumberPicker.this.d.clearFocus();
                if (view.getId() == R.id.np__increment) {
                    NumberPicker.this.a(true, 0L);
                    return true;
                }
                NumberPicker.this.a(false, 0L);
                return true;
            }
        };
        if (this.Q) {
            this.b = null;
        } else {
            ImageButton imageButton = (ImageButton) findViewById(R.id.np__increment);
            this.b = imageButton;
            imageButton.setOnClickListener(onClickListener);
            this.b.setOnLongClickListener(onLongClickListener);
        }
        if (this.Q) {
            this.f43822c = null;
        } else {
            ImageButton imageButton2 = (ImageButton) findViewById(R.id.np__decrement);
            this.f43822c = imageButton2;
            imageButton2.setOnClickListener(onClickListener);
            this.f43822c.setOnLongClickListener(onLongClickListener);
        }
        EditText editText = (EditText) findViewById(R.id.np__numberpicker_input);
        this.d = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: net.simonvt.numberpicker.NumberPicker.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Tracker.onFocusChange(view, z);
                if (z) {
                    NumberPicker.this.d.selectAll();
                    return;
                }
                NumberPicker.this.d.setSelection(0, 0);
                NumberPicker.this.a(view);
            }
        });
        this.d.setFilters(new InputFilter[]{new InputTextFilter()});
        this.d.setRawInputType(2);
        this.d.setImeOptions(6);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.L = viewConfiguration.getScaledTouchSlop();
        this.M = viewConfiguration.getScaledMinimumFlingVelocity();
        this.N = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        this.k = (int) this.d.getTextSize();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(this.k);
        paint.setTypeface(this.d.getTypeface());
        paint.setColor(this.d.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
        this.w = paint;
        this.B = new Scroller(getContext(), null, true);
        this.C = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        h();
        if (Build.VERSION.SDK_INT < 16 || getImportantForAccessibility() != 0) {
            return;
        }
        setImportantForAccessibility(1);
    }

    private int a(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return i;
                }
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
            }
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
    }

    public static int a(int i, int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            i4 = mode != 1073741824 ? i : size;
        } else {
            i4 = i;
            if (size < i) {
                i4 = 16777216 | size;
            }
        }
        return i4 | ((-16777216) & i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        try {
            if (this.m == null) {
                return Integer.parseInt(str);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.m.length) {
                    return Integer.parseInt(str);
                }
                str = str.toLowerCase();
                if (this.m[i2].toLowerCase().startsWith(str)) {
                    return this.n + i2;
                }
                i = i2 + 1;
            }
        } catch (NumberFormatException e) {
            return this.n;
        }
    }

    private void a(int i) {
        if (this.T == i) {
            return;
        }
        this.T = i;
        OnScrollListener onScrollListener = this.r;
        if (onScrollListener != null) {
            onScrollListener.a(this, i);
        }
    }

    private void a(int i, boolean z) {
        if (this.p == i) {
            return;
        }
        int c2 = this.O ? c(i) : Math.min(Math.max(i, this.n), this.o);
        int i2 = this.p;
        this.p = c2;
        h();
        if (z) {
            b(i2, c2);
        }
        e();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        String valueOf = String.valueOf(((TextView) view).getText());
        if (TextUtils.isEmpty(valueOf)) {
            h();
        } else {
            a(a(valueOf.toString()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!this.Q) {
            if (z) {
                a(this.p + 1, true);
                return;
            } else {
                a(this.p - 1, true);
                return;
            }
        }
        this.d.setVisibility(4);
        if (!a(this.B)) {
            a(this.C);
        }
        this.D = 0;
        if (z) {
            this.B.a(0, 0, 0, -this.y, 300);
        } else {
            this.B.a(0, 0, 0, this.y, 300);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.F;
        if (changeCurrentByOneFromLongPressCommand == null) {
            this.F = new ChangeCurrentByOneFromLongPressCommand();
        } else {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.F.a(z);
        postDelayed(this.F, j);
    }

    private void a(int[] iArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length - 1) {
                break;
            }
            int i3 = i2 + 1;
            iArr[i2] = iArr[i3];
            i = i3;
        }
        int i4 = iArr[iArr.length - 2] + 1;
        int i5 = i4;
        if (this.O) {
            i5 = i4;
            if (i4 > this.o) {
                i5 = this.n;
            }
        }
        iArr[iArr.length - 1] = i5;
        d(i5);
    }

    private boolean a(Scroller scroller) {
        scroller.a(true);
        int e = scroller.e() - scroller.b();
        int i = this.z - ((this.A + e) % this.y);
        if (i != 0) {
            int abs = Math.abs(i);
            int i2 = this.y;
            int i3 = i;
            if (abs > i2 / 2) {
                i3 = i > 0 ? i - i2 : i + i2;
            }
            scrollBy(0, e + i3);
            return true;
        }
        return false;
    }

    private int b(int i, int i2, int i3) {
        return i != -1 ? a(Math.max(i, i2), i3, 0) : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            if (this.Q) {
                this.d.setVisibility(0);
            }
            this.d.requestFocus();
            inputMethodManager.showSoftInput(this.d, 0);
        }
    }

    private void b(int i) {
        this.D = 0;
        if (i > 0) {
            this.B.a(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.B.a(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    private void b(int i, int i2) {
        OnValueChangeListener onValueChangeListener = this.q;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, i, this.p);
        }
    }

    private void b(Scroller scroller) {
        if (scroller == this.B) {
            if (!m()) {
                h();
            }
            a(0);
        } else if (this.T != 1) {
            h();
        }
    }

    private void b(int[] iArr) {
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (i <= 0) {
                break;
            }
            iArr[i] = iArr[i - 1];
            length = i;
        }
        int i2 = iArr[1] - 1;
        int i3 = i2;
        if (this.O) {
            i3 = i2;
            if (i2 < this.n) {
                i3 = this.o;
            }
        }
        iArr[0] = i3;
        d(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i) {
        int i2 = this.o;
        if (i > i2) {
            int i3 = this.n;
            return (i3 + ((i - i2) % (i2 - i3))) - 1;
        }
        int i4 = this.n;
        return i < i4 ? (i2 - ((i4 - i) % (i2 - i4))) + 1 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager == null || !inputMethodManager.isActive(this.d)) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        if (this.Q) {
            this.d.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2) {
        SetSelectionCommand setSelectionCommand = this.E;
        if (setSelectionCommand == null) {
            this.E = new SetSelectionCommand();
        } else {
            removeCallbacks(setSelectionCommand);
        }
        this.E.b = i;
        this.E.f43834c = i2;
        post(this.E);
    }

    private void d() {
        int i;
        if (this.j) {
            String[] strArr = this.m;
            int i2 = 0;
            if (strArr == null) {
                float f = 0.0f;
                int i3 = 0;
                while (i3 <= 9) {
                    float measureText = this.w.measureText(f(i3));
                    float f2 = f;
                    if (measureText > f) {
                        f2 = measureText;
                    }
                    i3++;
                    f = f2;
                }
                int i4 = this.o;
                while (true) {
                    int i5 = i4;
                    if (i5 <= 0) {
                        break;
                    }
                    i2++;
                    i4 = i5 / 10;
                }
                i = (int) (i2 * f);
            } else {
                int length = strArr.length;
                i = 0;
                int i6 = 0;
                while (i6 < length) {
                    float measureText2 = this.w.measureText(this.m[i6]);
                    int i7 = i;
                    if (measureText2 > i) {
                        i7 = (int) measureText2;
                    }
                    i6++;
                    i = i7;
                }
            }
            int paddingLeft = i + this.d.getPaddingLeft() + this.d.getPaddingRight();
            if (this.i != paddingLeft) {
                int i8 = this.h;
                if (paddingLeft > i8) {
                    this.i = paddingLeft;
                } else {
                    this.i = i8;
                }
                invalidate();
            }
        }
    }

    private void d(int i) {
        String str;
        SparseArray<String> sparseArray = this.u;
        if (sparseArray.get(i) != null) {
            return;
        }
        int i2 = this.n;
        if (i < i2 || i > this.o) {
            str = "";
        } else {
            String[] strArr = this.m;
            str = strArr != null ? strArr[i - i2] : e(i);
        }
        sparseArray.put(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(int i) {
        Formatter formatter = this.s;
        return formatter != null ? formatter.a(i) : f(i);
    }

    private void e() {
        this.u.clear();
        int[] iArr = this.v;
        int value = getValue();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.v.length) {
                return;
            }
            int i3 = (i2 - 1) + value;
            int i4 = i3;
            if (this.O) {
                i4 = c(i3);
            }
            iArr[i2] = i4;
            d(iArr[i2]);
            i = i2 + 1;
        }
    }

    private static String f(int i) {
        return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
    }

    private void f() {
        e();
        int[] iArr = this.v;
        int bottom = (int) ((((getBottom() - getTop()) - (iArr.length * this.k)) / iArr.length) + 0.5f);
        this.l = bottom;
        this.y = this.k + bottom;
        int baseline = (this.d.getBaseline() + this.d.getTop()) - (this.y * 1);
        this.z = baseline;
        this.A = baseline;
        h();
    }

    private void g() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.k) / 2);
    }

    private SupportAccessibilityNodeProvider getSupportAccessibilityNodeProvider() {
        return new SupportAccessibilityNodeProvider();
    }

    public static final Formatter getTwoDigitFormatter() {
        return f43821a;
    }

    private boolean h() {
        String[] strArr = this.m;
        String e = strArr == null ? e(this.p) : strArr[this.p - this.n];
        if (TextUtils.isEmpty(e) || e.equals(this.d.getText().toString())) {
            return false;
        }
        this.d.setText(e);
        return true;
    }

    private void i() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.F;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
    }

    private void j() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.G;
        if (beginSoftInputOnLongPressCommand == null) {
            this.G = new BeginSoftInputOnLongPressCommand();
        } else {
            removeCallbacks(beginSoftInputOnLongPressCommand);
        }
        postDelayed(this.G, ViewConfiguration.getLongPressTimeout());
    }

    private void k() {
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.G;
        if (beginSoftInputOnLongPressCommand != null) {
            removeCallbacks(beginSoftInputOnLongPressCommand);
        }
    }

    private void l() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.F;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        SetSelectionCommand setSelectionCommand = this.E;
        if (setSelectionCommand != null) {
            removeCallbacks(setSelectionCommand);
        }
        BeginSoftInputOnLongPressCommand beginSoftInputOnLongPressCommand = this.G;
        if (beginSoftInputOnLongPressCommand != null) {
            removeCallbacks(beginSoftInputOnLongPressCommand);
        }
        this.af.a();
    }

    private boolean m() {
        int i = this.z - this.A;
        if (i != 0) {
            this.D = 0;
            int abs = Math.abs(i);
            int i2 = this.y;
            int i3 = i;
            if (abs > i2 / 2) {
                int i4 = i2;
                if (i > 0) {
                    i4 = -i2;
                }
                i3 = i + i4;
            }
            this.C.a(0, 0, 0, i3, 800);
            invalidate();
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.B;
        Scroller scroller2 = scroller;
        if (scroller.a()) {
            Scroller scroller3 = this.C;
            scroller2 = scroller3;
            if (scroller3.a()) {
                return;
            }
        }
        scroller2.f();
        int b = scroller2.b();
        if (this.D == 0) {
            this.D = scroller2.d();
        }
        scrollBy(0, b - this.D);
        this.D = b;
        if (scroller2.a()) {
            b(scroller2);
        } else {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.Q) {
            if (((AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE)).isEnabled()) {
                int y = (int) motionEvent.getY();
                int i = y < this.W ? 3 : y > this.aa ? 1 : 2;
                int action = motionEvent.getAction() & 255;
                SupportAccessibilityNodeProvider supportAccessibilityNodeProvider = getSupportAccessibilityNodeProvider();
                if (action == 7) {
                    int i2 = this.ab;
                    if (i2 == i || i2 == -1) {
                        return false;
                    }
                    supportAccessibilityNodeProvider.a(i2, 256);
                    supportAccessibilityNodeProvider.a(i, 128);
                    this.ab = i;
                    supportAccessibilityNodeProvider.a(i, 64, null);
                    return false;
                } else if (action == 9) {
                    supportAccessibilityNodeProvider.a(i, 128);
                    this.ab = i;
                    supportAccessibilityNodeProvider.a(i, 64, null);
                    return false;
                } else if (action != 10) {
                    return false;
                } else {
                    supportAccessibilityNodeProvider.a(i, 256);
                    this.ab = -1;
                    return false;
                }
            }
            return false;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        requestFocus();
        r3.ag = r0;
        l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
        if (r3.B.a() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
        if (r0 != 20) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009e, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a1, code lost:
        a(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a7, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return true;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r4) {
        /*
            r3 = this;
            r0 = r4
            int r0 = r0.getKeyCode()
            r5 = r0
            r0 = r5
            r1 = 19
            if (r0 == r1) goto L27
            r0 = r5
            r1 = 20
            if (r0 == r1) goto L27
            r0 = r5
            r1 = 23
            if (r0 == r1) goto L20
            r0 = r5
            r1 = 66
            if (r0 == r1) goto L20
            goto La9
        L20:
            r0 = r3
            r0.l()
            goto La9
        L27:
            r0 = r3
            boolean r0 = r0.Q
            if (r0 != 0) goto L31
            goto La9
        L31:
            r0 = r4
            int r0 = r0.getAction()
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L51
            r0 = r6
            r1 = 1
            if (r0 == r1) goto L42
            goto La9
        L42:
            r0 = r3
            int r0 = r0.ag
            r1 = r5
            if (r0 != r1) goto La9
            r0 = r3
            r1 = -1
            r0.ag = r1
            r0 = 1
            return r0
        L51:
            r0 = r3
            boolean r0 = r0.O
            if (r0 != 0) goto L6f
            r0 = r5
            r1 = 20
            if (r0 != r1) goto L61
            goto L6f
        L61:
            r0 = r3
            int r0 = r0.getValue()
            r1 = r3
            int r1 = r1.getMinValue()
            if (r0 <= r1) goto La9
            goto L7a
        L6f:
            r0 = r3
            int r0 = r0.getValue()
            r1 = r3
            int r1 = r1.getMaxValue()
            if (r0 >= r1) goto La9
        L7a:
            r0 = r3
            boolean r0 = r0.requestFocus()
            r0 = r3
            r1 = r5
            r0.ag = r1
            r0 = r3
            r0.l()
            r0 = r3
            net.simonvt.numberpicker.Scroller r0 = r0.B
            boolean r0 = r0.a()
            if (r0 == 0) goto La7
            r0 = r5
            r1 = 20
            if (r0 != r1) goto L9e
            r0 = 1
            r7 = r0
            goto La1
        L9e:
            r0 = 0
            r7 = r0
        La1:
            r0 = r3
            r1 = r7
            r0.a(r1)
        La7:
            r0 = 1
            return r0
        La9:
            r0 = r3
            r1 = r4
            boolean r0 = super.dispatchKeyEvent(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.simonvt.numberpicker.NumberPicker.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            l();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            l();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.Q) {
            if (this.ae == null) {
                this.ae = new SupportAccessibilityNodeProvider();
            }
            return this.ae.f43835a;
        }
        return super.getAccessibilityNodeProvider();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public String[] getDisplayedValues() {
        return this.m;
    }

    public int getMaxValue() {
        return this.o;
    }

    public int getMinValue() {
        return this.n;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.p;
    }

    public boolean getWrapSelectorWheel() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.Q) {
            super.onDraw(canvas);
            return;
        }
        float right = (getRight() - getLeft()) / 2;
        float f = this.A;
        Drawable drawable = this.x;
        if (drawable != null && this.T == 0) {
            if (this.ad) {
                drawable.setState(PRESSED_ENABLED_STATE_SET);
                this.x.setBounds(0, 0, getRight(), this.W);
                this.x.draw(canvas);
            }
            if (this.ac) {
                this.x.setState(PRESSED_ENABLED_STATE_SET);
                this.x.setBounds(0, this.aa, getRight(), getBottom());
                this.x.draw(canvas);
            }
        }
        int[] iArr = this.v;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                break;
            }
            String str = this.u.get(iArr[i2]);
            if (i2 != 1 || this.d.getVisibility() != 0) {
                canvas.drawText(str, right, f, this.w);
            }
            f += this.y;
            i = i2 + 1;
        }
        Drawable drawable2 = this.R;
        if (drawable2 != null) {
            int i3 = this.W;
            drawable2.setBounds(0, i3, getRight(), this.S + i3);
            this.R.draw(canvas);
            int i4 = this.aa;
            this.R.setBounds(0, i4 - this.S, getRight(), i4);
            this.R.draw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(true);
        accessibilityEvent.setScrollY((this.n + this.p) * this.y);
        accessibilityEvent.setMaxScrollY((this.o - this.n) * this.y);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Q && isEnabled() && (motionEvent.getAction() & 255) == 0) {
            l();
            this.d.setVisibility(4);
            float y = motionEvent.getY();
            this.H = y;
            this.J = y;
            this.I = motionEvent.getEventTime();
            this.U = false;
            this.V = false;
            float f = this.H;
            if (f < this.W) {
                if (this.T == 0) {
                    this.af.a(2);
                }
            } else if (f > this.aa && this.T == 0) {
                this.af.a(1);
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!this.B.a()) {
                this.B.a(true);
                this.C.a(true);
                a(0);
                return true;
            } else if (!this.C.a()) {
                this.B.a(true);
                this.C.a(true);
                return true;
            } else {
                float f2 = this.H;
                if (f2 < this.W) {
                    c();
                    a(false, ViewConfiguration.getLongPressTimeout());
                    return true;
                } else if (f2 > this.aa) {
                    c();
                    a(true, ViewConfiguration.getLongPressTimeout());
                    return true;
                } else {
                    this.V = true;
                    j();
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.Q) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.d.getMeasuredWidth();
        int measuredHeight2 = this.d.getMeasuredHeight();
        int i5 = (measuredWidth - measuredWidth2) / 2;
        int i6 = (measuredHeight - measuredHeight2) / 2;
        this.d.layout(i5, i6, measuredWidth2 + i5, measuredHeight2 + i6);
        if (z) {
            f();
            g();
            int height = getHeight();
            int i7 = this.e;
            int i8 = (height - i7) / 2;
            int i9 = this.S;
            int i10 = i8 - i9;
            this.W = i10;
            this.aa = i10 + (i9 * 2) + i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.Q) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(a(i, this.i), a(i2, this.g));
        setMeasuredDimension(b(this.h, getMeasuredWidth(), i), b(this.f, getMeasuredHeight(), i2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.Q) {
            if (this.K == null) {
                this.K = VelocityTracker.obtain();
            }
            this.K.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action != 1) {
                if (action == 2 && !this.U) {
                    float y = motionEvent.getY();
                    if (this.T == 1) {
                        scrollBy(0, (int) (y - this.J));
                        invalidate();
                    } else if (((int) Math.abs(y - this.H)) > this.L) {
                        l();
                        a(1);
                    }
                    this.J = y;
                    return true;
                }
                return true;
            }
            k();
            i();
            this.af.a();
            VelocityTracker velocityTracker = this.K;
            velocityTracker.computeCurrentVelocity(1000, this.N);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.M) {
                b(yVelocity);
                a(2);
            } else {
                int y2 = (int) motionEvent.getY();
                int abs = (int) Math.abs(y2 - this.H);
                motionEvent.getEventTime();
                ViewConfiguration.getTapTimeout();
                if (abs > this.L) {
                    m();
                } else if (this.V) {
                    this.V = false;
                    b();
                } else {
                    int i = (y2 / this.y) - 1;
                    if (i > 0) {
                        a(true);
                        this.af.b(1);
                    } else if (i < 0) {
                        a(false);
                        this.af.b(2);
                    }
                }
                a(0);
            }
            this.K.recycle();
            this.K = null;
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        int[] iArr = this.v;
        if (!this.O && i2 > 0 && iArr[1] <= this.n) {
            this.A = this.z;
        } else if (!this.O && i2 < 0 && iArr[1] >= this.o) {
            this.A = this.z;
        } else {
            this.A += i2;
            while (true) {
                int i3 = this.A;
                if (i3 - this.z <= this.l) {
                    break;
                }
                this.A = i3 - this.y;
                b(iArr);
                a(iArr[1], true);
                if (!this.O && iArr[1] <= this.n) {
                    this.A = this.z;
                }
            }
            while (true) {
                int i4 = this.A;
                if (i4 - this.z >= (-this.l)) {
                    return;
                }
                this.A = i4 + this.y;
                a(iArr);
                a(iArr[1], true);
                if (!this.O && iArr[1] >= this.o) {
                    this.A = this.z;
                }
            }
        }
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.m == strArr) {
            return;
        }
        this.m = strArr;
        if (strArr != null) {
            this.d.setRawInputType(ConnectivityManager.CALLBACK_PRECHECK);
        } else {
            this.d.setRawInputType(2);
        }
        h();
        e();
        d();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.Q) {
            this.b.setEnabled(z);
        }
        if (!this.Q) {
            this.f43822c.setEnabled(z);
        }
        this.d.setEnabled(z);
    }

    public void setFormatter(Formatter formatter) {
        if (formatter == this.s) {
            return;
        }
        this.s = formatter;
        e();
        h();
    }

    public void setInputTextEnable(boolean z) {
        this.d.setEnabled(z);
    }

    public void setMaxValue(int i) {
        if (this.o == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.o = i;
        if (i < this.p) {
            this.p = i;
        }
        setWrapSelectorWheel(this.o - this.n > this.v.length);
        e();
        h();
        d();
        invalidate();
    }

    public void setMinValue(int i) {
        if (this.n == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.n = i;
        if (i > this.p) {
            this.p = i;
        }
        setWrapSelectorWheel(this.o - this.n > this.v.length);
        e();
        h();
        d();
        invalidate();
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.t = j;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.r = onScrollListener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.q = onValueChangeListener;
    }

    public void setValue(int i) {
        a(i, false);
    }

    public void setWheelTextColor(int i) {
        this.w.setColor(i);
        this.d.setTextColor(i);
        postInvalidate();
    }

    public void setWrapSelectorWheel(boolean z) {
        boolean z2 = this.o - this.n >= this.v.length;
        if ((!z || z2) && z != this.O) {
            this.O = z;
        }
    }
}
