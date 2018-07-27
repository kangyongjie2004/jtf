package order;

import com.jd.jtf.demo.plugin.order.OrderInfo;
import com.jd.jtf.demo.plugin.order.inter.IOrderService;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/17 15:17
 */
public class OrderService implements IOrderService{

    @Override
    public String getBusinessType() {
        return null;
    }

    @Override
    public void setBusinessType(String businessType) {

    }

    @Override
    public OrderInfo CreateOrder(String orderId, String orderType) {
        return null;
    }

    @Override
    public String deleteOrder(String orderId, String orderType) {
        return null;
    }

    @Override
    public OrderInfo getOrderInfo(String orderId, String businessType) {
        return null;
    }

    @Override
    public float getCoupon(String orderId, String orderType) {
        return 0;
    }
}
