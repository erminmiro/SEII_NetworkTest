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
    Socket clientSocket;
    DataOutputStream sendToServer;
    BufferedReader getFromServer;

    public GetResponse(String input) {
        this.input = input;
    }

    @Override
    public void run() {
            setUp();

            getResponseFromServer(input);

            closeConnection();
    }

    public void setUp(){
        try {

            clientSocket = new Socket("se2-isys.aau.at",53212);
            sendToServer = new DataOutputStream(clientSocket.getOutputStream());
            getFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getResponseFromServer(String input){
        try {

            sendToServer.writeBytes(input+'\n');

            response = getFromServer.readLine();

            Log.d("Response","Response from server : "+response);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void closeConnection(){
        try {

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
