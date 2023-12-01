package com.soft.blued.ui.user.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/UserProfileHoverBtmBtns.class */
public class UserProfileHoverBtmBtns extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f20701a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private View f20702c;
    private ImageView d;
    private TextView e;
    private View f;
    private ImageView g;
    private TextView h;
    private boolean i;
    private Long j;
    private int k;
    private float l;
    private View.OnClickListener m;
    private View.OnClickListener n;
    private BaseFragment o;
    private View p;
    private RecyclerView.OnScrollListener q;

    public UserProfileHoverBtmBtns(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.user.views.UserProfileHoverBtmBtns.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int findFirstVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (recyclerView.getChildAt(0) != null) {
                    if (UserProfileHoverBtmBtns.this.j == null) {
                        UserProfileHoverBtmBtns.this.j = Long.valueOf(System.currentTimeMillis());
                    }
                    int top = recyclerView.getChildAt(0).getTop();
                    long currentTimeMillis = System.currentTimeMillis() - UserProfileHoverBtmBtns.this.j.longValue();
                    if (findFirstVisibleItemPosition == 0 && top == 0) {
                        if (!UserProfileHoverBtmBtns.this.i) {
                            UserProfileHoverBtmBtns.this.b();
                        }
                    } else if (UserProfileHoverBtmBtns.this.k < findFirstVisibleItemPosition) {
                        if (UserProfileHoverBtmBtns.this.i) {
                            UserProfileHoverBtmBtns.this.c();
                        }
                    } else if (UserProfileHoverBtmBtns.this.k == findFirstVisibleItemPosition) {
                        float f = top;
                        int abs = (int) Math.abs(UserProfileHoverBtmBtns.this.l - f);
                        if (UserProfileHoverBtmBtns.this.l >= f || currentTimeMillis == 0 || (abs * 1000) / currentTimeMillis <= 2000) {
                            if (UserProfileHoverBtmBtns.this.l > f && abs > 10 && UserProfileHoverBtmBtns.this.i) {
                                UserProfileHoverBtmBtns.this.c();
                            }
                        } else if (!UserProfileHoverBtmBtns.this.i) {
                            UserProfileHoverBtmBtns.this.b();
                        }
                    }
                    UserProfileHoverBtmBtns.this.k = findFirstVisibleItemPosition;
                    UserProfileHoverBtmBtns.this.l = top;
                    UserProfileHoverBtmBtns.this.j = Long.valueOf(System.currentTimeMillis());
                }
            }
        };
        this.f20701a = context;
        a();
    }

    public UserProfileHoverBtmBtns(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.user.views.UserProfileHoverBtmBtns.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                int findFirstVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (recyclerView.getChildAt(0) != null) {
                    if (UserProfileHoverBtmBtns.this.j == null) {
                        UserProfileHoverBtmBtns.this.j = Long.valueOf(System.currentTimeMillis());
                    }
                    int top = recyclerView.getChildAt(0).getTop();
                    long currentTimeMillis = System.currentTimeMillis() - UserProfileHoverBtmBtns.this.j.longValue();
                    if (findFirstVisibleItemPosition == 0 && top == 0) {
                        if (!UserProfileHoverBtmBtns.this.i) {
                            UserProfileHoverBtmBtns.this.b();
                        }
                    } else if (UserProfileHoverBtmBtns.this.k < findFirstVisibleItemPosition) {
                        if (UserProfileHoverBtmBtns.this.i) {
                            UserProfileHoverBtmBtns.this.c();
                        }
                    } else if (UserProfileHoverBtmBtns.this.k == findFirstVisibleItemPosition) {
                        float f = top;
                        int abs = (int) Math.abs(UserProfileHoverBtmBtns.this.l - f);
                        if (UserProfileHoverBtmBtns.this.l >= f || currentTimeMillis == 0 || (abs * 1000) / currentTimeMillis <= 2000) {
                            if (UserProfileHoverBtmBtns.this.l > f && abs > 10 && UserProfileHoverBtmBtns.this.i) {
                                UserProfileHoverBtmBtns.this.c();
                            }
                        } else if (!UserProfileHoverBtmBtns.this.i) {
                            UserProfileHoverBtmBtns.this.b();
                        }
                    }
                    UserProfileHoverBtmBtns.this.k = findFirstVisibleItemPosition;
                    UserProfileHoverBtmBtns.this.l = top;
                    UserProfileHoverBtmBtns.this.j = Long.valueOf(System.currentTimeMillis());
                }
            }
        };
        this.f20701a = context;
        a();
    }

    private void c(final View view) {
        Logger.c("hover_btns", " startBtmBtnShowAnim()");
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(this.f20701a, -80.0f), 0);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.views.UserProfileHoverBtmBtns.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, intValue);
                view.setLayoutParams(layoutParams);
            }
        });
        ofInt.start();
    }

    private void d(final View view) {
        Logger.c("hover_btns", " startBtmBtnHideAnim()");
        ValueAnimator ofInt = ObjectAnimator.ofInt(0, DensityUtils.a(this.f20701a, -80.0f));
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.views.UserProfileHoverBtmBtns.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, intValue);
                view.setLayoutParams(layoutParams);
            }
        });
        ofInt.start();
    }

    public void a() {
        Logger.c("hover_btns", " initView()");
        View inflate = LayoutInflater.from(this.f20701a).inflate(R.layout.view_hover_btm_btns, (ViewGroup) this, true);
        this.b = inflate;
        this.p = inflate.findViewById(2131367622);
        this.f20702c = this.b.findViewById(R.id.ll_left);
        this.d = (ImageView) this.b.findViewById(R.id.img_left);
        this.e = (TextView) this.b.findViewById(R.id.tv_left);
        this.f = this.b.findViewById(R.id.ll_right);
        this.g = (ImageView) this.b.findViewById(R.id.img_right);
        this.h = (TextView) this.b.findViewById(R.id.tv_right);
        this.f20702c.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    public void a(final View view) {
        Logger.c("hover_btns", " playImageButtonClickAnimator()");
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.7f);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.views.UserProfileHoverBtmBtns.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setScaleX(floatValue);
                view.setScaleY(floatValue);
            }
        });
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(0.7f, 1.0f);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.views.UserProfileHoverBtmBtns.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setScaleX(floatValue);
                view.setScaleY(floatValue);
            }
        });
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.user.views.UserProfileHoverBtmBtns.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (UserProfileHoverBtmBtns.this.o == null) {
                    UserProfileHoverBtmBtns.this.b(view);
                } else if (CommonTools.a(UserProfileHoverBtmBtns.this.o)) {
                    UserProfileHoverBtmBtns.this.b(view);
                }
                view.setOnClickListener(UserProfileHoverBtmBtns.this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setOnClickListener(null);
            }
        });
        animatorSet.start();
    }

    public void b() {
        c(this.p);
        this.i = true;
    }

    public void b(View view) {
        View.OnClickListener onClickListener;
        int id = view.getId();
        if (id != 2131367957) {
            if (id == 2131368197 && (onClickListener = this.n) != null) {
                onClickListener.onClick(this.f);
                return;
            }
            return;
        }
        View.OnClickListener onClickListener2 = this.m;
        if (onClickListener2 != null) {
            onClickListener2.onClick(this.f20702c);
        }
    }

    public void c() {
        d(this.p);
        this.i = false;
    }

    public boolean getIfBtmBtnShowed() {
        return this.i;
    }

    public ImageView getImgLeft() {
        return this.d;
    }

    public ImageView getImgRight() {
        return this.g;
    }

    public RecyclerView.OnScrollListener getScrollListener() {
        return this.q;
    }

    public TextView getTvLeft() {
        return this.e;
    }

    public TextView getTvRight() {
        return this.h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        a(view);
    }

    public void setFragment(BaseFragment baseFragment) {
        this.o = baseFragment;
    }

    public void setLeftBtnClick(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setRightBtnClick(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }
}
