package com.jd.jtf.toc.virtual;

import com.google.inject.AbstractModule;
import com.jd.jtf.toc.Toc;

public class VirtualTocModule extends AbstractModule {

    public VirtualTocModule() {
        super();
    }

    @Override
    protected void configure() {

        bind(Toc.class).to(VirtualToc.class).asEagerSingleton();

    }

}
