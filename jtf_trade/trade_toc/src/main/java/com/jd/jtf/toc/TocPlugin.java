package com.jd.jtf.toc;

import com.google.inject.Module;
import com.jd.jtf.domain.plugins.AbstractPlugin;

import java.util.ArrayList;
import java.util.Collection;

public class TocPlugin extends AbstractPlugin {
    public TocPlugin() {
    }

    @Override
    public String name() {
        return "trade-toc";
    }

    @Override
    public String description() {
        return "trade toc Plugin";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        Collection<Class<? extends Module>> modules = new ArrayList<Class<? extends Module>>();
        modules.add(TocsModule.class);
        return modules;
    }
}
