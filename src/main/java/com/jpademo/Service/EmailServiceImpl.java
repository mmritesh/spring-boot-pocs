package com.jpademo.Service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.File;
import java.util.List;

/**
 * Created by Ritesh on 20-10-2016.
 */
@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendEmail(EmailDetail emailDetail) {

        MimeMessagePreparator preparator = new MimeMessagePreparator()
        {
            public void prepare(javax.mail.internet.MimeMessage mimeMessage) throws Exception
            {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
                message.setTo(emailDetail.getToAddress());
                message.setSubject(emailDetail.getSubject());

                if (!emailDetail.isHtmlBody())
                    message.setText(emailDetail.getBody());
                else
                    message.setText(emailDetail.getBody(),true);

                if (emailDetail.getFileAttachment() != null) {
                    emailDetail.getFileAttachment().forEach(filePath -> {
                        FileSystemResource file = new FileSystemResource(new File(filePath));
                        try {
                            message.addAttachment(file.getFilename(), file);
                        } catch (MessagingException e) {
                            System.out.println("Attachment failed");
                            e.printStackTrace();
                        }

                    });
                }
            }
        };

        try {
            javaMailSender.send(preparator);
            return true;
        } catch (Throwable th) {
            //LOG.error(String.format("Can't send email. Cause by: %s", th.getMessage()), th);
            System.out.println("Can't send email. Cause by: "+ th.getMessage());
            return false;
        }

    }
}

