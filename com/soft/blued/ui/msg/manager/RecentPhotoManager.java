package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.google.common.reflect.TypeToken;
import com.soft.blued.ui.msg.MsgPreferences;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.utils.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/RecentPhotoManager.class */
public class RecentPhotoManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32437a = "CHAT_" + RecentPhotoManager.class.getSimpleName();
    private static int b = 5;

    /* renamed from: c  reason: collision with root package name */
    private static int f32438c = 5;
    private Vector<MsgRecentPhotoInfo> d = new Vector<>();
    private Vector<MsgRecentPhotoInfo> e = new Vector<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/RecentPhotoManager$IRecordPicCallback.class */
    public interface IRecordPicCallback {
        void a();
    }

    public RecentPhotoManager() {
        try {
            ThreadManager.a().a(new ThreadExecutor("RecentPhoto_Thread") { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.1
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    RecentPhotoManager.this.d();
                }
            });
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<MsgRecentPhotoInfo> list) {
        String str;
        try {
            str = AppInfo.f().toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MsgPreferences.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i;
        String b2 = MsgPreferences.b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        try {
            List list = (List) AppInfo.f().fromJson(b2, new TypeToken<ArrayList<MsgRecentPhotoInfo>>() { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.5
            }.getType());
            if (list != null) {
                if (list.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= list.size()) {
                            break;
                        }
                        MsgRecentPhotoInfo msgRecentPhotoInfo = (MsgRecentPhotoInfo) list.get(i3);
                        if (msgRecentPhotoInfo == null) {
                            list.remove(i3);
                        } else {
                            i = i3;
                            if (new File(msgRecentPhotoInfo.imgPath).exists()) {
                                i2 = i + 1;
                            } else {
                                list.remove(i3);
                            }
                        }
                        i = i3 - 1;
                        i2 = i + 1;
                    }
                }
                List list2 = list;
                if (list.size() > b) {
                    list2 = list.subList(0, b);
                }
                synchronized (this.e) {
                    this.d.clear();
                    this.d.addAll(list2);
                }
                e();
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.e) {
            this.e.clear();
            int min = Math.min(this.d.size(), f32438c);
            if (min > 0) {
                this.e.addAll(this.d.subList(0, min));
            }
        }
    }

    public MsgRecentPhotoInfo a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MsgRecentPhotoInfo msgRecentPhotoInfo = new MsgRecentPhotoInfo();
        msgRecentPhotoInfo.imgPath = str;
        msgRecentPhotoInfo.width = i;
        msgRecentPhotoInfo.height = i2;
        return msgRecentPhotoInfo;
    }

    public List<MsgRecentPhotoInfo> a() {
        return this.e;
    }

    public void a(final IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback) {
        if (this.e.size() <= 0) {
            ThreadManager.a().a(new ThreadExecutor("RecentPhoto_Thread") { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.2
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    RecentPhotoManager.this.d();
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iGetPhotoListCallback != null) {
                                iGetPhotoListCallback.a(RecentPhotoManager.this.e);
                            }
                        }
                    });
                }
            });
        } else if (iGetPhotoListCallback != null) {
            iGetPhotoListCallback.a(this.e);
        }
    }

    public void a(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        this.d.remove(msgRecentPhotoInfo);
        this.e.remove(msgRecentPhotoInfo);
        ThreadManager.a().a((Runnable) new ThreadExecutor("RecentPhoto_Thread") { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.6
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                RecentPhotoManager recentPhotoManager = RecentPhotoManager.this;
                recentPhotoManager.a(recentPhotoManager.d);
            }
        });
    }

    public void a(final MsgRecentPhotoInfo msgRecentPhotoInfo, final IRecordPicCallback iRecordPicCallback) {
        if (msgRecentPhotoInfo == null || TextUtils.isEmpty(msgRecentPhotoInfo.imgPath)) {
            Logger.c(f32437a, "photoInfo == null || TextUtils.isEmpty(photoInfo.imgPath) ！！！");
        } else {
            ThreadManager.a().a((Runnable) new ThreadExecutor("RecentPhoto_Thread") { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.4
                /* JADX WARN: Can't wrap try/catch for region: R(9:1|(11:3|(1:5)|95|96|7|(1:9)(2:91|(1:93)(1:94))|10|f3|78|79|(2:81|82)(1:84))|100|95|96|7|(0)(0)|10|f3) */
                /* JADX WARN: Code restructure failed: missing block: B:11:0x008d, code lost:
                    com.blued.android.core.imagecache.MemoryRequest.a().b();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
                    if (r0 != 270) goto L7;
                 */
                /* JADX WARN: Removed duplicated region for block: B:14:0x00b1  */
                /* JADX WARN: Removed duplicated region for block: B:15:0x00bc  */
                /* JADX WARN: Removed duplicated region for block: B:93:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // com.blued.android.framework.pool.ThreadExecutor
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void execute() {
                    /*
                        Method dump skipped, instructions count: 649
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.manager.RecentPhotoManager.AnonymousClass4.execute():void");
                }
            });
        }
    }

    public void b() {
        this.d.clear();
        this.e.clear();
        MsgPreferences.a(null);
    }

    public void b(final IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback) {
        ThreadManager.a().a((Runnable) new ThreadExecutor("GetSelectPhotoThreadName") { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.3
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                ArrayList arrayList = new ArrayList();
                ArrayList<MsgRecentPhotoInfo> arrayList2 = new ArrayList();
                arrayList2.addAll(RecentPhotoManager.this.e);
                for (MsgRecentPhotoInfo msgRecentPhotoInfo : arrayList2) {
                    if (msgRecentPhotoInfo != null && msgRecentPhotoInfo.isSelected) {
                        arrayList.add(msgRecentPhotoInfo);
                    }
                }
                IRecentPhotoAdapterCallback.IGetPhotoListCallback iGetPhotoListCallback2 = iGetPhotoListCallback;
                if (iGetPhotoListCallback2 != null) {
                    iGetPhotoListCallback2.a(arrayList);
                }
            }
        });
    }

    public void b(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        Iterator<MsgRecentPhotoInfo> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MsgRecentPhotoInfo next = it.next();
            if (TextUtils.equals(next.imgPath, msgRecentPhotoInfo.imgPath)) {
                next.isYellow = true;
                break;
            }
        }
        Iterator<MsgRecentPhotoInfo> it2 = this.d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            MsgRecentPhotoInfo next2 = it2.next();
            if (TextUtils.equals(next2.imgPath, msgRecentPhotoInfo.imgPath)) {
                next2.isYellow = true;
                break;
            }
        }
        ThreadManager.a().a((Runnable) new ThreadExecutor("RecentPhoto_Thread") { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.7
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                RecentPhotoManager recentPhotoManager = RecentPhotoManager.this;
                recentPhotoManager.a(recentPhotoManager.d);
            }
        });
    }

    public void c(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        this.d.remove(msgRecentPhotoInfo);
        this.e.remove(msgRecentPhotoInfo);
        msgRecentPhotoInfo.isPin = !msgRecentPhotoInfo.isPin;
        int i = 0;
        if (msgRecentPhotoInfo.isPin) {
            this.d.add(0, msgRecentPhotoInfo);
            this.e.add(0, msgRecentPhotoInfo);
        } else {
            while (true) {
                if (i >= this.e.size()) {
                    i = -1;
                    break;
                } else if (!this.e.get(i).isPin) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                this.e.add(msgRecentPhotoInfo);
                int size = this.d.size();
                int i2 = f32438c;
                if (size >= i2) {
                    this.d.add(i2 - 1, msgRecentPhotoInfo);
                } else {
                    this.d.add(msgRecentPhotoInfo);
                }
            } else {
                this.e.add(i, msgRecentPhotoInfo);
                if (this.d.size() > i) {
                    this.d.add(i, msgRecentPhotoInfo);
                }
            }
        }
        ThreadManager.a().a((Runnable) new ThreadExecutor("RecentPhoto_Thread") { // from class: com.soft.blued.ui.msg.manager.RecentPhotoManager.8
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                RecentPhotoManager recentPhotoManager = RecentPhotoManager.this;
                recentPhotoManager.a(recentPhotoManager.d);
            }
        });
    }
}
