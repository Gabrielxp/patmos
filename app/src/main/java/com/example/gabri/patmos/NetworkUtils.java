package com.example.gabri.patmos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Jober on 01/07/2017.
 */

public class NetworkUtils {

    // HTTP POST request
    public boolean cadUsuarioPost(String email, String nome, String tel) throws Exception {

        String url = new ConnectRest().urlUsrSave;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        String urlParameters = "{\n" +
                "    \"nome\": \""+nome+"\",\n" +
                "    \"telefone\": \""+tel+"\",\n" +
                "    \"email\": \""+email+"\"\n" +
                "}";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        boolean ret = false;
        if(responseCode == 200){
            ret = true;
        }

        return ret;

    }

    // HTTP POST request
    public boolean logar(String email) throws Exception {

        String url = new ConnectRest().urlUsrLogar;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        String urlParameters = "{\n" +
                "    \"email\": \""+email+"\"\n" +
                "}";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        //print result
        System.out.println(response.toString());

        boolean ret = false;
        if(responseCode == 200){
            ret = convertBol(response.toString());
        }

        return ret;

    }

    private static boolean convertBol(String s){

        boolean b = false;

        try {
            b = Boolean.parseBoolean(s);
        }catch (Exception e){
            return false;
        }

        return b;
    }

    // HTTP GET request
    public List<Programas> buscaProgramacao() throws Exception {

        String url = new ConnectRest().urlProgramacao;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        /*
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        */

        if(responseCode == 200) {

            String ret = convertStreamToString(con.getInputStream());

            JSONArray j = new JSONArray(ret);

            List<Programas> progs = new ArrayList<>();

            for (int i = 0; i < j.length() ; i++) {
                JSONObject jprog = j.getJSONObject(i);

                Programas prog = new Programas();
                prog.setNome(jprog.getString("nomePrograma"));
                JSONObject jhrini = jprog.getJSONObject("dataHoraInicio");
                JSONObject jhrfim = jprog.getJSONObject("dataHoraFim");

                String hrini,hrfim;

                hrini = jhrini.getString("hour");

                if(jhrini.getString("hour").length() == 1) hrini = "0"+hrini;

                if(jhrini.getString("minute").length() == 1) {
                    hrini += ":0" + jhrini.getString("minute");
                }else{
                    hrini += ":"+jhrini.getString("minute");
                }

                hrini += ":00";

                hrfim = jhrfim.getString("hour");

                if(jhrfim.getString("hour").length() == 1) hrfim = "0"+hrfim;

                if(jhrfim.getString("minute").length() == 1) {
                    hrfim += ":0" + jhrfim.getString("minute");
                }else{
                    hrfim += ":"+jhrfim.getString("minute");
                }

                hrfim += ":00";

                prog.setHorario( hrini+ " - " + hrfim );

                byte[] decodedString = Base64.decode(jprog.getString("foto"), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                prog.setImg_bmp(decodedByte);

                progs.add(prog);

            }

            //print result
            System.out.println(ret);

            return progs;
        }else {
            return null;
        }
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }


}
