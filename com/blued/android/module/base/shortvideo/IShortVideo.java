package com.blued.android.module.base.shortvideo;

import android.os.Bundle;
import com.blued.android.module.base.base.IBaseInterface;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/shortvideo/IShortVideo.class */
public interface IShortVideo extends IBaseInterface {
    void a(Bundle bundle, int i, ISaveInterface iSaveInterface);

    void a(Object obj, int i, int i2);

    void a(Object obj, int i, int i2, int i3);

    void a(Object obj, int i, int i2, String str, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener);

    void a(Object obj, int i, String str, String str2, int i2);

    void a(Object obj, Bundle bundle, int i);

    void a(Object obj, Bundle bundle, int i, int i2);

    void a(Object obj, String str, int i, int i2);

    void a(Object obj, String str, int i, int i2, String str2, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener);

    void a(Object obj, String str, String str2, int i);

    void a(String str);

    void a(String str, ITranscodingVideoListener iTranscodingVideoListener);

    boolean a();

    void b(Object obj, int i, int i2);

    void b(String str);

    boolean b();

    void c();

    void d();
}
