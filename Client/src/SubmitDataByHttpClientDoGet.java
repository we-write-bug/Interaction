//import org.apache.http
//import com.sun.deploy.net.HttpResponse;
//import sun.net.www.http.HttpClient;
//import org.apache.http.client.utils.;
//
//import java.net.HttpURLConnection;
//import java.util.Map;
//
//public class SubmitDataByHttpClientDoGet{
//
//
//    public Boolean submitDataByHttpClientDoGet(Map<String, String> map, String path) throws Exception {
//        HttpClient hc = new DefaultHttpClient();
//        // 请求路径
//        StringBuilder sb = new StringBuilder(path);
//        sb.append("?");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            sb.append(entry.getKey()).append("=").append(entry.getValue());
//            sb.append("&");
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        String str = sb.toString();
//        System.out.println(str);
//        HttpGet request = new HttpGet(sb.toString());
//
//        HttpResponse response = hc.execute(request);
//        if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
//            return true;
//        }
//        return false;
//    }
//}
