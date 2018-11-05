package com.movie.demo.dao;

import com.movie.demo.entity.Movie;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-11-03
 */
@Repository
public interface MovieDao extends BaseMapper<Movie> {

}
