package com.ss.android.socialbase.downloader.segment;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/SegmentUtils.class */
public class SegmentUtils {
    public static long getDownloadedBytes(List<Segment> list) {
        long j;
        long j2;
        long j3 = 0;
        loop0: while (true) {
            j = -1;
            j2 = -1;
            for (Segment segment : list) {
                if (j == -1) {
                    if (segment.getDownloadBytes() > 0) {
                        j = segment.getStartOffset();
                        j2 = segment.getCurrentOffset();
                    }
                } else if (segment.getStartOffset() > j2) {
                    long j4 = j3 + (j2 - j);
                    j3 = j4;
                    if (segment.getDownloadBytes() > 0) {
                        j = segment.getStartOffset();
                        j2 = segment.getCurrentOffset();
                        j3 = j4;
                    }
                } else if (segment.getCurrentOffset() > j2) {
                    j2 = segment.getCurrentOffset();
                }
            }
        }
        long j5 = j3;
        if (j >= 0) {
            j5 = j3;
            if (j2 > j) {
                j5 = j3 + (j2 - j);
            }
        }
        return j5;
    }

    public static long getFirstOffset(List<Segment> list) {
        int size = list.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            Segment segment = list.get(i);
            if (segment.getStartOffset() > j) {
                break;
            }
            long j2 = j;
            if (segment.getCurrentOffsetRead() > j) {
                j2 = segment.getCurrentOffsetRead();
            }
            i++;
            j = j2;
        }
        return j;
    }
}
