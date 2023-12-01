package com.blued.community.ui.event.manager;

import android.text.TextUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.event.model.EventDetailsModel;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Objects;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/manager/EventMethods.class */
public class EventMethods {
    public static int a(EventDetailsModel eventDetailsModel) {
        int i;
        boolean s = CommunityManager.a.a().s();
        int i2 = eventDetailsModel.status;
        int i3 = 0;
        if (i2 == 0) {
            i = s ? R.drawable.icon_event_official_to_be_examine_dark : R.drawable.icon_event_official_to_be_examine;
        } else if (i2 == 1) {
            if (eventDetailsModel.join_num >= eventDetailsModel.quota_num) {
                i3 = s ? R.drawable.icon_event_full_complement_dark : R.drawable.icon_event_full_complement;
            }
            if (a(eventDetailsModel.uid)) {
                return i3;
            }
            int i4 = eventDetailsModel.apply_status;
            if (i4 != -1) {
                if (i4 == 1) {
                    i = eventDetailsModel.evaluate_status == 1 ? s ? R.drawable.icon_event_sign_up_score_dark : R.drawable.icon_event_sign_up_score : s ? R.drawable.icon_event_registered_dark : R.drawable.icon_event_registered;
                } else if (i4 != 2) {
                    return i3;
                }
            }
            i = s ? R.drawable.icon_event_sign_up_to_be_examin_dark : R.drawable.icon_event_sign_up_to_be_examin;
        } else if (i2 != 3) {
            return 0;
        } else {
            i = s ? R.drawable.icon_event_ended_dark : R.drawable.icon_event_ended;
        }
        return i;
    }

    public static boolean a(String str) {
        return TextUtils.equals(str, UserInfo.getInstance().getLoginUserInfo().uid);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        double d = 0.0d;
        try {
            d = ((Number) Objects.requireNonNull(new DecimalFormat().parse(str.replace("km", "")))).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (d > 999.0d) {
            return ((int) Math.floor(d)) + "km";
        }
        return d + "km";
    }
}
