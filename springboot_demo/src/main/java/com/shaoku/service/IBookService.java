package com.shaoku.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shaoku.pojo.Book;
import org.springframework.stereotype.Service;


public interface IBookService extends IService<Book> {
    //IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int pages, int pageSize, Book book);
}
