package zyf.pay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import common.util.PropertyUtil;

import java.util.Map;

/**
 * @Author zyf
 * @CreateAt 2018/1/30 下午2:30
 */
public class AlipayUtil {

    static AlipayClient alipayClient = null;

    static {
        String alipayServer = PropertyUtil.getProperty("alipay.serverUrl");
        String appId = PropertyUtil.getProperty("alipay.appId");
        String privateKey = PropertyUtil.getProperty("alipay.privateKey");
        String publicKey = PropertyUtil.getProperty("alipay.publicKey");

        alipayClient = new DefaultAlipayClient(alipayServer, appId,  privateKey,"json", "utf-8", publicKey, "RSA2");
    }

    /**
     * 生成支付的二维码
     */
    public static AlipayTradePrecreateResponse getAlipayQrcode(long tradeId, int amount) throws Exception {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + tradeId + "\"," +
                "    \"total_amount\":\"" + amount + "\"," +
                "    \"subject\":\"zyf pay\"," +
                "    \"store_id\":\"first store\"," +
                "    \"timeout_express\":\"90m\"}");//设置业务参数
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        return response;
    }

    /**
     * 交易信息查询
     */
    public static AlipayTradeQueryResponse getTradeDetail(long tradeId, long outTradeNo) throws Exception {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + outTradeNo + "\"," +
                "    \"trade_no\":\"" + tradeId + "\"}"); //设置业务参数
        AlipayTradeQueryResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        return response;
    }

    /**
     * 交易取消
     */
    public static AlipayTradeCancelResponse cancelTrade(long tradeId, long outTradeNo) throws Exception {
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + outTradeNo +"\"," +
                "    \"trade_no\":\"" + tradeId +"\"}"); //设置业务参数
        AlipayTradeCancelResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        return response;
    }

    /**
     * 退款
     */
    public static AlipayTradeRefundResponse refund(long tradeId, long outTradeNo, long refundId, int refundAmount) throws Exception {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + outTradeNo + "\"," +
                "    \"trade_no\":\"" + tradeId + "\"," +
                "    \"out_request_no\":\"" + refundId + "\"," +
                "    \"refund_amount\":\"" + refundAmount + "\"}"); //设置业务参数
        AlipayTradeRefundResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
        return response;
    }

}
