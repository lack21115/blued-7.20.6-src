package com.soft.blued.ui.msg.VideoChat;

import android.app.Activity;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/VideoChat/VideoChatTools.class */
public class VideoChatTools implements IVideoChatTools {

    /* renamed from: a  reason: collision with root package name */
    private static IVideoChatTools f31947a;
    private BD1V1Config b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f31948c;
    private IVideoChatListener d;
    private String e;
    private int f;
    private String g;

    public VideoChatTools(Activity activity, BD1V1Config bD1V1Config, IVideoChatListener iVideoChatListener) {
        this.f31948c = activity;
        this.b = bD1V1Config;
        this.d = iVideoChatListener;
        a(activity, bD1V1Config, iVideoChatListener);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a() {
        f31947a.a();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a(Activity activity, BD1V1Config bD1V1Config, IVideoChatListener iVideoChatListener) {
        VideoChatToolsForZego i = VideoChatToolsForZego.i();
        f31947a = i;
        i.a(activity, bD1V1Config, iVideoChatListener);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a(String str, int i, String str2) {
        this.e = str;
        this.f = i;
        this.g = str2;
        f31947a.a(str, i, str2);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void a(boolean z) {
        f31947a.a(z);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void b() {
        f31947a.b();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void b(boolean z) {
        f31947a.b(z);
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void c() {
        f31947a.c();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void d() {
        f31947a.d();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void e() {
        f31947a.e();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void f() {
        f31947a.f();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void g() {
        f31947a.g();
    }

    @Override // com.soft.blued.ui.msg.VideoChat.IVideoChatTools
    public void h() {
        f31947a.h();
    }

    public void i() {
        f31947a.c();
    }

    public void j() {
        f31947a.c();
    }
}
