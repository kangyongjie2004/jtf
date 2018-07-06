package com.jd.jtf.toc;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.jd.jtf.toc.general.GeneralTocModule;
import com.jd.jtf.toc.virtual.VirtualTocModule;
import com.sun.scenario.Settings;

import java.util.Map;

public class TocsModule extends AbstractModule {

    private final Settings settings;

    private Map<String, Class<? extends Module>> tocTypes = Maps.newHashMap();

    @Inject
    public TocsModule(Settings settings) {
        this.settings = settings;
        registerToc("general", GeneralTocModule.class);
        registerToc("virtual", VirtualTocModule.class);
    }

    /**
     * Registers a custom river type name against a module.
     *
     * @param type   The type
     * @param module The module
     */
    public void registerToc(String type, Class<? extends Module> module) {
        tocTypes.put(type, module);
    }

    @Override
    protected void configure() {
        bind(TocsService.class).asEagerSingleton();
        bind(TocAdapterFactory.class).asEagerSingleton();
        bind(TocsTypesRegistry.class).toInstance(new TocsTypesRegistry(ImmutableMap.copyOf(tocTypes)));
    }
}
