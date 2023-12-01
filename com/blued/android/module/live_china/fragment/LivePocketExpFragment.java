package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLivePocketExpBinding;
import com.blued.android.module.live_china.model.LivePocketExtraModel;
import com.blued.android.module.live_china.model.LivePocketModel;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketExpFragment.class */
public final class LivePocketExpFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13152a = new Companion(null);
    private DialogLivePocketExpBinding b;

    /* renamed from: c  reason: collision with root package name */
    private List<LivePocketModel> f13153c = new ArrayList();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketExpFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a() {
        Bundle arguments = getArguments();
        if ((arguments == null ? null : arguments.getSerializable("model")) instanceof LivePocketExtraModel) {
            Bundle arguments2 = getArguments();
            Serializable serializable = arguments2 == null ? null : arguments2.getSerializable("model");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LivePocketExtraModel");
            }
            List<LivePocketModel> in_use = ((LivePocketExtraModel) serializable).getIn_use();
            if (in_use != null) {
                this.f13153c.addAll(in_use);
            }
        }
        List<LivePocketModel> list = this.f13153c;
        if (list == null || list.size() == 0) {
            DialogLivePocketExpBinding dialogLivePocketExpBinding = this.b;
            LinearLayout linearLayout = dialogLivePocketExpBinding == null ? null : dialogLivePocketExpBinding.b;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            DialogLivePocketExpBinding dialogLivePocketExpBinding2 = this.b;
            ListView listView = dialogLivePocketExpBinding2 == null ? null : dialogLivePocketExpBinding2.f11801a;
            if (listView == null) {
                return;
            }
            listView.setVisibility(8);
            return;
        }
        DialogLivePocketExpBinding dialogLivePocketExpBinding3 = this.b;
        LinearLayout linearLayout2 = dialogLivePocketExpBinding3 == null ? null : dialogLivePocketExpBinding3.b;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogLivePocketExpBinding dialogLivePocketExpBinding4 = this.b;
        ListView listView2 = dialogLivePocketExpBinding4 == null ? null : dialogLivePocketExpBinding4.f11801a;
        if (listView2 != null) {
            listView2.setVisibility(0);
        }
        final int i = R.layout.live_pocket_props_exp_item;
        CommonAdapter<LivePocketModel> commonAdapter = new CommonAdapter<LivePocketModel>(i) { // from class: com.blued.android.module.live_china.fragment.LivePocketExpFragment$setData$adapter$1
            /* JADX WARN: Type inference failed for: r1v21, types: [T, android.view.View] */
            /* JADX WARN: Type inference failed for: r1v24, types: [T, android.view.View] */
            @Override // com.blued.android.module.common.adapter.CommonAdapter
            public void a(CommonAdapter.ViewHolder holder, LivePocketModel item, int i2) {
                Intrinsics.e(holder, "holder");
                Intrinsics.e(item, "item");
                ViewGroup.LayoutParams layoutParams = holder.a(R.id.view_main).getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (i2 == 0) {
                    marginLayoutParams.topMargin = DensityUtils.a(LivePocketExpFragment.this.getContext(), 12.0f);
                } else {
                    marginLayoutParams.topMargin = DensityUtils.a(LivePocketExpFragment.this.getContext(), 8.0f);
                }
                holder.c(R.id.iv_icon, item.getImage());
                holder.a(R.id.tv_name, item.getName());
                SimpleDateFormat simpleDateFormat = TimeAndDateUtils.l.get();
                String format = simpleDateFormat == null ? null : simpleDateFormat.format(new Date((item.getEffect_time() + item.getUse_time()) * 1000));
                String str = format;
                if (format == null) {
                    str = "";
                }
                int i3 = R.id.tv_time;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = AppInfo.d().getString(R.string.live_pocket_exp_over1);
                Intrinsics.c(string, "getAppContext().getStrin…ng.live_pocket_exp_over1)");
                String format2 = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.c(format2, "format(format, *args)");
                holder.a(i3, format2);
                holder.a(R.id.tv_des, item.getDescription());
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.f42545a = holder.a(R.id.tv_des);
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.f42545a = holder.a(R.id.ll_des);
                ViewTreeObserver viewTreeObserver = ((TextView) objectRef.f42545a).getViewTreeObserver();
                final LivePocketExpFragment livePocketExpFragment = LivePocketExpFragment.this;
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.blued.android.module.live_china.fragment.LivePocketExpFragment$setData$adapter$1$convert$1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        objectRef.f42545a.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (objectRef.f42545a.getLineCount() > 1) {
                            ViewGroup.LayoutParams layoutParams2 = objectRef2.f42545a.getLayoutParams();
                            if (layoutParams2 != null) {
                                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = DensityUtils.a(livePocketExpFragment.getContext(), 20.5f);
                                return true;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        }
                        ViewGroup.LayoutParams layoutParams3 = objectRef2.f42545a.getLayoutParams();
                        if (layoutParams3 != null) {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = DensityUtils.a(livePocketExpFragment.getContext(), 13.0f);
                            return true;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                });
            }
        };
        DialogLivePocketExpBinding dialogLivePocketExpBinding5 = this.b;
        ListView listView3 = dialogLivePocketExpBinding5 == null ? null : dialogLivePocketExpBinding5.f11801a;
        if (listView3 != null) {
            listView3.setAdapter((ListAdapter) commonAdapter);
        }
        commonAdapter.a(this.f13153c);
        commonAdapter.notifyDataSetChanged();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout root;
        FrameLayout root2;
        Intrinsics.e(inflater, "inflater");
        DialogLivePocketExpBinding a2 = DialogLivePocketExpBinding.a(getLayoutInflater(), viewGroup, false);
        this.b = a2;
        if (((a2 == null || (root = a2.getRoot()) == null) ? null : root.getParent()) != null) {
            DialogLivePocketExpBinding dialogLivePocketExpBinding = this.b;
            ViewParent parent = (dialogLivePocketExpBinding == null || (root2 = dialogLivePocketExpBinding.getRoot()) == null) ? null : root2.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            DialogLivePocketExpBinding dialogLivePocketExpBinding2 = this.b;
            viewGroup2.removeView(dialogLivePocketExpBinding2 == null ? null : dialogLivePocketExpBinding2.getRoot());
        }
        a();
        DialogLivePocketExpBinding dialogLivePocketExpBinding3 = this.b;
        return dialogLivePocketExpBinding3 == null ? null : dialogLivePocketExpBinding3.getRoot();
    }
}
