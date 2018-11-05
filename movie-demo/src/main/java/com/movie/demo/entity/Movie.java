package com.movie.demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2018-11-03
 */
@TableName("tb_movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 电影ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 电影名称
     */
    private String movieName;
    /**
     * 电影内容
     */
    private String movieContent;
    /**
     * 电影封面
     */
    private String moviePic;
    /**
     * 电影简介
     */
    private String movieBrief;
    /**
     * 下载链接
     */
    private String downloadUrl;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieContent() {
        return movieContent;
    }

    public void setMovieContent(String movieContent) {
        this.movieContent = movieContent;
    }

    public String getMoviePic() {
        return moviePic;
    }

    public void setMoviePic(String moviePic) {
        this.moviePic = moviePic;
    }

    public String getMovieBrief() {
        return movieBrief;
    }

    public void setMovieBrief(String movieBrief) {
        this.movieBrief = movieBrief;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
        ", id=" + id +
        ", movieName=" + movieName +
        ", movieContent=" + movieContent +
        ", moviePic=" + moviePic +
        ", movieBrief=" + movieBrief +
        ", downloadUrl=" + downloadUrl +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
