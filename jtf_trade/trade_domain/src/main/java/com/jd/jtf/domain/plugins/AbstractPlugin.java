package com.jd.jtf.domain.plugins;

import com.google.inject.Module;
import java.util.Collection;

public abstract class AbstractPlugin {
    public abstract String name();

    public abstract String description();

    public abstract Collection<Class<? extends Module>> modules();
}
