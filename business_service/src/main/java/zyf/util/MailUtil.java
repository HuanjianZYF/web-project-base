package zyf.util;

import com.sun.mail.util.MailSSLSocketFactory;
import common.util.CommonUtil;
import common.util.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.*;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;

/**
 * @Author zyf
 * @CreateAt 2018/1/19 上午10:17
 * 邮件发送工具类
 */
public class MailUtil {

    private static Logger logger = LoggerFactory.getLogger(MailUtil.class);
    private static JavaMailSenderImpl sender;
    private static Properties props;

    static {
        sender = new JavaMailSenderImpl();
        props = new Properties();

        sender.setHost("smtp.qq.com"); //邮件服务器
        sender.setUsername("1127848112@qq.com"); //发送人服务器用户名
        sender.setPassword("zygvjkjvzrvcrrghhbf");
        sender.setDefaultEncoding("UTF-8");

        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e){
            logger.error("邮件发送初始化信息失败！");
        }

        props.put("mail.smtp.ssl.enable", "true");//ssl安全协议
        props.put("mail.smtp.ssl.socketFactory", sf);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.timeout", "25000");
        sender.setJavaMailProperties(props);

    }
    /**
     * 发送一封邮件,正文按html展示
     * to 收件人
     * title 邮件主题
     * body 邮件正文
     * attachments 附件
     */
    public static void sendEmail(String to, String subject, String body, List<String> attachments) throws Exception {

        MimeMessage mail = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail,true);

        helper.setFrom(PropertyUtil.getProperty("mail.from"));
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        //获得邮件附件
        if (CommonUtil.isNotEmpty(attachments)) {
            for (String attachment : attachments) {
                FileSystemResource mailImage = new FileSystemResource(attachment);
                helper.addAttachment(mailImage.getFilename(), mailImage);
            }
        }

        sender.send(mail);
    }

}
