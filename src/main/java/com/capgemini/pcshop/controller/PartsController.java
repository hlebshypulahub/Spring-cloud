package com.capgemini.pcshop.controller;

import com.capgemini.pcshop.data.Order;
import com.capgemini.pcshop.data.Part;
import com.capgemini.pcshop.data.PartsMapper;
import com.capgemini.pcshop.service.PartsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*TODO: List all parts as json */
@RestController
@RequestMapping("api/v1/parts")
public class PartsController {

    final PartsService partsService;
    final PartsMapper partsMapper;

    public PartsController(PartsService partsService, PartsMapper partsMapper) {
        this.partsService = partsService;
        this.partsMapper = partsMapper;
    }

//    @GetMapping
//    public String getParts() throws PartsMappingException {
//        return partsMapper.toCollectionDto(partsService.getParts());
//    }

    @GetMapping
    public List<Part> getParts() {
        return new ArrayList<>(partsService.getParts());
    }

    @GetMapping("{id}")
    public Part getPart(@PathVariable int id) {
        return partsService.getPartById(id);
    }

    @PostMapping("order")
    public Order createOrder(@RequestBody Order order) {
        order.generateOrderId();
        return order;
    }


}
