package com.blued.community.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.ItemNearbyTransformersFlipperEventBinding;
import com.blued.community.databinding.ItemNearbyTransformersFullBinding;
import com.blued.community.databinding.ItemNearbyTransformersHalfBinding;
import com.blued.community.databinding.ItemNearbyTransformersQuarterBinding;
import com.blued.community.databinding.ItemNearbyViewFlipperBinding;
import com.blued.community.databinding.ItemNearbyViewFlipperWithImgBinding;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.square.fragment.NearbyFeedFragment;
import com.blued.community.ui.square.model.NearbyTransformersModel;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/TransformersLayout.class */
public class TransformersLayout extends FrameLayout {
    private int measure;
    private float ratio;
    private int space;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/TransformersLayout$MEASURE.class */
    public @interface MEASURE {
        public static final int HEIGHT = 2;
        public static final int NONE = 0;
        public static final int WIDTH = 1;
    }

    public TransformersLayout(Context context) {
        this(context, null);
    }

    public TransformersLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformersLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float f;
        float f2;
        this.measure = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TransformersLayout);
        this.space = (int) obtainStyledAttributes.getDimension(R.styleable.TransformersLayout_space, 5.0f);
        String string = obtainStyledAttributes.getString(R.styleable.TransformersLayout_dimensionRatio);
        if (!TextUtils.isEmpty(string) && string.length() >= 5 && ',' == string.charAt(1)) {
            String[] split = string.substring(2).split(":");
            if (split.length == 2) {
                f2 = Integer.parseInt(split[0]);
                f = Integer.parseInt(split[1]);
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            if (f2 > 0.0f && f > 0.0f) {
                char charAt = string.charAt(0);
                if ('w' == charAt || 'W' == charAt) {
                    this.ratio = f2 / f;
                    this.measure = 1;
                } else if ('h' == charAt || 'H' == charAt) {
                    this.ratio = f / f2;
                    this.measure = 2;
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void addFullView(NearbyTransformersModel nearbyTransformersModel) {
        ItemNearbyViewFlipperBinding a2 = ItemNearbyViewFlipperBinding.a(LayoutInflater.from(getContext()));
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() <= 0) {
            addItemFullView(nearbyTransformersModel, new NearbyTransformersModel.Rotation(), a2.b);
        } else {
            for (NearbyTransformersModel.Rotation rotation : nearbyTransformersModel.rotation) {
                addItemFullView(nearbyTransformersModel, rotation, a2.b);
            }
        }
        ImageLoader.a((IRequestHost) null, BluedSkinUtils.c() ? nearbyTransformersModel.white_background_img : nearbyTransformersModel.black_background_img).d(R.drawable.shape_nearby_view_flipper_bg).a(a2.f19015a);
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() <= 1) {
            a2.b.stopFlipping();
        } else {
            a2.b.startFlipping();
        }
        addView(a2.getRoot());
    }

    private void addHalfEventView(final NearbyTransformersModel nearbyTransformersModel) {
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() < 1) {
            return;
        }
        final ItemNearbyViewFlipperWithImgBinding a2 = ItemNearbyViewFlipperWithImgBinding.a(LayoutInflater.from(getContext()));
        for (NearbyTransformersModel.Rotation rotation : nearbyTransformersModel.rotation) {
            addItemHalfEventView(nearbyTransformersModel, rotation, a2.j);
        }
        ImageLoader.a((IRequestHost) null, BluedSkinUtils.c() ? nearbyTransformersModel.white_background_img : nearbyTransformersModel.black_background_img).d(R.drawable.shape_nearby_view_flipper_bg).a(a2.f19018c);
        a2.i.setText(nearbyTransformersModel.title);
        a2.g.setText(!TextUtils.isEmpty(nearbyTransformersModel.rotation.get(0).name) ? nearbyTransformersModel.rotation.get(0).name : nearbyTransformersModel.describe);
        if (nearbyTransformersModel.rotation.get(0).showDate()) {
            a2.e.setText(nearbyTransformersModel.rotation.get(0).getDate());
        }
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() <= 1) {
            a2.j.stopFlipping();
        } else {
            a2.j.startFlipping();
        }
        a2.j.getInAnimation().setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.community.view.TransformersLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LinearLayout linearLayout;
                LinearLayout linearLayout2;
                TextView textView;
                TextView textView2;
                int displayedChild = a2.j.getDisplayedChild();
                if (a2.b.getVisibility() == 0) {
                    linearLayout = a2.b;
                    linearLayout2 = a2.f19017a;
                    textView = a2.g;
                    textView2 = a2.e;
                } else {
                    linearLayout = a2.f19017a;
                    linearLayout2 = a2.b;
                    textView = a2.h;
                    textView2 = a2.f;
                }
                textView.setText(!TextUtils.isEmpty(nearbyTransformersModel.rotation.get(displayedChild).name) ? nearbyTransformersModel.rotation.get(displayedChild).name : nearbyTransformersModel.describe);
                if (nearbyTransformersModel.rotation.get(displayedChild).showDate()) {
                    textView2.setText(nearbyTransformersModel.rotation.get(displayedChild).getDate());
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "alpha", 1.0f, 0.1f);
                ofFloat.setDuration(300L);
                final LinearLayout linearLayout3 = linearLayout;
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.view.TransformersLayout.3.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        linearLayout3.setVisibility(4);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                ofFloat.start();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "alpha", 0.1f, 1.0f);
                ofFloat2.setDuration(300L);
                ofFloat2.setStartDelay(200L);
                final LinearLayout linearLayout4 = linearLayout2;
                ofFloat2.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.view.TransformersLayout.3.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        linearLayout4.setVisibility(0);
                    }
                });
                ofFloat2.start();
            }
        });
        addView(a2.getRoot());
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$TransformersLayout$8CKM71uKIo0OrAPNF7NyPyv_bj8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransformersLayout.this.lambda$addHalfEventView$0$TransformersLayout(a2, nearbyTransformersModel, view);
            }
        });
    }

    private void addHalfView(NearbyTransformersModel nearbyTransformersModel) {
        if (nearbyTransformersModel == null) {
            return;
        }
        if ("activity".equalsIgnoreCase(nearbyTransformersModel.type)) {
            addHalfEventView(nearbyTransformersModel);
            return;
        }
        ItemNearbyViewFlipperBinding a2 = ItemNearbyViewFlipperBinding.a(LayoutInflater.from(getContext()));
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() <= 0) {
            addItemHalfView(nearbyTransformersModel, new NearbyTransformersModel.Rotation(), a2.b);
        } else {
            for (NearbyTransformersModel.Rotation rotation : nearbyTransformersModel.rotation) {
                addItemHalfView(nearbyTransformersModel, rotation, a2.b);
            }
        }
        ImageLoader.a((IRequestHost) null, BluedSkinUtils.c() ? nearbyTransformersModel.white_background_img : nearbyTransformersModel.black_background_img).d(R.drawable.shape_nearby_view_flipper_bg).a(a2.f19015a);
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() <= 1) {
            a2.b.stopFlipping();
        } else {
            a2.b.startFlipping();
        }
        addView(a2.getRoot());
    }

    private void addItemFullView(final NearbyTransformersModel nearbyTransformersModel, final NearbyTransformersModel.Rotation rotation, ViewFlipper viewFlipper) {
        ItemNearbyTransformersFullBinding a2 = ItemNearbyTransformersFullBinding.a(LayoutInflater.from(getContext()));
        String str = TextUtils.isEmpty(rotation.pic) ? nearbyTransformersModel.icon : rotation.pic;
        if (TextUtils.isEmpty(str)) {
            a2.f19009a.setVisibility(8);
        } else {
            ImageLoader.a((IRequestHost) null, str).b(R.drawable.defaultpicture).d(R.drawable.defaultpicture).a(6.0f).a(a2.f19009a);
        }
        a2.f.setText(nearbyTransformersModel.title);
        a2.e.setText(rotation.name);
        a2.d.setText(rotation.getDate());
        a2.f19010c.setText(nearbyTransformersModel.button);
        postCityFirstShow(nearbyTransformersModel, rotation);
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.view.TransformersLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TransformersLayout.this.postCityFirstClick(nearbyTransformersModel, rotation);
                CommunityServiceManager.b().a(TransformersLayout.this.getContext(), nearbyTransformersModel.url);
                NearbyFeedFragment.r = SystemClock.elapsedRealtime();
            }
        });
        viewFlipper.addView(a2.getRoot());
    }

    private void addItemHalfEventView(NearbyTransformersModel nearbyTransformersModel, NearbyTransformersModel.Rotation rotation, ViewFlipper viewFlipper) {
        ItemNearbyTransformersFlipperEventBinding a2 = ItemNearbyTransformersFlipperEventBinding.a(LayoutInflater.from(getContext()));
        String str = TextUtils.isEmpty(rotation.pic) ? nearbyTransformersModel.icon : rotation.pic;
        if (TextUtils.isEmpty(str)) {
            a2.f19008a.setVisibility(8);
        } else {
            ImageLoader.a((IRequestHost) null, str).b(R.drawable.defaultpicture).d(R.drawable.defaultpicture).a(6.0f).a(a2.f19008a);
        }
        postCityFirstShow(nearbyTransformersModel, rotation);
        viewFlipper.addView(a2.getRoot());
    }

    private void addItemHalfView(final NearbyTransformersModel nearbyTransformersModel, final NearbyTransformersModel.Rotation rotation, ViewFlipper viewFlipper) {
        ItemNearbyTransformersHalfBinding a2 = ItemNearbyTransformersHalfBinding.a(LayoutInflater.from(getContext()));
        String str = TextUtils.isEmpty(rotation.pic) ? nearbyTransformersModel.icon : rotation.pic;
        if (TextUtils.isEmpty(str)) {
            a2.f19011a.setVisibility(8);
        } else {
            ImageLoader.a((IRequestHost) null, str).b(R.drawable.defaultpicture).d(R.drawable.defaultpicture).a(6.0f).a(a2.f19011a);
        }
        a2.e.setText(nearbyTransformersModel.title);
        a2.d.setText(!TextUtils.isEmpty(rotation.name) ? rotation.name : nearbyTransformersModel.describe);
        if (rotation.showDate()) {
            a2.f19012c.setText(rotation.getDate());
        }
        postCityFirstShow(nearbyTransformersModel, rotation);
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.view.TransformersLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TransformersLayout.this.postCityFirstClick(nearbyTransformersModel, rotation);
                CommunityServiceManager.b().a(TransformersLayout.this.getContext(), nearbyTransformersModel.url);
                NearbyFeedFragment.r = SystemClock.elapsedRealtime();
            }
        });
        viewFlipper.addView(a2.getRoot());
    }

    private void addItemQuarterView(final NearbyTransformersModel nearbyTransformersModel, final NearbyTransformersModel.Rotation rotation, ViewFlipper viewFlipper) {
        ItemNearbyTransformersQuarterBinding a2 = ItemNearbyTransformersQuarterBinding.a(LayoutInflater.from(getContext()));
        a2.b.setText(nearbyTransformersModel.title);
        postCityFirstShow(nearbyTransformersModel, rotation);
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.view.TransformersLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TransformersLayout.this.postCityFirstClick(nearbyTransformersModel, rotation);
                CommunityServiceManager.b().a(TransformersLayout.this.getContext(), nearbyTransformersModel.url);
                NearbyFeedFragment.r = SystemClock.elapsedRealtime();
            }
        });
        viewFlipper.addView(a2.getRoot());
    }

    private void addQuarterView(NearbyTransformersModel nearbyTransformersModel) {
        ItemNearbyViewFlipperBinding a2 = ItemNearbyViewFlipperBinding.a(LayoutInflater.from(getContext()));
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() <= 0) {
            addItemQuarterView(nearbyTransformersModel, new NearbyTransformersModel.Rotation(), a2.b);
        } else {
            for (NearbyTransformersModel.Rotation rotation : nearbyTransformersModel.rotation) {
                addItemQuarterView(nearbyTransformersModel, rotation, a2.b);
            }
        }
        if (BluedSkinUtils.c()) {
            ImageLoader.a((IRequestHost) null, nearbyTransformersModel.white_background_img).d(R.drawable.shape_nearby_view_flipper_bg).a(a2.f19015a);
        } else {
            ImageLoader.a((IRequestHost) null, nearbyTransformersModel.black_background_img).d(R.drawable.shape_nearby_view_flipper_bg).a(a2.f19015a);
        }
        if (nearbyTransformersModel.rotation == null || nearbyTransformersModel.rotation.size() <= 1) {
            a2.b.stopFlipping();
        } else {
            a2.b.startFlipping();
        }
        addView(a2.getRoot());
    }

    public /* synthetic */ void lambda$addHalfEventView$0$TransformersLayout(ItemNearbyViewFlipperWithImgBinding itemNearbyViewFlipperWithImgBinding, NearbyTransformersModel nearbyTransformersModel, View view) {
        postCityFirstClick(nearbyTransformersModel, nearbyTransformersModel.rotation.get(itemNearbyViewFlipperWithImgBinding.j.getDisplayedChild()));
        CommunityServiceManager.b().a(getContext(), nearbyTransformersModel.url);
        NearbyFeedFragment.r = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        if (childCount == 1) {
            oneLayout(z, i, i2, i3, i4);
        } else if (childCount == 2) {
            twoLayout(z, i, i2, i3, i4);
        } else if (childCount != 3) {
        } else {
            threeLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.measure;
        if (i3 == 1) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) * this.ratio), 1073741824), i2);
        } else if (i3 != 2) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.ratio), 1073741824));
        }
    }

    protected void oneLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = paddingLeft + layoutParams.leftMargin;
        int i6 = ((i3 - i) - paddingRight) - layoutParams.rightMargin;
        int i7 = paddingTop + layoutParams.topMargin;
        int i8 = ((i4 - i2) - paddingBottom) - layoutParams.bottomMargin;
        layoutParams.width = i6 - i5;
        layoutParams.height = i8 - i7;
        childAt.layout(i5, i7, i6, i8);
    }

    public void postCityFirstClick(NearbyTransformersModel nearbyTransformersModel, NearbyTransformersModel.Rotation rotation) {
        EventTrackFeed.b(FeedProtos.Event.CITY_FIRST_CLICK, rotation.id, nearbyTransformersModel.type, CommunityManager.f19086a.a().t());
    }

    public void postCityFirstShow(NearbyTransformersModel nearbyTransformersModel, NearbyTransformersModel.Rotation rotation) {
        EventTrackFeed.b(FeedProtos.Event.CITY_FIRST_SHOW, rotation.id, nearbyTransformersModel.type, CommunityManager.f19086a.a().t());
    }

    public void setTransformersData(List<NearbyTransformersModel> list) {
        removeAllViews();
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return;
        }
        int size = list.size();
        if (size == 1) {
            addFullView(list.get(0));
        } else if (size == 2) {
            addHalfView(list.get(0));
            addHalfView(list.get(1));
        } else if (size == 3) {
            addHalfView(list.get(0));
            addQuarterView(list.get(1));
            addQuarterView(list.get(2));
        }
        if (getChildCount() > 0) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    protected void threeLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = layoutParams.leftMargin + paddingLeft;
        int i6 = paddingRight - paddingLeft;
        int i7 = (((i6 - this.space) / 2) + paddingLeft) - layoutParams.rightMargin;
        int i8 = layoutParams.topMargin + paddingTop;
        int i9 = paddingBottom - layoutParams.bottomMargin;
        layoutParams.width = i7 - i5;
        layoutParams.height = i9 - i8;
        childAt.layout(i5, i8, i7, i9);
        View childAt2 = getChildAt(1);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
        int i10 = ((this.space + i6) / 2) + paddingLeft + layoutParams2.leftMargin;
        int i11 = paddingRight - layoutParams2.rightMargin;
        int i12 = layoutParams2.topMargin + paddingTop;
        int i13 = paddingBottom - paddingTop;
        int i14 = ((i13 - this.space) / 2) + paddingTop + layoutParams2.topMargin;
        layoutParams2.width = i11 - i10;
        layoutParams2.height = i14 - i12;
        childAt2.layout(i10, i12, i11, i14);
        View childAt3 = getChildAt(2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) childAt3.getLayoutParams();
        int i15 = ((i6 + this.space) / 2) + paddingLeft + layoutParams3.leftMargin;
        int i16 = paddingRight - layoutParams3.rightMargin;
        int i17 = ((i13 + this.space) / 2) + paddingTop + layoutParams3.topMargin;
        int i18 = paddingBottom - layoutParams3.bottomMargin;
        layoutParams3.width = i16 - i15;
        layoutParams3.height = i18 - i17;
        childAt3.layout(i15, i17, i16, i18);
    }

    protected void twoLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = layoutParams.leftMargin + paddingLeft;
        int i6 = paddingRight - paddingLeft;
        int i7 = (((i6 - this.space) / 2) + paddingLeft) - layoutParams.rightMargin;
        int i8 = layoutParams.topMargin + paddingTop;
        int i9 = paddingBottom - layoutParams.bottomMargin;
        layoutParams.width = i7 - i5;
        layoutParams.height = i9 - i8;
        childAt.layout(i5, i8, i7, i9);
        View childAt2 = getChildAt(1);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
        int i10 = ((i6 + this.space) / 2) + paddingLeft + layoutParams2.leftMargin;
        int i11 = paddingRight - layoutParams2.rightMargin;
        int i12 = paddingTop + layoutParams2.topMargin;
        int i13 = paddingBottom - layoutParams2.bottomMargin;
        layoutParams2.width = i11 - i10;
        layoutParams2.height = i13 - i12;
        childAt2.layout(i10, i12, i11, i13);
    }
}
