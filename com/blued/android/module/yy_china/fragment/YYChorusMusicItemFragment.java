package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYKtvMusicExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusMusicItemFragment.class */
public final class YYChorusMusicItemFragment extends BaseMusicItemFragment<YYKtvMusicModel> {
    private String b;
    private String c;

    public YYChorusMusicItemFragment(String sheetId) {
        Intrinsics.e(sheetId, "sheetId");
        this.b = sheetId;
        this.c = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<YYKtvMusicModel> list) {
        BaseQuickAdapter<YYKtvMusicModel, BaseViewHolder> b;
        if (TextUtils.isEmpty(this.c)) {
            BaseQuickAdapter<YYKtvMusicModel, BaseViewHolder> b2 = b();
            if (b2 == null) {
                return;
            }
            b2.setNewData(list);
        } else if (list == null || (b = b()) == null) {
        } else {
            b.addData(list);
        }
    }

    private final void i() {
        String str = this.b;
        String str2 = this.c;
        YYRoomModel d = d();
        String str3 = d == null ? null : d.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.b(str, str2, str3, "2", (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYKtvMusicModel, YYKtvMusicExtra>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYChorusMusicItemFragment$loadData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                String str4;
                super.onUIFinish(z);
                YYChorusMusicItemFragment yYChorusMusicItemFragment = YYChorusMusicItemFragment.this;
                str4 = yYChorusMusicItemFragment.c;
                yYChorusMusicItemFragment.a(!TextUtils.isEmpty(str4));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYKtvMusicModel, YYKtvMusicExtra> bluedEntity) {
                String str4;
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    str4 = YYChorusMusicItemFragment.this.c;
                    if (TextUtils.isEmpty(str4)) {
                        YYChorusMusicItemFragment.this.a((List<YYKtvMusicModel>) null);
                    }
                    YYChorusMusicItemFragment.this.c = "";
                    YYChorusMusicItemFragment.this.a(false);
                    return;
                }
                if (TextUtils.equals(YYChorusMusicItemFragment.this.h(), "wish-choosed")) {
                    for (YYKtvMusicModel yYKtvMusicModel : bluedEntity.data) {
                        yYKtvMusicModel.type = 2;
                    }
                }
                YYChorusMusicItemFragment.this.a(bluedEntity.data);
                YYKtvMusicExtra yYKtvMusicExtra = bluedEntity.extra;
                if (yYKtvMusicExtra == null) {
                    return;
                }
                YYChorusMusicItemFragment yYChorusMusicItemFragment = YYChorusMusicItemFragment.this;
                String str5 = yYKtvMusicExtra.ScrollToken;
                Intrinsics.c(str5, "it.ScrollToken");
                yYChorusMusicItemFragment.c = str5;
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseMusicItemFragment
    public BaseQuickAdapter<YYKtvMusicModel, BaseViewHolder> e() {
        return new YYChorusMusicItemFragment$createMusicItemAdapter$1(this);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseMusicItemFragment
    public void f() {
        this.c = "";
        i();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseMusicItemFragment
    public void g() {
        i();
    }

    public final String h() {
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        if (TextUtils.equals(this.b, "wish-choosed")) {
            NoDataAndLoadFailView c = c();
            if (c != null) {
                c.setNoDataImg(R.drawable.icon_chorus_no_music);
            }
            NoDataAndLoadFailView c2 = c();
            if (c2 != null) {
                c2.setTopSpace(DensityUtils.a(getContext(), 40.0f));
            }
            NoDataAndLoadFailView c3 = c();
            if (c3 != null) {
                c3.setNoDataTextColor(R.color.syc_999999);
            }
            NoDataAndLoadFailView c4 = c();
            if (c4 != null) {
                c4.setNoDataTextSize(14.0f);
            }
            NoDataAndLoadFailView c5 = c();
            if (c5 == null) {
                return;
            }
            c5.setNoDataStr(R.string.yy_no_music);
        }
    }
}
