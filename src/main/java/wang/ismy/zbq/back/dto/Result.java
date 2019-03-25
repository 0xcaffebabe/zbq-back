package wang.ismy.zbq.back.dto;

import lombok.Data;

@Data
public class Result {

    private boolean success;

    private String msg;

    private Object data;
}
