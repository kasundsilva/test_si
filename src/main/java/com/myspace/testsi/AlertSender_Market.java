package com.myspace.testsi;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;

public class AlertSender_Market implements java.io.Serializable {
	static final long serialVersionUID = 1L;
	static public int Send(String market_alert) {
		try {
			String url_post = "https://tp-websocket.qriousdev.com/api/create-alert-post";
			URL obj = new URL(url_post);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // String payload = "{\"category\":{\"displayName\":\"Category\",\"weighting\":20},\"subCategory\":{\"name\":\"With auto reclose\",\"weighting\":4},\"id\":5,\"lat\":-45.477457,\"lng\":169.319172,\"documentLink\":\"x\",\"description\":\"Dispatch exceeds limit\",\"kind\":\"toaster\"}"
			con.setRequestMethod("POST");
			String payload = "{\"category\":{\"displayName\":\"Category\",\"weighting\":20},\"subCategory\":{\"name\":\"With auto reclose\",\"weighting\":4},\"id\":12321312321,\"lat\":-45.477457,\"lng\":169.319172,\"documentLink\":\"x\",\"description\":\"Dispatch exceeds limit\",\"kind\":\"toaster\"}";
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-requested-with", "XMLHttpRequest");

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(payload);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			return responseCode;
		} catch (Exception e) {
			return 0;
		}
	}
	public AlertSender_Market() {
	}
}
