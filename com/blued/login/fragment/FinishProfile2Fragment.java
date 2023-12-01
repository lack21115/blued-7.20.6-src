package com.blued.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.databinding.FmFinishProfile2Binding;
import com.blued.login.log.EventTrackLogin;
import com.blued.login.model.ProfileInfoModel;
import com.blued.login.utils.LoginHelper;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.simonvt.datepicker.DatePicker;
import net.simonvt.numberpicker.NumberPicker;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/FinishProfile2Fragment.class */
public final class FinishProfile2Fragment extends MVVMBaseFragment<EmptyViewModel> implements DatePicker.OnDateChangedListener {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20545c;
    private ProfileInfoModel d;
    private String[] e;
    private NumberPicker f;
    private NumberPicker g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(FinishProfile2Fragment.class, "vb", "getVb()Lcom/blued/login/databinding/FmFinishProfile2Binding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20544a = new Companion(null);

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/FinishProfile2Fragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FinishProfile2Fragment() {
        super(R.layout.fm_finish_profile_2);
        this.f20545c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<FinishProfile2Fragment, FmFinishProfile2Binding>() { // from class: com.blued.login.fragment.FinishProfile2Fragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmFinishProfile2Binding invoke(FinishProfile2Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmFinishProfile2Binding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<FinishProfile2Fragment, FmFinishProfile2Binding>() { // from class: com.blued.login.fragment.FinishProfile2Fragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmFinishProfile2Binding invoke(FinishProfile2Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmFinishProfile2Binding.a(fragment.requireView());
            }
        });
        this.h = "";
        this.j = 170;
        this.k = 60;
        this.l = 120;
        this.m = 220;
        this.n = 30;
        this.o = 200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FinishProfile2Fragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FinishProfile2Fragment this$0, NumberPicker numberPicker, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        this$0.h = i2 + "";
        int c2 = CommonPreferences.c();
        if (c2 == 1) {
            this$0.h = i2 + "";
        } else if (c2 == 2) {
            String[] strArr = this$0.e;
            String[] strArr2 = strArr;
            if (strArr == null) {
                Intrinsics.c("heightList");
                strArr2 = null;
            }
            this$0.h = strArr2[i2];
        }
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FinishProfile2Fragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (CommonPreferences.c() == 2) {
            ProfileInfoModel profileInfoModel = this$0.d;
            ProfileInfoModel profileInfoModel2 = profileInfoModel;
            if (profileInfoModel == null) {
                Intrinsics.c("model");
                profileInfoModel2 = null;
            }
            String a2 = LoginServiceManager.a().a(this$0.h);
            Intrinsics.c(a2, "getLoginService().getHeightCM(height)");
            profileInfoModel2.d(a2);
            ProfileInfoModel profileInfoModel3 = this$0.d;
            ProfileInfoModel profileInfoModel4 = profileInfoModel3;
            if (profileInfoModel3 == null) {
                Intrinsics.c("model");
                profileInfoModel4 = null;
            }
            String b2 = LoginServiceManager.a().b(String.valueOf(this$0.i));
            Intrinsics.c(b2, "getLoginService().getWeightKG(weight.toString())");
            profileInfoModel4.e(b2);
        } else {
            ProfileInfoModel profileInfoModel5 = this$0.d;
            ProfileInfoModel profileInfoModel6 = profileInfoModel5;
            if (profileInfoModel5 == null) {
                Intrinsics.c("model");
                profileInfoModel6 = null;
            }
            profileInfoModel6.d(this$0.h);
            ProfileInfoModel profileInfoModel7 = this$0.d;
            ProfileInfoModel profileInfoModel8 = profileInfoModel7;
            if (profileInfoModel7 == null) {
                Intrinsics.c("model");
                profileInfoModel8 = null;
            }
            profileInfoModel8.e(String.valueOf(this$0.i));
        }
        Context context = this$0.getContext();
        Bundle bundle = new Bundle();
        ProfileInfoModel profileInfoModel9 = this$0.d;
        if (profileInfoModel9 == null) {
            Intrinsics.c("model");
            profileInfoModel9 = null;
        }
        bundle.putSerializable("profile_model", profileInfoModel9);
        Unit unit = Unit.f42314a;
        TerminalActivity.d(context, FinishProfile3Fragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FinishProfile2Fragment this$0, NumberPicker numberPicker, int i, int i2) {
        Intrinsics.e(this$0, "this$0");
        this$0.i = i2;
        this$0.s();
    }

    private final FmFinishProfile2Binding p() {
        return (FmFinishProfile2Binding) this.f20545c.b(this, b[0]);
    }

    private final void q() {
        String[] stringArray = getResources().getStringArray(R.array.inch_height_list);
        Intrinsics.c(stringArray, "resources.getStringArray(R.array.inch_height_list)");
        this.e = stringArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void r() {
        /*
            Method dump skipped, instructions count: 1492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.login.fragment.FinishProfile2Fragment.r():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        if ((r0 == null || r0.length() == 0) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void s() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.login.fragment.FinishProfile2Fragment.s():void");
    }

    @Override // net.simonvt.datepicker.DatePicker.OnDateChangedListener
    public void a(DatePicker datePicker, int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('-');
        int i4 = i2 + 1;
        sb.append(i4);
        sb.append('-');
        sb.append(i3);
        int a2 = TimeAndDateUtils.a(TimeAndDateUtils.c(sb.toString(), "yyyy-MM-dd"));
        if (a2 < 18) {
            AppMethods.d(R.string.age_low);
        } else if (a2 > 80) {
            AppMethods.d(R.string.age_high);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append('/');
            sb2.append(i4);
            sb2.append('/');
            sb2.append(i3);
            String sb3 = sb2.toString();
            ProfileInfoModel profileInfoModel = this.d;
            ProfileInfoModel profileInfoModel2 = profileInfoModel;
            if (profileInfoModel == null) {
                Intrinsics.c("model");
                profileInfoModel2 = null;
            }
            String b2 = TimeAndDateUtils.b(sb3, "yyyy/MM/dd");
            Intrinsics.c(b2, "date2TimeStamp(date, \"yyyy/MM/dd\")");
            profileInfoModel2.c(b2);
            Calendar calendar = Calendar.getInstance();
            ProfileInfoModel profileInfoModel3 = this.d;
            ProfileInfoModel profileInfoModel4 = profileInfoModel3;
            if (profileInfoModel3 == null) {
                Intrinsics.c("model");
                profileInfoModel4 = null;
            }
            calendar.setTime(new Date(Long.parseLong(profileInfoModel4.c())));
            FmFinishProfile2Binding p = p();
            TextView textView = p == null ? null : p.f;
            if (textView == null) {
                return;
            }
            textView.setText(sb3 + ' ' + LoginHelper.f20590a.a(i2, i3));
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        ShapeTextView shapeTextView;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        ImageView leftImg;
        DatePicker datePicker;
        DatePicker datePicker2;
        DatePicker datePicker3;
        q();
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("profile_model")) {
            Serializable serializable = arguments.getSerializable("profile_model");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.login.model.ProfileInfoModel");
            }
            this.d = (ProfileInfoModel) serializable;
            LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.REGISTER_PROFILE_BIRTHDAY_SHOW;
            LoginHelper loginHelper = LoginHelper.f20590a;
            ProfileInfoModel profileInfoModel = this.d;
            ProfileInfoModel profileInfoModel2 = profileInfoModel;
            if (profileInfoModel == null) {
                Intrinsics.c("model");
                profileInfoModel2 = null;
            }
            EventTrackLogin.a(event, loginHelper.a(profileInfoModel2));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -18);
        calendar.add(5, -1);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        FmFinishProfile2Binding p = p();
        DatePicker datePicker4 = p == null ? null : p.f20513a;
        if (datePicker4 != null) {
            datePicker4.setSpinnersShown(true);
        }
        FmFinishProfile2Binding p2 = p();
        DatePicker datePicker5 = p2 == null ? null : p2.f20513a;
        if (datePicker5 != null) {
            datePicker5.setCalendarViewShown(false);
        }
        FmFinishProfile2Binding p3 = p();
        if (p3 != null && (datePicker3 = p3.f20513a) != null) {
            datePicker3.a(i, i2, i3, this);
        }
        FmFinishProfile2Binding p4 = p();
        DatePicker datePicker6 = p4 == null ? null : p4.f20513a;
        if (datePicker6 != null) {
            datePicker6.setMaxDate(calendar.getTimeInMillis());
        }
        FmFinishProfile2Binding p5 = p();
        if (p5 != null && (datePicker2 = p5.f20513a) != null) {
            datePicker2.setWheelTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        }
        FmFinishProfile2Binding p6 = p();
        if (p6 != null && (datePicker = p6.f20513a) != null) {
            datePicker.setInputTextEnable(false);
        }
        View view = getView();
        if (view != null) {
            View findViewById = view.findViewById(R.id.heightPicker);
            Intrinsics.c(findViewById, "it.findViewById(R.id.heightPicker)");
            this.f = (NumberPicker) findViewById;
            View findViewById2 = view.findViewById(R.id.weightPicker);
            Intrinsics.c(findViewById2, "it.findViewById(R.id.weightPicker)");
            this.g = (NumberPicker) findViewById2;
            NumberPicker numberPicker = this.f;
            NumberPicker numberPicker2 = numberPicker;
            if (numberPicker == null) {
                Intrinsics.c("heightPicker");
                numberPicker2 = null;
            }
            numberPicker2.setWheelTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
            NumberPicker numberPicker3 = this.g;
            NumberPicker numberPicker4 = numberPicker3;
            if (numberPicker3 == null) {
                Intrinsics.c("weightPicker");
                numberPicker4 = null;
            }
            numberPicker4.setWheelTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
            NumberPicker numberPicker5 = this.f;
            NumberPicker numberPicker6 = numberPicker5;
            if (numberPicker5 == null) {
                Intrinsics.c("heightPicker");
                numberPicker6 = null;
            }
            numberPicker6.setInputTextEnable(false);
            NumberPicker numberPicker7 = this.g;
            NumberPicker numberPicker8 = numberPicker7;
            if (numberPicker7 == null) {
                Intrinsics.c("weightPicker");
                numberPicker8 = null;
            }
            numberPicker8.setInputTextEnable(false);
        }
        FmFinishProfile2Binding p7 = p();
        if (p7 != null && (commonTopTitleNoTrans = p7.e) != null && (leftImg = commonTopTitleNoTrans.getLeftImg()) != null) {
            leftImg.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile2Fragment$PFoJkWTmTKFEd3d5vuTCUjdjly8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FinishProfile2Fragment.a(FinishProfile2Fragment.this, view2);
                }
            });
        }
        FmFinishProfile2Binding p8 = p();
        a(p8 == null ? null : p8.f20513a, i, i2, i3);
        r();
        FmFinishProfile2Binding p9 = p();
        if (p9 == null || (shapeTextView = p9.h) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$FinishProfile2Fragment$FhAXOqEpvNBdx1JwLjRjNOKNcS4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FinishProfile2Fragment.b(FinishProfile2Fragment.this, view2);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }
}
