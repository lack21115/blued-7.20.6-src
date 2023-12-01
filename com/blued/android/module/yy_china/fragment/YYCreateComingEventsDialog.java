package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.BluedGuideDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogCreateComingEventsBinding;
import com.blued.android.module.yy_china.fragment.YYCreateComingEventsDialog;
import com.blued.android.module.yy_china.fragment.YYDatePickerDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEventsThemeConfig;
import com.blued.android.module.yy_china.model.YYEventsThemeModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCreateComingEventsDialog.class */
public final class YYCreateComingEventsDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogCreateComingEventsBinding f17174a;
    private ThemeAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f17175c;
    private long d;
    private long e;
    private int f;
    private String g;
    private YYRoomModel h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCreateComingEventsDialog$ThemeAdapter.class */
    public final class ThemeAdapter extends BaseQuickAdapter<YYEventsThemeModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYCreateComingEventsDialog f17176a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThemeAdapter(YYCreateComingEventsDialog this$0) {
            super(R.layout.item_events_theme_layout);
            Intrinsics.e(this$0, "this$0");
            this.f17176a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ThemeAdapter this$0, YYEventsThemeModel yYEventsThemeModel, View view) {
            Intrinsics.e(this$0, "this$0");
            List<YYEventsThemeModel> data = this$0.getData();
            Intrinsics.c(data, "data");
            for (YYEventsThemeModel yYEventsThemeModel2 : data) {
                yYEventsThemeModel2.setChecked(false);
            }
            if (yYEventsThemeModel != null) {
                yYEventsThemeModel.setChecked(true);
            }
            this$0.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYEventsThemeModel yYEventsThemeModel) {
            View view;
            FrameLayout frameLayout = null;
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_theme_name);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_theme_icon);
            HollowView hollowView = baseViewHolder == null ? null : (HollowView) baseViewHolder.getView(R.id.item_stroke_view);
            if (baseViewHolder != null) {
                frameLayout = (FrameLayout) baseViewHolder.getView(R.id.item_cover_view);
            }
            if (yYEventsThemeModel != null) {
                YYCreateComingEventsDialog yYCreateComingEventsDialog = this.f17176a;
                if (yYEventsThemeModel.getChecked()) {
                    yYCreateComingEventsDialog.g = yYEventsThemeModel.getType_id();
                }
                if (textView != null) {
                    textView.setTextColor(yYCreateComingEventsDialog.b(yYEventsThemeModel.getChecked() ? R.color.syc_0CCCBC : R.color.syc_666666));
                }
                if (frameLayout != null) {
                    frameLayout.setBackgroundColor(yYCreateComingEventsDialog.b(yYEventsThemeModel.getChecked() ? R.color.syc_tran12_12C2C5 : R.color.syc_dark_b));
                }
                if (hollowView != null) {
                    hollowView.setMGradientColor(yYCreateComingEventsDialog.a(yYEventsThemeModel.getChecked()));
                }
                ImageLoader.a(yYCreateComingEventsDialog.a(), yYEventsThemeModel.getChecked() ? yYEventsThemeModel.getTheme_type_icon_light() : yYEventsThemeModel.getTheme_type_icon_gray()).a(imageView);
                if (textView != null) {
                    textView.setText(yYEventsThemeModel.getTheme_name());
                }
            }
            if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
                return;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$ThemeAdapter$q2vn5wOzj_t7hrCMK6KwhJE0ztA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYCreateComingEventsDialog.ThemeAdapter.a(YYCreateComingEventsDialog.ThemeAdapter.this, yYEventsThemeModel, view2);
                }
            });
        }
    }

    public YYCreateComingEventsDialog(BaseFragment fragment) {
        Intrinsics.e(fragment, "fragment");
        this.g = "";
        this.f17175c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Integer> a(boolean z) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(b(z ? R.color.syc_12C2C5 : R.color.syc_EDEDED)));
        return arrayList;
    }

    private final void a(int i) {
        int i2 = i;
        if (this.f == i) {
            i2 = 0;
        }
        this.f = i2;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        dialogCreateComingEventsBinding2.d.setChecked(this.f == 1);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding4 = dialogCreateComingEventsBinding3;
        if (dialogCreateComingEventsBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding4 = null;
        }
        dialogCreateComingEventsBinding4.e.setChecked(this.f == 2);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding5 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding6 = dialogCreateComingEventsBinding5;
        if (dialogCreateComingEventsBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding6 = null;
        }
        dialogCreateComingEventsBinding6.b.setChecked(this.f == 3);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding7 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding8 = dialogCreateComingEventsBinding7;
        if (dialogCreateComingEventsBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding8 = null;
        }
        dialogCreateComingEventsBinding8.d.setTextColor(getResources().getColor(this.f == 1 ? R.color.syc_dark_000000 : R.color.syc_666666));
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding9 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding10 = dialogCreateComingEventsBinding9;
        if (dialogCreateComingEventsBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding10 = null;
        }
        dialogCreateComingEventsBinding10.e.setTextColor(getResources().getColor(this.f == 2 ? R.color.syc_dark_000000 : R.color.syc_666666));
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding11 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding12 = dialogCreateComingEventsBinding11;
        if (dialogCreateComingEventsBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding12 = null;
        }
        dialogCreateComingEventsBinding12.b.setTextColor(getResources().getColor(this.f == 3 ? R.color.syc_dark_000000 : R.color.syc_666666));
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding13 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding14 = dialogCreateComingEventsBinding13;
        if (dialogCreateComingEventsBinding13 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding14 = null;
        }
        dialogCreateComingEventsBinding14.d.setTypeface(Typeface.DEFAULT, this.f == 1 ? 1 : 0);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding15 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding16 = dialogCreateComingEventsBinding15;
        if (dialogCreateComingEventsBinding15 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding16 = null;
        }
        dialogCreateComingEventsBinding16.e.setTypeface(Typeface.DEFAULT, this.f == 2 ? 1 : 0);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding17 = this.f17174a;
        if (dialogCreateComingEventsBinding17 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding17 = null;
        }
        CheckBox checkBox = dialogCreateComingEventsBinding17.b;
        Typeface typeface = Typeface.DEFAULT;
        int i3 = 0;
        if (this.f == 3) {
            i3 = 1;
        }
        checkBox.setTypeface(typeface, i3);
    }

    private final void a(long j, YYDatePickerDialog.IEventCallback iEventCallback) {
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        bundleOf.putLong("start_time", j);
        YYDatePickerDialog yYDatePickerDialog = new YYDatePickerDialog();
        yYDatePickerDialog.setArguments(bundleOf);
        yYDatePickerDialog.a(iEventCallback);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYDatePickerDialog.show(parentFragmentManager, "date_picker_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AlertDialog confirmDialog, View view) {
        Intrinsics.e(confirmDialog, "$confirmDialog");
        confirmDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYCreateComingEventsDialog this$0, AlertDialog confirmDialog, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(confirmDialog, "$confirmDialog");
        this$0.k();
        confirmDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(int i) {
        return requireContext().getResources().getColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_CREATE_PRE_QA_CLICK;
        YYRoomModel yYRoomModel = this$0.h;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.h;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.d(event, str2, str);
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a(this$0.f17175c, YYRoomInfoManager.e().c(16));
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYWebViewDialogFragment.show(childFragmentManager, "theme_event_rule_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this$0.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        dialogCreateComingEventsBinding2.q.requestFocus();
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = this$0.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding4 = dialogCreateComingEventsBinding3;
        if (dialogCreateComingEventsBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding4 = null;
        }
        EditText editText = dialogCreateComingEventsBinding4.q;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding5 = this$0.f17174a;
        if (dialogCreateComingEventsBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding5 = null;
        }
        editText.setSelection(dialogCreateComingEventsBinding5.q.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(0L, new YYDatePickerDialog.IEventCallback() { // from class: com.blued.android.module.yy_china.fragment.YYCreateComingEventsDialog$onViewCreated$5$1
            @Override // com.blued.android.module.yy_china.fragment.YYDatePickerDialog.IEventCallback
            public void a(long j, String date) {
                DialogCreateComingEventsBinding dialogCreateComingEventsBinding;
                DialogCreateComingEventsBinding dialogCreateComingEventsBinding2;
                Intrinsics.e(date, "date");
                YYCreateComingEventsDialog.this.d = j;
                dialogCreateComingEventsBinding = YYCreateComingEventsDialog.this.f17174a;
                DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = dialogCreateComingEventsBinding;
                if (dialogCreateComingEventsBinding == null) {
                    Intrinsics.c("mBinding");
                    dialogCreateComingEventsBinding3 = null;
                }
                dialogCreateComingEventsBinding3.v.setText(date);
                YYCreateComingEventsDialog.this.e = 0L;
                dialogCreateComingEventsBinding2 = YYCreateComingEventsDialog.this.f17174a;
                DialogCreateComingEventsBinding dialogCreateComingEventsBinding4 = dialogCreateComingEventsBinding2;
                if (dialogCreateComingEventsBinding4 == null) {
                    Intrinsics.c("mBinding");
                    dialogCreateComingEventsBinding4 = null;
                }
                dialogCreateComingEventsBinding4.p.setText("");
            }
        });
    }

    private final void f() {
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.w(new BluedUIHttpResponse<BluedEntityA<YYEventsThemeConfig>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYCreateComingEventsDialog$loadConfig$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYEventsThemeConfig> bluedEntityA) {
                YYCreateComingEventsDialog.ThemeAdapter themeAdapter;
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                YYEventsThemeConfig singleData = bluedEntityA.getSingleData();
                if (!singleData.getTypes().isEmpty()) {
                    singleData.getTypes().get(0).setChecked(true);
                }
                themeAdapter = YYCreateComingEventsDialog.this.b;
                if (themeAdapter == null) {
                    return;
                }
                themeAdapter.setNewData(singleData.getTypes());
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        long j = this$0.d;
        if (j <= 0) {
            ToastUtils.a("请先设置开始时间");
        } else {
            this$0.a(j, new YYDatePickerDialog.IEventCallback() { // from class: com.blued.android.module.yy_china.fragment.YYCreateComingEventsDialog$onViewCreated$6$1
                @Override // com.blued.android.module.yy_china.fragment.YYDatePickerDialog.IEventCallback
                public void a(long j2, String date) {
                    DialogCreateComingEventsBinding dialogCreateComingEventsBinding;
                    Intrinsics.e(date, "date");
                    YYCreateComingEventsDialog.this.e = j2;
                    dialogCreateComingEventsBinding = YYCreateComingEventsDialog.this.f17174a;
                    DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
                    if (dialogCreateComingEventsBinding == null) {
                        Intrinsics.c("mBinding");
                        dialogCreateComingEventsBinding2 = null;
                    }
                    dialogCreateComingEventsBinding2.p.setText(date);
                }
            });
        }
    }

    private final void g() {
        YYRoomModel yYRoomModel = this.h;
        if (yYRoomModel == null) {
            return;
        }
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        dialogCreateComingEventsBinding2.q.setText(yYRoomModel.room_name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Context requireContext = this$0.requireContext();
        Intrinsics.c(requireContext, "requireContext()");
        BluedGuideDialog bluedGuideDialog = new BluedGuideDialog(requireContext);
        BluedGuideDialog.GuideBuilder guideBuilder = new BluedGuideDialog.GuideBuilder();
        guideBuilder.b(0);
        guideBuilder.a(1);
        guideBuilder.a(20.0f);
        guideBuilder.a("以您个人名义发私信通知");
        bluedGuideDialog.a(guideBuilder);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this$0.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        bluedGuideDialog.showAsDropDown(dialogCreateComingEventsBinding2.j, -DensityUtils.a(this$0.requireContext(), 18.0f), 0);
    }

    private final void h() {
        this.b = new ThemeAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        dialogCreateComingEventsBinding2.n.setLayoutManager(linearLayoutManager);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = this.f17174a;
        if (dialogCreateComingEventsBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding3 = null;
        }
        dialogCreateComingEventsBinding3.n.setAdapter(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this$0.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        String obj = StringsKt.b((CharSequence) dialogCreateComingEventsBinding2.q.getText().toString()).toString();
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = this$0.f17174a;
        if (dialogCreateComingEventsBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding3 = null;
        }
        String obj2 = StringsKt.b((CharSequence) dialogCreateComingEventsBinding3.s.getText().toString()).toString();
        if (TextUtils.isEmpty(obj) || this$0.d <= 0 || this$0.e <= 0 || TextUtils.isEmpty(obj2)) {
            ToastUtils.a("信息未填完整");
        } else {
            this$0.j();
        }
    }

    private final void i() {
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        dialogCreateComingEventsBinding2.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$j3uoHZxvJT0RKa7kzfJ6Q9F_5Ek
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYCreateComingEventsDialog.i(YYCreateComingEventsDialog.this, view);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding4 = dialogCreateComingEventsBinding3;
        if (dialogCreateComingEventsBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding4 = null;
        }
        dialogCreateComingEventsBinding4.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$X0G0biERQK__hJ4shnWLUhHEUOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYCreateComingEventsDialog.j(YYCreateComingEventsDialog.this, view);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding5 = this.f17174a;
        if (dialogCreateComingEventsBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding5 = null;
        }
        dialogCreateComingEventsBinding5.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$UJ2SWvls5SlGssEP4YvWtdfTIzA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYCreateComingEventsDialog.k(YYCreateComingEventsDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(1);
    }

    private final void j() {
        TextView textView;
        TextView textView2;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_confirm_create_layout, (ViewGroup) null);
        final AlertDialog create = new AlertDialog.Builder(requireContext()).setView(inflate).create();
        Intrinsics.c(create, "Builder(requireContext()…View(dialogView).create()");
        if (inflate != null && (textView2 = (TextView) inflate.findViewById(R.id.btn_ok)) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$7p3tZ-3kHMKemj3MgmByAvEp_5Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateComingEventsDialog.a(YYCreateComingEventsDialog.this, create, view);
                }
            });
        }
        if (inflate != null && (textView = (TextView) inflate.findViewById(R.id.btn_cancel)) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$lOSR3c0iVzcgxll3XLLHqZQN-F4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYCreateComingEventsDialog.a(AlertDialog.this, view);
                }
            });
        }
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        create.show();
        Window window = create.getWindow();
        if (window != null) {
            window.setLayout(DensityUtils.a(getContext(), 320.0f), -2);
        }
        if (create.getWindow() != null) {
            Window window2 = create.getWindow();
            Intrinsics.a(window2);
            window2.setBackgroundDrawableResource(R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(2);
    }

    private final void k() {
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        String obj = StringsKt.b((CharSequence) dialogCreateComingEventsBinding2.q.getText().toString()).toString();
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding4 = dialogCreateComingEventsBinding3;
        if (dialogCreateComingEventsBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding4 = null;
        }
        String obj2 = StringsKt.b((CharSequence) dialogCreateComingEventsBinding4.s.getText().toString()).toString();
        YYRoomModel yYRoomModel = this.h;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        String str2 = this.g;
        int i = this.f;
        long j = this.d;
        long j2 = 1000;
        String valueOf = String.valueOf(i);
        String valueOf2 = String.valueOf(j / j2);
        String valueOf3 = String.valueOf(this.e / j2);
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.a(str, obj, str2, obj2, valueOf, valueOf2, valueOf3, new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYCreateComingEventsDialog$createThemeEvent$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYCreateComingEventsDialog.this.dismissAllowingStateLoss();
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(YYCreateComingEventsDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(3);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_CREATE_PRE_DONE_CLICK;
        YYRoomModel yYRoomModel = this.h;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.h;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.d(event, str2, str);
        f();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = null;
        DialogCreateComingEventsBinding a2 = DialogCreateComingEventsBinding.a(LayoutInflater.from(getContext()).inflate(R.layout.dialog_create_coming_events, (ViewGroup) null));
        Intrinsics.c(a2, "bind(view)");
        this.f17174a = a2;
        this.h = YYRoomInfoManager.e().b();
        g();
        h();
        i();
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = this.f17174a;
        if (dialogCreateComingEventsBinding2 == null) {
            Intrinsics.c("mBinding");
        } else {
            dialogCreateComingEventsBinding = dialogCreateComingEventsBinding2;
        }
        return dialogCreateComingEventsBinding.getRoot();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding2 = dialogCreateComingEventsBinding;
        if (dialogCreateComingEventsBinding == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding2 = null;
        }
        dialogCreateComingEventsBinding2.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$VCsT9pNu3l75mvoD4xNo-kD-fyQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.a(YYCreateComingEventsDialog.this, view2);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding3 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding4 = dialogCreateComingEventsBinding3;
        if (dialogCreateComingEventsBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding4 = null;
        }
        dialogCreateComingEventsBinding4.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$jIvhBOTPxNkxrL_VxUHuAadTfus
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.b(YYCreateComingEventsDialog.this, view2);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding5 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding6 = dialogCreateComingEventsBinding5;
        if (dialogCreateComingEventsBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding6 = null;
        }
        dialogCreateComingEventsBinding6.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$FsQuk7MdGTp07gkyoxDHPmYxDgM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.c(YYCreateComingEventsDialog.this, view2);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding7 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding8 = dialogCreateComingEventsBinding7;
        if (dialogCreateComingEventsBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding8 = null;
        }
        dialogCreateComingEventsBinding8.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$EjAHXDC5HyIfvpu5KDJNHyieya0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.d(YYCreateComingEventsDialog.this, view2);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding9 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding10 = dialogCreateComingEventsBinding9;
        if (dialogCreateComingEventsBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding10 = null;
        }
        dialogCreateComingEventsBinding10.v.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$DuMma1fQew6n4u-ysqrQ5fZBBkE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.e(YYCreateComingEventsDialog.this, view2);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding11 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding12 = dialogCreateComingEventsBinding11;
        if (dialogCreateComingEventsBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding12 = null;
        }
        dialogCreateComingEventsBinding12.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$Vi5wsZ0BFoNhHmtydajrY2VeCrw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.f(YYCreateComingEventsDialog.this, view2);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding13 = this.f17174a;
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding14 = dialogCreateComingEventsBinding13;
        if (dialogCreateComingEventsBinding13 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding14 = null;
        }
        dialogCreateComingEventsBinding14.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$eqSUIsR7ArYv1sXHntpwQH8A3rA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.g(YYCreateComingEventsDialog.this, view2);
            }
        });
        DialogCreateComingEventsBinding dialogCreateComingEventsBinding15 = this.f17174a;
        if (dialogCreateComingEventsBinding15 == null) {
            Intrinsics.c("mBinding");
            dialogCreateComingEventsBinding15 = null;
        }
        dialogCreateComingEventsBinding15.f16323c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCreateComingEventsDialog$uvznLar7mypRDVcyBQQkVr8YjYk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCreateComingEventsDialog.h(YYCreateComingEventsDialog.this, view2);
            }
        });
    }
}
