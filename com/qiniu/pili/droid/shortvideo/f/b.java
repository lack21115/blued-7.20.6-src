package com.qiniu.pili.droid.shortvideo.f;

import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f13978a;
    private List<com.qiniu.pili.droid.shortvideo.core.h> b;

    /* renamed from: c  reason: collision with root package name */
    private PLCameraSetting f13979c;
    private PLMicrophoneSetting d;
    private PLVideoEncodeSetting e;
    private PLAudioEncodeSetting f;
    private PLFaceBeautySetting g;
    private PLRecordSetting h;

    public b() {
        this(null);
    }

    public b(String str) {
        this.f13978a = str;
        this.b = new ArrayList();
    }

    public String a() {
        return this.f13978a;
    }

    public void a(PLAudioEncodeSetting pLAudioEncodeSetting) {
        this.f = pLAudioEncodeSetting;
    }

    public void a(PLCameraSetting pLCameraSetting) {
        this.f13979c = pLCameraSetting;
    }

    public void a(PLFaceBeautySetting pLFaceBeautySetting) {
        this.g = pLFaceBeautySetting;
    }

    public void a(PLMicrophoneSetting pLMicrophoneSetting) {
        this.d = pLMicrophoneSetting;
    }

    public void a(PLRecordSetting pLRecordSetting) {
        this.h = pLRecordSetting;
    }

    public void a(PLVideoEncodeSetting pLVideoEncodeSetting) {
        this.e = pLVideoEncodeSetting;
    }

    public void a(String str) {
        this.f13978a = str;
    }

    public void a(Stack<com.qiniu.pili.droid.shortvideo.core.h> stack) {
        this.b.clear();
        this.b.addAll(stack);
    }

    public Stack<com.qiniu.pili.droid.shortvideo.core.h> b() {
        Stack<com.qiniu.pili.droid.shortvideo.core.h> stack = new Stack<>();
        for (com.qiniu.pili.droid.shortvideo.core.h hVar : this.b) {
            stack.push(hVar);
        }
        return stack;
    }

    public PLCameraSetting c() {
        return this.f13979c;
    }

    public PLMicrophoneSetting d() {
        return this.d;
    }

    public PLVideoEncodeSetting e() {
        return this.e;
    }

    public PLAudioEncodeSetting f() {
        return this.f;
    }

    public PLFaceBeautySetting g() {
        return this.g;
    }

    public PLRecordSetting h() {
        return this.h;
    }

    public JSONObject i() {
        List<com.qiniu.pili.droid.shortvideo.core.h> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag", this.f13978a);
            if (this.f13979c != null) {
                jSONObject.put(PLCameraSetting.TAG, this.f13979c.toJSON());
            }
            if (this.d != null) {
                jSONObject.put(PLMicrophoneSetting.TAG, this.d.toJSON());
            }
            if (this.e != null) {
                jSONObject.put(PLVideoEncodeSetting.TAG, this.e.toJSON());
            }
            if (this.f != null) {
                jSONObject.put(PLAudioEncodeSetting.TAG, this.f.toJSON());
            }
            if (this.g != null) {
                jSONObject.put(PLFaceBeautySetting.TAG, this.g.toJSON());
            }
            if (this.h != null) {
                jSONObject.put(PLRecordSetting.TAG, this.h.toJSON());
            }
            JSONArray jSONArray = new JSONArray();
            for (com.qiniu.pili.droid.shortvideo.core.h hVar : this.b) {
                jSONArray.put(hVar.a());
            }
            jSONObject.put("sections", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.d.e("Draft", "Error on toJSON, failed to create tag");
            return null;
        }
    }
}
