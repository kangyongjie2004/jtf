package com.jd.jtf.toc.helper;

import com.jd.jtf.toc.plugin.impl.GenenalTocService;
import com.jd.jtf.toc.plugin.TocService;
import com.jd.jtf.toc.plugin.impl.ToplifeTocService;
import com.jd.jtf.toc.plugin.impl.FreshTocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TocHelper {

    @Resource
    private GenenalTocService generalToc;
    @Resource
    private ToplifeTocService toplifeToc;
    @Resource
    private FreshTocService freshToc;


    static String type_general = "general";
    static String type_toplite = "toplite";
    static String type_fresh = "fresh";

    public TocService toc(String type) {

        TocService toc;
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
