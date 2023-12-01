package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.kuaishou.weapon.p0.bh;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/e.class */
public class e {

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/e$a.class */
    public enum a {
        check_su_binary(new String[]{"/system/xbin/which", bh.y});
        
        String[] b;

        a(String[] strArr) {
            this.b = strArr;
        }
    }

    public ArrayList a(a aVar) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 28) {
            return arrayList;
        }
        try {
            Process exec = Runtime.getRuntime().exec(aVar.b);
            new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return arrayList;
                    }
                    arrayList.add(readLine);
                } catch (Exception e) {
                    return arrayList;
                }
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
