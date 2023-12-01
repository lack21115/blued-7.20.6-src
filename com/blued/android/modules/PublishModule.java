package com.blued.android.modules;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.base.http.IPublish;
import com.blued.android.module.base.http.PublishProxy;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.blued.community.model.BluedIngSelfFeed;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.FlashVideoHttpUtils;
import com.soft.blued.utils.Logger;
import java.io.File;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/PublishModule.class */
public class PublishModule {
    public static final String a = PublishModule.class.getSimpleName();
    static IPublish b = new IPublish() { // from class: com.blued.android.modules.PublishModule.1
        /* JADX INFO: Access modifiers changed from: private */
        public void a(final Context context, final String str, final int i, BluedAlbum bluedAlbum, final PublishProxy.IUploadAuthVideoListener iUploadAuthVideoListener) {
            QiniuUploadUtils.a(StvMediaUtils.b(str), bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.android.modules.PublishModule.1.2
                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public void a(String str2) {
                    Logger.b(PublishModule.a, new Object[]{"uploadQiNiu = onFailure", str2});
                    iUploadAuthVideoListener.a(-1, str2);
                }

                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public void a(String str2, double d) {
                    iUploadAuthVideoListener.a(str2, d);
                }

                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public void a(String str2, String str3) {
                    Logger.b(PublishModule.a, new Object[]{"uploadQiNiu = onSuccess", str2});
                    if (iUploadAuthVideoListener.a()) {
                        return;
                    }
                    a(context, str, str2, i, iUploadAuthVideoListener);
                }

                @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
                public boolean a() {
                    return iUploadAuthVideoListener.a();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, final String str, String str2, int i, final PublishProxy.IUploadAuthVideoListener iUploadAuthVideoListener) {
            FlashVideoHttpUtils.a(context, new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>() { // from class: com.blued.android.modules.PublishModule.1.3
                boolean a = false;
                int b = -1;
                String c = "";

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str3) {
                    Logger.b(PublishModule.a, new Object[]{"getTokenForVideoAuth = onFailure | statusCode =", Integer.valueOf(i2), " | errorMessage = ", str3});
                    this.a = true;
                    this.b = i2;
                    this.c = str3;
                    return super.onUIFailure(i2, str3);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    if (this.a) {
                        iUploadAuthVideoListener.a(this.b, this.c);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    Logger.b(PublishModule.a, new Object[]{" synPhotoServer onStart()"});
                    super.onUIStart();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> bluedEntity) {
                    Logger.b(PublishModule.a, new Object[]{"synPhotoServer = onSuccess"});
                    try {
                        if (BluedHttpUtils.a(bluedEntity.code, bluedEntity.message)) {
                            StvThreadPoolHelper.a().a((Runnable) new StvThreadPoolHelper.StvThread(new Runnable() { // from class: com.blued.android.modules.PublishModule.1.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (str != null) {
                                        File file = new File(str);
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                    }
                                }
                            }));
                            if (iUploadAuthVideoListener.a()) {
                                return;
                            }
                            iUploadAuthVideoListener.b();
                        }
                    } catch (Exception e) {
                        Logger.b(PublishModule.a, new Object[]{"e = ", e});
                        e.printStackTrace();
                    }
                }
            }, str2);
        }

        private void a(final PublishProxy.ILiveApplyListener iLiveApplyListener, int i) {
            LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>() { // from class: com.blued.android.modules.PublishModule.1.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BluedLiveListData> bluedEntityA) {
                    Log.i("xpm", "postApplyComplete SUCCESS");
                    PublishProxy.ILiveApplyListener iLiveApplyListener2 = iLiveApplyListener;
                    if (iLiveApplyListener2 != null) {
                        iLiveApplyListener2.a();
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str) {
                    Log.i("xpm", "postApplyComplete FAIL");
                    PublishProxy.ILiveApplyListener iLiveApplyListener2 = iLiveApplyListener;
                    if (iLiveApplyListener2 != null) {
                        iLiveApplyListener2.a(i2, str);
                    }
                    AppMethods.a((CharSequence) str);
                    return false;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                }
            }, UserInfo.getInstance().getLoginUserInfo().getUid(), i);
        }

        @Override // com.blued.android.module.base.http.IPublish
        public void a(Context context, int i, PublishProxy.ILiveApplyListener iLiveApplyListener) {
            a(iLiveApplyListener, i);
        }

        @Override // com.blued.android.module.base.http.IPublish
        public void a(final Context context, final String str, final int i, final PublishProxy.IUploadAuthVideoListener iUploadAuthVideoListener) {
            if (iUploadAuthVideoListener == null) {
                return;
            }
            AppHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.blued.android.modules.PublishModule.1.1
                boolean a = false;
                int b = -1;
                String c = "";

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                    if (!BluedHttpUtils.a(bluedEntityA.code, bluedEntityA.message)) {
                        iUploadAuthVideoListener.a(this.b, this.c);
                    } else if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        iUploadAuthVideoListener.a(this.b, this.c);
                    } else {
                        a(context, str, i, bluedEntityA.data.get(0), iUploadAuthVideoListener);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str2) {
                    Logger.b(PublishModule.a, new Object[]{"getTokenForVideoAuth = onFailure | statusCode =", Integer.valueOf(i2), " | errorMessage = ", str2});
                    this.a = true;
                    this.b = i2;
                    this.c = str2;
                    return super.onUIFailure(i2, str2);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    if (this.a) {
                        iUploadAuthVideoListener.a(this.b, this.c);
                    }
                }
            });
        }
    };

    public static void a() {
        PublishProxy.a().a(b);
    }
}
