package com.blued.android.module.common.widget.menu;

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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.utils.CommonPreferences;
import com.bytedance.applog.tracker.Tracker;

@Deprecated
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheet.class */
public class ActionSheet extends BaseFragment implements View.OnClickListener {
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

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheet$ActionSheetListener.class */
    public interface ActionSheetListener {
        void a(ActionSheet actionSheet, int i);

        void a(ActionSheet actionSheet, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheet$Attributes.class */
    public static class Attributes {
        Drawable a = new ColorDrawable(0);
        Drawable b = new ColorDrawable(View.MEASURED_STATE_MASK);
        Drawable c;
        Drawable d;
        Drawable e;
        Drawable f;
        int g;
        int h;
        int i;
        int j;
        int k;
        int l;
        float m;
        private Context n;

        public Attributes(Context context) {
            this.n = context;
            ColorDrawable colorDrawable = new ColorDrawable(-7829368);
            this.c = colorDrawable;
            this.d = colorDrawable;
            this.e = colorDrawable;
            this.f = colorDrawable;
            this.g = -1;
            this.h = View.MEASURED_STATE_MASK;
            this.i = a(20);
            this.j = a(2);
            this.k = a(6);
            this.l = a(52);
            this.m = a(16);
        }

        private int a(int i) {
            return (int) TypedValue.applyDimension(1, i, this.n.getResources().getDisplayMetrics());
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheet$Builder.class */
    public static class Builder {
        private Context a;
        private FragmentManager b;
        private String c;
        private String[] d;
        private boolean f;
        private ActionSheetListener g;
        private String j;
        private String k;
        private int[] l;
        private String e = "actionSheet";
        private int h = -1;
        private boolean i = false;

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
            bundle.putString("text_color", this.j);
            bundle.putBoolean("has_title", this.i);
            bundle.putString("disable_text_color", this.k);
            bundle.putIntArray("disable_index_list", this.l);
            return bundle;
        }

        public Builder a(int i) {
            this.h = i;
            return this;
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

        public Builder a(int[] iArr) {
            this.l = iArr;
            return this;
        }

        public Builder a(String... strArr) {
            this.d = strArr;
            return this;
        }

        public Builder b(String str) {
            this.j = str;
            return this;
        }

        public Builder b(boolean z) {
            this.i = z;
            return this;
        }

        public ActionSheet b() {
            ActionSheet actionSheet = (ActionSheet) Fragment.instantiate(this.a, ActionSheet.class.getName(), a());
            actionSheet.a(this.g);
            actionSheet.a(this.b, this.e);
            return actionSheet;
        }

        public Builder c(String str) {
            this.k = str;
            return this;
        }
    }

    private View a(String str, int i, boolean z) {
        View inflate = this.j.inflate(getResources().getLayout(R.layout.item_actionsheet), (ViewGroup) null);
        inflate.setId(i + 100 + 1);
        inflate.setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_text);
        textView.setText(str);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_checked);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_checked_invisible);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.img_vip_icon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.img_red_dot);
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
        if (!TextUtils.isEmpty(p()) && b(i)) {
            textView.setTextColor(Color.parseColor(p()));
        } else if (TextUtils.isEmpty(o())) {
            textView.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        } else {
            textView.setTextColor(Color.parseColor(o()));
        }
        if (i == 0) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) inflate.findViewById(R.id.action_sheet);
            ShapeHelper.a(shapeLinearLayout, DensityUtils.a(getContext(), 10.0f), DensityUtils.a(getContext(), 10.0f), 0.0f, 0.0f);
            if (r()) {
                ShapeHelper.c(shapeLinearLayout, R.color.syc_b);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_text);
                textView3.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_j));
                textView3.setTextSize(2, 14.0f);
            }
        }
        if (getString(R.string.sticky_feed).equalsIgnoreCase(str)) {
            imageView3.setVisibility(0);
            return inflate;
        } else if (getString(R.string.dynamic_skin_setting).equalsIgnoreCase(str)) {
            imageView3.setVisibility(0);
            return inflate;
        } else if (getString(R.string.dynamic_skin_look).equalsIgnoreCase(str)) {
            imageView3.setVisibility(0);
            return inflate;
        } else if (getString(R.string.cancel_sticky_feed).equalsIgnoreCase(str)) {
            imageView3.setVisibility(0);
            return inflate;
        } else if (getString(R.string.msg_item_secret).equalsIgnoreCase(str)) {
            imageView3.setVisibility(0);
            imageView3.setImageResource(R.drawable.common_icon_svip);
            return inflate;
        } else if (getString(R.string.feed_super_exposure_post).equals(str)) {
            imageView4.setVisibility(0);
            return inflate;
        } else if (getString(R.string.privacy_photo_album_recover_dilatation).equalsIgnoreCase(str)) {
            imageView3.setVisibility(0);
            return inflate;
        } else if (!getString(R.string.customize_avatar_decoration).equalsIgnoreCase(str)) {
            if (getString(R.string.view_avatar_decoration).equalsIgnoreCase(str)) {
                imageView3.setVisibility(0);
            }
            return inflate;
        } else {
            if (!CommonPreferences.n()) {
                textView2.setVisibility(0);
            }
            imageView3.setVisibility(0);
            return inflate;
        }
    }

    public static Builder a(Context context, FragmentManager fragmentManager) {
        return new Builder(context, fragmentManager);
    }

    private Animation b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    private boolean b(int i) {
        int[] q = q();
        if (q == null) {
            return false;
        }
        int length = q.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (i == q[i3]) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private Animation c() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        return alphaAnimation;
    }

    private Animation d() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    private Animation e() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    private View f() {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.blued.android.framework.view.shape.ShapeHelper$ShapeView, com.blued.android.framework.view.shape.ShapeTextView, android.view.View] */
    private void g() {
        h();
        View view = new View(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, this.g.k));
        view.setBackgroundColor(BluedSkinUtils.a(getContext(), R.color.syc_x));
        this.d.addView(view);
        ?? shapeTextView = new ShapeTextView(getActivity());
        shapeTextView.setTextSize(0, this.g.m);
        shapeTextView.setId(100);
        ShapeHelper.b(shapeTextView, R.color.syc_b);
        ShapeHelper.c(shapeTextView, R.color.syc_c);
        shapeTextView.setText(k());
        shapeTextView.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        shapeTextView.setGravity(17);
        shapeTextView.setOnClickListener(this);
        LinearLayout.LayoutParams i = i();
        i.height = this.g.l;
        this.d.addView((View) shapeTextView, i);
    }

    private void h() {
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

    private LinearLayout.LayoutParams i() {
        return new LinearLayout.LayoutParams(-1, -2);
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
        attributes.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionSheet_actionSheetTextSize, (int) attributes.m);
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

    private String p() {
        return getArguments().getString("disable_text_color");
    }

    private int[] q() {
        return getArguments().getIntArray("disable_index_list");
    }

    private boolean r() {
        return getArguments().getBoolean("has_title", false);
    }

    public String a(int i) {
        String[] l = l();
        return i < l.length ? l[i] : "";
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
            beginTransaction.addToBackStack((String) null);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public void a(ActionSheetListener actionSheetListener) {
        this.b = actionSheetListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if ((view.getId() == 100 || view.getId() == 10 || !r() || view.getId() != 101) && !b((view.getId() - 100) - 1)) {
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
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View currentFocus;
        this.j = layoutInflater;
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager.isActive() && (currentFocus = getActivity().getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        this.g = j();
        this.c = f();
        ViewGroup viewGroup2 = (ViewGroup) getActivity().getWindow().getDecorView();
        try {
            this.e = (ViewGroup) ((ViewGroup) viewGroup2.getChildAt(0)).getChildAt(1);
        } catch (Exception e) {
            this.e = null;
        }
        if (this.e == null) {
            this.e = viewGroup2;
        }
        g();
        this.e.addView(this.c);
        this.f.startAnimation(c());
        this.d.startAnimation(b());
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroyView() {
        this.d.startAnimation(d());
        this.f.startAnimation(e());
        this.c.postDelayed(new Runnable() { // from class: com.blued.android.module.common.widget.menu.ActionSheet.1
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
}
