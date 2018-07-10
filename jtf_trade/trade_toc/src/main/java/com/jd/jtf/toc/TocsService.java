package com.jd.jtf.toc;

import com.jd.jtf.toc.general.GeneralToc;
import com.jd.jtf.toc.virtual.VirtualToc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TocsService {

    @Resource
    private GeneralToc generalToc;
    @Resource
    private VirtualToc virtualToc;


    static String type_general = "general";
    static String type_virtual = "virtual";

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
