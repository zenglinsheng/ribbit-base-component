package com.bfxy.rabbit.producer.broker;

import java.util.List;

import com.bfxy.rabbit.api.Message;
import com.google.common.collect.Lists;

@SuppressWarnings("all")
public class MessageHolder {

	private List<Message> messages = Lists.newArrayList();
	
	public static final ThreadLocal<MessageHolder> holder = ThreadLocal.withInitial(
			() -> new MessageHolder()
	);
	
	public static void add(Message message) {
		holder.get().messages.add(message);
	}
	
	public static List<Message> clear() {
		List<Message> tmp = Lists.newArrayList(holder.get().messages);
		holder.remove();
		return tmp;
	}
	
}
