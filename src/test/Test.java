package test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	private static int totalnum;
	public static void main(String[] args) throws Exception {
		
			URL url = new URL("http://localhost:8080/FindServer/servlet/ArticleListServletForA");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream is = conn.getInputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			while((len = is.read(buf))!=-1){
				os.write(buf, 0, len);
			}
			is.close();
			String result = os.toString();
			os.close();
//			System.out.println(result);
			String[] strings = result.split("<br/>");
			totalnum = Integer.valueOf(strings[0].trim());
			System.out.println(totalnum);
	}

}
