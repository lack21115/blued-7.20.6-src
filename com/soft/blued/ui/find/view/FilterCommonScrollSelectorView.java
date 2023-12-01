package com.soft.blued.ui.find.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.scrollpicker.ScrollPickerView;
import com.blued.android.module.common.view.scrollpicker.StringScrollPicker;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.LayoutFilterCommonSelectorBinding;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.manager.FilterNewHelper;
import com.soft.blued.ui.find.manager.FilterSelectorOpenTwoLevelListener;
import com.soft.blued.ui.user.presenter.PayUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FilterCommonScrollSelectorView.class */
public final class FilterCommonScrollSelectorView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f30681a = new Companion(null);
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutFilterCommonSelectorBinding f30682c;
    private FilterSelectorOpenTwoLevelListener d;
    private final int e;
    private String f;
    private String g;
    private Map<String, Integer> h;
    private Map<String, Integer> i;
    private boolean j;
    private String k;

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FilterCommonScrollSelectorView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterCommonScrollSelectorView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.e = DensityUtils.a(AppInfo.d(), 170.0f);
        this.f = "";
        this.g = "";
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.k = "";
        this.b = context;
        a((AttributeSet) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterCommonScrollSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attributeSet");
        this.e = DensityUtils.a(AppInfo.d(), 170.0f);
        this.f = "";
        this.g = "";
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.k = "";
        this.b = context;
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterCommonScrollSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attributeSet");
        this.e = DensityUtils.a(AppInfo.d(), 170.0f);
        this.f = "";
        this.g = "";
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.k = "";
        this.b = context;
        a(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FilterCommonScrollSelectorView this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        String str = this.k;
        boolean z = true;
        if (!Intrinsics.a((Object) str, (Object) "ONLINE_TIME")) {
            if (Intrinsics.a((Object) str, (Object) "DISTANCE")) {
                EventTrackGuy.a(GuyProtos.Event.SCREEN_DISTANCE_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0);
                return;
            }
            return;
        }
        GuyProtos.Event event = GuyProtos.Event.SCREEN_ONLINE_TIME_BTN_CLICK;
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            z = false;
        }
        EventTrackGuy.a(event, z);
    }

    private final boolean c() {
        return UserInfo.getInstance().getLoginUserInfo().vip_grade != 0;
    }

    private final void d() {
        FilterSelectorOpenTwoLevelListener openTwoLevelListener;
        if (this.j && !c()) {
            PayUtils.a(this.b, 24, Intrinsics.a((Object) this.k, (Object) "ONLINE_TIME") ? "nearby_filter_time" : "nearby_filter_distance", Intrinsics.a((Object) this.k, (Object) "ONLINE_TIME") ? VipProtos.FromType.ONLINE_FILTER : VipProtos.FromType.DISTANCE_FILTER);
            return;
        }
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        if (layoutFilterCommonSelectorBinding == null) {
            return;
        }
        boolean b = layoutFilterCommonSelectorBinding.e.b();
        setTagArrow(b);
        if (!b || (openTwoLevelListener = getOpenTwoLevelListener()) == null) {
            return;
        }
        openTwoLevelListener.a();
    }

    private final boolean e() {
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        if (layoutFilterCommonSelectorBinding == null) {
            return false;
        }
        return layoutFilterCommonSelectorBinding.e.a();
    }

    private final void f() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, Integer> entry : this.h.entrySet()) {
            arrayList.add(entry.getKey());
        }
        for (Map.Entry<String, Integer> entry2 : this.i.entrySet()) {
            arrayList2.add(entry2.getKey());
        }
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        StringScrollPicker stringScrollPicker = layoutFilterCommonSelectorBinding == null ? null : layoutFilterCommonSelectorBinding.f29392c;
        if (stringScrollPicker != null) {
            stringScrollPicker.setData(arrayList);
        }
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding2 = this.f30682c;
        StringScrollPicker stringScrollPicker2 = layoutFilterCommonSelectorBinding2 == null ? null : layoutFilterCommonSelectorBinding2.d;
        if (stringScrollPicker2 == null) {
            return;
        }
        stringScrollPicker2.setData(arrayList2);
    }

    private final void setTagArrow(boolean z) {
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding;
        Context context = this.b;
        if (context == null || (layoutFilterCommonSelectorBinding = this.f30682c) == null) {
            return;
        }
        if (z) {
            layoutFilterCommonSelectorBinding.b.setImageDrawable(context.getDrawable(R.drawable.icon_arrow_up_filter));
        } else {
            layoutFilterCommonSelectorBinding.b.setImageDrawable(context.getDrawable(R.drawable.icon_arrow_down_filter));
        }
    }

    public final void a() {
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding;
        ExpandLinearLayout expandLinearLayout;
        if (!e() || (layoutFilterCommonSelectorBinding = this.f30682c) == null || (expandLinearLayout = layoutFilterCommonSelectorBinding.e) == null) {
            return;
        }
        expandLinearLayout.b();
    }

    public final void a(AttributeSet attributeSet) {
        Context context = this.b;
        if (context == null) {
            return;
        }
        final LayoutFilterCommonSelectorBinding a2 = LayoutFilterCommonSelectorBinding.a(LayoutInflater.from(context).inflate(R.layout.layout_filter_common_selector, this));
        this.f30682c = a2;
        if (a2 == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FilterCommonScrollSelectorView);
            Intrinsics.c(obtainStyledAttributes, "mContext.obtainStyledAtt…CommonScrollSelectorView)");
            a2.g.setText(obtainStyledAttributes.getString(0));
            a2.f.setText(obtainStyledAttributes.getString(1));
        }
        a2.f29392c.a(BluedSkinUtils.a(context, 2131102254), BluedSkinUtils.a(context, 2131102263), BluedSkinUtils.a(context, 2131102260));
        a2.d.a(BluedSkinUtils.a(context, 2131102254), BluedSkinUtils.a(context, 2131102263), BluedSkinUtils.a(context, 2131102260));
        a2.f29391a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$FilterCommonScrollSelectorView$IyqLugrwoMqzmREKftX30MLs_O8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterCommonScrollSelectorView.a(FilterCommonScrollSelectorView.this, view);
            }
        });
        a2.f29392c.setOnSelectedListener(new ScrollPickerView.OnSelectedListener() { // from class: com.soft.blued.ui.find.view.FilterCommonScrollSelectorView$initView$1$1$3
            @Override // com.blued.android.module.common.view.scrollpicker.ScrollPickerView.OnSelectedListener
            public void a(ScrollPickerView<?> scrollPickerView, int i) {
                Map map;
                String str;
                Map map2;
                if (LayoutFilterCommonSelectorBinding.this.f29392c.getData() != null && LayoutFilterCommonSelectorBinding.this.f29392c.getData().size() > i) {
                    this.f = LayoutFilterCommonSelectorBinding.this.f29392c.getSelectedItem().toString();
                }
                map = this.h;
                str = this.f;
                Integer num = (Integer) map.get(str);
                map2 = this.i;
                Integer num2 = (Integer) map2.get(LayoutFilterCommonSelectorBinding.this.d.getSelectedItem().toString());
                if (num != null) {
                    LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = LayoutFilterCommonSelectorBinding.this;
                    FilterCommonScrollSelectorView filterCommonScrollSelectorView = this;
                    int intValue = num.intValue();
                    if (num2 != null) {
                        int intValue2 = num2.intValue();
                        if (FilterNewHelper.f30593a.a(layoutFilterCommonSelectorBinding.f29392c.getData().get(0).toString())) {
                            if (intValue >= intValue2) {
                                layoutFilterCommonSelectorBinding.d.a(intValue - 1, true);
                            }
                        } else if (intValue >= intValue2) {
                            if (Intrinsics.a((Object) filterCommonScrollSelectorView.getVIEW_TAG(), (Object) "ONLINE_TIME") || Intrinsics.a((Object) filterCommonScrollSelectorView.getVIEW_TAG(), (Object) "DISTANCE")) {
                                layoutFilterCommonSelectorBinding.d.a(intValue + 1, true);
                            } else {
                                layoutFilterCommonSelectorBinding.d.a(intValue, true);
                            }
                        }
                    }
                }
                this.setRightText(true);
                this.b();
            }

            @Override // com.blued.android.module.common.view.scrollpicker.ScrollPickerView.OnSelectedListener
            public void a(boolean z) {
            }
        });
        a2.d.setOnSelectedListener(new ScrollPickerView.OnSelectedListener() { // from class: com.soft.blued.ui.find.view.FilterCommonScrollSelectorView$initView$1$1$4
            @Override // com.blued.android.module.common.view.scrollpicker.ScrollPickerView.OnSelectedListener
            public void a(ScrollPickerView<?> scrollPickerView, int i) {
                Map map;
                Map map2;
                String str;
                int intValue;
                if (LayoutFilterCommonSelectorBinding.this.d.getData() != null && LayoutFilterCommonSelectorBinding.this.d.getData().size() > i) {
                    this.g = LayoutFilterCommonSelectorBinding.this.d.getSelectedItem().toString();
                }
                map = this.h;
                Integer num = (Integer) map.get(LayoutFilterCommonSelectorBinding.this.f29392c.getSelectedItem().toString());
                map2 = this.i;
                str = this.g;
                Integer num2 = (Integer) map2.get(str);
                if (num != null) {
                    FilterCommonScrollSelectorView filterCommonScrollSelectorView = this;
                    LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = LayoutFilterCommonSelectorBinding.this;
                    int intValue2 = num.intValue();
                    if (num2 != null && intValue2 >= (intValue = num2.intValue())) {
                        if (!Intrinsics.a((Object) filterCommonScrollSelectorView.getVIEW_TAG(), (Object) "DISTANCE") && !Intrinsics.a((Object) filterCommonScrollSelectorView.getVIEW_TAG(), (Object) "ONLINE_TIME")) {
                            layoutFilterCommonSelectorBinding.f29392c.a(intValue, true);
                        } else if (intValue != 0) {
                            layoutFilterCommonSelectorBinding.f29392c.a(intValue - 1, true);
                        } else {
                            layoutFilterCommonSelectorBinding.f29392c.a(0, true);
                            layoutFilterCommonSelectorBinding.d.a(1, true);
                        }
                    }
                }
                this.setRightText(true);
                this.b();
            }

            @Override // com.blued.android.module.common.view.scrollpicker.ScrollPickerView.OnSelectedListener
            public void a(boolean z) {
            }
        });
    }

    public final void a(Integer num, Integer num2) {
        StringScrollPicker stringScrollPicker;
        StringScrollPicker stringScrollPicker2;
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (num2 == null) {
            return;
        }
        int intValue2 = num2.intValue();
        if (intValue < 0 || intValue2 < 0) {
            return;
        }
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        if (layoutFilterCommonSelectorBinding != null && (stringScrollPicker2 = layoutFilterCommonSelectorBinding.f29392c) != null) {
            stringScrollPicker2.a(intValue, false);
        }
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding2 = this.f30682c;
        if (layoutFilterCommonSelectorBinding2 == null || (stringScrollPicker = layoutFilterCommonSelectorBinding2.d) == null) {
            return;
        }
        stringScrollPicker.a(intValue2, false);
    }

    public final void a(Map<String, Integer> left, Map<String, Integer> right) {
        Intrinsics.e(left, "left");
        Intrinsics.e(right, "right");
        this.h = left;
        this.i = right;
        f();
    }

    public final FilterSelectorOpenTwoLevelListener getOpenTwoLevelListener() {
        return this.d;
    }

    public final CharSequence getRightText() {
        TextView textView;
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        if (layoutFilterCommonSelectorBinding == null || (textView = layoutFilterCommonSelectorBinding.f) == null) {
            return null;
        }
        return textView.getText();
    }

    public final View getTwoLevelView() {
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        return layoutFilterCommonSelectorBinding == null ? null : layoutFilterCommonSelectorBinding.e;
    }

    public final String getVIEW_TAG() {
        return this.k;
    }

    public final void setLeftText(String text) {
        Intrinsics.e(text, "text");
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        TextView textView = layoutFilterCommonSelectorBinding == null ? null : layoutFilterCommonSelectorBinding.g;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void setNeedVipPrivilege(boolean z) {
        this.j = z;
    }

    public final void setOpenTwoLevelListener(FilterSelectorOpenTwoLevelListener filterSelectorOpenTwoLevelListener) {
        this.d = filterSelectorOpenTwoLevelListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void setRightText(boolean z) {
        StringScrollPicker stringScrollPicker;
        StringScrollPicker stringScrollPicker2;
        String str;
        Resources resources;
        Resources resources2;
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        this.f = String.valueOf((layoutFilterCommonSelectorBinding == null || (stringScrollPicker = layoutFilterCommonSelectorBinding.f29392c) == null) ? null : stringScrollPicker.getSelectedItem());
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding2 = this.f30682c;
        this.g = String.valueOf((layoutFilterCommonSelectorBinding2 == null || (stringScrollPicker2 = layoutFilterCommonSelectorBinding2.d) == null) ? null : stringScrollPicker2.getSelectedItem());
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g) || TextUtils.isEmpty(this.k)) {
            return;
        }
        String str2 = this.k;
        switch (str2.hashCode()) {
            case -1738262920:
                if (str2.equals("WEIGHT")) {
                    str = FilterNewHelper.f30593a.c(this.h.get(this.f), this.i.get(this.g), this.b);
                    break;
                }
                str = "";
                break;
            case -1648306887:
                if (str2.equals("ONLINE_TIME")) {
                    str = FilterNewHelper.f30593a.d(this.h.get(this.f), this.i.get(this.g), this.b);
                    break;
                }
                str = "";
                break;
            case 64735:
                if (str2.equals("AGE")) {
                    str = FilterNewHelper.f30593a.a(this.h.get(this.f), this.i.get(this.g), this.b);
                    break;
                }
                str = "";
                break;
            case 1071086581:
                if (str2.equals("DISTANCE")) {
                    str = FilterNewHelper.f30593a.e(this.h.get(this.f), this.i.get(this.g), this.b);
                    break;
                }
                str = "";
                break;
            case 2127267111:
                if (str2.equals("HEIGHT")) {
                    str = FilterNewHelper.f30593a.b(this.h.get(this.f), this.i.get(this.g), this.b);
                    break;
                }
                str = "";
                break;
            default:
                str = "";
                break;
        }
        if (z) {
            if (this.j) {
                Context context = this.b;
                setRightTextColor((context == null || (resources2 = context.getResources()) == null) ? null : Integer.valueOf(resources2.getColor(2131102182)));
            } else {
                Context context2 = this.b;
                setRightTextColor((context2 == null || (resources = context2.getResources()) == null) ? null : Integer.valueOf(resources.getColor(2131101766)));
            }
        }
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding3 = this.f30682c;
        TextView textView = layoutFilterCommonSelectorBinding3 == null ? null : layoutFilterCommonSelectorBinding3.f;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void setRightTextColor(Integer num) {
        TextView textView;
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        LayoutFilterCommonSelectorBinding layoutFilterCommonSelectorBinding = this.f30682c;
        if (layoutFilterCommonSelectorBinding == null || (textView = layoutFilterCommonSelectorBinding.f) == null) {
            return;
        }
        textView.setTextColor(intValue);
    }

    public final void setTag(String tag) {
        Intrinsics.e(tag, "tag");
        this.k = tag;
    }

    public final void setVIEW_TAG(String str) {
        Intrinsics.e(str, "<set-?>");
        this.k = str;
    }
}
