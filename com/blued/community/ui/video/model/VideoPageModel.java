package com.blued.community.ui.video.model;

import com.blued.android.framework.utils.Logger;
import com.blued.community.model.BluedIngSelfFeed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/model/VideoPageModel.class */
public class VideoPageModel {
    public static List<VideoPageModel> mVideos = new ArrayList();
    public BluedIngSelfFeed bluedIngSelfFeed;
    public int isLike;
    public String previewUrl;
    public String relationship;
    public String videoUrl;

    public VideoPageModel() {
    }

    public VideoPageModel(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    public VideoPageModel(String str, String str2) {
        this.previewUrl = str;
        this.videoUrl = str2;
    }

    public VideoPageModel(String[] strArr, BluedIngSelfFeed bluedIngSelfFeed) {
        if (strArr == null || strArr.length < 2) {
            return;
        }
        this.previewUrl = strArr[0];
        String str = strArr[1];
        this.videoUrl = str;
        this.bluedIngSelfFeed = bluedIngSelfFeed;
        Logger.b("xpf", new Object[]{"videoUrl:", str});
    }
}
