package com.soft.blued.ui.msg.controller.tools;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.upload.qiniu.MediaSender;
import com.blued.android.framework.utils.upload.qiniu.SenderListener;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.manager.ConfirmYellowManager;
import com.soft.blued.ui.msg.manager.MarkYellowManager;
import com.soft.blued.ui.msg.model.ConfirmYellowModel;
import com.soft.blued.ui.msg.model.MarkYellowModel;
import com.soft.blued.ui.msg.model.MessageIdentifyYellowModel;
import com.soft.blued.utils.AppUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/IdentifyYellowManager.class */
public class IdentifyYellowManager {

    /* renamed from: a  reason: collision with root package name */
    private static IdentifyYellowManager f32242a;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f32243c;
    private String d;
    private CheckYellowListener f;
    private LinkedBlockingQueue<ChattingModel> b = new LinkedBlockingQueue<>();
    private List<Pair<String, String>> e = new ArrayList();

    private IdentifyYellowManager() {
    }

    public static IdentifyYellowManager a() {
        if (f32242a == null) {
            synchronized (IdentifyYellowManager.class) {
                try {
                    if (f32242a == null) {
                        f32242a = new IdentifyYellowManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f32242a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Log.v("drb", "checkAndUpload");
        if (this.b.size() == 0) {
            this.f32243c = false;
            this.d = null;
            c();
            return;
        }
        final ChattingModel poll = this.b.poll();
        if (poll == null) {
            b();
            return;
        }
        if (!AppUtils.c(poll.fromId + "")) {
            if (!StringUtils.b(this.d)) {
                MediaSender.a(this.d);
            }
            this.b.clear();
            this.f32243c = false;
            this.d = null;
            return;
        }
        this.f32243c = true;
        final String a2 = a(poll);
        Log.v("drb", "checkAndUpload uploadFilePath:" + a2);
        if (a2.startsWith("http")) {
            b();
            return;
        }
        final short s = poll.msgType;
        Log.v("drb", "checkAndUpload msgType：" + ((int) s));
        if (s != 2) {
            if (s != 5) {
                if (s != 24) {
                    if (s != 25) {
                        return;
                    }
                }
            }
            Log.v("drb", "checkAndUpload 开始七牛上传");
            MediaSender.a(ChatHttpUtils.a(poll), new Pair(a2, ""), new SenderListener() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.2
                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str, int i) {
                }

                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str, Pair<String, UploadModel> pair) {
                    Log.v("drb", "checkAndUpload 七牛上传完成 pair.second：" + pair.second + " -- pair.second.url：" + pair.second.url);
                    if (pair == null || pair.second == null || TextUtils.isEmpty(pair.second.url)) {
                        IdentifyYellowManager.this.d();
                    } else {
                        String str2 = pair.second.url;
                        String str3 = str2;
                        if (s == 25) {
                            str3 = str2;
                            try {
                                String e = AesCrypto.e(pair.second.url);
                                StringBuilder sb = new StringBuilder();
                                sb.append("checkAndUpload 解密服务器返回的地址：");
                                sb.append(e);
                                str3 = e;
                                Log.v("drb", sb.toString());
                                str3 = e;
                            } catch (Exception e2) {
                                Log.v("drb", "checkAndUpload 解密异常：" + e2.toString());
                                e2.printStackTrace();
                            }
                        }
                        IdentifyYellowManager.this.e.add(new Pair(a2, str3));
                        IdentifyYellowManager.this.e();
                    }
                    IdentifyYellowManager.this.f32243c = false;
                }

                @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
                public void a(String str, boolean z, List<Pair<String, String>> list) {
                }
            });
            return;
        }
        boolean a3 = ChatHelperV4.a(new File(a2));
        this.d = MediaSender.a(ChatHttpUtils.a(poll), QiniuUploadUtils.a(a2, ""), !a3, new SenderListener() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.1
            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, int i) {
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, Pair<String, UploadModel> pair) {
                if (AppUtils.c(poll.fromId + "") && IdentifyYellowManager.this.f32243c) {
                    if (pair != null) {
                        if (poll.msgType == 24) {
                            try {
                                String e = AesCrypto.e(pair.second.url);
                                Log.v("drb", "checkAndUpload 解密服务器返回的地址：" + e);
                                IdentifyYellowManager.this.e.add(new Pair(a2, e));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            IdentifyYellowManager.this.e.add(new Pair(a2, pair.second.url));
                        }
                    }
                    IdentifyYellowManager.this.b();
                }
            }

            @Override // com.blued.android.framework.utils.upload.qiniu.SenderListener
            public void a(String str, boolean z, List<Pair<String, String>> list) {
            }
        });
    }

    private void c() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : this.e) {
            if (pair != null) {
                arrayList.add(pair.second);
                arrayList2.add(pair.first);
            }
        }
        if (FlexDebugSevConfig.a().b().isOpenLocalIdentifyYellow()) {
            MarkYellowManager.a().a(arrayList2);
        }
        ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MessageIdentifyYellowModel>>() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MessageIdentifyYellowModel> bluedEntityA) {
                IdentifyYellowManager.this.d();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                Log.v("drb", "statusCode:" + i + " -- content:" + str);
                if (i != 400) {
                    IdentifyYellowManager.this.d();
                } else if (BluedHttpUtils.a(th, i, str).first.intValue() != 4036114) {
                    IdentifyYellowManager.this.d();
                } else {
                    try {
                        final BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<MessageIdentifyYellowModel>>() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.3.1
                        }.getType());
                        if (bluedEntityA.hasData()) {
                            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.3.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    MessageIdentifyYellowModel messageIdentifyYellowModel = (MessageIdentifyYellowModel) bluedEntityA.getSingleData();
                                    ArrayList arrayList3 = new ArrayList();
                                    if (messageIdentifyYellowModel == null) {
                                        return;
                                    }
                                    Iterator it = IdentifyYellowManager.this.e.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            Log.v("drb", "接口鉴黄返回：" + arrayList3.size());
                                            ConfirmYellowManager.a().a(arrayList3);
                                            IdentifyYellowManager.this.f.a(false, (String[]) arrayList3.toArray(new String[0]));
                                            return;
                                        }
                                        Pair pair2 = (Pair) it.next();
                                        if (messageIdentifyYellowModel.image != null && pair2 != null) {
                                            for (String str2 : messageIdentifyYellowModel.image) {
                                                if (TextUtils.equals((CharSequence) pair2.second, str2)) {
                                                    arrayList3.add((String) pair2.first);
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        IdentifyYellowManager.this.d();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                IdentifyYellowManager.this.e.clear();
                super.onUIFinish();
            }
        }, (String[]) arrayList.toArray(new String[0]), (String[]) null, "send");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f.a(false, new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList arrayList = new ArrayList();
        for (Pair<String, String> pair : this.e) {
            if (pair != null) {
                arrayList.add(pair.second);
            }
        }
        if (FlexDebugSevConfig.a().b().isOpenLocalIdentifyYellow()) {
            MarkYellowManager.a().a(arrayList);
        }
        ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MessageIdentifyYellowModel>>() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MessageIdentifyYellowModel> bluedEntityA) {
                IdentifyYellowManager.this.d();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                Log.v("drb", "statusCode:" + i + " -- content:" + str);
                if (i == 400 && BluedHttpUtils.a(th, i, str).first.intValue() == 4036114) {
                    try {
                        final BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<MessageIdentifyYellowModel>>() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.4.1
                        }.getType());
                        if (bluedEntityA.hasData()) {
                            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.controller.tools.IdentifyYellowManager.4.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    MessageIdentifyYellowModel messageIdentifyYellowModel = (MessageIdentifyYellowModel) bluedEntityA.getSingleData();
                                    ArrayList arrayList2 = new ArrayList();
                                    if (messageIdentifyYellowModel == null) {
                                        return;
                                    }
                                    Iterator it = IdentifyYellowManager.this.e.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            ConfirmYellowManager.a().a(arrayList2);
                                            IdentifyYellowManager.this.f.a(false, (String[]) arrayList2.toArray(new String[0]));
                                            return;
                                        }
                                        Pair pair2 = (Pair) it.next();
                                        if (messageIdentifyYellowModel.video != null && pair2 != null) {
                                            for (String str2 : messageIdentifyYellowModel.video) {
                                                if (TextUtils.equals((CharSequence) pair2.second, str2)) {
                                                    arrayList2.add((String) pair2.first);
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    } catch (Exception e) {
                        IdentifyYellowManager.this.d();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                IdentifyYellowManager.this.e.clear();
                super.onUIFinish();
            }
        }, (String[]) null, (String[]) arrayList.toArray(new String[0]), "send");
    }

    public String a(ChattingModel chattingModel) {
        String str;
        String str2;
        String str3;
        short s = chattingModel.msgType;
        if (s == 2 || s == 5 || s == 251) {
            str = chattingModel.msgContent;
        } else if (s != 24) {
            if (s != 25) {
                str = "";
            } else if (com.soft.blued.utils.StringUtils.d(chattingModel.msgContent) || chattingModel.msgContent.endsWith("destroy")) {
                return "";
            } else {
                try {
                    str3 = AesCrypto.e(chattingModel.msgContent);
                } catch (Exception e) {
                    e.printStackTrace();
                    str3 = "";
                }
                if (com.soft.blued.utils.StringUtils.d(str3)) {
                    return chattingModel.msgContent;
                }
                str = str3;
                if (!com.soft.blued.utils.StringUtils.d(str3)) {
                    str = str3;
                    if (!str3.contains("http")) {
                        return chattingModel.msgContent;
                    }
                }
            }
        } else if (com.soft.blued.utils.StringUtils.d(chattingModel.msgContent) || chattingModel.msgContent.endsWith("destroy")) {
            return "";
        } else {
            try {
                str2 = AesCrypto.e(chattingModel.msgContent);
            } catch (Exception e2) {
                e2.printStackTrace();
                str2 = "";
            }
            if (com.soft.blued.utils.StringUtils.d(str2)) {
                return chattingModel.msgContent;
            }
            str = str2;
            if (!com.soft.blued.utils.StringUtils.d(str2)) {
                str = str2;
                if (!str2.contains("http")) {
                    return chattingModel.msgContent;
                }
            }
        }
        return com.soft.blued.utils.StringUtils.d(str) ? "" : str;
    }

    public void a(ChattingModel chattingModel, CheckYellowListener checkYellowListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(chattingModel);
        a(arrayList, checkYellowListener);
    }

    public void a(List<ChattingModel> list, CheckYellowListener checkYellowListener) {
        this.f = checkYellowListener;
        if (list != null) {
            checkYellowListener.a();
            ArrayList<ChattingModel> arrayList = new ArrayList();
            arrayList.addAll(list);
            if (FlexDebugSevConfig.a().b().isOpenLocalIdentifyYellow()) {
                List<ConfirmYellowModel> modelList = ConfirmYellowManager.a().b().getModelList();
                ArrayList arrayList2 = new ArrayList();
                for (ChattingModel chattingModel : arrayList) {
                    for (ConfirmYellowModel confirmYellowModel : modelList) {
                        if (TextUtils.equals(a(chattingModel), confirmYellowModel.path)) {
                            arrayList2.add(confirmYellowModel.path);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    Log.v("drb", "本地拦截");
                    this.f.a(true, (String[]) arrayList2.toArray(new String[0]));
                    return;
                }
                for (MarkYellowModel markYellowModel : MarkYellowManager.a().b().getModelList()) {
                    Iterator<E> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ChattingModel chattingModel2 = (ChattingModel) it.next();
                        if (TextUtils.equals(a(chattingModel2), markYellowModel.path)) {
                            Log.v("drb", "已经鉴黄过了，就不再去鉴黄一次了");
                            arrayList.remove(chattingModel2);
                            break;
                        }
                    }
                    if (arrayList.size() == 0) {
                        Log.v("drb", "这些资源都已经鉴黄过了，直接返回");
                        d();
                        return;
                    }
                }
            }
            for (ChattingModel chattingModel3 : arrayList) {
                this.b.add(chattingModel3);
                if (!this.f32243c) {
                    b();
                }
            }
        }
    }
}
