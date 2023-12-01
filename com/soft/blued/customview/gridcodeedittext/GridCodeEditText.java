package com.soft.blued.customview.gridcodeedittext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.gridcodeedittext.imebugfixer.BugFixedEditText;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/GridCodeEditText.class */
public class GridCodeEditText extends LinearLayout implements PasswordView {

    /* renamed from: a  reason: collision with root package name */
    private ColorStateList f28593a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28594c;
    private int d;
    private int e;
    private Drawable f;
    private Drawable g;
    private int h;
    private String i;
    private int j;
    private int k;
    private String[] l;
    private TextView[] m;
    private BugFixedEditText n;
    private OnPasswordChangedListener o;
    private PasswordTransformationMethod p;
    private View.OnClickListener q;
    private BugFixedEditText.OnDelKeyEventListener r;
    private TextWatcher s;
    @Deprecated
    private View.OnKeyListener t;

    /* renamed from: com.soft.blued.customview.gridcodeedittext.GridCodeEditText$5  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/GridCodeEditText$5.class */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28599a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PasswordType.values().length];
            f28599a = iArr;
            try {
                iArr[PasswordType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f28599a[PasswordType.TEXTVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f28599a[PasswordType.TEXTWEB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/GridCodeEditText$OnPasswordChangedListener.class */
    public interface OnPasswordChangedListener {
        void a(String str);

        void b(String str);
    }

    public GridCodeEditText(Context context) {
        super(context);
        this.b = 16;
        this.q = new View.OnClickListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GridCodeEditText.this.c();
            }
        };
        this.r = new BugFixedEditText.OnDelKeyEventListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.2
            @Override // com.soft.blued.customview.gridcodeedittext.imebugfixer.BugFixedEditText.OnDelKeyEventListener
            public void a() {
                int length = GridCodeEditText.this.l.length;
                while (true) {
                    int i = length - 1;
                    if (i < 0) {
                        return;
                    }
                    if (GridCodeEditText.this.l[i] != null) {
                        GridCodeEditText.this.l[i] = null;
                        GridCodeEditText.this.m[i].setText((CharSequence) null);
                        GridCodeEditText.this.d();
                        return;
                    }
                    GridCodeEditText.this.m[i].setText((CharSequence) null);
                    length = i;
                }
            }
        };
        this.s = new TextWatcher() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null) {
                    return;
                }
                String charSequence2 = charSequence.toString();
                if (charSequence2.length() == 1) {
                    GridCodeEditText.this.l[0] = charSequence2;
                    GridCodeEditText.this.d();
                } else if (charSequence2.length() == 2) {
                    String substring = charSequence2.substring(1);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= GridCodeEditText.this.l.length) {
                            break;
                        } else if (GridCodeEditText.this.l[i5] == null) {
                            GridCodeEditText.this.l[i5] = substring;
                            GridCodeEditText.this.m[i5].setText(substring);
                            GridCodeEditText.this.d();
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    GridCodeEditText.this.n.removeTextChangedListener(this);
                    GridCodeEditText.this.n.setText(GridCodeEditText.this.l[0]);
                    if (GridCodeEditText.this.n.getText().length() >= 1) {
                        GridCodeEditText.this.n.setSelection(1);
                    }
                    GridCodeEditText.this.n.addTextChangedListener(this);
                }
            }
        };
        this.t = new View.OnKeyListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                    GridCodeEditText.this.r.a();
                    return true;
                }
                return false;
            }
        };
        a(context, null, 0);
    }

    public GridCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 16;
        this.q = new View.OnClickListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GridCodeEditText.this.c();
            }
        };
        this.r = new BugFixedEditText.OnDelKeyEventListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.2
            @Override // com.soft.blued.customview.gridcodeedittext.imebugfixer.BugFixedEditText.OnDelKeyEventListener
            public void a() {
                int length = GridCodeEditText.this.l.length;
                while (true) {
                    int i = length - 1;
                    if (i < 0) {
                        return;
                    }
                    if (GridCodeEditText.this.l[i] != null) {
                        GridCodeEditText.this.l[i] = null;
                        GridCodeEditText.this.m[i].setText((CharSequence) null);
                        GridCodeEditText.this.d();
                        return;
                    }
                    GridCodeEditText.this.m[i].setText((CharSequence) null);
                    length = i;
                }
            }
        };
        this.s = new TextWatcher() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null) {
                    return;
                }
                String charSequence2 = charSequence.toString();
                if (charSequence2.length() == 1) {
                    GridCodeEditText.this.l[0] = charSequence2;
                    GridCodeEditText.this.d();
                } else if (charSequence2.length() == 2) {
                    String substring = charSequence2.substring(1);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= GridCodeEditText.this.l.length) {
                            break;
                        } else if (GridCodeEditText.this.l[i5] == null) {
                            GridCodeEditText.this.l[i5] = substring;
                            GridCodeEditText.this.m[i5].setText(substring);
                            GridCodeEditText.this.d();
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    GridCodeEditText.this.n.removeTextChangedListener(this);
                    GridCodeEditText.this.n.setText(GridCodeEditText.this.l[0]);
                    if (GridCodeEditText.this.n.getText().length() >= 1) {
                        GridCodeEditText.this.n.setSelection(1);
                    }
                    GridCodeEditText.this.n.addTextChangedListener(this);
                }
            }
        };
        this.t = new View.OnKeyListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                    GridCodeEditText.this.r.a();
                    return true;
                }
                return false;
            }
        };
        a(context, attributeSet, 0);
    }

    public GridCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 16;
        this.q = new View.OnClickListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GridCodeEditText.this.c();
            }
        };
        this.r = new BugFixedEditText.OnDelKeyEventListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.2
            @Override // com.soft.blued.customview.gridcodeedittext.imebugfixer.BugFixedEditText.OnDelKeyEventListener
            public void a() {
                int length = GridCodeEditText.this.l.length;
                while (true) {
                    int i2 = length - 1;
                    if (i2 < 0) {
                        return;
                    }
                    if (GridCodeEditText.this.l[i2] != null) {
                        GridCodeEditText.this.l[i2] = null;
                        GridCodeEditText.this.m[i2].setText((CharSequence) null);
                        GridCodeEditText.this.d();
                        return;
                    }
                    GridCodeEditText.this.m[i2].setText((CharSequence) null);
                    length = i2;
                }
            }
        };
        this.s = new TextWatcher() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                if (charSequence == null) {
                    return;
                }
                String charSequence2 = charSequence.toString();
                if (charSequence2.length() == 1) {
                    GridCodeEditText.this.l[0] = charSequence2;
                    GridCodeEditText.this.d();
                } else if (charSequence2.length() == 2) {
                    String substring = charSequence2.substring(1);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= GridCodeEditText.this.l.length) {
                            break;
                        } else if (GridCodeEditText.this.l[i5] == null) {
                            GridCodeEditText.this.l[i5] = substring;
                            GridCodeEditText.this.m[i5].setText(substring);
                            GridCodeEditText.this.d();
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    GridCodeEditText.this.n.removeTextChangedListener(this);
                    GridCodeEditText.this.n.setText(GridCodeEditText.this.l[0]);
                    if (GridCodeEditText.this.n.getText().length() >= 1) {
                        GridCodeEditText.this.n.setSelection(1);
                    }
                    GridCodeEditText.this.n.addTextChangedListener(this);
                }
            }
        };
        this.t = new View.OnKeyListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                    GridCodeEditText.this.r.a();
                    return true;
                }
                return false;
            }
        };
        a(context, attributeSet, i);
    }

    public GridCodeEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = 16;
        this.q = new View.OnClickListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GridCodeEditText.this.c();
            }
        };
        this.r = new BugFixedEditText.OnDelKeyEventListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.2
            @Override // com.soft.blued.customview.gridcodeedittext.imebugfixer.BugFixedEditText.OnDelKeyEventListener
            public void a() {
                int length = GridCodeEditText.this.l.length;
                while (true) {
                    int i22 = length - 1;
                    if (i22 < 0) {
                        return;
                    }
                    if (GridCodeEditText.this.l[i22] != null) {
                        GridCodeEditText.this.l[i22] = null;
                        GridCodeEditText.this.m[i22].setText((CharSequence) null);
                        GridCodeEditText.this.d();
                        return;
                    }
                    GridCodeEditText.this.m[i22].setText((CharSequence) null);
                    length = i22;
                }
            }
        };
        this.s = new TextWatcher() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i22, int i222, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i22, int i222, int i3) {
                if (charSequence == null) {
                    return;
                }
                String charSequence2 = charSequence.toString();
                if (charSequence2.length() == 1) {
                    GridCodeEditText.this.l[0] = charSequence2;
                    GridCodeEditText.this.d();
                } else if (charSequence2.length() == 2) {
                    String substring = charSequence2.substring(1);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= GridCodeEditText.this.l.length) {
                            break;
                        } else if (GridCodeEditText.this.l[i5] == null) {
                            GridCodeEditText.this.l[i5] = substring;
                            GridCodeEditText.this.m[i5].setText(substring);
                            GridCodeEditText.this.d();
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    GridCodeEditText.this.n.removeTextChangedListener(this);
                    GridCodeEditText.this.n.setText(GridCodeEditText.this.l[0]);
                    if (GridCodeEditText.this.n.getText().length() >= 1) {
                        GridCodeEditText.this.n.setSelection(1);
                    }
                    GridCodeEditText.this.n.addTextChangedListener(this);
                }
            }
        };
        this.t = new View.OnKeyListener() { // from class: com.soft.blued.customview.gridcodeedittext.GridCodeEditText.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i22, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                    GridCodeEditText.this.r.a();
                    return true;
                }
                return false;
            }
        };
        a(context, attributeSet, i);
    }

    private void a(Context context) {
        setShowDividers(0);
        setOrientation(0);
        this.p = new CustomPasswordTransformationMethod(this.i);
        b(context);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        b(context, attributeSet, i);
        a(context);
    }

    private GradientDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.e);
        gradientDrawable.setStroke(this.f28594c, this.d);
        return gradientDrawable;
    }

    private void b(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(R.layout.view_grid_code_edit_text, (ViewGroup) this, false);
        BugFixedEditText bugFixedEditText = (BugFixedEditText) inflate.findViewById(2131364751);
        this.n = bugFixedEditText;
        bugFixedEditText.setMaxEms(this.h);
        this.n.addTextChangedListener(this.s);
        this.n.setDelKeyEventListener(this.r);
        this.n.setLayoutParams(new LinearLayout.LayoutParams(this.k, -1));
        addView(inflate);
        setCustomAttr(this.n);
        this.m[0] = this.n;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.h) {
                setOnClickListener(this.q);
                return;
            }
            addView(from.inflate(R.layout.view_gcet_divider, (ViewGroup) this, false));
            TextView textView = (ShapeTextView) from.inflate(R.layout.view_text, (ViewGroup) this, false);
            setCustomAttr(textView);
            addView(textView, new LinearLayout.LayoutParams(this.k, -1));
            this.m[i2] = textView;
            i = i2 + 1;
        }
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridCodeEditText, i, 0);
        if (obtainStyledAttributes.hasValue(6)) {
            this.f28593a = ColorStateList.valueOf(BluedSkinUtils.a(context, obtainStyledAttributes.getResourceId(6, 2131102254)));
        } else {
            this.f28593a = obtainStyledAttributes.getColorStateList(6);
        }
        if (this.f28593a == null) {
            this.f28593a = ColorStateList.valueOf(getResources().getColor(17170435));
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        if (dimensionPixelSize != -1) {
            this.b = DensityUtils.c(context, dimensionPixelSize);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= attributeSet.getAttributeCount()) {
                break;
            }
            if ("layout_height".equals(attributeSet.getAttributeName(i3))) {
                String attributeValue = attributeSet.getAttributeValue(i3);
                this.k = DensityUtils.a(context, Float.parseFloat(attributeValue.substring(0, attributeValue.lastIndexOf("."))));
            }
            i2 = i3 + 1;
        }
        this.f28594c = (int) obtainStyledAttributes.getDimension(2, DensityUtils.a(getContext(), 1.0f));
        this.d = obtainStyledAttributes.getColor(1, -1433892728);
        this.e = obtainStyledAttributes.getColor(0, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f = drawable;
        if (drawable == null) {
            this.f = new ColorDrawable(this.d);
        }
        this.g = b();
        this.h = obtainStyledAttributes.getInt(3, 6);
        String string = obtainStyledAttributes.getString(4);
        this.i = string;
        if (TextUtils.isEmpty(string)) {
            this.i = "●";
        }
        this.j = obtainStyledAttributes.getInt(5, 0);
        obtainStyledAttributes.recycle();
        int i4 = this.h;
        this.l = new String[i4];
        this.m = new TextView[i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.n.setFocusable(true);
        this.n.setFocusableInTouchMode(true);
        this.n.requestFocus();
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.n, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.o == null) {
            return;
        }
        String passWord = getPassWord();
        this.o.a(passWord);
        if (passWord.length() == this.h) {
            this.o.b(passWord);
        }
    }

    private boolean getPassWordVisibility() {
        boolean z = false;
        if (this.m[0].getTransformationMethod() == null) {
            z = true;
        }
        return z;
    }

    private void setCustomAttr(TextView textView) {
        ColorStateList colorStateList = this.f28593a;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        textView.setTextSize(this.b);
        int i = 18;
        int i2 = this.j;
        if (i2 == 1) {
            i = 129;
        } else if (i2 == 2) {
            i = 145;
        } else if (i2 == 3) {
            i = 225;
        }
        textView.setInputType(i);
        textView.setTransformationMethod(this.p);
    }

    private void setError(String str) {
        this.n.setError(str);
    }

    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = this.l;
            if (i2 >= strArr.length) {
                return;
            }
            strArr[i2] = null;
            this.m[i2].setText((CharSequence) null);
            i = i2 + 1;
        }
    }

    public String getPassWord() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = this.l;
            if (i2 >= strArr.length) {
                return sb.toString();
            }
            if (strArr[i2] != null) {
                sb.append(strArr[i2]);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2 = parcelable;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.l = bundle.getStringArray("passwordArr");
            parcelable2 = bundle.getParcelable("instanceState");
            this.n.removeTextChangedListener(this.s);
            setPassword(getPassWord());
            this.n.addTextChangedListener(this.s);
        }
        super.onRestoreInstanceState(parcelable2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putStringArray("passwordArr", this.l);
        return bundle;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    public void setOnPasswordChangedListener(OnPasswordChangedListener onPasswordChangedListener) {
        this.o = onPasswordChangedListener;
    }

    public void setPassword(String str) {
        a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charArray.length) {
                return;
            }
            String[] strArr = this.l;
            if (i2 < strArr.length) {
                strArr[i2] = charArray[i2] + "";
                this.m[i2].setText(this.l[i2]);
            }
            i = i2 + 1;
        }
    }

    public void setPasswordType(PasswordType passwordType) {
        boolean passWordVisibility = getPassWordVisibility();
        int i = AnonymousClass5.f28599a[passwordType.ordinal()];
        int i2 = i != 1 ? i != 2 ? i != 3 ? 18 : 225 : 145 : 129;
        TextView[] textViewArr = this.m;
        int length = textViewArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                setPasswordVisibility(passWordVisibility);
                return;
            } else {
                textViewArr[i4].setInputType(i2);
                i3 = i4 + 1;
            }
        }
    }

    public void setPasswordVisibility(boolean z) {
        TextView[] textViewArr = this.m;
        int length = textViewArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            TextView textView = textViewArr[i2];
            textView.setTransformationMethod(z ? null : this.p);
            if (textView instanceof EditText) {
                EditText editText = (EditText) textView;
                editText.setSelection(editText.getText().length());
            }
            i = i2 + 1;
        }
    }
}
