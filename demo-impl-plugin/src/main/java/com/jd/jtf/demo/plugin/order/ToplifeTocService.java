package order;

import com.jd.jtf.demo.plugin.order.inter.ITocService;

/**
 * =========================================================
 * 京东 - 技术拓展研发部 - 智能研发组
 * 类说明：
 *
 * @author kangyongjie E-mail: kangyongjie@jd.com
 * @version Created ：2018/7/17 15:15
 */
public class ToplifeTocService implements ITocService{
    @Override
    public int getTimeout() {
        return 50;
    }
}
