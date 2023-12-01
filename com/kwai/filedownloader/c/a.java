package com.kwai.filedownloader.c;

import android.content.ContentValues;
import com.kwai.filedownloader.e.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/c/a.class */
public final class a {
    private long aGT;
    private long aGU;
    private long aGV;
    private int id;
    private int index;

    public static long H(List<a> list) {
        Iterator<a> it = list.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            a next = it.next();
            j = j2 + (next.Ix() - next.getStartOffset());
        }
    }

    public final long Ix() {
        return this.aGU;
    }

    public final long Iy() {
        return this.aGV;
    }

    public final ContentValues Iz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.aGT));
        contentValues.put("currentOffset", Long.valueOf(this.aGU));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.aGV));
        return contentValues;
    }

    public final void am(long j) {
        this.aGU = j;
    }

    public final void an(long j) {
        this.aGV = j;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.aGT;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setStartOffset(long j) {
        this.aGT = j;
    }

    public final String toString() {
        return f.j("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.aGT), Long.valueOf(this.aGV), Long.valueOf(this.aGU));
    }
}
