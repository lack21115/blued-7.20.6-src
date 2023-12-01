package com.blued.android.module.yy_china.fragment;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPageLevelFragmentNew.class */
public final class YYPageLevelFragmentNew extends YYPageLevelFragment {
    @Override // com.blued.android.module.yy_china.fragment.YYPageLevelFragment
    public void b() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.h(b.room_id, (BluedUIHttpResponse) c(), getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPageLevelFragment
    public void d() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.d(b.room_id, String.valueOf(a()), (BluedUIHttpResponse) e(), getFragmentActive());
    }
}
