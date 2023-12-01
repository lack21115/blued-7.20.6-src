package com.blued.android.modules;

import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.base.shortvideo.IMusicList;
import com.blued.android.module.base.shortvideo.MusicListProxy;
import com.blued.community.ui.video.fragment.MyMusicCollectionFragment;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/MusicListModule.class */
public class MusicListModule {

    /* renamed from: a  reason: collision with root package name */
    protected static IMusicList f18630a = new IMusicList() { // from class: com.blued.android.modules.MusicListModule.1
        @Override // com.blued.android.module.base.shortvideo.IMusicList
        public void a(BaseFragment baseFragment, int i) {
            MyMusicCollectionFragment.a(baseFragment, i);
        }

        @Override // com.blued.android.module.base.shortvideo.IMusicList
        public void b(BaseFragment baseFragment, int i) {
            MyMusicCollectionFragment.a(baseFragment, i);
        }
    };

    public static void a() {
        MusicListProxy.a().a(f18630a);
    }
}
