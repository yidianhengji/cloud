package com.cloud.service.impl;

import com.cloud.dao.CarouselMapper;
import com.cloud.entity.Carousel;
import com.cloud.handler.BusinessException;
import com.cloud.service.CarouselService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Resource
    private CarouselMapper carouselDao;

    @Override
    public Carousel queryById(String uuid) {
        return this.carouselDao.queryById(uuid);
    }

    @Override
    public List<Carousel> queryAllByLimit(int offset, int limit) {
        return this.carouselDao.queryAllByLimit(offset, limit);
    }

    @Override
    public Carousel insert(Carousel carousel) {
        carousel.setUuid(UUID.randomUUID().toString().replace("-", ""));
        carousel.setModifyTime(new Date());
        carousel.setCreateTime(new Date());
        this.carouselDao.insert(carousel);
        return carousel;
    }

    @Override
    public Carousel update(Carousel carousel) {
        if (StringUtil.isEmpty(carousel.getUuid())) {
            throw new BusinessException(500, "uuid必传");
        }
        carousel.setModifyTime(new Date());
        this.carouselDao.update(carousel);
        return this.queryById(carousel.getUuid());
    }

    @Override
    public boolean deleteById(String uuid) {
        return this.carouselDao.deleteById(uuid) > 0;
    }

    @Override
    public Page<Carousel> queryAll(Carousel carousel) {
        if (carousel.getPageSize() != null && carousel.getPageNum() != null) {
            PageHelper.startPage(carousel.getPageNum(), carousel.getPageSize());
        }
        Page<Carousel> pages = this.carouselDao.queryAll(carousel);
        return pages;
    }
}