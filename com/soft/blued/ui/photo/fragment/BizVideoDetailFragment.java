package com.soft.blued.ui.photo.fragment;

import android.os.Bundle;
import com.blued.android.module.player.media.fragment.VideoDetailFragment;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.soft.blued.log.InstantLog;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/BizVideoDetailFragment.class */
public class BizVideoDetailFragment extends VideoDetailFragment {

    /* renamed from: c  reason: collision with root package name */
    public boolean f19368c;
    private int d;
    private String e;
    private String f;

    public static BizVideoDetailFragment a(VideoPlayConfig videoPlayConfig, int i) {
        BizVideoDetailFragment bizVideoDetailFragment = new BizVideoDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("video_config_data", videoPlayConfig);
        bundle.putInt("come_code", i);
        bizVideoDetailFragment.setArguments(bundle);
        return bizVideoDetailFragment;
    }

    public static BizVideoDetailFragment a(VideoPlayConfig videoPlayConfig, int i, String str, String str2) {
        BizVideoDetailFragment bizVideoDetailFragment = new BizVideoDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("video_config_data", videoPlayConfig);
        bundle.putString("key_feed_id", str);
        bundle.putString("target_uid", str2);
        bundle.putInt("come_code", i);
        bizVideoDetailFragment.setArguments(bundle);
        return bizVideoDetailFragment;
    }

    public static VideoPlayConfig d() {
        VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
        videoPlayConfig.p = true;
        videoPlayConfig.o = true;
        videoPlayConfig.q = false;
        videoPlayConfig.r = true;
        return videoPlayConfig;
    }

    public void a() {
        this.d = getArguments() != null ? getArguments().getInt("come_code") : 0;
        this.e = getArguments() != null ? getArguments().getString("key_feed_id") : "";
        this.f = getArguments() != null ? getArguments().getString("target_uid") : "";
        super.a();
    }

    public void e() {
        int i = this.d;
        if (i == 0 || i == 7 || i == 6 || i == 10) {
            InstantLog.a("feed_video_play", (Object) 1);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f19368c) {
            b().c();
        }
    }

    public void onCreate(Bundle bundle) {
        getActivity().getWindow().setFlags(128, 128);
        super.onCreate(bundle);
    }

    public void onResume() {
        e();
        super.onResume();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f19368c = z;
        if (!z || b() == null) {
            return;
        }
        b().c();
    }
}
