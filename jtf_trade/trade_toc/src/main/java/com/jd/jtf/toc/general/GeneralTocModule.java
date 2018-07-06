package com.jd.jtf.toc.general;

import com.google.inject.AbstractModule;
import com.jd.jtf.toc.Toc;

public class GeneralTocModule extends AbstractModule {

    public GeneralTocModule() {
        super();
    }

    @Override
    protected void configure() {
        bind(Toc.class).to(GeneralToc.class).asEagerSingleton();
    }

}