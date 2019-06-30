package com.example.week2.bean;

import java.util.List;

public class GoldBean {


    /**
     * error : false
     * results : [{"_id":"5cf46c3a9d212203197e0f08","createdAt":"2019-06-03T10:09:11.787Z","desc":"码个蛋周刊 --- ARM发布新架构，国际计算机学术界封杀华为，王海峰升任百度CTO","publishedAt":"2019-06-03T10:12:26.220Z","source":"web","type":"瞎推荐","url":"https://mp.weixin.qq.com/s/ClkQRpP4K3pGYOy6aDsuNg","used":true,"who":"潇湘剑雨"},{"_id":"5cef26eb9d2122031ea521e6","createdAt":"2019-05-31T07:38:39.232Z","desc":"Gradle这么差还来面腾讯？","publishedAt":"2019-05-31T07:38:46.826Z","source":"web","type":"瞎推荐","url":"https://mp.weixin.qq.com/s/2hxeo5yvOqSdFF8lKnxtjg","used":true,"who":"潇湘剑雨"},{"_id":"5ce2466e9d212239d75618a5","createdAt":"2019-05-20T06:17:18.914Z","desc":"基于 Chrome 扩展程序的 Swagger 资源渲染程序","publishedAt":"2019-05-29T01:28:17.0Z","source":"web","type":"瞎推荐","url":"https://www.v2ex.com/t/565724","used":true,"who":"潇湘剑雨"},{"_id":"5ce4ea469d212239df927abe","createdAt":"2019-05-22T06:20:54.280Z","desc":"JAVA开发的轻论坛系统，特点就是前端界面好看，功能强大","publishedAt":"2019-05-28T05:47:18.153Z","source":"web","type":"瞎推荐","url":"https://github.com/diyhi/bbs","used":true,"who":"潇湘剑雨"},{"_id":"5cd3de829d212239d756188d","createdAt":"2019-05-09T08:02:10.198Z","desc":"时隔五年，Scrapyd 终于原生支持 basic auth","publishedAt":"2019-05-10T01:26:25.32Z","source":"web","type":"瞎推荐","url":"https://github.com/my8100/files/blob/master/scrapyd-basic-auth/README_CN.md","used":true,"who":"潇湘剑雨"},{"_id":"5ccff5f49d212239da9c6aad","createdAt":"2019-05-06T14:54:28.829Z","desc":"Flutter交互实战－即刻App探索页下拉＆拖拽效果","publishedAt":"2019-05-06T14:54:40.489Z","source":"web","type":"瞎推荐","url":"https://mp.weixin.qq.com/s/zjQG9DjayiF6df3y-SErCw","used":true,"who":"潇湘剑雨"},{"_id":"5cc5326d9d212239da9c6a9d","createdAt":"2019-05-04T16:17:52.774Z","desc":"5G到来，App的未来，是JavaScript，Flutter还是Native ？","publishedAt":"2019-05-04T16:17:57.548Z","source":"web","type":"瞎推荐","url":"https://mp.weixin.qq.com/s/bYsu_nkcTE6yQKmHe1DPsQ","used":true,"who":"lijinshanmx"},{"_id":"5cca4dd99d212239dd3b8fb4","createdAt":"2019-05-04T16:14:28.789Z","desc":"程序员过五一的最佳姿势","publishedAt":"2019-05-04T16:14:43.383Z","source":"web","type":"瞎推荐","url":"https://mp.weixin.qq.com/s/i6MJQA3M_MDU4QqRAIZXMA","used":true,"who":"lijinshanmx"},{"_id":"5cc6a09d9d212239da9c6aa1","createdAt":"2019-04-30T01:39:12.85Z","desc":"详见 GitHub ReadMe ^_^ ","publishedAt":"2019-04-30T01:39:33.430Z","source":"web","type":"瞎推荐","url":"https://github.com/KunMinX/RxJava2-Operators-Sample","used":true,"who":"潇湘剑雨"},{"_id":"5c774eee9d212233da370f41","createdAt":"2019-04-29T09:03:48.181Z","desc":"可以监控任何网页的任何区域的桌面（MacOS & Windows）App","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1g2jm79ymrcj30wt0oe47p"],"publishedAt":"2019-04-29T09:03:54.112Z","source":"web","type":"瞎推荐","url":"http://openwebmonitor.netqon.com","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5cf46c3a9d212203197e0f08
         * createdAt : 2019-06-03T10:09:11.787Z
         * desc : 码个蛋周刊 --- ARM发布新架构，国际计算机学术界封杀华为，王海峰升任百度CTO
         * publishedAt : 2019-06-03T10:12:26.220Z
         * source : web
         * type : 瞎推荐
         * url : https://mp.weixin.qq.com/s/ClkQRpP4K3pGYOy6aDsuNg
         * used : true
         * who : 潇湘剑雨
         * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1g2jm79ymrcj30wt0oe47p"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
