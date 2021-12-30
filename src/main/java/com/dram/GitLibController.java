package com.dram;

import com.dram.dto.BaseMessage;
import com.dram.dto.CardMessage;
import com.dram.dto.CardMessageFactory;
import com.dram.dto.GitLabPushEvent;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * GitLib
 *
 * @author dragon
 * @date 2021/12/29
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("gitlab")
@Slf4j
public class GitLibController {
    @Inject
    @RestClient
    FeishuService feishuService;
    /**
     * 推
     *
     * @param gitLabPushEvent git 推事件
     * @return {@link String}
     */
    @POST
    @Path("push")
    public String push(GitLabPushEvent gitLabPushEvent) {

        String titleColor = "grey";
        String titleEmoji = "\uD83D\uDE80";

        final GitLabPushEvent.ProjectBean project = gitLabPushEvent.getProject();
        final GitLabPushEvent.CommitsBean commitsBean = gitLabPushEvent.getCommits().get(0);


        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("**项目名：**").append(project.getName()).append("\n");
        stringBuilder.append("**Git 分支：**").append(project.getDefault_branch()).append("\n");
        stringBuilder.append("**Git 提交人：**").append(commitsBean.getAuthor().getName()).append("\n");
        stringBuilder.append("**Git Commit：**").append(commitsBean.getId()).append("\n");
        stringBuilder.append("**Git Message：**").append("\n").append(commitsBean.getMessage());

        //按钮
        final ArrayList<CardMessage.ElementsBean.ActionsBean> actionsBeans = new ArrayList<>();
        final CardMessage.ElementsBean.ActionsBean button = CardMessageFactory.createButton("\uD83D\uDD0D查看提交", commitsBean.getUrl());
        actionsBeans.add(button);

        final BaseMessage baseMessage = CardMessageFactory.createBaseMessage(titleColor, titleEmoji + "推送事件", stringBuilder.toString(), actionsBeans);

        log.info(baseMessage.toString());
        final String res = feishuService.send(baseMessage);
        log.info(res);
        return res;
    }


}
