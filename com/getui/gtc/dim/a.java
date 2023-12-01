package com.getui.gtc.dim;

import android.text.TextUtils;
import com.getui.gtc.dim.b.b;
import com.getui.gtc.dim.b.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/a.class */
public final class a {

    /* renamed from: a */
    final com.getui.gtc.dim.b.a f21930a;
    final b b;

    /* renamed from: c */
    final e f21931c;
    final Map<String, Boolean> d;
    private final Map<String, Object> e;
    private final Map<String, List<String>> f;

    /* renamed from: com.getui.gtc.dim.a$a */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/a$a.class */
    public static final class C0343a {

        /* renamed from: a */
        private static final a f21932a = new a((byte) 0);
    }

    private a() {
        b bVar;
        this.e = new ConcurrentHashMap();
        this.f = new HashMap();
        this.d = new HashMap();
        this.f21930a = com.getui.gtc.dim.b.a.a();
        bVar = b.a.f21937a;
        this.b = bVar;
        this.f21931c = e.a();
        Map<String, List<String>> map = this.f;
        ArrayList arrayList = new ArrayList();
        arrayList.add("dim-2-1-21-5");
        arrayList.add("dim-2-1-21-3");
        arrayList.add("dim-2-1-21-1");
        arrayList.add("dim-2-1-21-2");
        map.put("dim-2-1-21-4", arrayList);
    }

    /* synthetic */ a(byte b) {
        this();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:415:0x017a A[Catch: all -> 0x09e1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:396:0x00f9, B:398:0x0103, B:401:0x0110, B:405:0x0130, B:407:0x013b, B:409:0x014f, B:411:0x0162, B:411:0x0162, B:412:0x0165, B:410:0x0157, B:415:0x017a, B:418:0x01aa, B:421:0x01c0, B:422:0x01ca, B:428:0x022e, B:431:0x024f, B:432:0x027e, B:437:0x0289, B:441:0x029a, B:444:0x02b2, B:445:0x02c8, B:447:0x03be, B:563:0x0599, B:566:0x05b5, B:569:0x05cc, B:570:0x05d6, B:576:0x063b, B:579:0x065d, B:580:0x069a, B:451:0x03cc, B:455:0x03dc, B:459:0x03ec, B:463:0x03fc, B:467:0x040c, B:471:0x041c, B:475:0x042d, B:479:0x043e, B:483:0x044f, B:487:0x045f, B:491:0x046f, B:495:0x047f, B:499:0x048f, B:503:0x049f, B:507:0x04af, B:511:0x04bf, B:515:0x04cf, B:519:0x04df, B:523:0x04ef, B:527:0x0500, B:531:0x0511, B:535:0x0522, B:539:0x0533, B:543:0x0544, B:547:0x0555, B:551:0x0566, B:555:0x0577, B:559:0x0588, B:583:0x069d, B:585:0x06b2, B:588:0x06ca, B:590:0x06dc, B:591:0x06df, B:593:0x0762, B:655:0x0857, B:656:0x0860, B:660:0x08b4, B:662:0x08bf, B:663:0x090b, B:668:0x0913, B:670:0x091e, B:671:0x096a, B:597:0x0770, B:601:0x0780, B:605:0x0790, B:609:0x07a0, B:613:0x07b0, B:617:0x07c0, B:621:0x07d1, B:625:0x07e2, B:629:0x07f3, B:633:0x0803, B:637:0x0813, B:641:0x0823, B:645:0x0833, B:649:0x0843, B:674:0x096d, B:676:0x097d, B:678:0x09d8, B:679:0x09de), top: B:712:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0289 A[Catch: all -> 0x09e1, TRY_ENTER, TryCatch #0 {, blocks: (B:396:0x00f9, B:398:0x0103, B:401:0x0110, B:405:0x0130, B:407:0x013b, B:409:0x014f, B:411:0x0162, B:411:0x0162, B:412:0x0165, B:410:0x0157, B:415:0x017a, B:418:0x01aa, B:421:0x01c0, B:422:0x01ca, B:428:0x022e, B:431:0x024f, B:432:0x027e, B:437:0x0289, B:441:0x029a, B:444:0x02b2, B:445:0x02c8, B:447:0x03be, B:563:0x0599, B:566:0x05b5, B:569:0x05cc, B:570:0x05d6, B:576:0x063b, B:579:0x065d, B:580:0x069a, B:451:0x03cc, B:455:0x03dc, B:459:0x03ec, B:463:0x03fc, B:467:0x040c, B:471:0x041c, B:475:0x042d, B:479:0x043e, B:483:0x044f, B:487:0x045f, B:491:0x046f, B:495:0x047f, B:499:0x048f, B:503:0x049f, B:507:0x04af, B:511:0x04bf, B:515:0x04cf, B:519:0x04df, B:523:0x04ef, B:527:0x0500, B:531:0x0511, B:535:0x0522, B:539:0x0533, B:543:0x0544, B:547:0x0555, B:551:0x0566, B:555:0x0577, B:559:0x0588, B:583:0x069d, B:585:0x06b2, B:588:0x06ca, B:590:0x06dc, B:591:0x06df, B:593:0x0762, B:655:0x0857, B:656:0x0860, B:660:0x08b4, B:662:0x08bf, B:663:0x090b, B:668:0x0913, B:670:0x091e, B:671:0x096a, B:597:0x0770, B:601:0x0780, B:605:0x0790, B:609:0x07a0, B:613:0x07b0, B:617:0x07c0, B:621:0x07d1, B:625:0x07e2, B:629:0x07f3, B:633:0x0803, B:637:0x0813, B:641:0x0823, B:645:0x0833, B:649:0x0843, B:674:0x096d, B:676:0x097d, B:678:0x09d8, B:679:0x09de), top: B:712:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x02b2 A[Catch: all -> 0x09e1, TRY_ENTER, TryCatch #0 {, blocks: (B:396:0x00f9, B:398:0x0103, B:401:0x0110, B:405:0x0130, B:407:0x013b, B:409:0x014f, B:411:0x0162, B:411:0x0162, B:412:0x0165, B:410:0x0157, B:415:0x017a, B:418:0x01aa, B:421:0x01c0, B:422:0x01ca, B:428:0x022e, B:431:0x024f, B:432:0x027e, B:437:0x0289, B:441:0x029a, B:444:0x02b2, B:445:0x02c8, B:447:0x03be, B:563:0x0599, B:566:0x05b5, B:569:0x05cc, B:570:0x05d6, B:576:0x063b, B:579:0x065d, B:580:0x069a, B:451:0x03cc, B:455:0x03dc, B:459:0x03ec, B:463:0x03fc, B:467:0x040c, B:471:0x041c, B:475:0x042d, B:479:0x043e, B:483:0x044f, B:487:0x045f, B:491:0x046f, B:495:0x047f, B:499:0x048f, B:503:0x049f, B:507:0x04af, B:511:0x04bf, B:515:0x04cf, B:519:0x04df, B:523:0x04ef, B:527:0x0500, B:531:0x0511, B:535:0x0522, B:539:0x0533, B:543:0x0544, B:547:0x0555, B:551:0x0566, B:555:0x0577, B:559:0x0588, B:583:0x069d, B:585:0x06b2, B:588:0x06ca, B:590:0x06dc, B:591:0x06df, B:593:0x0762, B:655:0x0857, B:656:0x0860, B:660:0x08b4, B:662:0x08bf, B:663:0x090b, B:668:0x0913, B:670:0x091e, B:671:0x096a, B:597:0x0770, B:601:0x0780, B:605:0x0790, B:609:0x07a0, B:613:0x07b0, B:617:0x07c0, B:621:0x07d1, B:625:0x07e2, B:629:0x07f3, B:633:0x0803, B:637:0x0813, B:641:0x0823, B:645:0x0833, B:649:0x0843, B:674:0x096d, B:676:0x097d, B:678:0x09d8, B:679:0x09de), top: B:712:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:585:0x06b2 A[Catch: all -> 0x09e1, TRY_LEAVE, TryCatch #0 {, blocks: (B:396:0x00f9, B:398:0x0103, B:401:0x0110, B:405:0x0130, B:407:0x013b, B:409:0x014f, B:411:0x0162, B:411:0x0162, B:412:0x0165, B:410:0x0157, B:415:0x017a, B:418:0x01aa, B:421:0x01c0, B:422:0x01ca, B:428:0x022e, B:431:0x024f, B:432:0x027e, B:437:0x0289, B:441:0x029a, B:444:0x02b2, B:445:0x02c8, B:447:0x03be, B:563:0x0599, B:566:0x05b5, B:569:0x05cc, B:570:0x05d6, B:576:0x063b, B:579:0x065d, B:580:0x069a, B:451:0x03cc, B:455:0x03dc, B:459:0x03ec, B:463:0x03fc, B:467:0x040c, B:471:0x041c, B:475:0x042d, B:479:0x043e, B:483:0x044f, B:487:0x045f, B:491:0x046f, B:495:0x047f, B:499:0x048f, B:503:0x049f, B:507:0x04af, B:511:0x04bf, B:515:0x04cf, B:519:0x04df, B:523:0x04ef, B:527:0x0500, B:531:0x0511, B:535:0x0522, B:539:0x0533, B:543:0x0544, B:547:0x0555, B:551:0x0566, B:555:0x0577, B:559:0x0588, B:583:0x069d, B:585:0x06b2, B:588:0x06ca, B:590:0x06dc, B:591:0x06df, B:593:0x0762, B:655:0x0857, B:656:0x0860, B:660:0x08b4, B:662:0x08bf, B:663:0x090b, B:668:0x0913, B:670:0x091e, B:671:0x096a, B:597:0x0770, B:601:0x0780, B:605:0x0790, B:609:0x07a0, B:613:0x07b0, B:617:0x07c0, B:621:0x07d1, B:625:0x07e2, B:629:0x07f3, B:633:0x0803, B:637:0x0813, B:641:0x0823, B:645:0x0833, B:649:0x0843, B:674:0x096d, B:676:0x097d, B:678:0x09d8, B:679:0x09de), top: B:712:0x00f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:676:0x097d A[Catch: all -> 0x09e1, TryCatch #0 {, blocks: (B:396:0x00f9, B:398:0x0103, B:401:0x0110, B:405:0x0130, B:407:0x013b, B:409:0x014f, B:411:0x0162, B:411:0x0162, B:412:0x0165, B:410:0x0157, B:415:0x017a, B:418:0x01aa, B:421:0x01c0, B:422:0x01ca, B:428:0x022e, B:431:0x024f, B:432:0x027e, B:437:0x0289, B:441:0x029a, B:444:0x02b2, B:445:0x02c8, B:447:0x03be, B:563:0x0599, B:566:0x05b5, B:569:0x05cc, B:570:0x05d6, B:576:0x063b, B:579:0x065d, B:580:0x069a, B:451:0x03cc, B:455:0x03dc, B:459:0x03ec, B:463:0x03fc, B:467:0x040c, B:471:0x041c, B:475:0x042d, B:479:0x043e, B:483:0x044f, B:487:0x045f, B:491:0x046f, B:495:0x047f, B:499:0x048f, B:503:0x049f, B:507:0x04af, B:511:0x04bf, B:515:0x04cf, B:519:0x04df, B:523:0x04ef, B:527:0x0500, B:531:0x0511, B:535:0x0522, B:539:0x0533, B:543:0x0544, B:547:0x0555, B:551:0x0566, B:555:0x0577, B:559:0x0588, B:583:0x069d, B:585:0x06b2, B:588:0x06ca, B:590:0x06dc, B:591:0x06df, B:593:0x0762, B:655:0x0857, B:656:0x0860, B:660:0x08b4, B:662:0x08bf, B:663:0x090b, B:668:0x0913, B:670:0x091e, B:671:0x096a, B:597:0x0770, B:601:0x0780, B:605:0x0790, B:609:0x07a0, B:613:0x07b0, B:617:0x07c0, B:621:0x07d1, B:625:0x07e2, B:629:0x07f3, B:633:0x0803, B:637:0x0813, B:641:0x0823, B:645:0x0833, B:649:0x0843, B:674:0x096d, B:676:0x097d, B:678:0x09d8, B:679:0x09de), top: B:712:0x00f9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.getui.gtc.dim.DimRequest r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 2832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.a.a(com.getui.gtc.dim.DimRequest, boolean):java.lang.Object");
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f.put(str, arrayList);
        String[] split = str2.split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                com.getui.gtc.dim.e.b.a("dim complex policy set: " + str + " : " + str2);
                return;
            }
            arrayList.add(split[i2].trim().toLowerCase());
            i = i2 + 1;
        }
    }
}
