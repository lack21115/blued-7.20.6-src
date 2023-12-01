package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.soft.blued.ui.msg.model.ConfirmYellowListModel;
import com.soft.blued.ui.msg.model.ConfirmYellowModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/ConfirmYellowManager.class */
public class ConfirmYellowManager {

    /* renamed from: a  reason: collision with root package name */
    private static ConfirmYellowManager f18713a = new ConfirmYellowManager();

    private ConfirmYellowManager() {
    }

    public static ConfirmYellowManager a() {
        return f18713a;
    }

    public void a(List<String> list) {
        ConfirmYellowListModel b = b();
        if (b == null) {
            return;
        }
        for (String str : list) {
            b.addItem(new ConfirmYellowModel(str));
        }
        String json = AppInfo.f().toJson(b);
        Log.v("drb", "writHistory:" + json);
        BluedPreferences.f(json);
    }

    public ConfirmYellowListModel b() {
        String v = BluedPreferences.v();
        Log.v("drb", "readHistory 确认为黄：" + v);
        try {
            return TextUtils.isEmpty(v) ? new ConfirmYellowListModel() : (ConfirmYellowListModel) AppInfo.f().fromJson(v, (Class<Object>) ConfirmYellowListModel.class);
        } catch (Exception e) {
            return new ConfirmYellowListModel();
        }
    }
}
