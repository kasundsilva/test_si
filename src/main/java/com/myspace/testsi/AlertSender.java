package com.myspace.testsi;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;

public class AlertSender implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    static public int Send(String payload) {
        try {
            String url_post = "https://tp-websocket.qriousdev.com/api/create-alert-post";
            URL obj = new URL(url_post);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("x-requested-with", "XMLHttpRequest");

            String payload1 = "{\"category\":{\"displayName\":\"Category\",\"weighting\":20},\"subCategory\":{\"name\":\"With auto reclose\",\"weighting\":4},\"id\":12321312321,\"lat\":-45.477457,\"lng\":169.319172,\"documentLink\":\"x\",\"description\":\"Island Totals Exceeds Limit\",\"kind\":\"toaster\"}";

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(payload1);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            return responseCode;
        } catch (Exception e) {
            return 0;
        }
    }
    public AlertSender() {}
}
