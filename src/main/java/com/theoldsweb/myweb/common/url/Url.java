package com.theoldsweb.myweb.common.url;/** * @描述:controller路由 * @版权: Copyright (c) 2016-2018 * @公司: lumi * @作者: 泽林 * @创建日期: 2018-10-19 * @创建时间: 下午3:30 */public interface Url {    class user {        public static final String login="/user/login";        public static final String logUp="/user/logup";        public static final String update="/user/update";        public static final String forget = "/user/forget";        public static final String index = "/user/index";        public static final String getVerificationCode = "/user/getVerificationCode";    }    class tour {        public static final String getTourList="/tour/getall";        public static final String insert="/tour/insert";        public static final String tourCommentsAdd = "/tourComments/add";        public static final String del = "/tour/del";    }    class love {        public static final String getList = "/love/getall";        public static final String insert = "/love/insert";        public static final String del = "/love/del";        public static final String update = "/love/update";    }    class activity {        public static final String getList = "/activity/getall";        public static final String insert = "/activity/insert";        public static final String del = "/activity/del";    }    class video {        public static final String getList = "/video/getall";        public static final String insert = "/video/insert";        public static final String videoCommentsAdd = "/videoComments/add";        public static final String del = "/video/del";    }    class news{        public static final String getNewsList = "/news/getList";        public static final String insert = "/news/insert";        public static final String newsCommentsAdd = "/newsComments/add";        public static final String del = "/news/del";    }    class allConfig {        public static final String getList = "/allConfig/getList";        public static final String insert = "/allConfig/insert";        public static final String delect = "/allConfig/delect";        public static final String update = "/allConfig/update";    }    class img {        public static final String imgUpload = "img/upload";    }}