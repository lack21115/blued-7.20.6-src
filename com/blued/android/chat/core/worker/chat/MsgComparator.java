package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.model.ChattingModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/MsgComparator.class */
public class MsgComparator implements Comparator<ChattingModel> {

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/MsgComparator$FillInterval.class */
    public static final class FillInterval {
        long endId;
        long startId;

        public FillInterval(long j, long j2) {
            this.startId = j;
            this.endId = j2;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/MsgComparator$MsgPairComparator.class */
    static class MsgPairComparator implements Comparator<ChattingModel> {
        private MsgPairComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ChattingModel chattingModel, ChattingModel chattingModel2) {
            return new MsgComparator().compare(chattingModel, chattingModel2);
        }
    }

    public static FillInterval getFillTaskIntervalBySortedMsg(ChattingModel chattingModel, List<ChattingModel> list) {
        long j;
        long j2;
        boolean z;
        int size = list.size();
        ChattingModel chattingModel2 = chattingModel;
        if (chattingModel == null) {
            chattingModel2 = list.get(size - 1);
        }
        long j3 = chattingModel2.msgPreviousId;
        long j4 = chattingModel2.msgId;
        boolean z2 = false;
        long j5 = list.get(0).msgId;
        int i = size - 1;
        while (i >= 0) {
            ChattingModel chattingModel3 = list.get(i);
            if (j3 == chattingModel3.msgId) {
                j = j4;
                j2 = j5;
                z = z2;
                if (!z2) {
                    j = chattingModel3.msgId;
                    j2 = j5;
                    z = z2;
                }
            } else {
                j = j4;
                j2 = j5;
                z = z2;
                if (j3 > chattingModel3.msgId) {
                    j2 = chattingModel3.msgId;
                    z = true;
                    j = j4;
                }
            }
            j3 = chattingModel3.msgPreviousId;
            i--;
            j4 = j;
            j5 = j2;
            z2 = z;
        }
        if (j4 > 1 + j5) {
            return new FillInterval(j5, j4);
        }
        return null;
    }

    public static void mergeSortedList(List<ChattingModel> list, ChattingModel chattingModel) {
        int i;
        if (list == null || chattingModel == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(chattingModel);
            return;
        }
        MsgComparator msgComparator = new MsgComparator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= size) {
                break;
            }
            int compare = msgComparator.compare(list.get(i), chattingModel);
            if (compare == 0) {
                list.set(i, chattingModel);
                break;
            } else if (compare > 0) {
                list.add(i, chattingModel);
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i == size) {
            list.add(chattingModel);
        }
    }

    public static void mergeSortedList(List<ChattingModel> list, List<ChattingModel> list2) {
        int i;
        int i2;
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size == 0 || size2 == 0) {
            list.addAll(list2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        MsgComparator msgComparator = new MsgComparator();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i3;
            if (i3 >= size) {
                break;
            }
            i = i3;
            if (i4 >= size2) {
                break;
            }
            ChattingModel chattingModel = list.get(i3);
            ChattingModel chattingModel2 = list2.get(i4);
            int compare = msgComparator.compare(chattingModel, chattingModel2);
            if (compare == 0) {
                arrayList.add(chattingModel2);
                i3++;
            } else if (compare > 0) {
                arrayList.add(chattingModel2);
            } else {
                arrayList.add(chattingModel);
                i3++;
            }
            i4++;
        }
        while (true) {
            if (i >= size) {
                break;
            }
            arrayList.add(list.get(i));
            i++;
        }
        for (i2 = i4; i2 < size2; i2++) {
            arrayList.add(list2.get(i2));
        }
        list.clear();
        list.addAll(arrayList);
    }

    private static void removeDuplicatedSorted(List<ChattingModel> list) {
        MsgComparator msgComparator = new MsgComparator();
        ArrayList arrayList = new ArrayList();
        ChattingModel chattingModel = null;
        for (ChattingModel chattingModel2 : list) {
            if (msgComparator.compare(chattingModel, chattingModel2) != 0) {
                arrayList.add(chattingModel2);
            } else if (chattingModel2.dbId > chattingModel.dbId) {
                arrayList.remove(chattingModel);
                arrayList.add(chattingModel2);
            }
            chattingModel = chattingModel2;
        }
        list.clear();
        list.addAll(arrayList);
    }

    public static void sortAndDistinct(List<ChattingModel> list) {
        Collections.sort(list, new MsgComparator());
        removeDuplicatedSorted(list);
    }

    public static void sortPair(List<ChattingModel> list) {
        Collections.sort(list, new MsgPairComparator());
    }

    @Override // java.util.Comparator
    public int compare(ChattingModel chattingModel, ChattingModel chattingModel2) {
        int i;
        if (chattingModel == null && chattingModel2 == null) {
            return 0;
        }
        if (chattingModel == null) {
            return -1;
        }
        if (chattingModel2 == null) {
            return 1;
        }
        int i2 = ((chattingModel.msgId - chattingModel2.msgId) > 0L ? 1 : ((chattingModel.msgId - chattingModel2.msgId) == 0L ? 0 : -1));
        if (i2 != 0) {
            return i2 > 0 ? 1 : -1;
        }
        int i3 = ((chattingModel.msgLocalId - chattingModel2.msgLocalId) > 0L ? 1 : ((chattingModel.msgLocalId - chattingModel2.msgLocalId) == 0L ? 0 : -1));
        if (i3 != 0) {
            return i3 > 0 ? 1 : -1;
        } else if (chattingModel.msgId == 0 && chattingModel.msgLocalId == 0 && chattingModel.msgTimestamp - chattingModel2.msgTimestamp != 0) {
            return i > 0 ? 1 : -1;
        } else {
            return 0;
        }
    }
}
