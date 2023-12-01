package com.soft.blued.ui.welcome;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.Excitation;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.R;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.model.FlashNumberModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/BaseADVideoFragment.class */
public class BaseADVideoFragment extends BaseFragment {
    private static PayVIPPopupWindow.OnVideoSuccessListener g;

    /* renamed from: a  reason: collision with root package name */
    public Dialog f34513a;
    public BluedADExtra b;

    /* renamed from: c  reason: collision with root package name */
    public int f34514c;
    public boolean d;
    public String e;
    public boolean f;

    public static void a(Context context, BluedADExtra bluedADExtra, int i) {
        a(context, bluedADExtra, i, null);
    }

    public static void a(Context context, BluedADExtra bluedADExtra, int i, PayVIPPopupWindow.OnVideoSuccessListener onVideoSuccessListener) {
        if (bluedADExtra == null) {
            return;
        }
        g = onVideoSuccessListener;
        Bundle bundle = new Bundle();
        bundle.putSerializable("AD_DATA", bluedADExtra);
        bundle.putInt("AD_FROM", i);
        TransparentActivity.a(bundle);
        if ("4".equalsIgnoreCase(bluedADExtra.adms_type)) {
            TransparentActivity.b(context, TTVideoFragment.class, bundle);
        } else if ("3".equalsIgnoreCase(bluedADExtra.adms_type)) {
            TransparentActivity.b(context, TXVideoFragment.class, bundle);
        } else if ("6".equalsIgnoreCase(bluedADExtra.adms_type)) {
            TransparentActivity.b(context, TopVideoFragment.class, bundle);
        } else if ("13".equalsIgnoreCase(bluedADExtra.adms_type)) {
            TransparentActivity.b(context, KSVideoFragment.class, bundle);
        }
    }

    public void a() {
        int i = this.f34514c;
        if (i == 0) {
            LoginRegisterHttpUtils.a(new BluedUIHttpResponse(getFragmentActive()) { // from class: com.soft.blued.ui.welcome.BaseADVideoFragment.1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                }
            });
        } else if (i != 1) {
        } else {
            LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Excitation>>(getFragmentActive()) { // from class: com.soft.blued.ui.welcome.BaseADVideoFragment.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Excitation> bluedEntityA) {
                    if (bluedEntityA.hasData()) {
                        BaseADVideoFragment.this.d = true;
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str) {
                    BaseADVideoFragment.this.e = str;
                    return true;
                }
            }, this.b);
        }
    }

    public void b() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
        int i = this.f34514c;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            AppMethods.a((CharSequence) CommunityPreferences.k());
        } else if (this.d) {
            AppMethods.d((int) R.string.ad_video_success);
        } else if (TextUtils.isEmpty(this.e)) {
        } else {
            AppMethods.a((CharSequence) this.e);
        }
    }

    public void f() {
        if (this.f34514c != 2) {
            return;
        }
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.FLASH_AD_VIDEO_SUCCESS;
        EventTrackLoginAndRegister.c(event, this.b.aid + "");
        FlashPhotoManager.a().a(this.f, new FlashPhotoManager.FlashPhotoModelSuccessListener() { // from class: com.soft.blued.ui.welcome.BaseADVideoFragment.3
            @Override // com.soft.blued.ui.msg.manager.FlashPhotoManager.FlashPhotoModelSuccessListener
            public void onSuccess(BluedEntityA<FlashNumberModel> bluedEntityA) {
                if (BaseADVideoFragment.g != null) {
                    BaseADVideoFragment.g.a((bluedEntityA == null || bluedEntityA.getSingleData() == null || bluedEntityA.getSingleData().flash_left_times <= 0) ? false : true);
                }
            }
        });
    }

    public void g() {
        int i = this.f34514c;
        if (i == 0) {
            AppMethods.d((int) R.string.ad_video_failed);
        } else if (i == 1) {
            AppMethods.d((int) R.string.ad_video_banner_failed);
        } else if (i != 2) {
        } else {
            AppMethods.d(2131890735);
        }
    }

    public void h() {
        if (this.f34514c != 2) {
            return;
        }
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.FLASH_AD_VIDEO_REQUEST;
        EventTrackLoginAndRegister.c(event, this.b.ads_id + "");
    }

    public void i() {
        if (this.f34514c != 2) {
            return;
        }
        LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.FLASH_AD_VIDEO_RESPONSE;
        EventTrackLoginAndRegister.c(event, this.b.aid + "");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            BluedADExtra bluedADExtra = (BluedADExtra) getArguments().getSerializable("AD_DATA");
            this.b = bluedADExtra;
            if (bluedADExtra == null) {
                b();
            }
            this.f34514c = getArguments().getInt("AD_FROM");
        }
        this.f34513a = DialogUtils.a(getContext());
    }
}
