package com.blued.community.ui.send.manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.community.R;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.ui.event.dialog.EventSendDialogFragment;
import com.blued.community.ui.event.model.EventPostModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/manager/EventSendManager.class */
public class EventSendManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20040a = EventSendManager.class.getSimpleName();
    private static volatile EventSendManager b;

    public static EventSendManager a() {
        if (b == null) {
            synchronized (EventSendManager.class) {
                try {
                    if (b == null) {
                        b = new EventSendManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final Dialog dialog, final EventPostModel eventPostModel, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(eventPostModel.localPic, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.community.ui.send.manager.EventSendManager.2
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str) {
                dialog.dismiss();
                AppMethods.d(R.string.avatar_upload_error);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str, String str2) {
                dialog.dismiss();
                eventPostModel.pic = str;
                EventSendManager.this.b(context, dialog, eventPostModel);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, final Dialog dialog, final EventPostModel eventPostModel) {
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (TextUtils.isEmpty(eventPostModel.localSceneImg)) {
            b(context, eventPostModel);
            return;
        }
        String[] split = eventPostModel.localSceneImg.split(",");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                break;
            }
            arrayList.add(split[i2]);
            if (!split[i2].startsWith("http")) {
                arrayList2.add(new Pair(split[i2], ""));
            }
            i = i2 + 1;
        }
        if (arrayList2.size() == 0) {
            b(context, eventPostModel);
            return;
        }
        MediaSender.a(CommunityHttpUtils.a() + "/blued/qiniu?filter=token&action=ticktocks", (List<Pair<String, String>>) arrayList2, true, true, new SenderListener() { // from class: com.blued.community.ui.send.manager.EventSendManager.3
            private void a(Pair<String, UploadModel> pair, EventPostModel eventPostModel2) {
                if (TextUtils.isEmpty(pair.second.url)) {
                    return;
                }
                String str = pair.second.url;
                String str2 = EventSendManager.f20040a;
                Logger.e(str2, "图片上传成功===" + str);
                ImageFileLoader.a((IRequestHost) null).a(pair.second.compressPath, str).a();
                StringBuffer stringBuffer = new StringBuffer();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= arrayList.size()) {
                        String str3 = EventSendManager.f20040a;
                        Logger.e(str3, "图片上传成功===" + stringBuffer.toString());
                        eventPostModel2.localSceneImg = stringBuffer.toString();
                        return;
                    }
                    String str4 = (String) arrayList.get(i4);
                    String str5 = str4;
                    if (str4.equals(pair.first)) {
                        arrayList.remove(i4);
                        arrayList.add(i4, str);
                        str5 = str;
                    }
                    stringBuffer.append(str5);
                    stringBuffer.append(",");
                    i3 = i4 + 1;
                }
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, int i3) {
                String str2 = EventSendManager.f20040a;
                Logger.e(str2, "img===progress==" + i3);
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, Pair<String, UploadModel> pair) {
                Logger.e(EventSendManager.f20040a, "onPartFinish=======");
                a(pair, eventPostModel);
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, boolean z, List<Pair<String, String>> list) {
                String str2 = EventSendManager.f20040a;
                Logger.e(str2, "onFinish=======" + z);
                if (z) {
                    EventSendManager.this.b(context, eventPostModel);
                    return;
                }
                dialog.dismiss();
                AppMethods.d(R.string.avatar_upload_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, EventPostModel eventPostModel) {
        EventHttpUtils.a(new BluedUIHttpResponse<BluedEntity>(null) { // from class: com.blued.community.ui.send.manager.EventSendManager.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    AppMethods.d(R.string.event_post_success);
                } else {
                    AppMethods.d(R.string.event_post_fail);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                Context context2 = context;
                if (context2 instanceof Activity) {
                    ((Activity) context2).finish();
                }
                if (CommonPreferences.p()) {
                    CommonPreferences.q();
                    EventSendDialogFragment.f19531a.a(context);
                }
            }
        }, eventPostModel);
    }

    public void a(final Context context, final Dialog dialog, final EventPostModel eventPostModel) {
        CommunityHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(null) { // from class: com.blued.community.ui.send.manager.EventSendManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedAlbum> parseData(String str) {
                BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                            EventSendManager.this.a(context, dialog, eventPostModel, bluedEntityA.data.get(0));
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

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                dialog.dismiss();
                AppMethods.d(R.string.avatar_upload_error);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                dialog.show();
            }
        });
    }

    public void a(Context context, EventPostModel eventPostModel) {
        Dialog a2 = DialogUtils.a(context);
        if (TextUtils.isEmpty(eventPostModel.localPic) || !TextUtils.isEmpty(eventPostModel.pic)) {
            b(context, a2, eventPostModel);
        } else {
            a(context, a2, eventPostModel);
        }
    }
}
