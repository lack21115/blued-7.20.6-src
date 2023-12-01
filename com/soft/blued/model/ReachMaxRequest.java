package com.soft.blued.model;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/model/ReachMaxRequest.class */
public class ReachMaxRequest {
    public App app;
    public Device device;
    public String id;
    public List<Imp> imp;

    public ReachMaxRequest(String str, App app, List<Imp> list, Device device) {
        this.id = str;
        this.app = app;
        this.imp = list;
        this.device = device;
    }
}
