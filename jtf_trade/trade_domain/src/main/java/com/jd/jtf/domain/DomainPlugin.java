package com.jd.jtf.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.google.inject.Module;
import com.jd.jtf.domain.plugins.AbstractPlugin;

public class DomainPlugin extends AbstractPlugin {
    public DomainPlugin() {
    }

    @Override
    public String name() {
        return "trade-domain";
    }

    @Override
    public String description() {
        return "trade domain Plugin";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        Collection<Class<? extends Module>> modules = new ArrayList<Class<? extends Module>>();
        modules.add(DomainModule.class);
        return modules;
    }
}