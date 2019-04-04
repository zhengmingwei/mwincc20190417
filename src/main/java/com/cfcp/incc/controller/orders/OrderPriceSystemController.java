package com.cfcp.incc.controller.orders;

import com.cfcp.incc.dto.CommonDto;
import com.cfcp.incc.entity.OrderPriceSystem;
import com.cfcp.incc.service.orders.OrderPriceSystemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tigerfacejs.commons.view.DataEvent;

import java.util.List;

@RestController
@RequestMapping("manager/orderPriceSystem")
public class OrderPriceSystemController {

    @Autowired
    private OrderPriceSystemService service;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object get(@PathVariable String id){
        System.out.println("+++++++++++"+id);
        OrderPriceSystem dictionary = service.findOrderPriceSystemById(id);
        return DataEvent.wrap("orderPriceSystem", new CommonDto<OrderPriceSystem>(dictionary));
    }
    @RequestMapping(value = "query")
    public Object query() {
        PageInfo<OrderPriceSystem> pageInfo= (PageInfo<OrderPriceSystem>) service.queryAll();
        //pageInfo.getList().forEach(item->item.setIndustryPo(dictionaryService.findDictionaryById(item.getIndustry())));
        return DataEvent.wrap("orderPriceSystemList", pageInfo);
    }

    @RequestMapping(value = "query2")
    public Object query2() {
        List<OrderPriceSystem> pageInfo= (List<OrderPriceSystem>) service.queryAll();
        //pageInfo.getList().forEach(item->item.setIndustryPo(dictionaryService.findDictionaryById(item.getIndustry())));
        return DataEvent.wrap("orderPriceSystemList", pageInfo);
    }
}
