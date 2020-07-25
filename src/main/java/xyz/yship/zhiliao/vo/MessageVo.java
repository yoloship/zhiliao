package xyz.yship.zhiliao.vo;

import lombok.Data;

@Data
public class MessageVo {
	private String email;
	private String content;
	private String author;
	private String isMe;
	private String avatarUrl;
}
