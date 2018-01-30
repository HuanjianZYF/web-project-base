package zyf.test;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import common.util.PropertyUtil;
import org.junit.Before;
import org.junit.Test;
import zyf.pay.AlipayUtil;

/**
 * @Author zyf
 * @CreateAt 2018/1/30 上午11:37
 */
public class AlipayTest {

    AlipayClient alipayClient = null;
    @Before
    public void before() {
        String alipayServer = PropertyUtil.getProperty("alipay.serverUrl");
        String appId = PropertyUtil.getProperty("alipay.appId");
        String privateKey = PropertyUtil.getProperty("alipay.privateKey");
        String publicKey = PropertyUtil.getProperty("alipay.publicKey");
//        alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016091200493571",
//                "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCZ1qB8XbPj90zQ6HYIDaPGSDhhVQfxFk3frO2A5bC/uB5b3cPBUQQwV1DQpNILvhXOPZsAkYwRwundN9AVG/tnGNwHg7TIMKybW9DPsZi8byPwNpB7tvTUt3l41OwJ4qyy78FsGgTQMt0Eiy71+lfsmP7YkN/lZ6QIB+BQbQMwoQISpsY1EKw6hXD7Em+801+4Tl4l0iuYzD57RV5rfoBxTOqlT5I21QRaiuYup+wwioFhj9bMCVSqLq3hT28fJaSPLs32VtJW2Biebi0W9coirz4w5uDlOLc0aqqj/pp+OAjk4aIVTJSpeF6acqZ9rpjXt86CWEq93/zSklWS3JsxAgMBAAECggEAPnjwV1DeGrd01GlydTbEyWLOsogLX5ZFLY5WLMAaFOE6Qug99KVn5BGxWel0+xvIUyalaYexsAzNV+6wa8IfR/DKeaq8oYdSsQyKMa3Xbr5bg9NEvVjA+BlCFRWyfRk2NLw0eifeyIW/R3cWLQHq7sP6ygubQNfjvvcj2sVKRFadA7uFasz0LgVK0oaPtXpDo+jA83YnpHZMKB4Sy6k2eFWRql4BjOmUXCd/W5WaTf4JcXmZ1NNSOLcMqcwgKK7kohdNknixXnDfugwj1t2EQDAtZCz55pV77RGR7DZVLL2LnlLqGIT3GNT9P4eUz+uHxtejSjBX/A2qIE7+V48NgQKBgQDJi1BPenOMurvbXKtZ3fWlemZ5/pXAMXIRxVrXhzj6I2i9kwR+a7LLos90iULbwEUv2sypMjGeF3ztW+RWyQzvQC4VbmouD14p3VhPgrTu65nVM3pK/deFgWukBKvllXV/sBP6HqmfODD29VPLZvzfxmiPqiShjtCe8sSDgOWkOQKBgQDDZ4g9m7bG7/M1FZGZYZG+9BX6KNJ3HR0HxQjz4KKxZte1uDR0SE3v8WPM4ah+lHkwhMpDrpvLxd/aLS9wPwUhaqrsL+hzCcwFAPTzTvHuauMvCqz0hUCoZG7dtIpFm2qOofRgzroMTJdbcXB1yUIMnVk6jl6x0V/WZolAB3xeuQKBgELJJHrB1Ap9UoT1Z16nO6BzOAQTBeKjP+59nIWxLINPOoUfc6zE2YG7WM2AMqSJSSP7eDhVBrYhiGdLPRY5F00s0liNtye+NfDfhUULxhMqBVbt8QdqqIF4CohWd/PjHAWM/oGyqXi2cRtU3kiXvxIUOE/rDKpwndceEVqWWwKZAoGAWbaJ9YctVo7KAaBCdcI3EQ2tnWnqnydtsaiD4LxM1dgax2KoKo8bwUL5iBI+ssbmESGWX5amDtttWBUQx58Xcu0vRjsEpPRliBKVY7PmHYlTfsCPAcDAG8/omr+OEEE3nf67XUrsXkM35pLhiCJ7waDoW5sL3OX880mmUBBfyHkCgYBx8VJGvm0H4TgYeGVWr8bkhL6nN9ssnHSU4iiKypItoag9jmWhSAjOmTfORu84b3q/DSgwTcH3NqgC3ruIYJaXvrg/zAtSJxu6cF5B9Go3RD7Xtmg3/ZgplVEaz4xxYdjDYdQyepRR+K26oUKK2mMSZzb1AH/wmwuBif5xoobV5g==","json","utf-8",
//                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7znmfmlGQM5lxWdgTgwjvnJKAdzcwaMLEtUMfpjpFcG2zGmh/ysb5Ir8LIp7NzqBRgqoOlEm64OHHWuxXETbEGX76UY4URHBr/pTHgYQH0NyeBHs2FNqPro1zAqJM5bFm7Qe7mgbN6QIa5OiuTg6iXZKRhwQD6oT0xVeBI4TJPMdZ4uD6r1TuuPWtufEz+r/cwtJQl62KYmSsheAgc48qCcBxoFXqneJ8OvymSxcwwL0rX1Qx2Pq8IP57GCGx8FlbjeKByxFDHCBklQXKiwNB2nZXuz+icQ0FMbKm6pctrCrPe39jdtJMohUS+IDGCYe89OHgvPNTfK4/+9CMTXFgwIDAQAB","RSA2" );

        alipayClient = new DefaultAlipayClient(alipayServer, appId,  privateKey,"json", "utf-8", publicKey, "RSA2");
    }

    @Test
    public void testAlipayClient() throws Exception {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101003\"," +
                "    \"total_amount\":\"88.88\"," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"store_id\":\"NJ_001\"," +
                "    \"timeout_express\":\"90m\"}");//设置业务参数
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        System.out.print(response.getBody());
    }

    @Test
    public void testAlipayUtil() throws Exception {
        System.out.println(AlipayUtil.getAlipayQrcode(1L, 1));
    }

    @Test public void testGetTradeDetail() throws Exception {
        AlipayTradeCancelResponse response = AlipayUtil.cancelTrade(20150320010101003L, 20150320010101003L);

        System.out.println(JSON.toJSON(response));
    }
}
