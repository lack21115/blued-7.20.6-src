package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.utils.CommunityPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.model.FlashNumberModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/FlashPhotoManager.class */
public class FlashPhotoManager {

    /* renamed from: c  reason: collision with root package name */
    private static FlashPhotoManager f18720c;

    /* renamed from: a  reason: collision with root package name */
    private Gson f18721a;
    private FlashNumberModel b;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/FlashPhotoManager$FlashPhotoModelSuccessListener.class */
    public interface FlashPhotoModelSuccessListener {
        void onSuccess(BluedEntityA<FlashNumberModel> bluedEntityA);
    }

    private FlashPhotoManager() {
        String j = CommunityPreferences.j();
        this.f18721a = new GsonBuilder().disableHtmlEscaping().create();
        if (TextUtils.isEmpty(j)) {
            this.b = new FlashNumberModel();
        } else {
            this.b = (FlashNumberModel) this.f18721a.fromJson(j, (Class<Object>) FlashNumberModel.class);
        }
    }

    public static FlashPhotoManager a() {
        FlashPhotoManager flashPhotoManager;
        synchronized (FlashPhotoManager.class) {
            try {
                f18720c = null;
                flashPhotoManager = new FlashPhotoManager();
                f18720c = flashPhotoManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return flashPhotoManager;
    }

    public void a(int i) {
        this.b.flash_left_times = i;
        CommunityPreferences.e(AppInfo.f().toJson(this.b));
    }

    public void a(final FlashPhotoModelSuccessListener flashPhotoModelSuccessListener) {
        ChatHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<FlashNumberModel>>() { // from class: com.soft.blued.ui.msg.manager.FlashPhotoManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FlashNumberModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                CommunityPreferences.e(AppInfo.f().toJson(bluedEntityA.getSingleData()));
                FlashPhotoModelSuccessListener flashPhotoModelSuccessListener2 = flashPhotoModelSuccessListener;
                if (flashPhotoModelSuccessListener2 != null) {
                    flashPhotoModelSuccessListener2.onSuccess(bluedEntityA);
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, null);
    }

    public void a(boolean z) {
        if (z) {
            this.b.flash_left_times = 0;
            this.b.stimulate_flash = 0;
            CommunityPreferences.e(AppInfo.f().toJson(this.b));
            LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_FLASH_TIP).post(true);
        }
    }

    public void a(boolean z, final FlashPhotoModelSuccessListener flashPhotoModelSuccessListener) {
        if (z) {
            ChatHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<FlashNumberModel>>() { // from class: com.soft.blued.ui.msg.manager.FlashPhotoManager.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<FlashNumberModel> bluedEntityA) {
                    if (bluedEntityA != null) {
                        if (bluedEntityA.code == 403330) {
                            CommunityPreferences.f(AppInfo.d().getString(R.string.msg_flash_stimulate_is_vip));
                        } else {
                            CommunityPreferences.f(AppInfo.d().getString(R.string.msg_flash_stimulate_success));
                        }
                    }
                    FlashPhotoManager.this.a(new FlashPhotoModelSuccessListener() { // from class: com.soft.blued.ui.msg.manager.FlashPhotoManager.2.1
                        @Override // com.soft.blued.ui.msg.manager.FlashPhotoManager.FlashPhotoModelSuccessListener
                        public void onSuccess(BluedEntityA<FlashNumberModel> bluedEntityA2) {
                            LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_FLASH_TIP).post(true);
                            if (flashPhotoModelSuccessListener != null) {
                                flashPhotoModelSuccessListener.onSuccess(bluedEntityA2);
                            }
                        }
                    });
                }

                public boolean onUIFailure(int i, String str, String str2) {
                    flashPhotoModelSuccessListener.onSuccess(null);
                    CommunityPreferences.f(AppInfo.d().getString(R.string.msg_flash_stimulate_failed));
                    return true;
                }
            }, UserInfo.getInstance().getLoginUserInfo().uid, (IRequestHost) null);
            return;
        }
        CommunityPreferences.f(AppInfo.d().getString(R.string.msg_flash_stimulate_times_unlock));
        if (flashPhotoModelSuccessListener != null) {
            flashPhotoModelSuccessListener.onSuccess(null);
        }
    }

    public FlashNumberModel b() {
        return this.b;
    }
}
