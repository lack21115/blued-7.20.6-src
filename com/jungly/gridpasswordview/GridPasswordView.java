package com.jungly.gridpasswordview;

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
import cn.blued.blued_third_library.R;
import com.bytedance.applog.tracker.Tracker;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;

/* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/GridPasswordView.class */
public class GridPasswordView extends LinearLayout implements PasswordView {

    /* renamed from: a  reason: collision with root package name */
    private ColorStateList f10071a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10072c;
    private int d;
    private int e;
    private Drawable f;
    private Drawable g;
    private int h;
    private String i;
    private int j;
    private ImeDelBugFixedEditText k;
    private String[] l;
    private TextView[] m;
    private OnPasswordChangedListener n;
    private PasswordTransformationMethod o;
    private View.OnClickListener p;
    private ImeDelBugFixedEditText.OnDelKeyEventListener q;
    private TextWatcher r;
    @Deprecated
    private View.OnKeyListener s;

    /* renamed from: com.jungly.gridpasswordview.GridPasswordView$5  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/GridPasswordView$5.class */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10077a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PasswordType.values().length];
            f10077a = iArr;
            try {
                iArr[PasswordType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10077a[PasswordType.TEXTVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10077a[PasswordType.TEXTWEB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/GridPasswordView$OnPasswordChangedListener.class */
    public interface OnPasswordChangedListener {
        void a(String str);

        void b(String str);
    }

    public GridPasswordView(Context context) {
        this(context, null);
    }

    public GridPasswordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridPasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 16;
        this.p = new View.OnClickListener() { // from class: com.jungly.gridpasswordview.GridPasswordView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GridPasswordView.this.c();
            }
        };
        this.q = new ImeDelBugFixedEditText.OnDelKeyEventListener() { // from class: com.jungly.gridpasswordview.GridPasswordView.2
            @Override // com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText.OnDelKeyEventListener
            public void a() {
                int length = GridPasswordView.this.l.length;
                while (true) {
                    int i2 = length - 1;
                    if (i2 < 0) {
                        return;
                    }
                    if (GridPasswordView.this.l[i2] != null) {
                        GridPasswordView.this.l[i2] = null;
                        GridPasswordView.this.m[i2].setText((CharSequence) null);
                        GridPasswordView.this.d();
                        return;
                    }
                    GridPasswordView.this.m[i2].setText((CharSequence) null);
                    length = i2;
                }
            }
        };
        this.r = new TextWatcher() { // from class: com.jungly.gridpasswordview.GridPasswordView.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (charSequence == null) {
                    return;
                }
                String charSequence2 = charSequence.toString();
                if (charSequence2.length() == 1) {
                    GridPasswordView.this.l[0] = charSequence2;
                    GridPasswordView.this.d();
                } else if (charSequence2.length() == 2) {
                    String substring = charSequence2.substring(1);
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= GridPasswordView.this.l.length) {
                            break;
                        } else if (GridPasswordView.this.l[i6] == null) {
                            GridPasswordView.this.l[i6] = substring;
                            GridPasswordView.this.m[i6].setText(substring);
                            GridPasswordView.this.d();
                            break;
                        } else {
                            i5 = i6 + 1;
                        }
                    }
                    GridPasswordView.this.k.removeTextChangedListener(this);
                    GridPasswordView.this.k.setText(GridPasswordView.this.l[0]);
                    if (GridPasswordView.this.k.getText().length() >= 1) {
                        GridPasswordView.this.k.setSelection(1);
                    }
                    GridPasswordView.this.k.addTextChangedListener(this);
                }
            }
        };
        this.s = new View.OnKeyListener() { // from class: com.jungly.gridpasswordview.GridPasswordView.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                    GridPasswordView.this.q.a();
                    return true;
                }
                return false;
            }
        };
        a(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        super.setBackgroundDrawable(this.g);
        setShowDividers(0);
        setOrientation(0);
        this.o = new CustomPasswordTransformationMethod(this.i);
        b(context);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.gridPasswordView, i, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.gridPasswordView_textColorGpv);
        this.f10071a = colorStateList;
        if (colorStateList == null) {
            this.f10071a = ColorStateList.valueOf(getResources().getColor(android.R.color.primary_text_light));
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.gridPasswordView_textSizeGpv, -1);
        if (dimensionPixelSize != -1) {
            this.b = Util.a(context, dimensionPixelSize);
        }
        this.f10072c = (int) obtainStyledAttributes.getDimension(R.styleable.gridPasswordView_lineWidthGpv, Util.a(getContext(), 1));
        this.d = obtainStyledAttributes.getColor(R.styleable.gridPasswordView_lineColorGpv, -1433892728);
        this.e = obtainStyledAttributes.getColor(R.styleable.gridPasswordView_gridColorGpv, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.gridPasswordView_lineColorGpv);
        this.f = drawable;
        if (drawable == null) {
            this.f = new ColorDrawable(this.d);
        }
        this.g = b();
        this.h = obtainStyledAttributes.getInt(R.styleable.gridPasswordView_passwordLengthGpv, 6);
        String string = obtainStyledAttributes.getString(R.styleable.gridPasswordView_passwordTransformationGpv);
        this.i = string;
        if (TextUtils.isEmpty(string)) {
            this.i = "●";
        }
        this.j = obtainStyledAttributes.getInt(R.styleable.gridPasswordView_passwordTypeGpv, 0);
        obtainStyledAttributes.recycle();
        int i2 = this.h;
        this.l = new String[i2];
        this.m = new TextView[i2];
    }

    private GradientDrawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.e);
        gradientDrawable.setStroke(this.f10072c, this.d);
        return gradientDrawable;
    }

    private void b(Context context) {
        LayoutInflater from = LayoutInflater.from(context);
        from.inflate(R.layout.gridpasswordview, this);
        ImeDelBugFixedEditText imeDelBugFixedEditText = (ImeDelBugFixedEditText) findViewById(R.id.inputView);
        this.k = imeDelBugFixedEditText;
        imeDelBugFixedEditText.setMaxEms(this.h);
        this.k.addTextChangedListener(this.r);
        this.k.setDelKeyEventListener(this.q);
        setCustomAttr(this.k);
        this.m[0] = this.k;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.h) {
                setOnClickListener(this.p);
                return;
            }
            View inflate = from.inflate(R.layout.divider, (ViewGroup) null);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f10072c, -1);
            inflate.setBackgroundDrawable(this.f);
            addView(inflate, layoutParams);
            TextView textView = (TextView) from.inflate(R.layout.textview, (ViewGroup) null);
            setCustomAttr(textView);
            addView(textView, new LinearLayout.LayoutParams(0, -1, 1.0f));
            this.m[i2] = textView;
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.k.setFocusable(true);
        this.k.setFocusableInTouchMode(true);
        this.k.requestFocus();
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.k, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.n == null) {
            return;
        }
        String passWord = getPassWord();
        this.n.a(passWord);
        if (passWord.length() == this.h) {
            this.n.b(passWord);
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
        ColorStateList colorStateList = this.f10071a;
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
        textView.setTransformationMethod(this.o);
    }

    private void setError(String str) {
        this.k.setError(str);
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

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2 = parcelable;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.l = bundle.getStringArray("passwordArr");
            parcelable2 = bundle.getParcelable("instanceState");
            this.k.removeTextChangedListener(this.r);
            setPassword(getPassWord());
            this.k.addTextChangedListener(this.r);
        }
        super.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
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
        this.n = onPasswordChangedListener;
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
        int i = AnonymousClass5.f10077a[passwordType.ordinal()];
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
            textView.setTransformationMethod(z ? null : this.o);
            if (textView instanceof EditText) {
                EditText editText = (EditText) textView;
                editText.setSelection(editText.getText().length());
            }
            i = i2 + 1;
        }
    }
}
