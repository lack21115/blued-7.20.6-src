package com.qiniu.pili.droid.shortvideo.f;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f13980a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private List<b> f13981c;

    private c(Context context) {
        this.b = context.getApplicationContext();
        if (!b()) {
            this.f13981c = new ArrayList();
            return;
        }
        List<b> d = d();
        if (d != null) {
            this.f13981c = d;
            return;
        }
        e.d.d("Error on construct DraftBox, parse file failed, creating empty DraftBox");
        this.f13981c = new ArrayList();
    }

    public static c a(Context context) {
        c cVar;
        synchronized (c.class) {
            try {
                if (f13980a == null) {
                    f13980a = new c(context);
                }
                cVar = f13980a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    private boolean b() {
        return new File(this.b.getFilesDir().getPath() + "/drafts.json").exists();
    }

    private boolean c() {
        if (b()) {
            new File(this.b.getFilesDir().getPath() + "/drafts.json").delete();
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.b.openFileOutput("drafts.json", 0));
            for (b bVar : this.f13981c) {
                JSONObject i = bVar.i();
                if (i == null) {
                    return false;
                }
                outputStreamWriter.write(i.toString());
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.close();
            return true;
        } catch (IOException e) {
            e.d.e("DraftBox", "Error on drafts saveToLocalStorage");
            return false;
        }
    }

    private List<b> d() {
        File file = new File(this.b.getFilesDir().getPath() + "/drafts.json");
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return arrayList;
                }
                JSONObject jSONObject = new JSONObject(readLine);
                b bVar = new b();
                Stack<com.qiniu.pili.droid.shortvideo.core.h> stack = new Stack<>();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("tag")) {
                        bVar.a(jSONObject.optString("tag"));
                    }
                    if (next.equals(PLCameraSetting.TAG)) {
                        bVar.a(PLCameraSetting.fromJSON(jSONObject.optJSONObject(PLCameraSetting.TAG)));
                    }
                    if (next.equals(PLMicrophoneSetting.TAG)) {
                        bVar.a(PLMicrophoneSetting.fromJSON(jSONObject.optJSONObject(PLMicrophoneSetting.TAG)));
                    }
                    if (next.equals(PLVideoEncodeSetting.TAG)) {
                        bVar.a(PLVideoEncodeSetting.fromJSON(this.b, jSONObject.optJSONObject(PLVideoEncodeSetting.TAG)));
                    }
                    if (next.equals(PLAudioEncodeSetting.TAG)) {
                        bVar.a(PLAudioEncodeSetting.fromJSON(jSONObject.optJSONObject(PLAudioEncodeSetting.TAG)));
                    }
                    if (next.equals(PLFaceBeautySetting.TAG)) {
                        bVar.a(PLFaceBeautySetting.fromJSON(jSONObject.optJSONObject(PLFaceBeautySetting.TAG)));
                    }
                    if (next.equals(PLRecordSetting.TAG)) {
                        bVar.a(PLRecordSetting.fromJSON(jSONObject.optJSONObject(PLRecordSetting.TAG)));
                    }
                    if (next.equals("sections")) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("sections");
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= optJSONArray.length()) {
                                break;
                            }
                            stack.push(com.qiniu.pili.droid.shortvideo.core.h.a(optJSONArray.getJSONObject(i2)));
                            i = i2 + 1;
                        }
                        bVar.a(stack);
                    }
                }
                arrayList.add(bVar);
            }
        } catch (IOException | JSONException e) {
            e.d.e("DraftBox", "Error on recoverFromFile");
            return null;
        }
    }

    public b a(String str) {
        b next;
        synchronized (this) {
            Iterator<b> it = this.f13981c.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (!next.a().equals(str));
            return next;
        }
    }

    public List<b> a() {
        List<b> list;
        synchronized (this) {
            list = this.f13981c;
        }
        return list;
    }

    public void a(String str, boolean z) {
        com.qiniu.pili.droid.shortvideo.core.h next;
        synchronized (this) {
            b bVar = null;
            for (b bVar2 : this.f13981c) {
                if (bVar2.a().equals(str)) {
                    bVar = bVar2;
                }
            }
            if (bVar != null) {
                this.f13981c.remove(bVar);
                if (z) {
                    Iterator<com.qiniu.pili.droid.shortvideo.core.h> it = bVar.b().iterator();
                    while (it.hasNext()) {
                        if (it.next().f13864a.delete()) {
                            e.d.c("DraftBox", "deleted section:" + next.f13864a);
                        } else {
                            e.d.e("DraftBox", "deleted section failed:" + next.f13864a);
                        }
                    }
                }
            }
            c();
        }
    }

    public void a(boolean z) {
        synchronized (this) {
            if (z) {
                for (b bVar : this.f13981c) {
                    Iterator<com.qiniu.pili.droid.shortvideo.core.h> it = bVar.b().iterator();
                    while (it.hasNext()) {
                        com.qiniu.pili.droid.shortvideo.core.h next = it.next();
                        if (next.f13864a.delete()) {
                            e eVar = e.d;
                            eVar.c("DraftBox", "deleted section:" + next.f13864a);
                        } else {
                            e eVar2 = e.d;
                            eVar2.e("DraftBox", "deleted section failed:" + next.f13864a);
                        }
                    }
                }
            }
            this.f13981c.clear();
            if (b()) {
                new File(this.b.getFilesDir().getPath() + "/drafts.json").delete();
            }
        }
    }

    public boolean a(b bVar) {
        boolean c2;
        synchronized (this) {
            b bVar2 = null;
            for (b bVar3 : this.f13981c) {
                if (bVar3.a().equals(bVar.a())) {
                    e.d.c("Delete old draft: " + bVar3.a());
                    bVar2 = bVar3;
                }
            }
            if (bVar2 != null) {
                this.f13981c.remove(bVar2);
            }
            this.f13981c.add(bVar);
            c2 = c();
        }
        return c2;
    }
}
