package com.cloud.dao;

import com.cloud.entity.Carousel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarouselMapper {

    Carousel queryById(@Param(value = "uuid") String uuid);

    List<Carousel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    Page<Carousel> queryAll(Carousel carousel);

    int insert(Carousel carousel);

    int update(Carousel carousel);

    int deleteById(String uuid);

}