package com.cloud.service;

import com.cloud.entity.Carousel;
import com.github.pagehelper.Page;

import java.util.List;

public interface CarouselService {

    Carousel queryById(String uuid);

    List<Carousel> queryAllByLimit(int offset, int limit);

    Carousel insert(Carousel carousel);

    Carousel update(Carousel carousel);

    boolean deleteById(String uuid);

    Page<Carousel> queryAll(Carousel carousel);
}