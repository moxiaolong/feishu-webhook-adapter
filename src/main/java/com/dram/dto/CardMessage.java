package com.dram.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CardMessage implements Serializable {


    /**
     * config : {"wide_screen_mode":true}
     * elements : [{"tag":"markdown","content":"普通文本\n标准emoji 😁😢🌞💼🏆❌✅\n*斜体*\n**粗体**\n~~删除线~~\n[文字链接](https://www.feishu.cn)\n[差异化跳转（桌面端和移动配置不同跳转链接）]($urlVal)\n<at id=all><\/at>"},{"actions":[{"tag":"button","text":{"content":"立即推荐好书","tag":"plain_text"},"type":"primary","url":"https://open.feishu.cn/"},{"tag":"button","text":{"content":"查看活动指南","tag":"plain_text"},"type":"default","url":"https://open.feishu.cn/"}],"tag":"action"}]
     * header : {"template":"turquoise","title":{"content":"📚晒挚爱好书，赢读书礼金","tag":"plain_text"}}
     */

    private ConfigBean config;
    private HeaderBean header;
    private List<ElementsBean> elements;

    @NoArgsConstructor
    @Data
    public static class ConfigBean implements Serializable {
        /**
         * wide_screen_mode : true
         */

        private Boolean wide_screen_mode;
    }

    @NoArgsConstructor
    @Data
    public static class HeaderBean implements Serializable {
        /**
         * template : turquoise
         * title : {"content":"📚晒挚爱好书，赢读书礼金","tag":"plain_text"}
         */

        private String template;
        private TitleBean title;

        @NoArgsConstructor
        @Data
        public static class TitleBean implements Serializable {
            /**
             * content : 📚晒挚爱好书，赢读书礼金
             * tag : plain_text
             */

            private String content;
            private String tag;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ElementsBean implements Serializable {
        /**
         * tag : markdown
         * content : 普通文本
         标准emoji 😁😢🌞💼🏆❌✅
         *斜体*
         **粗体**
         ~~删除线~~
         [文字链接](https://www.feishu.cn)
         [差异化跳转（桌面端和移动配置不同跳转链接）]($urlVal)
         <at id=all></at>
         * actions : [{"tag":"button","text":{"content":"立即推荐好书","tag":"plain_text"},"type":"primary","url":"https://open.feishu.cn/"},{"tag":"button","text":{"content":"查看活动指南","tag":"plain_text"},"type":"default","url":"https://open.feishu.cn/"}]
         */

        private String tag;
        private String content;
        private List<ActionsBean> actions;

        @NoArgsConstructor
        @Data
        public static class ActionsBean implements Serializable {
            /**
             * tag : button
             * text : {"content":"立即推荐好书","tag":"plain_text"}
             * type : primary
             * url : https://open.feishu.cn/
             */

            private String tag;
            private TextBean text;
            private String type;
            private String url;

            @NoArgsConstructor
            @Data
            public static class TextBean implements Serializable {
                /**
                 * content : 立即推荐好书
                 * tag : plain_text
                 */

                private String content;
                private String tag;
            }
        }
    }
}
