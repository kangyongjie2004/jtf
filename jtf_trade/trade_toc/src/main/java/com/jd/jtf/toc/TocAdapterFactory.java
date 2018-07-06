package com.jd.jtf.toc;
import com.google.inject.Inject;
import com.jd.jtf.domain.order.IOrder;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;

public class TocAdapterFactory implements IAdapterFactory {

    private final TocsService tocsService;
    @Inject
    public TocAdapterFactory(TocsService tocsService) {
        this.tocsService = tocsService;
        IAdapterManager manager = Platform.getAdapterManager();
        manager.registerAdapters(this, IOrder.class);

    }

    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == Toc.class) {
            IOrder order = (IOrder) adaptableObject;
            Toc toc = tocsService.toc(order.getType());
            if (toc== null) {
                toc = tocsService.toc("general");
            }
            return toc;
        }
        return null;
    }

    @Override
    public Class[] getAdapterList() {
        return new Class[] { Toc.class };
    }

}
