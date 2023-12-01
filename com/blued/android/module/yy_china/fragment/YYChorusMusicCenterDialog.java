package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.music.model.YYChorusMusicModel;
import com.blued.android.module.live.base.music.model.YYKtvMusicTypeModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.BaseMusicPagerAdapter;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusMusicCenterDialog.class */
public final class YYChorusMusicCenterDialog extends BaseMusicCenterDialog<YYKtvMusicTypeModel> {

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChorusMusicCenterDialog$MusicAdapter.class */
    final class MusicAdapter extends BaseMusicPagerAdapter<YYKtvMusicTypeModel> {
        final /* synthetic */ YYChorusMusicCenterDialog a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MusicAdapter(com.blued.android.module.yy_china.fragment.YYChorusMusicCenterDialog r5) {
            /*
                r4 = this;
                r0 = r5
                java.lang.String r1 = "this$0"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                r0 = r4
                r1 = r5
                r0.a = r1
                r0 = r5
                androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
                r5 = r0
                r0 = r5
                java.lang.String r1 = "childFragmentManager"
                kotlin.jvm.internal.Intrinsics.c(r0, r1)
                r0 = r4
                r1 = r5
                r2 = 1
                r0.<init>(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChorusMusicCenterDialog.MusicAdapter.<init>(com.blued.android.module.yy_china.fragment.YYChorusMusicCenterDialog):void");
        }

        public Fragment getItem(int i) {
            YYKtvMusicTypeModel yYKtvMusicTypeModel;
            String str;
            List<YYKtvMusicTypeModel> a = a();
            YYChorusMusicItemFragment yYChorusMusicItemFragment = null;
            if (a != null && (yYKtvMusicTypeModel = a.get(i)) != null && (str = yYKtvMusicTypeModel.sheetId) != null) {
                yYChorusMusicItemFragment = new YYChorusMusicItemFragment(str);
            }
            if (yYChorusMusicItemFragment != null) {
                return yYChorusMusicItemFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }

        public CharSequence getPageTitle(int i) {
            YYKtvMusicTypeModel yYKtvMusicTypeModel;
            List<YYKtvMusicTypeModel> a = a();
            String str = null;
            if (a != null && (yYKtvMusicTypeModel = a.get(i)) != null) {
                str = yYKtvMusicTypeModel.sheetName;
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChorusMusicCenterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYChorusPlaylistDialog yYChorusPlaylistDialog = new YYChorusPlaylistDialog();
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYChorusPlaylistDialog.show(parentFragmentManager, "chorus_playlist_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYChorusMusicCenterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYChorusSearchMusicDialog yYChorusSearchMusicDialog = new YYChorusSearchMusicDialog();
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYChorusSearchMusicDialog.show(parentFragmentManager, "chorus_search_music_dialog");
    }

    private final void k() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.a(str, 1, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYChorusMusicModel, BluedEntityBaseExtra>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYChorusMusicCenterDialog$loadMusicCount$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYChorusMusicModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null) {
                    return;
                }
                ShapeTextView shapeTextView = YYChorusMusicCenterDialog.this.f().e;
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String string = YYChorusMusicCenterDialog.this.getResources().getString(R.string.yy_playlist_amount);
                Intrinsics.c(string, "resources.getString(R.string.yy_playlist_amount)");
                BluedEntityBaseExtra bluedEntityBaseExtra = bluedEntity.extra;
                String format = String.format(string, Arrays.copyOf(new Object[]{bluedEntityBaseExtra == null ? null : Integer.valueOf(bluedEntityBaseExtra.total)}, 1));
                Intrinsics.c(format, "format(format, *args)");
                shapeTextView.setText(format);
            }
        }, a());
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseMusicCenterDialog
    public void i() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.q(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYKtvMusicTypeModel>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYChorusMusicCenterDialog$loadMusicSheet$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYKtvMusicTypeModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                BaseMusicPagerAdapter<YYKtvMusicTypeModel> g = YYChorusMusicCenterDialog.this.g();
                List<YYKtvMusicTypeModel> list = bluedEntityA.data;
                Intrinsics.c(list, "result.data");
                g.a(list);
                YYChorusMusicCenterDialog.this.h();
            }
        }, a());
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseMusicCenterDialog
    public BaseMusicPagerAdapter<YYKtvMusicTypeModel> j() {
        return new MusicAdapter(this);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseMusicCenterDialog, com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        f().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicCenterDialog$exMnGbJTabGNXK4wlrhSkzisyIw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChorusMusicCenterDialog.a(YYChorusMusicCenterDialog.this, view2);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChorusMusicCenterDialog$FgW1G37Zg9WPrL5jMBfzYrmUE8Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChorusMusicCenterDialog.b(YYChorusMusicCenterDialog.this, view2);
            }
        });
        k();
    }
}
