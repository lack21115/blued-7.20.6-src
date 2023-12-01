package android.util;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: source-9557208-dex2jar.jar:android/util/LocalLog.class */
public final class LocalLog {
    private LinkedList<String> mLog = new LinkedList<>();
    private int mMaxLines;
    private long mNow;

    public LocalLog(int i) {
        this.mMaxLines = i;
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this) {
            ListIterator<String> listIterator = this.mLog.listIterator(0);
            while (listIterator.hasNext()) {
                printWriter.println(listIterator.next());
            }
        }
    }

    public void log(String str) {
        synchronized (this) {
            if (this.mMaxLines > 0) {
                this.mNow = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.mNow);
                sb.append(String.format("%tm-%td %tH:%tM:%tS.%tL", calendar, calendar, calendar, calendar, calendar, calendar));
                this.mLog.add(sb.toString() + " - " + str);
                while (this.mLog.size() > this.mMaxLines) {
                    this.mLog.remove();
                }
            }
        }
    }
}
