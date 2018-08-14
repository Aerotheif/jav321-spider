import com.aerothief.common.Const;
import com.aerothief.service.StarService;
import com.aerothief.service.VideoService;
import com.aerothief.service.impl.StarServiceImpl;
import com.aerothief.service.impl.VideoServiceImpl;
import com.aerothief.util.DocumentUtils;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;


public class NetCatch {
    @Test
    public void getNetDom() throws IOException {
        String proxyHost = "127.0.0.1";
        String proxyPort = "1080";
        System.getProperties().setProperty("http.proxyHost", proxyHost);
        System.getProperties().setProperty("http.proxyPort", proxyPort);
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
        String url=Const.URL+Const.VIDEO_PATH+"avop00127";
//        String url="https://www.google.com";
        StarService starService=new StarServiceImpl();
        try{
            Document doc=Jsoup.connect(url).get();
            starService.getStarFromVideoCode(doc);
            System.out.println(doc);
        }catch (HttpStatusException exception){
        }
    }
}
