package com.dram;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

/**
 * webhook配置
 *
 * @author dragon
 * @date 2021/12/29
 */
@ConfigMapping(prefix = "webhook")
public interface WebhookConfig {

    /**
     * 飞书web hook 完整 url
     *
     *  https://open.feishu.cn/open-apis/bot/v2/hook/aaaaaaa-aaaa-aaaa-aaaa-aaaaaaaa
     *
     * @return {@link String}
     */
    @WithName("feishu.uri")
    String feishuUrl();

}