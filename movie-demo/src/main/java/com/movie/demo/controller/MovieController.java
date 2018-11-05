package com.movie.demo.controller;


import com.movie.demo.comm.po.ResultVM;
import com.movie.demo.entity.Movie;
import com.movie.demo.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-11-03
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private IMovieService movieService;

    @RequestMapping("getMovieById")
    public ResultVM getMovieById(@RequestParam("id") Integer id){
        Movie movie = movieService.selectById(id);
        return ResultVM.ok(movie);
    }
}

