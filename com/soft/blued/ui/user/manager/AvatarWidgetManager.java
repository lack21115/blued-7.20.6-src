package com.soft.blued.ui.user.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.model.AvatarWidgetList;
import com.soft.blued.ui.user.model.AvatarWidgetModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/manager/AvatarWidgetManager.class */
public class AvatarWidgetManager {

    /* renamed from: c  reason: collision with root package name */
    private static final AvatarWidgetManager f20532c = new AvatarWidgetManager();

    /* renamed from: a  reason: collision with root package name */
    public List<AvatarWidgetModel> f20533a;
    private boolean b;

    private AvatarWidgetManager() {
        ArrayList arrayList = new ArrayList();
        this.f20533a = arrayList;
        if (arrayList.size() == 0) {
            this.f20533a = b().getModelList();
        }
    }

    public static AvatarWidgetManager a() {
        return f20532c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AvatarWidgetModel> list) {
        AvatarWidgetList b = b();
        if (b == null || list == null || list.size() == 0) {
            return;
        }
        b.modelList = list;
        BluedPreferences.X(AppInfo.f().toJson(b));
    }

    private AvatarWidgetList b() {
        String di = BluedPreferences.di();
        if (!TextUtils.isEmpty(di)) {
            try {
                return (AvatarWidgetList) AppInfo.f().fromJson(di, (Class<Object>) AvatarWidgetList.class);
            } catch (Exception e) {
            }
        }
        return new AvatarWidgetList();
    }

    private void c() {
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AvatarWidgetModel>>() { // from class: com.soft.blued.ui.user.manager.AvatarWidgetManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AvatarWidgetModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    AvatarWidgetManager.this.a(bluedEntityA.data);
                    if (AvatarWidgetManager.this.f20533a.size() == 0) {
                        AvatarWidgetManager.this.f20533a.addAll(bluedEntityA.data);
                        AvatarWidgetManager.this.b(-1);
                    }
                }
            }

            public boolean onUIFailure(int i, String str) {
                return true;
            }

            public void onUIFinish() {
            }
        }, "pendant");
    }

    public String a(int i) {
        if (!this.b) {
            c();
            this.b = true;
        }
        Log.v("drb", "getWidgetRes id:" + i);
        for (AvatarWidgetModel avatarWidgetModel : this.f20533a) {
            if (avatarWidgetModel.id == i) {
                Log.v("drb", "getWidgetRes AvatarWidgetModel.theme:" + avatarWidgetModel.theme);
                return avatarWidgetModel.theme;
            }
        }
        return "";
    }

    public void b(int i) {
        LiveEventBus.get("feed_avatar_widget").post(Integer.valueOf(i));
    }
}
