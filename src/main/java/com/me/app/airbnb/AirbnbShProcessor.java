package com.me.app.airbnb;

import java.util.ArrayList;
import java.util.List;

import com.me.app.airbnb.model.Room;
import com.me.app.airbnb.util.DBUtil;
import com.me.app.airbnb.util.Util;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 
 * 列表页 详细页 抓取
 */
public class AirbnbShProcessor implements PageProcessor {

	public static final String sUrl = "https://zh.airbnb.com/s/%E4%B8%8A%E6%B5%B7--%E4%B8%AD%E5%9B%BD?guests=1&adults=1&children=0&infants=0&ss_id=jqu7jlf3&source=bb&cdn_cn=1&page=1&s_tag=N0ImGcYQ&allow_override%5B%5D=";
	// 列表页
	public static final String URL_LIST = "https://zh\\.airbnb\\.com/s/.*";
	// 详细页
	public static final String URL_DETAIL = "/rooms/\\d+.*";

	private Site site = Site.me()
			.setDomain("zh.airbnb.com")
			.setSleepTime(3000)
			// Set the interval between the processing of two pages.Time unit is
			// micro seconds.
			.setUserAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

	public Site getSite() {
		return site;
	}
	
	public void process(Page page) {
		// 列表页
		if (page.getUrl().regex(URL_LIST).match()) {
			page.addTargetRequests(page.getHtml().xpath("//div[@class=\"map-search\"]").links().regex(URL_DETAIL).all());
		} else if (page.getUrl().regex(URL_DETAIL).match()) {
			Room r = new Room();
			//roomName
			r.setRoomName(page.getHtml().xpath("//div[@id='listing_name']/text()").toString());
			//roomId
			Long roomId = Long.parseLong(Util.findStr(page.getUrl().toString(), "\\d+"));
			r.setRoomId(roomId);
			//comments
			String comments = page.getHtml()
					.xpath("//h4[@class='col-middle va-bottom review-header-text']/span/span/text()").toString();
			r.setComments(Util.findStrToInt(comments));
			//pv
			String pv = page.getHtml().xpath("//div[@class='media space-top-1']/text()").toString();
			r.setPv(Util.findStrToInt(pv));
			
			Integer count = DBUtil.findCountByRoomId(roomId);
			if (!(count > 0)) {
				// DBUtil.add(r);
			}
		}
	}

	public static void main(String[] args) {
		List<String> startUrls = new ArrayList<String>();
		startUrls
				.add("https://zh.airbnb.com/s/%E4%B8%8A%E6%B5%B7--%E4%B8%AD%E5%9B%BD?guests=1&adults=1&children=0&infants=0&ss_id=jqu7jlf3&source=bb&cdn_cn=1&page=1&s_tag=N0ImGcYQ&allow_override%5B%5D=");
		Spider.create(new AirbnbShProcessor()).startUrls(startUrls).run();
	}
}