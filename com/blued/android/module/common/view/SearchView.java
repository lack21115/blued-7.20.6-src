package com.blued.android.module.common.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.SearchTaskTool;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/SearchView.class */
public class SearchView extends LinearLayout implements BluedSkinSupportable, SearchTaskTool.TaskListener {

    /* renamed from: a  reason: collision with root package name */
    public View f11043a;
    public LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f11044c;
    private SearchEditText d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private boolean h;
    private boolean i;
    private OnSearchInfoListener j;
    private Context k;
    private int l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private float q;
    private float r;
    private RelativeLayout s;
    private ShapeLinearLayout t;
    private boolean u;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/SearchView$OnSearchInfoListener.class */
    public interface OnSearchInfoListener {
        void a();

        void a(String str);

        void b();
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11043a = null;
        this.u = true;
        this.k = context;
        a(context, attributeSet);
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (this.f11043a != null) {
            return;
        }
        this.k = context;
        this.i = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonSearchView);
        this.m = obtainStyledAttributes.getBoolean(R.styleable.CommonSearchView_search_click_jump, false);
        this.n = obtainStyledAttributes.getResourceId(R.styleable.CommonSearchView_search_hint, 0);
        this.o = obtainStyledAttributes.getColor(R.styleable.CommonSearchView_search_textColorHint, 0);
        this.p = obtainStyledAttributes.getColor(R.styleable.CommonSearchView_search_textColor, 0);
        this.q = obtainStyledAttributes.getDimension(R.styleable.CommonSearchView_search_textSize, 0.0f);
        this.r = obtainStyledAttributes.getFloat(R.styleable.CommonSearchView_search_delaymillis, -1.0f);
        obtainStyledAttributes.recycle();
        this.b = LayoutInflater.from(this.k);
        View rootView = getRootView();
        this.f11043a = rootView;
        this.t = (ShapeLinearLayout) rootView.findViewById(R.id.edit_lay);
        this.s = (RelativeLayout) this.f11043a.findViewById(R.id.rl_root);
        this.f11044c = this.f11043a.findViewById(R.id.search_mask_layer);
        SearchEditText searchEditText = (SearchEditText) this.f11043a.findViewById(R.id.search_edt);
        this.d = searchEditText;
        float f = this.q;
        if (f != 0.0f) {
            searchEditText.setTextSize(f);
        }
        int i = this.p;
        if (i != 0) {
            this.d.setTextColor(i);
        } else {
            this.d.setTextColor(BluedSkinUtils.a(this.k, R.color.syc_h));
        }
        int i2 = this.n;
        if (i2 != 0) {
            this.d.setHint(i2);
        }
        int i3 = this.o;
        if (i3 != 0) {
            this.d.setHintTextColor(i3);
        } else {
            this.d.setHintTextColor(BluedSkinUtils.a(this.k, R.color.syc_j));
        }
        float f2 = this.r;
        if (f2 >= 0.0f) {
            setDelaymillis(f2);
        }
        this.e = (ImageView) this.f11043a.findViewById(R.id.search_del);
        this.f = (ImageView) this.f11043a.findViewById(R.id.search_icon);
        this.g = (TextView) this.f11043a.findViewById(R.id.search_cancel);
        if (this.m) {
            this.d.setFocusable(false);
            this.f11044c.setVisibility(0);
        } else {
            this.f11044c.setVisibility(8);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.SearchView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (!TextUtils.isEmpty(SearchView.this.d.getText())) {
                        SearchView.this.d.setText("");
                    }
                    if (SearchView.this.j != null) {
                        SearchView.this.j.a();
                    }
                }
            });
            this.d.setEditorActionListener(true);
            this.d.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.common.view.SearchView.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                    if (TextUtils.isEmpty(SearchView.this.d.getText().toString())) {
                        SearchView.this.e.setVisibility(8);
                    } else {
                        SearchView.this.e.setVisibility(0);
                    }
                }
            });
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.SearchView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SearchView.this.d.setFocusableInTouchMode(true);
                    SearchView.this.d.requestFocus();
                    ((InputMethodManager) SearchView.this.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(SearchView.this.d, 0);
                }
            });
            this.d.a(this);
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.SearchView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SearchView.this.d.setText("");
                    if (SearchView.this.j != null) {
                        SearchView.this.j.b();
                    }
                }
            });
        }
        addView(this.f11043a);
    }

    @Override // com.blued.android.framework.utils.SearchTaskTool.TaskListener
    public void a(String str) {
        OnSearchInfoListener onSearchInfoListener = this.j;
        if (onSearchInfoListener != null) {
            onSearchInfoListener.a(str);
        }
    }

    public void a(boolean z) {
        int i;
        synchronized (this) {
            if (this.u) {
                if (this.i == z) {
                    return;
                }
                if (this.h) {
                    return;
                }
                final int a2 = DensityUtils.a(getContext(), 45.0f);
                int width = this.t.getWidth();
                if (width != 0) {
                    this.i = z;
                    if (this.l == 0 && z) {
                        this.l = width;
                    }
                    if (z) {
                        i = width - a2;
                    } else {
                        i = width + a2;
                        this.d.setFocusableInTouchMode(false);
                    }
                    ValueAnimator ofInt = ValueAnimator.ofInt(width, i);
                    ofInt.setDuration(300L);
                    ofInt.setInterpolator(new LinearInterpolator());
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.SearchView.5
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Integer num = (Integer) valueAnimator.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams = SearchView.this.t.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.width = num.intValue();
                            }
                            SearchView.this.t.setLayoutParams(layoutParams);
                        }
                    });
                    ofInt.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.common.view.SearchView.6
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            SearchView.this.h = false;
                            ViewGroup.LayoutParams layoutParams = SearchView.this.t.getLayoutParams();
                            if (SearchView.this.i) {
                                if (layoutParams != null) {
                                    layoutParams.width = SearchView.this.l - a2;
                                    SearchView.this.t.setLayoutParams(layoutParams);
                                }
                            } else if (layoutParams != null) {
                                layoutParams.width = SearchView.this.l;
                                SearchView.this.t.setLayoutParams(layoutParams);
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            SearchView.this.h = true;
                        }
                    });
                    ofInt.start();
                }
            }
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        this.d.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        this.d.setHintTextColor(BluedSkinUtils.a(getContext(), R.color.msg_search_hint));
        ShapeHelper.b(this.t, R.color.syc_search_et_bg);
        this.f.setImageDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_search_common));
    }

    public SearchEditText getEditView() {
        return this.d;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.b.inflate(R.layout.view_common_search, (ViewGroup) null);
    }

    public View getSearchRootView() {
        return this.f11043a;
    }

    public void setDelaymillis(long j) {
        SearchEditText searchEditText = this.d;
        if (searchEditText != null) {
            searchEditText.setDelaymillis(j);
        }
    }

    public void setFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.d.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setMaskLayerOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f11044c.setVisibility(0);
            this.f11044c.setOnClickListener(onClickListener);
        }
    }

    public void setOnSearchInfoListener(OnSearchInfoListener onSearchInfoListener) {
        this.j = onSearchInfoListener;
    }

    public void setRootBgColor(int i) {
        this.s.setBackgroundColor(i);
    }

    public void setShapeModel(ShapeModel shapeModel) {
        this.t.setShapeModel(shapeModel);
    }
}
