package com.shaoku.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaoku.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
