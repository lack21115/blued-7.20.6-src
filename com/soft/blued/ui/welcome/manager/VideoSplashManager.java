package com.soft.blued.ui.welcome.manager;

import android.util.Log;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.soft.blued.utils.VideoLoadController;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/VideoSplashManager.class */
public class VideoSplashManager extends SplashAdManagerAdapter {

    /* renamed from: com.soft.blued.ui.welcome.manager.VideoSplashManager$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/VideoSplashManager$1.class */
    class AnonymousClass1 implements VideoLoadController.IVideoController {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SplashAdListener f20971a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f20972c;
        final /* synthetic */ PLVideoPageView d;

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str) {
            Log.v("drb", "视频下载失败 videoUrl:" + str);
            this.f20971a.a(0, "");
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, int i) {
            Log.v("drb", "视频开始下载 onDownloading:" + i);
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, String str2) {
            this.f20971a.a();
            VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
            videoPlayConfig.b = str2;
            videoPlayConfig.e = this.b;
            videoPlayConfig.f = this.f20972c;
            videoPlayConfig.j = false;
            videoPlayConfig.s = false;
            videoPlayConfig.l = true;
            videoPlayConfig.w = false;
            this.d.b(videoPlayConfig);
            this.d.setVisibility(4);
            this.d.c();
        }
    }

    /* renamed from: com.soft.blued.ui.welcome.manager.VideoSplashManager$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/VideoSplashManager$2.class */
    class AnonymousClass2 implements PLVideoPageView.OnPLVideoListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SplashAdListener f20973a;

        public void a() {
        }

        public void a(int i) {
            this.f20973a.b();
        }

        public void a(long j, long j2) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }
}
