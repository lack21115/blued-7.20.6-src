package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogFeedStyleBinding;
import com.blued.android.module.yy_china.model.YYEventsThemeModel;
import com.blued.android.module.yy_china.model.YYShareAchievementModel;
import com.blued.android.module.yy_china.model.YYThemeActivityInfo;
import com.blued.android.module.yy_china.model.YYThemeEventEndInfo;
import com.blued.android.module.yy_china.model.YYThemeRankList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPostFeedStyleDialog.class */
public final class YYPostFeedStyleDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogFeedStyleBinding f17388a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f17389c;
    private int d;
    private YYThemeEventEndInfo e;

    private final void a(int i) {
        this.d = i;
        if (i == 0) {
            g();
            DialogFeedStyleBinding dialogFeedStyleBinding = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding2 = dialogFeedStyleBinding;
            if (dialogFeedStyleBinding == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding2 = null;
            }
            ShapeConstraintLayout shapeConstraintLayout = dialogFeedStyleBinding2.p;
            Intrinsics.c(shapeConstraintLayout, "mBinding.llPostAll");
            ShapeConstraintLayout shapeConstraintLayout2 = shapeConstraintLayout;
            DialogFeedStyleBinding dialogFeedStyleBinding3 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding4 = dialogFeedStyleBinding3;
            if (dialogFeedStyleBinding3 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding4 = null;
            }
            ImageView imageView = dialogFeedStyleBinding4.l;
            Intrinsics.c(imageView, "mBinding.imgBtnAll");
            a(true, shapeConstraintLayout2, imageView);
            DialogFeedStyleBinding dialogFeedStyleBinding5 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding6 = dialogFeedStyleBinding5;
            if (dialogFeedStyleBinding5 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding6 = null;
            }
            ConstraintLayout constraintLayout = dialogFeedStyleBinding6.q;
            Intrinsics.c(constraintLayout, "mBinding.llPostData");
            ConstraintLayout constraintLayout2 = constraintLayout;
            DialogFeedStyleBinding dialogFeedStyleBinding7 = this.f17388a;
            if (dialogFeedStyleBinding7 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding7 = null;
            }
            ImageView imageView2 = dialogFeedStyleBinding7.m;
            Intrinsics.c(imageView2, "mBinding.imgBtnData");
            a(false, constraintLayout2, imageView2);
            a(false);
        } else if (i == 1) {
            g();
            DialogFeedStyleBinding dialogFeedStyleBinding8 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding9 = dialogFeedStyleBinding8;
            if (dialogFeedStyleBinding8 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding9 = null;
            }
            ShapeConstraintLayout shapeConstraintLayout3 = dialogFeedStyleBinding9.p;
            Intrinsics.c(shapeConstraintLayout3, "mBinding.llPostAll");
            ShapeConstraintLayout shapeConstraintLayout4 = shapeConstraintLayout3;
            DialogFeedStyleBinding dialogFeedStyleBinding10 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding11 = dialogFeedStyleBinding10;
            if (dialogFeedStyleBinding10 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding11 = null;
            }
            ImageView imageView3 = dialogFeedStyleBinding11.l;
            Intrinsics.c(imageView3, "mBinding.imgBtnAll");
            a(false, shapeConstraintLayout4, imageView3);
            DialogFeedStyleBinding dialogFeedStyleBinding12 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding13 = dialogFeedStyleBinding12;
            if (dialogFeedStyleBinding12 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding13 = null;
            }
            ConstraintLayout constraintLayout3 = dialogFeedStyleBinding13.q;
            Intrinsics.c(constraintLayout3, "mBinding.llPostData");
            ConstraintLayout constraintLayout4 = constraintLayout3;
            DialogFeedStyleBinding dialogFeedStyleBinding14 = this.f17388a;
            if (dialogFeedStyleBinding14 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding14 = null;
            }
            ImageView imageView4 = dialogFeedStyleBinding14.m;
            Intrinsics.c(imageView4, "mBinding.imgBtnData");
            a(true, constraintLayout4, imageView4);
            a(false);
        } else if (i != 2) {
        } else {
            a(true);
            DialogFeedStyleBinding dialogFeedStyleBinding15 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding16 = dialogFeedStyleBinding15;
            if (dialogFeedStyleBinding15 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding16 = null;
            }
            ShapeConstraintLayout shapeConstraintLayout5 = dialogFeedStyleBinding16.p;
            Intrinsics.c(shapeConstraintLayout5, "mBinding.llPostAll");
            ShapeConstraintLayout shapeConstraintLayout6 = shapeConstraintLayout5;
            DialogFeedStyleBinding dialogFeedStyleBinding17 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding18 = dialogFeedStyleBinding17;
            if (dialogFeedStyleBinding17 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding18 = null;
            }
            ImageView imageView5 = dialogFeedStyleBinding18.l;
            Intrinsics.c(imageView5, "mBinding.imgBtnAll");
            a(false, shapeConstraintLayout6, imageView5);
            DialogFeedStyleBinding dialogFeedStyleBinding19 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding20 = dialogFeedStyleBinding19;
            if (dialogFeedStyleBinding19 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding20 = null;
            }
            ConstraintLayout constraintLayout5 = dialogFeedStyleBinding20.q;
            Intrinsics.c(constraintLayout5, "mBinding.llPostData");
            ConstraintLayout constraintLayout6 = constraintLayout5;
            DialogFeedStyleBinding dialogFeedStyleBinding21 = this.f17388a;
            if (dialogFeedStyleBinding21 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding21 = null;
            }
            ImageView imageView6 = dialogFeedStyleBinding21.m;
            Intrinsics.c(imageView6, "mBinding.imgBtnData");
            a(false, constraintLayout6, imageView6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPostFeedStyleDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void a(YYThemeEventEndInfo yYThemeEventEndInfo, HashMap<Integer, YYShareAchievementModel> hashMap) {
        if (!TextUtils.isEmpty(yYThemeEventEndInfo.getDuration_time())) {
            YYShareAchievementModel yYShareAchievementModel = new YYShareAchievementModel("开播时长", yYThemeEventEndInfo.getDuration_time(), "", false);
            HashMap<Integer, YYShareAchievementModel> hashMap2 = hashMap;
            DialogFeedStyleBinding dialogFeedStyleBinding = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding2 = dialogFeedStyleBinding;
            if (dialogFeedStyleBinding == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding2 = null;
            }
            hashMap2.put(Integer.valueOf(dialogFeedStyleBinding2.i.getId()), yYShareAchievementModel);
        }
        if (!TextUtils.isEmpty(yYThemeEventEndInfo.getSend_users_count())) {
            YYShareAchievementModel yYShareAchievementModel2 = new YYShareAchievementModel("祝福人数", yYThemeEventEndInfo.getSend_users_count(), "", false);
            HashMap<Integer, YYShareAchievementModel> hashMap3 = hashMap;
            DialogFeedStyleBinding dialogFeedStyleBinding3 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding4 = dialogFeedStyleBinding3;
            if (dialogFeedStyleBinding3 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding4 = null;
            }
            hashMap3.put(Integer.valueOf(dialogFeedStyleBinding4.j.getId()), yYShareAchievementModel2);
        }
        if (!TextUtils.isEmpty(yYThemeEventEndInfo.getUsers_count())) {
            YYShareAchievementModel yYShareAchievementModel3 = new YYShareAchievementModel("观看人数", yYThemeEventEndInfo.getUsers_count(), "", false);
            HashMap<Integer, YYShareAchievementModel> hashMap4 = hashMap;
            DialogFeedStyleBinding dialogFeedStyleBinding5 = this.f17388a;
            DialogFeedStyleBinding dialogFeedStyleBinding6 = dialogFeedStyleBinding5;
            if (dialogFeedStyleBinding5 == null) {
                Intrinsics.c("mBinding");
                dialogFeedStyleBinding6 = null;
            }
            hashMap4.put(Integer.valueOf(dialogFeedStyleBinding6.g.getId()), yYShareAchievementModel3);
        }
        if (TextUtils.isEmpty(yYThemeEventEndInfo.getValue())) {
            return;
        }
        YYShareAchievementModel yYShareAchievementModel4 = new YYShareAchievementModel("庆典值", yYThemeEventEndInfo.getValue(), "", false);
        HashMap<Integer, YYShareAchievementModel> hashMap5 = hashMap;
        DialogFeedStyleBinding dialogFeedStyleBinding7 = this.f17388a;
        if (dialogFeedStyleBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding7 = null;
        }
        hashMap5.put(Integer.valueOf(dialogFeedStyleBinding7.h.getId()), yYShareAchievementModel4);
    }

    private final void a(ArrayList<YYShareAchievementModel> arrayList, HashMap<Integer, YYShareAchievementModel> hashMap) {
        for (Map.Entry<Integer, YYShareAchievementModel> entry : hashMap.entrySet()) {
            YYShareAchievementModel value = entry.getValue();
            if (value != null) {
                arrayList.add(value);
            }
        }
    }

    private final void a(boolean z) {
        DialogFeedStyleBinding dialogFeedStyleBinding = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding2 = dialogFeedStyleBinding;
        if (dialogFeedStyleBinding == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding2 = null;
        }
        ConstraintLayout constraintLayout = dialogFeedStyleBinding2.e;
        Intrinsics.c(constraintLayout, "mBinding.btnPostText");
        ConstraintLayout constraintLayout2 = constraintLayout;
        DialogFeedStyleBinding dialogFeedStyleBinding3 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding4 = dialogFeedStyleBinding3;
        if (dialogFeedStyleBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding4 = null;
        }
        ImageView imageView = dialogFeedStyleBinding4.n;
        Intrinsics.c(imageView, "mBinding.imgBtnText");
        a(z, constraintLayout2, imageView);
        DialogFeedStyleBinding dialogFeedStyleBinding5 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding6 = dialogFeedStyleBinding5;
        if (dialogFeedStyleBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding6 = null;
        }
        ConstraintLayout constraintLayout3 = dialogFeedStyleBinding6.e;
        int i = this.b;
        constraintLayout3.setPadding(0, i, 0, z ? this.f17389c : i);
        DialogFeedStyleBinding dialogFeedStyleBinding7 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding8 = dialogFeedStyleBinding7;
        if (dialogFeedStyleBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding8 = null;
        }
        dialogFeedStyleBinding8.o.setVisibility(z ? 0 : 8);
        DialogFeedStyleBinding dialogFeedStyleBinding9 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding10 = dialogFeedStyleBinding9;
        if (dialogFeedStyleBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding10 = null;
        }
        dialogFeedStyleBinding10.r.setVisibility(z ? 0 : 8);
        DialogFeedStyleBinding dialogFeedStyleBinding11 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding12 = dialogFeedStyleBinding11;
        if (dialogFeedStyleBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding12 = null;
        }
        dialogFeedStyleBinding12.g.setVisibility(z ? 0 : 8);
        DialogFeedStyleBinding dialogFeedStyleBinding13 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding14 = dialogFeedStyleBinding13;
        if (dialogFeedStyleBinding13 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding14 = null;
        }
        dialogFeedStyleBinding14.h.setVisibility(z ? 0 : 8);
        DialogFeedStyleBinding dialogFeedStyleBinding15 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding16 = dialogFeedStyleBinding15;
        if (dialogFeedStyleBinding15 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding16 = null;
        }
        dialogFeedStyleBinding16.i.setVisibility(z ? 0 : 8);
        DialogFeedStyleBinding dialogFeedStyleBinding17 = this.f17388a;
        if (dialogFeedStyleBinding17 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding17 = null;
        }
        dialogFeedStyleBinding17.j.setVisibility(z ? 0 : 8);
    }

    private final void a(boolean z, View view, ImageView imageView) {
        view.setBackgroundResource(z ? R.drawable.shape_stroke_8_0bccbc : R.drawable.shape_stroke_8_ededed);
        imageView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPostFeedStyleDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYPostFeedStyleDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYPostFeedStyleDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYPostFeedStyleDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(1);
    }

    private final void f() {
        boolean z;
        YYThemeEventEndInfo yYThemeEventEndInfo;
        ArrayList<YYShareAchievementModel> arrayList = new ArrayList<>();
        HashMap<Integer, YYShareAchievementModel> hashMap = new HashMap<>();
        YYThemeEventEndInfo yYThemeEventEndInfo2 = this.e;
        YYEventsThemeModel yYEventsThemeModel = null;
        if (yYThemeEventEndInfo2 == null) {
            z = true;
        } else {
            a(yYThemeEventEndInfo2, hashMap);
            int i = this.d;
            if (i == 0) {
                a(arrayList, hashMap);
                z = true;
            } else if (i == 1) {
                a(arrayList, hashMap);
                z = false;
            } else if (i == 2) {
                ArrayList arrayList2 = new ArrayList();
                DialogFeedStyleBinding dialogFeedStyleBinding = this.f17388a;
                DialogFeedStyleBinding dialogFeedStyleBinding2 = dialogFeedStyleBinding;
                if (dialogFeedStyleBinding == null) {
                    Intrinsics.c("mBinding");
                    dialogFeedStyleBinding2 = null;
                }
                if (dialogFeedStyleBinding2.i.isChecked()) {
                    DialogFeedStyleBinding dialogFeedStyleBinding3 = this.f17388a;
                    DialogFeedStyleBinding dialogFeedStyleBinding4 = dialogFeedStyleBinding3;
                    if (dialogFeedStyleBinding3 == null) {
                        Intrinsics.c("mBinding");
                        dialogFeedStyleBinding4 = null;
                    }
                    arrayList2.add(Integer.valueOf(dialogFeedStyleBinding4.i.getId()));
                }
                DialogFeedStyleBinding dialogFeedStyleBinding5 = this.f17388a;
                DialogFeedStyleBinding dialogFeedStyleBinding6 = dialogFeedStyleBinding5;
                if (dialogFeedStyleBinding5 == null) {
                    Intrinsics.c("mBinding");
                    dialogFeedStyleBinding6 = null;
                }
                if (dialogFeedStyleBinding6.j.isChecked()) {
                    DialogFeedStyleBinding dialogFeedStyleBinding7 = this.f17388a;
                    DialogFeedStyleBinding dialogFeedStyleBinding8 = dialogFeedStyleBinding7;
                    if (dialogFeedStyleBinding7 == null) {
                        Intrinsics.c("mBinding");
                        dialogFeedStyleBinding8 = null;
                    }
                    arrayList2.add(Integer.valueOf(dialogFeedStyleBinding8.j.getId()));
                }
                DialogFeedStyleBinding dialogFeedStyleBinding9 = this.f17388a;
                DialogFeedStyleBinding dialogFeedStyleBinding10 = dialogFeedStyleBinding9;
                if (dialogFeedStyleBinding9 == null) {
                    Intrinsics.c("mBinding");
                    dialogFeedStyleBinding10 = null;
                }
                if (dialogFeedStyleBinding10.g.isChecked()) {
                    DialogFeedStyleBinding dialogFeedStyleBinding11 = this.f17388a;
                    DialogFeedStyleBinding dialogFeedStyleBinding12 = dialogFeedStyleBinding11;
                    if (dialogFeedStyleBinding11 == null) {
                        Intrinsics.c("mBinding");
                        dialogFeedStyleBinding12 = null;
                    }
                    arrayList2.add(Integer.valueOf(dialogFeedStyleBinding12.g.getId()));
                }
                DialogFeedStyleBinding dialogFeedStyleBinding13 = this.f17388a;
                DialogFeedStyleBinding dialogFeedStyleBinding14 = dialogFeedStyleBinding13;
                if (dialogFeedStyleBinding13 == null) {
                    Intrinsics.c("mBinding");
                    dialogFeedStyleBinding14 = null;
                }
                if (dialogFeedStyleBinding14.h.isChecked()) {
                    DialogFeedStyleBinding dialogFeedStyleBinding15 = this.f17388a;
                    DialogFeedStyleBinding dialogFeedStyleBinding16 = dialogFeedStyleBinding15;
                    if (dialogFeedStyleBinding15 == null) {
                        Intrinsics.c("mBinding");
                        dialogFeedStyleBinding16 = null;
                    }
                    arrayList2.add(Integer.valueOf(dialogFeedStyleBinding16.h.getId()));
                }
                if (!arrayList2.isEmpty()) {
                    Iterator<Map.Entry<Integer, YYShareAchievementModel>> it = hashMap.entrySet().iterator();
                    while (true) {
                        z = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<Integer, YYShareAchievementModel> next = it.next();
                        int intValue = next.getKey().intValue();
                        YYShareAchievementModel value = next.getValue();
                        if (!arrayList2.contains(Integer.valueOf(intValue))) {
                            arrayList.add(value);
                        }
                    }
                } else {
                    ToastUtils.a("请选择隐藏字段");
                    return;
                }
            } else {
                z = true;
            }
        }
        YYPreviewPosterDialog yYPreviewPosterDialog = new YYPreviewPosterDialog();
        ArrayList<YYShareAchievementModel> arrayList3 = arrayList;
        YYThemeEventEndInfo yYThemeEventEndInfo3 = this.e;
        YYThemeActivityInfo activity_info = yYThemeEventEndInfo3 == null ? null : yYThemeEventEndInfo3.getActivity_info();
        List<YYThemeRankList> rank_list = (!z || (yYThemeEventEndInfo = this.e) == null) ? null : yYThemeEventEndInfo.getRank_list();
        YYThemeEventEndInfo yYThemeEventEndInfo4 = this.e;
        if (yYThemeEventEndInfo4 != null) {
            yYEventsThemeModel = yYThemeEventEndInfo4.getSkin();
        }
        yYPreviewPosterDialog.a(arrayList3, activity_info, rank_list, yYEventsThemeModel);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYPreviewPosterDialog.show(childFragmentManager, "preview_poster_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(YYPostFeedStyleDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(2);
    }

    private final void g() {
        DialogFeedStyleBinding dialogFeedStyleBinding = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding2 = dialogFeedStyleBinding;
        if (dialogFeedStyleBinding == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding2 = null;
        }
        dialogFeedStyleBinding2.i.setChecked(false);
        DialogFeedStyleBinding dialogFeedStyleBinding3 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding4 = dialogFeedStyleBinding3;
        if (dialogFeedStyleBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding4 = null;
        }
        dialogFeedStyleBinding4.j.setChecked(false);
        DialogFeedStyleBinding dialogFeedStyleBinding5 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding6 = dialogFeedStyleBinding5;
        if (dialogFeedStyleBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding6 = null;
        }
        dialogFeedStyleBinding6.g.setChecked(false);
        DialogFeedStyleBinding dialogFeedStyleBinding7 = this.f17388a;
        if (dialogFeedStyleBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding7 = null;
        }
        dialogFeedStyleBinding7.h.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(YYPostFeedStyleDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    public final void a(YYThemeEventEndInfo yYThemeEventEndInfo) {
        this.e = yYThemeEventEndInfo;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_feed_style, (ViewGroup) null);
        DialogFeedStyleBinding a2 = DialogFeedStyleBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.f17388a = a2;
        this.b = DensityUtils.a(getContext(), 19.0f);
        this.f17389c = DensityUtils.a(getContext(), 34.0f);
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogFeedStyleBinding dialogFeedStyleBinding = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding2 = dialogFeedStyleBinding;
        if (dialogFeedStyleBinding == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding2 = null;
        }
        dialogFeedStyleBinding2.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPostFeedStyleDialog$IdUr8cZEHWXvKIIqNngPGCQN9ks
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPostFeedStyleDialog.a(YYPostFeedStyleDialog.this, view2);
            }
        });
        DialogFeedStyleBinding dialogFeedStyleBinding3 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding4 = dialogFeedStyleBinding3;
        if (dialogFeedStyleBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding4 = null;
        }
        dialogFeedStyleBinding4.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPostFeedStyleDialog$XUBwXKH-1NQP-FPBRotrZlt4NPk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPostFeedStyleDialog.b(YYPostFeedStyleDialog.this, view2);
            }
        });
        DialogFeedStyleBinding dialogFeedStyleBinding5 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding6 = dialogFeedStyleBinding5;
        if (dialogFeedStyleBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding6 = null;
        }
        dialogFeedStyleBinding6.f16336a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPostFeedStyleDialog$1atxa6kurwQj9kYTmCs-cZE6DKg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPostFeedStyleDialog.c(YYPostFeedStyleDialog.this, view2);
            }
        });
        DialogFeedStyleBinding dialogFeedStyleBinding7 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding8 = dialogFeedStyleBinding7;
        if (dialogFeedStyleBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding8 = null;
        }
        dialogFeedStyleBinding8.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPostFeedStyleDialog$0JCaHcVQ1NiMk9nS5G--GQjktII
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPostFeedStyleDialog.d(YYPostFeedStyleDialog.this, view2);
            }
        });
        DialogFeedStyleBinding dialogFeedStyleBinding9 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding10 = dialogFeedStyleBinding9;
        if (dialogFeedStyleBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding10 = null;
        }
        dialogFeedStyleBinding10.q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPostFeedStyleDialog$Q51I9r1pKt_1R0awxs9dsi8WaSs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPostFeedStyleDialog.e(YYPostFeedStyleDialog.this, view2);
            }
        });
        DialogFeedStyleBinding dialogFeedStyleBinding11 = this.f17388a;
        DialogFeedStyleBinding dialogFeedStyleBinding12 = dialogFeedStyleBinding11;
        if (dialogFeedStyleBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding12 = null;
        }
        dialogFeedStyleBinding12.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPostFeedStyleDialog$qykRpY1SCwAEhFhvzcDmZHAiOnY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPostFeedStyleDialog.f(YYPostFeedStyleDialog.this, view2);
            }
        });
        DialogFeedStyleBinding dialogFeedStyleBinding13 = this.f17388a;
        if (dialogFeedStyleBinding13 == null) {
            Intrinsics.c("mBinding");
            dialogFeedStyleBinding13 = null;
        }
        dialogFeedStyleBinding13.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPostFeedStyleDialog$-0yfK6r9ThKcs9UMue_qnWj89B8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPostFeedStyleDialog.g(YYPostFeedStyleDialog.this, view2);
            }
        });
        a(0);
    }
}
