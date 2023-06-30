package com.example.design.mode.factory.factoryabs;

import com.example.design.mode.factory.EmailU;
import com.example.design.mode.factory.SendServiceInterface;
import com.example.design.mode.factory.SmsU;

public class SendFactory {

    public static SendServiceInterface email() {
        return new EmailU();
    }

    public static SendServiceInterface sms() {
        return new SmsU();
    }
}
