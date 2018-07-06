package com.jd.jtf.lifeservice.toc;

import com.google.inject.Module;
import com.jd.jtf.domain.plugins.AbstractPlugin;

import java.util.ArrayList;
import java.util.Collection;

public class LifeserviceTocPlugin extends AbstractPlugin {
    public LifeserviceTocPlugin() {
    }

    @Override
    public String name() {
        return "lifeservice toc";
    }

    @Override
    public String description() {
        return "lifeservice toc extension Plugin";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        Collection<Class<? extends Module>> modules = new ArrayList<Class<? extends Module>>();
        modules.add(LifeserviceTocModule.class);
        return modules;
    }
}
