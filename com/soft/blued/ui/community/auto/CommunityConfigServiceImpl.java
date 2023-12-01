package com.soft.blued.ui.community.auto;

import android.content.Context;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.community.auto.ICommunityConfigService;
import com.blued.community.model.BubbleExhibitionModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.PopMenuUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/auto/CommunityConfigServiceImpl.class */
public class CommunityConfigServiceImpl implements ICommunityConfigService {
    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean A() {
        return BluedConfig.a().M();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean B() {
        return BluedConfig.a().N();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean C() {
        return BluedConfig.a().L();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int D() {
        return BluedConfig.a().O();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int E() {
        return FlashPhotoManager.a().b().flash_left_times;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String F() {
        return FlashPhotoManager.a().b().flash_prompt;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String G() {
        return FlashPhotoManager.a().b().notice_text;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int H() {
        return FlashPhotoManager.a().b().stimulate_flash;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String I() {
        return FlashPhotoManager.a().b().aid;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String J() {
        return FlashPhotoManager.a().b().third_id;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String K() {
        return FlashPhotoManager.a().b().adms_type;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String L() {
        return FlashPhotoManager.a().b().stimulate_flash_text;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean M() {
        return BluedConfig.a().W();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean N() {
        return BluedConfig.a().Y();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public List<BubbleExhibitionModel> O() {
        return BluedConfig.a().aa();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean P() {
        return BluedConfig.a().Z();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int Q() {
        return BluedConfig.a().ab();
    }

    @Override // com.blued.community.auto.ICommunityConfigService, com.blued.community.auto.ICommunityLocationService, com.blued.community.auto.ICommunityOtherService, com.blued.community.auto.ICommunityShowPageService, com.blued.community.auto.ICommunityTrackService
    public String a() {
        return "MAIN";
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public void b(boolean z) {
        BluedConfig.a().f34699a = z;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean b(Context context) {
        return PopMenuUtils.a(context);
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean c(Context context) {
        if (LiveFloatManager.a().H()) {
            DialogSkipFragment.a(context, 4);
        }
        return LiveFloatManager.a().H();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String g() {
        return "com.soft.blued";
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean j() {
        return PopMenuUtils.a();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean k() {
        return AudioChannelManager.j().o();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean l() {
        return AudioChannelManager.j().n();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean m() {
        return AudioChannelManager.j().n();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean n() {
        return LiveFloatManager.a().H();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean o() {
        return BluedConfig.a().f34699a;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int p() {
        if (HomeActivity.f30985c == null || HomeActivity.f30985c.h() == null) {
            return 0;
        }
        return HomeActivity.f30985c.h().bubble_source;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int q() {
        if (HomeActivity.f30985c == null || HomeActivity.f30985c.h() == null) {
            return 0;
        }
        return HomeActivity.f30985c.h().bubble_type;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String[] r() {
        if (HomeActivity.f30985c != null) {
            return HomeActivity.f30985c.l();
        }
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public void s() {
        if (HomeActivity.f30985c != null) {
            HomeActivity.f30985c.i();
        }
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public List<String> t() {
        return BluedConfig.a().H();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String u() {
        return BluedConfig.a().I();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int v() {
        return BluedConfig.a().J();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean w() {
        return true;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int x() {
        if (BluedConfig.a().b() == null) {
            return 0;
        }
        return BluedConfig.a().b().is_activity_white;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int y() {
        return BluedConfig.a().z();
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean z() {
        return BluedConfig.a().K();
    }
}
