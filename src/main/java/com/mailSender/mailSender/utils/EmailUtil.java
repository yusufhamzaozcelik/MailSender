package com.mailSender.mailSender.utils;

public class EmailUtil {

    public static String getEmailMessage(String name,String host,String token){
        return "Hello"+ name+"\n\n Your new account has been created.Please click the link below to verify your account \n\n"+
                getVerificationUrl(host, token) +"\n\n The Tech Team";
    }

    public static String getVerificationUrl(String host,String token){
        return host+ "/api/users/confirm?token="+token;
    }
}
