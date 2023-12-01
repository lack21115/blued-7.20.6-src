package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/di.class */
public class di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dh f41337a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f303a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Throwable f304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar, String str, Throwable th) {
        this.f41337a = dhVar;
        this.f303a = str;
        this.f304a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        SimpleDateFormat simpleDateFormat;
        String str;
        List list2;
        String str2;
        String str3;
        List list3;
        List list4;
        SimpleDateFormat simpleDateFormat2;
        String str4;
        List list5;
        List list6;
        list = dh.f300a;
        simpleDateFormat = dh.f299a;
        str = this.f41337a.b;
        list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.f303a), this.f304a));
        list2 = dh.f300a;
        if (list2.size() > 20000) {
            list3 = dh.f300a;
            int size = (list3.size() - 20000) + 50;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                try {
                    list5 = dh.f300a;
                    if (list5.size() > 0) {
                        list6 = dh.f300a;
                        list6.remove(0);
                    }
                } catch (IndexOutOfBoundsException e) {
                }
                i = i2 + 1;
            }
            list4 = dh.f300a;
            simpleDateFormat2 = dh.f299a;
            String format = simpleDateFormat2.format(new Date());
            str4 = this.f41337a.b;
            list4.add(new Pair(String.format("%1$s %2$s %3$s ", format, str4, "flush " + size + " lines logs."), null));
        }
        try {
            if (z.d()) {
                this.f41337a.m11621a();
                return;
            }
            str3 = this.f41337a.b;
            Log.w(str3, "SDCard is unavailable.");
        } catch (Exception e2) {
            str2 = this.f41337a.b;
            Log.e(str2, "", e2);
        }
    }
}
