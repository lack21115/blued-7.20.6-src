package com.blued.community.ui.video.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.community.R;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.video.model.VideoScanMusic;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/presenter/MusicVideoCollectPresent.class */
public class MusicVideoCollectPresent extends MvpPresenter {
    private VideoScanMusic h;
    private String i;
    private int j = 1;
    private int k = 30;
    private boolean l;

    static /* synthetic */ int c(MusicVideoCollectPresent musicVideoCollectPresent) {
        int i = musicVideoCollectPresent.j;
        musicVideoCollectPresent.j = i - 1;
        return i;
    }

    private void c(final IFetchDataListener iFetchDataListener) {
        if (this.j == 1) {
            this.l = true;
        }
        if (this.l) {
            FeedHttpUtils.b(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, VideoScanMusic>>(g()) { // from class: com.blued.community.ui.video.presenter.MusicVideoCollectPresent.1
                public void onUIFinish(boolean z) {
                    if (!z && MusicVideoCollectPresent.this.j != 1) {
                        MusicVideoCollectPresent.c(MusicVideoCollectPresent.this);
                    }
                    iFetchDataListener.a(z);
                }

                public void onUIUpdate(BluedEntity<BluedIngSelfFeed, VideoScanMusic> bluedEntity) {
                    boolean z = false;
                    if (bluedEntity != null) {
                        if (bluedEntity.extra != null && !TextUtils.isEmpty(((VideoScanMusic) bluedEntity.extra).music_id)) {
                            MusicVideoCollectPresent.this.h = (VideoScanMusic) bluedEntity.extra;
                        }
                        MusicVideoCollectPresent.this.a("collect_music", (VideoScanMusic) bluedEntity.extra);
                        if (bluedEntity.hasData()) {
                            iFetchDataListener.a("collect_list", bluedEntity.data);
                        }
                        if (bluedEntity.extra != null) {
                            MusicVideoCollectPresent musicVideoCollectPresent = MusicVideoCollectPresent.this;
                            if (((VideoScanMusic) bluedEntity.extra).has_more == 1) {
                                z = true;
                            }
                            musicVideoCollectPresent.l = z;
                        } else {
                            MusicVideoCollectPresent.this.l = false;
                        }
                    } else {
                        MusicVideoCollectPresent.this.l = false;
                    }
                    IFetchDataListener iFetchDataListener2 = iFetchDataListener;
                    if (iFetchDataListener2 != null) {
                        iFetchDataListener2.b(MusicVideoCollectPresent.this.l);
                    }
                }
            }, this.i, this.j, this.k, g());
        }
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        VideoScanMusic videoScanMusic = (VideoScanMusic) bundle.getSerializable("video_scan_music");
        this.h = videoScanMusic;
        if (videoScanMusic == null || TextUtils.isEmpty(videoScanMusic.music_id)) {
            i();
            return;
        }
        this.i = this.h.music_id;
        a("collect_music", this.h);
    }

    public void a(IFetchDataListener iFetchDataListener) {
        this.j = 1;
        c(iFetchDataListener);
    }

    public void b(IFetchDataListener iFetchDataListener) {
        this.j++;
        c(iFetchDataListener);
    }

    public void m() {
        if (p().i_star == 1) {
            p().i_star = 0;
            a("collect_music", this.h);
            o();
            return;
        }
        p().i_star = 1;
        a("collect_music", this.h);
        n();
    }

    public void n() {
        FeedHttpUtils.e(new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.video.presenter.MusicVideoCollectPresent.2
            public void onUIUpdate(BluedEntity bluedEntity) {
                MusicVideoCollectPresent.this.p().i_star = 1;
                MusicVideoCollectPresent musicVideoCollectPresent = MusicVideoCollectPresent.this;
                musicVideoCollectPresent.a("collect_music", musicVideoCollectPresent.h);
                AppMethods.d(R.string.music_collection_success);
            }
        }, this.i, g());
    }

    public void o() {
        FeedHttpUtils.f(new BluedUIHttpResponse(g()) { // from class: com.blued.community.ui.video.presenter.MusicVideoCollectPresent.3
            public void onUIUpdate(BluedEntity bluedEntity) {
                MusicVideoCollectPresent.this.p().i_star = 0;
                MusicVideoCollectPresent musicVideoCollectPresent = MusicVideoCollectPresent.this;
                musicVideoCollectPresent.a("collect_music", musicVideoCollectPresent.h);
            }
        }, this.i, g());
    }

    public VideoScanMusic p() {
        if (this.h == null) {
            this.h = new VideoScanMusic();
        }
        return this.h;
    }
}
