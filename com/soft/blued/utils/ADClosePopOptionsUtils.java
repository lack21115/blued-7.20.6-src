package com.soft.blued.utils;

import android.content.Context;
import android.view.View;
import com.blued.ad.ADConstants;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.utils.ADClosePopOptionsHelper;
import com.blued.das.vip.VipProtos;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/ADClosePopOptionsUtils.class */
public class ADClosePopOptionsUtils {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/ADClosePopOptionsUtils$ADRemovedListener.class */
    public interface ADRemovedListener {
        void onRemoved();
    }

    public static void a(final Context context, final BluedADExtra bluedADExtra, View view, final ADConstants.AD_POSITION ad_position, final ADRemovedListener aDRemovedListener) {
        ADClosePopOptionsHelper.a(context, bluedADExtra, view, ad_position, new ADClosePopOptionsHelper.ADOptionsListener() { // from class: com.soft.blued.utils.ADClosePopOptionsUtils.1
            public void a() {
                EventTrackVIP.a(VipProtos.Event.NO_AD_PROPAGATE_SHOW, EventTrackVIP.b(ADConstants.AD_POSITION.this), bluedADExtra.adms_type);
            }

            public void b() {
                EventTrackVIP.a(VipProtos.Event.NO_AD_PROPAGATE_BUY_CLICK, EventTrackVIP.b(ADConstants.AD_POSITION.this), bluedADExtra.adms_type);
                PayUtils.a(context, 2, EventTrackVIP.a(ADConstants.AD_POSITION.this), 27, VipProtos.FromType.UNKNOWN_FROM);
            }

            public void c() {
                EventTrackVIP.a(VipProtos.Event.NO_AD_PROPAGATE_CLOSE_CLICK, EventTrackVIP.b(ADConstants.AD_POSITION.this), bluedADExtra.adms_type);
            }

            public void d() {
                aDRemovedListener.onRemoved();
            }

            public int e() {
                return BluedConfig.a().z();
            }
        });
    }
}
