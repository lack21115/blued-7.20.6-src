package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLivePocketRecordBinding;
import com.blued.android.module.live_china.model.LivePocketModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketRecordDialogFragment.class */
public final class LivePocketRecordDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogLivePocketRecordBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePocketRecordDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLivePocketRecordBinding invoke() {
            return DialogLivePocketRecordBinding.a(LayoutInflater.from(LivePocketRecordDialogFragment.this.getContext()));
        }
    });
    private List<LivePocketModel> c = new ArrayList();
    private CommonAdapter<LivePocketModel> d;
    private int e;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketRecordDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LivePocketRecordDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LivePocketRecordDialogFragment livePocketRecordDialogFragment = new LivePocketRecordDialogFragment();
            livePocketRecordDialogFragment.show(manager, LivePocketRecordDialogFragment.class.getSimpleName());
            return livePocketRecordDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePocketRecordDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLivePocketRecordBinding f() {
        return (DialogLivePocketRecordBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.e++;
        String valueOf = String.valueOf(this.e);
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.l(valueOf, new BluedUIHttpResponse<BluedEntityA<LivePocketModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LivePocketRecordDialogFragment$requestData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LivePocketModel> entity) {
                DialogLivePocketRecordBinding f;
                SmartRefreshLayout smartRefreshLayout;
                DialogLivePocketRecordBinding f2;
                SmartRefreshLayout smartRefreshLayout2;
                DialogLivePocketRecordBinding f3;
                List list;
                SmartRefreshLayout smartRefreshLayout3;
                DialogLivePocketRecordBinding f4;
                List list2;
                SmartRefreshLayout smartRefreshLayout4;
                Intrinsics.e(entity, "entity");
                if (LivePocketRecordDialogFragment.this.d() == 1) {
                    f4 = LivePocketRecordDialogFragment.this.f();
                    if (f4 != null && (smartRefreshLayout4 = f4.e) != null) {
                        smartRefreshLayout4.b(true);
                    }
                    list2 = LivePocketRecordDialogFragment.this.c;
                    list2.clear();
                }
                if (entity.data == null || entity.data.size() <= 0) {
                    f = LivePocketRecordDialogFragment.this.f();
                    if (f != null && (smartRefreshLayout = f.e) != null) {
                        smartRefreshLayout.b(false);
                    }
                    LivePocketRecordDialogFragment livePocketRecordDialogFragment = LivePocketRecordDialogFragment.this;
                    livePocketRecordDialogFragment.a(livePocketRecordDialogFragment.d() - 1);
                } else {
                    f3 = LivePocketRecordDialogFragment.this.f();
                    if (f3 != null && (smartRefreshLayout3 = f3.e) != null) {
                        smartRefreshLayout3.b(true);
                    }
                    list = LivePocketRecordDialogFragment.this.c;
                    List<LivePocketModel> list3 = entity.data;
                    Intrinsics.c(list3, "entity.data");
                    list.addAll(list3);
                }
                LivePocketRecordDialogFragment.this.h();
                f2 = LivePocketRecordDialogFragment.this.f();
                if (f2 == null || (smartRefreshLayout2 = f2.e) == null) {
                    return;
                }
                smartRefreshLayout2.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                DialogLivePocketRecordBinding f;
                SmartRefreshLayout smartRefreshLayout;
                LivePocketRecordDialogFragment livePocketRecordDialogFragment = LivePocketRecordDialogFragment.this;
                livePocketRecordDialogFragment.a(livePocketRecordDialogFragment.d() - 1);
                LivePocketRecordDialogFragment.this.h();
                f = LivePocketRecordDialogFragment.this.f();
                if (f != null && (smartRefreshLayout = f.e) != null) {
                    smartRefreshLayout.h();
                }
                return super.onUIFailure(i, str, str2);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        List<LivePocketModel> list = this.c;
        if (list == null || list.size() == 0) {
            DialogLivePocketRecordBinding f = f();
            LinearLayout linearLayout = f == null ? null : f.c;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            DialogLivePocketRecordBinding f2 = f();
            SmartRefreshLayout smartRefreshLayout = f2 == null ? null : f2.e;
            if (smartRefreshLayout == null) {
                return;
            }
            smartRefreshLayout.setVisibility(8);
            return;
        }
        DialogLivePocketRecordBinding f3 = f();
        LinearLayout linearLayout2 = f3 == null ? null : f3.c;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        DialogLivePocketRecordBinding f4 = f();
        SmartRefreshLayout smartRefreshLayout2 = f4 == null ? null : f4.e;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.setVisibility(0);
        }
        CommonAdapter<LivePocketModel> commonAdapter = this.d;
        if (commonAdapter == null) {
            return;
        }
        commonAdapter.a(this.c);
    }

    public final void a(int i) {
        this.e = i;
    }

    public final int d() {
        return this.e;
    }

    public final void e() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            if (dialog.isShowing()) {
                dismissAllowingStateLoss();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 398.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(f().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        View decorView = window.getDecorView();
        if (decorView != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void setupDialog(Dialog dialog, int i) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(f().getRoot());
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePocketRecordDialogFragment$xX955wuGYkDgCZlP39_3hW-wxoc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePocketRecordDialogFragment.a(LivePocketRecordDialogFragment.this, view);
            }
        });
        DialogLivePocketRecordBinding f = f();
        if (f != null && (smartRefreshLayout2 = f.e) != null) {
            smartRefreshLayout2.c(false);
        }
        BluedLoadMoreView bluedLoadMoreView = new BluedLoadMoreView(getContext());
        bluedLoadMoreView.setBackgroundColorRes(R.color.transparent);
        DialogLivePocketRecordBinding f2 = f();
        (f2 == null ? null : f2.e).a(bluedLoadMoreView);
        DialogLivePocketRecordBinding f3 = f();
        if (f3 != null && (smartRefreshLayout = f3.e) != null) {
            smartRefreshLayout.a(new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LivePocketRecordDialogFragment$setupDialog$2
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    LivePocketRecordDialogFragment.this.g();
                }
            });
        }
        final int i2 = R.layout.live_pocket_props_record_item;
        this.d = new CommonAdapter<LivePocketModel>(i2) { // from class: com.blued.android.module.live_china.fragment.LivePocketRecordDialogFragment$setupDialog$3
            @Override // com.blued.android.module.common.adapter.CommonAdapter
            public void a(CommonAdapter.ViewHolder holder, LivePocketModel item, int i3) {
                Intrinsics.e(holder, "holder");
                Intrinsics.e(item, "item");
                View a2 = holder.a(R.id.view_main);
                ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (i3 == 0) {
                    marginLayoutParams.topMargin = DensityUtils.a(LivePocketRecordDialogFragment.this.getContext(), 15.0f);
                } else {
                    marginLayoutParams.topMargin = DensityUtils.a(LivePocketRecordDialogFragment.this.getContext(), 7.5f);
                }
                a2.setLayoutParams(marginLayoutParams);
                holder.c(R.id.iv_icon, item.getImage());
                holder.a(R.id.tv_name, item.getName());
                if (item.getUse_time() > 0) {
                    SimpleDateFormat simpleDateFormat = TimeAndDateUtils.l.get();
                    String format = simpleDateFormat == null ? null : simpleDateFormat.format(new Date(item.getUse_time() * 1000));
                    String str = format;
                    if (format == null) {
                        str = "";
                    }
                    holder.b(R.id.ll_time, 0);
                    holder.a(R.id.tv_time, str);
                } else {
                    holder.b(R.id.ll_time, 8);
                }
                if (item.getEffect_time() <= 0) {
                    holder.b(R.id.ll_dead, 8);
                    return;
                }
                holder.b(R.id.ll_dead, 0);
                SimpleDateFormat simpleDateFormat2 = TimeAndDateUtils.l.get();
                String format2 = simpleDateFormat2 == null ? null : simpleDateFormat2.format(new Date((item.getEffect_time() + item.getUse_time()) * 1000));
                if (format2 == null) {
                    format2 = "";
                }
                holder.a(R.id.tv_dead_time, format2);
            }
        };
        DialogLivePocketRecordBinding f4 = f();
        ListView listView = f4 == null ? null : f4.b;
        if (listView != null) {
            listView.setAdapter((ListAdapter) this.d);
        }
        g();
    }
}
