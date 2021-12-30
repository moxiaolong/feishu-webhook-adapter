package com.dram.dto;

import lombok.Data;

/**
 * 詹金斯构建信息
 *
 * @author dragon
 * @date 2021/12/29
 */
@Data
public class JenkinsBuildInfo {

    /**
     * 构建状态 1开始 2成功 3失败
     */
    private String buildStatus;
    /**
     * 作业名
     */
    private String jobName;
    /**
     * 构建用户
     */
    private String buildUser;
    /**
     * git分支
     */
    private String gitBranch;
    /**
     * git提交版本
     */
    private String gitCommit;
    /**
     * git提交用户
     */
    private String gitCommitUser;
    /**
     * git提交消息
     */
    private String gitCommitMessage;
    /**
     * 工作的url
     */
    private String jobUrl;
}
