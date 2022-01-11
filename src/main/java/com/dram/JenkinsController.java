package com.dram;

import com.dram.dto.BaseMessage;
import com.dram.dto.CardMessage;
import com.dram.dto.CardMessageFactory;
import com.dram.dto.JenkinsBuildInfo;
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
 * Jenkins
 *
 * @author dragon
 * @date 2021/12/29
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("jenkins")
@Slf4j
public class JenkinsController {
    @Inject
    @RestClient
    FeishuService feishuService;


    @POST
    @Path("push")
    public String push(JenkinsBuildInfo jenkinsBuildInfo) {
        log.info(jenkinsBuildInfo.toString());
        String buildStatus = jenkinsBuildInfo.getBuildStatus();
        String titleColor = "blue";
        String titleEmoji = "";
        try {
            final int parseInt = Integer.parseInt(buildStatus);
            switch (parseInt) {
                case 1:
                    titleColor = "blue";
                    titleEmoji = "😐";
                    buildStatus = "构建开始";
                    break;
                case 2:
                    titleColor = "green";
                    titleEmoji = "\uD83D\uDE01";
                    buildStatus = "构建成功";
                    break;
                case 3:
                    titleColor = "red";
                    titleEmoji = "\uD83D\uDE35";
                    buildStatus = "构建失败";
                    break;
                default:
                    break;
            }
        } catch (Exception ignored) {
        }


        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("**作业：**").append(jenkinsBuildInfo.getJobName()).append("\n");
        stringBuilder.append("**构建人：**").append(jenkinsBuildInfo.getBuildUser()).append("\n");
        stringBuilder.append("**Git 分支：**").append(jenkinsBuildInfo.getGitBranch()).append("\n");
        stringBuilder.append("**Git 提交人：**").append(jenkinsBuildInfo.getGitCommitUser()).append("\n");
        stringBuilder.append("**Git Commit：**").append(jenkinsBuildInfo.getGitCommit()).append("\n");
        stringBuilder.append("**Git Message：**").append("\n").append(jenkinsBuildInfo.getGitCommitMessage());
        if (jenkinsBuildInfo.getExtra() != null) {
            stringBuilder.append("\n").append(jenkinsBuildInfo.getExtra());
        }
        //按钮
        final ArrayList<CardMessage.ElementsBean.ActionsBean> actionsBeans = new ArrayList<>();
        final CardMessage.ElementsBean.ActionsBean button = CardMessageFactory.createButton("\uD83D\uDD0D查看作业", jenkinsBuildInfo.getJobUrl());
        actionsBeans.add(button);

        final BaseMessage baseMessage = CardMessageFactory.createBaseMessage(titleColor, titleEmoji + buildStatus, stringBuilder.toString(), actionsBeans);


        log.info(baseMessage.toString());
        final String res = feishuService.send(baseMessage);
        log.info(res);
        return res;
    }


}
