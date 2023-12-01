package com.amap.api.services.busline;

import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/busline/BusStationResult.class */
public final class BusStationResult {

    /* renamed from: a  reason: collision with root package name */
    private int f5592a;
    private ArrayList<BusStationItem> b;

    /* renamed from: c  reason: collision with root package name */
    private BusStationQuery f5593c;
    private List<String> d;
    private List<SuggestionCity> e;

    private BusStationResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        this.b = new ArrayList<>();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f5593c = busStationQuery;
        this.f5592a = a(i);
        this.e = list;
        this.d = list2;
        this.b = arrayList;
    }

    private int a(int i) {
        int pageSize = this.f5593c.getPageSize();
        int i2 = ((i + pageSize) - 1) / pageSize;
        if (i2 > 30) {
            return 30;
        }
        return i2;
    }

    public static BusStationResult createPagedResult(BusStationQuery busStationQuery, int i, List<SuggestionCity> list, List<String> list2, ArrayList<BusStationItem> arrayList) {
        return new BusStationResult(busStationQuery, i, list, list2, arrayList);
    }

    public final List<BusStationItem> getBusStations() {
        return this.b;
    }

    public final int getPageCount() {
        return this.f5592a;
    }

    public final BusStationQuery getQuery() {
        return this.f5593c;
    }

    public final List<SuggestionCity> getSearchSuggestionCities() {
        return this.e;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.d;
    }
}
