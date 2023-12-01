package dalvik.system.profiler;

import dalvik.system.profiler.HprofData;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/profiler/AsciiHprofWriter.class */
public final class AsciiHprofWriter {
    private static final Comparator<HprofData.Sample> SAMPLE_COMPARATOR = new Comparator<HprofData.Sample>() { // from class: dalvik.system.profiler.AsciiHprofWriter.1
        @Override // java.util.Comparator
        public int compare(HprofData.Sample sample, HprofData.Sample sample2) {
            return sample2.count - sample.count;
        }
    };
    private final HprofData data;
    private final PrintWriter out;

    private AsciiHprofWriter(HprofData hprofData, OutputStream outputStream) {
        this.data = hprofData;
        this.out = new PrintWriter(outputStream);
    }

    private void write() throws IOException {
        for (HprofData.ThreadEvent threadEvent : this.data.getThreadHistory()) {
            this.out.println(threadEvent);
        }
        ArrayList<HprofData.Sample> arrayList = new ArrayList(this.data.getSamples());
        Collections.sort(arrayList, SAMPLE_COMPARATOR);
        int i = 0;
        for (HprofData.Sample sample : arrayList) {
            HprofData.StackTrace stackTrace = sample.stackTrace;
            int i2 = i + sample.count;
            this.out.printf("TRACE %d: (thread=%d)\n", Integer.valueOf(stackTrace.stackTraceId), Integer.valueOf(stackTrace.threadId));
            StackTraceElement[] stackTraceElementArr = stackTrace.stackFrames;
            int length = stackTraceElementArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 < length) {
                    this.out.printf("\t%s\n", stackTraceElementArr[i4]);
                    i3 = i4 + 1;
                }
            }
        }
        Date date = new Date(this.data.getStartMillis());
        this.out.printf("CPU SAMPLES BEGIN (total = %d) %ta %tb %td %tT %tY\n", Integer.valueOf(i), date, date, date, date, date);
        this.out.printf("rank   self  accum   count trace method\n", new Object[0]);
        int i5 = 0;
        double d = 0.0d;
        for (HprofData.Sample sample2 : arrayList) {
            i5++;
            HprofData.StackTrace stackTrace2 = sample2.stackTrace;
            int i6 = sample2.count;
            double d2 = i6 / i;
            d += d2;
            this.out.printf("% 4d% 6.2f%%% 6.2f%% % 7d % 5d %s.%s\n", Integer.valueOf(i5), Double.valueOf(100.0d * d2), Double.valueOf(100.0d * d), Integer.valueOf(i6), Integer.valueOf(stackTrace2.stackTraceId), stackTrace2.stackFrames[0].getClassName(), stackTrace2.stackFrames[0].getMethodName());
        }
        this.out.printf("CPU SAMPLES END\n", new Object[0]);
        this.out.flush();
    }

    public static void write(HprofData hprofData, OutputStream outputStream) throws IOException {
        new AsciiHprofWriter(hprofData, outputStream).write();
    }
}
