package com.example.administrator.kotlintest.bean

/**
 * Created by Administrator on 2017/12/9.
 */

data class ImgBean(
        val tag1: String, //美女
        val tag2: String, //全部
        val totalNum: Int, //16870
        val start_index: Int, //1
        val return_number: Int, //20
        val data: List<Data>
)

data class Data(
        val id: String, //9385900259
        val setId: String, //168137
        val pn: Int, //1
        val abs: String, //气质清纯MM野外自拍
        val desc: String, //气质清纯MM野外自拍
        val tags: List<String>,
        val tag: String, //全部
        val date: String, //2016-10-25
        val like_num: String,
        val is_single: String,
        val fashion_id: String,
        val dress_id: String,
        val fushi_obj_num: String,
        val fushi_obj_array: String, //null
        val dress_buy_link: String,
        val dress_price: String,
        val dress_tag: String,
        val dress_num: String,
        val dress_discount: String,
        val dress_other: String,
        val dress_extend_type: String,
        val dress_extend_name: String,
        val children_vote: String,
        val dislike_num: String,
        val image_url: String, //http://d.hiphotos.baidu.com/image/pic/item/2934349b033b5bb52a9264e134d3d539b600bc6c.jpg
        val image_width: Int, //851
        val image_height: Int, //565
        val download_url: String, //http://d.hiphotos.baidu.com/image/pic/item/2934349b033b5bb52a9264e134d3d539b600bc6c.jpg
        val thumbnail_url: String, //http://imgt9.bdstatic.com/it/u=2,795965667&fm=25&gp=0.jpg
        val thumbnail_width: Int, //230
        val thumbnail_height: Int, //152
        val thumb_large_width: Int, //310
        val thumb_large_height: Int, //205
        val thumb_large_url: String, //http://imgt7.bdstatic.com/it/u=2,795965667&fm=19&gp=0.jpg
        val site_name: String,
        val site_logo: String,
        val site_url: String, //http://www.mm522.net
        val from_url: String, //http://www.mm522.net/wangluo/qingchunmm/24/4701_14.html
        val obj_url: String, //http://img.mm522.net/flashAll/20110525/1306331468AIJVRi.jpg
        val share_url: String, //http://d.hiphotos.baidu.com/image/s%3D550%3Bc%3Dwantu%2C8%2C95/sign=b03b8addb0119313c343ffb555036fea/2934349b033b5bb52a9264e134d3d539b600bc6c.jpg?referer=6e6870c63b01213f96247becfc22
        val download_num: Int, //0
        val collect_num: Int, //0
        val start_index: Int, //1
        val return_number: Int, //20
        val album_di: String,
        val can_album_id: String,
        val album_obj_num: String, //17
        val user_id: String, //862715074
        val app_id: String,
        val colum: String, //美女
        val photo_id: String, //9385900259
        val is_album: Int, //0
        val is_vip: Int, //0
        val from_name: Int, //0
        val hostname: String, //www.mm522.net
        val parent_tag: String,
        val desc_info: String,
        val other_urls: List<Any>,
        val isAdapted: Int //1
)