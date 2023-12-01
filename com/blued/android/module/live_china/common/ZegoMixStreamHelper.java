package com.blued.android.module.live_china.common;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.RecordingMultiConnectionManager;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.zego.zegoavkit2.mixstream.IZegoMixStreamExCallback;
import com.zego.zegoavkit2.mixstream.IZegoSoundLevelInMixStreamCallback;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamConfig;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamInfo;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamOutput;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamResultEx;
import com.zego.zegoavkit2.mixstream.ZegoSoundLevelInMixStreamInfo;
import com.zego.zegoavkit2.mixstream.ZegoStreamMixer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/common/ZegoMixStreamHelper.class */
public class ZegoMixStreamHelper implements IZegoMixStreamExCallback, IZegoSoundLevelInMixStreamCallback {

    /* renamed from: c  reason: collision with root package name */
    private static ZegoMixStreamHelper f11733c;
    private ZegoStreamMixer d = null;
    private ZegoMixStreamConfig e = null;
    private List<ZegoMixStreamInfo> f = new ArrayList();
    private MixStreamCallback g = null;
    private String h = "rtmp://pili-publish.blued.cn/blued/test-zego-deploy-1?key=e437838e9cc37958";
    private String i = "";

    /* renamed from: a  reason: collision with root package name */
    List<String> f11734a = new ArrayList();
    List<String> b = new ArrayList();
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private int m = 0;
    private List<String> n = new ArrayList();
    private List<String> o = new ArrayList();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/common/ZegoMixStreamHelper$MixStreamCallback.class */
    public interface MixStreamCallback {
        void a(int i);

        void a(ArrayList<ZegoSoundLevelInMixStreamInfo> arrayList);
    }

    public static ZegoMixStreamHelper a() {
        synchronized (ZegoMixStreamHelper.class) {
            try {
                if (f11733c == null) {
                    f11733c = new ZegoMixStreamHelper();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f11733c;
    }

    public int a(ZegoMixStreamInfo zegoMixStreamInfo, String str) {
        Log.i("==record", "addMixStreamInfo:" + str);
        if (!TextUtils.equals(str, LiveRoomManager.a().p().stream)) {
            Log.i("==record", "addMixStreamInfo Fail=========:" + str + " / " + LiveRoomManager.a().p().stream);
            return 0;
        }
        Iterator<ZegoMixStreamInfo> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ZegoMixStreamInfo next = it.next();
            if (next != null && TextUtils.equals(next.streamID, zegoMixStreamInfo.streamID)) {
                Log.i("==record", "remove MixStreamInfo:" + next.streamID);
                this.f.remove(next);
                break;
            }
        }
        this.f.add(zegoMixStreamInfo);
        h();
        return a(str);
    }

    public int a(String str) {
        Log.i("==record mixConfig", "startMixStream:" + str);
        Log.i("==record mixConfig", "room stream:" + LiveRoomManager.a().p().stream);
        Log.i("==record mixConfig", "mOutputURL:" + this.h);
        if (!TextUtils.equals(str, LiveRoomManager.a().p().stream)) {
            Log.i("==record", "startMixStream Fail=========:" + str + " / " + LiveRoomManager.a().p().stream);
            return 0;
        }
        if (this.d == null) {
            this.d = new ZegoStreamMixer();
        }
        int size = this.f.size();
        ZegoMixStreamInfo[] zegoMixStreamInfoArr = new ZegoMixStreamInfo[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            zegoMixStreamInfoArr[i2] = this.f.get(i2);
            i = i2 + 1;
        }
        if (this.e == null) {
            this.e = new ZegoMixStreamConfig();
        }
        this.e.outputBitrate = ZegoCommonHelper.b().m;
        this.e.outputFps = ZegoCommonHelper.b().l;
        this.e.outputWidth = ZegoCommonHelper.b().h;
        this.e.outputHeight = ZegoCommonHelper.b().i;
        Log.i("==record mixConfig", "outputWidth:" + this.e.outputWidth + "  outputHeight:" + this.e.outputHeight);
        StringBuilder sb = new StringBuilder();
        sb.append("outputFps:");
        sb.append(this.e.outputFps);
        Log.i("==record mixConfig", sb.toString());
        Log.i("==record mixConfig", "outputBitrate:" + this.e.outputBitrate);
        this.e.inputStreamList = zegoMixStreamInfoArr;
        ZegoMixStreamOutput zegoMixStreamOutput = new ZegoMixStreamOutput();
        zegoMixStreamOutput.isUrl = true;
        zegoMixStreamOutput.target = this.h;
        this.e.outputList = new ZegoMixStreamOutput[]{zegoMixStreamOutput};
        this.e.withSoundLevel = false;
        this.e.outputAudioConfig = 1;
        this.i = "mixStream-" + LiveRoomManager.a().e() + "-" + LiveRoomManager.a().g();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mix stream id:");
        sb2.append(this.i);
        Log.i("==record", sb2.toString());
        ZegoStreamMixer zegoStreamMixer = this.d;
        int i3 = 0;
        if (zegoStreamMixer != null) {
            i3 = zegoStreamMixer.mixStreamEx(this.e, this.i);
            Log.i("==record", "mixStreamEx result:" + i3);
        }
        return i3;
    }

    public void a(MixStreamCallback mixStreamCallback) {
        if (this.d == null) {
            this.d = new ZegoStreamMixer();
        }
        this.d.setMixStreamExCallback(this);
        this.d.setSoundLevelInMixStreamCallback(this);
        this.g = mixStreamCallback;
    }

    public void a(String str, String str2) {
        Log.i("==makelover==", "handleMixStreamDeleted:" + str2);
        if (TextUtils.equals(str2, LiveRoomManager.a().p().stream)) {
            Iterator<ZegoMixStreamInfo> it = this.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ZegoMixStreamInfo next = it.next();
                if (str.equals(next.streamID)) {
                    this.f.remove(next);
                    break;
                }
            }
            h();
            a(str2);
        }
    }

    public void a(String str, String str2, boolean z) {
        List<ZegoMixStreamInfo> list;
        ZegoMixStreamInfo zegoMixStreamInfo;
        if (TextUtils.isEmpty(str) || (list = this.f) == null || list.isEmpty() || !TextUtils.equals(str2, LiveRoomManager.a().p().stream)) {
            return;
        }
        Iterator<ZegoMixStreamInfo> it = this.f.iterator();
        while (true) {
            zegoMixStreamInfo = null;
            if (!it.hasNext()) {
                break;
            }
            zegoMixStreamInfo = it.next();
            if (zegoMixStreamInfo != null && TextUtils.equals(zegoMixStreamInfo.streamID, str)) {
                Log.i("==record", "remove MixStreamInfo:" + zegoMixStreamInfo.streamID);
                break;
            }
        }
        if (zegoMixStreamInfo == null) {
            return;
        }
        zegoMixStreamInfo.volume = z ? 0 : 100;
        a(zegoMixStreamInfo, str2);
    }

    public void a(List<LiveInviteUserModel> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        String str = list.get(0).stream_id;
        if (!TextUtils.equals(str, LiveRoomManager.a().p().stream)) {
            return;
        }
        this.f.clear();
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                a(arrayList, arrayList2);
                h();
                a(str);
                return;
            }
            LiveInviteUserModel liveInviteUserModel = list.get(i2);
            arrayList.add(liveInviteUserModel.uid);
            arrayList2.add(liveInviteUserModel.lid);
            int i3 = ZegoCommonHelper.b().h / 2;
            int i4 = (int) (i3 * RecordingMultiConnectionManager.e);
            ZegoMixStreamInfo zegoMixStreamInfo = new ZegoMixStreamInfo();
            zegoMixStreamInfo.streamID = liveInviteUserModel.stream_id;
            if (i2 == 0) {
                if (size <= 3) {
                    zegoMixStreamInfo.left = 0;
                    int i5 = i4 * 2;
                    zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i5) / 2;
                    zegoMixStreamInfo.right = i3;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i5;
                } else {
                    zegoMixStreamInfo.left = 0;
                    zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - (i4 * 2)) / 2;
                    zegoMixStreamInfo.right = i3;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i4;
                }
            } else if (i2 == 1) {
                if (size <= 2) {
                    zegoMixStreamInfo.left = i3;
                    int i6 = i4 * 2;
                    zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - i6) / 2;
                    zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i6;
                } else {
                    zegoMixStreamInfo.left = i3;
                    zegoMixStreamInfo.top = (ZegoCommonHelper.b().i - (i4 * 2)) / 2;
                    zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i4;
                }
            } else if (i2 == 2) {
                if (size <= 3) {
                    zegoMixStreamInfo.left = i3;
                    zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i4 * 2)) / 2) + i4;
                    zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i4;
                } else {
                    zegoMixStreamInfo.left = 0;
                    zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i4 * 2)) / 2) + i4;
                    zegoMixStreamInfo.right = i3;
                    zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i4;
                }
            } else if (i2 == 3) {
                zegoMixStreamInfo.left = i3;
                zegoMixStreamInfo.top = ((ZegoCommonHelper.b().i - (i4 * 2)) / 2) + i4;
                zegoMixStreamInfo.right = ZegoCommonHelper.b().h;
                zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i4;
            }
            this.f.add(zegoMixStreamInfo);
            i = i2 + 1;
        }
    }

    public void a(List<String> list, List<String> list2) {
        this.f11734a.clear();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next())) {
                    it.remove();
                }
            }
            this.f11734a.addAll(list);
        }
        this.b.clear();
        if (list2 != null) {
            Iterator<String> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (TextUtils.isEmpty(it2.next())) {
                    it2.remove();
                }
            }
            this.b.addAll(list2);
        }
    }

    public void b() {
        this.f.clear();
    }

    public void b(String str) {
        this.h = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.common.ZegoMixStreamHelper.b(java.lang.String, java.lang.String):void");
    }

    public void c() {
        if (this.d != null) {
            this.d = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        f11733c = null;
    }

    public void c(String str) {
        Log.i("==record", "stopMixStream:" + str);
        if (TextUtils.equals(str, LiveRoomManager.a().p().stream)) {
            this.f.clear();
            h();
            a(str);
            return;
        }
        Log.i("==record", "stopMixStream Fail=========:" + str + " / " + LiveRoomManager.a().p().stream);
    }

    public String d() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.n.size()) {
                break;
            }
            boolean z = false;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (TextUtils.equals((CharSequence) arrayList.get(i3), this.n.get(i2))) {
                    z = true;
                }
            }
            if (!z && !TextUtils.equals(this.n.get(i2), LiveRoomInfo.a().f()) && StringUtils.a(this.n.get(i2), 0L) != 0) {
                arrayList.add(this.n.get(i2));
            }
            i = i2 + 1;
        }
        String str = "";
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= arrayList.size()) {
                return str;
            }
            str = i5 == 0 ? (String) arrayList.get(0) : str + "," + ((String) arrayList.get(i5));
            i4 = i5 + 1;
        }
    }

    public String e() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.o.size()) {
                break;
            }
            boolean z = false;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (TextUtils.equals((CharSequence) arrayList.get(i3), this.o.get(i2))) {
                    z = true;
                }
            }
            if (!z) {
                if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
                    if (!TextUtils.equals(this.o.get(i2), LiveRoomManager.a().e()) && StringUtils.a(this.o.get(i2), 0L) != 0) {
                        arrayList.add(this.o.get(i2));
                    }
                } else if (StringUtils.a(this.o.get(i2), 0L) != 0) {
                    arrayList.add(this.o.get(i2));
                }
            }
            i = i2 + 1;
        }
        String str = "";
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= arrayList.size()) {
                return str;
            }
            str = i5 == 0 ? (String) arrayList.get(0) : str + "," + ((String) arrayList.get(i5));
            i4 = i5 + 1;
        }
    }

    public void f() {
        this.n.clear();
        this.n.addAll(this.f11734a);
        this.o.clear();
        this.o.addAll(this.b);
    }

    public void g() {
        this.f11734a.clear();
        this.b.clear();
        this.n.clear();
        this.o.clear();
    }

    public void h() {
        Log.i("==iop", "reportZegoRtcTime0 mMixStreamInfos size:" + this.f.size() + "  uid:" + d() + " lid:" + e() + "  startTime:" + this.j + " endTime:" + this.k);
        if (this.m > 0 && this.j != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.k = currentTimeMillis;
            long j = currentTimeMillis - this.j;
            int i = this.m;
            this.l = ((i - 1) * j) + (i * j);
            Log.i("==iop", "reportZegoRtcTime1 value:" + j + " lastStreamSize:" + this.m + " duration:" + this.l + "  uid:" + d() + " lid:" + e() + "  startTime:" + this.j + " endTime:" + this.k);
            if (this.l > 1) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_CALL_END, d(), e(), this.j, this.k, this.l);
            }
        }
        if (this.f.size() > 0) {
            this.j = System.currentTimeMillis() / 1000;
            f();
        } else {
            this.j = 0L;
            g();
        }
        this.m = this.f.size();
    }

    @Override // com.zego.zegoavkit2.mixstream.IZegoMixStreamExCallback
    public void onMixStreamExConfigUpdate(int i, String str, ZegoMixStreamResultEx zegoMixStreamResultEx) {
        MixStreamCallback mixStreamCallback = this.g;
        if (mixStreamCallback != null) {
            mixStreamCallback.a(i);
        }
    }

    @Override // com.zego.zegoavkit2.mixstream.IZegoSoundLevelInMixStreamCallback
    public void onSoundLevelInMixStream(ArrayList<ZegoSoundLevelInMixStreamInfo> arrayList) {
        MixStreamCallback mixStreamCallback = this.g;
        if (mixStreamCallback != null) {
            mixStreamCallback.a(arrayList);
        }
    }
}
