package com.example.otp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

public class OTP_Receiver extends BroadcastReceiver {

    private static EditText editText;

    public void setEditText(EditText editText){
        OTP_Receiver.editText = editText;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {

        SmsMessage[ ] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

        for (SmsMessage sms : messages){
            String message = sms.getMessageBody();
            String otp = message.split(":")[1];
            editText.setText(otp);
        }
    }
}
