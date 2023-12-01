package com.soft.blued.user;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.google.gson.Gson;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.login_register.model.PayExperimentConfigModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/user/ExperimentConfig.class */
public class ExperimentConfig {
    private static ExperimentConfig b;

    /* renamed from: a  reason: collision with root package name */
    private Gson f34702a;

    /* renamed from: c  reason: collision with root package name */
    private PayExperimentConfigModel f34703c;

    private ExperimentConfig() {
        String D = BluedPreferences.D();
        this.f34702a = AppInfo.f();
        try {
            if (StringUtils.d(D)) {
                this.f34703c = new PayExperimentConfigModel();
            } else {
                this.f34703c = (PayExperimentConfigModel) this.f34702a.fromJson(D, (Class<Object>) PayExperimentConfigModel.class);
            }
        } catch (Exception e) {
            this.f34703c = new PayExperimentConfigModel();
        }
    }

    public static ExperimentConfig a() {
        ExperimentConfig experimentConfig;
        synchronized (ExperimentConfig.class) {
            try {
                if (b == null) {
                    b = new ExperimentConfig();
                }
                experimentConfig = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return experimentConfig;
    }

    public PayExperimentConfigModel b() {
        return this.f34703c;
    }

    public void c() {
        PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<PayExperimentConfigModel>>(null) { // from class: com.soft.blued.user.ExperimentConfig.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayExperimentConfigModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                ExperimentConfig.this.f34703c = bluedEntityA.getSingleData();
                try {
                    BluedPreferences.j(ExperimentConfig.this.f34702a.toJson(bluedEntityA.getSingleData()));
                } catch (Exception e) {
                }
            }
        });
    }
}
