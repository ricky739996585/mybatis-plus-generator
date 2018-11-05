package com.movie.demo.service.impl;

import com.movie.demo.entity.Movie;
import com.movie.demo.dao.MovieDao;
import com.movie.demo.service.IMovieService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-11-03
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieDao, Movie> implements IMovieService {

}
