package xyz.yship.zhiliao.server;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.yship.zhiliao.entity.Client;
import xyz.yship.zhiliao.vo.MessageVo;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

;

@Component
@ServerEndpoint(value = "/chat/{myEmail}")
public class ChatWebSocketServer {
	private static final AtomicInteger OnlineCouunt = new AtomicInteger();
	private static ConcurrentHashMap<String,Session> concurrentHashMap = new ConcurrentHashMap<>();

	@Autowired
	private ObjectMapper objectMapper;

	@SneakyThrows
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "myEmail") String myEmail) {
		concurrentHashMap.put(myEmail,session);
	}

	@OnClose
	public void onClose(Session session, @PathParam(value = "myEmail") String myEmail) {
		concurrentHashMap.remove(myEmail);
	}

	@OnMessage
	public void onMessage(String message) throws IOException {

		String hisEmail = "";
		String newMessage = message.replace(" ", "").replace("{","").replace("}","").replace("\"","");
		String[] split = newMessage.split(",");
		for (String s : split) {
			String[] split1 = s.split(":");
			if (split1[0].equals("hisEmail")) {
				hisEmail = split1[1];
				break;
			}
		}
		Session session = concurrentHashMap.get(hisEmail);
		session.getBasicRemote().sendText(message);

	}

	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
	}

	public static void sendMessage(Session session, String message) {
		try {
			session.getBasicRemote().sendText("zzz");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
