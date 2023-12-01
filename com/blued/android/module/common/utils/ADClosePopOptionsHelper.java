package com.blued.android.module.common.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ADClosePopOptionsHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ADClosePopOptionsHelper.class */
public class ADClosePopOptionsHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.common.utils.ADClosePopOptionsHelper$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ADClosePopOptionsHelper$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10861a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ADConstants.AD_POSITION.values().length];
            f10861a = iArr;
            try {
                iArr[ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10861a[ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10861a[ADConstants.AD_POSITION.NEARBY_HOME_ORIGIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ADClosePopOptionsHelper$ADOptionsListener.class */
    public interface ADOptionsListener {
        void a();

        void b();

        void c();

        void d();

        int e();
    }

    public static void a(Context context, final BluedADExtra bluedADExtra, View view, ADConstants.AD_POSITION ad_position, final ADOptionsListener aDOptionsListener) {
        if (a(bluedADExtra, aDOptionsListener)) {
            if (aDOptionsListener != null) {
                aDOptionsListener.a();
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_ad_filter_pop, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_option_1);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_option_2);
            ShapeHelper.b((ShapeTextView) inflate.findViewById(R.id.tv_bg), R.color.syc_x);
            final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
            popupWindow.setTouchable(true);
            popupWindow.setBackgroundDrawable(context.getResources().getDrawable(17170445));
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.utils.-$$Lambda$ADClosePopOptionsHelper$3P5WMJ-GZVVWr_-qulcStMrsmEA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ADClosePopOptionsHelper.b(ADClosePopOptionsHelper.ADOptionsListener.this, bluedADExtra, popupWindow, view2);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.utils.-$$Lambda$ADClosePopOptionsHelper$muw2xvVc8uX-fMRrQsFKVx1La0A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ADClosePopOptionsHelper.a(ADClosePopOptionsHelper.ADOptionsListener.this, bluedADExtra, popupWindow, view2);
                }
            });
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int a2 = DensityUtils.a(context, 100.0f);
            int i = AnonymousClass1.f10861a[ad_position.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                a2 += DensityUtils.a(context, 70.0f);
            }
            int i2 = AppInfo.m;
            int i3 = AppInfo.l;
            int i4 = iArr[0];
            popupWindow.showAtLocation(view, 53, (i3 - i4) - view.getWidth(), iArr[1] <= i2 - a2 ? iArr[1] + view.getHeight() : iArr[1] - DensityUtils.a(context, 80.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ADOptionsListener aDOptionsListener, BluedADExtra bluedADExtra, PopupWindow popupWindow, View view) {
        if (aDOptionsListener != null) {
            aDOptionsListener.c();
            aDOptionsListener.d();
            CommonHttpUtils.a(bluedADExtra.hidden_url);
        }
        popupWindow.dismiss();
    }

    private static boolean a(BluedADExtra bluedADExtra, ADOptionsListener aDOptionsListener) {
        if (bluedADExtra == null || bluedADExtra.is_show_adm_icon != 1 || UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) {
            if (aDOptionsListener != null) {
                aDOptionsListener.d();
                CommonHttpUtils.a(bluedADExtra.hidden_url);
                return false;
            }
            return false;
        }
        int e = aDOptionsListener.e();
        if (e != 1) {
            if (e == 2) {
                return true;
            }
        } else if (!CommonPreferences.r()) {
            CommonPreferences.s();
            return true;
        }
        if (aDOptionsListener != null) {
            aDOptionsListener.d();
            CommonHttpUtils.a(bluedADExtra.hidden_url);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ADOptionsListener aDOptionsListener, BluedADExtra bluedADExtra, PopupWindow popupWindow, View view) {
        if (aDOptionsListener != null) {
            aDOptionsListener.b();
            aDOptionsListener.d();
            CommonHttpUtils.a(bluedADExtra.hidden_url);
        }
        popupWindow.dismiss();
    }
}
