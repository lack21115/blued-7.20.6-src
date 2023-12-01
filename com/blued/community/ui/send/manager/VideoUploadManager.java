package com.blued.community.ui.send.manager;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.community.http.CommunityHttpUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/manager/VideoUploadManager.class */
public class VideoUploadManager {
    private static String a = "FeedSend";
    private static VideoUploadManager b = new VideoUploadManager();
    private String c = CommunityHttpUtils.a() + "/blued/qiniu?filter=token&action=ticktocks";
    private String d = CommunityHttpUtils.a() + "/blued/qiniu?filter=token&action=videos&ops=ticktocks";
    private HashMap<String, UploadData> e = new HashMap<>();
    private VideoUploadListener f;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/manager/VideoUploadManager$UploadData.class */
    public static class UploadData implements Serializable {
        int a;
        ArrayList<Pair<String, UploadModel>> b = new ArrayList<>();
        List<Pair<String, String>> c;
        boolean d;
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/manager/VideoUploadManager$VideoUploadListener.class */
    public interface VideoUploadListener {
        void a(String str, int i);

        void a(String str, boolean z, ArrayList<Pair<String, UploadModel>> arrayList, List<Pair<String, String>> list);
    }

    public static VideoUploadManager a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UploadData b(String str) {
        return this.e.get(str) != null ? this.e.get(str) : new UploadData();
    }

    public void a(Pair<String, String> pair, Pair<String, String> pair2, VideoUploadListener videoUploadListener) {
        Log.d(a, "uploadVideo");
        if (videoUploadListener != null) {
            this.f = videoUploadListener;
        }
        MediaSender.a(this.c, this.d, pair, pair2, new SenderListener() { // from class: com.blued.community.ui.send.manager.VideoUploadManager.1
            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, int i) {
                UploadData b2 = VideoUploadManager.this.b(str);
                b2.a = i;
                VideoUploadManager.this.e.put(str, b2);
                if (VideoUploadManager.this.f != null) {
                    VideoUploadManager.this.f.a(str, i);
                }
                String str2 = VideoUploadManager.a;
                Log.d(str2, "sendVideo onProcess taskId" + str);
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, Pair<String, UploadModel> pair3) {
                UploadData b2 = VideoUploadManager.this.b(str);
                b2.b.add(pair3);
                VideoUploadManager.this.e.put(str, b2);
                String str2 = VideoUploadManager.a;
                Log.d(str2, "sendVideo onPartFinish taskId" + str);
                if (((UploadModel) pair3.second).type == 0) {
                    String str3 = VideoUploadManager.a;
                    Log.d(str3, "sendVideo onPartFinish pair first" + ((String) pair3.first));
                }
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, boolean z, List<Pair<String, String>> list) {
                UploadData b2 = VideoUploadManager.this.b(str);
                ArrayList<Pair<String, UploadModel>> arrayList = b2 != null ? b2.b : null;
                b2.d = z;
                b2.c = list;
                VideoUploadManager.this.e.put(str, b2);
                if (VideoUploadManager.this.f != null) {
                    VideoUploadManager.this.f.a(str, z, arrayList, list);
                }
                String str2 = VideoUploadManager.a;
                Log.d(str2, "sendVideo onFinish taskId" + str);
            }
        });
    }

    public void a(String str) {
        MediaSender.a(str);
        this.e.remove(str);
        String str2 = a;
        Log.d(str2, "cancleUploadVideo taskId" + str);
    }

    public void a(String str, Pair<String, String> pair, Pair<String, String> pair2, VideoUploadListener videoUploadListener) {
        if (TextUtils.isEmpty(str) || !this.e.containsKey(str)) {
            a(pair, pair2, videoUploadListener);
        } else if (videoUploadListener == null) {
        } else {
            this.f = videoUploadListener;
            UploadData uploadData = this.e.get(str);
            if (uploadData == null || uploadData.a != 100) {
                return;
            }
            this.f.a(str, uploadData.d, uploadData.b, uploadData.c);
        }
    }
}
