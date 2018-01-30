package zyf.test;

import com.sun.mail.util.MailSSLSocketFactory;
import zyf.util.MailUtil;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @Author zyf
 * @CreateAt 2018/1/19 上午9:12
 */
public class JavaMailTest {

    @Test
    public void testSendMail() throws Exception {
        String from = "123456@qq.com";
        String to = "1127848112@qq.com";
        String subject = "test";
        String body = "<h5>zyf is the best! </h5>" +
                "<img src='/Users/zyf/Downloads/4309CD4C-57C2-4083-8D06-296D0AC6D4C0.jpg' />";

        Session session = Session.getDefaultInstance(new Properties());
        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(from));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSentDate(new Date());
        msg.setSubject(subject);

        MimeMultipart multipart = new MimeMultipart("related");

        MimeBodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent(body, "text/html;charset=utf8");
        multipart.addBodyPart(htmlBodyPart);


        MimeBodyPart gifBodyPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource("/Users/zyf/Downloads/4309CD4C-57C2-4083-8D06-296D0AC6D4C0.jpg");
        gifBodyPart.setFileName("zyf图片");
        gifBodyPart.setDataHandler(new DataHandler(fds));
        multipart.addBodyPart(gifBodyPart);


        MimeMultipart allPart = new MimeMultipart();
        MimeBodyPart part1 = new MimeBodyPart();
        part1.setContent(multipart);

        MimeBodyPart part2 = new MimeBodyPart();
        FileDataSource fds2 = new FileDataSource("/Users/zyf/Downloads/1.pdf");
        part2.setDataHandler(new DataHandler(fds));
        part2.setFileName(fds2.getName());

        allPart.addBodyPart(part1);
        allPart.addBodyPart(part2);

        msg.setContent(allPart);
        msg.saveChanges();
        msg.writeTo(new FileOutputStream("/Users/zyf/Downloads/1.eml"));
    }

    @Test
    public void testMailUtil() throws Exception {
        String body = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />" +
                "</head><body><h1>你好纳纳<h1>" +
                "<table><tr bgcolor='yellow'><td>你好可爱<td></tr></table>" +
                "<br /></body></html>";

        List<String> list = new ArrayList<>();
        list.add("/Users/zyf/Downloads/1.pdf");
        list.add("/Users/zyf/Downloads/循环结构流程图.pdf");
        list.add("/Users/zyf/Downloads/1.jpg");

        MailUtil.sendEmail("1312594167@qq.com", "test", body, list);
    }

    @Test
    public void testSpringMail() throws Exception {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

        senderImpl.setHost("smtp.qq.com"); //邮件服务器
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("1127848112@qq.com");  //收信人邮箱
        mailMessage.setFrom("1127848112@qq.com "); //发送人邮箱
        mailMessage.setSubject("测试");  //邮件主题
        mailMessage.setText("测试");  //邮件内容
        senderImpl.setUsername("1127848112@qq.com"); //发送人服务器用户名
        senderImpl.setPassword("gvjkjvzrvcrrghhb"); //此处为授权码，而非邮箱密码
        Properties prop = new Properties();
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");//ssl安全协议
        prop.put("mail.smtp.ssl.socketFactory", sf);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);
        senderImpl.send(mailMessage);
    }
}
