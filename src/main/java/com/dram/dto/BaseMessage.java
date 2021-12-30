package com.dram.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基础信息
 *
 * @author dragon
 * @date 2021/12/29
 */
@NoArgsConstructor
@Data
public class BaseMessage implements Serializable {

    /**
     * chat_id : oc_abcdefg1234567890
     * msg_type : interactive
     * root_id : om_4ad8
     * card : {}
     */
    private String msg_type;
    private CardMessage card;

}
