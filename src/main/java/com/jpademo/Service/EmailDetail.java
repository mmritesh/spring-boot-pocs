package com.jpademo.Service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ritesh on 21-10-2016.
 */
@Getter
@Setter
public class EmailDetail {

    private String toAddress;
    private String ccAddress;
    private String bccAddress;

    private String subject;
    private String body;
    private boolean htmlBody;

    private List<String> fileAttachment;


}
