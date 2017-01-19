package com.dassmeta.passport.web.home;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.dassmeta.stockspider.core.service.StockService;
import com.dassmeta.stockspider.util.PageConstant;
import com.dassmeta.stockspider.util.PageList;

@Controller
public class StockController {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/stocks.json", method = RequestMethod.GET)
	public void home(ModelMap model, Integer pageSize, Integer pageNumber, String search) {

		if (pageNumber == null || pageNumber <= 0) {
			pageNumber = 1;
		}

		if (pageSize == null || pageSize <= 0) {
			pageSize = PageConstant.PAGE_SIZE_15;
		}

		if (null != search) {
			search = search.trim();
		}

		PageList<?> pageList = stockService.findByPage(pageNumber, pageSize, search);
		JSONObject data = new JSONObject();
		data.put("total", pageList.getPaginator().getItems());
		data.put("pageSize", pageSize);
		data.put("pageNumber", pageList.getPaginator().getPage());
		data.put("rows", pageList);
		data.put("search", search);

		model.put("data", JSONObject.toJSON(data));
	}

	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	public String index() {
		return "stocks";
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

}