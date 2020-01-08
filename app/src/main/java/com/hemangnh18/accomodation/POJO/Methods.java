package com.hemangnh18.accomodation.POJO;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.github.tntkhang.gmailsenderlibrary.GMailSender;
import com.github.tntkhang.gmailsenderlibrary.GmailListener;
import com.hemangnh18.accomodation.API.APIClient;
import com.hemangnh18.accomodation.API.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Methods {


    public static void AddToDatabase(Participant participant, final Context context)
    {
        SendMail(participant,context);
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Updating Registration...");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();
        ApiInterface apiService = APIClient.getClient().create(ApiInterface.class);
        Call<PostRes> call = apiService.setData("addParticipant",participant.name,participant.getEmail(),participant.getPhone(),participant.getInstitute(),participant.getId(),participant.getCity(),participant.getDays());

        call.enqueue(new Callback<PostRes>() {
            @Override
            public void onResponse(Call<PostRes> call, Response<PostRes> response) {

                progressDialog.dismiss();
                if(response.isSuccessful())
                {
                    PostRes pp = response.body();
                    Toast.makeText(context,pp.getResponce().getValue().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostRes> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(context,t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


    public static void SendMail(Participant emailto, final Context context)
    {
        GMailSender.withAccount(Config.EMAIL, Config.PASSWORD)
                .withTitle("Hello")
                .withBody("RRR NIKAL LAWDE")
                .withSender(Config.EMAIL)
                .toEmailAddress(emailto.getEmail())
                .withListenner(new GmailListener()
                {
                    @Override
                    public void sendSuccess() {
                        Toast.makeText(context, "Email Sent!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void sendFail(String err) {
                        Toast.makeText(context, "Email falilure: " + err, Toast.LENGTH_SHORT).show();
                    }
                })
                .send();
    }
}
