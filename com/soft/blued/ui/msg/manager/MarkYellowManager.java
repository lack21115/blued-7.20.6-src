package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.soft.blued.ui.msg.model.MarkYellowListModel;
import com.soft.blued.ui.msg.model.MarkYellowModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/MarkYellowManager.class */
public class MarkYellowManager {

    /* renamed from: a  reason: collision with root package name */
    private static MarkYellowManager f32421a = new MarkYellowManager();

    private MarkYellowManager() {
    }

    public static MarkYellowManager a() {
        return f32421a;
    }

    public void a(List<String> list) {
        MarkYellowListModel b = b();
        if (b == null) {
            return;
        }
        for (String str : list) {
            b.addItem(new MarkYellowModel(str));
        }
        String json = AppInfo.f().toJson(b);
        Log.v("drb", "writHistory:" + json);
        BluedPreferences.e(json);
    }

    public MarkYellowListModel b() {
        String u = BluedPreferences.u();
        if (TextUtils.isEmpty(u)) {
            return new MarkYellowListModel();
        }
        try {
            return (MarkYellowListModel) AppInfo.f().fromJson(u, (Class<Object>) MarkYellowListModel.class);
        } catch (Exception e) {
            return new MarkYellowListModel();
        }
    }
}
