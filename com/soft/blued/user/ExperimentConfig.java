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
    private Gson f21011a;

    /* renamed from: c  reason: collision with root package name */
    private PayExperimentConfigModel f21012c;

    private ExperimentConfig() {
        String D = BluedPreferences.D();
        this.f21011a = AppInfo.f();
        try {
            if (StringUtils.d(D)) {
                this.f21012c = new PayExperimentConfigModel();
            } else {
                this.f21012c = (PayExperimentConfigModel) this.f21011a.fromJson(D, (Class<Object>) PayExperimentConfigModel.class);
            }
        } catch (Exception e) {
            this.f21012c = new PayExperimentConfigModel();
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
        return this.f21012c;
    }

    public void c() {
        PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<PayExperimentConfigModel>>(null) { // from class: com.soft.blued.user.ExperimentConfig.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayExperimentConfigModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                ExperimentConfig.this.f21012c = (PayExperimentConfigModel) bluedEntityA.getSingleData();
                try {
                    BluedPreferences.j(ExperimentConfig.this.f21011a.toJson(bluedEntityA.getSingleData()));
                } catch (Exception e) {
                }
            }
        });
    }
}
