//package com.jd.jtf.route;
//
//import com.google.inject.Inject;
//import com.jd.jtf.domain.order.Order;
//import com.jd.jtf.toc.Toc;
//import org.apache.camel.CamelContext;
//import org.eclipse.osgi.container.Module;
//import org.springframework.web.bind.annotation.RestController;
//
//public class RestBuyNowAction {
//
//    private final Version version;
//    private final CamelContext camelContext;
//
//    @Inject
//    public RestBuyNowAction(Module.Settings settings, Version version, RestController controller, Client client, CamelContext camelContext) {
//        this.version = version;
//        this.camelContext = camelContext;
//        controller.registerHandler(GET, "/buy_general", this);
//        controller.registerHandler(HEAD, "/buy_general", this);
//    }
//
//    @Override
//    public void handleRequest(final RestRequest request, RestChannel channel, final Client client) throws Exception {
//
//        RestStatus status = RestStatus.OK;
//        if (request.method() == RestRequest.Method.HEAD) {
//            channel.sendResponse(new BytesRestResponse(status));
//            return;
//        }
//
//        XContentBuilder builder = channel.newBuilder();
//
//        // Default to pretty printing, but allow ?pretty=false to disable
//        if (!request.hasParam("pretty")) {
//            builder.prettyPrint().lfAtEnd();
//        }
//
//        Order order = new Order("general",1);
//
//        //toc接口功过order的getAdapter的方式返回，在上面toc模快里TocAdapterFactory里，
//        // 解释了会根据order的type类型，返回对应的实现，这里会返回GenrealToc的实现。
//        Toc toc = (Toc)order.getAdapter(Toc.class);
//
//        if (toc!=null) {
//            toc.setOrderConfirmTimeout(order);
//            toc.setOrderConsignmentTimeout(order);
//        }
//
//        Ump ump = (Ump)order.getAdapter(Ump.class);
//        if (ump!=null) {
//            ump.setOrderPromation(order);
//        }
//
//        int consignment_timeout = toc.getOrderConsignmentTimeout(order);
//        int confirm_timeout = toc.getOrderConfirmTimeout(order);
//
//        float promotion = ump.getOrderPromation(order);
//
//        builder.startObject();
//        if (settings.get("name") != null) {
//            builder.field("name", settings.get("name"));
//        }
//        builder.startObject("version")
//                .field("confignment_timeout", consignment_timeout)
//                .field("confirm_timeout",confirm_timeout)
//                .field("promotion",promotion)
//                .endObject();
//        builder.endObject();
//
//        channel.sendResponse(new BytesRestResponse(status, builder));
//    }