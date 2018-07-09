package com.jd.jtf.toc;

import com.jd.jtf.toc.general.GeneralToc;
import com.jd.jtf.toc.virtual.VirtualToc;

public class TocsService {


    static Toc generalToc = null;
    static Toc virtualToc = null;
    static String type_general = "general";
    static String type_virtual = "virtual";

    static {

        generalToc = new GeneralToc(new TocName(type_general), new TocSettings());
        virtualToc = new VirtualToc(new TocName(type_virtual), new TocSettings());
    }

    public Toc toc(String type) {

        Toc toc;
        if (type.equals(type_general)) {
            toc = generalToc;
        } else if (type.equals(type_virtual)) {
            toc = virtualToc;
        } else {
            toc = generalToc;
        }

        return toc;
    }


}
