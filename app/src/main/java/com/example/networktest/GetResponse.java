package com.example.networktest;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class GetResponse implements Runnable{
    private String input;
    private String response;

    public GetResponse(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at",53212);

            DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader getFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            sendToServer.writeBytes(input+'\n');

            response = getFromServer.readLine();

            Log.d("Response","Response from server : "+response);

            sendToServer.close();
            getFromServer.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getResponse() {
        return response;
    }
}
