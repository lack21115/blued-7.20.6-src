package com.uc.crashsdk.a;

import com.tencent.smtt.sdk.TbsMediaPlayer;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/e.class */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f26873a = !e.class.desiredAssertionStatus();
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f26874c;

    public e(int i) {
        this.b = i;
        this.f26874c = null;
    }

    public e(int i, Object[] objArr) {
        this.b = i;
        this.f26874c = objArr;
    }

    public final boolean a() {
        int i = this.b;
        if (i == 451 || i == 452) {
            return com.uc.crashsdk.e.b(this.b, this.f26874c);
        }
        switch (i) {
            case 351:
            case 352:
            case 353:
            case 354:
                return h.b(i, this.f26874c);
            default:
                switch (i) {
                    case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA /* 751 */:
                    case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA /* 752 */:
                    case 753:
                    case 754:
                    case 755:
                    case 756:
                        return com.uc.crashsdk.f.a(i, this.f26874c);
                    default:
                        a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (f26873a) {
                            return false;
                        }
                        throw new AssertionError();
                }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.b;
        if (i == 10) {
            f.a(i, this.f26874c);
        } else if (i == 500) {
            d.a(i);
        } else if (i == 700) {
            com.uc.crashsdk.f.b(i);
        } else if (i == 800) {
            g.a(i);
        } else if (i == 201 || i == 202) {
            com.uc.crashsdk.a.a(this.b);
        } else {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                    com.uc.crashsdk.b.a(i);
                    return;
                default:
                    switch (i) {
                        case 301:
                        case 302:
                        case 303:
                            h.a(i, this.f26874c);
                            return;
                        default:
                            switch (i) {
                                case 401:
                                case 402:
                                case 403:
                                    break;
                                default:
                                    switch (i) {
                                        case 405:
                                        case 406:
                                        case 407:
                                        case 408:
                                        case 409:
                                        case 410:
                                        case 411:
                                        case 412:
                                        case 413:
                                        case 414:
                                        case 415:
                                        case 416:
                                            break;
                                        default:
                                            a.d("crashsdk", "Unknown async runnable: " + toString());
                                            if (!f26873a) {
                                                throw new AssertionError();
                                            }
                                            return;
                                    }
                            }
                            com.uc.crashsdk.e.a(this.b, this.f26874c);
                            return;
                    }
            }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.b;
    }
}
