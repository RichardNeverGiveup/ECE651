package com.QuickBuy.service.goods.controller;

import com.QuickBuy.common.pojo.PageResult;
import com.QuickBuy.common.pojo.Result;
import com.QuickBuy.common.pojo.StatusCode;
import com.QuickBuy.goods.pojo.Brand;
import com.QuickBuy.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/brand")
@RestController
@CrossOrigin

public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping //查询品牌表
    public Result<List<Brand>> findList(){
        List<Brand> brandList = brandService.findList();
        return new Result<>(true, StatusCode.OK, "Query OK", brandList);
    }

    @GetMapping("/{id}") //根据id查询品牌表
    public Result<Brand> findById(@PathVariable("id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "Query OK", brand);
    }

    //品牌添加
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "Add OK.");
    }

    //品牌修改
    @PutMapping("/{id}")
    public Result update(@PathVariable("id") Integer id, @RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "Update OK.");
    }

    //品牌删除
    @DeleteMapping("/{id}")
    public Result delById(@PathVariable("id") Integer id){
        brandService.delById(id);
        return new Result(true, StatusCode.OK, "Delete OK.");
    }

    //品牌条件查询
    @GetMapping("/search")
    public Result<List<Brand>> search(@RequestParam Map<String, Object> searchMap){
       List<Brand> list = brandService.list(searchMap);
       return new Result<>(true, StatusCode.OK, "Query OK.", list);
    }

    //品牌分页查询
    //@GetMapping("/search/{page}/{size}")
    //public Result findPage(@PathVariable("page") int page, @PathVariable("size") int size){
    //    Page<Brand> pageInfo = brandService.findPage(page,size);
    //    PageResult<Brand> pageResult = new PageResult<>(PageInfo.EMPTY.getTotal(), pageInfo.getResult());
    //    return new Result<>(true, StatusCode.OK, "Query OK", pageResult);
    //}

    //品牌分页+查询
   /* @GetMapping("/searchPage/{page}/{size}")
    public Result findPage(@RequestParam Map<String, Object> searchMap, @PathVariable("page") int page, @PathVariable("size") int size){

        //测试手动添加异常
//        int i = 1 / 0;

        Page<Brand> pageInfo = brandService.findPage(searchMap, page, size);
        PageResult<Brand> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getResult());
        return new Result<>(true, StatusCode.OK, "Query OK.", pageResult);
    }*/


}
