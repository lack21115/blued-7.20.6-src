package com.kwai.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/ab.class */
final class ab implements w {
    private final SparseArray<Handler> aGn = new SparseArray<>();

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwai.filedownloader.w
    public final void F(List<Integer> list) {
        for (Integer num : list) {
            b(this.aGn.get(num.intValue()));
        }
    }

    @Override // com.kwai.filedownloader.w
    public final void Hv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aGn.size()) {
                return;
            }
            a(this.aGn.get(this.aGn.keyAt(i2)));
            i = i2 + 1;
        }
    }

    @Override // com.kwai.filedownloader.w
    public final int Hw() {
        return this.aGn.size();
    }

    @Override // com.kwai.filedownloader.w
    public final boolean cF(int i) {
        return this.aGn.get(i) != null;
    }
}
