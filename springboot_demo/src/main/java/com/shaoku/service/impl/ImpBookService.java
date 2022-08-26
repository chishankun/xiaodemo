package com.shaoku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaoku.dao.BookDao;
import com.shaoku.pojo.Book;
import com.shaoku.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpBookService extends ServiceImpl<BookDao, Book> implements IBookService {
        @Autowired
        private BookDao bookDao;

//    @Override
//    public IPage<Book> getPage(int currentPage, int pageSize) {
//        IPage page = new Page(currentPage,pageSize);
//        bookDao.selectPage(page,null);
//        return page;
//    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book queryBook) {
        IPage page = new Page(currentPage,pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(queryBook.getName()),Book::getName,queryBook.getName());
        lqw.like(Strings.isNotEmpty(queryBook.getType()),Book::getType,queryBook.getType());
        lqw.like(Strings.isNotEmpty(queryBook.getDescription()),Book::getDescription,queryBook.getDescription());
        bookDao.selectPage(page,lqw);
        return page;
    }
}
