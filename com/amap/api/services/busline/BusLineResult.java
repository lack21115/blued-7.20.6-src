package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/busline/BusLineResult.class */
public final class BusLineResult {

    /* renamed from: a  reason: collision with root package name */
    private int f5585a;
    private ArrayList<BusLineItem> b;

    /* renamed from: c  reason: collision with root package name */
    private BusLineQuery f5586c;
    private List<String> d;
    private List<SuggestionCity> e;

    private BusLineResult(BusLineQuery busLineQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        this.b = new ArrayList<>();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f5586c = busLineQuery;
        this.f5585a = a(i);
        this.e = list;
        this.d = list2;
        this.b = arrayList;
    }

    private int a(int i) {
        int pageSize = this.f5586c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    public static BusLineResult createPagedResult(BusLineQuery busLineQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusLineItem> arrayList) {
        return new BusLineResult(busLineQuery, i, list, list2, arrayList);
    }

    public final List<BusLineItem> getBusLines() {
        return this.b;
    }

    public final int getPageCount() {
        return this.f5585a;
    }

    public final BusLineQuery getQuery() {
        return this.f5586c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.d;
    }
}
