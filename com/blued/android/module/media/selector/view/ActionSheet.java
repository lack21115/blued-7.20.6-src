package com.blued.android.module.media.selector.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.media.selector.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/ActionSheet.class */
public class ActionSheet extends Fragment implements View.OnClickListener {
    private ActionSheetListener b;
    private View c;
    private LinearLayout d;
    private ViewGroup e;
    private View f;
    private Attributes g;
    private LayoutInflater j;
    private boolean a = true;
    private boolean h = true;
    private boolean i = false;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/ActionSheet$ActionSheetListener.class */
    public interface ActionSheetListener {
        void a(ActionSheet actionSheet, int i);

        void a(ActionSheet actionSheet, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/ActionSheet$Attributes.class */
    public static class Attributes {
        Drawable a = new ColorDrawable(0);
        Drawable b;
        Drawable c;
        Drawable d;
        Drawable e;
        Drawable f;
        int g;
        int h;
        int i;
        int j;
        int k;
        float l;
        private Context m;

        public Attributes(Context context) {
            this.m = context;
            this.b = new ColorDrawable(View.MEASURED_STATE_MASK);
            ColorDrawable colorDrawable = new ColorDrawable(-7829368);
            this.b = colorDrawable;
            this.c = colorDrawable;
            this.d = colorDrawable;
            this.e = colorDrawable;
            this.f = colorDrawable;
            this.g = -1;
            this.h = View.MEASURED_STATE_MASK;
            this.i = a(20);
            this.j = a(2);
            this.k = a(1);
            this.l = a(15);
        }

        private int a(int i) {
            return (int) TypedValue.applyDimension(1, i, this.m.getResources().getDisplayMetrics());
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/ActionSheet$Builder.class */
    public static class Builder {
        private Context a;
        private FragmentManager b;
        private String c;
        private String[] d;
        private boolean f;
        private ActionSheetListener g;
        private String i;
        private String e = "actionSheet";
        private int h = -1;

        public Builder(Context context, FragmentManager fragmentManager) {
            this.a = context;
            this.b = fragmentManager;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("cancel_button_title", this.c);
            bundle.putStringArray("other_button_titles", this.d);
            bundle.putBoolean("cancelable_ontouchoutside", this.f);
            bundle.putInt("arg_selected_index", this.h);
            bundle.putString("text_color", this.i);
            return bundle;
        }

        public Builder a(ActionSheetListener actionSheetListener) {
            this.g = actionSheetListener;
            return this;
        }

        public Builder a(String str) {
            this.c = str;
            return this;
        }

        public Builder a(boolean z) {
            this.f = z;
            return this;
        }

        public Builder a(String... strArr) {
            this.d = strArr;
            return this;
        }

        public Builder b(String str) {
            this.i = str;
            return this;
        }

        public ActionSheet b() {
            ActionSheet actionSheet = (ActionSheet) Fragment.instantiate(this.a, ActionSheet.class.getName(), a());
            actionSheet.a(this.g);
            actionSheet.a(this.b, this.e);
            return actionSheet;
        }
    }

    public static Builder a(Context context, FragmentManager fragmentManager) {
        return new Builder(context, fragmentManager);
    }

    private Animation d() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    private Animation e() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        return alphaAnimation;
    }

    private Animation f() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    private Animation g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    private View h() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(getActivity());
        this.f = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f.setBackgroundColor(Color.argb(136, 0, 0, 0));
        this.f.setId(10);
        this.f.setOnClickListener(this);
        this.d = new LinearLayout(getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = StatusBarHelper.b(getActivity());
        this.d.setLayoutParams(layoutParams);
        this.d.setOrientation(1);
        frameLayout.addView(this.f);
        frameLayout.addView(this.d);
        return frameLayout;
    }

    private void i() {
        b();
        Button button = new Button(getActivity());
        button.setTextSize(0, this.g.l);
        button.setId(100);
        button.setBackgroundDrawable(this.g.b);
        button.setText(k());
        button.setTextColor(getResources().getColor(R.color.pl_popitems_font_gray));
        button.setOnClickListener(this);
        LinearLayout.LayoutParams c = c();
        c.topMargin = this.g.k;
        this.d.addView(button, c);
    }

    private Attributes j() {
        Attributes attributes = new Attributes(getActivity());
        TypedArray obtainStyledAttributes = getActivity().getTheme().obtainStyledAttributes(null, R.styleable.ActionSheet, R.attr.actionSheetStyle, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActionSheet_actionSheetBackground);
        if (drawable != null) {
            attributes.a = drawable;
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ActionSheet_cancelButtonBackground);
        if (drawable2 != null) {
            attributes.b = drawable2;
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ActionSheet_otherButtonTopBackground);
        if (drawable3 != null) {
            attributes.c = drawable3;
        }
        Drawable drawable4 = obtainStyledAttributes.getDrawable(R.styleable.ActionSheet_otherButtonMiddleBackground);
        if (drawable4 != null) {
            attributes.d = drawable4;
        }
        Drawable drawable5 = obtainStyledAttributes.getDrawable(R.styleable.ActionSheet_otherButtonBottomBackground);
        if (drawable5 != null) {
            attributes.e = drawable5;
        }
        Drawable drawable6 = obtainStyledAttributes.getDrawable(R.styleable.ActionSheet_otherButtonSingleBackground);
        if (drawable6 != null) {
            attributes.f = drawable6;
        }
        attributes.g = obtainStyledAttributes.getColor(R.styleable.ActionSheet_cancelButtonTextColor, attributes.g);
        attributes.h = obtainStyledAttributes.getColor(R.styleable.ActionSheet_otherButtonTextColor, attributes.h);
        attributes.i = (int) obtainStyledAttributes.getDimension(R.styleable.ActionSheet_actionSheetPadding, attributes.i);
        attributes.j = (int) obtainStyledAttributes.getDimension(R.styleable.ActionSheet_otherButtonSpacing, attributes.j);
        attributes.k = (int) obtainStyledAttributes.getDimension(R.styleable.ActionSheet_cancelButtonMarginTop, attributes.k);
        attributes.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionSheet_actionSheetTextSize, (int) attributes.l);
        obtainStyledAttributes.recycle();
        return attributes;
    }

    private String k() {
        return getArguments().getString("cancel_button_title");
    }

    private String[] l() {
        return getArguments().getStringArray("other_button_titles");
    }

    private boolean m() {
        return getArguments().getBoolean("cancelable_ontouchoutside");
    }

    private int n() {
        return getArguments().getInt("arg_selected_index");
    }

    private String o() {
        return getArguments().getString("text_color");
    }

    public View a(String str, int i, boolean z) {
        View inflate = this.j.inflate(getResources().getLayout(R.layout.pl_item_actionsheet), (ViewGroup) null);
        inflate.setId(i + 100 + 1);
        inflate.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_text);
        textView.setText(str);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_checked);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_checked_invisible);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.img_vip_icon);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.img_feed);
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.setMargins(imageView.getMeasuredWidth(), 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            imageView.setVisibility(0);
            imageView2.setVisibility(4);
        } else {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        }
        if (TextUtils.isEmpty(o())) {
            textView.setTextColor(getResources().getColor(R.color.pl_sara_c));
            return inflate;
        }
        textView.setTextColor(Color.parseColor(o()));
        return inflate;
    }

    public void a() {
        if (this.a) {
            return;
        }
        this.a = true;
        try {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.remove(this);
                beginTransaction.commit();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        this.i = false;
    }

    public void a(FragmentManager fragmentManager, String str) {
        if (this.a) {
            this.a = false;
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.addToBackStack(null);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public void a(ActionSheetListener actionSheetListener) {
        this.b = actionSheetListener;
    }

    public void b() {
        String[] l = l();
        int n = n();
        if (l == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= l.length) {
                return;
            }
            this.d.addView(a(l[i2], i2, n < l.length && n >= 0 && i2 == n));
            i = i2 + 1;
        }
    }

    public LinearLayout.LayoutParams c() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        a();
        if ((view.getId() != 10 || m()) && !this.i) {
            this.i = true;
            if (view.getId() == 100 || view.getId() == 10) {
                return;
            }
            ActionSheetListener actionSheetListener = this.b;
            if (actionSheetListener != null) {
                actionSheetListener.a(this, (view.getId() - 100) - 1);
            }
            this.h = false;
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View currentFocus;
        this.j = layoutInflater;
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager.isActive() && (currentFocus = getActivity().getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        this.g = j();
        this.c = h();
        ViewGroup viewGroup2 = (ViewGroup) getActivity().getWindow().getDecorView();
        try {
            this.e = (ViewGroup) ((ViewGroup) viewGroup2.getChildAt(0)).getChildAt(1);
        } catch (NullPointerException e) {
            this.e = null;
        }
        if (this.e == null) {
            this.e = viewGroup2;
        }
        i();
        this.e.addView(this.c);
        this.f.startAnimation(e());
        this.d.startAnimation(d());
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.d.startAnimation(f());
        this.f.startAnimation(g());
        this.c.postDelayed(new Runnable() { // from class: com.blued.android.module.media.selector.view.ActionSheet.1
            @Override // java.lang.Runnable
            public void run() {
                ActionSheet.this.e.removeView(ActionSheet.this.c);
            }
        }, 300L);
        ActionSheetListener actionSheetListener = this.b;
        if (actionSheetListener != null) {
            actionSheetListener.a(this, this.h);
        }
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // android.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }
}
