package com.jd.jtf.lifeservice.action;

import com.google.inject.Inject;
import org.apache.camel.CamelContext;

public class RestLifeserviceBuyNowAction extends BaseRestHandler {

    private final Version version;
    private final CamelContext camelContext;

    @Inject
    public RestLifeserviceBuyNowAction(Settings settings, Version version, RestController controller, Client client, CamelContext camelContext) {
        super(settings, controller, client);
        this.version = version;
        this.camelContext = camelContext;
        controller.registerHandler(GET, "/buy_lifeservice", this);
        controller.registerHandler(HEAD, "/buy_lifeservice", this);
    }

    @Override
    public void handleRequest(final RestRequest request, RestChannel channel, final Client client) throws Exception {

        RestStatus status = RestStatus.OK;
        if (request.method() == RestRequest.Method.HEAD) {
            channel.sendResponse(new BytesRestResponse(status));
            return;
        }

        XContentBuilder builder = channel.newBuilder();

        // Default to pretty printing, but allow ?pretty=false to disable
        if (!request.hasParam("pretty")) {
            builder.prettyPrint().lfAtEnd();
        }

        Order order = new Order("lifeservice",1);
        Toc toc = (Toc)order.getAdapter(Toc.class);
        toc.setOrderConfirmTimeout(order);
        toc.setOrderConsignmentTimeout(order);

        Ump ump = (Ump)order.getAdapter(Ump.class);
        ump.setOrderPromation(order);

        int consignment_timeout = toc.getOrderConsignmentTimeout(order);
        int confirm_timeout = toc.getOrderConfirmTimeout(order);

        float promotion = ump.getOrderPromation(order);

        builder.startObject();
        if (settings.get("name") != null) {
            builder.field("name", settings.get("name"));
        }
        builder.startObject("version")
                .field("confignment_timeout", consignment_timeout)
                .field("confirm_timeout",confirm_timeout)
                .field("promotion",promotion)
                .endObject();
        builder.endObject();
        channel.sendResponse(new BytesRestResponse(status, builder));
    }
}
