package com.blued.community.ui.video.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/observer/MusicChoosedObserver.class */
public class MusicChoosedObserver {

    /* renamed from: a  reason: collision with root package name */
    private static MusicChoosedObserver f20428a = new MusicChoosedObserver();
    private List<IMusicDownloadObserver> b = new ArrayList();

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/observer/MusicChoosedObserver$IMusicDownloadObserver.class */
    public interface IMusicDownloadObserver {
        void a();

        void a(String str, String str2);

        void b(String str, String str2);
    }

    private MusicChoosedObserver() {
    }

    public static MusicChoosedObserver a() {
        return f20428a;
    }

    public void a(String str, String str2) {
        synchronized (this) {
            for (IMusicDownloadObserver iMusicDownloadObserver : this.b) {
                if (iMusicDownloadObserver != null) {
                    iMusicDownloadObserver.a(str, str2);
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            for (IMusicDownloadObserver iMusicDownloadObserver : this.b) {
                if (iMusicDownloadObserver != null) {
                    iMusicDownloadObserver.a();
                }
            }
        }
    }

    public void b(String str, String str2) {
        synchronized (this) {
            for (IMusicDownloadObserver iMusicDownloadObserver : this.b) {
                if (iMusicDownloadObserver != null) {
                    iMusicDownloadObserver.b(str, str2);
                }
            }
        }
    }
}
