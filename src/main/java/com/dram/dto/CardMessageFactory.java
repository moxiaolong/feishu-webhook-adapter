package com.dram.dto;

import com.dram.dto.CardMessage.ConfigBean;
import com.dram.dto.CardMessage.ElementsBean;
import com.dram.dto.CardMessage.ElementsBean.ActionsBean;
import com.dram.dto.CardMessage.ElementsBean.ActionsBean.TextBean;
import com.dram.dto.CardMessage.HeaderBean;
import com.dram.dto.CardMessage.HeaderBean.TitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡信息工厂
 *
 * @author dragon
 * @date 2021/12/29
 */
public class CardMessageFactory {
    /**
     * 创建卡片
     *
     * @param color   颜色
     * @param title   标题
     * @param content 内容
     * @return {@link BaseMessage}
     */
    public static BaseMessage createBaseMessage(String color, String title, String content, List<ActionsBean> actions) {
        final BaseMessage baseMessage = new BaseMessage();
        baseMessage.setMsg_type("interactive");
        final CardMessage cardMessage = new CardMessage();
        baseMessage.setCard(cardMessage);
        final ConfigBean config = new ConfigBean();
        config.setWide_screen_mode(false);
        cardMessage.setConfig(config);
        final HeaderBean header = new HeaderBean();
        header.setTemplate(color);
        final TitleBean titleBean = new TitleBean();
        titleBean.setContent(title);
        titleBean.setTag("plain_text");
        header.setTitle(titleBean);
        cardMessage.setHeader(header);
        final ArrayList<ElementsBean> elements = new ArrayList<>();
        final ElementsBean elementsBean = new ElementsBean();
        elementsBean.setTag("markdown");
        elementsBean.setContent(content);
        elements.add(elementsBean);
        final ElementsBean button = new ElementsBean();
        button.setTag("action");
        button.setActions(actions);
        elements.add(button);

        cardMessage.setElements(elements);
        return baseMessage;
    }

    /**
     * 创建按钮
     *
     * @param text 文本
     * @param url  url
     * @return {@link ActionsBean}
     */
    public static ActionsBean createButton(String text, String url) {
        final ActionsBean actionsBean = new ActionsBean();
        actionsBean.setTag("button");
        final TextBean textBean = new TextBean();
        textBean.setContent(text);
        textBean.setTag("plain_text");
        actionsBean.setText(textBean);
        actionsBean.setType("default");
        actionsBean.setUrl(url);
        return actionsBean;
    }
}
