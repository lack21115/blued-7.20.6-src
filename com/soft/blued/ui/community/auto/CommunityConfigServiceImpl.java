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
    public boolean A() {
        return BluedConfig.a().M();
    }

    public boolean B() {
        return BluedConfig.a().N();
    }

    public boolean C() {
        return BluedConfig.a().L();
    }

    public int D() {
        return BluedConfig.a().O();
    }

    public int E() {
        return FlashPhotoManager.a().b().flash_left_times;
    }

    public String F() {
        return FlashPhotoManager.a().b().flash_prompt;
    }

    public String G() {
        return FlashPhotoManager.a().b().notice_text;
    }

    public int H() {
        return FlashPhotoManager.a().b().stimulate_flash;
    }

    public String I() {
        return FlashPhotoManager.a().b().aid;
    }

    public String J() {
        return FlashPhotoManager.a().b().third_id;
    }

    public String K() {
        return FlashPhotoManager.a().b().adms_type;
    }

    public String L() {
        return FlashPhotoManager.a().b().stimulate_flash_text;
    }

    public boolean M() {
        return BluedConfig.a().W();
    }

    public boolean N() {
        return BluedConfig.a().Y();
    }

    public List<BubbleExhibitionModel> O() {
        return BluedConfig.a().aa();
    }

    public boolean P() {
        return BluedConfig.a().Z();
    }

    public int Q() {
        return BluedConfig.a().ab();
    }

    public String a() {
        return "MAIN";
    }

    public void b(boolean z) {
        BluedConfig.a().f21008a = z;
    }

    public boolean b(Context context) {
        return PopMenuUtils.a(context);
    }

    public boolean c(Context context) {
        if (LiveFloatManager.a().H()) {
            DialogSkipFragment.a(context, 4);
        }
        return LiveFloatManager.a().H();
    }

    public String g() {
        return "com.soft.blued";
    }

    public boolean j() {
        return PopMenuUtils.a();
    }

    public boolean k() {
        return AudioChannelManager.j().o();
    }

    public boolean l() {
        return AudioChannelManager.j().n();
    }

    public boolean m() {
        return AudioChannelManager.j().n();
    }

    public boolean n() {
        return LiveFloatManager.a().H();
    }

    public boolean o() {
        return BluedConfig.a().f21008a;
    }

    public int p() {
        if (HomeActivity.f17295c == null || HomeActivity.f17295c.h() == null) {
            return 0;
        }
        return HomeActivity.f17295c.h().bubble_source;
    }

    public int q() {
        if (HomeActivity.f17295c == null || HomeActivity.f17295c.h() == null) {
            return 0;
        }
        return HomeActivity.f17295c.h().bubble_type;
    }

    public String[] r() {
        if (HomeActivity.f17295c != null) {
            return HomeActivity.f17295c.l();
        }
        return null;
    }

    public void s() {
        if (HomeActivity.f17295c != null) {
            HomeActivity.f17295c.i();
        }
    }

    public List<String> t() {
        return BluedConfig.a().H();
    }

    public String u() {
        return BluedConfig.a().I();
    }

    public int v() {
        return BluedConfig.a().J();
    }

    public boolean w() {
        return true;
    }

    public int x() {
        if (BluedConfig.a().b() == null) {
            return 0;
        }
        return BluedConfig.a().b().is_activity_white;
    }

    public int y() {
        return BluedConfig.a().z();
    }

    public boolean z() {
        return BluedConfig.a().K();
    }
}
