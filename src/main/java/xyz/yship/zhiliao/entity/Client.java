package xyz.yship.zhiliao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.websocket.Session;

@Data
@AllArgsConstructor
public class Client {
	private String email;
	private Session session;
}
