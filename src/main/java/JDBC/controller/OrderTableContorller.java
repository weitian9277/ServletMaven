package JDBC.controller;

import JDBC.anno.ContentType;
import JDBC.eneity.State;
import JDBC.service.OrderDetailService;
import JDBC.service.OrderTableService;
import JDBC.service.impl.OrderDetailServiceImpl;
import JDBC.service.impl.OrderTableServiceImp;
import JDBC.utile.GetTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
@WebServlet("/ajax/orderTable")
public class OrderTableContorller extends  BaseController {
    private static OrderTableService  orderTableServiceImp = new OrderTableServiceImp();
    private static OrderDetailService  orderDetailService = new OrderDetailServiceImpl();

    /**
     *  添加订单
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object addOrderTable(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String orderId = UUID.randomUUID().toString();
        String orderStatus = req.getParameter("orderStatus");  // 订单状态
        String paymentStatus = req.getParameter("paymentStatus");  //支付状态
        String zMoney = req.getParameter("zMoney");  //总金额
        String updateTime = GetTime.getThisTime();  //更新时间
        String creationTime = GetTime.getThisTime();;  //创建时间
        String buyerAddress = req.getParameter("buyerAddress");  //买家地址
        String buyerTel = req.getParameter("buyerTel");  //买家电话
        String buyerName = req.getParameter("buyerName");  //买家id
        Object[] params = {orderId,orderStatus,paymentStatus,zMoney,updateTime,creationTime,buyerAddress,buyerTel,buyerName};
        int i = orderTableServiceImp.addOrderTableService(params);
        State state;
        if(i <=1){
              state = new State(200, "成功", new String(orderId));
        }else {
            state = new State(-1, "失败");
        }
        return  state;
    }

    /**
     * 添加对应订单中的商品详情
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @ContentType(value = "application/json;charset=utf-8")
    public  static  Object addOrderDeail(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String orderId = req.getParameter("orderId");  //订单编号
        String goodsNum = req.getParameter("goodsNum");  //商品数量
        String goodsImg = req.getParameter("goodsImg");  //商品图片
        String goodsPrice = req.getParameter("goodsPrice");  //商品价格
        String goodsName = req.getParameter("goodsName");  //商品名称
        String goodsId = req.getParameter("goodsId");  //商品id

        System.out.println("商品id"+goodsId);
        Object[] params = {orderId,goodsNum,goodsImg,goodsPrice,goodsName,goodsId};
        for (Object param : params) {
            System.out.println(param);
        }
        return orderDetailService.addOrderDetailService(params);
    }

}
