package com.soft.blued.ui.home.manager;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.ui.home.model.ALinkActionModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/manager/ALinkAction.class */
public final class ALinkAction {

    /* renamed from: a  reason: collision with root package name */
    public static final ALinkAction f17351a = new ALinkAction();
    private static final BluedSharedPreferences b = BluedPreferences.a();

    private ALinkAction() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ALinkActionModel aLinkActionModel) {
        LiveEventBus.get("aLink_home_pop", ALinkActionModel.class).post(aLinkActionModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(int i, long j) {
        boolean z = false;
        int i2 = i != 1 ? i != 2 ? i != 3 ? 0 : 1 : 7 : 30;
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, calendar.get(6) - i2);
        Logger.c("ALink", Intrinsics.a("current - past: ", Long.valueOf(calendar.getTime().getTime())), " last_show_time : " + j + " current : " + calendar.get(6));
        if (calendar.getTime().getTime() - j >= 0) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        b.c().a("dot_last_show_time", System.currentTimeMillis()).b();
        LiveEventBus.get("aLink_live_dot").post(null);
    }

    public final void a(String str, final IRequestHost iRequestHost) {
        Intrinsics.e(str, "utm_campaign");
        AppHttpUtils.a(str, new BluedUIHttpResponse<BluedEntityA<ALinkActionModel>>(iRequestHost) { // from class: com.soft.blued.ui.home.manager.ALinkAction$getALinkAction$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ IRequestHost f17352a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(iRequestHost);
                this.f17352a = iRequestHost;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ALinkActionModel> bluedEntityA) {
                BluedSharedPreferences bluedSharedPreferences;
                BluedSharedPreferences bluedSharedPreferences2;
                boolean a2;
                BluedSharedPreferences bluedSharedPreferences3;
                BluedSharedPreferences bluedSharedPreferences4;
                BluedSharedPreferences bluedSharedPreferences5;
                boolean a3;
                Intrinsics.e(bluedEntityA, "resp");
                List list = bluedEntityA.data;
                if (list == null || list.isEmpty()) {
                    return;
                }
                ALinkActionModel aLinkActionModel = (ALinkActionModel) bluedEntityA.data.get(0);
                if (aLinkActionModel.getLive_tab_red_dot() == 1) {
                    bluedSharedPreferences3 = ALinkAction.b;
                    int b2 = bluedSharedPreferences3.b("dot_show_times", 0);
                    int i = b2;
                    if (aLinkActionModel.getLive_tab_red_dot_cycle() != 4) {
                        bluedSharedPreferences5 = ALinkAction.b;
                        i = b2;
                        a3 = ALinkAction.f17351a.a(aLinkActionModel.getLive_tab_red_dot_cycle(), bluedSharedPreferences5.a("dot_last_show_time", 0L));
                        if (a3) {
                            i = 0;
                        }
                    }
                    if (i < aLinkActionModel.getLive_tab_red_dot_time()) {
                        ALinkAction.f17351a.b();
                        bluedSharedPreferences4 = ALinkAction.b;
                        bluedSharedPreferences4.c().a("dot_show_times", i + 1).b();
                    }
                }
                if (aLinkActionModel.getHome_page_popup() == 1) {
                    bluedSharedPreferences = ALinkAction.b;
                    int b3 = bluedSharedPreferences.b("dialog_show_times", 0);
                    if (aLinkActionModel.getHome_page_popup_cycle() != 4) {
                        bluedSharedPreferences2 = ALinkAction.b;
                        a2 = ALinkAction.f17351a.a(aLinkActionModel.getHome_page_popup_cycle(), bluedSharedPreferences2.a("dialog_last_show_time", 0L));
                        if (a2) {
                            b3 = 0;
                        }
                    }
                    if (b3 < aLinkActionModel.getHome_page_popup_time()) {
                        aLinkActionModel.setLocal_dialog_show_times(b3 + 1);
                        ALinkAction aLinkAction = ALinkAction.f17351a;
                        Intrinsics.c(aLinkActionModel, "model");
                        aLinkAction.a(aLinkActionModel);
                    }
                }
            }
        });
    }
}
