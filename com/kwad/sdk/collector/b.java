package com.kwad.sdk.collector;

import android.os.Environment;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/b.class */
public final class b {

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/b$a.class */
    public static final class a implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    if (d.tF()) {
                        try {
                            long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                            StringBuilder sb = new StringBuilder("analysisByFile: runningInfoPtrs: ");
                            sb.append(analysis);
                            com.kwad.sdk.core.d.b.d("AppStatusAnalyserNative", sb.toString());
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= analysis.length) {
                                    break;
                                }
                                arrayList.add(new AppRunningInfoNative(analysis[i4]));
                                i3 = i4 + 1;
                            }
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                    com.kwad.sdk.core.d.b.d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
                    return arrayList;
                }
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i2);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i2] = ((AnalyseTaskNative) aVar).getNativePtr();
                i = i2 + 1;
            }
        }

        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                com.kwad.sdk.collector.model.d dVar = list.get(i2);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i2] = ((RulesTargetNative) dVar).getNativePtr();
                }
                i = i2 + 1;
            }
            ArrayList arrayList = new ArrayList();
            if (d.tF()) {
                try {
                    long[] nativeGetUploadEntry = AppStatusNative.nativeGetUploadEntry(jArr, j, str);
                    int length = nativeGetUploadEntry.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length) {
                            break;
                        }
                        arrayList.add(new UploadEntryNative(nativeGetUploadEntry[i4]));
                        i3 = i4 + 1;
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }

    public static com.kwad.sdk.collector.a tD() {
        return new a();
    }
}
