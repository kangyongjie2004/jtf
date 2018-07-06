package com.jd.jtf.toc;

public class AbstractTocComponent {
    private TocName tocName;
    private TocSettings settings;

    public AbstractTocComponent(TocName tocName, TocSettings settings) {
        this.tocName = tocName;
        this.settings = settings;
    }
}
