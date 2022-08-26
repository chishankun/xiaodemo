package com.shaoku.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shaoku.pojo.Book;
import com.shaoku.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private IBookService bookService;

    /**
     * 查所有
     * @return
     */
    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    /**
     * 保存
     * @param book
     * @return
     */
    @PostMapping
    public R save(@RequestBody Book book){

        boolean save = bookService.save(book);
        return new R(save,save ? "添加成功^_^" : "添加失败-_-!");
       // return new R(bookService.save(book));
    }

    /**
     * 根据id修改
     * @param book
     * @return
     */
    @PutMapping
    public R update(@RequestBody Book book){
        boolean updateById = bookService.updateById(book);

        return new R(updateById,updateById ? "修改成功^_^" : "修改失败-_-!");
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    /**
     * 根据id查对象
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){

        return new R(true,bookService.getById(id));

    }

    /**
     * 分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }

        return new R(true,page);
    }

}
