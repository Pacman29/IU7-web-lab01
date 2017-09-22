package task_options;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.Buffer;

public class UrlChecker {
    public static Request sendRequest(String url, String method) throws IOException {
        try {
            URL _url = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) _url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod(method);

            BufferedReader br;
            StringBuilder stringBuilder = new StringBuilder();

            if (200 <= httpURLConnection.getResponseCode() && httpURLConnection.getResponseCode() <= 299) {
                if(httpURLConnection.getInputStream() == null){
                    return new Request(url,httpURLConnection.getHeaderFields(),null, null);
                }

                br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
                String line;
                while ((line = br.readLine()) != null){
                    stringBuilder.append(line);
                }

                return new Request(url,httpURLConnection.getHeaderFields(),stringBuilder.toString(),null);
            } else {
                if(httpURLConnection.getErrorStream() == null){
                    return new Request(url,httpURLConnection.getHeaderFields(),null, null);
                }

                br = new BufferedReader(new InputStreamReader((httpURLConnection.getErrorStream())));

                String line;
                while ((line = br.readLine()) != null){
                    stringBuilder.append(line);
                }

                return new Request(url,httpURLConnection.getHeaderFields(),null, stringBuilder.toString());
            }
        } catch (SocketTimeoutException e){
            return new Request(url,null,null, "connect timed out");
        }

    }
}
