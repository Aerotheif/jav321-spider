package com.aerothief.util;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DocumentUtils {
    public static Document doc;
    public static String path;
    public static String videoPath;
    public static void setDoc(String url) throws HttpStatusException{
        videoPath=url.split("/")[url.split("/").length-1];
        path=url;
        doc=null;
        String proxyHost = "127.0.0.1";
        String proxyPort = "1080";
        System.getProperties().setProperty("http.proxyHost", proxyHost);
        System.getProperties().setProperty("http.proxyPort", proxyPort);
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
        try {
            Connection connection=Jsoup.connect(url).timeout(50000);
            Map<String, String> header = new HashMap<String, String>();
            header.put("Host", "http://www.jav321.com");
            header.put("User-Agent", "  Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0");
            header.put("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            header.put("Accept-Language", "zh-cn,zh;q=0.5");
            header.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
            header.put("Connection", "keep-alive");
            Connection data = connection.headers(header);
            doc=data.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Document getDoc() {
        return doc;
    }
}
