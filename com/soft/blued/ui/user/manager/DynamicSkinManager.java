package com.soft.blued.ui.user.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.model.DynamicSkinList;
import com.soft.blued.ui.user.model.DynamicSkinModel;
import com.soft.blued.ui.user.model.VipBubbleModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/manager/DynamicSkinManager.class */
public class DynamicSkinManager {

    /* renamed from: c  reason: collision with root package name */
    private static final DynamicSkinManager f34226c = new DynamicSkinManager();

    /* renamed from: a  reason: collision with root package name */
    public List<DynamicSkinModel> f34227a;
    private boolean b;

    private DynamicSkinManager() {
        ArrayList arrayList = new ArrayList();
        this.f34227a = arrayList;
        if (arrayList.size() == 0) {
            this.f34227a = b().getModelList();
        }
    }

    public static DynamicSkinManager a() {
        return f34226c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DynamicSkinModel> list) {
        DynamicSkinList b = b();
        if (b == null || list == null || list.size() == 0) {
            return;
        }
        b.modelList = list;
        BluedPreferences.W(AppInfo.f().toJson(b));
    }

    private DynamicSkinList b() {
        String dh = BluedPreferences.dh();
        if (TextUtils.isEmpty(dh)) {
            return new DynamicSkinList();
        }
        try {
            return (DynamicSkinList) AppInfo.f().fromJson(dh, (Class<Object>) DynamicSkinList.class);
        } catch (Exception e) {
            return new DynamicSkinList();
        }
    }

    private void c() {
        MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<DynamicSkinModel>>() { // from class: com.soft.blued.ui.user.manager.DynamicSkinManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<DynamicSkinModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    DynamicSkinManager.this.a(bluedEntityA.data);
                    if (DynamicSkinManager.this.f34227a.size() == 0) {
                        DynamicSkinManager.this.f34227a.addAll(bluedEntityA.data);
                        DynamicSkinManager.this.b(-1);
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
            }
        }, VipBubbleModel.TYPE_TICKTOCKS);
    }

    public String a(int i) {
        if (!this.b) {
            c();
            this.b = true;
        }
        Log.v("drb", "getDynamicRes id:" + i);
        for (DynamicSkinModel dynamicSkinModel : this.f34227a) {
            if (dynamicSkinModel.id == i) {
                Log.v("drb", "getDynamicRes dynamicSkinModel.theme:" + dynamicSkinModel.theme);
                return dynamicSkinModel.theme;
            }
        }
        return "";
    }

    public void b(int i) {
        LiveEventBus.get("feed_dynamic_skin").post(Integer.valueOf(i));
    }
}
