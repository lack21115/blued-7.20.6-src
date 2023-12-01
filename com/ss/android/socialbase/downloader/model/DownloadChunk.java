package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/model/DownloadChunk.class */
public class DownloadChunk implements Parcelable {
    private int bindValueCount;
    private int chunkIndex;
    private DownloadChunkRunnable chunkRunnable;
    private long contentLength;
    private AtomicLong currentOffset;
    private long endOffset;
    private DownloadChunk hostChunk;
    private AtomicInteger hostChunkIndex;
    private int id;
    private AtomicBoolean isDownloading;
    private long oldOffset;
    private boolean reuseingFirstConnection;
    private long startOffset;
    private List<DownloadChunk> subChunkList;
    private static final String TAG = DownloadChunk.class.getSimpleName();
    public static final Parcelable.Creator<DownloadChunk> CREATOR = new Parcelable.Creator<DownloadChunk>() { // from class: com.ss.android.socialbase.downloader.model.DownloadChunk.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadChunk createFromParcel(Parcel parcel) {
            return new DownloadChunk(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadChunk[] newArray(int i) {
            return new DownloadChunk[i];
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/model/DownloadChunk$Builder.class */
    public static class Builder {
        private int chunkIndex;
        private long contentLength;
        private long currentOffset;
        private long endOffset;
        private DownloadChunk hostChunk;
        private int id;
        private long oldOffset;
        private long startOffset;

        public Builder(int i) {
            this.id = i;
        }

        public DownloadChunk build() {
            return new DownloadChunk(this);
        }

        public Builder chunkIndex(int i) {
            this.chunkIndex = i;
            return this;
        }

        public Builder contentLength(long j) {
            this.contentLength = j;
            return this;
        }

        public Builder currentOffset(long j) {
            this.currentOffset = j;
            return this;
        }

        public Builder endOffset(long j) {
            this.endOffset = j;
            return this;
        }

        public Builder hostChunk(DownloadChunk downloadChunk) {
            this.hostChunk = downloadChunk;
            return this;
        }

        public Builder id(int i) {
            this.id = i;
            return this;
        }

        public Builder oldOffset(long j) {
            this.oldOffset = j;
            return this;
        }

        public Builder startOffset(long j) {
            this.startOffset = j;
            return this;
        }
    }

    public DownloadChunk(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.id = cursor.getInt(cursor.getColumnIndex("_id"));
        this.chunkIndex = cursor.getInt(cursor.getColumnIndex(DBDefinition.CHUNK_INDEX));
        this.startOffset = cursor.getLong(cursor.getColumnIndex(DBDefinition.START_OFFSET));
        int columnIndex = cursor.getColumnIndex(DBDefinition.CUR_OFFSET);
        if (columnIndex != -1) {
            this.currentOffset = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.currentOffset = new AtomicLong(0L);
        }
        this.endOffset = cursor.getLong(cursor.getColumnIndex(DBDefinition.END_OFFSET));
        int columnIndex2 = cursor.getColumnIndex(DBDefinition.HOST_CHUNK_INDEX);
        if (columnIndex2 != -1) {
            this.hostChunkIndex = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.hostChunkIndex = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex(DBDefinition.CHUNK_CONTENT_LEN);
        if (columnIndex3 != -1) {
            this.contentLength = cursor.getLong(columnIndex3);
        }
        this.isDownloading = new AtomicBoolean(false);
    }

    protected DownloadChunk(Parcel parcel) {
        this.id = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.currentOffset = new AtomicLong(parcel.readLong());
        this.endOffset = parcel.readLong();
        this.contentLength = parcel.readLong();
        this.chunkIndex = parcel.readInt();
        this.hostChunkIndex = new AtomicInteger(parcel.readInt());
    }

    private DownloadChunk(Builder builder) {
        if (builder == null) {
            return;
        }
        this.id = builder.id;
        this.startOffset = builder.startOffset;
        this.currentOffset = new AtomicLong(builder.currentOffset);
        this.endOffset = builder.endOffset;
        this.contentLength = builder.contentLength;
        this.chunkIndex = builder.chunkIndex;
        this.oldOffset = builder.oldOffset;
        this.hostChunkIndex = new AtomicInteger(-1);
        setHostChunk(builder.hostChunk);
        this.isDownloading = new AtomicBoolean(false);
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i = this.bindValueCount + 1;
        this.bindValueCount = i;
        sQLiteStatement.bindLong(i, this.id);
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        sQLiteStatement.bindLong(i2, this.chunkIndex);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        sQLiteStatement.bindLong(i3, this.startOffset);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        sQLiteStatement.bindLong(i4, getCurrentOffset());
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        sQLiteStatement.bindLong(i5, this.endOffset);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        sQLiteStatement.bindLong(i6, this.contentLength);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, getHostChunkIndex());
    }

    public boolean canRefreshCurOffsetForReuseChunk() {
        DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk == null) {
            return true;
        }
        if (!downloadChunk.hasChunkDivided()) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hostChunk.getSubChunkList().size()) {
                return false;
            }
            DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i2);
            if (downloadChunk2 != null) {
                int indexOf = this.hostChunk.getSubChunkList().indexOf(this);
                if (indexOf > i2 && !downloadChunk2.hasNoBytesDownload()) {
                    return false;
                }
                if (indexOf == i2) {
                    return true;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DownloadChunk> divideChunkForReuse(int i, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        if (!isHostChunk() || hasChunkDivided()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long curOffset = getCurOffset();
        long retainLength = getRetainLength(true);
        long j8 = retainLength / i;
        String str = TAG;
        Logger.d(str, "retainLen:" + retainLength + " divideChunkForReuse chunkSize:" + j8 + " current host downloadChunk index:" + this.chunkIndex);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            if (i3 == 0) {
                j4 = getStartOffset();
                j3 = (curOffset + j8) - 1;
            } else {
                int i4 = i - 1;
                if (i3 == i4) {
                    long endOffset = getEndOffset();
                    j5 = endOffset > curOffset ? (endOffset - curOffset) + 1 : retainLength - (i4 * j8);
                    j6 = endOffset;
                    j7 = curOffset;
                    DownloadChunk build = new Builder(this.id).chunkIndex((-i3) - 1).startOffset(j7).currentOffset(curOffset).oldOffset(curOffset).endOffset(j6).contentLength(j5).hostChunk(this).build();
                    String str2 = TAG;
                    Logger.d(str2, "divide sub chunk : " + i3 + " startOffset:" + j7 + " curOffset:" + curOffset + " endOffset:" + j6 + " contentLen:" + j5);
                    arrayList.add(build);
                    curOffset += j8;
                    i2 = i3 + 1;
                } else {
                    j3 = (curOffset + j8) - 1;
                    j4 = curOffset;
                }
            }
            long j9 = j3;
            j5 = j8;
            j7 = j4;
            j6 = j9;
            DownloadChunk build2 = new Builder(this.id).chunkIndex((-i3) - 1).startOffset(j7).currentOffset(curOffset).oldOffset(curOffset).endOffset(j6).contentLength(j5).hostChunk(this).build();
            String str22 = TAG;
            Logger.d(str22, "divide sub chunk : " + i3 + " startOffset:" + j7 + " curOffset:" + curOffset + " endOffset:" + j6 + " contentLen:" + j5);
            arrayList.add(build2);
            curOffset += j8;
            i2 = i3 + 1;
        }
        int size = arrayList.size() - 1;
        long j10 = 0;
        while (true) {
            j2 = j10;
            if (size <= 0) {
                break;
            }
            DownloadChunk downloadChunk = arrayList.get(size);
            long j11 = j2;
            if (downloadChunk != null) {
                j11 = j2 + downloadChunk.getContentLength();
            }
            size--;
            j10 = j11;
        }
        String str3 = TAG;
        Logger.d(str3, "reuseChunkContentLen:" + j2);
        DownloadChunk downloadChunk2 = arrayList.get(0);
        if (downloadChunk2 != null) {
            downloadChunk2.setContentLength((getEndOffset() == 0 ? j - getStartOffset() : (getEndOffset() - getStartOffset()) + 1) - j2);
            downloadChunk2.setChunkIndex(this.chunkIndex);
            DownloadChunkRunnable downloadChunkRunnable = this.chunkRunnable;
            if (downloadChunkRunnable != null) {
                downloadChunkRunnable.refreshResponseHandleOffset(downloadChunk2.getEndOffset(), getContentLength() - j2);
            }
        }
        setSubChunkList(arrayList);
        return arrayList;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public int getChunkIndex() {
        return this.chunkIndex;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurOffset() {
        AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long getCurrentOffset() {
        if (isHostChunk() && hasChunkDivided()) {
            long j = 0;
            int i = 0;
            while (i < this.subChunkList.size()) {
                DownloadChunk downloadChunk = this.subChunkList.get(i);
                long j2 = j;
                if (downloadChunk != null) {
                    if (!downloadChunk.hasNoBytesDownload()) {
                        return downloadChunk.getCurOffset();
                    }
                    j2 = j;
                    if (j < downloadChunk.getCurOffset()) {
                        j2 = downloadChunk.getCurOffset();
                    }
                }
                i++;
                j = j2;
            }
            return j;
        }
        return getCurOffset();
    }

    public long getDownloadChunkBytes() {
        long currentOffset = getCurrentOffset() - this.startOffset;
        if (hasChunkDivided()) {
            long j = 0;
            int i = 0;
            while (true) {
                currentOffset = j;
                if (i >= this.subChunkList.size()) {
                    break;
                }
                DownloadChunk downloadChunk = this.subChunkList.get(i);
                long j2 = j;
                if (downloadChunk != null) {
                    j2 = j + (downloadChunk.getCurrentOffset() - downloadChunk.getStartOffset());
                }
                i++;
                j = j2;
            }
        }
        return currentOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public DownloadChunk getFirstReuseChunk() {
        DownloadChunk downloadChunk = !isHostChunk() ? this.hostChunk : this;
        if (downloadChunk == null || !downloadChunk.hasChunkDivided()) {
            return null;
        }
        return downloadChunk.getSubChunkList().get(0);
    }

    public DownloadChunk getHostChunk() {
        return this.hostChunk;
    }

    public int getHostChunkIndex() {
        AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public int getId() {
        return this.id;
    }

    public long getNextChunkCurOffset() {
        DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk == null || downloadChunk.getSubChunkList() == null) {
            return -1L;
        }
        int indexOf = this.hostChunk.getSubChunkList().indexOf(this);
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (i >= this.hostChunk.getSubChunkList().size()) {
                return -1L;
            }
            DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i);
            boolean z3 = z2;
            if (downloadChunk2 != null) {
                if (z2) {
                    return downloadChunk2.getCurrentOffset();
                }
                z3 = z2;
                if (indexOf == i) {
                    z3 = true;
                }
            }
            i++;
            z = z3;
        }
    }

    public long getOldOffset() {
        return this.oldOffset;
    }

    public long getRetainLength(boolean z) {
        long currentOffset = getCurrentOffset();
        long j = this.contentLength;
        long j2 = this.oldOffset;
        long j3 = j - (currentOffset - j2);
        long j4 = j3;
        if (!z) {
            j4 = j3;
            if (currentOffset == j2) {
                j4 = j - (currentOffset - this.startOffset);
            }
        }
        Logger.d("DownloadChunk", "contentLength:" + this.contentLength + " curOffset:" + getCurrentOffset() + " oldOffset:" + this.oldOffset + " retainLen:" + j4);
        long j5 = j4;
        if (j4 < 0) {
            j5 = 0;
        }
        return j5;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public List<DownloadChunk> getSubChunkList() {
        return this.subChunkList;
    }

    public boolean hasChunkDivided() {
        List<DownloadChunk> list = this.subChunkList;
        return list != null && list.size() > 0;
    }

    public boolean hasNoBytesDownload() {
        long j = this.startOffset;
        long j2 = j;
        if (isHostChunk()) {
            long j3 = this.oldOffset;
            j2 = j;
            if (j3 > this.startOffset) {
                j2 = j3;
            }
        }
        return getCurrentOffset() - j2 >= this.contentLength;
    }

    public boolean isDownloading() {
        AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean isHostChunk() {
        return getHostChunkIndex() == -1;
    }

    public boolean isReuseingFirstConnection() {
        return this.chunkIndex == 0 && this.reuseingFirstConnection;
    }

    public void setChunkIndex(int i) {
        this.chunkIndex = i;
    }

    public void setChunkRunnable(DownloadChunkRunnable downloadChunkRunnable) {
        this.chunkRunnable = downloadChunkRunnable;
        setOldOffset();
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setCurrentOffset(long j) {
        AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.currentOffset = new AtomicLong(j);
        }
    }

    public void setDownloading(boolean z) {
        AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            this.isDownloading = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.chunkRunnable = null;
    }

    public void setHostChunk(DownloadChunk downloadChunk) {
        this.hostChunk = downloadChunk;
        if (downloadChunk != null) {
            setHostChunkIndex(downloadChunk.getChunkIndex());
        }
    }

    public void setHostChunkIndex(int i) {
        AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            this.hostChunkIndex = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setOldOffset() {
        this.oldOffset = getCurrentOffset();
    }

    public void setOldOffset(long j) {
        this.oldOffset = j;
    }

    public void setReuseingFirstConnection(boolean z) {
        this.reuseingFirstConnection = z;
    }

    public void setSubChunkList(List<DownloadChunk> list) {
        this.subChunkList = list;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.id));
        contentValues.put(DBDefinition.CHUNK_INDEX, Integer.valueOf(this.chunkIndex));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.startOffset));
        contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(getCurrentOffset()));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.endOffset));
        contentValues.put(DBDefinition.CHUNK_CONTENT_LEN, Long.valueOf(this.contentLength));
        contentValues.put(DBDefinition.HOST_CHUNK_INDEX, Integer.valueOf(getHostChunkIndex()));
        return contentValues;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeLong(this.startOffset);
        AtomicLong atomicLong = this.currentOffset;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.endOffset);
        parcel.writeLong(this.contentLength);
        parcel.writeInt(this.chunkIndex);
        int i2 = -1;
        AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger != null) {
            i2 = atomicInteger.get();
        }
        parcel.writeInt(i2);
    }
}
