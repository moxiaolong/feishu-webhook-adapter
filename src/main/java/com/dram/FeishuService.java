package com.dram;

import com.dram.dto.BaseMessage;
import com.dram.dto.CardMessage;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * 飞书服务
 *
 * @author dragon
 * @date 2021/12/29
 */
@RegisterRestClient(configKey = "feishu")
public interface FeishuService {

    /**
     * 发送
     *
     * @param baseMessage 基础信息
     * @return {@link String}
     */
    @POST
    @Path("/")
   String send(BaseMessage baseMessage);


}
