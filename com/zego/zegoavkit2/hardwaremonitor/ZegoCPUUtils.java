package com.zego.zegoavkit2.hardwaremonitor;

import android.os.Process;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/hardwaremonitor/ZegoCPUUtils.class */
public class ZegoCPUUtils {
    private RandomAccessFile appProcStatFile;
    private RandomAccessFile sysProcStatFile;
    private final long tickInHz = ZegoTimeUtilJNI.getTimeTick();
    private final int cpuCount = Runtime.getRuntime().availableProcessors();
    private float appCpuUseTimeLast = 0.0f;
    private float appCpuUsage = 0.0f;
    private long sysCpuTotalTimeLast = 0;
    private long sysCpuIdelTimeLast = 0;
    private float sysCpuUsage = 0.0f;

    public ZegoCPUUtils() {
        try {
            this.appProcStatFile = new RandomAccessFile(String.format("/proc/%d/stat", Integer.valueOf(Process.myPid())), "r");
        } catch (IOException e) {
        }
        try {
            this.sysProcStatFile = new RandomAccessFile("proc/stat", "r");
        } catch (IOException e2) {
        }
    }

    private static String[] getStrsFromFile(RandomAccessFile randomAccessFile) {
        String str;
        if (randomAccessFile == null) {
            return null;
        }
        try {
            randomAccessFile.seek(0L);
            str = randomAccessFile.readLine();
        } catch (IOException e) {
            str = null;
        }
        if (str.isEmpty()) {
            return null;
        }
        return str.split("\\s+");
    }

    private void updateCpuUsage() {
        long currentTimeMillis;
        long j;
        String[] strsFromFile = getStrsFromFile(this.appProcStatFile);
        if (strsFromFile == null || strsFromFile.length < 52) {
            return;
        }
        long parseLong = (((float) (((Long.parseLong(strsFromFile[13]) + Long.parseLong(strsFromFile[14])) + Long.parseLong(strsFromFile[15])) + Long.parseLong(strsFromFile[16]))) * 1000.0f) / ((float) this.tickInHz);
        String[] strsFromFile2 = getStrsFromFile(this.sysProcStatFile);
        if (strsFromFile2 == null || strsFromFile2.length < 8) {
            currentTimeMillis = System.currentTimeMillis() * this.cpuCount;
            j = currentTimeMillis;
        } else {
            long parseLong2 = Long.parseLong(strsFromFile2[1]);
            long parseLong3 = Long.parseLong(strsFromFile2[2]);
            long parseLong4 = Long.parseLong(strsFromFile2[3]);
            long parseLong5 = Long.parseLong(strsFromFile2[4]);
            long parseLong6 = Long.parseLong(strsFromFile2[5]);
            long parseLong7 = Long.parseLong(strsFromFile2[6]);
            long parseLong8 = Long.parseLong(strsFromFile2[7]);
            long parseLong9 = Long.parseLong(strsFromFile2[4]);
            long parseLong10 = Long.parseLong(strsFromFile2[5]);
            float f = (float) (parseLong2 + parseLong3 + parseLong4 + parseLong5 + parseLong6 + parseLong7 + parseLong8);
            long j2 = this.tickInHz;
            currentTimeMillis = (f * 1000.0f) / ((float) j2);
            j = (((float) (parseLong9 + parseLong10)) * 1000.0f) / ((float) j2);
        }
        long j3 = this.sysCpuIdelTimeLast;
        if (j < j3) {
            return;
        }
        float f2 = (float) parseLong;
        float f3 = (float) (currentTimeMillis - this.sysCpuTotalTimeLast);
        this.appCpuUsage = ((f2 - this.appCpuUseTimeLast) * 100.0f) / f3;
        this.sysCpuUsage = ((f3 - ((float) (j - j3))) * 100.0f) / f3;
        this.appCpuUseTimeLast = f2;
        this.sysCpuIdelTimeLast = j;
        this.sysCpuTotalTimeLast = currentTimeMillis;
    }

    public double[] getCpuUsage() {
        double d;
        double d2;
        synchronized (this) {
            updateCpuUsage();
            d = 0.0d;
            d2 = ((double) this.appCpuUsage) > 0.0d ? this.appCpuUsage : 0.0d;
            if (this.sysCpuUsage > 0.0d) {
                d = this.sysCpuUsage;
            }
        }
        return new double[]{d2, d};
    }
}
