package com.jd.jtf.toc.service;

import com.jd.jtf.toc.Toc;
import com.jd.jtf.toc.impl.GenenalToc;
import com.jd.jtf.toc.impl.ToplifeToc;
import com.jd.jtf.toc.impl.FreshToc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TocService {

    @Resource
    private GenenalToc generalToc;
    @Resource
    private ToplifeToc toplifeToc;
    @Resource
    private FreshToc freshToc;


    static String type_general = "general";
    static String type_toplite = "toplite";
    static String type_fresh = "fresh";

    public Toc toc(String type) {

        Toc toc;
        if (type.equals(type_toplite)) {
            toc = toplifeToc;
        } else if (type.equals(type_fresh)) {
            toc = freshToc;
        } else {
            toc = generalToc;
        }

        return toc;
    }


}
