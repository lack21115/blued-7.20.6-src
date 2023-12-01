package com.soft.blued.ui.msg.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/view/MultiPicLayout.class */
public final class MultiPicLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f32604a;
    private final FrameLayout.LayoutParams b;

    /* renamed from: c  reason: collision with root package name */
    private int f32605c;
    private int d;
    private final ArrayList<ImageView> e;
    private final ArrayList<RelativeLayout> f;
    private final SparseArray<ImageView> g;
    private TextView h;
    private Callback i;
    private boolean j;
    private List<String> k;
    private IRequestHost l;
    private boolean m;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/view/MultiPicLayout$Callback.class */
    public interface Callback {
        void a(ImageView imageView, SparseArray<ImageView> sparseArray, List<String> list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiPicLayout(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiPicLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPicLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f32604a = 4;
        this.b = new FrameLayout.LayoutParams(-2, -2);
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.g = new SparseArray<>();
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f32605c = (int) (TypedValue.applyDimension(1, 144.0f, displayMetrics) + 0.5f);
        this.d = (int) (TypedValue.applyDimension(1, 2.0f, displayMetrics) + 0.5f);
        int i2 = this.f32604a;
        int i3 = 0;
        while (i3 < i2) {
            i3++;
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            Context context2 = getContext();
            Intrinsics.c(context2, "context");
            ColorFilterImageView colorFilterImageView = new ColorFilterImageView(context2);
            colorFilterImageView.setEnable(this.m);
            colorFilterImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (this.m) {
                colorFilterImageView.setOnClickListener(this);
            }
            relativeLayout.addView(colorFilterImageView, new FrameLayout.LayoutParams(-2, -2));
            this.f.add(relativeLayout);
            addView(relativeLayout);
            this.e.add(colorFilterImageView);
        }
        TextView textView = new TextView(getContext());
        this.h = textView;
        textView.setTextColor(ContextCompat.getColor(getContext(), 2131102360));
        this.h.setTextSize(14.0f);
        this.h.setGravity(17);
        this.h.setBackgroundColor(Color.parseColor("#80000000"));
        this.h.setVisibility(8);
        addView(this.h);
        this.j = true;
    }

    private final void a() {
        List<String> list = this.k;
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        List<String> list2 = this.k;
        int size = list2 == null ? 0 : list2.size();
        int i = 2;
        int i2 = size == 1 ? 1 : (size != 2 && (size == 3 || size < 4)) ? 3 : 2;
        if (size <= 3) {
            i = 1;
        }
        int width = getWidth();
        if (size != 1) {
            width = (int) (((width * 1.0f) - (this.d * (i2 - 1))) / i2);
        }
        this.b.width = width;
        FrameLayout.LayoutParams layoutParams = this.b;
        layoutParams.height = layoutParams.width;
        this.h.setVisibility(size > this.f32604a ? 0 : 8);
        this.h.setText(Intrinsics.a("+ ", (Object) Integer.valueOf(size - this.f32604a)));
        this.h.setLayoutParams(this.b);
        this.g.clear();
        int size2 = this.e.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                getLayoutParams().height = (width * i) + (this.d * (i - 1));
                return;
            }
            ImageView imageView = this.e.get(i4);
            Intrinsics.c(imageView, "pictureList[i]");
            ImageView imageView2 = imageView;
            RelativeLayout relativeLayout = this.f.get(i4);
            Intrinsics.c(relativeLayout, "contentList[i]");
            RelativeLayout relativeLayout2 = relativeLayout;
            if (i4 < size) {
                relativeLayout2.setVisibility(0);
                this.g.put(i4, imageView2);
                ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams3.width = width;
                layoutParams3.height = this.b.width;
                imageView2.setLayoutParams(layoutParams3);
                relativeLayout2.setLayoutParams(this.b);
                List<String> list3 = this.k;
                if (list3 != null) {
                    ImageLoader.a(getRequestHost(), list3.get(i4)).b(2131232687).a(imageView2);
                }
                relativeLayout2.setTranslationX((i4 % i2) * (this.d + width));
                relativeLayout2.setTranslationY((i4 / i2) * (this.d + width));
            } else {
                relativeLayout2.setVisibility(8);
            }
            if (i4 == this.f32604a - 1) {
                this.h.setTranslationX((i4 % i2) * (this.d + width));
                this.h.setTranslationY((i4 / i2) * (this.d + width));
            }
            i3 = i4 + 1;
        }
    }

    public final Callback getCallback() {
        return this.i;
    }

    public final boolean getNeedClick() {
        return this.m;
    }

    public final IRequestHost getRequestHost() {
        return this.l;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Tracker.onClick(v);
        Intrinsics.e(v, "v");
        Callback callback = this.i;
        if (callback == null) {
            return;
        }
        callback.a((ImageView) v, this.g, this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public final void setCallback(Callback callback) {
        this.i = callback;
    }

    public final void setData(List<String> urlList) {
        Intrinsics.e(urlList, "urlList");
        this.k = urlList;
        if (this.j) {
            a();
        }
    }

    public final void setNeedClick(boolean z) {
        this.m = z;
    }

    public final void setRequestHost(IRequestHost iRequestHost) {
        this.l = iRequestHost;
    }
}
