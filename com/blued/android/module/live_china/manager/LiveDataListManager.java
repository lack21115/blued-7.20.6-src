package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveDataListManager.class */
public class LiveDataListManager {
    private static LiveDataListManager b;
    private List<LiveRoomData> a = new ArrayList();

    private LiveDataListManager() {
    }

    public static LiveDataListManager a() {
        if (b == null) {
            b = new LiveDataListManager();
        }
        return b;
    }

    private static void a(Context context, LiveRoomData liveRoomData, int i) {
        PlayingOnliveFragment.a(context, liveRoomData, i, a().b());
    }

    public void a(LiveRoomData liveRoomData) {
        int i;
        if (liveRoomData == null) {
            return;
        }
        if (this.a.size() == 0) {
            this.a.add(liveRoomData);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a);
        Iterator<E> it = arrayList.iterator();
        while (it.hasNext()) {
            LiveRoomData liveRoomData2 = (LiveRoomData) it.next();
            if (liveRoomData2 == null) {
                it.remove();
            } else if (liveRoomData2.lid == liveRoomData.lid) {
                it.remove();
            }
        }
        this.a.clear();
        this.a.addAll(arrayList);
        long d = LiveRoomManager.a().d();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = -1;
            if (i3 >= this.a.size()) {
                break;
            } else if (this.a.get(i3).lid == d) {
                i = i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        if (i >= 0) {
            this.a.add(i + 1, liveRoomData);
        } else {
            this.a.add(liveRoomData);
        }
    }

    public void a(LiveRoomData liveRoomData, boolean z) {
        int i;
        if (liveRoomData == null) {
            return;
        }
        LiveRoomData liveRoomData2 = new LiveRoomData();
        ReflectionUtils.a(LiveRoomManager.a().p(), liveRoomData2);
        if (this.a.size() == 0 && liveRoomData2.lid > 0) {
            this.a.add(liveRoomData2);
        }
        long c = c();
        long d = d();
        if (z) {
            LiveRoomManager.a().b(liveRoomData2);
        }
        if (c == liveRoomData.lid) {
            LiveEventBus.get("live_auto_scroll_next").post(false);
        } else if (d == liveRoomData.lid) {
            LiveEventBus.get("live_auto_scroll_next").post(true);
        } else {
            List<LiveRoomData> b2 = b();
            if (b2 != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    i = -1;
                    if (i3 >= b2.size()) {
                        break;
                    } else if (b2.get(i3).lid == liveRoomData.lid) {
                        i = i3;
                        break;
                    } else {
                        i2 = i3 + 1;
                    }
                }
                if (i >= 0 && i < b2.size()) {
                    b2.remove(i);
                }
            }
            a(liveRoomData);
            LiveEventBus.get("live_auto_scroll_next").post(false);
        }
    }

    public void a(List<LiveRoomData> list) {
        synchronized (this) {
            this.a.clear();
            if (list != null && list.size() > 0) {
                b(list);
            }
        }
    }

    public boolean a(Context context, long j, int i, String str) {
        int i2;
        LiveRoomData liveRoomData;
        List<LiveRoomData> b2 = b();
        if (b2.size() == 1) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= b2.size()) {
                return false;
            }
            if (b2.get(i4).lid == j) {
                if (i == 0) {
                    i2 = i4 + 1;
                    if (i2 == b2.size()) {
                        liveRoomData = b2.get(0);
                        i2 = 0;
                    } else {
                        liveRoomData = b2.get(i2);
                    }
                } else if (i4 == 0) {
                    liveRoomData = b2.get(b2.size() - 1);
                    i2 = b2.size() - 1;
                } else {
                    i2 = i4 - 1;
                    liveRoomData = b2.get(i2);
                }
                if (liveRoomData.lid == 0) {
                    return false;
                }
                liveRoomData.comeCode = str;
                a(context, liveRoomData, i2);
                return true;
            }
            i3 = i4 + 1;
        }
    }

    public boolean a(Context context, LiveRoomData liveRoomData, int i, String str) {
        if (liveRoomData.lid == 0) {
            return false;
        }
        liveRoomData.comeCode = str;
        a(context, liveRoomData, i);
        return true;
    }

    public List<LiveRoomData> b() {
        return this.a;
    }

    public void b(LiveRoomData liveRoomData) {
        a(liveRoomData, true);
    }

    public void b(List<LiveRoomData> list) {
        synchronized (this) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (LiveRoomData liveRoomData : this.a) {
                    if (liveRoomData != null) {
                        arrayList.add(Long.valueOf(liveRoomData.lid));
                    }
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    if (!arrayList.contains(Long.valueOf(list.get(i2).lid)) && list.get(i2).lid > 0 && list.get(i2).profile != null && !TextUtils.isEmpty(list.get(i2).profile.uid)) {
                        arrayList.add(Long.valueOf(list.get(i2).lid));
                        this.a.add(list.get(i2));
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public long c() {
        if (LiveRoomManager.a().d() == 0) {
            return 0L;
        }
        List<LiveRoomData> b2 = b();
        if (b2.size() == 0) {
            return 0L;
        }
        long d = LiveRoomManager.a().d();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b2.size()) {
                return 0L;
            }
            if (b2.get(i2).lid == d && i2 < b2.size() - 1) {
                return b2.get(i2 + 1).lid;
            }
            i = i2 + 1;
        }
    }

    public void c(List<LiveRoomData> list) {
        synchronized (this) {
            this.a.clear();
            if (list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    LiveRoomData liveRoomData = list.get(i2);
                    if (liveRoomData == null || liveRoomData.live_type != 0) {
                        this.a.add(liveRoomData);
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public long d() {
        if (LiveRoomManager.a().d() == 0) {
            return 0L;
        }
        List<LiveRoomData> b2 = b();
        if (b2.size() == 0) {
            return 0L;
        }
        long d = LiveRoomManager.a().d();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= b2.size()) {
                return 0L;
            }
            if (b2.get(i2).lid == d && i2 > 0) {
                return b2.get(i2 - 1).lid;
            }
            i = i2 + 1;
        }
    }
}
