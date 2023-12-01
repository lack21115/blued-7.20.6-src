package com.soft.blued.ui.find.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.community.view.PhotoGridView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.LayoutFilterCommonPhotoGridViewBinding;
import com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FilterCommonPhotoGridView.class */
public final class FilterCommonPhotoGridView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f16989a;
    private LayoutFilterCommonPhotoGridViewBinding b;

    /* renamed from: c  reason: collision with root package name */
    private FilterSelectorOpenTwoLevelListener f16990c;
    private boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterCommonPhotoGridView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.d = true;
        this.f16989a = context;
        a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterCommonPhotoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attributeSet");
        this.d = true;
        this.f16989a = context;
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterCommonPhotoGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attributeSet");
        this.d = true;
        this.f16989a = context;
        a(attributeSet);
    }

    private final void a(AttributeSet attributeSet) {
        Context context = this.f16989a;
        if (context == null) {
            return;
        }
        LayoutFilterCommonPhotoGridViewBinding a2 = LayoutFilterCommonPhotoGridViewBinding.a(LayoutInflater.from(context).inflate(R.layout.layout_filter_common_photo_grid_view, this));
        this.b = a2;
        if (a2 == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FilterCommonPhotoGridView);
            Intrinsics.c(obtainStyledAttributes, "mContext.obtainStyledAtt…ilterCommonPhotoGridView)");
            a2.h.setText(obtainStyledAttributes.getString(0));
            a2.i.setText(obtainStyledAttributes.getString(1));
            a2.i.setTextColor(obtainStyledAttributes.getColor(2, BluedSkinUtils.a(context, 2131102254)));
        }
        a2.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$FilterCommonPhotoGridView$mSWJISqhbMSsXYuseUNnQ-FAUTU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterCommonPhotoGridView.a(FilterCommonPhotoGridView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterCommonPhotoGridView filterCommonPhotoGridView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(filterCommonPhotoGridView, "this$0");
        if (filterCommonPhotoGridView.d) {
            filterCommonPhotoGridView.c();
        }
    }

    private final void c() {
        FilterSelectorOpenTwoLevelListener openTwoLevelListener;
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        if (layoutFilterCommonPhotoGridViewBinding == null) {
            return;
        }
        boolean b = layoutFilterCommonPhotoGridViewBinding.d.b();
        setTagArrow(b);
        setDefaultContent(b);
        if (!b || (openTwoLevelListener = getOpenTwoLevelListener()) == null) {
            return;
        }
        openTwoLevelListener.a();
    }

    private final void setDefaultContent(boolean z) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Context context = this.f16989a;
        if (context == null) {
            return;
        }
        if (z) {
            LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
            if (TextUtils.equals(String.valueOf((layoutFilterCommonPhotoGridViewBinding == null || (textView3 = layoutFilterCommonPhotoGridViewBinding.i) == null) ? null : textView3.getText()), context.getString(R.string.filter_new_choose))) {
                LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding2 = this.b;
                TextView textView5 = layoutFilterCommonPhotoGridViewBinding2 == null ? null : layoutFilterCommonPhotoGridViewBinding2.i;
                if (textView5 != null) {
                    textView5.setText("");
                }
                LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding3 = this.b;
                if (layoutFilterCommonPhotoGridViewBinding3 == null || (textView4 = layoutFilterCommonPhotoGridViewBinding3.i) == null) {
                    return;
                }
                textView4.setTextColor(BluedSkinUtils.a(context, 2131101766));
                return;
            }
            return;
        }
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding4 = this.b;
        if (TextUtils.isEmpty(String.valueOf((layoutFilterCommonPhotoGridViewBinding4 == null || (textView = layoutFilterCommonPhotoGridViewBinding4.i) == null) ? null : textView.getText()))) {
            LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding5 = this.b;
            TextView textView6 = layoutFilterCommonPhotoGridViewBinding5 == null ? null : layoutFilterCommonPhotoGridViewBinding5.i;
            if (textView6 != null) {
                textView6.setText(context.getString(R.string.filter_new_choose));
            }
            LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding6 = this.b;
            if (layoutFilterCommonPhotoGridViewBinding6 == null || (textView2 = layoutFilterCommonPhotoGridViewBinding6.i) == null) {
                return;
            }
            textView2.setTextColor(BluedSkinUtils.a(context, 2131102254));
        }
    }

    private final void setTagArrow(boolean z) {
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding;
        Context context = this.f16989a;
        if (context == null || (layoutFilterCommonPhotoGridViewBinding = this.b) == null) {
            return;
        }
        if (z) {
            layoutFilterCommonPhotoGridViewBinding.f15700c.setImageDrawable(context.getDrawable(R.drawable.icon_arrow_up_filter));
        } else {
            layoutFilterCommonPhotoGridViewBinding.f15700c.setImageDrawable(context.getDrawable(R.drawable.icon_arrow_down_filter));
        }
    }

    public final void a() {
        if (b()) {
            c();
        }
    }

    public final boolean b() {
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        if (layoutFilterCommonPhotoGridViewBinding == null) {
            return false;
        }
        return layoutFilterCommonPhotoGridViewBinding.d.a();
    }

    public final FilterSelectorOpenTwoLevelListener getOpenTwoLevelListener() {
        return this.f16990c;
    }

    public final PhotoGridView getPhotoGridView() {
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        if (layoutFilterCommonPhotoGridViewBinding == null) {
            return null;
        }
        return layoutFilterCommonPhotoGridViewBinding.f15699a;
    }

    public final PhotoGridView getPhotoGridView2() {
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        if (layoutFilterCommonPhotoGridViewBinding == null) {
            return null;
        }
        return layoutFilterCommonPhotoGridViewBinding.b;
    }

    public final void setGridViewTitle(String str) {
        Intrinsics.e(str, "title");
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        TextView textView = layoutFilterCommonPhotoGridViewBinding == null ? null : layoutFilterCommonPhotoGridViewBinding.f;
        if (textView != null) {
            textView.setVisibility(0);
        }
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding2 = this.b;
        TextView textView2 = layoutFilterCommonPhotoGridViewBinding2 == null ? null : layoutFilterCommonPhotoGridViewBinding2.f;
        if (textView2 == null) {
            return;
        }
        textView2.setText(str);
    }

    public final void setGridViewTitle2(String str) {
        Intrinsics.e(str, "title");
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        TextView textView = layoutFilterCommonPhotoGridViewBinding == null ? null : layoutFilterCommonPhotoGridViewBinding.g;
        if (textView != null) {
            textView.setVisibility(0);
        }
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding2 = this.b;
        TextView textView2 = layoutFilterCommonPhotoGridViewBinding2 == null ? null : layoutFilterCommonPhotoGridViewBinding2.g;
        if (textView2 == null) {
            return;
        }
        textView2.setText(str);
    }

    public final void setLeftText(String str) {
        Intrinsics.e(str, "text");
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        TextView textView = layoutFilterCommonPhotoGridViewBinding == null ? null : layoutFilterCommonPhotoGridViewBinding.h;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void setNeedClickShowTwoLevel(boolean z) {
        this.d = z;
    }

    public final void setOpenTwoLevelListener(FilterSelectorOpenTwoLevelListener filterSelectorOpenTwoLevelListener) {
        this.f16990c = filterSelectorOpenTwoLevelListener;
    }

    public final void setRightText(String str) {
        Intrinsics.e(str, "text");
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        TextView textView = layoutFilterCommonPhotoGridViewBinding == null ? null : layoutFilterCommonPhotoGridViewBinding.i;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void setRightTextColor(int i) {
        TextView textView;
        LayoutFilterCommonPhotoGridViewBinding layoutFilterCommonPhotoGridViewBinding = this.b;
        if (layoutFilterCommonPhotoGridViewBinding == null || (textView = layoutFilterCommonPhotoGridViewBinding.i) == null) {
            return;
        }
        textView.setTextColor(i);
    }
}
