package com.blued.android.module.live_china.manager;

import android.os.Handler;
import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.model.LiveBunchLightModel;
import com.blued.android.module.live_china.model.LiveBunchLightResponseModel;
import com.blued.android.module.live_china.model.LiveImgModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveBunchLightTaskManager.class */
public final class LiveBunchLightTaskManager {
    private final LiveBaseFragment a;
    private final Handler b;
    private final ArrayList<LiveBunchLightModel> c;
    private long d;
    private long e;

    public LiveBunchLightTaskManager(LiveBaseFragment fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = fragmentActive;
        this.b = new Handler();
        this.c = new ArrayList<>();
    }

    private final void a(int i, int i2) {
        LiveRoomHttpUtils.a(i, i2, this.a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBunchLightTaskManager this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    private final void b() {
        ArrayList<LiveBunchLightModel> arrayList = this.c;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        long j = 1000;
        long currentTimeMillis = (this.d + (System.currentTimeMillis() / j)) - this.e;
        long j2 = -1;
        for (LiveBunchLightModel liveBunchLightModel : this.c) {
            if (liveBunchLightModel.getTaskList() == null) {
                liveBunchLightModel.setTaskList(new ArrayList<>());
                long end_time = (liveBunchLightModel.getEnd_time() - liveBunchLightModel.getStart_time()) / (liveBunchLightModel.getFrequency() * 60);
                if (0 <= end_time) {
                    long j3 = 0;
                    while (true) {
                        long j4 = j3;
                        ArrayList<Long> taskList = liveBunchLightModel.getTaskList();
                        if (taskList != null) {
                            taskList.add(Long.valueOf(liveBunchLightModel.getStart_time() + (liveBunchLightModel.getFrequency() * j4 * 60)));
                        }
                        if (j4 == end_time) {
                            break;
                        }
                        j3 = j4 + 1;
                    }
                }
            }
            ArrayList<Long> taskList2 = liveBunchLightModel.getTaskList();
            Intrinsics.a(taskList2);
            int size = taskList2.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                ArrayList<Long> taskList3 = liveBunchLightModel.getTaskList();
                Intrinsics.a(taskList3);
                Long l = taskList3.get(i);
                Intrinsics.c(l, "it.taskList!![i]");
                long longValue = l.longValue();
                if (longValue > 0 && longValue >= currentTimeMillis) {
                    long j5 = longValue - currentTimeMillis;
                    if (j5 <= 1) {
                        a(liveBunchLightModel.getTask_id(), liveBunchLightModel.getLantern_id());
                        ArrayList<Long> taskList4 = liveBunchLightModel.getTaskList();
                        Intrinsics.a(taskList4);
                        taskList4.set(i, -1L);
                    } else if (j2 < 0) {
                        i = i2;
                        j2 = j5;
                    } else {
                        j2 = Math.min(j2, j5);
                    }
                }
                i = i2;
            }
        }
        if (j2 > 0) {
            this.b.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveBunchLightTaskManager$5y7lcynBCmLPYfh7IBLku0UL118
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBunchLightTaskManager.a(LiveBunchLightTaskManager.this);
                }
            }, j2 * j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveBunchLightTaskManager this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    private final void c() {
        long j = 1000;
        long currentTimeMillis = (this.d + (System.currentTimeMillis() / j)) - this.e;
        long j2 = -1;
        for (LiveBunchLightModel liveBunchLightModel : this.c) {
            ArrayList<Long> taskList = liveBunchLightModel.getTaskList();
            if (taskList == null || taskList.isEmpty()) {
                return;
            }
            ArrayList<Long> taskList2 = liveBunchLightModel.getTaskList();
            Intrinsics.a(taskList2);
            int size = taskList2.size();
            int i = 0;
            long j3 = j2;
            while (true) {
                j2 = j3;
                if (i < size) {
                    ArrayList<Long> taskList3 = liveBunchLightModel.getTaskList();
                    Intrinsics.a(taskList3);
                    Long l = taskList3.get(i);
                    Intrinsics.c(l, "it.taskList!![i]");
                    long longValue = l.longValue();
                    if (longValue > 0 && longValue >= currentTimeMillis) {
                        long j4 = longValue - currentTimeMillis;
                        if (j4 <= 1) {
                            a(liveBunchLightModel.getTask_id(), liveBunchLightModel.getLantern_id());
                            ArrayList<Long> taskList4 = liveBunchLightModel.getTaskList();
                            Intrinsics.a(taskList4);
                            taskList4.set(i, -1L);
                        } else {
                            j3 = j3 < 0 ? j4 : Math.min(j3, j4);
                        }
                    }
                    i++;
                }
            }
        }
        if (j2 > 0) {
            this.b.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveBunchLightTaskManager$kFpCxGYOUXQT6VR0MHMWXQJ5y2E
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBunchLightTaskManager.b(LiveBunchLightTaskManager.this);
                }
            }, j2 * j);
        }
    }

    public final void a() {
        this.c.clear();
        this.b.removeCallbacksAndMessages(null);
    }

    public final void a(List<LiveBunchLightResponseModel> taskList, long j) {
        Intrinsics.e(taskList, "taskList");
        if (taskList.isEmpty() || j <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (LiveBunchLightResponseModel liveBunchLightResponseModel : taskList) {
            LiveBunchLightModel liveBunchLightModel = new LiveBunchLightModel();
            liveBunchLightModel.setTask_id(liveBunchLightResponseModel.getTask_id());
            liveBunchLightModel.setLantern_id(liveBunchLightResponseModel.getLantern_id());
            liveBunchLightModel.setStart_time(liveBunchLightResponseModel.getStart_time());
            liveBunchLightModel.setEnd_time(liveBunchLightResponseModel.getEnd_time());
            liveBunchLightModel.setFrequency(liveBunchLightResponseModel.getFrequency());
            liveBunchLightModel.setPlay_times(liveBunchLightResponseModel.getPlay_times());
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<LiveImgModel> image = liveBunchLightResponseModel.getImage();
            if (image != null) {
                for (LiveImgModel liveImgModel : image) {
                    arrayList2.add(liveImgModel.getImg());
                }
            }
            liveBunchLightModel.setImage(arrayList2);
            arrayList.add(liveBunchLightModel);
        }
        b(arrayList, j);
    }

    public final void b(List<LiveBunchLightModel> taskList, long j) {
        Intrinsics.e(taskList, "taskList");
        if (taskList.isEmpty() || j <= 0) {
            return;
        }
        a();
        this.c.addAll(taskList);
        this.d = j;
        this.e = System.currentTimeMillis() / 1000;
        b();
    }
}
