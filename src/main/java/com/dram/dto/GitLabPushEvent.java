package com.dram.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * gitlab推动事件
 *
 * @author dragon
 * @date 2021/12/30
 */
@NoArgsConstructor
@Data
public class GitLabPushEvent implements Serializable {

    /**
     * object_kind : push
     * event_name : push
     * before : 95790bf891e76fee5e1747ab589903a6a1f80f22
     * after : da1560886d4f094c3e6c9ef40349f7d38b5d27d7
     * ref : refs/heads/master
     * checkout_sha : da1560886d4f094c3e6c9ef40349f7d38b5d27d7
     * message : Hello World
     * user_id : 4
     * user_name : John Smith
     * user_email : john@example.com
     * user_avatar : https://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=8://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=80
     * project_id : 15
     * project : {"id":15,"name":"gitlab","description":"","web_url":"http://test.example.com/gitlab/gitlab","avatar_url":"https://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=8://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=80","git_ssh_url":"git@test.example.com:gitlab/gitlab.git","git_http_url":"http://test.example.com/gitlab/gitlab.git","namespace":"gitlab","visibility_level":0,"path_with_namespace":"gitlab/gitlab","default_branch":"master"}
     * commits : [{"id":"c5feabde2d8cd023215af4d2ceeb7a64839fc428","message":"Add simple search to projects in public area\n\ncommit message body","title":"Add simple search to projects in public area","timestamp":"2013-05-13T18:18:08+00:00","url":"https://test.example.com/gitlab/gitlab/-/commit/c5feabde2d8cd023215af4d2ceeb7a64839fc428","author":{"name":"Test User","email":"test@example.com"}}]
     * total_commits_count : 1
     * push_options : {"ci":{"skip":true}}
     */

    private String object_kind;
    private String event_name;
    private String before;
    private String after;
    private String ref;
    private String checkout_sha;
    private String message;
    private Integer user_id;
    private String user_name;
    private String user_email;
    private String user_avatar;
    private Integer project_id;
    private ProjectBean project;
    private Integer total_commits_count;
    private PushOptionsBean push_options;
    private List<CommitsBean> commits;

    @NoArgsConstructor
    @Data
    public static class ProjectBean implements Serializable {
        /**
         * id : 15
         * name : gitlab
         * description :
         * web_url : http://test.example.com/gitlab/gitlab
         * avatar_url : https://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=8://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=80
         * git_ssh_url : git@test.example.com:gitlab/gitlab.git
         * git_http_url : http://test.example.com/gitlab/gitlab.git
         * namespace : gitlab
         * visibility_level : 0
         * path_with_namespace : gitlab/gitlab
         * default_branch : master
         */

        private Integer id;
        private String name;
        private String description;
        private String web_url;
        private String avatar_url;
        private String git_ssh_url;
        private String git_http_url;
        private String namespace;
        private Integer visibility_level;
        private String path_with_namespace;
        private String default_branch;
    }

    @NoArgsConstructor
    @Data
    public static class PushOptionsBean implements Serializable {
        /**
         * ci : {"skip":true}
         */

        private CiBean ci;

        @NoArgsConstructor
        @Data
        public static class CiBean implements Serializable {
            /**
             * skip : true
             */

            private Boolean skip;
        }
    }

    @NoArgsConstructor
    @Data
    public static class CommitsBean implements Serializable {
        /**
         * id : c5feabde2d8cd023215af4d2ceeb7a64839fc428
         * message : Add simple search to projects in public area

         commit message body
         * title : Add simple search to projects in public area
         * timestamp : 2013-05-13T18:18:08+00:00
         * url : https://test.example.com/gitlab/gitlab/-/commit/c5feabde2d8cd023215af4d2ceeb7a64839fc428
         * author : {"name":"Test User","email":"test@example.com"}
         */

        private String id;
        private String message;
        private String title;
        private String timestamp;
        private String url;
        private AuthorBean author;

        @NoArgsConstructor
        @Data
        public static class AuthorBean implements Serializable {
            /**
             * name : Test User
             * email : test@example.com
             */

            private String name;
            private String email;
        }
    }
}
