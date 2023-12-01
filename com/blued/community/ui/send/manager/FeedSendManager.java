package com.blued.community.ui.send.manager;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.module.common.db.NewFeedDao;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedExtra;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.RepostListDataObserver;
import com.blued.community.ui.send.manager.VideoUploadManager;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.utils.StorageUtils;
import com.blued.community.utils.UserInfoUtils;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/manager/FeedSendManager.class */
public class FeedSendManager {

    /* renamed from: a  reason: collision with root package name */
    private static FeedSendManager f20048a = new FeedSendManager();
    private List<NewFeedModel> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<NewFeedModel> f20049c = new ArrayList();
    private List<String> d = new ArrayList();
    private List<String> e = new ArrayList();
    private ArrayMap<String, String> f = new ArrayMap<>();
    private int g;
    private int h;
    private String i;
    private String j;
    private long k;

    public static FeedSendManager a() {
        return f20048a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Pair<String, UploadModel> pair, final NewFeedModel newFeedModel) {
        if (pair.second.type == 0) {
            Logger.e("FeedSend", "pair.second.type ");
            b(pair, newFeedModel);
            return;
        }
        Logger.e("FeedSend", "video===onPartFinish==" + pair.second.url);
        if (TextUtils.isEmpty(pair.second.url)) {
            return;
        }
        String str = pair.first;
        if (!TextUtils.isEmpty(pair.second.compressPath)) {
            str = pair.second.compressPath;
        }
        StorageUtils.a(pair.second.url, newFeedModel.localVideoPath, str);
        newFeedModel.videoPath = pair.second.url;
        ThreadManager.a().a(new ThreadExecutor("update-feedModel") { // from class: com.blued.community.ui.send.manager.FeedSendManager.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                NewFeedDao.a().c(newFeedModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedIngSelfFeed bluedIngSelfFeed, NewFeedModel newFeedModel) {
        LogUtils.c(bluedIngSelfFeed.toString());
        newFeedModel.setProgress(100);
        FeedRefreshObserver.a().a(null, 1);
        if (!TextUtils.isEmpty(newFeedModel.localVideoPath) && newFeedModel.localVideoPath.contains("/storage/emulated/0/Android/data/com.soft.blued/cache/AutnVideo/")) {
            FileUtils.a(newFeedModel.localVideoPath);
        }
        NewFeedDao.a().d(newFeedModel);
        this.f20049c.remove(newFeedModel);
        this.b.remove(newFeedModel);
        f();
        g();
        bluedIngSelfFeed.vip_grade = UserInfoUtils.b().vip_grade;
        bluedIngSelfFeed.is_vip_annual = UserInfoUtils.b().is_vip_annual;
        bluedIngSelfFeed.is_show_vip_page = UserInfoUtils.b().is_show_vip_page;
        bluedIngSelfFeed.activity_id = newFeedModel.activity_id;
        FeedRefreshObserver.a().a(bluedIngSelfFeed, 2);
        LiveEventBus.get("send_feed_success").post(bluedIngSelfFeed);
        if (newFeedModel.is_attention_show_dot == 1) {
            CommunityServiceManager.e().h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedComment feedComment, NewFeedModel newFeedModel) {
        newFeedModel.setProgress(100);
        FeedRefreshObserver.a().a(null, 1);
        this.f20049c.remove(newFeedModel);
        this.b.remove(newFeedModel);
        f();
        g();
        FeedRefreshObserver.a().a(feedComment, 2);
        if (AppInfo.m()) {
            AppMethods.a((CharSequence) "评论成功");
            Log.v("drb", "评论成功");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, BluedAlbum bluedAlbum, final String str2, final NewFeedModel newFeedModel) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.community.ui.send.manager.FeedSendManager.10
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str3) {
                Logger.a("drb", "upLoadByQiNiu onFailure = ", str3);
                FeedSendManager.this.f(newFeedModel);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str3, final double d) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.send.manager.FeedSendManager.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d <= 1.0d) {
                            FeedSendManager.this.g = (((int) (d * 100.0d)) / newFeedModel.getSize()) + FeedSendManager.this.h;
                            int size = ((int) (d * 100.0d)) / newFeedModel.getSize();
                            if (d == 1.0d) {
                                FeedSendManager.b(FeedSendManager.this, size);
                                newFeedModel.setProgress(FeedSendManager.this.g);
                                NewFeedDao.a().c(newFeedModel);
                            }
                            if (FeedSendManager.this.g == 100 || FeedSendManager.this.g > 99) {
                                if (newFeedModel.isVideo == 1) {
                                    newFeedModel.setProgress(20);
                                } else {
                                    newFeedModel.setProgress(99);
                                }
                                FeedRefreshObserver.a().a(null, 1);
                            } else if (FeedSendManager.this.g != newFeedModel.getProgress()) {
                                if (newFeedModel.isVideo == 1) {
                                    newFeedModel.setProgress((int) (FeedSendManager.this.g * 0.2d));
                                } else {
                                    newFeedModel.setProgress(FeedSendManager.this.g);
                                }
                                FeedRefreshObserver.a().a(null, 1);
                            }
                        }
                    }
                });
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str3, String str4) {
                ImageFileLoader.a((IRequestHost) null).a(str, str3).a();
                FeedSendManager.this.d.remove(str2);
                StringBuffer stringBuffer = new StringBuffer();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= FeedSendManager.this.e.size()) {
                        break;
                    }
                    String str5 = (String) FeedSendManager.this.e.get(i2);
                    String str6 = str5;
                    if (str5.equals(str2)) {
                        FeedSendManager.this.e.remove(i2);
                        FeedSendManager.this.e.add(i2, str3);
                        str6 = str3;
                    }
                    stringBuffer.append(str6);
                    stringBuffer.append(";");
                    i = i2 + 1;
                }
                newFeedModel.setPics(stringBuffer.toString());
                NewFeedDao.a().c(newFeedModel);
                if (FeedSendManager.this.d.size() > 0) {
                    FeedSendManager.this.e(newFeedModel);
                } else if (newFeedModel.isVideo != 1) {
                    FeedSendManager.this.d(newFeedModel);
                } else if (TextUtils.isEmpty(newFeedModel.videoPath) || newFeedModel.videoPath.startsWith("http")) {
                    FeedSendManager.this.h(newFeedModel);
                } else {
                    FeedSendManager.this.g(newFeedModel);
                }
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, BluedAlbum bluedAlbum, final NewFeedModel newFeedModel) {
        QiniuUploadUtils.a(bArr, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.community.ui.send.manager.FeedSendManager.11
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str) {
                FeedSendManager.this.f(newFeedModel);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str, final double d) {
                AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.send.manager.FeedSendManager.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        double d2 = d;
                        if (d2 <= 1.0d) {
                            int i = ((int) (100.0d * d2)) + 20;
                            if (d2 == 1.0d) {
                                newFeedModel.setProgress(99);
                                NewFeedDao.a().c(newFeedModel);
                            }
                            if (i == 100 || i > 99) {
                                newFeedModel.setProgress(99);
                                FeedRefreshObserver.a().a(null, 1);
                            } else if (i != newFeedModel.getProgress()) {
                                newFeedModel.setProgress(i);
                                FeedRefreshObserver.a().a(null, 1);
                            }
                            Logger.a("ddrb", "progress = ", Integer.valueOf(i));
                        }
                    }
                });
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str, String str2) {
                StorageUtils.a(str, newFeedModel.localPath, newFeedModel.videoPath);
                newFeedModel.videoPath = str;
                NewFeedDao.a().c(newFeedModel);
                FeedSendManager.this.h(newFeedModel);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    static /* synthetic */ int b(FeedSendManager feedSendManager, int i) {
        int i2 = feedSendManager.h + i;
        feedSendManager.h = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Pair<String, UploadModel> pair, final NewFeedModel newFeedModel) {
        if (TextUtils.isEmpty(pair.second.url)) {
            return;
        }
        String str = pair.second.url;
        Logger.e("FeedSend", "图片上传成功===" + str);
        ImageFileLoader.a((IRequestHost) null).a(pair.second.compressPath, str).a();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                Logger.e("FeedSend", "图片上传成功===" + stringBuffer.toString());
                newFeedModel.setPics(stringBuffer.toString());
                ThreadManager.a().a(new ThreadExecutor("update-feedModel") { // from class: com.blued.community.ui.send.manager.FeedSendManager.5
                    @Override // com.blued.android.framework.pool.ThreadExecutor
                    public void execute() {
                        NewFeedDao.a().c(newFeedModel);
                    }
                });
                return;
            }
            String str2 = this.e.get(i2);
            String str3 = str2;
            if (str2.equals(pair.first)) {
                this.e.remove(i2);
                this.e.add(i2, str);
                str3 = str;
            }
            stringBuffer.append(str3);
            stringBuffer.append(";");
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final NewFeedModel newFeedModel) {
        final String str = this.d.get(0);
        final String e = RecyclingUtils.e("photo");
        Houyi.a().a(str, e).a(new Houyi.OnCompressListener() { // from class: com.blued.community.ui.send.manager.FeedSendManager.2
            @Override // com.blued.android.framework.utils.Houyi.OnCompressListener
            public void a() {
            }

            @Override // com.blued.android.framework.utils.Houyi.OnCompressListener
            public void a(String str2) {
                CommunityHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.blued.community.ui.send.manager.FeedSendManager.2.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public BluedEntityA<BluedAlbum> parseData(String str3) {
                        BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA) super.parseData(str3);
                        if (bluedEntityA != null) {
                            try {
                                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                                    FeedSendManager.this.a(e, bluedEntityA.data.get(0), str, newFeedModel);
                                    Logger.a("drb", "newPath = ", e);
                                    return bluedEntityA;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        return bluedEntityA;
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                    public void onFailure(Throwable th, int i, String str3) {
                        super.onFailure(th, i, str3);
                        Logger.a("drb", "CommunityHttpUtils onFailure = ", Integer.valueOf(i));
                        FeedSendManager.this.f(newFeedModel);
                    }
                });
            }

            @Override // com.blued.android.framework.utils.Houyi.OnCompressListener
            public void a(Throwable th) {
                Logger.a("drb", "onError = ", th);
                FeedSendManager.this.f(newFeedModel);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final NewFeedModel newFeedModel) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.send.manager.FeedSendManager.6
            @Override // java.lang.Runnable
            public void run() {
                newFeedModel.setState(0);
                if (newFeedModel.showNotificationWhenSend == 0) {
                    NewFeedDao.a().c(newFeedModel);
                    FeedRefreshObserver.a().a(BluedIngSelfFeed.convertFromFeed(newFeedModel), 0);
                }
                FeedSendManager.this.f20049c.remove(newFeedModel);
                FeedSendManager.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final NewFeedModel newFeedModel) {
        CommunityHttpUtils.b(null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.blued.community.ui.send.manager.FeedSendManager.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedAlbum> parseData(String str) {
                BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                            FeedSendManager.this.a(StorageUtils.c(newFeedModel.videoPath), bluedEntityA.data.get(0), newFeedModel);
                            return bluedEntityA;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bluedEntityA;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                FeedSendManager.this.f(newFeedModel);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final NewFeedModel newFeedModel) {
        if (!UserInfoUtils.c().equals(String.valueOf(newFeedModel.getLoadName()))) {
            j();
            return;
        }
        Logger.e("FeedSend", "video====" + ((System.currentTimeMillis() - this.k) / 1000) + "==end==" + System.currentTimeMillis());
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>() { // from class: com.blued.community.ui.send.manager.FeedSendManager.12
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onSuccess(String str) {
                super.onSuccess(str);
                Logger.e("FeedSend", "onSuccess content" + str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                FeedSendManager.this.f(newFeedModel);
                Logger.e("FeedSend", "onUIFailure successed");
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> bluedEntity) {
                if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    Logger.e("FeedSend", "else onUIUpdate successed");
                    return;
                }
                FeedSendManager.this.a(bluedEntity.extra, newFeedModel);
                Logger.e("FeedSend", "onUIUpdate successed");
            }
        }, newFeedModel, this.i, this.j, !TextUtils.isEmpty(newFeedModel.getPics()) ? newFeedModel.getPics().split(";") : new String[1], new String[]{newFeedModel.videoPath}, newFeedModel.videoWidth > 0 ? String.valueOf(newFeedModel.videoWidth) : String.valueOf(480), newFeedModel.videoHeight > 0 ? String.valueOf(newFeedModel.videoHeight) : String.valueOf(480), newFeedModel.duration);
    }

    private void i() {
        this.d.clear();
        this.e.clear();
        this.g = 0;
        this.h = 0;
    }

    private void i(final NewFeedModel newFeedModel) {
        Logger.a("drb", "feedForward content = ", newFeedModel.getContent());
        FeedHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>() { // from class: com.blued.community.ui.send.manager.FeedSendManager.13
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                FeedSendManager.this.f(newFeedModel);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> bluedEntity) {
                if (bluedEntity != null) {
                    try {
                        if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                            return;
                        }
                        FeedSendManager.this.a(bluedEntity.extra, newFeedModel);
                        FeedRepost feedRepost = new FeedRepost();
                        feedRepost.feed_id = newFeedModel.feed_id;
                        feedRepost.repost_id = bluedEntity.getSingleData().feed_id;
                        feedRepost.repost_uid = UserInfoUtils.c();
                        feedRepost.user_avatar = UserInfoUtils.b().getAvatar();
                        feedRepost.user_name = UserInfoUtils.b().getName();
                        feedRepost.repost_timestamp = newFeedModel.getTime() + "";
                        feedRepost.vbadge = UserInfoUtils.b().getVBadge();
                        feedRepost.repost_content = newFeedModel.getContent();
                        feedRepost.repost_also_comment = newFeedModel.repost_also_comment;
                        Logger.a("drb", "feedForward repost_content = ", feedRepost.repost_content);
                        Logger.a("drb", "feedForward forwardContent = ", newFeedModel.forwardContent);
                        RepostListDataObserver.b().a(feedRepost);
                        LiveEventBus.get("feed_add_repost").post(feedRepost);
                        if (bluedEntity.extra.repost_also_comment == 1) {
                            FeedSendManager.this.a(newFeedModel.feed_id, feedRepost.repost_content, false);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> parseData(String str) {
                return super.parseData(str);
            }
        }, newFeedModel.feed_id, newFeedModel.getContent(), newFeedModel.allow_comments, newFeedModel.reading_scope, newFeedModel.is_ads, newFeedModel.address, newFeedModel.getLng(), newFeedModel.getLat(), newFeedModel.is_super_topics, newFeedModel.super_did, newFeedModel.super_topics_name, newFeedModel.share_posting_id, newFeedModel.repost_also_comment);
    }

    private void j() {
        FeedRefreshObserver.a().a(null, 4);
        i();
    }

    public void a(NewFeedModel newFeedModel) {
        this.k = System.currentTimeMillis();
        Logger.e("FeedSend", "startUpload========" + this.k);
        if (newFeedModel == null || newFeedModel.getLoadName() == 0) {
            return;
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("Only the original thread can start upload feed.");
        }
        newFeedModel.setState(1);
        if (newFeedModel.showNotificationWhenSend == 0) {
            this.b.add(0, newFeedModel);
        }
        if (this.f20049c.size() <= 0) {
            this.f20049c.add(0, newFeedModel);
            f();
        } else {
            this.f20049c.add(0, newFeedModel);
        }
        FeedRefreshObserver.a().a(BluedIngSelfFeed.convertFromFeed(newFeedModel), 3);
    }

    public void a(String str, String str2, boolean z) {
        FeedComment feedComment = new FeedComment();
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed(str);
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = AppInfo.d().getString(R.string.feed_meanwhile_forward_);
        }
        if (z) {
            CircleHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<FeedComment>>(null) { // from class: com.blued.community.ui.send.manager.FeedSendManager.14
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    LiveEventBus.get("comment_meanwhile").post(bluedEntityA.data.get(0));
                }
            }, bluedIngSelfFeed, feedComment, str3, false, 0, (IRequestHost) null);
        } else {
            FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(null) { // from class: com.blued.community.ui.send.manager.FeedSendManager.15
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<FeedComment> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    LiveEventBus.get("comment_meanwhile").post(bluedEntityA.data.get(0));
                }
            }, bluedIngSelfFeed, feedComment, str3, (IRequestHost) null);
        }
    }

    public void b() {
        this.j = Build.MANUFACTURER + Build.MODEL;
        this.i = "Android" + Build.VERSION.RELEASE;
        List<NewFeedModel> d = NewFeedDao.a().d();
        this.b = d;
        if (d == null || d.size() <= 0) {
            return;
        }
        Collections.reverse(this.b);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                FeedRefreshObserver.a().a(null, 0);
                return;
            }
            NewFeedModel newFeedModel = this.b.get(i2);
            newFeedModel.setState(0);
            NewFeedDao.a().c(newFeedModel);
            i = i2 + 1;
        }
    }

    public void b(NewFeedModel newFeedModel) {
        newFeedModel.setState(1);
        newFeedModel.isResend = true;
        if (this.f20049c.size() <= 0) {
            Log.d("FendSend", "restartUploadmSendingList.add");
            this.f20049c.add(0, newFeedModel);
            f();
        } else {
            this.f20049c.add(0, newFeedModel);
        }
        FeedRefreshObserver.a().a(null, 3);
    }

    public ArrayMap<String, String> c() {
        return this.f;
    }

    public void c(NewFeedModel newFeedModel) {
        List<NewFeedModel> list = this.b;
        if (list == null || list.size() <= 0) {
            return;
        }
        if (!this.b.remove(newFeedModel)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    break;
                } else if (newFeedModel.getId() == this.b.get(i2).getId()) {
                    this.b.remove(i2);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
        FeedRefreshObserver.a().a(null, 4);
    }

    public List<NewFeedModel> d() {
        return this.b;
    }

    public void d(final NewFeedModel newFeedModel) {
        boolean z = false;
        if (!UserInfoUtils.c().equals(String.valueOf(newFeedModel.getLoadName()))) {
            Logger.e("FeedSend", "切换账号====" + newFeedModel.getLoadName() + "=loginInfo==" + UserInfoUtils.c());
            j();
            return;
        }
        int size = this.e.size();
        String[] strArr = new String[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                break;
            }
            strArr[i2] = this.e.get(i2);
            i = i2 + 1;
        }
        String[] a2 = ImageUtils.a(newFeedModel.localPath);
        if (!TextUtils.isEmpty(newFeedModel.extraJSON)) {
            Gson f = AppInfo.f();
            FeedExtra feedExtra = (FeedExtra) f.fromJson(newFeedModel.extraJSON, (Class<Object>) FeedExtra.class);
            if (feedExtra.thumb == null || feedExtra.thumb.size() <= 0) {
                feedExtra.thumb = new ArrayList();
            }
            if (size > 0) {
                feedExtra.thumb.add(strArr[0]);
            }
            newFeedModel.extraJSON = f.toJson(feedExtra);
        }
        if (newFeedModel.is_circle_comment != 1) {
            FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>() { // from class: com.blued.community.ui.send.manager.FeedSendManager.8
                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable th, int i3, String str) {
                    super.onFailure(th, i3, str);
                    BluedHttpUtils.b(th, i3, str);
                    FeedSendManager.this.f(newFeedModel);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> bluedEntity) {
                    if (bluedEntity != null) {
                        try {
                            if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                                return;
                            }
                            FeedSendManager.this.a(bluedEntity.extra, newFeedModel);
                            if (newFeedModel.repost_also_comment == 1) {
                                FeedSendManager.this.a(newFeedModel.feed_id, bluedEntity.extra.feed_content, true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> parseData(String str) {
                    return super.parseData(str);
                }
            }, newFeedModel, this.i, this.j, strArr, (String[]) null, a2[0], a2[1], 0.0d);
            return;
        }
        BluedUIHttpResponse<BluedEntity<FeedComment, BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<FeedComment, BluedIngSelfFeed>>() { // from class: com.blued.community.ui.send.manager.FeedSendManager.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i3, String str) {
                super.onFailure(th, i3, str);
                BluedHttpUtils.b(th, i3, str);
                FeedSendManager.this.f(newFeedModel);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedComment, BluedIngSelfFeed> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    return;
                }
                FeedSendManager.this.a(bluedEntity.data.get(0), newFeedModel);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<FeedComment, BluedIngSelfFeed> parseData(String str) {
                return super.parseData(str);
            }
        };
        String str = newFeedModel.feed_id;
        String content = newFeedModel.getContent();
        if (newFeedModel.is_anonym == 1) {
            z = true;
        }
        FeedHttpUtils.a(bluedUIHttpResponse, str, content, strArr, z);
    }

    public int e() {
        return this.b.size();
    }

    public void f() {
        i();
        List<NewFeedModel> list = this.f20049c;
        if (list == null || list.size() <= 0) {
            return;
        }
        final NewFeedModel newFeedModel = this.f20049c.get(0);
        String pics = newFeedModel.getPics();
        Logger.e("FeedSend", "Pic====" + newFeedModel.getPics());
        Pair<String, String> pair = null;
        Pair<String, String> pair2 = null;
        if (newFeedModel.isVideo == 1) {
            if (!TextUtils.isEmpty(pics)) {
                String[] split = pics.split(";");
                int i = 0;
                while (true) {
                    int i2 = i;
                    pair = pair2;
                    if (i2 >= split.length) {
                        break;
                    }
                    this.e.add(split[i2]);
                    if (!split[i2].startsWith("http")) {
                        pair2 = new Pair<>(split[i2], "");
                    }
                    i = i2 + 1;
                }
            }
            Pair<String, String> pair3 = new Pair<>(newFeedModel.videoPath, "");
            Logger.e("FeedSend", "videoPath=====" + newFeedModel.videoPath);
            VideoUploadManager.a().a(newFeedModel.videoTaskID, pair, pair3, new VideoUploadManager.VideoUploadListener() { // from class: com.blued.community.ui.send.manager.FeedSendManager.3
                @Override // com.blued.community.ui.send.manager.VideoUploadManager.VideoUploadListener
                public void a(String str, int i3) {
                    if (TextUtils.isEmpty(newFeedModel.videoTaskID) || str.equals(newFeedModel.videoTaskID)) {
                        Logger.e("FeedSend", "video===progress==" + i3);
                        newFeedModel.setProgress(i3);
                        AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.send.manager.FeedSendManager.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedRefreshObserver.a().a(null, 1);
                            }
                        });
                        return;
                    }
                    Logger.e("FeedSend", "feedModel.videoTaskID" + newFeedModel.videoTaskID + DBDefinition.TASK_ID + str);
                }

                @Override // com.blued.community.ui.send.manager.VideoUploadManager.VideoUploadListener
                public void a(String str, boolean z, ArrayList<Pair<String, UploadModel>> arrayList, List<Pair<String, String>> list2) {
                    if (!TextUtils.isEmpty(newFeedModel.videoTaskID) && !str.equals(newFeedModel.videoTaskID)) {
                        Logger.e("FeedSend", "feedModel.videoTaskID" + newFeedModel.videoTaskID + DBDefinition.TASK_ID + str);
                        return;
                    }
                    Logger.e("FeedSend", "onFinish succeed " + z);
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            FeedSendManager.this.a(arrayList.get(i3), newFeedModel);
                        }
                    } else {
                        Logger.e("FeedSend", "onFinish partArrayList is null");
                    }
                    if (z) {
                        FeedSendManager.this.h(newFeedModel);
                    } else {
                        FeedSendManager.this.f(newFeedModel);
                    }
                }
            });
        } else if (newFeedModel.is_repost == 1) {
            i(newFeedModel);
        } else {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(pics)) {
                d(newFeedModel);
                return;
            }
            String[] split2 = pics.split(";");
            for (int i3 = 0; i3 < split2.length; i3++) {
                this.e.add(split2[i3]);
                if (!split2[i3].startsWith("http")) {
                    arrayList.add(new Pair(split2[i3], ""));
                }
            }
            if (arrayList.size() == 0) {
                d(newFeedModel);
                return;
            }
            this.h = newFeedModel.getProgress();
            MediaSender.a(CommunityHttpUtils.a() + "/blued/qiniu?filter=token&action=ticktocks", (List<Pair<String, String>>) arrayList, !newFeedModel.dontNeedCompress, true, new SenderListener() { // from class: com.blued.community.ui.send.manager.FeedSendManager.4
                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str, int i4) {
                    Logger.e("FeedSend", "img===progress==" + i4);
                    newFeedModel.setProgress(i4);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.community.ui.send.manager.FeedSendManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FeedRefreshObserver.a().a(null, 1);
                        }
                    });
                }

                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str, Pair<String, UploadModel> pair4) {
                    Logger.e("SendManager", "onPartFinish=======");
                    FeedSendManager.this.b(pair4, newFeedModel);
                }

                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str, boolean z, List<Pair<String, String>> list2) {
                    if (!z) {
                        FeedSendManager.this.f(newFeedModel);
                        return;
                    }
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= list2.size()) {
                            FeedSendManager.this.d(newFeedModel);
                            return;
                        }
                        String[] a2 = ImageUtils.a(list2.get(i5).first);
                        if (i5 == 0) {
                            newFeedModel.feed_pics_width = a2[0];
                            newFeedModel.feed_pics_height = a2[1];
                        } else {
                            NewFeedModel newFeedModel2 = newFeedModel;
                            newFeedModel2.feed_pics_width = newFeedModel.feed_pics_width + "," + a2[0];
                            NewFeedModel newFeedModel3 = newFeedModel;
                            newFeedModel3.feed_pics_height = newFeedModel.feed_pics_height + "," + a2[1];
                        }
                        i4 = i5 + 1;
                    }
                }
            });
        }
    }

    public void g() {
        boolean z;
        synchronized (this) {
            if (this.b == null || this.b.size() <= 0) {
                FeedRefreshObserver.a().a(null, 5);
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 >= this.b.size()) {
                        break;
                    } else if (this.b.get(i2).getState() == 0) {
                        FeedRefreshObserver.a().a(null, 0);
                        z = true;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
                if (!z) {
                    FeedRefreshObserver.a().a(null, 5);
                }
            }
        }
    }

    public int h() {
        synchronized (this) {
            int i = 0;
            if (this.b == null || this.b.size() <= 0) {
                return 0;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i >= this.b.size()) {
                    return i3;
                }
                int i4 = i3;
                if (this.b.get(i).getState() == 0) {
                    i4 = i3 + 1;
                }
                i++;
                i2 = i4;
            }
        }
    }
}
